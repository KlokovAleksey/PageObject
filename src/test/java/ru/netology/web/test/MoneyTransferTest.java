package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.LoginPageV2;
import ru.netology.web.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.DataHelper.*;

class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
      open("http://localhost:9999");
      val loginPage = new LoginPageV1();
//    val loginPage = open("http://localhost:9999", LoginPageV1.class);
      val authInfo = getAuthInfo();
      val verificationPage = loginPage.validLogin(authInfo);
      val verificationCode = getVerificationCodeFor(authInfo);
      verificationPage.validVerify(verificationCode);
    }

  @Test
  void shouldTransferMoneyBetweenOwnCardsV2() {
    open("http://localhost:9999");
    val loginPage = new LoginPageV2();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
  }

  @Test
  void shouldTransferMoneyBetweenOwnCardsV3() {
    val loginPage = open("http://localhost:9999", LoginPageV3.class);
    val authInfo = getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
  }
}

