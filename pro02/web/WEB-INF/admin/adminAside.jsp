<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path3" value="<%=request.getContextPath() %>" />
<aside class="side-bar">
    <section class="side-bar__icon-box">
        <section class="side-bar__icon-1">
            <div></div>
            <div></div>
            <div></div>
        </section>
    </section>
    <ul>
        <li>
            <a href="#">배송관리</a>
            <ul>
                <li><a href="${path3}/AdminDeliveryList.do?pstate=0">출고처리</a></li>
                <li><a href="${path3}/AdminDeliveryList.do?pstate=1">배송중</a></li>
                <li><a href="${path3}/AdminDeliveryList.do?pstate=2">배송완료</a></li>
                <li><a href="${path3}/AdminDeliveryList.do?pstate=3">구매완료</a></li>
            </ul>
        </li>
    </ul>
</aside>
