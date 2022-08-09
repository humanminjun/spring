package com.myspring.pro30.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.member.vo.MemberVO;

public interface MemberService {
	public List listMembers()throws DataAccessException;
	public MemberVO loginDO(MemberVO memberVO)throws DataAccessException;
}
