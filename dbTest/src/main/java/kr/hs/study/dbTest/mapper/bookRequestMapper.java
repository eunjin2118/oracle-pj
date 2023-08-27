package kr.hs.study.dbTest.mapper;

import kr.hs.study.dbTest.dto.bookRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface bookRequestMapper {

    public void insert(bookRequestDTO dto);

}
