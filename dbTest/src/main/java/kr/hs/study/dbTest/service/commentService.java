package kr.hs.study.dbTest.service;


import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.commentDTO;

import java.util.List;

public interface commentService {

    public bookDTO read(String id);

    public void insert(commentDTO dto);

    public List<commentDTO> readcomment(String book_id);

    public commentDTO mycomment(Integer buser_id);

    public List<commentDTO> mycomments(Integer buser_id);

    public void delete(Integer comment_id);

}
