<h1 align="center">
  Take Note <a name="readme-top"></a>
</h1>

<div align="center">
  <img src="./Readme Resources/Not Tut Logo.png" alt="Logo" width="120"/>
</div>

<div align="right">
  Türkçe | <a href="./Other Readmes/en/Readme.en.md" target="_blank">English</a>
</div>

## İçindekiler  

- [Uygulama Hakkında](#uygulama-hakkında)
- [Ekran Görüntüleri](#ekran-görüntüleri)
  <!-- videoyu buraya ekle -->
- [Kullanılan Mimari Yapı, Teknoloji ve Kütüphaneler](#kullanılan-mimari-yapı-teknoloji-ve-kütüphaneler)
- [Katmanlar](#katmanlar)
- [Test Edilen Sürümler](#test-edilen-sürümler)
- [Uygulamayı Çalıştırma](#uygulamayı-çalıştırma)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)
- [İletişim](#i̇letişim)


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Uygulama Hakkında

<table>
  <tr>
    <th style="text-align: left; font-weight: bold;">İşletim Sistemi</th>
    <td style="text-align: left;">Android</td>
  </tr>
  <tr>
    <th style="text-align: left; font-weight: bold;">Uygulama Türü</th>
    <td style="text-align: left;">Mobil</td>
  </tr>
  <tr>
    <th style="text-align: left; font-weight: bold;">Kullanılan İzinler</th>
    <td style="text-align: left;">INTERNET<br>POST_NOTIFICATIONS<br>FOREGROUND_SERVICE<br>FOREGROUND_SERVICE_DATA_SYNC</td>
  </tr>
</table>

<br>

Bu uygulama ile hızlı bir şekilde not alabilir, notlarınıza renk ekleyebilir ve hatta istediğiniz notu favorilerinize ekleyebilirsiniz.
Kaydettiğiniz notları farklı sıralama şekilleri ile sıralayabilir, dilerseniz uygulama dilini değiştirebilir ve uygulama içinden
diğer ayarlarla uygulama görünümünü özelleştirebilirsiniz.


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Ekran Görüntüleri

Ekran görüntüleri uygulamanın `v1.0.0` sürümünden alınmıştır. Yeni sürümlerde arayüz tamamen yada kısmi olarak değiştirilmiş olabilir.

<details>
  <summary>Ana Ekran</summary>
  
  | ![Ekran Görüntüsü 1](./Readme%20Resources/Ekran%20Görüntüleri/Ana%201.jpg) | ![Ekran Görüntüsü 2](./Readme%20Resources/Ekran%20Görüntüleri/Ana%202.jpg) | ![Ekran Görüntüsü 3](./Readme%20Resources/Ekran%20Görüntüleri/Ana%203.jpg) |
  | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
  | ![Ekran Görüntüsü 4](./Readme%20Resources/Ekran%20Görüntüleri/Ana%204.jpg) | ![Ekran Görüntüsü 5](./Readme%20Resources/Ekran%20Görüntüleri/Ana%205.jpg) | ![Ekran Görüntüsü 6](./Readme%20Resources/Ekran%20Görüntüleri/Ana%206.jpg) |
  
</details>

<details>
  <summary>Ekle/Düzenle Ekranı</summary>
  
  | ![Ekran Görüntüsü 7](./Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%201.jpg)  | ![Ekran Görüntüsü 8](./Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%202.jpg) | ![Ekran Görüntüsü 9](./Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%203.jpg) |
  | -------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
  | ![Ekran Görüntüsü 10](./Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%204.jpg) |                                                                                       |                                                                                       |
  
</details> 

<details>
  <summary>Ayarlar Ekranı</summary>
  
  | ![Ekran Görüntüsü 11](./Readme%20Resources/Ekran%20Görüntüleri/Ayarlar%201.jpg) | ![Ekran Görüntüsü 12](./Readme%20Resources/Ekran%20Görüntüleri/Ayarlar%202.jpg) |
  | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
  
</details>   

<details>
  <summary>Hakkında Ekranı</summary>
  
  | ![Ekran Görüntüsü 13](./Readme%20Resources/Ekran%20Görüntüleri/Hakkında%201.jpg) | ![Ekran Görüntüsü 14](./Readme%20Resources/Ekran%20Görüntüleri/Hakkında%202.jpg) |
  | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
  
</details>   


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Kullanılan Mimari Yapı, Teknoloji ve Kütüphaneler

- `MVVM + Clean Architecture`
- `Jetpack Compose`
- `Android Jetpack` 
  - Navigation
  - Flow
  - Lifecycle
  - Room
  - KSP
  - Serialization
  - Splash Sreen
  - Data Store
  - Coroutines
  - Hilt
  - Material Design
- `Detekt`
- `Retrofit`
- `Coil`
- `Sonner`
- `Ketch`
- `Github API`
- `ProGuard`

[libs.versions.toml](./AppSource/gradle/libs.versions.toml)

[**Kök Dizin** build.gradle.kts](./AppSource/build.gradle.kts)

[**Uygulama Modülü** build.gradle.kts](./AppSource/app/build.gradle.kts)

![MVVM Mimari Yapısı](./Readme%20Resources/Mimari/MVVM.png)


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Katmanlar

<table>
  <tr>
    <th style="text-align: center;">Data Layer</th>
    <th style="text-align: center;">Domain Layer</th>
    <th style="text-align: center;">UI Layer</th>
  </tr>
  <tr>
    <td style="text-align: center;">Veri Yönetimi</td>
    <td style="text-align: center;">İş Mantığı</td>
    <td style="text-align: center;">Kullanıcı Arayüzü</td>
  </tr>
  <tr>
    <td style="text-align: center;">Room Database<br>Retrofit<br>Data Store</td>
    <td style="text-align: center;">Use Case<br>Repository<br>Interface<br>Model</td>
    <td style="text-align: center;">Compose<br>ViewModel<br>Event<br>State</td>
  </tr>
</table>


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Test Edilen Sürümler

<table>
  <tr>
    <td style="text-align: left;">Android 8.1 Oreo</td>
    <td style="text-align: left;">API 27</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 9 Pie</td>
    <td style="text-align: left;">API 28</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 10</td>
    <td style="text-align: left;">API 29</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 11</td>
    <td style="text-align: left;">API 30</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 12</td>
    <td style="text-align: left;">API 31</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 12L</td>
    <td style="text-align: left;">API 32</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 13</td>
    <td style="text-align: left;">API 33</td>
    <td style="text-align: left;">✅️</td>
  </tr>
  <tr>
    <td style="text-align: left;">Android 14</td>
    <td style="text-align: left;">API 34</td>
    <td style="text-align: left;">✅️</td>
  </tr>
</table>


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Uygulamayı Çalıştırma

- Uygulamanın proje dosyasını kendi bilgisayarınıza indirmek, kodları incelemek veya
  [lisans hakları](https://www.gnu.org/licenses/gpl-3.0.html) kapsamında [katkıda bulunabilmek](#katkıda-bulunma)
  için [git](https://git-scm.com) yüklü bir bilgisayarda projeyi indirmek istediğiniz dosya yoluna gidip terminalde
  ```
  git clone https://github.com/mustafatoktas/A_TakeNote.git
  ```
  komutunu çalıştırabilirsiniz.

- [Releases](https://github.com/mustafatoktas/A_TakeNote/releases) sayfasına gidip
  uygulamanın en güncel sürümünü indirebilirsiniz.


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Katkıda Bulunma

Projeye katkıda bulunmak isteyenler için katkı kuralları ve adımları [contributing.md dosyasında](./Contributing.md) açıklanmıştır.


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

<div align="center">
  <a href="https://github.com/mustafatoktas/W.BE_RepoVisitorCounterAPI" target="_blank"> <img src="https://toktasoft.com/api/github2/repo-visitor-counter.php?repo=2hkuemfzs8dv59c&show_repo_name=1&show_date=1&show_brand=0&txt_color=255,255,255&bg_color=45,52,58" alt="Repo Visitor Counter"/> </a>
</div>

<br>
  
<div align="center">
  <a href="https://buymeacoffee.com/mustafatoktas" target="_blank"> <img src="./Readme Resources/İletişim/Buy Me a Coffee.png" alt="Buy Me a Coffee" height="64"/> </a>
</div>


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## Lisans

```
Copyright 2024 Mustafa TOKTAŞ

Licensed under the GNU General Public License v3.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.gnu.org/licenses/gpl-3.0.html

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


![-----------------------------------------------------](./Readme%20Resources/Çizgi.png)

## İletişim

<a href="mailto:info@mustafatoktas.com"              target="_blank"> <img src="./Readme Resources/İletişim/Mail.png"     alt="Mail"     width="64"/> </a>
<a href="https://t.me/mustafatoktas00"               target="_blank"> <img src="./Readme Resources/İletişim/Telegram.png" alt="Telegram" width="64"/> </a>
<a href="https://www.linkedin.com/in/mustafatoktas/" target="_blank"> <img src="./Readme Resources/İletişim/LinkedIn.png" alt="LinkedIn" width="64"/> </a>

<p align="center">
  <a href="#readme-top"> <img src="./Readme Resources/Back to Top.png" alt="Back to Top" height="64"/> </a>
</p>
