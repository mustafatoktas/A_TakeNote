<h1 align="center">
Take Note<a name="readme-top"></a>
</h1>

<div align="center">
  <img src="../Readme Resources/Not Tut Logo.png" alt="Logo" width="120"/>
</div>

<div align="right">
  <a href="https://github.com/mustafatoktas/A_TakeNote">Türkçe</a> | English
</div>

## Contents  

- [About the Application](#about-the-application)
- [Screenshots](#screenshots)
- [Architecture, Technology and Libraries Used](#architecture-technology-and-libraries-used)
- [Layers](#layers)
- [Tested Versions](#tested-versions)
- [Cloning the Project and Inspecting the Code](#cloning-the-project-and-inspecting-the-code)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## About the Application

<table>
  <tr>
    <th>Operating System</th>
    <td>Android</td>
  </tr>
  <tr>
    <th>App Type</th>
    <td>Mobile</td>
  </tr>
  <tr>
    <th>Permissions</th>
    <td>INTERNET<br>POST_NOTIFICATIONS<br>FOREGROUND_SERVICE<br>FOREGROUND_SERVICE_DATA_SYNC</td>
  </tr>
</table>

<br>

With this application, you can quickly take notes add colors to your notes and even mark your favorite notes.
You can sort your saved notes in various ways, change the app's language if desired and customize the appearance of the application through the settings.


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Screenshots

Screenshots are taken from the `v1.0.0` version of the application. The interface may be fully or partially changed in newer versions.

<details>
  <summary>Home Screen</summary>
  
  | ![Home 1](../Readme%20Resources/Screenshots/Home%201.jpg) | ![Home 2](../Readme%20Resources/Screenshots/Home%202.jpg) | ![Home 3](../Readme%20Resources/Screenshots/Home%203.jpg) |
  | --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
  | ![Home 4](../Readme%20Resources/Screenshots/Home%204.jpg) | ![Home 5](../Readme%20Resources/Screenshots/Home%205.jpg) | ![Home 6](../Readme%20Resources/Screenshots/Home%206.jpg) |
  
</details>

<details>
  <summary>Add/Edit Screen</summary>
  
  | ![Add/Edit 1](../Readme%20Resources/Screenshots/Add%20Edit%201.jpg) | ![Add/Edit 2](../Readme%20Resources/Screenshots/Add%20Edit%202.jpg) | ![Add/Edit 3](../Readme%20Resources/Screenshots/Add%20Edit%203.jpg) |
  | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
  | ![Add/Edit 4](../Readme%20Resources/Screenshots/Add%20Edit%204.jpg) |                                                                     |                                                                     |
  
</details> 

<details>
  <summary>Settings Screen</summary>
  
  | ![Settings 1](../Readme%20Resources/Screenshots/Settings%201.jpg) | ![Settings 2](../Readme%20Resources/Screenshots/Settings%202.jpg) |
  | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
  
</details>   

<details>
  <summary>About Screen</summary>
  
  | ![About 1](../Readme%20Resources/Screenshots/About%201.jpg) | ![About 2](../Readme%20Resources/Screenshots/About%202.jpg) |
  | ----------------------------------------------------------- | ----------------------------------------------------------- |
  
</details>   


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Architecture, Technology and Libraries Used

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

[**Root** build.gradle.kts](../Project%20Source/build.gradle.kts)

[**App Module** build.gradle.kts](../Project%20Source/app/build.gradle.kts)

[libs.versions.toml](../Project%20Source/gradle/libs.versions.toml)

![MVVM Architecture](../Readme%20Resources/Architecture/MVVM.png)


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Layers

<table>
  <tr>
    <th>Data Layer</th>
    <th>Domain Layer</th>
    <th>UI Layer</th>
  </tr>
  <tr>
    <td align="center">Data Management</td>
    <td align="center">Business Logic</td>
    <td align="center">User Interface</td>
  </tr>
  <tr>
    <td align="center">Retrofit<br>Data Store<br>Room Database</td>
    <td align="center">Model<br>Interface<br>Use Case<br>Repository</td>
    <td align="center">State<br>Event<br>Compose<br>ViewModel</td>
  </tr>
</table>


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Tested Versions

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


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Cloning the Project and Inspecting the Code

To clone this repository, open a terminal on a computer with [Git](https://git-scm.com) installed
and run the following command:
```
git clone https://github.com/mustafatoktas/A_TakeNote.git
```

By cloning this repository, you can explore the project structure, discover the development
approaches and [contribute](#contributing) under the terms of the [GPL-3.0 license](https://www.gnu.org/licenses/gpl-3.0.html).


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Contributing

Contribution rules and steps for those who want to contribute to the project are explained in the [contributing file](./Contributing.en.md).


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

<div align="center">
  <a href="https://github.com/mustafatoktas/W.BE_RepoVisitorCounterAPI"><img src="https://toktasoft.com/api/repo-visitor-counter?repo=2hkuemfzs8dv59c&show_repo_name=1&show_date=1&show_brand=0&txt_color=209,215,224&bg_color=45,52,58" alt="Repo Visitor Counter"/></a>
</div>

<br>
  
<div align="center">
  <a href="https://buymeacoffee.com/mustafatoktas"><img src="../Readme Resources/Contact/Buy Me a Coffee.png" alt="Buy Me a Coffee" height="64"/></a>
</div>


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## License

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


![—————————————————————————————————————————————————](../Readme%20Resources/Line.png)

## Contact

<a href="mailto:info@mustafatoktas.com"             ><img src="../Readme Resources/Contact/Mail.png"     alt="Mail"     width="64"/></a>
<a href="https://t.me/mustafatoktas00"              ><img src="../Readme Resources/Contact/Telegram.png" alt="Telegram" width="64"/></a>
<a href="https://www.linkedin.com/in/mustafatoktas/"><img src="../Readme Resources/Contact/LinkedIn.png" alt="LinkedIn" width="64"/></a>

<div align="center">
  <a href="#readme-top"><img src="../Readme Resources/Back to Top.png" alt="Back to Top" height="64"/></a>
</div>
