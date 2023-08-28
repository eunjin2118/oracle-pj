package kr.hs.study.dbTest.service;

import kr.hs.study.dbTest.dto.buserDTO;
import kr.hs.study.dbTest.mapper.dbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;

import java.util.List;

@Service
public class dbServiceImpl implements dbService{
    @Autowired
    private dbMapper mapper;

    @Override
    public void insert(buserDTO dto) {
        System.out.println("admin@admin.com".equalsIgnoreCase(dto.getEmail()));

        // 이름이 "admin"일 경우 "admin" 역할 설정
        if ("admin@admin.com".equalsIgnoreCase(dto.getEmail())) {
            dto.setRole("admin");
        } else {
            dto.setRole("user");
        }
        mapper.insert(dto);
    }

    @Override
    public buserDTO selectuser(Integer buser_id) {
        buserDTO dto = mapper.selectuser(buser_id);
        return dto;
    }

//    @Override
//    public buserDTO select(Integer buser_id) {
//        buserDTO user = mapper.select(buser_id);
//        return user;
//    }

    @Override
    public buserDTO authenticate(String email, String password) throws AuthenticationException {
        buserDTO user = mapper.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }

    @Override
    public void update(buserDTO dto) {
        mapper.update(dto);
    }


}
