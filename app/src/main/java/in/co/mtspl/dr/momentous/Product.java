package in.co.mtspl.dr.momentous;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by amreshkumar on 27/08/17.
 */

public class Product {

    private int productId;
    private int productCode;
    private String productName;
    private String productPacking;
    private String productPrice;
    private int offerId;
    private boolean isActive;
    int productQuantity;

    public Product(JSONObject jo) throws JSONException {

        this.productId=jo.getInt("product_id");
        this.productName=jo.getString("product_name");
        this.productPacking = jo.getString("product_packing");
        this.productPrice = jo.getString("product_price");
        this.productQuantity = 0;
    }

  /*  public Product(int productId, int productCode, String productName, String productPacking, int productPrice, int offerId, boolean isActive) {

        this.productId = productId;

        this.productCode = productCode;
        this.productName = productName;
        this.productPacking = productPacking;
        this.productPrice = productPrice;
        this.offerId = offerId;
        this.isActive = isActive;
    }*/
    public Product(String productName, String productPacking, String productPrice) {
        this.productName=productName;
        this.productPacking = productPacking;
        this.productPrice = productPrice;
        this.productQuantity = 0;

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPacking() {
        return productPacking;
    }

    public void setProductPacking(String productPacking) {
        this.productPacking = productPacking;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDistributerId() {
        return distributerId;
    }

    public void setDistributerId(int distributerId) {
        this.distributerId = distributerId;
    }

    private int distributerId;


}
