package com.mttch.admin.common;

public class StringConstants {

    public static class MailServersGrid {
        public static final String HOSTNAME = "Имя сервера";
        public static final String POP_PORT = "POP-порт";
        public static final String POP_SECURITY = "POP-security";
        public static final String SMTP_PORT = "SMTP-порт";
        public static final String SMTP_SECURITY = "SMTP-security";
        public static final String IP = "IP-порт";
        public static final String BASE_DIR = "Рабочая директория";
        public static final String STORAGE_NODE = "Хранилище";
        public static final String MAX_MAILBOXES = "Максимальный объём";
    }

    public static class XmppGrid {
        public static final String USERNAME = "Имя пользователя";
        public static final String NAME = "Имя";
        public static final String EMAIL = "Почтовый адрес";
    }


    public static class EmailServiceGrid {
        public static final String LOGIN = "Логин";
        public static final String MAILBOX = "Почтовый адрес";
        public static final String PASSWORD = "Пароль";
        public static final String QUOTA = "Квота";
        public static final String STORAGE = "Хранилище";
    }

    public static class AdminLogGrid {
        public static final String ID = "Id";
        public static final String CRYPTO_NUMBER = "Крипто-номер";
        public static final String DATE_TIME = "Время";
        public static final String ADMIN = "Администратор";
        public static final String USER_AGENT = "User Agent";
        public static final String EVENT = "Событие";
        public static final String IP = "IP-адрес";
    }

    public static class LicenseEventsGrid {
        public static final String ID = "Id";
        public static final String TIME = "Время";
        public static final String CRYPTO_NUMBER = "Крипто-номер";
        public static final String METHOD = "Метод";
        public static final String EVENT = "Событие";
        public static final String SERVER = "Сервер";
        public static final String DESCRIPTION = "Описание";
    }

    public static class AdministratorsGrid {
        public static final String ID = "Id";
        public static final String NAME = "Имя администратора";
        public static final String ONLINE  = "Онлайн";
        public static final String DELETE_ADMIN = "Удалить администратора";
        public static final String DELETE = "Удаление";

        public static final String ADD_ADMINISTRATOR_BUTTON = "Добавить администратора";
    }

    public static class UserGrid {
        public static final String CREATE_DATE = "Дата создания";
        public static final String RECEIVE_DATE = "Дата получения";
        public static final String FIRST_QUERY_DATE = "Первый запрос";
        public static final String CRYPTO_NUMBER = "Крипто-номер";
        public static final String LOGIN = "Логин";
        public static final String DEVICE_ID = "Id устройства";
        public static final String PLATFORM = "Платформа";
        public static final String PUSH_TOKEN = "Push-токен";
        public static final String LICENSE = "Лицензия";
        public static final String LINK_TABLE = "Таблица связок";

        public static final String LOAD_LICENSES_BUTTON = "Загрузить лицензии";
    }

    public static class LeftMenu {
        public static final String USERS = "Пользователи";
        public static final String SERVICES = "Сервисы";
        public static final String SIP = "SIP";
        public static final String EMAIL = "EMAIL";
        public static final String XMPP = "XMPP";
        public static final String SERVERS = "Серверы";
        public static final String ADMINISTRATION = "Администрирование";
        public static final String LOGS = "Логи";
        public static final String LICENSE_LOG = "Лицензии";
        public static final String ADMIN_LOG = "Администратор";
    }

    public static final String USERNAME = "Логин";
    public static final String PASSWORD = "Пароль";
    public static final String RETYPE_PASSWORD = "Повторите пароль";
    public static final String LOGIN = "Войти";

    public static final String LOGIN_TO_ACCESS_YOUR_ACCOUNT = "Вход в аккаунт";

    public static final String LOGOUT = "Выход";

    public static final String ROWS_PER_PAGE = "Записей на страницу:";
}
