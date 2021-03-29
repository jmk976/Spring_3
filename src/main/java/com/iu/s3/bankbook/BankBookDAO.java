package com.iu.s3.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.s3.bankbook.BankBookDTO;
import com.iu.s3.util.Pager;

@Repository
public class BankBookDAO {
	//주입하는 어노테이션 
    @Autowired
	private SqlSession sqlSession;
    private final String NAMESPACE="com.iu.s3.bankbook.BankBookDAO.";
    
    
    public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
    	return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
    	
    	
    }
    
    
    public int setDelete(BankBookDTO bankBookDTO) throws Exception{
    	return sqlSession.delete(NAMESPACE+"setDelete",bankBookDTO);
    }
    
    public int setWrite(BankBookDTO bankBookDTO) throws Exception{
    	int result = sqlSession.insert(NAMESPACE+"setWrite", bankBookDTO);
    	
    	
    	
    	return result;
    }
    	
    	
    public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception{
    	//long num = 1L;   bankBookDTO 부분num 으로 넣기 가
    	
    	System.out.println("select service");
    	bankBookDTO = sqlSession.selectOne(NAMESPACE+"getSelect", bankBookDTO);
        
    	System.out.println(bankBookDTO.getBooknumber());
        return bankBookDTO;

    	
    }
    	//getList
    	//bankbook table의  모든 데이터 조회 후  리턴 
    	

    	
      public List<BankBookDTO> getList(Pager pager) throws Exception {
    	  
    	 return sqlSession.selectList(NAMESPACE+"getList", pager);
    	  
      }
      
      public Long getTotalCount()throws Exception{
    	  return sqlSession.selectOne(NAMESPACE+"getTotalCount");
      }
}
