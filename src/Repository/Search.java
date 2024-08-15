package Repository;

import Music.MusicList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Search {
    /**
     * categorization에 해당하는 노래 랜덤으로 뽑는 class
     */

    PreparedStatement prmst = null;
    Scanner scanner = new Scanner(System.in);
    MusicList list = new MusicList();

    public Search(Connect connect) {

        System.out.println("<음악 찾기>");
        System.out.println("| 1 : 신남 | 2 : 잔잔 |");
        System.out.print("추천받을 장르를 고르세요 : ");
        int number = Integer.parseInt(scanner.nextLine());  // categorization

        try {
            /**
             * select문에서 categorization에 맞는것만 출력
             */
            String sql = "SELECT author, name, description, categorization " +
                    "FROM musiclist " +
                    "WHERE categorization=? " +
                    "ORDER BY RAND() LIMIT 1";      // 이 코드로 인해 랜덤으로 1개 뽑아서 나옴.
            Connection conn = connect.getConnection();
            prmst = conn.prepareStatement(sql);
            prmst.setInt(1, number);

            ResultSet rs = prmst.executeQuery();

            if (rs.next()) {
                list.setAuthor(rs.getString("author"));
                list.setName(rs.getString("name"));
                list.setDescription(rs.getString("description"));
                list.setCategorization(rs.getInt("categorization"));
                System.out.println(list);
            }
            System.out.println();
            prmst.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
