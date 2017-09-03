package in.co.mtspl.dr.momentous;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by amreshkumar on 28/08/17.
 */

public class filteredProductActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private filteredProductAdapter fpAdapter;
    private Button placeOrderBtn;

    public static final String JSON_URL = "http://192.168.1.4:8000/order/?format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_filteredproduct);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        placeOrderBtn = (Button) findViewById(R.id.place_order);
        placeOrderBtn.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        fpAdapter = new filteredProductAdapter(ProductManager.singleton.products);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fpAdapter);
        recyclerView.setEnabled(false);

        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // true: consume touch event
                // false: dispatch touch event
                return true;
            }
        });

        fpAdapter.notifyDataSetChanged();
    }

    /*{
        "products": "1,2",
            "quantity": "",
            "retailer_id": null
    }*/

    private void sendRequest() {

        HashMap<String, Object> params = new HashMap<String, Object>();

        params.put("products", ProductManager.singleton.getCommaSeparatedProductIds());
        params.put("quantity", ProductManager.singleton.getCommaSeparatedProductQuantities());
        params.put("retailer_id", Integer.parseInt("123"));

        JsonObjectRequest req = new JsonObjectRequest(JSON_URL, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                            AlertDialog alertDialog = new AlertDialog.Builder(
                                    filteredProductActivity.this).create();
                            alertDialog.setTitle("SUCCESS");
                            alertDialog.setMessage("Your Order is Placed");
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);

                                }
                            });
                            alertDialog.show();

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                AlertDialog alertDialog = new AlertDialog.Builder(
                        filteredProductActivity.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Something went Wrong");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(req);
    }

    @Override
    public void onClick(View view) {
        if (view == placeOrderBtn) {

            sendRequest();
        }
    }
}
