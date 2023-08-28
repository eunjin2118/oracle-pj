package kr.hs.study.dbTest.mapper;

import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.bookRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface bookRequestMapper {

    public void insert(bookRequestDTO dto);

    public List<bookRequestDTO> select();

    public void insertbook(bookDTO dto);

    public void deleterequestbook(String request_title, String request_author);
}
