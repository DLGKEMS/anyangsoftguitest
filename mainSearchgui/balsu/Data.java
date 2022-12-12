package mainSearchgui.balsu;
public class Data {
    int barcode;
    int product_name;
    int count;
    int price;
    int mainclass;


    public Data() {
    }

    public Data(int barcode, int product_name, int count,
                int price, int mainclass) {
        this.barcode = barcode;
        this.product_name = product_name;
        this.count = count;
        this.price = price;
        this.mainclass = mainclass;
    }

    public int getBarcode() {
        return barcode;
    }
    public void setbarcode(int barcode) {
        this.barcode = barcode;
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