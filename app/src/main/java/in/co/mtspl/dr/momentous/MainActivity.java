package in.co.mtspl.dr.momentous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Product> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductAdapter pAdapter;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        submitButton=(Button)findViewById(R.id.submit);
        submitButton.setOnClickListener(this);
        pAdapter = new ProductAdapter(productList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        prepareProductData();
    }

    public void onClick(View v)
    {
        if (v == submitButton)
        {
            ArrayList<Product> filteredProdArray= new ArrayList<Product>();
            for(int i=0;i<productList.size();i++)
            {
                if(productList.get(i).productQuantity>0)
                {
                    filteredProdArray.add(productList.get(i));
                }
            }
            ProductManager.singleton.products = filteredProdArray;
            Intent intent = new Intent(MainActivity.this, filteredProductActivity.class);
            startActivity(intent);
        }

    }

    private void prepareProductData() {
        Product product = new Product("Algic Eyedrop", "5 ml", 20);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);
        product = new Product("Cap_Sr cap", "10 ml", 200);
        productList.add(product);

        pAdapter.notifyDataSetChanged();

    }
}
