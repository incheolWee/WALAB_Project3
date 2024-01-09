package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteManager {
    private static final String SQLITE_JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String SQLITE_FILE_DB_URL = "jdbc:sqlite:movie.db";

    private static final boolean OPT_AUTO_COMMIT = false ;
    private static final int OPT_VALID_TIMEOUT = 500;

    private static Connection conn = null;

    //DB 연결 함수
    static Connection createConnection() {
        try {
            Class.forName(SQLITE_JDBC_DRIVER);
            conn = DriverManager.getConnection(SQLITE_FILE_DB_URL);
            conn.setAutoCommit(OPT_AUTO_COMMIT);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //DB 연결 종료 함수
    static void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            conn = null;
        }
    }
    //DB연결  객체 가져오기
}
