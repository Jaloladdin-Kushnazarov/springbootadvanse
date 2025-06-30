package org.example.springbootadvance.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.example.springbootadvance.entity.Users;


@Getter
@ToString
@RequiredArgsConstructor
public final class OtpGenerateEvent  {
    private final Users user;
}
