package mainSearchgui.balsu;
import java.sql.*;
import java.util.ArrayList;

public class makecon {
        static Connection conn = null;
        static Statement stmt = null;
        static ResultSet rs = null;
        static  ResultSetMetaData rsmd = null;
        static PreparedStatement ps = null;
        static String url = "jdbc:mysql://localhost:3306/mydb";
        static String userName = "root";
        static String password = "1379";
    public makecon() {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        //Connection conn = null;
        public static void getConnection () {
            try {
                conn = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                stmt = conn.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public static void dbClose(){
        try{
            if(rs !=null)
                rs.close();
            if(stmt !=null)
                stmt.close();
            if(ps != null)
                ps.close();
        }catch(Exception e){
            System.out.println("tlqkf");
        }
    }

    public static void moveW(String mybarcode, String mycount){
        getConnection();
        System.out.println("mmmmmmmmmmm\n"+mybarcode);
        System.out.println("mmmmmmmmmmm\n"+mycount);
        try{
            String sql = "insert into warehousing select stock.* from stock where barcode like "+mybarcode+"";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql = "update warehousing set count="+mycount+" where barcode like "+mybarcode+"";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void insertData(Data data){
        getConnection();
        try {
            String sql = "INSERT INTO stock(bacode, product_name, count, price," +
                    " mainclass) values(?, ?,?,?,?)";
            // PrparedStatment?????? ??????, ????????? sql?????? ?????????
            ps = conn.prepareStatement(sql);
            ps.setInt(1, data.barcode);
            ps.setInt(2, data.product_name);
            ps.setInt(3, data.count);
            ps.setInt(4, data.price);
            ps.setInt(5, data.mainclass);
             // ????????? ??????
            // executeUpdate : insert, delete, update??? ?????? ?????? ???????????? ?????? ????????? ??????
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
    }
    public static String[][] deleteData(String delbarcode) {
        getConnection();
        try {
            String sql = "DELETE FROM warehousing WHERE barcode='"+delbarcode+"'";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ArrayList<String[]> arr = new ArrayList<>();
            while (rs.next()) {
                arr.add(new String[]{rs.getString(1),
                        rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            String[][] list = new String[arr.size()][6];
            return arr.toArray(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] alldeleteData() {
        getConnection();
        try {
            String sql = "DELETE FROM warehousing";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ArrayList<String[]> arr = new ArrayList<>();
            while (rs.next()) {
                arr.add(new String[]{rs.getString(1),
                        rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            String[][] list = new String[arr.size()][6];
            return arr.toArray(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] InquireData(){
        try {
            getConnection();
            String sql = "SELECT * FROM warehousing ";
            rs = stmt.executeQuery(sql);
            ArrayList<String[]> arr = new ArrayList<>();
            while (rs.next()) {
                arr.add(new String[]{rs.getString(1),
                        rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            String[][] list = new String[arr.size()][6];
            return arr.toArray(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(Data data) {
        getConnection();
        try {
            String sql = "UPDATE stock SET count=? WHERE barcode=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, data.barcode);
            ps.setInt(2, data.count);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
    }


    public static String[][] searchData(String x, String y){
        try {
            getConnection();
            String sql = "SELECT * FROM stock WHERE product_name LIKE '%"+x+"%' " +
                    "and mainclass like '%"+y+"%'";
            rs = stmt.executeQuery(sql);
            ArrayList<String[]> arr = new ArrayList<>();
            while (rs.next()) {
                arr.add(new String[]{rs.getString(1),
                        rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            String[][] list = new String[arr.size()][6];
            return arr.toArray(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[][] readData() {
        getConnection();
        try {
            // ???????????? db??? ??????, ????????? ????????? ??????
            String sql = "SELECT * FROM stock";
            //rs:ResultSet??? ????????? ???????????? ?????? ?????? ???????????????.
            rs = stmt.executeQuery(sql);
            ArrayList<String[]> arr = new ArrayList<>();
            System.out.println(arr);
            // ?????? ???????????? ??????
            while (rs.next()) {
                arr.add(new String[]{rs.getString(1),
                        rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                });
            }
            System.out.println(arr);
            String[][] list = new String[arr.size()][6];
            return arr.toArray(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }

/////////////////////////////////
    /*
    public static int[][] readData() {
        ArrayList<int[]> arr = new ArrayList<int[]>();
        System.out.println(arr);
        try {
            // ???????????? db??? ??????, ????????? ????????? ??????
            //stmt = conn.createStatement();

            String sql = "SELECT * FROM cash";
            //rs:ResultSet??? ????????? ???????????? ?????? ?????? ???????????????.
            rs = stmt.executeQuery(sql);

            // ?????? ???????????? ??????
            while (rs.next()) {
                arr.add(new int[]{rs.getInt(1),
                        rs.getInt(2)
                        , rs.getInt(3)
                        , rs.getInt(4)
                        , rs.getInt(5)
                        , rs.getInt(6)
                        , rs.getInt(7)
                });
            }
            int[][] list = new int[arr.size()][7];
            return arr.toArray(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbClose();
        }
    }

    */
    //////////////////////////
            /*String qu2 = "select * from cash";
            rs = stmt.executeQuery(qu2);
                while(rs.next()){
                        c_arry[index].barcode = rs.getInt(1);
                        c_arry[index].time_present = rs.getInt(2);
                        c_arry[index].opreating_reserve = rs.getInt(3);
                        c_arry[index].total_cash = rs.getInt(4);
                        c_arry[index].difference = rs.getInt(5);
                        c_arry[index].expenditure = rs.getInt(6);
                        c_arry[index].net_profit = rs.getInt(7);

                        index++;
                    }
                System.out.println("barcode \t time_present \t opreating_reserve \t");
                for (int i=0;i<c_arry.length;i++){
                    System.out.print(c_arry[i].barcode+"\t");
                    System.out.print(c_arry[i].time_present+"\t");
                    System.out.print(c_arry[i].opreating_reserve+"\t");
                    System.out.print(c_arry[i].total_cash+"\t");
                    System.out.print(c_arry[i].difference+"\t");
                    System.out.print(c_arry[i].expenditure+"\t");
                    System.out.println(c_arry[i].net_profit);
                    //System.out.println();
                }*/
}

////String quer1 = "INSERT INTO cash VALUES (5,3,4,5,6,7,8)";
//    //stmt.executeUpdate(quer1);

//String qu = "DELETE FROM cash WHERE barcode ='1'";
//stmt.executeUpdate(qu);
