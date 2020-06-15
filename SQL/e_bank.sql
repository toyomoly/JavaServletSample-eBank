DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS history;

CREATE TABLE account (
    id SERIAL NOT NULL PRIMARY KEY,
    user_id TEXT NOT NULL,
    password TEXT NOT NULL,
    user_name TEXT NOT NULL,
    saving INTEGER NOT NULL
);

CREATE TABLE history (
    id SERIAL NOT NULL PRIMARY KEY,
    user_id TEXT NOT NULL,
    status INTEGER NOT NULL,
    price INTEGER NOT NULL,
    created_at timestamp
);

ALTER TABLE account OWNER TO student;
ALTER TABLE history OWNER TO student;

INSERT INTO account(user_id, password, user_name, saving) VALUES('aoki', 'stepstep', '青木 花子', 10000);
INSERT INTO account(user_id, password, user_name, saving) VALUES('akai', 'imissyou', '赤井 太郎', 0);

INSERT INTO history(user_id, status, price, created_at) VALUES('aoki', 1, 10000, '2020-05-29 14:00:00');
