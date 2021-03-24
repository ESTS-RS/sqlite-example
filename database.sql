CREATE TABLE contracts(
    id INT PRIMARY KEY,
    description TEXT NOT NULL,
    amount REAL NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE cashflows(
    id INT PRIMARY KEY,
    reference_date DATE NOT NULL,
    amount REAL NOT NULL,
    contract_id INT NOT NULL,
    foreign KEY(contract_id) REFERENCES contracts(id)
);

CREATE TABLE reports(
    id INT PRIMARY KEY,
    contract_id INT NOT NULL,
    reference_date DATE NOT NULL,
    state TEXT NOT NULL,
    foreign KEY(contract_id) REFERENCES contracts(id)
);

INSERT INTO contracts (id, description, amount, start_date, end_date) VALUES (1,'Contract 1',168317,'2019-03-01','2029-02-01');
INSERT INTO contracts (id, description, amount, start_date, end_date) VALUES (2,'Contract 2',545518,'2018-10-01','2024-04-01');
INSERT INTO contracts (id, description, amount, start_date, end_date) VALUES (3,'Contract 3',80415,'2017-01-01','2020-04-01');
INSERT INTO contracts (id, description, amount, start_date, end_date) VALUES (4,'Contract 4',507020,'2016-06-01','2021-10-01');
INSERT INTO contracts (id, description, amount, start_date, end_date) VALUES (5,'Contract 5',149001,'2015-04-01','2020-06-01');
