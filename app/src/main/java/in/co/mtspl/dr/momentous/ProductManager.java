package in.co.mtspl.dr.momentous;

import java.util.ArrayList;

/**
 * Created by amreshkumar on 29/08/17.
 */

public class ProductManager {

    static ProductManager singleton = new ProductManager();
    ArrayList<Product> products = new ArrayList<Product>();
}
