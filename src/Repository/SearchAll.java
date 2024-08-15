package Repository;

import Music.MusicList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchAll {

    PreparedStatement prmst = null;
    Scanner scanner = new Scanner(System.in);
    MusicList list = new MusicList();

    public SearchAll(Connect connect) {

        System.out.println("<전체 음악 셋 리스트>");

        try {

            String sql = "SELECT author, name, description, categorization " +
                    "FROM musiclist";
            Connection conn = connect.getConnection();
            prmst = conn.prepareStatement(sql);

            ResultSet rs = prmst.executeQuery();
            /**
             * rs.next() 가 false가 나올 때 까지 계속 출력
             */
            while (rs.next()) {
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
