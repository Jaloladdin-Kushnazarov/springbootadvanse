package org.example.springbootadvance.listeners;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.entity.Users;
import org.example.springbootadvance.event.OtpGenerateEvent;
import org.example.springbootadvance.event.SendMailEvent;
import org.example.springbootadvance.repository.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserEventListener {

    private final UserRepository userRepository;

    //    @TransactionalEventListener (phase = TransactionPhase.AFTER_COMMIT, condition = "#event.user.email ne null")
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @EventListener({OtpGenerateEvent.class})
    @Async
    @Order(1)
    public CompletableFuture<SendMailEvent> generateOtpEventListener(OtpGenerateEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        Users user = event.getUser();
        user.setOtp(UUID.randomUUID().toString());
        log.info("Generate OTP with: {}", event.getUser());
        userRepository.save(user);
//        throw new RuntimeException("OTP generation failed");
        return CompletableFuture.completedFuture(new SendMailEvent(user.getEmail(), user.getOtp()));
    }


    @EventListener({SendMailEvent.class})
    @Async
    @Order(2)
    public void eventVertificationMailSenderListener(OtpGenerateEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        log.info("User verification mail sender: {}", event);
    }

}
