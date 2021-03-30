package com.iu.s3.util;

public class Pager {
	
	private long curPage;
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	
	private long curBlock;
	private long totalBlock;
	private long startBlock;
	private long lastBlock;
	
	private boolean pre; //이전 블락이 있으면 true 없으면 false
	private boolean next; // 다음블락이 있으면   true 없으면false
	
	private String kind; // 검색할 컬럼명
	private String search; //검색어
	
	
	
	
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		
      if(this.search ==null) {
    	  this.search="";
      }
		return search;
	}
	public void setSearch(String search) {
		if(search==null) {
			search="";
		}
		this.search = search;
	}
	public long getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(long curBlock) {
		this.curBlock = curBlock;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public long getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(long startBlock) {
		this.startBlock = startBlock;
	}
	public long getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(long lastBlock) {
		this.lastBlock = lastBlock;
	}
	public long getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(long totalBlock) {
		this.totalBlock = totalBlock;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
	
	public long getCurPage() {
		if(this.curPage<1) {
		
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {
		if(curPage<1) {
			curPage=1;
		}
		this.curPage = curPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	
	
	

}
