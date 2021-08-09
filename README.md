# BookStorage2.0
Передо мной стояла задача по реализации консольного CRUD приложения, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:
<p>Writer(id, name, List<Post> posts)</p>
<p>Post(id, content, Long created, Long updated, List<Label> labels)</p>
<p>Label(id, name)</p>
<p>PostStatus (enum ACTIVE, DELETED)</p>
<hr>

Слои:
<p>model - POJO классы</p>
<p>dao - классы, реализующие доступ к базе данных</p>
<p>controller - обработка запросов от пользователя</p>
<p>service - обработка запросов от пользователя</p>
<p>view - все данные, необходимые для работы с консолью</p>

<hr>
Требования к приложению:
<ol>
  <li>Придерживаться шаблона MVC (пакеты model, repository, service, controller, view)</li>
  <li>Для взаимодействия с БД использовать Hibernate</li>
  <li>Для конфигурирования Hibernate использовать аннотации</li>
  <li>Инициализация БД должна быть реализована с помощью flyway</li>
  <li>Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito)</li>
  <li>Для импорта библиотек использовать Maven</li>
</ol>

<hr>

Технологии: JavaSE8+, MySQL, Hibernate, Maven, Flyway, JUnit, Mockito.
