package in.co.mtspl.dr.momentous;

import android.text.TextUtils;

import java.util.ArrayList;

/**
 * Created by amreshkumar on 29/08/17.
 */

public class ProductManager {

    static ProductManager singleton = new ProductManager();
    ArrayList<Product> products = new ArrayList<Product>();

    public String getCommaSeparatedProductIds() {
        ArrayList<String> productIds = new ArrayList<>();
        for (Product product : products)
            productIds.add(String.valueOf(product.getProductId()));

        return TextUtils.join(",", productIds);
    }
    public String getCommaSeparatedProductQuantities() {
        ArrayList<String> productQuantities = new ArrayList<>();
        for (Product product : products)
            productQuantities.add(String.valueOf(product.productQuantity));

        return TextUtils.join(",", productQuantities);
    }
}
