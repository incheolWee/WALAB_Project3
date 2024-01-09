package org.example;

import java.sql.*;


public class DDLService {
    final String TABLE_NAME = "movie";
    final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +" (  "
            + " num INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " name TEXT NOT NULL,"
            + " genre TEXT NOT NULL,"
            + " runningTime INTEGER NOT NULL,"
            + "viewor INTEGER NOT NULL,"
            + "regDate TEXT NOT NULL,"
            + "rating_Point REAL NOT NULL )";
    Connection conn;
    public DDLService(Connection conn){
        this.conn = conn;
    }
    public boolean executeSQL (final String SQL) throws SQLException{
        Statement stmt = null;
        boolean result = false;
        try {
            stmt = conn.createStatement();
            stmt.execute(SQL);
            conn.commit();
            result = true;
        }catch(SQLException e) {
            System.out.println(e.getMessage());
            if(conn != null){
                conn.rollback();
            }
            result= false;
        }finally {
            if(stmt!=null){
                try{
                    stmt.close();
                }catch (SQLException e ){
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }

    // 테이블 생성 함수
    public boolean createTable() throws SQLException {
        // SQL 실행 및 반환
        return executeSQL(CREATE_SQL);
    }
}
