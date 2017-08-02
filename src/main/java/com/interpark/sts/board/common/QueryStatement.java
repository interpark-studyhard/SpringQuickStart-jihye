/**
 * 
 */
package com.interpark.sts.board.common;

/**
 * @author 최지혜
 */
public class QueryStatement {
	
//	private static QueryStatement str = null;
	private QueryStatement() {
	}
	
	public static final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0) +1 from board), ?, ?, ?)";
    public static final String BOARD_UPDATE = "update board set title = ?, content = ? where 1=1 and seq = ?";
    public static final String BOARD_DELETE = "delete board where 1=1 and seq = ?";
    public static final String BOARD_GET = "select * from board where seq = ?";
    public static final String BOARD_LIST = "select * from board order by seq desc";
    
    public static final String USER_GET = "select * from users where id=? and password=?";
}
