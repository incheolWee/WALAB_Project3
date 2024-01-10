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


        int result = -1;
        Connection conn =SQLiteManager.getConnection();
        List<Map<String, Object>> resultList;

        Menu m = new Menu();
        CRUD crud = new CRUD();
        SearchService searchService = new SearchService();
        DDLService DDL = new DDLService(conn);
        DMLService DML = new DMLService(conn);
        DQLService DQL = new DQLService(conn);

        DDL.createTable();

        System.out.println("=======시작========");
        while(true){
            try{
                String choose = m.printMenu();
                switch (choose){
                    case "1":
                        result = DML.insertMovie(crud.addData());
                        if(result>=0){
                            System.out.println("추가되었습니다");
                        }else{
                            System.out.println("데이터 입력 실패");
                        }
                        break;

                    case "2":
                        crud.readData(DQL);
                        result = DML.updateMovie(crud.editData());
                        if(result >= 0){
                            System.out.println("수정되었습니다");
                        }else{
                            System.out.println("데이터 수정 실패");
                        }
                        break;
                    case "3":
                        crud.readData(DQL);
                        result = DML.deleteMovie(crud.deleteData());
                        if(result >= 0){
                            System.out.println("삭제되었습니다");
                        }else{
                            System.out.println("데이터 삭제 실패");
                        }
                        break;
                    case "4":
                        crud.readData(DQL);
                        break;
                    case "5":
                        resultList = DQL.selectByName(searchService.searchByName());
                        DQL.printMapList(resultList);
                        break;
                    case "0":
                        System.out.println("종료");
                        return ;
                    default:
                        System.out.println("잘못된 메뉴 선택");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}
