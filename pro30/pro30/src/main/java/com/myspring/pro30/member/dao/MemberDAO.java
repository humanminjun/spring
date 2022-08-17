package com.myspring.pro30.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.member.vo.MemberVO;

@Repository
public interface MemberDAO {

	public List selectAllMemberList()throws DataAccessException;

	public MemberVO login(MemberVO memberVO)throws DataAccessException;
	
	public int deleteMember(String id)throws DataAccessException;
	
	public int insertMember(MemberVO memberVO)throws DataAccessException;
	
	public MemberVO readMember(String id)throws DataAccessException;
}
	 

