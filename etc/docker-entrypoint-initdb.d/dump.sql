--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
ALTER TABLE public.film ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE public.film_id_seq;
DROP TABLE public.film;
SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: film; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.film (
    id integer NOT NULL,
    title text,
    director text,
    release_date date,
    votes integer,
    runtime integer,
    country text
);


ALTER TABLE public.film OWNER TO postgres;

--
-- Name: film_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.film_id_seq OWNER TO postgres;

--
-- Name: film_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.film_id_seq OWNED BY public.film.id;


--
-- Name: film id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film ALTER COLUMN id SET DEFAULT nextval('public.film_id_seq'::regclass);


--
-- Data for Name: film; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.film (id, title, director, release_date, votes, runtime, country) FROM stdin;
1	La Jetée	Chris Marker	1962-02-16	29	28	France
2	Ugetsu	Mizoguchi Kenji	1953-03-26	29	94	Japan
3	City Lights	Charlie Chaplin	1931-01-30	29	87	United States
4	Histoire(s) du cinéma	Jean-Luc Godard	1988-01-01	30	266	France
5	The Battle of Algiers	Gillo Pontecorvo	1966-08-31	30	120	Italy
6	Close-Up	Abbas Kiarostami	1990-01-01	31	98	Iran
7	Play Time	Jacques Tati	1967-12-16	31	124	France
8	Pierrot le fou	Jean-Luc Godard	1965-11-05	31	110	France
9	Gertrud	Carl Dreyer	1964-12-19	31	116	Denmark
10	Some Like It Hot	Billy Wilder	1959-03-29	31	121	United States
11	Pather Panchali	Satyajit Ray	1955-08-26	31	126	India
12	Journey to Italy	Roberto Rossellini	1954-09-07	32	105	Italy
13	La Dolce Vita	Federico Fellini	1960-02-05	32	180	Italy
14	The 400 Blows	François Truffaut	1959-05-04	33	99	France
15	Sátántangó	Béla Tarr	1004-02-08	34	432	Ungari
16	Jeanne Dielman, 23 quai du Commerce 1080 Bruxelles	Chantal Akerman	1975-05-14	34	201	Belgium
17	Psycho	Alfred Hitchcock	1960-06-16	34	109	United States
18	The General	Buster Keaton, Clyde Bruckman	1926-12-31	34	75	United States
19	Metropolis	Fritz Lang	1927-01-10	34	153	Germany
20	Bicycle Thieves	Vittoria De Sica	1948-11-24	37	93	Italy
21	Taxi Driver	Martin Scorsese	1976-02-08	38	113	United States
22	The Godfather Part II	Francis Ford Coppola	1974-12-12	38	200	United States
23	Shoah	Claude Lanzmann	1985-04-30	39	566	France
24	Stalker	Andrei Tarkovsky	1979-05-01	39	161	Soviet Union
25	Mulholland Dr	David Lynch	2001-05-16	40	146	United States
26	Andrei Rublev	Andrei Tarkovsky	1966-12-01	41	205	Soviet Union
27	Rashomon	Akira Kurosawa	1950-08-25	41	88	Japan
28	In the Mood for Love	Wong Kar-wai	2000-05-20	42	98	Hong Kong
29	Ordet	Carl Dreyer	1955-01-10	42	126	Denmark
30	The Godfather	Francis Ford Coppola	1972-03-15	43	177	United States
31	Contempt	Jean-Luc Godard	1963-12-20	43	101	France
32	L'Avventura	Michelangelo Antonioni	1960-05-15	43	143	Italy
33	Singin' in the Rain	Stanley Donen, Gene Kelly	1952-03-27	46	103	United States
34	Mirror	Andrei Tarkovsky	1975-03-07	47	106	Soviet Union
35	Persona	Ingmar Bergman	1966-08-31	48	84	Sweden
36	Seven Samurai	Akira Kurosawa	1954-04-26	48	207	Japan
37	Au hasard Balthazar	Robert Bresson	1966-05-25	49	95	France
38	Late Spring	Yasujiro Ozu	1949-09-19	50	108	Japan
39	Apocalypse Now	Francis Ford Coppola	1979-05-10	53	153	United States
40	Breathless	Jean-Luc Godard	1960-03-16	57	87	France
41	L'Atalante	Jean Vigo	1934-04-25	58	65	France
42	Battleship Potemkin	Sergei Eisenstein	1925-12-21	63	75	Soviet Union
43	8½	Federico Fellini	1963-02-14	64	138	Italy
44	The Passion of Joan of Arc	Carl Dreyer	1928-04-21	65	110	France
45	Man with a Movie Camera	Dziga Vertov	1929-01-08	68	68	Soviet Union
46	The Searchers	John Ford	1956-05-16	78	119	United States
47	2001: A Space Odyssey	Stanley Kubrick	1968-04-02	90	142	United States
48	Sunrise: A Song of Two Humans	FW Murnau	1927-09-23	93	95	United States
49	La Règle du jeu	Jean Renoir	1939-07-07	100	110	France
50	Tokyo Story	Yasujiro Ozu	1953-11-03	107	136	Japan
51	Citizen Kane	Orson Welles	1941-05-01	157	119	United States
52	Vertigo	Alfred Hitchcock	1958-05-09	191	128	United States
\.


--
-- Name: film_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.film_id_seq', 52, true);


--
-- Name: film film_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

