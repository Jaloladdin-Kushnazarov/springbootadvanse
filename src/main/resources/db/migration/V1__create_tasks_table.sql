CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR NOT NULL,
                       description VARCHAR,
                       label VARCHAR NOT NULL DEFAULT 'Backend',
                       created_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);