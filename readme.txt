Для запуска проекта необходимо установить:

1) Java SE Development Kit 8u172 for Windows (http://www.oracle.com/technetwork/java//jdk8-downloads-2133151.html)
2) Gradle-4.7
    a) https://gradle.org/releases/
    b) Выбираем v4.7 complete
    с) Разархивируем в нужную директорию
    d) Как указано ниже в инструкции, для удобства использования через Command Line добавить в Path путь к bin директории gradle
3) Базу данных HSQLDB-2.4.0
    a) https://sourceforge.net/projects/hsqldb/files/
    b) скачиваем версию 2.4.0 - latest
    с) разархивируем в нужную директорию

Для ввода команд взаимодействия с приложением и базой данных:
1) переходим в папку trainingtask
2) Открываем командную строку

Запуск базы данных:
1) gradle startDatabase
2) gradle createTables
3) gradle fillTables

Запуск приложения с сервером:
1) gradle appStart
2) Приложение запускается. Доступ осуществляется по незанятому порту 8080 в браузере по адресу http://localhost:8080

Остановка приложения:
1) Из командной строки, где запускали приложение, пишем команду "gradle appStop" либо "Ctrl" + "C" и выбираем "Y"

Команды для работы с базой данных:
1) gradle startDatabase - создание базы данных и подключение к ней
2) gradle stopDatabase - отключение от базы данных
3) gradle createTables - создание таблиц
4) gradle fillTables - заполнение данными таблиц
5) gradle dropTables - удаление таблиц