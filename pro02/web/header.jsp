<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path2" value="<%=request.getContextPath() %>" />
<div class="hd_wrap">
    <nav class="tnb"> <!-- .hd_wrap:first-child  -->
        <ul class="menu">
            <c:if test="${!empty sid}">
            <li>안녕하세요,  ${sid}님</li> <!-- 로그인 한 회원의 이름 -->
            <li><a href="${path2}/Mypage.do">마이페이지</a></li>
            <li><a href="${path2}/Logout.do">로그아웃</a></li>
                <li><a href="${path2}/Cart.do">장바구니</a></li>
                <c:if test="${sid eq 'admin'}">
                <li><a href="${path2}/Manage.do">관리자페이지</a></li>
                </c:if>
            </c:if>
            <c:if test="${empty sid}">
            <li><a href="${path2}/Login.do">로그인</a></li>
            <li><a href="${path2}/Join.do">회원가입</a></li>
            </c:if>
        </ul>
    </nav>
</div>

<div class="hd_wrap"> <!-- .hd_wrap:first-child  -->
    <a href="/pro02" class="logo">
        <img src="./img/logo.png" alt="">
    </a>
    <nav class="gnb">
        <ul class="menu">
            <li class="item1">
                <a href="${path2}/ProList.do?cate=전체" class="dp1">전체 도서</a>
                <ul class="sub">
                    <li><a class="move" href="${path2}/ProList.do?cate=초등">초등 도서</a></li>
                    <li><a class="move" href="${path2}/ProList.do?cate=중등">중등 도서</a></li>
                    <li><a class="move" href="${path2}/ProList.do?cate=고등">고등 도서</a></li>
                </ul>
            </li>
            <%--
            <li class="item2">
                <a href="${path2}/ProList.do?cate=초등" class="dp1">초등</a>

                <ul class="sub">
                    <li><a class="move" href="/information_info/boardList.jsp">입시 정보</a></li>
                    <li><a class="move" href="/board_act/boardList.jsp">대외 활동 정보</a></li>
                    <li><a class="move" href="/file/boardList.jsp">자료실</a></li>
                </ul>
            </li>
            <li class="item3">
                <a href="${path2}/ProList.do?cate=중등" class="dp1">중등</a>

                <ul class="sub">
                    <li><a class="move" href="/qna_problem/qnaList.jsp">문제 QnA</a></li>
                    <li><a class="move" href="/qna_career/qnaList.jsp">진로 상담</a></li>
                </ul>
            </li>
            <li class="item4">
                <a href="${path2}/ProList.do?cate=고등" class="dp1">고등</a>

                <ul class="sub">
                    <li><a class="move" href="${path2}/NoticeList.do">공지사항</a></li>
                    <li><a class="move" href="${path2}/QnaList.do">QnA</a></li>
                </ul>
            </li> --%>
            <li class="item5">
            <a href="" class="dp1">고객센터</a>
            <ul class="sub">
                <li><a class="move" href="${path2}/NoticeList.do">공지사항</a></li>
                <li><a class="move" href="${path2}/QnaList.do">QnA</a></li>
            </ul>
        </li>
        </ul>
    </nav>
    <script src="/js/load.js"></script>
</div>