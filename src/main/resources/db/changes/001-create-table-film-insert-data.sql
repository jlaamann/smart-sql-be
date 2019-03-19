--liquibase formatted sql

--changeset johannes:001-create-table-film-insert-data
CREATE TABLE film(
                   id SERIAL PRIMARY KEY,
                   title TEXT,
                   director TEXT,
                   release_date DATE,
                   votes INTEGER,
                   runtime INTEGER,
                   country TEXT
);
insert into film (votes, title, director, release_date, runtime, country) values (29,'La Jetée', 'Chris Marker', to_date('16.02.1962', 'DD.MM.YYYY'), 28, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (29,'Ugetsu', 'Mizoguchi Kenji', to_date('26.03.1953', 'DD.MM.YYYY'), 94, 'Japan');
insert into film (votes, title, director, release_date, runtime, country) values (29,'City Lights', 'Charlie Chaplin', to_date('30.01.1931', 'DD.MM.YYYY'), 87, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (30,'Histoire(s) du cinéma', 'Jean-Luc Godard', to_date('01.01.1988', 'DD.MM.YYYY'), 266, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (30,'The Battle of Algiers', 'Gillo Pontecorvo', to_date('31.08.1966', 'DD.MM.YYYY'), 120, 'Italy');
insert into film (votes, title, director, release_date, runtime, country) values (31,'Close-Up', 'Abbas Kiarostami', to_date('01.01.1990', 'DD.MM.YYYY'), 98, 'Iran');
insert into film (votes, title, director, release_date, runtime, country) values (31,'Play Time', 'Jacques Tati', to_date('16.12.1967', 'DD.MM.YYYY'), 124, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (31,'Pierrot le fou', 'Jean-Luc Godard', to_date('05.11.1965', 'DD.MM.YYYY'), 110, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (31,'Gertrud', 'Carl Dreyer', to_date('19.12.1964', 'DD.MM.YYYY'), 116, 'Denmark');
insert into film (votes, title, director, release_date, runtime, country) values (31,'Some Like It Hot', 'Billy Wilder', to_date('29.03.1959', 'DD.MM.YYYY'), 121, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (31,'Pather Panchali', 'Satyajit Ray', to_date('26.08.1955', 'DD.MM.YYYY'), 126, 'India');
insert into film (votes, title, director, release_date, runtime, country) values (32,'Journey to Italy', 'Roberto Rossellini', to_date('07.09.1954', 'DD.MM.YYYY'), 105, 'Italy');
insert into film (votes, title, director, release_date, runtime, country) values (32,'La Dolce Vita', 'Federico Fellini', to_date('05.02.1960', 'DD.MM.YYYY'), 180, 'Italy');
insert into film (votes, title, director, release_date, runtime, country) values (33,'The 400 Blows', 'François Truffaut', to_date('04.05.1959', 'DD.MM.YYYY'), 99, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (34,'Sátántangó', 'Béla Tarr', to_date('08.02.1004', 'DD.MM.YYYY'), 432, 'Ungari');
insert into film (votes, title, director, release_date, runtime, country) values (34,'Jeanne Dielman, 23 quai du Commerce 1080 Bruxelles', 'Chantal Akerman', to_date('14.05.1975', 'DD.MM.YYYY'), 201, 'Belgium');
insert into film (votes, title, director, release_date, runtime, country) values (34,'Psycho', 'Alfred Hitchcock', to_date('16.06.1960', 'DD.MM.YYYY'), 109, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (34,'The General', 'Buster Keaton, Clyde Bruckman', to_date('31.12.1926', 'DD.MM.YYYY'), 75, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (34,'Metropolis', 'Fritz Lang', to_date('10.01.1927', 'DD.MM.YYYY'), 153, 'Germany');
insert into film (votes, title, director, release_date, runtime, country) values (37,'Bicycle Thieves', 'Vittoria De Sica', to_date('24.11.1948', 'DD.MM.YYYY'), 93, 'Italy');
insert into film (votes, title, director, release_date, runtime, country) values (38,'Taxi Driver', 'Martin Scorsese', to_date('08.02.1976', 'DD.MM.YYYY'), 113, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (38,'The Godfather Part II', 'Francis Ford Coppola', to_date('12.12.1974', 'DD.MM.YYYY'), 200, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (39,'Shoah', 'Claude Lanzmann', to_date('30.04.1985', 'DD.MM.YYYY'), 566, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (39,'Stalker', 'Andrei Tarkovsky', to_date('01.05.1979', 'DD.MM.YYYY'), 161, 'Soviet Union');
insert into film (votes, title, director, release_date, runtime, country) values (40,'Mulholland Dr', 'David Lynch', to_date('16.05.2001', 'DD.MM.YYYY'), 146, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (41,'Andrei Rublev', 'Andrei Tarkovsky', to_date('01.12.1966', 'DD.MM.YYYY'), 205, 'Soviet Union');
insert into film (votes, title, director, release_date, runtime, country) values (41,'Rashomon', 'Akira Kurosawa', to_date('25.08.1950', 'DD.MM.YYYY'), 88, 'Japan');
insert into film (votes, title, director, release_date, runtime, country) values (42,'In the Mood for Love', 'Wong Kar-wai', to_date('20.05.2000', 'DD.MM.YYYY'), 98, 'Hong Kong');
insert into film (votes, title, director, release_date, runtime, country) values (42,'Ordet', 'Carl Dreyer', to_date('10.01.1955', 'DD.MM.YYYY'), 126, 'Denmark');
insert into film (votes, title, director, release_date, runtime, country) values (43,'The Godfather', 'Francis Ford Coppola', to_date('15.03.1972', 'DD.MM.YYYY'), 177, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (43,'Contempt', 'Jean-Luc Godard', to_date('20.12.1963', 'DD.MM.YYYY'), 101, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (43,'L''Avventura', 'Michelangelo Antonioni', to_date('15.05.1960', 'DD.MM.YYYY'), 143, 'Italy');
insert into film (votes, title, director, release_date, runtime, country) values (46,'Singin'' in the Rain', 'Stanley Donen, Gene Kelly', to_date('27.03.1952', 'DD.MM.YYYY'), 103, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (47,'Mirror', 'Andrei Tarkovsky', to_date('07.03.1975', 'DD.MM.YYYY'), 106, 'Soviet Union');
insert into film (votes, title, director, release_date, runtime, country) values (48,'Persona', 'Ingmar Bergman', to_date('31.08.1966', 'DD.MM.YYYY'), 84, 'Sweden');
insert into film (votes, title, director, release_date, runtime, country) values (48,'Seven Samurai', 'Akira Kurosawa', to_date('26.04.1954', 'DD.MM.YYYY'), 207, 'Japan');
insert into film (votes, title, director, release_date, runtime, country) values (49,'Au hasard Balthazar', 'Robert Bresson', to_date('25.05.1966', 'DD.MM.YYYY'), 95, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (50,'Late Spring', 'Yasujiro Ozu', to_date('19.09.1949', 'DD.MM.YYYY'), 108, 'Japan');
insert into film (votes, title, director, release_date, runtime, country) values (53,'Apocalypse Now', 'Francis Ford Coppola', to_date('10.05.1979', 'DD.MM.YYYY'), 153, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (57,'Breathless', 'Jean-Luc Godard', to_date('16.03.1960', 'DD.MM.YYYY'), 87, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (58,'L''Atalante', 'Jean Vigo', to_date('25.04.1934', 'DD.MM.YYYY'), 65, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (63,'Battleship Potemkin', 'Sergei Eisenstein', to_date('21.12.1925', 'DD.MM.YYYY'), 75, 'Soviet Union');
insert into film (votes, title, director, release_date, runtime, country) values (64,'8½', 'Federico Fellini', to_date('14.02.1963', 'DD.MM.YYYY'), 138, 'Italy');
insert into film (votes, title, director, release_date, runtime, country) values (65,'The Passion of Joan of Arc', 'Carl Dreyer', to_date('21.04.1928', 'DD.MM.YYYY'), 110, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (68,'Man with a Movie Camera', 'Dziga Vertov', to_date('08.01.1929', 'DD.MM.YYYY'), 68, 'Soviet Union');
insert into film (votes, title, director, release_date, runtime, country) values (78,'The Searchers', 'John Ford', to_date('16.05.1956', 'DD.MM.YYYY'), 119, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (90,'2001: A Space Odyssey', 'Stanley Kubrick', to_date('02.04.1968', 'DD.MM.YYYY'), 142, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (93,'Sunrise: A Song of Two Humans', 'FW Murnau', to_date('23.09.1927', 'DD.MM.YYYY'), 95, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (100,'La Règle du jeu', 'Jean Renoir', to_date('07.07.1939', 'DD.MM.YYYY'), 110, 'France');
insert into film (votes, title, director, release_date, runtime, country) values (107,'Tokyo Story', 'Yasujiro Ozu', to_date('03.11.1953', 'DD.MM.YYYY'), 136, 'Japan');
insert into film (votes, title, director, release_date, runtime, country) values (157,'Citizen Kane', 'Orson Welles', to_date('01.05.1941', 'DD.MM.YYYY'), 119, 'United States');
insert into film (votes, title, director, release_date, runtime, country) values (191,'Vertigo', 'Alfred Hitchcock', to_date('09.05.1958', 'DD.MM.YYYY'), 128, 'United States');
