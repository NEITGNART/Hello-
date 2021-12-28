package DataAccess;

import java.sql.*;

public class DAO {

    public static String USERNAME;
    public static String PASSWORD;
    public static String URL;

    private static DAO db;
    private Connection conn;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;


    private DAO() {
        getConn();
    }

    public static  void setAttribute(String URL_, String userName, String password) {
        USERNAME = userName;
        PASSWORD = password;
        URL = URL_;
    }


    public static DAO getDbUtil() {
        if (db == null) {
            db = new DAO();
        }
        return db;
    }

    public int executeUpdate(String sql) {
        int result = -1;
        if (getConn() == null) {
            return result;
        }
        try {
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int executeUpdate(String sql, Object[] obj) {
        int result = -1;
        if (getConn() == null) {
            return result;
        }
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            result = ps.executeUpdate();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public ResultSet executeQuery(String sql) {
        if (getConn() == null) {
            return null;
        }
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet executeQuery(String sql, Object[] obj) {
        if (getConn() == null) {
            return null;
        }
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }


    public boolean execute(String sql) {
        if (getConn() == null) {
            return false;
        }
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("jdbc driver is not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
