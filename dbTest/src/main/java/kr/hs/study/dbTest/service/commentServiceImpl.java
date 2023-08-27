package kr.hs.study.dbTest.service;

import kr.hs.study.dbTest.dto.bookDTO;
import kr.hs.study.dbTest.dto.commentDTO;
import kr.hs.study.dbTest.mapper.bookMapper;
import kr.hs.study.dbTest.mapper.commentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentServiceImpl implements commentService{
    @Autowired
    private commentMapper mapper;

    @Override
    public bookDTO read(String id) {
        bookDTO book = mapper.read(id);
        return book;
    }

    @Override
    public void insert(commentDTO dto) {
        mapper.insert(dto);
    }

    @Override
    public List<commentDTO> readcomment(String book_id) {
        List<commentDTO> comments = mapper.readcomment(book_id);
        return comments;
    }

    @Override
    public commentDTO mycomment(Integer buser_id) {
        commentDTO count = mapper.mycomment(buser_id);
        return count;
    }

    @Override
    public List<commentDTO> mycomments(Integer buser_id) {
        List<commentDTO> dto = mapper.mycomments(buser_id);
        return dto;
    }

    @Override
    public void delete(Integer comment_id) {
        mapper.delete(comment_id);
    }

}
