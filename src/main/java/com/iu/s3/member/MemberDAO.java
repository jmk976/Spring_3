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
		//id 를 제외하고 나머지를 수정  
	}
	
	public int memberDelete(MemberDTO memberDTO)throws Exception{
		
	}
	
	//memberJoin 데이터를 받아서 Db에 insert하는 메서드
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";

		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		con.setAutoCommit(false);
		
		String sql = "insert into member(id, pw, name, phone, email) values(?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql); 
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		
		int result = st.executeUpdate();
		
		if(result>0) {
			con.commit();
		} else {
			con.rollback();
		}
		
		con.setAutoCommit(true);
		
		st.close();
		con.close();
		
		return result;
		
		
	}
	
	//login -id pw 를 받아서 조회
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		
		
		
		return sqlSession.selectOne(NAMESPACE+".memberLogin", memberDTO);
		
	}

}
