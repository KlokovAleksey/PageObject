package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement pageName = $(withText("Пополнение карты"));
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public TransferPage() {
        pageName.shouldBe(Condition.visible);
    }

    public DashboardPage transferMoney(DataHelper.CardInfo info, int amount) {
        amountField.setValue(String.valueOf(amount));
        fromField.setValue(info.getNumberCard());
        transferButton.click();
        return new DashboardPage();
    }

}
