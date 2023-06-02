# Проект книжная библиотека
## Задачи проекта
1) Страницы добавления, изменения и удаления пользователя/книг.
2) Страница со списком всех пользователей/книг (объекты кликабельные - при клике осуществляется
   переход на страницу человека).
3) Страница человека, на которой показаны значения его полей и список книг, которые он
   взял. Если человек не взял ни одной книги, вместо списка должен быть текст, сообщающий об этом.
4) Страница книги, на которой показаны значения полей этой книги и имя человека,
   который взял эту книгу. Если эта книга не была никем взята, должен быть текст, сообщающий об этом.
5) На странице книги, если книга взята человеком, рядом с его именем должна быть кнопка
   "Освободить книгу". Эта кнопка нажимается библиотекарем тогда, когда читатель
   возвращает эту книгу обратно в библиотеку. После нажатия на эту кнопку книга снова
   становится свободно и пропадает из списка книг человека.
6) На странице книги, если книга свободна, должен быть выпадающий список (\<select\>)
   со всеми людьми и кнопка "Назначить книгу". Эта кнопка нажимается библиотекарем
   тогда, когда читатель хочет забрать эту книгу домой. После нажатия на эту кнопку, книга
   должна начать принадлежать выбранному человеку и должна появится в его списке
   книг.
7) Все поля должны валидироваться с помощью @Valid и Spring Validator, если это
   требуется.
## Навыки и инструменты необходимые для выполнения проекта
1) Java Core
2) Tomcat (запуск сервера)
3) Spring Boot (зависимости, аннотации)
4) Thymeleaf (HTTP-методы, модели)
5) Базовый HTML
6) Класс JdbcTemplate
7) SQL (PostgreSQL, защита от sql-инъекций, primary/foreign key, валидация)
8) XML (контроль версий зависимостей)
9) Валидация (@Valid и Spring Validator)
## Запуск проекта
1) Для успешного запуска проекта необходимо использовать IntelliJ IDEA Ultimate Edition и скачать Tomcat 11.0.0-M5
(актуальная версия на момент написания проекта).
2) Нажмите "Edit Configurations..." в разделе запуска проекта. Выберите Tomcat Local Server.
3) В разделе URL укажите следующую ссылку "http://localhost:8080/library"
4) Нажмите кнопку "fix", если она появилась выберте "exploded" вариант. Если среда этого не предложила, то самостоятельно перейдите в раздел "Deployment" и создайте war.exploded артифакт. 
5) Далее в любом случае зайдите в раздел "Deployment" и укажите пустую строку в "Application Context". 
6) Убедитесь, что зависимости из файла pom.xml были скачаны. Перейдите в файл и следуйте инструкциям среды, если
такие будут.
7) Подключитесь к PostgreSQL и создайте базу данных с любым именем.
8) Перейдите в файл src/main/resources/database.properties.origin и заполните указанный парметры. По умолчанию (без скобок):
   * driver=org.postgresql.Driver (не изменяется если БД PostgreSQL)
   * url=jdbc:postgresql://localhost:5432/BooksLibrary (BooksLibrary=название БД)
   * user=postgres (username в PostgreSQL)
   * password=postgres (password)
9) Перейдите в файл src/main/sql/dataBaseInfo.sql и запустите sql код, создающий 2 таблицы и данные для них.
10) Проект готов к запуску. Нажмите Shift+F10.


driver=org.postgresql.Driver
url=jdbc:postgresql://localhost:5432/BooksLibrary
user=postgres
password=123