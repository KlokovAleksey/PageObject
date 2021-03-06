package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferPage {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferFirstBySecond() {
        LoginPage loginPage = new LoginPage();
        loginPage.validLogin(DataHelper.getAuthInfo());
        val verificationPage = new VerificationPage();
        verificationPage.validVerify(DataHelper.getVerificationCodeFor(DataHelper.getAuthInfo()));
        val dashboardPage = new DashboardPage();
        val startBalanceFirstCard = dashboardPage.getFirstCardBalance();
        val startBalanceSecondCard = dashboardPage.getSecondCardBalance();
        dashboardPage.replenishFirstCard();
        val transferPage = new TransferPage();
        int amount = 100;
        transferPage.transferMoney(amount,DataHelper.getSecondCardInfo());
        val balanceFirstCard = DataHelper.addingBalance(startBalanceFirstCard,amount);
        val balanceSecondCard = DataHelper.withdrawalBalance(startBalanceSecondCard,amount);
        val finishBalanceFirstCard = dashboardPage.getFirstCardBalance();
        val finishBalanceSecondCard = dashboardPage.getSecondCardBalance();
        assertEquals(balanceFirstCard,finishBalanceFirstCard);
        assertEquals(balanceSecondCard,finishBalanceSecondCard);

    }

    @Test
    void shouldTransferSecondByFirst() {
        LoginPage loginPage = new LoginPage();
        loginPage.validLogin(DataHelper.getAuthInfo());
        val verificationPage = new VerificationPage();
        verificationPage.validVerify(DataHelper.getVerificationCodeFor(DataHelper.getAuthInfo()));
        val dashboardPage = new DashboardPage();
        val startBalanceFirstCard = dashboardPage.getFirstCardBalance();
        val startBalanceSecondCard = dashboardPage.getSecondCardBalance();
        dashboardPage.replenishSecondCard();
        val transferPage = new TransferPage();
        int amount = 100;
        transferPage.transferMoney(amount,DataHelper.getFirstCardInfo());
        val balanceFirstCard = DataHelper.withdrawalBalance(startBalanceFirstCard,amount);
        val balanceSecondCard = DataHelper.addingBalance(startBalanceSecondCard,amount);
        val finishBalanceFirstCard = dashboardPage.getFirstCardBalance();
        val finishBalanceSecondCard = dashboardPage.getSecondCardBalance();
        assertEquals(balanceFirstCard,finishBalanceFirstCard);
        assertEquals(balanceSecondCard,finishBalanceSecondCard);

    }
}