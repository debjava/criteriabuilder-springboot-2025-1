CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INTEGER CHECK (age > 0),
    salary NUMERIC(10, 2),
    designation VARCHAR(100),
    city VARCHAR(100),
    status VARCHAR(20) CHECK (status IN ('Active', 'Inactive', 'On Leave')),
    email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Ananya Mishra', 31, 68000.00, 'UX Designer', 'Bhubaneswar', 'Active', 'ananya.mishra@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Debasis Rout', 45, 112000.00, 'Technical Architect', 'Cuttack', 'Active', 'debasis.rout@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Priya Sinha', 28, 59000.00, 'HR Executive', 'Rourkela', 'On Leave', 'priya.sinha@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Sourav Das', 34, 72000.00, 'Business Analyst', 'Kolkata', 'Active', 'sourav.das@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Ritika Sharma', 39, 98000.00, 'Marketing Manager', 'Delhi', 'Inactive', 'ritika.sharma@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Amitabh Sen', 50, 125000.00, 'VP of Sales', 'Mumbai', 'Active', 'amitabh.sen@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Neha Verma', 27, 61000.00, 'Content Strategist', 'Jaipur', 'Active', 'neha.verma@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Rajeev Nair', 41, 102500.00, 'Finance Controller', 'Kochi', 'On Leave', 'rajeev.nair@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Tanmay Patil', 36, 87000.00, 'DevOps Engineer', 'Pune', 'Active', 'tanmay.patil@example.com');

INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Swati Jha', 33, 76000.00, 'Legal Advisor', 'Ranchi', 'Inactive', 'swati.jha@example.com');

-- Junior Developer, Engineering
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Kunal Pradhan', 24, 48000.00, 'Junior Developer', 'Bhubaneswar', 'Active', 'kunal.pradhan@example.com');

-- Senior Developer, Engineering
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Sasmita Behera', 38, 98000.00, 'Senior Developer', 'Cuttack', 'Active', 'sasmita.behera@example.com');

-- Data Analyst, Analytics
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Rohit Nayak', 30, 72000.00, 'Data Analyst', 'Rourkela', 'On Leave', 'rohit.nayak@example.com');

-- Lead Designer, Design
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Ipsita Mohanty', 35, 85000.00, 'Lead Designer', 'Berhampur', 'Active', 'ipsita.mohanty@example.com');

-- HR Manager, Human Resources
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Manaswini Das', 40, 91000.00, 'HR Manager', 'Sambalpur', 'Inactive', 'manaswini.das@example.com');

-- Operations Executive, Operations
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Bibhu Ranjan', 29, 63000.00, 'Operations Executive', 'Balangir', 'Active', 'bibhu.ranjan@example.com');

-- Chief Technology Officer, Executive
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Satyabrata Mishra', 48, 150000.00, 'CTO', 'Bhubaneswar', 'Active', 'satyabrata.mishra@example.com');

-- Marketing Associate, Marketing
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Rashmi Ranjan', 26, 52000.00, 'Marketing Associate', 'Puri', 'Active', 'rashmi.ranjan@example.com');

-- Legal Consultant, Legal
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Chinmayee Panda', 37, 97000.00, 'Legal Consultant', 'Rayagada', 'On Leave', 'chinmayee.panda@example.com');

-- Customer Support Specialist, Support
INSERT INTO employee (name, age, salary, designation, city, status, email) VALUES
('Tapan Kumar', 32, 58000.00, 'Customer Support Specialist', 'Jharsuguda', 'Inactive', 'tapan.kumar@example.com');

select * from employee;

-- for Department and Project to learn the joining of multiple tables




