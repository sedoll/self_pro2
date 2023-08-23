package shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    // 결제 처리
    public int addPayment() {
        return 0;
    }

    //가장 마지막에 추가된 결제 정보 sno
}
