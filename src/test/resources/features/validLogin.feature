@login
Feature: Walkedu Gecerli Login Testi
  Kullanici olarak
  Walkedu sitesine basariyla login olmak istiyorum

  Background:
    Given Kullanici Login Sayfasina gider.

  @validLogin
  Scenario: Gecerli verilerle Login olma
    And kullanici login formu gecerli verilerle doldurur
      | Field     | Value                 |
      | Email     | muammer10er@gmail.com |
      | Password  | Walkedu.24            |
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.


  @validLogin
  Scenario: Gecerli verilerle Login olma
    And kullanici login formu gecerli email ve sifre ile doldurur
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Profilini goruntuleyebilecegi Hesabim butonunu Navbarda goruntuler.


  @invalidLogin
  Scenario Outline: Gecersiz verilerle login testi
    And kullanici Login Formu icin gecerli email ve "<gecersiz sifre>" girer
    When Kullanici Login Sayfasinda Giris Yap butonuna tiklar.
    Then Kullanici Gecersiz email veya password hatasini goruntuler.

    Examples:
     |gecersiz sifre  |
     |Walkedu24       |
     |Walkedu 24      |
     |Walkedu.        |




