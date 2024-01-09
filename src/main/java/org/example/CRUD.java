package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CRUD {
BufferedReader br;
private List<Movie> list;
    public CRUD(){
        this.list = new ArrayList<>();
    }



    private void addData() {
        Movie m = new Movie();
        try{
            System.out.println("영화 제목을 입력하세요");
            br = new BufferedReader(new InputStreamReader(System.in));
            m.setName(br.readLine());
            System.out.println("영화 장르를 입력하세요 ex)드라마, 공포, 액션, 코미디");
            m.setGenre(br.readLine());
            System.out.println("영화 상영 시간을 입력하세요 ex)분으로만 입력");
            m.setRunningTime(Integer.parseInt(br.readLine()));
            System.out.println("누적 관객 수를 입력하세요 *단위는 만 입니다.*  M");
            m.setViewor(Integer.parseInt(br.readLine()));
            System.out.println("영화의 평점을 입력하세요 (10점 만점)");
            m.setRating_Point(Float.parseFloat(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        m.setNum(this.list.size());
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        m.setRegDate(regDate);

        this.list.add(m);
        System.out.println("추가되었습니다.");
    }

    private  void editData() {
        // Placeholder implementation
       if(this.list.isEmpty()){
           System.out.print("데이터가 존재하지 않습니다");
           return;
       }
       try{
           readData();
           System.out.println("수정할 번호 입력");
           br = new BufferedReader(new InputStreamReader(System.in));
           int num = Integer.parseInt(br.readLine()) -1;
           if(valid(num)){
               System.out.println("영화 제목을 입력하세요");
               br = new BufferedReader(new InputStreamReader(System.in));
               this.list.get(num).setName(br.readLine());
               System.out.println("영화 장르를 입력하세요 ex)드라마, 공포, 액션, 코미디");
               this.list.get(num).setGenre(br.readLine());
               System.out.println("영화 상영 시간을 입력하세요 ex)분으로만 입력");
               this.list.get(num).setRunningTime(Integer.parseInt(br.readLine()));
               System.out.println("누적 관객 수를 입력하세요 *단위는 만 입니다.*  M");
               this.list.get(num).setViewor(Integer.parseInt(br.readLine()));
               System.out.println("영화의 평점을 입력하세요 (10점 만점)");
               this.list.get(num).setRating_Point(Float.parseFloat(br.readLine()));
               LocalDate date = LocalDate.now();
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
               String regDate = date.format(formatter);
               this.list.get(num).setRegDate(regDate);
               System.out.println("수정 되었습니다!");
           }else{
               editData();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    private  void deleteData() {
        if(this.list.isEmpty()){
            System.out.println("데이터가 존재하지 않았습니다!");
            return;
        }
       try{
           readData();
           System.out.println("삭제할 영화 번호를 입력하세요");
           br = new BufferedReader(new InputStreamReader(System.in));
           int num = Integer.parseInt(br.readLine())-1;
           if(valid(num)) {
               this.list.remove(num);
               for (int i = 0; i < list.size(); i++) {
                   this.list.get(i).setNum(i);
               }
               System.out.println("삭제되었습니다.");
           }else{
               deleteData();
           }
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    private void readData() {
        if (list.isEmpty()) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        System.out.println("NO  영화제목        장르      상영시간    누적관객수      기록날자     영화평점");
        System.out.println("=========================================================================");
        for (Movie m : list) {
            System.out.println(m.toString());
        }
    }

    private void searchData() {
        if (this.list.isEmpty()) {
            System.out.println("데이터가 존재하지 않습니다");
            return;
        }
        br = new BufferedReader(new InputStreamReader(System.in));
        String type = null;
        try {
            System.out.println("1) 영화 이름 검색  2) 영화 장르 검색");
            type = br.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (type.equals("1")) {
            System.out.println("검색할 영화 제목을 입력하세요");

            try {
                String name = br.readLine();
                boolean check = false;
                for (Movie m : list) {
                    if (m.getName().contains(name)) {
                        if (!check) {
                            System.out.println("NO  영화제목        장르      상영시간    누적관객수      기록날자     영화평점");
                            System.out.println("=========================================================================");
                            check = true;
                        }
                        System.out.println(m.toString());
                    }
                }
                if (!check) {
                    System.out.println("검색 결과가 없습니다.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(type.equals("2")){
                System.out.println("검색할 영화 장르를 입력하세요");

                try {
                    String genre = br.readLine();
                    boolean check = false;
                    for (Movie m : list) {
                        if (m.getGenre().contains(genre)) {
                            if (!check) {
                                System.out.println("NO  영화제목        장르      상영시간    누적관객수      기록날자     영화평점");
                                System.out.println("=========================================================================");
                                check = true;
                            }
                            System.out.println(m.toString());
                        }
                    }
                    if (!check) {
                        System.out.println("검색 결과가 없습니다.");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
