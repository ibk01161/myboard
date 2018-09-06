package net.developia.restful.board;

import java.util.List;

public interface BoardService {

	List<BoardVO> getBoardList() throws Exception;

	void insertBoard(BoardVO boardVO) throws Exception;

	void insertArticle(ArticleVO articleVO) throws Exception;

	List<ArticleVO> getArticleList(int boa_no) throws Exception;

	BoardVO getBoard(int boa_no) throws Exception;

	ArticleVO getArticle(long art_no) throws Exception;

	void updateReadcnt(long art_no) throws Exception;

	void deleteArticle(ArticleVO articleVO) throws Exception;

	void updateArticle(ArticleVO articleVO) throws Exception;

	void insertComment(CommentVO commentVO) throws Exception;

	List<CommentVO> getCommentList(CommentVO commentVO) throws Exception;

	void deleteComment(CommentVO commentVO) throws Exception;

	void updateComment(CommentVO commentVO) throws Exception;

	


}
