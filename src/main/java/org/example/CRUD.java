package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CRUD {
BufferedReader br;
private List<Movie> list;
    public CRUD(){
        this.list = new ArrayList<>();
    }



  public HashMap<String,Object> addData() {
        int num;
        String name;
        String genre;
        int runningTime;
        int viewor;
        String regDate;
        double rating_Point;

        final HashMap<String, Object> dataMap = new HashMap<String ,Object>();

        Movie m = new Movie();
        try{
            System.out.println("영화 제목을 입력하세요");
            br = new BufferedReader(new InputStreamReader(System.in));
            name =br.readLine();
            dataMap.put("name", name);
            System.out.println("영화 장르를 입력하세요 ex)드라마, 공포, 액션, 코미디");
            genre = br.readLine();
            dataMap.put("genre", genre);
            System.out.println("영화 상영 시간을 입력하세요 ex)분으로만 입력");
            runningTime=Integer.parseInt(br.readLine());
            dataMap.put("runningTime", runningTime);
            System.out.println("누적 관객 수를 입력하세요 *단위는 만 입니다.*  M");
            viewor=Integer.parseInt(br.readLine());
            dataMap.put("viewor", viewor);
            System.out.println("영화의 평점을 입력하세요 (10점 만점)");
            rating_Point = (Float.parseFloat(br.readLine()));
            dataMap.put("rating_Point",rating_Point);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        regDate = date.format(formatter);
        dataMap.put("regDate",regDate);
        return dataMap;
    }

   public HashMap<String, Object> editData() {
        // Placeholder implementation
       int num;
       String name;
       String genre;
       int runningTime;
       int viewor;
       String regDate;
       double rating_Point;

       final HashMap<String, Object>updateMap = new HashMap<String ,Object>();

       try{
           System.out.println("수정할 번호 입력");
           br = new BufferedReader(new InputStreamReader(System.in));
           num = Integer.parseInt(br.readLine());
           updateMap.put("updateID",num);

               System.out.println("영화 제목을 입력하세요");
               br = new BufferedReader(new InputStreamReader(System.in));
               name = (br.readLine());
               updateMap.put("name", name);
               System.out.println("영화 장르를 입력하세요 ex)드라마, 공포, 액션, 코미디");
               genre = (br.readLine());
               updateMap.put("genre", genre);
               System.out.println("영화 상영 시간을 입력하세요 ex)분으로만 입력");
               runningTime=(Integer.parseInt(br.readLine()));
               updateMap.put("runningTime",runningTime);
               System.out.println("누적 관객 수를 입력하세요 *단위는 만 입니다.*  M");
               viewor =(Integer.parseInt(br.readLine()));
               updateMap.put("viewor", viewor);
               System.out.println("영화의 평점을 입력하세요 (10점 만점)");
               rating_Point =(Float.parseFloat(br.readLine()));
               updateMap.put("rating_Point", rating_Point);
       } catch (IOException e) {
           e.printStackTrace();
       }
       LocalDate date = LocalDate.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       regDate = date.format(formatter);
       updateMap.put("regDate",regDate);

       return updateMap;
    }

    public int deleteData() {
        int num = 0;
        try {
            System.out.println("삭제할 번호 입력");
            br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return num;
    }

    public void readData(DQLService dql) {
     List<Map<String,Object>> resultList= dql.selectAll();
     dql.printMapList(resultList);
    }




    private void topRanking() {
        if (list.isEmpty()) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
      //평점으로 내림차순 정렬
        Collections.sort(list, Comparator.comparing(Movie::getRating_Point).reversed());

        System.out.println("NO  영화제목        장르      상영시간    누적관객수      기록날자     영화평점");
        System.out.println("=========================================================================");

        for (Movie m : list) {
            System.out.println(m.toString());
        }
        // num 으로 오름차순으로 정렬
        Collections.sort(list, Comparator.comparing(Movie::getNum));
    }

    private boolean valid(int num) {
        // 배열 범위
        if (this.list.size() <= num || num == -1) {
            System.out.println("없는 번호 입니다.");
            return false;
        }

        return true;
    }
}
