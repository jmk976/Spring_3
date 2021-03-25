package com.iu.s3.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.s3.member.MemberDAO";
	
	
	
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		//id 를 제외하고 나머지를 수정  (id, pw를 둘다 입력해야 수정가능..) 
		return sqlSession.update(NAMESPACE+".memberUpdate", memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+".memberDelete", memberDTO);
	}
	
	//memberJoin 데이터를 받아서 Db에 insert하는 메서드
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+".memberJoin", memberDTO);

		
		return result;
	}
	
	//login -id pw 를 받아서 조회
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		
		return sqlSession.selectOne(NAMESPACE+".memberLogin", memberDTO);	
	}

}
