package kr.hs.study.dbTest.mapper;

import kr.hs.study.dbTest.dto.buserDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@Mapper
public interface dbMapper {
    public void insert(buserDTO dto);

    public buserDTO findByEmail(String eamil);

    public buserDTO select(Integer buser_id);

    public void update(buserDTO dto);
}
