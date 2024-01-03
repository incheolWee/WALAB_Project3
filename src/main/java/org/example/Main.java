package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Main {

    public static void main(String [] args) {
        CRUD m = new CRUD();
        System.out.println("--------------프로그램을 시작합니다--------------");
        boolean check = true;

        while(check) {
            try{
                m.printMenu();
                BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));
                String input = sbr.readLine();
                check = m.menuChoose(input);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
