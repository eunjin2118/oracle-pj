package kr.hs.study.dbTest.service;


import kr.hs.study.dbTest.dto.buserDTO;

import javax.security.sasl.AuthenticationException;
import java.util.List;

public interface dbService {
    public void insert(buserDTO dto);

//    public buserDTO select(Integer buser_id);

    public buserDTO selectuser(Integer buser_id);

    public buserDTO authenticate(String email, String password) throws AuthenticationException;

    public void update(buserDTO dto);

    public List<buserDTO> selectall();

    public void deleteuser(Integer buser_id);

    public void updateadmin(Integer buser_id);


}
