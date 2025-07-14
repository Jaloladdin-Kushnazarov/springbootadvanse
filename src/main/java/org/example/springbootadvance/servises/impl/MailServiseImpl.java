package org.example.springbootadvance.servises.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.servises.CacheServise;
import org.example.springbootadvance.servises.MailServise;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class MailServiseImpl implements MailServise {

    private final CacheServise cacheServise;
    private boolean on = false;

    public MailServiseImpl(CacheServise cacheServise) {
        this.cacheServise = cacheServise;
    }

    @Override
    public void sendVerificationMail(Map<Object, Object> model) {
        if (on) {
            log.info("Connect SMTP server");
            log.info("Send verification mail");
        }else {
            log.info("CACHING MAIL MODEL {}," , model);
            cacheServise.put(model);
        }
    }

    @Override
    public Boolean turnOnOffSMTPServer() {
        this.on = !on;
        return this.on;
    }

    public Boolean isSMTPActive() {
        return on;
    }
}
