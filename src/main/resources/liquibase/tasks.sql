CREATE TABLE tasks (
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(150)       NOT NULL,
    description VARCHAR(250),
    category    VARCHAR(150)       NOT NULL,
    deadline    DATE,
    priority    INTEGER DEFAULT 10 NOT NULL,
    status      VARCHAR(150)       NOT NULL,
    pending     BOOLEAN            NOT NULL,
    display     BOOLEAN            NOT NULL,
    created_at  DATE               NOT NULL,
    creator_id  VARCHAR(150)       NOT NULL
);