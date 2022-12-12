package mainSearchgui.balsu;
public class WData {
    int barcode;
    int product_name;
    int count;
    int price;
    int mainclass;

    public WData() {
    }

    public WData(int wbarcode, int wproduct_name, int wcount,
                int wprice, int wmainclass) {
        this.barcode = wbarcode;
        this.product_name = wproduct_name;
        this.count = wcount;
        this.price = wprice;
        this.mainclass = wmainclass;
    }

    public int getBarcode() {
        return barcode;
    }
    public void setbarcode(int wbarcode) {
        this.barcode = wbarcode;
    }

    public int getProduct_name() {
        return product_name;
    }
    public void setTime_present(int product_name) {
        this.product_name = product_name;
    }

    public int getcount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getPricece() {
        return price;
    }
    public void setprice(int price) {
        this.price = price;
    }

    public int getMainclass() {
        return mainclass;
    }
    public void setMainclass(int mainclass) {
        this.mainclass = mainclass;
    }
}