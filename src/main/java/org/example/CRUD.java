package org.example;

import java.util.Scanner;

public class CRUD {
    static Scanner s = new Scanner(System.in);
    public static int addData() {
        System.out.println("<1> 동영상 추가");
        System.out.println("=======================");
        System.out.println("추가하고 싶은 영상의 이름을 입력하세요");
        String name = s.next();
        System.out.println("영상의 크리에이터를 입력하세요");
        String creator = s.next();
        System.out.println("영상의 좋아요 갯수를 입력하세요");
        int likes = s.nextInt();

        System.out.println("데이터가 추가되었습니다");
        return 1;
    }
    public static void searchData() {
    }

    public static void showData() {
    }

    public static void deleteData() {
    }

    public static void editData() {
    }


}
