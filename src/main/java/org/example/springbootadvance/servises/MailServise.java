package org.example.springbootadvance.servises;

import java.util.Map;

public interface MailServise {
    void sendVerificationMail(Map<Object, Object> model);

    Boolean turnOnOffSMTPServer();
     Boolean isSMTPActive();
}
