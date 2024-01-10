package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchService {
BufferedReader br;
    public String searchByName() {
        String name = null;
        String type = null;
        System.out.println("검색할 이름 입력");
        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("1) 영화 이름 검색  2) 영화 장르 검색");
            type = br.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (type.equals("1")) {
            System.out.println("검색할 영화 제목을 입력하세요");

            try {
              name = br.readLine();
                }catch (IOException e) {
                e.printStackTrace();
            }
        }else if(type.equals("2")){
            System.out.println("검색할 영화 장르를 입력하세요");
            try {
                name = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return name;
    }
}
