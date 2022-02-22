DROP TABLE IF EXISTS employee_details;

CREATE employee_details   (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100),
    email VARCHAR(100),
    address VARCHAR(150),
    telephone VARCHAR(50)
);