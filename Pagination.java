package com.moneta.test.domain;

public class Pagination {

	 /** 한 페이지당 게시글 수 **/
    private int pageSize = 5;
    
    /** 한 블럭(range)당 페이지 수 **/
    private int rangeSize = 5;
    
    /** 현재 페이지 **/
    private int curPage = 1;
    
    /** 현재 블럭(range) **/
    private int curRange = 1;
    
    /** 총 게시글 수 **/
    private int listCnt;
    
	/** 총 페이지 수 **/
    private int pageCnt;
    
    /** 총 블럭(range) 수 **/
    private int rangeCnt;
    
    /** 시작 페이지 **/
    private int startPage = 1;
    
    /** 끝 페이지 **/
    private int endPage = 1;
    
    /** 시작 index **/
    private int startIndex = 0;
    
    /** 종료 index **/
    private int endIndex = 0;
       
	/** 이전 페이지 **/
    private int prevPage;
    
    /** 다음 페이지 **/
    private int nextPage;
    
    /**검색어 **/
    private String searchWord;
	

	public Pagination(int curPage, int listCnt) {
		// TODO Auto-generated constructor stub
    	setCurPage(curPage);
    	/*총 페이지 수 셋팅*/
    	setPageCnt(listCnt);
//    	this.startPage = 1;
//    	this.endPage = pageCnt;
    	/*총 블럭수
    	setRangeCnt(pageCnt);
    	 3. 블럭(range) setting 
        rangeSetting(curPage);*/
        
        /* DB 질의를 위한 startIndex 설정 */
        setStartIndex(curPage);
        setEndIndex(startIndex);
        
        rangeSetting(curPage);
	}
    
    private void rangeSetting(int curPage) {
		// TODO Auto-generated method stub
    	 setCurRange(curPage);   
    	 setRangeCnt(pageCnt);
         this.startPage = (curRange - 1) * rangeSize + 1;
         
         // 1부터 시작할지 11부터 시작할지 결정해준다.
         this.endPage = startPage + rangeSize - 1;
         
//         System.out.println("여기는?>>>"+startPage+" >>>>>"+endPage);
         
         if(endPage > pageCnt){
             this.endPage = pageCnt;
         }
         
         this.prevPage = curPage - 1;
         this.nextPage = curPage + 1;
	}

	public int getPageSize() {
  		return pageSize;
  	}

  	public void setPageSize(int pageSize) {
  		this.pageSize = pageSize;
  	}

  	public int getRangeSize() {
  		return rangeSize;
  	}

  	public void setRangeSize(int rangeSize) {
  		this.rangeSize = rangeSize;
  	}

  	public int getCurPage() {
  		return curPage;
  	}

  	public void setCurPage(int curPage) {
  		this.curPage = curPage;
  	}

  	public int getCurRange() {
  		return curRange;
  	}

  	public void setCurRange(int curRange) {
  	  this.curRange = (int)((curPage-1)/rangeSize) + 1;
  	  //몇 번째 블럭 위치에 있는지를 셋팅해준다.
  	  // 블록당 갯수로 나누어주면 몫이 몇번째 블록인지를 알 수 있게 해주는데.. -1은 블록당 갯수와 동일할 경우에 애매한 위치가 되므로
  	  // 1을 빼준다. 그리고 인덱스가 0부터 시작하므로 +1로 해준다.c
  	}

  	public int getListCnt() {
  		return listCnt;
  	}

  	public void setListCnt(int listCnt) {
  		this.listCnt = listCnt;
  	}

  	public int getPageCnt() {
  		return pageCnt;
  	}

  	public void setPageCnt(int listCnt) {
  		 this.pageCnt = (int) Math.ceil(listCnt*1.0/pageSize);
  		 // 총 페이지 수는  = 총 게시물수/페이지 당 게시글 수  해서 올림한다.
  		 // ex > 223/10 = 22.3 페이지가 나오는데 3개 게시물을 위해 올림 해준결과인 23이 된다.
  	}

  	public int getRangeCnt() {
  		return rangeCnt;
  	}

  	public void setRangeCnt(int rangeCnt) {
  		this.rangeCnt = (int) Math.ceil(pageCnt*1.0/rangeSize);
  		//총 블럭수는 = 총 페이지 갯수/블럭당 갯수 해서 올림한다.
  		// ex> 11페이지 일때 블럭당 갯수가 5개면 , 11/5 = 2.2 이므로 올림해서 3개의 블럭이 나온다.
  	}

  	public int getStartPage() {
  		return startPage;
  	}

  	public void setStartPage(int startPage) {
  		this.startPage = startPage;
  	}

  	public int getEndPage() {
  		return endPage;
  	}

  	public void setEndPage(int endPage) {
  		this.endPage = endPage;
  	}

  	public int getStartIndex() {
  		return startIndex;
  	}

  	public void setStartIndex(int curPage) {
  		this.startIndex = (curPage - 1) * pageSize + 1;
  	}
  	
  	 public int getEndIndex() {
 		return endIndex;
 	}

 	public void setEndIndex(int startIndex) {
 		this.endIndex = startIndex + pageSize -1;
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
  	
    public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

}
