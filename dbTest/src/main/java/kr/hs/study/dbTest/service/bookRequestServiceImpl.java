package kr.hs.study.dbTest.service;

import kr.hs.study.dbTest.dto.bookRequestDTO;
import kr.hs.study.dbTest.mapper.bookRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookRequestServiceImpl implements bookRequestService{
    @Autowired
    private bookRequestMapper mapper;

    @Override
    public void insert(bookRequestDTO dto) {
        mapper.insert(dto);
    }
}
