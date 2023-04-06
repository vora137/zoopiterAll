package com.project.zoopiter.domain.member.dao;

import com.project.zoopiter.domain.entity.PetInfo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;


@Slf4j
@SpringBootTest
class PetInfoDAOImplTest {
  @Autowired
  private PetInfoDAO petInfoDAO;

  @Test
  @DisplayName("반려동물 등록")
  void saveInfo() {
    byte[] petImg = "test image".getBytes();
    PetInfo petInfo = new PetInfo();
    petInfo.setUserId("test1");
    petInfo.setPetImg(petImg);
    petInfo.setPetType("시츄");
    petInfo.setPetName("강아지1");
    petInfo.setPetBirth(new Timestamp(new Date(123, 3, 6).getTime()));
    petInfo.setPetGender("M");
    petInfo.setPetYn("Y");
    petInfo.setPetDate(new Timestamp(new Date(123, 3, 6).getTime()));
    petInfo.setPetVac("P0101");
    petInfo.setPetInfo("다이어트");

    String petNum = String.valueOf(petInfoDAO.saveInfo(petInfo));
    log.info("petNum={}", petNum);

    Assertions.assertThat(petNum).isGreaterThan(String.valueOf(0L));
  }


  @Test
  void findInfo() {
  }

  @Test
  void updateInfo() {
  }

  @Test
  void deleteInfo() {
  }

  @Test
  void findAll() {
  }
}