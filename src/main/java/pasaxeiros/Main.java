package pasaxeiros;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<String> reservaArrayList=new ArrayList<>();
    static String[] arrayLine=null;
    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = Conexion();

        lerReservas();


        conn.close();
    }

    public static void lerReservas() throws IOException {
        BufferedReader leer=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/java/pasaxeiros/reservas.txt"));
        String oneLine;

        while ((oneLine=leer.readLine())!=null){
            String[] split = oneLine.split(",");
            String s = split[0];


        }
//        for (String x:reservaArray) {
//            System.out.println(x);
//        }

    }

    public static void exe(Connection connection)throws IOException, ClassNotFoundException{
        ResultSet rs = null;


        try {

            rs = connection.createStatement().executeQuery("select codp,graxa, peso from componentes right JOIN composicion ON componentes.codc = composicion.codc where codp='"+"';");
            while(rs.next()){

                rs.getString(1);
                rs.getInt(2);
                rs.getInt(3);

            }



            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static Connection Conexion(){
        Connection conn;
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "dam2a";
        String password = "castelao";
        String url = driver + host+ porto + "/" + sid;
        try {
            conn = DriverManager.getConnection(url,usuario,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}