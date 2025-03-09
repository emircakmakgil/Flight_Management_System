

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
| POST | `/api/auth/register` | Yeni kullanıcı kaydı |
| POST | `/api/auth/login` | Kullanıcı girişi |
| GET | `/api/auth/me` | Mevcut kullanıcı bilgilerini getirir |

### ✈️ Uçuş API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/flights` | Tüm uçuşları listeler |
| GET | `/api/flights/{id}` | Belirli bir uçuşun detaylarını getirir |
| POST | `/api/flights` | Yeni uçuş oluşturur (ADMIN) |
| PUT | `/api/flights/{id}` | Uçuş bilgilerini günceller (ADMIN) |
| DELETE | `/api/flights/{id}` | Uçuşu siler (ADMIN) |
| GET | `/api/flights/search` | Uçuşları filtreler |

### 🎫 Bilet API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/tickets` | Kullanıcının biletlerini listeler |
| GET | `/api/tickets/{id}` | Belirli bir biletin detaylarını getirir |
| POST | `/api/tickets` | Yeni bilet oluşturur |
| GET | `/api/tickets/discounted` | İndirimli biletleri listeler |
| POST | `/api/tickets/discounted` | İndirimli bilet oluşturur |
| DELETE | `/api/tickets/{id}` | Bileti iptal eder |

### 🏢 Havalimanı API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/airports` | Tüm havalimanlarını listeler |
| GET | `/api/airports/{id}` | Belirli bir havalimanının detaylarını getirir |
| POST | `/api/airports` | Yeni havalimanı ekler (ADMIN) |
| PUT | `/api/airports/{id}` | Havalimanı bilgilerini günceller (ADMIN) |
| DELETE | `/api/airports/{id}` | Havalimanını siler (ADMIN) |

### 💰 Kampanya API'leri

| Metod | Endpoint | Açıklama |
|-------|----------|-----------|
| GET | `/api/campaigns` | Tüm kampanyaları listeler |
| GET | `/api/campaigns/{id}` | Belirli bir kampanyanın detaylarını getirir |
| POST | `/api/campaigns` | Yeni kampanya oluşturur (ADMIN) |
| PUT | `/api/campaigns/{id}` | Kampanya bilgilerini günceller (ADMIN) |
| DELETE | `/api/campaigns/{id}` | Kampanyayı siler (ADMIN) |

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
