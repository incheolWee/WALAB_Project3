package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DMLService {

    final String INSERT_SQL = "INSERT INTO movie (name, genre, running_Time, viewor, regDate, ratiing_Point) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE movie SET name = ? , genre = ?, running_Time= ? , viewor= ? , regDate= ? , ratiing_Point= ? WHERE num = ?";
    final String DELETE_SQL = "DELETE FROM movie WHERE num = ? ";

    Connection conn;
    PreparedStatement pstmt;

    public DMLService(Connection conn) {
        this.conn = conn;
    }

    public int insertMovie(HashMap<String, Object> dataMap) throws SQLException {
        int inserted = 0;
        try {
            // PreparedStatement 생성
            pstmt = conn.prepareStatement(INSERT_SQL);
            pstmt.setObject(1, dataMap.get("name"));
            pstmt.setObject(2, dataMap.get("genre"));
            pstmt.setObject(3, dataMap.get("running_Time"));
            pstmt.setObject(4, dataMap.get("viewor"));
            pstmt.setObject(5, dataMap.get("regDate"));
            pstmt.setObject(6, dataMap.get("ratiing_Point"));

            pstmt.executeUpdate();

            inserted = pstmt.getUpdateCount();

            conn.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            inserted = -1;
            if (conn != null) {
                conn.rollback();
            }
        }
        return inserted;
    }

    public int updateMovie(Map<String, Object> updateMap) throws SQLException {
        int updated = 0;
        try {
            pstmt = conn.prepareStatement(UPDATE_SQL);
            pstmt.setObject(1, updateMap.get("name"));
            pstmt.setObject(2, updateMap.get("genre"));
            pstmt.setObject(3, updateMap.get("runningTime"));
            pstmt.setObject(4, updateMap.get("viewor"));
            pstmt.setObject(5, updateMap.get("regDate"));
            pstmt.setObject(6, updateMap.get("rating_Point"));
            pstmt.executeUpdate();

            updated = pstmt.getUpdateCount();
            conn.commit();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            updated = -1;
            conn.rollback();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return updated;
    }

    public int deletePerson(int num) throws SQLException {
        int deleted = 0;
        try {
            pstmt = conn.prepareStatement(DELETE_SQL);
            pstmt.setObject(1, num);
            pstmt.executeUpdate();
            deleted = pstmt.getUpdateCount();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            deleted = -1;
            conn.commit();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return deleted;
    }
}