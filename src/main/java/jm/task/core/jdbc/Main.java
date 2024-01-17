package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Создание таблицы User(ов)
        userService.createUsersTable();

        // Добавление 4 User(ов) в таблицу
        userService.saveUser("John", "Doe", (byte) 25);
        userService.saveUser("Jane", "Smith", (byte) 30);
        userService.saveUser("Bob", "Johnson", (byte) 22);
        userService.saveUser("Alice", "Williams", (byte) 28);

        // Получение всех User из базы и вывод в консоль
       System.out.println("Список всех пользователей:");
        userService.getAllUsers().forEach(System.out::println);

        // Очистка таблицы User(ов)
        System.out.println("Таблица очищена");
        userService.cleanUsersTable();

        // Удаление таблицы User(ов)
        System.out.println("Таблица удалена");
        userService.dropUsersTable();
    }
}



