package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
BufferedReader br;
    public String printMenu() throws IOException {
        System.out.println("=============[ 보고 싶은 영화 ] ==========");
        System.out.println("1. 영화 추가");
        System.out.println("2. 영화 수정");
        System.out.println("3. 영화 삭제");
        System.out.println("4. 영화 리스트 보기");
        System.out.println("5. 영화 검색");
        System.out.println("6. 영화 별점 순위");
        System.out.println("0. 프로그램 종료");
        System.out.println("=========================================");

        br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
