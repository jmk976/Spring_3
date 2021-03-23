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

@Repository
public class BankBookDAO {
	//주입하는 어노테이션 
    @Autowired
	private SqlSession sqlSession;
    private final String NAMESPACE="com.iu.s3.bankbook.BankBookDAO";
    
    public int setWrite(BankBookDTO bankBookDTO) throws Exception{
    	int result = sqlSession.insert(NAMESPACE+".setWrite", bankBookDTO);
    	
    	
    	
    	return result;
    }
    	
    	
    public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception{
    	long num = 1L;
    	bankBookDTO = sqlSession.selectOne(NAMESPACE+"getSelect", num);
        
        return bankBookDTO;

    	
    }
    	//getList
    	//bankbook table의  모든 데이터 조회 후  리턴 
    	

    	
      public List getList() throws Exception {
    	  
    	  
    		ArrayList<BankBookDTO> ar = new ArrayList();
    		
    	   
    	    
    	    return ar;
      }
}
