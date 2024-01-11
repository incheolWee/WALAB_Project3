package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchService {
BufferedReader br;
    public String searchByName() {
        String name = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("검색할 영화 제목입력");

        try {
            name = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
    public String searchByGenre(){
        String genre = null;
        br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("검색할 영화 장르입력");
            try {
                genre = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return  genre;
    }


}

