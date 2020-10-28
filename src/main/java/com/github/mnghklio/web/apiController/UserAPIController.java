package com.github.mnghklio.web.apiController;

import com.github.mnghklio.web.dto.UserDto;
import com.github.mnghklio.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserAPIController {

    private final UserService userService;

    @PostMapping("/login")
    public Long login (@RequestBody UserDto userDto) {

        return 0L;
    }
}


//todo: Spring Security 다시 작성할것.