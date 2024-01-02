INSERT INTO restaurants (name, location, image_url)
values
('Burger Buddies', '1 Cantonment Rd, #01-01, Singapore 080001', 'https://lh3.googleusercontent.com/p/AF1QipPffCwljlqVeOqvRfA16lEQ7LE4XYYDlQK-F-4R=s1360-w1360-h1020'),
('Fork n Spoon Restaurant', '13 Siglap Rd, Mandarin Gardens, Singapore 448911', 'https://lh5.googleusercontent.com/p/AF1QipNal24_u46oGaZeulxqObhV7StUANV7gr8M_JHY=w408-h306-k-no'),
('BPS.Cafe at East Coast Park', '1110 ECP, Singapore 449880', 'https://lh5.googleusercontent.com/p/AF1QipMemdm6EIqhH_7qG3MB6uJgS967GGLzFHYWEFuG=w408-h272-k-no'),
('Blu Kouzina Siglap', '907 E Coast Rd, #01-01, Singapore 459107', 'https://lh5.googleusercontent.com/p/AF1QipNLjIXwU4mR6N7548uu2lIwyCfnbxAMzpPjqaXl=w408-h272-k-no'),
('J.B. Ah Meng Restaurant', '534 Geylang Rd, Singapore 389490', 'https://lh5.googleusercontent.com/p/AF1QipNrhhzjqY8QB8DpHKJRTyBwhi561MrLfoIWbJM=w408-h306-k-no'),
('Zaffron Kitchen East Coast', '137 E Coast Rd, #135, Singapore 428820', 'https://lh5.googleusercontent.com/p/AF1QipPrWJpoWJv4xdZ6U3hRrMS3tZFTWFjPVtce2r7Z=w408-h272-k-no'),
('Quentin''s' 'the Eurasian Restaurant', '139 Ceylon Rd, Level 1 Eurasian Heritage Gallery, Singapore 429744', 'https://lh5.googleusercontent.com/p/AF1QipMwmLvStQfvxvMIy-CStDSAR5Nk_Y3bwk2Glfjz=w426-h240-k-no');

INSERT INTO users (name, username, password_hash)
values
('John', 'john', 'OnSL4EG5VTgOVMcEm8kaww=='), -- 12345
('Mark', 'mark', 'OnSL4EG5VTgOVMcEm8kaww=='),
('Prem', 'prem', 'OnSL4EG5VTgOVMcEm8kaww=='),
('Max', 'max', 'OnSL4EG5VTgOVMcEm8kaww=='),
('Rohit', 'rohit', 'OnSL4EG5VTgOVMcEm8kaww=='),
('Raj', 'raj', 'OnSL4EG5VTgOVMcEm8kaww==');

INSERT INTO sessions (name, description, starts_at, initiated_by, active, picked_restaurant_id)
values
('New Year Party', 'Lets celebrate new year 2024', CURRENT_TIMESTAMP + 2, 1, true, null),
('John''s Birthday', 'Lets celebrate Johns Birthday', CURRENT_TIMESTAMP + 5, 2, false, 5),
('Release Celebration', 'Lets celebrate our last release', null, 3, true, null);

INSERT INTO session_users (session_id, user_id, status)
values
(1, 1, 'joined'),
(1, 2, 'invited'),
(1, 3, 'invited'),
(2, 2, 'invited'),
(2, 1, 'joined');

INSERT INTO session_restaurants (session_id, restaurant_id, submitted_by)
values
(1, 1, 1),
(1, 2, 2),
(1, 3, 4),
(2, 2, 5),
(2, 1, 6);
