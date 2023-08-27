package kr.hs.study.dbTest.mapper;

import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.commentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface commentMapper {

    public bookDTO read(String id);

    public void insert(commentDTO dto);

    public List<commentDTO> readcomment(String book_id);

    public commentDTO mycomment(Integer buser_id);

    public List<commentDTO> mycomments(Integer buser_id);

    public void delete(Integer comment_id);
}
