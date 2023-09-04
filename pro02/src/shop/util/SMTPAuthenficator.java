//package com.chunjae.util;
//
//import com.chunjae.data.Email;
//
//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
//
//// 사용할 메일과 비밀번호 설정 가능
//// lib에 넣는 경우 동작에 문제는 없지만 인텔리제이 상에서 빨간 줄이 뜬다.
//public class SMTPAuthenficator extends Authenticator {
//    @Override
//    protected PasswordAuthentication getPasswordAuthentication() {
//        return new PasswordAuthentication(Email.ID, Email.PW);
//    }
//}
