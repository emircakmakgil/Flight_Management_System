

# Flight Management System 🛫

Bu proje, havayolu şirketleri için kapsamlı bir uçuş yönetim sistemidir. Spring Boot kullanılarak geliştirilmiş modern bir web uygulamasıdır.

## 🚀 Özellikler

### Kullanıcı İşlemleri
- 👤 Kullanıcı kaydı ve girişi
- 🔐 JWT tabanlı kimlik doğrulama
- 👥 Rol tabanlı yetkilendirme (ADMIN, USER)

### Uçuş İşlemleri
- ✈️ Uçuş arama ve filtreleme
- 🎫 Bilet rezervasyonu
- 💺 Koltuk seçimi
- 📅 Uçuş takvimi görüntüleme

### Admin Paneli
- ✈️ Uçuş yönetimi (ekleme, silme, güncelleme)
- 🏢 Havayolu şirketi yönetimi
- 🛫 Havalimanı yönetimi
- 🎯 Kampanya yönetimi

### Diğer Özellikler
- 💰 Kampanya ve indirimler
- 🔍 Gelişmiş arama seçenekleri
- 📊 Raporlama ve istatistikler

## 🛠 Teknoloji Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT Authentication
- MapStruct
- Lombok

## 📋 Gereksinimler

- Java 17 veya üzeri
- PostgreSQL 12 veya üzeri
- Maven 3.x

## 🚀 Kurulum

1. Projeyi klonlayın:
```bash
git clone https://github.com/emircakmakgil/Flight_Management_System.git
```

2. PostgreSQL veritabanını oluşturun:
```sql
CREATE DATABASE flight_management;
```

3. `application.yml` dosyasındaki veritabanı bağlantı ayarlarını güncelleyin.

4. Projeyi derleyin ve çalıştırın:
```bash
cd flight-management-system
./mvnw spring-boot:run
```

## 📝 API Dokümantasyonu

### 🔑 Kimlik Doğrulama API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/users/all` | Tüm kullanıcıları listeler |
| POST | `/api/v1/users` | Yeni kullanıcı kaydı |
| PUT | `/api/v1/users/change-password` | Kullanıcı şifresini değiştirir |
| POST | `/api/v1/users/login` | Kullanıcı girişi |

### 👨‍💼 Çalışan API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/employees` | Tüm çalışanları listeler |
| POST | `/api/v1/employees` | Yeni çalışan ekler |
| PUT | `/api/v1/employees` | Çalışan bilgilerini günceller |
| DELETE | `/api/v1/employees` | Çalışan siler |
| POST | `/api/v1/employees/login` | Çalışan girişi |
| PUT | `/api/v1/employees/change-password` | Çalışan şifresini değiştirir |
### 👨‍👩‍👧‍👦 Yolcu API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/passengers` | Tüm yolcuları listeler |
| POST | `/api/v1/passengers` | Yeni yolcu ekler |
| PUT | `/api/v1/passengers` | Yolcu bilgilerini günceller |
| DELETE | `/api/v1/passengers` | Yolcu siler |
| POST | `/api/v1/passengers/login` | Yolcu girişi |
| PUT | `/api/v1/passengers/change-password` | Yolcu şifresini değiştirir |

### ✈️ Uçuş API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/flights` | Tüm uçuşları listeler |
| POST | `/api/v1/flights` | Yeni uçuş oluşturur |
| PUT | `/api/v1/flights` | Uçuş bilgilerini günceller |
| DELETE | `/api/v1/flights` | Uçuş siler |
| GET | `/api/v1/flights/getFlightsByDate` | Belirli tarih aralığındaki uçuşları listeler |

### 🎫 Bilet API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/tickets` | Tüm biletleri listeler |
| POST | `/api/v1/tickets` | Yeni bilet oluşturur |
| PUT | `/api/v1/tickets` | Bilet bilgilerini günceller |
| DELETE | `/api/v1/tickets` | Bilet siler |
| GET | `/api/v1/tickets/discounted` | İndirimli biletleri listeler |
| POST | `/api/v1/tickets/discounted` | İndirimli bilet oluşturur |
| GET | `/api/v1/tickets/discounted/{discountRate}` | Belirli indirim oranına sahip biletleri listele

### 🏢 Havalimanı API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/airports/arrivalAirport` | Tüm varış havalimanlarını listeler |
| GET | `/api/v1/airports/departureAirport` | Tüm kalkış havalimanlarını listeler |
| POST | `/api/v1/airports/arrivalAirport` | Yeni varış havalimanı ekler |
| POST | `/api/v1/airports/departureAirport` | Yeni kalkış havalimanı ekler |
| PUT | `/api/v1/airports/arrivalAirport` | Varış havalimanı bilgilerini günceller |
| PUT | `/api/v1/airports/departureAirport` | Kalkış havalimanı bilgilerini günceller |
| DELETE | `/api/v1/airports/arrivalAirport` | Varış havalimanı siler |
| DELETE | `/api/v1/airports/departureAirport` | Kalkış havalimanı siler |

### ✈️ Havayolu Şirketi API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/airlines` | Tüm havayolu şirketlerini listeler |
| POST | `/api/v1/airlines` | Yeni havayolu şirketi ekler |
| PUT | `/api/v1/airlines` | Havayolu şirketi bilgilerini günceller |
| DELETE | `/api/v1/airlines` | Havayolu şirketi siler |

### 💰 Kampanya API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/v1/campaigns` | Tüm kampanyaları listeler |
| POST | `/api/v1/campaigns` | Yeni kampanya oluşturur |
| PUT | `/api/v1/campaigns` | Kampanya bilgilerini günceller |
| DELETE | `/api/v1/campaigns` | Kampanya siler |

## 🔐 Güvenlik

- JWT tabanlı kimlik doğrulama
- Rol tabanlı yetkilendirme
- Password encryption
- CORS yapılandırması

## 🧪 Test

```bash
./mvnw test
```

## 📦 Docker ile Çalıştırma

```bash
# Docker compose ile tüm servisleri başlatma
docker-compose up -d
```



## 👥 Geliştirici

- Emir Çakmakgil

## 📞 İletişim

[Emir Çakmakgil] - emircakmakgil37@gmail.com

🙏 Teşekkürler 
