package com.project.zoopiter.domain.member.dao;

import com.project.zoopiter.domain.entity.PetInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PetInfoDAOImpl implements PetInfoDAO{
  private final NamedParameterJdbcTemplate template;

  /** 등록
   * @param petInfo
   * @return
   */
  @Override
  public PetInfo saveInfo(PetInfo petInfo) {
    StringBuffer sql = new StringBuffer();

    return petInfo;
  }

  /** 수정
   * @param PetNum
   * @param petInfo
   * @return
   */
  @Override
  public int updateInfo(Long PetNum, PetInfo petInfo) {
    return 0;
  }

  /** 삭제
   * @param PetNum
   * @return
   */
  @Override
  public int deleteInfo(Long PetNum) {
    return 0;
  }

  /** 목록
   * @return
   */
  @Override
  public List<PetInfo> findInfo() {
    return null;
  }
}
