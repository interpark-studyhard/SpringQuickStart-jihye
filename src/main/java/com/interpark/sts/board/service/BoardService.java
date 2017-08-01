package com.interpark.sts.board.service;

import com.interpark.sts.board.BoardVO;

import java.util.List;

/**
 * Created by 최지혜 on 2017-07-31.
 */
public interface BoardService {
    // implements CRUD

    // write
    void insertBoard(BoardVO vo);

    // update
    void updateBoard(BoardVO vo);

    // delete
    void deleteBoard(BoardVO vo);

    // get board detail
    BoardVO getBoard(BoardVO vo);

    // get board list
    List<BoardVO> getBoardList(BoardVO vo);
}
