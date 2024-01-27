package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

        // Создание таблицы User(ов)
        userDao.createUsersTable();

        // Добавление 4 User(ов) в таблицу
        userDao.saveUser("Валико", "Мизандари", (byte) 35);
        userDao.saveUser("Рубен", "Хачикян", (byte) 30);
        userDao.saveUser("Лариса", "Ивановна", (byte) 22);
        userDao.saveUser("Alice", "Williams", (byte) 28);

        // Получение всех User из базы и вывод в консоль
       System.out.println("Список всех пользователей:");
        userDao.getAllUsers().forEach(System.out::println);

        // Очистка таблицы User(ов)
        System.out.println("Таблица очищена.");
        userDao.cleanUsersTable();

        // Удаление таблицы User(ов)
        System.out.println("Таблица удалена.");
        userDao.dropUsersTable();
    }
}



