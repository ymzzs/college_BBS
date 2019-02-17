package muzhou.com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnectionUtil {

	private static DataSource dataSource = null;
	private static ThreadLocal<Connection> threadLocal = null;
	static {
		dataSource = new ComboPooledDataSource();
		threadLocal = new ThreadLocal<Connection>();
	}

    /**
     * 
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
    	Connection connection = threadLocal.get();
        if (connection == null) {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            threadLocal.set(connection);
        }
        return connection;
    }



    /**
     * 
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) {
        
    	try{
    		if (connection != null) {
            connection.commit();
            threadLocal.remove();
            connection.close();
    		}
        }catch(SQLException ex) {
        	ex.printStackTrace();
        }
    }

    /**
     * 
     * @throws SQLException
     */
    public static void rollback(Connection connection) {
    	try {
    		if (connection != null) {
				connection.rollback();
			} 
        }catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    }
}
