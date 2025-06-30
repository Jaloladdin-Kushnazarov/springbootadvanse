package org.example.springbootadvance.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class SendMailEvent {

    private final String email;
    private final String otp;
}
