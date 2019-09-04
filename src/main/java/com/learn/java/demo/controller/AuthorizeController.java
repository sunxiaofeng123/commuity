package com.learn.java.demo.controller;

import com.learn.java.demo.dto.AccessTokenDTO;
import com.learn.java.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state") String state)
    {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Iv1.d9d5fdd646e76f54");
        accessTokenDTO.setClient_secret("9790993886b85f83f7ad82c91a20ebfcff85ab83");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
