#language: ru

@all
Функционал: Создание командировок

  @tripTest
  Сценарий: Создание командировки с ошибками полей
    * Вводим логин "Taraskina Valeriya" и пароль "testing"
    * Жмем кнопку войти
    * Выбираем вкладку "Расходы"
    * Жмем подменю"Командировки"
    * Проверяем что открылось окно 'Командировки'
    * И жмем кнопку 'Создать командировку'
    * Проверяем что находимся на странице создания командировки
    * Раскрываем поле 'Подразделение'
    * И выбираем необходимое
    * Далее вибираем оганизацию и ставим чек-бокс 'Заказ билетов'
    * Заполняем поля
      | Город выбытия  | Нижний Новгород |
      | Город прибытия | Тамбов          |
      | Дата выезда    | 20.08.2024      |
      | Дата въезда    | 31.08.2024      |
    * Жмем кнопку 'Сохранить'
    * Проверяем что под полем появилось ожидаемое предупреждение "Список командируемых сотрудников не может быть пустым"