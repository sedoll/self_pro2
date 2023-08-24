package shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DBConnect {
    // region notice
    final static String NOTICE_SELECT_ALL = "select * from notice";
    final static String NOTICE_SELECT_ONE = "select * from notice where no=?";
    final static String NOTICE_INSERT = "insert into notice values (default,?,?,default,default)";
    final static String NOTICE_UPDATE = "update notice set title=?, content=? where no=?";
    final static String NOTICE_UPDATE_CNT = "update notice set visited=visited+1 where no=?";
    final static String NOTICE_DELETE = "delete from notice where no=?";
    // endregion

    // region customer
    final static String CUSTOM_SELECT_ALL = "select * from custom order by regdate desc";
    final static String CUSTOM_SELECT_ONE = "select * from custom where id=?";
    final static String CUSTOM_INSERT = "insert into custom values(?, ?, ?, default, default, ?, ?, ?, default, ?)";
    final static String CUSTOM_UPDATE = "update custom set title=?, content=? where id=?";
    final static String CUSTOM_DELETE = "delete from custom where id=?";
    final static String CUSTOM_SELECT_LOG = "select * from custom where id=? and pw=?";
    // endregion
    
    // region file
    final static String FILE_SELECT_ALL = "select * from file";
    final static String FILE_INSERT = "insert into file values (?,?,?,?)";
    final static String FILE_DELETE = "DELETE FROM file where fname = ?";
    // endregion

    // region shop

    // product
    final static String PRODUCT_UPDATE_prono = "UPDATE product SET cateno = CONCAT(cate, NO) WHERE NO=?";
    final static String PRODUCT_UPDATE = ""; // 상품정보수정
    final static String PRODUCT_SELECT_ALL = "SELECT * FROM product ORDER BY NO"; // 상품 조회
    final static String PRODUCT_SELECT_CATE = "SELECT * FROM product where cate=? ORDER BY NO";
    final static String PRODUCT_SELECT_ONE = "SELECT * FROM product where no=?"; // 상품 상세 조회
    final static String PRODUCT_SELECT_RECENT = "SELECT * FROM product ORDER BY NO DESC LIMIT 5"; // 최근 상품 조회
    final static String PRODUCT_SELECT_BEST = "SELECT * from product where pno IN (SELECT pno FROM payment GROUP BY pno ORDER BY SUM(amount) DESC LIMIT 5)"; // 제일 잘나가는 상품 조회
    final static String PRODUCT_DELETE = "delete from product where no=?";


    // qna
    final static String QNA_SELECT_ALL = "select * from qna where lev=0 order by resdate desc";
    final static String QNA_SELECT_BOARD = "select * from qna where par=? and lev=0";
    final static String QNA_SELECT_COMMENTS = "select * from qna where par=? and lev=1 order by resdate desc";
    final static String QNA_SELECT_COMMENT = "select * from qna where qno=? and lev=1";
    final static String QNA_INSERT_BOARD = "INSERT INTO qna(title, content, cid, par) VALUES(?, ?, ?, ?)";
    final static String QNA_INSERT_COMMENT = "INSERT INTO qna(title, content, cid, lev, par) VALUES(?, ?, ?, ?, ?)";
    final static String QNA_UPDATE_PAR = "update qna set par=qno where par=0 and lev=0";
    final static String QNA_UPDATE_CNT = "update qna set cnt=cnt+1 where qno=?";
    final static String QNA_UPDATE = "update qna set title=?, content=? where qno=?";
    final static String QNA_DELETE = "delete from qna where qno=?";

    // receive
    final static String RECEIVE_INSERT = "INSERT INTO receive VALUES(DEFAULT, ?, ?, ?, DEFAULT)";


    // serve
    final static String SERVE_INSERT = "INSERT INTO serve VALUES(DEFAULT, ?, ?, ?, DEFAULT)";


    //delivery
    final static String DELIVERY_INSERT = "INSERT INTO delivery VALUES(DEFAULT, ?, ?, ?, ?, '', '', DEFAULT, DEFAULT, '', )";


    //cart
    final static String CART_DELETE = "DELETE FROM cart WHERE NO=?";

    //review
    final static String REVIEW_SELECT = "select * from review where par=?";
    final static String REVIEW_INSERT = "insert into review values(default, ?, ?, default, ?)";
    
    
    //입고처리패턴
    final static String PRODUCT_INSERT = "INSERT INTO product VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', DEFAULT)";
    final static String CATEGORY_LOAD = "SELECT * FROM CATEGORY";


    //반품처리
    final static String RETURN_PAYMENT = "DELETE FROM payment WHERE sno=?";
    final static String RETURN_RECEIVE = "INSERT INTO receive VALUES(DEFAULT, ?, ?, ?, DEFAULT)";
    final static String RETURN_SERVE = "DELETE FROM serve WHERE sno=?";
    final static String RETURN_CART = "INSERT INTO cart VALUES(DEFAULT, ?, ?, ?)"; // 장바구니 복귀
    final static String RETURN_DELIVERY = "DELETE FROM delivery WHERE sno=?";


    // 배송처리
    // 출발
    final static String DELIVERY_START = "UPDATE delivery SET pcom=?, ptel=?, pstate=1, sdate=CURRENT_TIMESTAMP, rdate=?, bcode=? WHERE dno=?";
    // 도착
    final static String DELIVERY_END = "UPDATE delivery SET pcom=?, ptel=?, pstate=2, sdate=CURRENT_TIMESTAMP, rdate=?, bcode=? WHERE dno=?";
    // endregion

    public Connection connect();
    public void close(PreparedStatement pstmt, Connection conn);
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn);
}
