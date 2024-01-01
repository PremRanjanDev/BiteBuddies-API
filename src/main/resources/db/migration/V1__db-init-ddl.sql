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
  starts_at TIMESTAMP,
  initiated_by INT NOT NULL REFERENCES users(id),
  picked_restaurant_id INT REFERENCES restaurants(id),
  active BOOLEAN DEFAULT TRUE,
  deleted BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE session_restaurants (
  session_id INT NOT NULL REFERENCES sessions(id),
  restaurant_id INT NOT NULL REFERENCES restaurants(id),
  PRIMARY KEY (session_id, restaurant_id)
);

CREATE TABLE session_users (
  session_id INT NOT NULL REFERENCES sessions(id),
  user_id INT NOT NULL REFERENCES users(id),
  status VARCHAR(10) NOT NULL DEFAULT 'invited' CHECK (status IN ('invited', 'joined')),
  invited_at TIMESTAMP,
  joined_at TIMESTAMP,
  PRIMARY KEY (session_id, user_id)
);
