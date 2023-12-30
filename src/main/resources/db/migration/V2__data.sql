INSERT INTO users (name, username, password_hash)
values
('Prem', 'prem', '12345'),
('Ranjan', 'ranjan', '123456'),
('Someone', 'user1', '1234567');

INSERT INTO sessions (name, description, event_date, initiated_by)
values
('New Year', 'Lets celebrate new year 2024', CURRENT_DATE, 1);
('Johns Birthday', 'Lets celebrate Johns Birthday', CURRENT_DATE, 1),
('Release Celebration', 'Lets celebrate our last release', CURRENT_DATE, 1);


--COMMIT;