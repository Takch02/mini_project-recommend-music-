package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

    Scanner scanner = new Scanner(System.in);
    PreparedStatement prmst = null;
    String result;

    public Delete(Connect connect) {

        System.out.println("<노래 삭제하기>");
        System.out.print("삭제할 노래를 입력하세요 : ");

        result = scanner.nextLine();

        try {
            String sql = "DELETE FROM musiclist WHERE name=?";
            Connection conn = connect.getConnection();
            prmst = conn.prepareStatement(sql);
            prmst.setString(1, result);

            int row = prmst.executeUpdate();
            if (row > 0) {
                System.out.println("노래가 성공적으로 삭제됐습니다.");
            }
            else {
                System.out.println("해당하는 노래가 없습니다.");
            }
            prmst.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
