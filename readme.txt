Для запуска проекта необходимо установить:

1) Java SE Development Kit 8u172 for Windows ( http://www.oracle.com/technetwork/java//jdk8-downloads-2133151.html )
2) Базу данных HSQLDB-2.4.0
    a) https://sourceforge.net/projects/hsqldb/files/
    b) скачиваем версию 2.4.0 - latest
    с) разархивируем в нужную директорию

Для ввода команд взаимодействия с приложением и базой данных:
1) переходим в папку trainingtask
2) Открываем командную строку

Порядок запуска приложения:
1) gradlew startDatabase
2) gradlew createTables
3) gradlew fillTables
4) gradlew appStart
5) Приложение запускается. Доступ осуществляется по незанятому порту 8080 в браузере по адресу http://localhost:8080

Остановка приложения:
1) Из командной строки, где запускали приложение, пишем команду "gradlew appStop" либо "Ctrl" + "C" и выбираем "Y"

Команды для работы с базой данных:
1) gradlew startDatabase - создание базы данных и подключение к ней
2) gradlew stopDatabase - отключение от базы данных
3) gradlew createTables - создание таблиц
4) gradlew fillTables - заполнение данными таблиц
5) gradlew dropTables - удаление таблиц