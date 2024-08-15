package Repository;

import Music.MusicList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Create {

    Scanner scanner = new Scanner(System.in);
    MusicList list = new MusicList();

    public Create(Connect connect) {

        PreparedStatement prmst_1 = null;
        PreparedStatement prmst_2 = null;

        System.out.println("*************************");
        System.out.println("< 음악 추가 >");
        System.out.println("*************************");

        System.out.print("가수 이름 : ");
        list.setAuthor(scanner.nextLine());
        System.out.print("노래 제목 : ");
        list.setName(scanner.nextLine().trim());
        /**
         * 제목칸은 공란이면 안되므로 공란이 아닐때 까지 계속 입력을 받음.
         */
        while (list.getName().isEmpty()) {
            System.out.println("제목칸이 공란입니다.");
            System.out.print("노래 제목 : ");
            list.setName(scanner.nextLine().trim());
        }
        System.out.print("노래 설명(필수 X) : ");
        list.setDescription(scanner.nextLine());
        System.out.print("노래 분류 (1 : 신남, 2: 잔잔) : ");
        list.setCategorization(Integer.parseInt(scanner.nextLine()));

        try {
            Connection conn = connect.getConnection();

            String sel = "SELECT author, name, description, categorization " +
                    "FROM musiclist " +
                    "WHERE name=?";
            prmst_2 = conn.prepareStatement(sel);
            prmst_2.setString(1, list.getName());
            ResultSet rs = prmst_2.executeQuery();

            /**
             * Select 문으로 입력받은 노래 제목이 테이블에 존재하는지 조사한다. 만약 있으면 종료함.
             */
            if (rs.next()) {
                System.out.println("이미 존재하는 노래입니다.");
                return;
            }

            String sql = "INSERT INTO musiclist (author, name, description, categorization) VALUES(?, ?, ?, ?)";
            prmst_1 = conn.prepareStatement(sql);

            prmst_1.setString(1, list.getAuthor());
            prmst_1.setString(2, list.getName());
            prmst_1.setString(3, list.getDescription());
            prmst_1.setInt(4, list.getCategorization());

            int row = prmst_1.executeUpdate();
            if (row > 0) {
                System.out.println("음악이 성공적으로 저장됐습니다.");
            }
            else {
                System.out.println("음악 저장에 실패했습니다.");
            }
            prmst_1.close();
            prmst_2.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        }

    }


