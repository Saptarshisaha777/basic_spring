CREATE TABLE IF NOT EXISTS customer (
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  mobile_number VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(255) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(255) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
  customer_id INT NOT NULL,
  account_no INT AUTO_INCREMENT PRIMARY KEY,
  branch_address VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(255) NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(255) DEFAULT NULL,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);