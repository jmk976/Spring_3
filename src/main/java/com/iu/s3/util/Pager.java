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
