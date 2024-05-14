package com.example.My.service.skills.excepiton;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request")
public class SkillNotFound extends RuntimeException{
    
}
