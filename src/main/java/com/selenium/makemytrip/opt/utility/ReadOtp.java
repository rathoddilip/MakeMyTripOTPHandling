package com.selenium.makemytrip.opt.utility;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadOtp {
    public static final String ACCOUNT_SID = "AC63cf4beb3418d3017d50c12ac7fa846f";
    public static final String AUTH_TOKEN = "3dc6094c52302ff2efa8b3098d0d4f2b";

    public static String readOTP() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String smsBody = getMessage();
        System.out.println(smsBody);
        String[] oTPNumber = smsBody.split("[^\\d]+");
        String otp = oTPNumber[1];
        System.out.println(otp);

        return otp;
    }

    private static String getMessage() {
        return getMessages().filter(message -> message.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(message -> message.getTo().equals("+19854002437")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }
}
