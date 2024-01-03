package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class CRUD {
BufferedReader br;
private List<Movie> list;
    public CRUD(){
        this.list = new ArrayList<>();
    }
    public void printMenu() {
        System.out.println("=============[ 보고 싶은 영화 ] ==========");
        System.out.println("1. 영화 추가");
        System.out.println("2. 영화 수정");
        System.out.println("3. 영화 삭제");
        System.out.println("4. 영화 리스트 보기");
        System.out.println("5. 영화 검색");
        System.out.println("6. 영화 별점 순위");
        System.out.println("0. 프로그램 종료");
        System.out.println("====================================");
    }
    public boolean menuChoose(String input){
        switch (input) {
                case "1":
                    addData();
                    break;
                case "2":
                    editData();
                    break;
                case "3":
                    deleteData();
                    break;
                case "4":
                    readData();
                    break;
                case "5":
                    searchData();
                    break;
                case "6":
                    topRanking();
                    break;
                case "0":
                    System.out.println("프로그램을 종료 합니다!");
                    return false;
                default:
                    System.out.println("잘못된 입력 입니다.");
            }
       return true;
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
        System.out.println("NO  영화제목    장르  상영시간    누적관객수   기록날자    영화평점");
        System.out.println("=============================================================");
        for (Movie m : list) {
            System.out.println(m.toString());
        }
    }

    private void searchData() {
        if( this.list.isEmpty()){
            System.out.println("데이터가 존재하지 않습니다");
            return;
        }
        System.out.println("검색할 영화를 입력하세요");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = br.readLine();
            boolean check = false;
            for (Movie m : list) {
                if (m.getName().contains(name)) {
                    if (!check) {
                        System.out.println("NO  영화제목    장르  상영시간    누적관객수   기록날자    영화평점");
                        System.out.println("=============================================================");
                        check = true;
                    }
                    System.out.println(m.toString());
                }
            }
            if(!check){
                System.out.println("검색 결과가 없습니다.");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void topRanking() {

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
