package net.developia.restful.board;

import java.sql.SQLException;
import java.util.List;

public interface BoardDAO {

	List<BoardVO> getBoardList() throws SQLException;

	void insertBoard(BoardVO boardVO) throws SQLException;

	void insertArticle(ArticleVO articleVO) throws SQLException;

	List<ArticleVO> getArticleList (int boa_no) throws SQLException;

	BoardVO getBoard(int boa_no) throws SQLException;

	

	ArticleVO getArticle(long art_no) throws SQLException;

	int updateReadcnt(long art_no) throws SQLException;

	int deleteArticle(ArticleVO articleVO) throws SQLException;

	int updateArticle(ArticleVO articleVO) throws SQLException;

	void insertComment(CommentVO commentVO) throws SQLException;

	List<CommentVO> getCommentList(CommentVO commentVO) throws SQLException;

	void deleteComment(CommentVO commentVO) throws SQLException;

	int updateComment(CommentVO commentVO) throws SQLException;

	

}
