package com.moneta.test.service;

import org.springframework.stereotype.Service;

@Service
public class PagingService {
	private int contentsNum; // 총 게시글 수, contentsNum()을 통해 가져옴
	private int contentsPerPage = 5; // 페이지당 글 수, 5개로 지정
	private int pagesNum; // 총 페이지 수 = 맨 끝 페이지. contentsNum/ contentsPerPage + 1
	private int pagesPerBlock = 5; // 블럭당 페이지 수 	
	private int blockNum; // 총 블럭 수 = 마지막 블럭. pagesNum / pagesPerBlock + 1
	private int curPage; // 현재 페이지. 페이지링크 클릭하면 받아옴
	private int curBlock; // 현재 블럭. curPage/pagesPerBlock + 1
	private int startPage; // 현재 블럭의 첫 번째 페이지. curBlock * pagesPerBlock -4
	private int endPage; // 현재 블럭의 마지막 페이지. startPage + 4
	private int firstPage = 1; // 맨 처음 페이지. 
	private int startContent; // 페이지의 첫 번째 게시물 curPage * contentsPerPage - 4
	private int lastContent; // 페이지의 마지막 게시물 startContent + 4
	private int prevPage; // 이전 페이지.
	private int nextPage; // 다음 페이지
	private int boardSeq; // 댓글 페이징처리할 게시물의 넘버
	private String searchWord;
	
	public int getFirstPage() {
		return firstPage;
	}
	/*public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	} */
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int curBlock) {
		//현재 페이지 블럭을 알면 블러당 페이지수를 곱해준 후 -4를 해준다
		//현재 블럭 2 * 페이지수 5 - 4 = 현재 블럭의 첫 페이지는 페이지 6
		this.startPage = curBlock * pagesPerBlock - 4;
		setEndPage(startPage);
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int startPage) {
		//현재 페이지 블럭의 첫 페이지 + 4
		if (startPage + 4 < pagesNum) {
			this.endPage = startPage + 4;
		} else {
			this.endPage = pagesNum;
		}
	}
	public int getContentsPerPage() {
		return contentsPerPage;
	}
	public void setContentsPerPage(int contentsPerPage) {
		this.contentsPerPage = contentsPerPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
		setCurBlock(curPage);
		setStartContent(curPage);
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curPage) { 
		//현재 페이지를 인자로 넣으면 블럭당 페이지수를 나눈 후 1을 더해서 현재 블럭 알려줌
		if (curPage != pagesPerBlock) {
			this.curBlock = curPage/pagesPerBlock + 1;
		}	else { //현재 페이지가 블럭당 페이지수와 일치하면 + 1을 하지 않음
			this.curBlock = curPage/pagesPerBlock;
		}
		setStartPage(curBlock);
	}
	public int getPagesPerBlock() {
		return pagesPerBlock;
	}
	public void setPagesPerBlock(int pagesPerBlock) {
		this.pagesPerBlock = pagesPerBlock;
	}
	public int getContentsNum() {
		return contentsNum;
	}
	public void setContentsNum(int contentsNum) {
		this.contentsNum = contentsNum;
		setPagesNum(contentsNum);
	}
	public int getPagesNum() {
		return pagesNum;
	}
	public void setPagesNum(int contentsNum) {
		// 총 게시글 수를 파라미터로 받으면 페이지당 글 수로 나눈 후 +1 해준다
		// 게시글 수 26 / 페이지당 글 수 5 + 1 = 총 6 페이지
		this.pagesNum = contentsNum / contentsPerPage + 1;
	}
	public int getBlockNum() {
		return blockNum;
	}
	public void setBlockNum(int blockNum) {
		this.blockNum = blockNum;
	}
	public int getStartContent() {
		return startContent;
	}
	public void setStartContent(int curPage) {
		//페이지의 첫 번째 게시물 = 현재 페이지 curPage * 페이지당 글 수contentsPerPage - 4
		this.startContent = curPage * contentsPerPage -4;
		setLastContent(startContent);
	}
	public int getLastContent() {
		return lastContent;
	}
	public void setLastContent(int startContent) {
		// 페이지의 마지막 게시물  = 페이지 첫 번째 게시물 startContent + 4
		this.lastContent = startContent + 4;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
	
}
