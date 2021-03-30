package com.iu.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return  bankBookDAO.setDelete(bankBookDTO);
	}
	
	public List<BankBookDTO> getList(Pager pager) throws Exception{
		   int perPage=10;
		   int perBlock=5;
		   //--------------------------
		   long startRow = (pager.getCurPage()-1)*perPage+1;
		   long lastRow = pager.getCurPage()*perPage;
		   pager.setStartRow(startRow);
		   pager.setLastRow(lastRow);
		   //--------------------------
		   //1. totalCount
		   long totalCount = bankBookDAO.getTotalCount(pager);
		   //2. totalPage
		   long totalPage = totalCount/perPage;
		   if(totalCount%perPage!=0) {
			   totalPage++;
		   }
		   
		   //3. totalBlock
		   long totalBlock= totalPage/perBlock;
		   if(totalPage%perBlock !=0) {
			   totalBlock++;
		   }
		   
		   //4. curBlock
		   long curBlock= pager.getCurPage()/perBlock;
		   if(pager.getCurPage()%perBlock != 0) {
			   curBlock++;
		   }
		   //5. startBlock, lastBlock
		   long startBlock = (curBlock-1)*perBlock+1;
		   long lastBlock = perBlock*curBlock;
		   
		   
		   pager.setLastBlock(lastBlock);
		   pager.setStartBlock(startBlock);
		 
			System.out.println("curBlock: "+curBlock);
			System.out.println("TotalPage: " +totalPage);
			System.out.println("TotalBlock: "+totalBlock);
			
			//6. curBlock이 마지막 block 일때 
			
			if(curBlock == totalBlock) {
				lastBlock = totalPage;
			}
			
			//7. 이전, 다음 block 존재 여부
			
		  if(curBlock!=1) {
			  pager.setPre(true);
		  }
          //다음
		  if(curBlock!=totalBlock) {
			  pager.setNext(true);
		  }

		   
		
		return bankBookDAO.getList(pager);
		
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception {
	   return bankBookDAO.getSelect(bankBookDTO);
	}
	
	

}
