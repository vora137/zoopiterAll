package com.project.zoopiter.domain.member.dao;

import com.project.zoopiter.domain.entity.PetInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PetInfoDAOImpl implements PetInfoDAO{
  private final NamedParameterJdbcTemplate template;

  /**
   * 등록
   *
   * @param petInfo
   * @return
   */
  @Override
  public String saveInfo(PetInfo petInfo) {
    StringBuffer sb = new StringBuffer();
    sb.append(
    "insert into pet_info( pet_num,user_id,pet_img,pet_name,pet_type,pet_gender,pet_birth,pet_yn,pet_date,pet_vac,pet_info)");
    sb.append("values(");
    sb.append("pet_info_pet_num_seq.nextval, ");
    sb.append(":pet_img");
    sb.append(":pet_name");
    sb.append(":pet_type");
    sb.append(":pet_gender");
    sb.append(":pet_birth");
    sb.append(":pet_yn");
    sb.append(":pet_date");
    sb.append(":pet_vac");
    sb.append(":pet_info )");

    SqlParameterSource param = new BeanPropertySqlParameterSource(petInfo);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    template.update(sb.toString(),param,keyHolder);

    String key = keyHolder.getKey().toString();  // Long petNum;    // Pet ID
    return key;
  }

  /**
   * 조회
   * @param memberId
   * @return
   */
  @Override
  public Optional<PetInfo> findInfo(Long memberId) {
    StringBuffer sb = new StringBuffer();
    sb.append(" select *");
    sb.append("from pet_info");
    sb.append(" where user_id = :id");

    try{
    Map<String,Long> param = Map.of("id",memberId);
    PetInfo petInfo = template.queryForObject(sb.toString(),param, PetInfo.class);
      return Optional.of(petInfo);
    } catch (EmptyResultDataAccessException e){
      // 조회 결과가 없을때
      return Optional.empty();
    }
  }

  /** 수정
   * @param PetNum  펫아이디
   * @param petInfo 수정할 펫정보
   * @return
   */
  @Override
  public int updateInfo(Long PetNum, PetInfo petInfo) {
    StringBuffer sb = new StringBuffer();

    sb.append("update pet_info");
    sb.append("set");
    sb.append("    pet_img = :pet_img ,");
    sb.append("    pet_name = :pet_name,");
    sb.append("    pet_type= :pet_type,");
    sb.append("    pet_gender= :pet_gender',");
    sb.append("    pet_birth= :pet_birth,");
    sb.append("    pet_yn= :pet_yn ,");
    sb.append("    pet_date= :pet_date,");
    sb.append("    pet_vac= :pet_vac,");
    sb.append("    pet_info= :pet_info");
    sb.append("where user_id= :id;");

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("pet_img",petInfo.getPetImg());

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
  public List<PetInfo> findAll() {
    return null;
  }
}
