package org.example.springbootadvance.listeners;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.entity.Users;
import org.example.springbootadvance.event.OtpGenerateEvent;
import org.example.springbootadvance.event.SendMailEvent;
import org.example.springbootadvance.repository.UserRepository;
import org.example.springbootadvance.servises.MailServise;
import org.example.springbootadvance.servises.OtpServise;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEventListener {

    private final OtpServise otpServise;
    private final MailServise mailServise;


    //    @TransactionalEventListener (phase = TransactionPhase.AFTER_COMMIT, condition = "#event.user.email ne null")
    //    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @EventListener({OtpGenerateEvent.class})
    @Async
    @Order(1)
    public CompletableFuture<SendMailEvent> generateOtpEventListener(OtpGenerateEvent event) throws InterruptedException {
        Users user = event.getUser();
        otpServise.otpGenerate(user);
        log.info("Generate OTP: {}", user);
        return CompletableFuture.completedFuture(new SendMailEvent(user.getId(), user.getEmail(), user.getOtp()));
    }


    @EventListener({SendMailEvent.class})
    @Async
    @Order(2)
    public void eventVertificationMailSenderListener(SendMailEvent event) throws InterruptedException {
        Map<Object, Object> model = Map.of(
                "id", event.getId(),
                "email", event.getEmail(),
                "otp", event.getOtp()
        );
        mailServise.sendVerificationMail(model );
    }

}
