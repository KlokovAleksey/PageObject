# PageObject

Тестирование функции перевода с карты на карту

После логина , вы получите список карт:

![cards](https://user-images.githubusercontent.com/68289203/118332769-4ca7bf00-b513-11eb-8440-c8c98347ec3e.png)

Нажав на кнопку "Пополнить" вы перейдёте на страницу перевода средств:

![transfer](https://user-images.githubusercontent.com/68289203/118332867-6812ca00-b513-11eb-8f0f-eef6aadd8965.png)

Тестируемая функциональность:
* Перевод с определённой карты на другую карту n'ой суммы
* Проверки баланса по карте (со страницы списка карт)

Для запуска выполнить команду : ```gradlew clean test```


# [![Build status](https://ci.appveyor.com/api/projects/status/wtklm7qs1ruiromb?svg=true)](https://ci.appveyor.com/project/KlokovAleksey/pageobject)
