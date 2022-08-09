package com.myspring.pro30.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.pro30.member.dao.MemberDAO;
import com.myspring.pro30.member.vo.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List listMembers = memberDAO.selectAllMemberList();
		return listMembers;
	}

	@Override
	public MemberVO loginDO(MemberVO memberVO) throws DataAccessException {
		MemberVO loginDO = memberDAO.login(memberVO);
		return loginDO;
	}
	
	
}
