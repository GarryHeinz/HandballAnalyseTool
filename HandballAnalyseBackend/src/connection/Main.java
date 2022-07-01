package connection;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(DBConnector db = new DBConnector()){
            db.connect();
        }catch(Exception e){

        }

    }
}
