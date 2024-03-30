CREATE TABLE tariff_plan (
                             id BIGSERIAL NOT NULL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             price NUMERIC(10, 2) NOT NULL,
                             data_allowance NUMERIC(10, 2) NOT NULL
);