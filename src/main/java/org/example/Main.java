package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;



public class Main {

    public static void main(String [] args) throws SQLException {
        CRUD m = new CRUD();
        Menu menu = new Menu();
        System.out.println("--------------프로그램을 시작합니다--------------");
        int result = -1;
        Connection conn = SQLiteManager.getConnection();

        boolean check = true;

        while(check) {
            try{
                menu.printMenu();
                BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));
                String input = sbr.readLine();
                check = m.menuChoose(input);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
