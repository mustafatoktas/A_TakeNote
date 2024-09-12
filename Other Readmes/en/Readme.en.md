<h1 align="center">
  Take Note <a name="readme-top"></a>
</h1>

<div align="center">
  <img src="../../Readme Resources/Not Tut Logo.png" alt="Logo" width="120"/>
</div>

<div align="right">
  <a href="../../Readme.md" target="_blank">Türkçe</a> | English
</div>

## Contents  

- [About the Application](#about-the-application)
- [Screenshots](#screenshots)
- [Architecture, Technology and Libraries Used](#architecture-technology-and-libraries-used)
- [Layers](#layers)
- [Tested Versions](#tested-versions)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## About the Application

<table>
  <tr>
    <th style="text-align: left; font-weight: bold;">Operating System</th>
    <td style="text-align: left;">Android</td>
  </tr>
  <tr>
    <th style="text-align: left; font-weight: bold;">App Type</th>
    <td style="text-align: left;">Mobile</td>
  </tr>
  <tr>
    <th style="text-align: left; font-weight: bold;">Permissions Used</th>
    <td style="text-align: left;">INTERNET<br>POST_NOTIFICATIONS<br>FOREGROUND_SERVICE<br>FOREGROUND_SERVICE_DATA_SYNC</td>
  </tr>
</table>

<br>

With this application, you can quickly take notes add colors to your notes and even mark your favorite notes.
You can sort your saved notes in various ways, change the app's language if desired and customize the appearance of the application through the settings.


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Screenshots

Screenshots are taken from the `v1.0.0` version of the application. The interface may be fully or partially changed in newer versions.

<details>
  <summary>Home Screen</summary>
  
  | ![Screenshot 1](../../Readme%20Resources/Ekran%20Görüntüleri/Ana%201.jpg) | ![Screenshot 2](../../Readme%20Resources/Ekran%20Görüntüleri/Ana%202.jpg) | ![Screenshot 3](../../Readme%20Resources/Ekran%20Görüntüleri/Ana%203.jpg) |
  | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
  | ![Screenshot 4](../../Readme%20Resources/Ekran%20Görüntüleri/Ana%204.jpg) | ![Screenshot 5](../../Readme%20Resources/Ekran%20Görüntüleri/Ana%206.jpg) | ![Screenshot 6](../../Readme%20Resources/Ekran%20Görüntüleri/Ana%206.jpg) |
  
</details>

<details>
  <summary>Add/Edit Screen</summary>
  
  | ![Screenshot 7](../../Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%201.jpg)  | ![Screenshot 8](../../Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%202.jpg) | ![Screenshot 9](../../Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%203.jpg) |
  | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------ |
  | ![Screenshot 10](../../Readme%20Resources/Ekran%20Görüntüleri/Ekle%20Düzenle%204.jpg) |                                                                                      |                                                                                      |
  
</details> 

<details>
  <summary>Settings Screen</summary>
  
  | ![Screenshot 11](../../Readme%20Resources/Ekran%20Görüntüleri/Ayarlar%201.jpg) | ![Screenshot 12](../../Readme%20Resources/Ekran%20Görüntüleri/Ayarlar%202.jpg) |
  | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
  
</details>   

<details>
  <summary>About Screen</summary>
  
  | ![Screenshot 13](../../Readme%20Resources/Ekran%20Görüntüleri/Hakkında%201.jpg) | ![Screenshot 14](../../Readme%20Resources/Ekran%20Görüntüleri/Hakkında%202.jpg) |
  | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
  
</details>   


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Architecture, Technology and Libraries Used

- `MVVM + Clean Architecture`
- `Jetpack Compose`
- `Android Jetpack` 
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
- `Detekt`
- `Retrofit`
- `Coil`
- `Sonner`
- `Ketch`
- `Github API`
- `ProGuard`

[libs.versions.toml](../../AppSource/gradle/libs.versions.toml)

[**Root Directory** build.gradle.kts](../../AppSource/build.gradle.kts)

[**App Module** build.gradle.kts](../../AppSource/app/build.gradle.kts)

![MVVM Architecture](../../Readme%20Resources/Mimari/MVVM.png)


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Layers

<table>
  <tr>
    <th style="text-align: center;">Data Layer</th>
    <th style="text-align: center;">Domain Layer</th>
    <th style="text-align: center;">UI Layer</th>
  </tr>
  <tr>
    <td style="text-align: center;">Data Management</td>
    <td style="text-align: center;">Business Logic</td>
    <td style="text-align: center;">User Interface</td>
  </tr>
  <tr>
    <td style="text-align: center;">Room Database<br>Retrofit<br>Data Store</td>
    <td style="text-align: center;">Use Case<br>Repository<br>Interface<br>Model</td>
    <td style="text-align: center;">Compose<br>ViewModel<br>Event<br>State</td>
  </tr>
</table>


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Tested Versions

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


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Running the Application

- To download the project files to your computer, review the code or [contribute](#contributing) under the
  [license rights](https://www.gnu.org/licenses/gpl-3.0.html), go to the directory where you want to download the project
  on a computer with [git](https://git-scm.com) installed and run the following command in the terminal:
  ```
  git clone https://github.com/mustafatoktas/A_TakeNote.git
  ```

- You can visit the [releases](https://github.com/mustafatoktas/A_TakeNote/releases) page to download the latest version of the application.


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Contributing

Contribution rules and steps for those who want to contribute to the project are explained in the [contributing.md file](./Contributing.en.md).


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

<div align="center">
  <a href="https://github.com/mustafatoktas/W.BE_RepoVisitorCounterAPI" target="_blank"> <img src="https://toktasoft.com/api/github2/repo-visitor-counter.php?repo=2hkuemfzs8dv59c&show_repo_name=1&show_date=1&show_brand=0&txt_color=255,255,255&bg_color=45,52,58" alt="Repo Visitor Counter"/> </a>
</div>

<br>
  
<div align="center">
  <a href="https://buymeacoffee.com/mustafatoktas" target="_blank"> <img src="../../Readme Resources/İletişim/Buy Me a Coffee.png" alt="Buy Me a Coffee" height="64"/> </a>
</div>


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## License

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


![-----------------------------------------------------](../../Readme%20Resources/Çizgi.png)

## Contact

<a href="mailto:info@mustafatoktas.com"              target="_blank"> <img src="../../Readme Resources/İletişim/Mail.png"     alt="Mail"     width="64"/> </a>
<a href="https://t.me/mustafatoktas00"               target="_blank"> <img src="../../Readme Resources/İletişim/Telegram.png" alt="Telegram" width="64"/> </a>
<a href="https://www.linkedin.com/in/mustafatoktas/" target="_blank"> <img src="../../Readme Resources/İletişim/LinkedIn.png" alt="LinkedIn" width="64"/> </a>

<p align="center">
  <a href="#readme-top"> <img src="../../Readme Resources/Back to Top.png" alt="Back to Top" height="64"/> </a>
</p>
