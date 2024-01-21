
# Bankacılık Uygulaması

Kullanıcı banka hesabı oluşturabilir, para yatırabilir ve çekebilir. Hesap numarası kullanarak telefon faturasını ödeyebilir. Bu örneklerin api detayları aşağıda verilmiştir. Postman tarafında bulunan servisler [Postman Collection](https://github.com/bekiristek/simple-banking/blob/main/collection/bank-app-api.postman_collection.json) içerisinden incelenebilir.

## Projenin Çalıştırılması

- Projenin bulunduğu dizine gidilir --> "cd /bekiristek/simple-banking"
- Projenin ihtiyaç duyduğu veritabanı için  [docker-compose.yml](https://github.com/bekiristek/simple-banking/blob/main/docker-compose.yml) dosyası çalıştırılır --> "docker-compose up -d"
- Java projesi ayağa kaldırılır --> "http://localhost:9000/"
- Projenin endpointlerine <b> API Kullanımı </b>  bölümünden detaylarına ulaşabilirsiniz.


## API Kullanımı

#### Hesap Oluşturma

```http
  POST http://localhost:9000/api/v1/account/create
```
<p align="center">
    <img src ="screenshots/create-account.png">
</p>

#### Hesaba Para Yatırma

```http
  POST http://localhost:9000/api/v1/account/credit
```
<p align="center">
    <img src ="screenshots/deposit-account.png">
</p>

#### Hesabtan Para Çekme

```http
  POST http://localhost:9000/api/v1/account/debit
```
<p align="center">
    <img src ="screenshots/debit-account.png">
</p>

#### Telefon Faturası Ödeme

```http
  POST http://localhost:9000/api/v1/account/payment
```
<p align="center">
    <img src ="screenshots/payment-phone-bill.png">
</p>

#### Hesap Numarası Bilgisi ile Hesap Detaylarını Getirme

```http
  GET http://localhost:9000/api/v1/account/{accountNumber}
```
<p align="center">
    <img src ="screenshots/get-account.png">
</p>

#### Veritabanında İlgili Kayıtlar

```http
  jdbc:postgresql://localhost:5432/bankApp
```

<p align="center">
    <img src ="screenshots/account-db.png">
</p>

<p align="center">
    <img src ="screenshots/transaction-db.png">
</p>

## Projede Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.2.2
- Maven
- Lombok
- Restful API
- Docker
- Docker Compose
- Postman
- PostgreSQL

## İletişim

- 📫 mail : **admin@bekiristek.com**
- 💻 website: [bekiristek.com](https://bekiristek.com/)
