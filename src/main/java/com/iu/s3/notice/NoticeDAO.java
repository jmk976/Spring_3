package com.iu.s3.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession; 
	private final String NAMESPACE="com.iu.s3.notice.NoticeDAO.";
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	
	
	public List<NoticeDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	

}
