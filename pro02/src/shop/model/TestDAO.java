package shop.model;

import shop.dto.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    public Test getTest(int no) {
        Test t = new Test();
        DBConnect con = new MariaDBCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement("select * from test1 where no=?");
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                t.setNo(rs.getInt("no"));
                t.setName(rs.getString("name"));
                t.setPoint(rs.getInt("point"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
