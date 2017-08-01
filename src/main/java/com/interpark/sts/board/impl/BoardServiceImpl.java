package com.interpark.sts.board.impl;

import com.interpark.sts.board.dao.BoardDAO;
import com.interpark.sts.board.service.BoardService;
import com.interpark.sts.board.vo.BoardVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 최지혜 on 2017-07-31.
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);
    @Autowired
    private BoardDAO boardDAO;

    public BoardServiceImpl() {
        LOGGER.info("=== board service impl === ");
    }

    @Override
    public void insertBoard(BoardVO vo) {
        boardDAO.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }
}
