package in.co.mtspl.dr.momentous;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by amreshkumar on 03/09/17.
 */

public class ParseJSON {
    public static String[] productId;
    public static String[] productName;
    public static String[] productPacking;
    public  static String[] productPrice;

    private JSONArray productsArray = null;


    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    public ArrayList<Product> parseJSON(){
        ArrayList<Product>productList= new ArrayList<>();
        JSONObject jsonObject=null;
        try {
            productsArray = new JSONArray(json);
            for(int i=0;i<productsArray.length();i++){
                JSONObject jo = productsArray.getJSONObject(i);
                Product product=new Product(jo);
                productList.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

