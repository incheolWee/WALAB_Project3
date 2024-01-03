package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Movie> list = new ArrayList<>();
   Scanner s = new Scanner(System.in);

    public void main(String[] args) {
        int input;
        boolean repeat = true;

        while (repeat) {
            showMenu();
            input = s.nextInt();
            switch (input) {
                case 1:
                    addData();
                    break;
                case 2:
                    editData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4:
                    readData();
                    break;
                case 5:
                    searchData();
                    break;
                case 6:
                    topRanking();
                    break;
                case 0:
                    repeat = false;
                    break;

                default:
                    System.out.println("잘못된 입력 입니다.");
                    break;
            }
        }
        System.out.println("프로그램이 종료 되었습니다!");
    }



    private void addData() {

    }

    private  void editData() {
        // Placeholder implementation
        System.out.println("영상 수정 기능은 아직 구현되지 않았습니다.");
    }

    private  void deleteData() {
        // Placeholder implementation
        System.out.println("영상 삭제 기능은 아직 구현되지 않았습니다.");
    }

    private void readData() {
        if (list.isEmpty()) {
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        for (Movie m : list) {
            System.out.println(m.toString());
        }
    }

    private static void searchData() {
        // Placeholder implementation
        System.out.println("영상 검색 기능은 아직 구현되지 않았습니다.");
    }

    private void topRanking() {
    }

    private static void showMenu() {
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
}
