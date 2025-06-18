<h1 align="center">
Take Note<a name="readme-top"></a>
</h1>

<div align="center">
  <img src="./Readme Resources/Not Tut Logo.png" alt="Logo" width="120"/>
</div>

<div align="right">
Türkçe | <a href="./Other Readmes/Readme.en.md">English</a>
</div>

## İçindekiler  

- [Uygulama Hakkında](#uygulama-hakkında)
- [Ekran Görüntüleri](#ekran-görüntüleri)
  <!-- videoyu buraya ekle -->
- [Kullanılan Mimari Yapı, Teknoloji ve Kütüphaneler](#kullanılan-mimari-yapı-teknoloji-ve-kütüphaneler)
- [Katmanlar](#katmanlar)
- [Test Edilen Sürümler](#test-edilen-sürümler)
- [Projenin Klonlanması ve Kodların İncelenmesi](#projenin-klonlanması-ve-kodların-i̇ncelenmesi)
- [Katkıda Bulunma](#katkıda-bulunma)
- [Lisans](#lisans)
- [İletişim](#i̇letişim)


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Uygulama Hakkında

<table>
  <tr>
    <th>İşletim Sistemi</th>
    <td>Android</td>
  </tr>
  <tr>
    <th>Uygulama Türü</th>
    <td>Mobil</td>
  </tr>
  <tr>
    <th>İzinler</th>
    <td>INTERNET<br>POST_NOTIFICATIONS<br>FOREGROUND_SERVICE<br>FOREGROUND_SERVICE_DATA_SYNC</td>
  </tr>
</table>

<br>

Bu uygulama ile hızlı bir şekilde not alabilir, notlarınıza renk ekleyebilir ve hatta istediğiniz notu favorilerinize ekleyebilirsiniz.
Kaydettiğiniz notları farklı sıralama şekilleri ile sıralayabilir, dilerseniz uygulama dilini değiştirebilir ve uygulama içinden
diğer ayarlarla uygulama görünümünü özelleştirebilirsiniz.


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Ekran Görüntüleri

Ekran görüntüleri uygulamanın `v1.0.0` sürümünden alınmıştır. Yeni sürümlerde arayüz tamamen yada kısmi olarak değiştirilmiş olabilir.

<details>
  <summary>Ana Ekran</summary>
  
  | ![Ana Ekran 1](./Readme%20Resources/Screenshots/Home%201.jpg) | ![Ana Ekran 2](./Readme%20Resources/Screenshots/Home%202.jpg) | ![Ana Ekran 3](./Readme%20Resources/Screenshots/Home%203.jpg) |
  | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
  | ![Ana Ekran 4](./Readme%20Resources/Screenshots/Home%204.jpg) | ![Ana Ekran 5](./Readme%20Resources/Screenshots/Home%206.jpg) | ![Ana Ekran 6](./Readme%20Resources/Screenshots/Home%206.jpg) |
  
</details>

<details>
  <summary>Ekle/Düzenle Ekranı</summary>
  
  | ![Ekle/Düzenle 1](./Readme%20Resources/Screenshots/Add%20Edit%201.jpg) | ![Ekle/Düzenle 2](./Readme%20Resources/Screenshots/Add%20Edit%202.jpg) | ![Ekle/Düzenle 3](./Readme%20Resources/Screenshots/Add%20Edit%203.jpg) |
  | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- |
  | ![Ekle/Düzenle 4](./Readme%20Resources/Screenshots/Add%20Edit%204.jpg) |                                                                        |                                                                        |
  
</details> 

<details>
  <summary>Ayarlar Ekranı</summary>
  
  | ![Ayarlar 1](./Readme%20Resources/Screenshots/Settings%201.jpg) | ![Ayarlar 2](./Readme%20Resources/Screenshots/Settings%202.jpg) |
  | --------------------------------------------------------------- | --------------------------------------------------------------- |
  
</details>   

<details>
  <summary>Hakkında Ekranı</summary>
  
  | ![Hakkında 1](./Readme%20Resources/Screenshots/About%201.jpg) | ![Hakkında 2](./Readme%20Resources/Screenshots/About%202.jpg) |
  | ------------------------------------------------------------- | ------------------------------------------------------------- |
  
</details>   


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Kullanılan Mimari Yapı, Teknoloji ve Kütüphaneler

- MVVM + Clean Architecture
- Jetpack Compose
- Android Jetpack
  - Navigation
  - Flow
  - Lifecycle
  - Room
  - KSP
  - Serialization
  - Splash Screen
  - Data Store
  - Coroutines
  - Hilt
  - Material Design
- Detekt
- Retrofit
- Coil
- Sonner
- Ketch
- Github API
- ProGuard

[**Kök** build.gradle.kts](./Project%20Source/build.gradle.kts)

[**App Module** build.gradle.kts](./Project%20Source/app/build.gradle.kts)

[libs.versions.toml](./Project%20Source/gradle/libs.versions.toml)

![MVVM Mimari Yapısı](./Readme%20Resources/Architecture/MVVM.png)


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Katmanlar

<table>
  <tr>
    <th>Data Layer</th>
    <th>Domain Layer</th>
    <th>UI Layer</th>
  </tr>
  <tr>
    <td align="center">Veri Yönetimi</td>
    <td align="center">İş Mantığı</td>
    <td align="center">Kullanıcı Arayüzü</td>
  </tr>
  <tr>
    <td align="center">Retrofit<br>Data Store<br>Room Database</td>
    <td align="center">Model<br>Interface<br>Use Case<br>Repository</td>
    <td align="center">State<br>Event<br>Compose<br>ViewModel</td>
  </tr>
</table>


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Test Edilen Sürümler

<table>
  <tr>
    <td>Android 14</td>
    <td>API 34</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 13</td>
    <td>API 33</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 12L</td>
    <td>API 32</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 12</td>
    <td>API 31</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 11</td>
    <td>API 30</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 10</td>
    <td>API 29</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 9 Pie</td>
    <td>API 28</td>
    <td>✅️</td>
  </tr>
  <tr>
    <td>Android 8.1 Oreo</td>
    <td>API 27</td>
    <td>✅️</td>
  </tr>
</table>


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Projenin Klonlanması ve Kodların İncelenmesi

Projeyi klonlamak için [Git](https://git-scm.com) yüklü bir bilgisayarda
terminali açarak aşağıdaki komutu çalıştırabilirsiniz:
```
git clone https://github.com/mustafatoktas/A_TakeNote.git
```

Bu repoyu klonlayarak proje yapısını inceleyebilir, geliştirme yöntemlerini
keşfedebilir ve [GPL-3.0 lisansı](https://www.gnu.org/licenses/gpl-3.0.html)
kapsamında [katkıda bulunabilirsiniz](#katkıda-bulunma).


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Katkıda Bulunma

Projeye katkıda bulunmak isteyenler için katkı kuralları ve adımları [contributing](./Contributing.md) dosyasında açıklanmıştır.


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

<div align="center">
  <a href="https://github.com/mustafatoktas/W.BE_RepoVisitorCounterAPI"><img src="https://toktasoft.com/api/repo-visitor-counter?repo=2hkuemfzs8dv59c&show_repo_name=1&show_date=1&show_brand=0&txt_color=209,215,224&bg_color=45,52,58" alt="Repo Visitor Counter"/></a>
</div>

<br>
  
<div align="center">
  <a href="https://buymeacoffee.com/mustafatoktas"><img src="./Readme Resources/Contact/Buy Me a Coffee.png" alt="Buy Me a Coffee" height="64"/></a>
</div>


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## Lisans

```
Copyright 2024-2025 Mustafa TOKTAŞ

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


![—————————————————————————————————————————————————](./Readme%20Resources/Line.png)

## İletişim

<a href="mailto:info@mustafatoktas.com"             ><img src="./Readme Resources/Contact/Mail.png"     alt="Mail"     width="64"/></a>
<a href="https://t.me/mustafatoktas00"              ><img src="./Readme Resources/Contact/Telegram.png" alt="Telegram" width="64"/></a>
<a href="https://www.linkedin.com/in/mustafatoktas/"><img src="./Readme Resources/Contact/LinkedIn.png" alt="LinkedIn" width="64"/></a>

<div align="center">
  <a href="#readme-top"><img src="./Readme Resources/Back to Top.png" alt="Back to Top" height="64"/></a>
</div>
