CREATE TABLE IF NOT EXISTS item (
    id SERIAL PRIMARY KEY NOT NULL,
    description VARCHAR(255),
    status VARCHAR(10),
    created_date TIMESTAMPTZ NOT NULL,
    last_modified_date TIMESTAMPTZ NOT NULL
    );