# **Проект по автоматизации тестовых сценариев для сайта компании [VK](https://vk.com/)**
> ВКонтакте — крупнейшая социальная сеть в России и странах СНГ. Миссия компании 
— соединять людей, сервисы и компании, создавая простые и удобные инструменты коммуникации.
>
## :scroll: Содержание:

* <a href="#tools">Использованный стек технологий</a>
* <a href="#launch">Запуск автотестов</a>
* <a href="#build">Сборка в Jenkins</a>
* <a href="#allure">Пример Allure-отчета</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#notifications">Уведомления в Telegram с использованием бота</a>
* <a href="#video">Видео примера запуска тестов в Selenoid</a>

<a id="tools"></a>
## <a name="Использованный стек технологий"> :computer: **Использованный стек технологий** </a>

<p align="center">
<a href="https://www.jetbrains.com/idea/" target="_blank"><img width="6%" title="IntelliJ IDEA" src="src/test/resources/media/icons/IntelijIdea.svg"></a>
<a href="https://www.java.com/ru/" target="_blank"><img width="6%" title="Java" src="src/test/resources/media/icons/Java.svg"></a>
<a href="https://selenide.org/" target="_blank"><img width="6%" title="Selenide" src="src/test/resources/media/icons/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/" target="_blank"><img width="6%" title="Selenoid" src="src/test/resources/media/icons/Selenoid.svg"></a>
<a href="https://allurereport.org/" target="_blank"><img width="6%" title="Allure Report" src="src/test/resources/media/icons/AllureReport.svg"></a>
<a href="https://qameta.io/" target="_blank"><img width="5%" title="Allure TestOps" src="src/test/resources/media/icons/AllureTestOps.svg"></a>
<a href="https://gradle.org/" target="_blank"><img width="6%" title="Gradle" src="src/test/resources/media/icons/Gradle.svg"></a>
<a href="https://junit.org/junit5/" target="_blank"><img width="6%" title="JUnit5" src="src/test/resources/media/icons/JUnit5.svg"></a>
<a href="https://github.com/" target="_blank"><img width="6%" title="GitHub" src="src/test/resources/media/icons/Github.svg"></a>
<a href="https://www.jenkins.io/" target="_blank"><img width="6%" title="Jenkins" src="src/test/resources/media/icons/Jenkins.svg"></a>
<a href="https://telegram.org/" target="_blank"><img width="6%" title="Telegram" src="src/test/resources/media/icons/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira" target="_blank"><img width="5%" title="Jira" src="src/test/resources/media/icons/Jira.svg"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code>.
- В качестве сборщика проекта был использован - <code>Gradle</code>.
- Использованы фреймворки: <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://selenoid.autotests.cloud/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов прогона в <code>Telegram</code> при помощи бота.
- Реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>

### Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста

<a id="launch"></a>
## <a name="Запуск автотестов"> :arrow_forward: **Запуск автотестов** </a>

### Запуск тестов из терминала
```
gradle clean test
```
После выполнения команды, автотесты запускаются удаленно в <code>Selenoid</code>.

### Запуск тестов на удаленном браузере
```
gradle clean test -Denv=main
```
### При необходимости также можно переопределить параметры запуска:

```
clean test -Dtask=${TASK}
"-Dbrowser=${BROWSER}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-DwindowSize=${WINDOW_SIZE}"
"-Dselenide.remote=https://${AUTH}@${REMOTE_URL}/wd/hub"
```
### Параметры сборки

* <code>TASK</code> – запуск автотестов по определенному тегу, которым они отмечены. По-умолчанию - <code>all_tests</code>, который запускает все автотесты
* <code>BROWSER</code> – браузер, в котором будут запускаться автотесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут запускаться автотесты. По-умолчанию - <code>122.0</code>.
* <code>WINDOW_SIZE</code> – размер окна браузера, в котором будут запускаться автотесты. По-умолчанию - <code>1920x1080</code>.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться автотесты.

<a id="build"></a>
## <a name="Сборка в Jenkins"><img src="src/test/resources/media/icons/Jenkins.svg" title="Jenkins" width="4%"/> **Сборка в Jenkins** </a>
<p align="center">
<img title="Jenkins Build" src="src/test/resources/media/screenshots/Jenkins.png">
</p>

<a id="allure"></a>
## <a name="Пример Allure-отчета"><img src="src/test/resources/media/icons/AllureReport.svg" title="Allure Report" width="4%"/> **Пример Allure-отчета** </a>
### Overview

<p align="center">
<img title="Allure Overview" src="src/test/resources/media/screenshots/AllureReport-1.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Allure" src="src/test/resources/media/screenshots/AllureReport-2.png">
</p>

<a id="testops"></a>
## <a name="Интеграция с Allure TestOps"><img src="src/test/resources/media/icons/AllureTestOps.svg" width="4%"/> **Интеграция с Allure TestOps** </a>

- Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>. 
- Результат выполнения автотестов отображается в <code>Allure TestOps</code>. 
- На <code>Dashboard</code> в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps Dashboard" src="src/test/resources/media/screenshots/AllureTestOps.png">
</p>

<a id="jira"></a>
## <a name="Интеграция с Jira"><img src="src/test/resources/media/icons/Jira.svg" title="Jira" width="4%"/> **Интеграция с Jira** </a>

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие именно тест-кейсы были реализованы в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="src/test/resources/media/screenshots/Jira-1.png">
</p>

<p align="center">
<img title="Jira Task" src="src/test/resources/media/screenshots/Jira-2.png">
</p>

<a id="notifications"></a>
## <a name="Уведомления в Telegram с использованием бота"><img width="4%" style="vertical-align:middle" title="Telegram" src="src/test/resources/media/icons/Telegram.svg"> **Уведомления в Telegram с использованием бота** </a>

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом прогона.

<p align="center">
<img width="70%" title="Telegram Notifications" src="src/test/resources/media/screenshots/TelegramNotification.png">
</p>

<a id="video"></a>
## <a name="Видео примера запуска тестов в Selenoid"><img src="src/test/resources/media/icons/Selenoid.svg" title="Jira" width="4%"/> **Видео примера запуска тестов в Selenoid** </a>

К каждому автотесту в Allure-отчете сохраняется видео запуска автотеста после его завершения.
<p align="center">
  <img title="Selenoid Video" src="src/test/resources/media/screenshots/Video.gif">
</p>