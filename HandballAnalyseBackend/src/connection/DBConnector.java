package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector implements AutoCloseable{

    private final String DB_URL ="jdbc:mysql://localhost:3306/";

    private String DB_USER = "newuser";

    private String DB_PASS = "password";

    private Connection connection;

    public DBConnector(){

    }
    
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
    }

    /**
     *
     * @return
     */
    public boolean insert(){
        return false;
    }


    @Override
    public void close() throws Exception {
        if(!this.connection.isClosed()){
            this.connection.close();
        }
    }
}
