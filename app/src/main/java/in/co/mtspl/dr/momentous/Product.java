package in.co.mtspl.dr.momentous;

/**
 * Created by amreshkumar on 27/08/17.
 */

public class Product {

    private int productId;
    private int productCode;
    private String productName;
    private String productPacking;
    private int productPrice;
    private int offerId;
    private boolean isActive;
    int productQuantity;

    public Product() {

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
    public Product(String productName, String productPacking, int productPrice) {
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
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
