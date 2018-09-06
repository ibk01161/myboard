package net.developia.restful.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void insertArticle(ArticleVO articleVO) throws Exception {
		boardDAO.insertArticle(articleVO);
		
	}

	@Override
	public List<ArticleVO> getArticleList(int boa_no) throws Exception {
		return boardDAO.getArticleList(boa_no);
	}

	@Override
	public BoardVO getBoard(int boa_no) throws Exception {
		BoardVO boardVO = boardDAO.getBoard(boa_no);
		if (boardVO == null) {
			throw new RuntimeException("잘못된 게시판 번호");
		}
		return boardVO;
	}

	@Override
	public ArticleVO getArticle(long art_no) throws Exception {
		ArticleVO articleVO = boardDAO.getArticle(art_no);
		if (articleVO == null) {
			throw new RuntimeException(art_no + "번 글 없음");
		}
		return articleVO;		// 오류가 안나면 리턴
	}

	@Override
	public void updateReadcnt(long art_no) throws Exception {
		if(boardDAO.updateReadcnt(art_no) == 0) {
			throw new RuntimeException(art_no + "번 글 없음");
		}
		
	}

	@Override
	public void deleteArticle(ArticleVO articleVO) throws Exception {
		if (boardDAO.deleteArticle(articleVO) == 0) {				// 1이여야 정상
			throw new RuntimeException("존재 ㄴㄴ 권한 ㄴㄴ");
		}
		
	}

	@Override
	public void updateArticle(ArticleVO articleVO) throws Exception {
		if (boardDAO.updateArticle(articleVO) == 0) {				// 1이여야 정상
			throw new RuntimeException("존재 ㄴㄴ 권한 ㄴㄴ");
		}
		
	}

	   @Override
	   public void insertComment(CommentVO commentVO) throws Exception {
	      boardDAO.insertComment(commentVO);
	   }

	@Override
	public List<CommentVO> getCommentList(CommentVO commentVO) throws Exception {
		return boardDAO.getCommentList(commentVO);
	}

	@Override
	public void deleteComment(CommentVO commentVO) throws Exception {
		boardDAO.deleteComment(commentVO);
	}

	@Override
	public void updateComment(CommentVO commentVO) throws Exception {
		if (boardDAO.updateComment(commentVO) == 0) {
			throw new RuntimeException("수정 실패");
		};
		
	}






}
