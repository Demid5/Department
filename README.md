## Spring application "Department employees". 

### 1. Create database.  

В качестве сервера бд в моем случае выступал докер контейнер MySql.
Скачать его образ можно с докер хаба с помощью следующей команды: `docker pull mysql`.  

В файле docker-compose.yml описаны все инструкции, необходимые для настройки и запуска бд. Запустите `docker-compose up -d`.

В случае использования другого сервера бд или использования других настроек подключения, необходимо изменить параметры **_spring.datasource...._** в файле **application.properties**.  

Скрипты для создания таблиц и заполнения таблицы Department данными находятся в файле **create_db.sql**.

### 2. Run application.

1) `mvn package` - для формирования jar файла
2) `java -jar target/Department-0.0.1-SNAPSHOT.jar` - запуск приложения, после можно переходить по ссылке [http://localhost:[номер порта]/](http://localhost:8080/)
