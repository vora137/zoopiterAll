package com.project.zoopiter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/pet")
public class PetInfoController {
// 등록 pet_reg
  // 등록양식
  @GetMapping("/pet_reg")
  public String saveInfo(){
    return "pet_reg";
  }
  // 등록처리
//  PetInfo saveInfo(PetInfo petInfo);
  @PostMapping("/pet_reg")
  public String save(){
    return "redirect:/mypage/pet/{id}/mypage_pet_reg";
  }

// 수정 pet_modify > 메인으로 이동(보호자정보페이지)
//  int updateInfo (Long PetNum, PetInfo petInfo);
  // 수정양식
  @GetMapping("/{id}/edit")
  public String updateInfo(){
    return "/mypage/pet_modify";
  }

  // 수정
  @PostMapping("/{id}/edit")
  public String update(){
    return "redirect:/mypage/pet_modify";
  }

  // 삭제 > 메인으로 이동(보호자정보페이지)
//  int deleteInfo(Long PetNum);
  @GetMapping("{id}/del")
  public String deleteInfo(){
    return "redirect:/mypage";
  }

  // 목록 > ?
//  List<PetInfo> findInfo();
  @GetMapping
  public String findInfo(){
    return "/mypage/pet";
  }
}
