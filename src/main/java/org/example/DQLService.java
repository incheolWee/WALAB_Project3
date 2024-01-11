package org.example;

import java.sql.*;
import java.util.*;

public class DQLService {
    final String SELECTALL_SQL = "SELECT * FROM movie";
    final String SELECTBYNAME_SQL = "SELECT * FROM movie WHERE NAME = ? ";
    final String SELECTBYGENRE_SQL = "SELECT * FROM movie WHERE genre = ?";

    Connection conn;
    PreparedStatement pstmt;
    ResultSetMetaData meta;

    public DQLService(Connection conn){
        this.conn = conn;
    }
    // 데이터 조회 함수
    public List<Map<String,Object>> selectAll(){
        final Set<String> columnNames = new HashSet<String>();
        final List<Map<String, Object>> selected = new ArrayList<Map<String,Object>>();
        try{
            pstmt= conn.prepareStatement(SELECTALL_SQL);
            //데이터 조회
            ResultSet rs = pstmt.executeQuery();
            // 조회된 데이터의 컬럼명 저장
            meta = pstmt.getMetaData();
            for(int i=1; i<= meta.getColumnCount(); i++){
                columnNames.add(meta.getColumnName(i));
            }
            Map<String , Object > resultMap = null;
            while(rs.next()){
                resultMap = new HashMap<String, Object>();
                for(String column : columnNames){
                    resultMap.put(column, rs.getObject(column));
                }
                if(resultMap != null){
                    selected.add(resultMap);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } finally  {
            try {
                // PreparedStatement 종료
                if( pstmt != null ) {
                    pstmt.close();
                }

            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
        //조회된 데이터 리스트
        return selected;
    }
    public List<Map<String, Object>>selectByName(String name){
        //조회 결과 변수
        final Set<String> columnNames = new HashSet<String>();
        final List<Map<String, Object>> selected = new ArrayList<Map<String, Object>>();
        try{
          //죄회 데이터 조건 매핑
            pstmt = conn.prepareStatement(SELECTBYNAME_SQL);
            pstmt.setObject(1,name);
            ResultSet rs = pstmt.executeQuery();
            meta= pstmt.getMetaData();
            for(int i =1; i<=meta.getColumnCount(); i++){
                columnNames.add(meta.getColumnName(i));
            }
            Map<String, Object> resultMap = null;
            while(rs.next()){
                resultMap = new HashMap<String, Object>();
                for(String column : columnNames){
                    resultMap.put(column, rs.getObject(column));
                }
                if(resultMap != null){
                    selected.add(resultMap);
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(pstmt != null){
                    pstmt.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return selected;
    }
    //조회 결고 출력 함수
    public void printMapList(List<Map<String,Object>> mapList){
        if(mapList.size() == 0){
            System.out.println("초회된 데이터가 없습니다.");
            return;
        }
        //상세 데이터 출력
        System.out.println("NO  영화제목        장르      상영시간    누적관객수      기록날자     영화평점");
        System.out.println("=========================================================================");
        for(int i=0; i<mapList.size(); i++){
            Map<String, Object> map = mapList.get(i);
            int num = Integer.parseInt(map.get("num").toString());
            String name = (String) map.get("name");
            String genre = (String) map.get("genre");
            int runningTime = Integer.parseInt(map.get("runningTime").toString());
            int viewor = Integer.parseInt(map.get("viewor").toString());
            String regDate = (String) map.get("regDate");
            double rating_Point = Double.parseDouble(map.get("rating_Point").toString());

           System.out.println( String.format("%2d",(num)) +"\t"
                    + String.format("%-7s",name) +"\t"+
                    String.format("%5s",genre) +"\t\t" +
                    String.format("%4d",runningTime)+"m" +"\t\t"+
                    String.format("%4d",viewor)+"M"+"\t\t"+
                    regDate+"\t\t"+
                    String.format("%.1f",rating_Point));
        }
    }


}
