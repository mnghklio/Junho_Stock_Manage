package com.github.mnghklio.web.service;

import com.github.mnghklio.web.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService{

    private final UserRepository userRepository;

}
