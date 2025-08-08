-- Schema for Sneaker Shop project

-- Таблица пользователей
CREATE TABLE all_users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    mail VARCHAR(255),
    phone_number VARCHAR(255),
    number_of_orders INTEGER DEFAULT 0,
    sum_orders INTEGER DEFAULT 0
);

-- Таблица кроссовок
CREATE TABLE sneakers (
    id SERIAL PRIMARY KEY,
    sneakers_name VARCHAR(255),
    count_of_sneakers INTEGER DEFAULT 0,
    sum_sneakers INTEGER DEFAULT 0
);

-- Таблица активных заказов
CREATE TABLE active_orders (
    id SERIAL PRIMARY KEY,
    id_client INTEGER NOT NULL,
    client_name VARCHAR(255),
    name_allsneakers VARCHAR(255),
    status VARCHAR(255),
    CONSTRAINT active_orders_id_client_fkey FOREIGN KEY (id_client)
        REFERENCES all_users (id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT active_orders_status_check CHECK (
        status IN (
            'Заказ поступил',
            'Сборка заказа',
            'Заказ отправлен',
            'Завершён'
        )
    )
);
