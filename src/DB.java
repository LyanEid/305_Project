package org.example;



import java.sql.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 class DB<T> {
    private String url = "jdbc:postgresql://db.rqmohzkdbsvuazdmzjkj.supabase.co:5432/postgres";
    private String user = "postgres";
    private String password = "305ProjectAirline";
    private static Statement stmt;
    private static Connection conn;
    private static ResultSet rs;
    private static boolean flag = false ;
    private static DB db;



    public DB() {
     init();
    }

    private void init() {


            try {
                conn = DriverManager.getConnection(url, user, password);
                stmt = conn.createStatement();
                conn.close();
                flag = true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static DB getInstance() {
        if(!flag) {
           DB db = new DB();
        }
        return db;
        }



    public static void Add (Object o) throws SQLException {
            String Add = " INSERT INTO Users ("+((User) o).getEmail()+", "+((User) o).getF_name()+", "+((User) o).getL_name()+", "+((User) o).getPassportNumber()+")";
            stmt.executeUpdate(Add);

    }
    public static ResultSet retrive (String query) throws SQLException {
        rs = stmt.executeQuery(query);
        return rs;
    }
    public static void update (String update) throws SQLException {
       stmt.executeUpdate(update);
    }
}