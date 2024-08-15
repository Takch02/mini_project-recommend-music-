import Repository.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Connect connect = new Connect();
        int result;
        do {
            System.out.println("****************************************************************");
            System.out.println("<노래 추천 시스템>");
            System.out.println("| 1. 노래 추가 | 2. 노래 삭제 | 3. 노래 추천 | 4. 전체 리스트 | 5. 종료");
            System.out.println("****************************************************************\n");
            System.out.print("메뉴를 선택하세요 : ");
            result = Integer.parseInt(scanner.nextLine());

            System.out.println();

            switch (result) {

                case 1:
                    Create create = new Create(connect);
                    break;
                case 2 :
                    Delete delete = new Delete(connect);
                    break;
                case 3:
                    Search search = new Search(connect);
                    break;
                case 4:
                    SearchAll searchAll = new SearchAll(connect);
                    break;
            }

        } while (result != 5);


        System.out.println("프로그램 종료");
        scanner.close();
    }
}
