package ru.netology.web.data;

import lombok.AllArgsConstructor;
import lombok.Value;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
    return new AuthInfo("petya", "123qwerty");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }

  @Value
  @AllArgsConstructor
  public static class CardInfo {
    private String numberCard;
  }

public static CardInfo getFirstCardInfo() {
    return new CardInfo("5559 0000 0000 0001");}


  public static CardInfo getSecondCardInfo() {
    return new CardInfo("5559 0000 0000 0002");}

    public static int addingBalance(int balance,int amount){
    return balance + amount;
    }

  public static int withdrawalBalance(int balance,int amount) {
    return balance - amount;
  }

}

