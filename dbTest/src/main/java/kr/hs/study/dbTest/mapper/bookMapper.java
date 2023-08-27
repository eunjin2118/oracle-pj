package kr.hs.study.dbTest.mapper;

import kr.hs.study.dbTest.dto.bookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface bookMapper {

    public List<bookDTO> select();

    public List<bookDTO> read();

    public List<bookDTO> search(String searchtext);

}
