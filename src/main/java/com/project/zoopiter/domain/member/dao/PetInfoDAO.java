package com.project.zoopiter.domain.member.dao;

import com.project.zoopiter.domain.entity.PetInfo;

import java.util.List;

public interface PetInfoDAO {
  // 등록
  PetInfo saveInfo(PetInfo petInfo);

  // 수정
  int updateInfo (Long PetNum, PetInfo petInfo);

  // 삭제
  int deleteInfo(Long PetNum);
  // 목록
  List<PetInfo> findInfo();

  // 회원유무

}
