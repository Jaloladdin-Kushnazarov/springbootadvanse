package org.example.springbootadvance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.servises.CacheServise;
import org.example.springbootadvance.servises.MailServise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringbootadvanceApplication {

    private final CacheServise cacheServise;
    private final MailServise mailServise;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadvanceApplication.class, args);
    }


    @Scheduled (initialDelay = 5, fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    public void sendCachedVerificationMails() {
        if (mailServise.isSMTPActive()) {
            ConcurrentHashMap<Object, Map<Object, Object>> cache = cacheServise.getCache();
            cache.forEach((key, value) -> {
                mailServise.sendVerificationMail(value);
                cache.remove(key);
            });
        } else {
            log.info("SMTP Server is turned off ");
        }

    }

}



