--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-06-24 13:08:56

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 18728)
-- Name: corpus; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.corpus (
    id integer NOT NULL,
    name character varying NOT NULL,
    location character varying,
    faculty_id integer
);


ALTER TABLE public.corpus OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 18733)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id integer NOT NULL,
    name character varying NOT NULL,
    faculty_id integer NOT NULL
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 18738)
-- Name: faculty; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.faculty (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.faculty OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 18743)
-- Name: floor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.floor (
    id integer NOT NULL,
    height numeric NOT NULL
);


ALTER TABLE public.floor OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 18748)
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    id integer NOT NULL,
    number integer,
    name character varying,
    corpus_id integer,
    width numeric,
    length numeric,
    floor_number integer
);


ALTER TABLE public.room OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 18768)
-- Name: Все комнаты в корпусе; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."Все комнаты в корпусе" AS
 SELECT r.number,
    r.name
   FROM (public.room r
     JOIN public.corpus c ON ((r.corpus_id = c.id)))
  WHERE ((c.name)::text = 'Корпус А'::text);


ALTER VIEW public."Все комнаты в корпусе" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 18772)
-- Name: Количеств помещений в корпусах; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."Количеств помещений в корпусах" AS
 SELECT corpus.name,
    count(room.id) AS expr1
   FROM (public.corpus
     JOIN public.room ON ((room.corpus_id = corpus.id)))
  GROUP BY corpus.name;


ALTER VIEW public."Количеств помещений в корпусах" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 18776)
-- Name: Общая инфрмация по факультетам; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."Общая инфрмация по факультетам" AS
 SELECT name AS "Faculty name",
    ( SELECT count(*) AS expr1
           FROM public.department
          WHERE (department.faculty_id = f.id)) AS "Department count",
    ( SELECT count(*) AS expr1
           FROM public.corpus
          WHERE (corpus.faculty_id = f.id)) AS "Corpuses count",
    ( SELECT count(*) AS expr1
           FROM public.room
          WHERE (room.corpus_id IN ( SELECT corpus_1.id
                   FROM public.corpus corpus_1
                  WHERE (corpus_1.faculty_id = f.id)))) AS "Rooms count"
   FROM public.faculty f;


ALTER VIEW public."Общая инфрмация по факультетам" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 18780)
-- Name: Общая площадь всех помещений в кор; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."Общая площадь всех помещений в кор" AS
 SELECT c.name,
    sum((r.width * r.length)) AS "Total area"
   FROM (public.room r
     JOIN public.corpus c ON ((r.corpus_id = c.id)))
  GROUP BY c.name;


ALTER VIEW public."Общая площадь всех помещений в кор" OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 18784)
-- Name: Факультет количество корпусов; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public."Факультет количество корпусов" AS
 SELECT f.name AS "Faculty name",
    count(c.id) AS "Corpuses count"
   FROM (public.faculty f
     LEFT JOIN public.corpus c ON ((f.id = c.faculty_id)))
  GROUP BY f.name;


ALTER VIEW public."Факультет количество корпусов" OWNER TO postgres;

--
-- TOC entry 4871 (class 0 OID 18728)
-- Dependencies: 215
-- Data for Name: corpus; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.corpus (id, name, location, faculty_id) FROM stdin;
1	Корпус А	Западное крыло	1
2	Корпус Б	Восточное крыло	2
3	Корпус В	Северное крыло	3
4	Корпус Г	Южное крыло	4
5	Корпус Д	Центральное крыло	1
6	Корпус Е	Восточное крыло	4
\.


--
-- TOC entry 4872 (class 0 OID 18733)
-- Dependencies: 216
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (id, name, faculty_id) FROM stdin;
1	Кафедра вычислительной математики	1
2	Кафедра программной инженерии	1
3	Кафедра теоретической физики	2
4	Кафедра механики жидкостей и газов	3
5	Кафедра алгебры и геометрии	3
6	Кафедра гражданского права	4
7	Кафедра теории вероятностей	1
8	Кафедра квантовой физики	2
9	Кафедра дифференциальных уравнений	3
10	Кафедра уголовного права	4
\.


--
-- TOC entry 4873 (class 0 OID 18738)
-- Dependencies: 217
-- Data for Name: faculty; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.faculty (id, name) FROM stdin;
1	Факультет Информатики
2	Физический факультет
3	Факультет Механики и Математики
4	Юридический факультет
\.


--
-- TOC entry 4874 (class 0 OID 18743)
-- Dependencies: 218
-- Data for Name: floor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.floor (id, height) FROM stdin;
1	3.00
2	2.50
3	2.50
4	2.50
5	3.00
\.


--
-- TOC entry 4875 (class 0 OID 18748)
-- Dependencies: 219
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (id, number, name, corpus_id, width, length, floor_number) FROM stdin;
23	103	Аудитория для лекций	1	4.00	6.00	1
24	104	Кабинет преподавателя	1	3.00	8.00	1
25	203	Компьютерный класс	2	6.00	6.00	2
26	204	Кабинет лектора	2	6.00	8.00	2
27	303	Аудитория физики	3	4.00	5.00	3
28	304	Кабинет химии	3	3.00	9.00	3
29	403	Лаборатория биологии	4	3.00	5.00	4
30	404	Лаборатория геологии	4	6.00	6.00	4
31	503	Аудитория иностранных языков	5	6.00	6.00	5
32	504	Кабинет лингвиста	5	4.00	6.00	5
33	105	Кабинет математики	1	3.00	6.00	1
34	205	Кабинет физики	2	4.00	5.50	2
35	305	Лаборатория химии	3	3.50	7.00	3
36	405	Лаборатория биологии	4	4.50	5.50	4
37	505	Аудитория иностранных языков	5	5.00	6.00	5
38	106	Кабинет литературы	1	4.50	6.50	1
39	206	Кабинет истории	2	5.00	8.00	2
40	306	Кабинет обществознания	3	3.00	6.00	3
41	406	Лаборатория физики	4	4.00	7.00	4
42	506	Кабинет биологии	5	5.50	6.30	5
43	107	Кабинет английского языка	1	5.00	7.00	1
44	207	Лаборатория информатики	2	5.00	8.50	2
45	307	Аудитория для лекций	3	4.50	6.50	3
46	407	Кабинет русского языка	4	4.00	7.50	4
47	507	Аудитория литературы	5	6.00	8.00	5
48	108	Аудитория географии	1	3.50	7.00	1
49	208	Кабинет информатики	2	4.00	6.50	2
50	308	Кабинет французского языка	3	3.50	7.50	3
51	408	Кабинет немецкого языка	4	4.00	8.00	4
52	508	Кабинет лингвиста	5	6.50	6.50	5
53	109	Кабинет преподавателя	1	4.50	8.00	1
54	209	Аудитория для лекций	2	5.00	7.00	2
55	309	Компьютерный класс	3	4.50	6.50	3
56	409	Кабинет лектора	4	5.00	8.50	4
57	509	Аудитория физики	5	6.50	7.00	5
58	110	Кабинет химии	1	3.50	8.50	1
59	210	Лаборатория биологии	2	4.50	7.50	2
60	310	Лаборатория геологии	3	4.00	8.00	3
61	410	Аудитория иностранных языков	4	5.50	7.50	4
62	510	Кабинет лингвиста	5	7.00	7.00	5
65	511	Кабинет карповой	5	2.00	2.00	5
\.


-- Completed on 2024-06-24 13:09:04

--
-- PostgreSQL database dump complete
--

