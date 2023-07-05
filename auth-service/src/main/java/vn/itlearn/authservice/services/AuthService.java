package vn.itlearn.authservice.services;

import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.itlearn.authservice.entities.AuthRequest;
import vn.itlearn.authservice.entities.AuthResponse;
import vn.itlearn.authservice.entities.UserVO;

@Service
public class AuthService {


    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(RestTemplate restTemplate, final JwtUtil jwtUtil) {
        this.restTemplate = restTemplate;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse register(AuthRequest authRequest) {
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));
        UserVO userVo = restTemplate.postForObject("http://user-service/users", authRequest, UserVO.class);
        Assert.notNull(userVo, "Failed to register user. Please try again later");

        String accessToken = jwtUtil.generate(userVo, "ACCESS");
        String refreshToken = jwtUtil.generate(userVo, "REFRESH");
        return new AuthResponse(accessToken, refreshToken);
    }
}
