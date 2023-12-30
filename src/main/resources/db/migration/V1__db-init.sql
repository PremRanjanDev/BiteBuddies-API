CREATE TABLE restaurants (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255),
  imageUrl VARCHAR(255)
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  username VARCHAR(255) NOT NULL,
  password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE sessions (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  event_date DATE,
  initiated_by INT NOT NULL REFERENCES users(id),
  picked_restaurant_id INT REFERENCES restaurants(id),
  visibility VARCHAR(10) DEFAULT 'Private' CHECK (visibility IN ('Public', 'Private')),
  active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

