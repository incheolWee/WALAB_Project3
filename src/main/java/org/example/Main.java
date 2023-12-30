package org.example;

import org.example.data;
import static org.example.CRUD.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;



public class Main {
    public static void main(String[] args) {
        int input = 0;
        int count =0;
        boolean repeat = true;
        ArrayList list = new ArrayList();
        while(repeat){
            showMenu();
            input = s.nextInt();
            switch (input){
                case 1:
                    addData();
                    break;
                case 2:
                    editData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4 :
                    showData();
                    break;
                case 5 :
                    searchData();
                    break;
                case 0:
                    repeat=false;
                    break;
                default:
                    System.out.println("잘못된 입력 입니다");
                    break;
            }

        }
        System.out.println("프로그램이 종료되었습니다!");
    }



    public static void showMenu() {
        System.out.println("=============[ 보고 싶은 너튜브 ] ==========");
        System.out.println("1. 영상 추가");
        System.out.println("2. 영상 수정");
        System.out.println("3. 영상 삭제");
        System.out.println("4. 영상 전체 보기");
        System.out.println("5. 영상 검색");
        System.out.println("0. 프로그램 종료");
        System.out.println("====================================");
        }
}