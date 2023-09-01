<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/head.jsp"%> <%-- head 영역 호출 --%>
    <!-- 플러그인 연결-->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

    <!-- 스타일 초기화 : reset.css 또는 normalize.css -->
    <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" rel="stylesheet">
    <!-- 웹 폰트 -->
    <link rel="stylesheet" href="${path}/css/font.css">

    <!-- css 모듈화 -->
    <link rel="stylesheet" href="${path}/css/common.css">
    <link rel="stylesheet" href="${path}/css/hd.css">
    <link rel="stylesheet" href="${path}/css/ft.css">
    <link rel="stylesheet" href="${path}/css/change_img.css">
    <link rel="stylesheet" href="${path}/css/slidebox.css">

    <style>
        .img_box li.item1 .bg_box { background-image: url("${path}/img/006.png");}
        .img_box li.item2 .bg_box { background-image: url("${path}/img/008.png");}

        .page {clear: both; width: 100vw; height: 100vh; position: relative;}
        .page::after {content: ""; display: block; width: 100vw; clear: both;}
        .page_wrap { clear: both; width: 1200px; height: auto; margin: 0 auto;}
        .page_tit {font-size: 48px; text-align: center; padding-top: 50px; padding-top: 0.5em;}

        #page2 {height: 400px; background-color: #f5f9fe; background-position: 15vw 75vh;
            background-repeat: no-repeat; padding-top: 100px;}

        .pic_lst {clear: both; width: 1200px; margin: 150px auto;}
        .pic_lst li {width: 280px; height: 400px; margin-left: 26px; float: left; background-repeat: no-repeat;
            background-position: center center; background-size: cover; filter: blur(1px) brightness(80%); box-shadow: 12px 12px 12px #999;}
        .pic_lst li a { display: block; width: 256px; height: 376px; margin: 11px;}
        .pic_lst li a:hover {border: 1px solid #fff; transition: 0.3s;}
        .pic_lst li:first-child {margin-left: 0;} /* 안쪽에만 마진이 있으므로 테두리 부분의 마진 제거*/
        pic_lst li.item1 { background-image: url("${path}/img/img_social_main01.jpg");}
        .pic_lst li.item2 { background-image: url("${path}/img/img_social_main02.jpg");}
        .pic_lst li.item3 { background-image: url("${path}/img/img_social_main03.jpg");}
        .pic_lst li.item4 { background-image: url("${path}/img/img_social_main04.jpg");}
        .pic_lst li:hover { margin-top: -20px; transition: 0.5s; filter: brightness(105%); } /*호버 후 움직여서 밝기*/
        .pic_com {padding-left: 20px; padding-top: 20px; font-size: 14px;}
        .pic_tit {padding-left: 20px; padding-top: 20px; font-size: 18px;}
        .pic_arrow {display: block; width: 110px; height: 10px; border-bottom: 1px solid white; margin-left: -20px; margin-top: 20px;
            transition: 0.4s; position: relative;}
        .pic_lst li:hover .pic_arrow {margin-left: 20px;}
        .pic_arrow::after {content: ""; width: 10px; height: 10px; position: absolute; right: 0; top: 0; border-bottom: 1px solid white;
            display: block; clear: both; transform-origin: 100% 100%; transform: rotate(45deg); display: none;} /* 화살표 생성 */
        .pic_lst li:hover .pic_arrow::after {display: block;} /*처음엔 안보였다가 호버하면 화살표 생성 */


        .card_lst li.item2 .thumb_box {background-image: url("${path}/img/t1.jpg");}
        .card_lst li.item3 .thumb_box {background-image: url("${path}/img/t2.jpg");}
        .card_lst li.item4 .thumb_box {background-image: url("${path}/img/t3.jpg");}
        .card_lst li.item5 .thumb_box {background-image: url("${path}/img/t4.jpg");}
        .card_lst li.item6 .thumb_box {background-image: url("${path}/img/t5.jpg");}
        .card_lst li.item7 .thumb_box {background-image: url("${path}/img/t6.jpg");}


        .ico.item1 {background-position: -70px -60px;} /*네이버 블로그 아이콘*/
        .ico.item2 {background-position: -140px -120px;} /*인스타 그램 아이콘*/




        /*중간*/
        .board_tit {font-size: 38px; text-align: center;
            padding-top: 50px;
            padding-top: 0.5em;
            margin-bottom: 20px}

        .latest_board{
            width:1000px;
            margin: 0 auto;
        }
        .leftcontent {
            width: 500px;
            height: 700px;
            float: left;

        }
        .rightcontent {
            width: 500px;
            height: 700px;
            display: inline-block;

        }
        .rightcontent table{
            float: right;
        }
        .tb1 {
            font-size: 16px;
            width: 480px;
        }
        .tb1 th {
            font-weight: bold;
            background-color: #dae4f3;
            line-height: 40px;
            border-right: 1px solid white;

        }
        .tb1 td {
            line-height: 34px;
            border-bottom: 1px solid #d2d2d2;
        }
    </style>
</head>
<body>
<header class="hd" id="hd">
    <%@include file="/header.jsp"%>
</header>

<div class="contents">
    <figure class="vs">
        <ul class="img_box">
            <li class="item1 active">
                <input type="radio" name="vs_ra" id="vs_ra1" class="vs_ra" checked>
                <div class="bg_box"></div>
<%--                <h2 class="vs_tit">“나눔의 힘! 실천의 힘!”<br>--%>
<%--                    <strong>작은 따뜻함으로 세상을 <br>바꿉니다</strong>--%>
<%--                </h2>--%>
            </li>
            <li class="item2">
                <input type="radio" name="vs_ra" id="vs_ra2" class="vs_ra">
                <div class="bg_box"></div>
<%--                <h2 class="vs_tit">교육에 대한 끊임없는 도전<br>--%>
<%--                    <strong>행복한 내일을 함께 합니다</strong></h2>--%>
            </li>
        </ul>
        <ul class="btn_box">
            <li class="item1 active"><label for="vs_btn1" class="vs_btn"></label></li>
            <li class="item2"><label for="vs_btn2" class="vs_btn"></label></li>
        </ul>
        <button type="button" class="play_btn"></button>
    </figure>
    <script src="./js/rotation.js"></script>
</div>

<footer class="ft" id="ft">
    <%@include file="/footer.jsp"%>
</footer>
<a href="#" class="totop">위</a>
</body>
</html>
