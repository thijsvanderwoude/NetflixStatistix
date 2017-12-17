-- Netflix Statistix database, Thijs van der Woude (2126506)
-- Alleen nog keys

USE master;

DROP DATABASE NetflixStatistix;
CREATE DATABASE NetflixStatistix;
GO

USE NetflixStatistix;

CREATE TABLE Film(
	Id int,
	Titel nvarchar(150),
	Leeftijdsindicatie nvarchar(16),
	Taal nvarchar(50),
	Tijdsduur time,
	Genre nvarchar(20)
);
INSERT INTO Film VALUES
(1010,	'The Abominable Bride',				'12',				'Engels',				'01:29',	'Detective'),
(8001,	'The Life of Brian',				'12 jaar en ouder',	'Engels',				'01:34',	'Humor'),
(8002,	'Pulp Fiction',						'16 jaar en ouder',	'Engels-Amerikaans',	'02:34',	'Misdaad'),
(8004,	'Pruimebloesem',					'18 jaar en ouder',	'Nederlands',			'01:20',	'Erotiek'),
(8008,	'Reservoir Dogs',					'16 jaar en ouder',	'Engels-Amerikaans',	'01:39',	'Misdaad'),
(8010,	'The Good, the Bad and the Ugly',	'12 jaar en ouder',	'Engels-Amerikaans',	'02:41',	'Western'),
(8011,	'Andy Warhol''s Dracula',			'16 jaar en ouder',	'Engels-Amerikaans',	'01:43',	'Humor'),
(8012,	'Ober',								'6 jaar en ouder',	'Nederlands',			'01:37',	'Humor'),
(8014,	'Der Untergang',					'6 jaar en ouder',	'Duits',				'02:58',	'Oorlog'),
(8016,	'De helaasheid der dingen',			'12 jaar en ouder',	'Vlaams',				'01:48',	'Humor'),
(8017,	'A Clockwork Orange',				'16 jaar en ouder',	'Engels',				'02:16',	'SF');

CREATE TABLE Serie(
	Serie nvarchar(150),
	Seizoen nvarchar(6),
	Leeftijd nvarchar(16),
	Taal nvarchar(50),
	Genre nvarchar(20),
	LijktEenBeetjeOp nvarchar(150)
);
INSERT INTO Serie VALUES
('Sherlock',		'S01E01',	'12 jaar en ouder',	'Engels',				'Detective',	'Fargo'),
('Breaking Bad',	'S01E01',	'16 jaar en ouder',	'Engels-Amerikaans',	'Spanning',		'Fargo'),
('Fargo',			'S01E01',	'16 jaar en ouder',	'Engels-Amerikaans',	'Spanning',		'Breaking Bad');

CREATE TABLE Aflevering(
	Id int,
	Serie nvarchar(150),
	Seizoen nvarchar(6),
	Titel nvarchar (150),
	Tijdsduur time
);
INSERT INTO Aflevering VALUES
(1001,	'Sherlock',		'S01E01',	'A Study in Pink',					'01:28'),
(1002,	'Sherlock',		'S01E02',	'The Blind Banker',					'01:28'),
(1003,	'Sherlock',		'S01E03',	'The Great Game',					'01:28'),
(1004,	'Sherlock',		'S02E01',	'A Scandal in Belgravia',			'01:28'),
(1005,	'Sherlock',		'S02E02',	'The Hounds of Baskerville',		'01:28'),
(1006,	'Sherlock',		'S02E03',	'The Reichenbach Fall',				'01:28'),
(1007,	'Sherlock',		'S03E01',	'The Empty Hearse',					'01:28'),
(1008,	'Sherlock',		'S03E02',	'The Sign of Three',				'01:28'),
(1009,	'Sherlock',		'S03E03',	'His Last Vow',						'01:28'),
(2000,	'Breaking Bad',	'S01E01',	'Pilot',								'00:58'),
(2001,	'Breaking Bad',	'S01E02',	'Cat’s in the Bag…',				'00:48'),
(2002,	'Breaking Bad',	'S01E03',	'…And the Bag’s in the River',		'00:48'),
(2003,	'Breaking Bad',	'S01E04',	'Cancer Man',						'00:48'),
(2004,	'Breaking Bad',	'S01E05',	'Gray Matter',						'00:48'),
(2005,	'Breaking Bad',	'S01E06',	'Crazy Handful of Nothin’',			'00:48'),
(2006,	'Breaking Bad',	'S01E07',	'A No-Rough-Stuff-Type Deal',		'00:48'),
(2007,	'Breaking Bad',	'S02E01',	'Seven Thirty-Seven',				'00:48'),
(2008,	'Breaking Bad',	'S02E02',	'Grilled',							'00:48'),
(2009,	'Breaking Bad',	'S02E03',	'Bit by a Dead Bee',				'00:48'),
(2010,	'Breaking Bad',	'S02E04',	'Down',								'00:48'),
(2011,	'Breaking Bad',	'S02E05',	'Breakage',							'00:48'),
(2012,	'Breaking Bad',	'S02E06',	'Peekaboo',							'00:48'),
(2013,	'Breaking Bad',	'S02E07',	'Negro Y Azul',						'00:48'),
(2014,	'Breaking Bad',	'S02E08',	'Better Call Saul',					'00:48'),
(2015,	'Breaking Bad',	'S02E09',	'4 Days Out',						'00:48'),
(2016,	'Breaking Bad',	'S02E10',	'Over',								'00:48'),
(2017,	'Breaking Bad',	'S02E11',	'Mandala',							'00:48'),
(2018,	'Breaking Bad',	'S02E12',	'Phoenix',							'00:48'),
(2019,	'Breaking Bad',	'S02E13',	'ABQ',								'00:48'),
(3001,	'Fargo',		'S01E01',	'The Crocodile''s Dilemma',			'01:08'),
(3002,	'Fargo',		'S01E02',	'The Rooster Prince',				'01:08'),
(3003,	'Fargo',		'S01E03',	'A Muddy Road',						'01:08'),
(3004,	'Fargo',		'S01E04',	'Eating the Blame',					'01:08'),
(3005,	'Fargo',		'S01E05',	'The Six Ungraspables',				'01:08'),
(3006,	'Fargo',		'S01E06',	'Buridan''s Ass',					'01:08'),
(3007,	'Fargo',		'S01E07',	'Who Shaves the Barber?',			'01:08'),
(3008,	'Fargo',		'S01E08',	'The Heap',							'01:08'),
(3009,	'Fargo',		'S01E09',	'A Fox, a Rabbit, and a Cabbage',	'01:08'),
(3010,	'Fargo',		'S01E10',	'Morton''s Fork',					'01:08'),
(3101,	'Fargo',		'S02E01',	'Waiting for Dutch',				'01:08'),
(3102,	'Fargo',		'S02E02',	'Before the Law',					'01:08'),
(3103,	'Fargo',		'S02E03',	'The Myth of Sisyphus',				'01:08'),
(3105,	'Fargo',		'S02E04',	'The Gift of the Magi',				'01:08'),
(3104,	'Fargo',		'S02E05',	'Fear and Trembling',				'01:08'),
(3106,	'Fargo',		'S02E06',	'Rhinoceros',						'01:08'),
(3107,	'Fargo',		'S02E07',	'Did you do this? No, you did it!',	'01:08'),
(3108,	'Fargo',		'S02E08',	'Loplop',							'01:08'),
(3109,	'Fargo',		'S02E09',	'The Castle',						'01:08'),
(3110,	'Fargo',		'S02E10',	'Palindrome',						'01:08');

CREATE TABLE Account(
	Abonneenummer int,
	Naam nvarchar(100),
	Straat nvarchar(100),
	Postcode nvarchar(7),
	Huisnummer nvarchar(4),
	Plaats nvarchar(100)
);
INSERT INTO Account VALUES
(1215426,	'Fam. van Raalte',	'Schopenhauerdijkje',	'3991 ML',	'5',	'Houten'),
(5602533,	'J. van Betlehem',	'Nietzschestraat',		'8542 BE',	'99',	'Breda'),
(5285824,	'F. de Kat',		'Kantlaan',				'8542 CD',	'11',	'Breda');

CREATE TABLE Profiel(
	Abonneenummer int,
	Profielnaam nvarchar(50),
	Geboortedatum date
);
INSERT INTO Profiel VALUES
(1215426,	'Frank',	CONVERT(date, '25-1-1968', 105)),
(1215426,	'Frank',	CONVERT(date, '25-1-1968', 105)),
(1215426,	'Frank',	CONVERT(date, '25-1-1968', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(1215426,	'Madelief',	CONVERT(date, '19-8-2001', 105)),
(5602533,	'Petrus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Petrus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Petrus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Petrus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Petrus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Paulus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Paulus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Paulus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Paulus',	CONVERT(date, '26-6-1999', 105)),
(5602533,	'Paulus',	CONVERT(date, '26-6-1999', 105)),
(5285824,	'Fritz',	CONVERT(date, '19-8-1968', 105)),
(5285824,	'Fritz',	CONVERT(date, '19-8-1968', 105)),
(5285824,	'Fritz',	CONVERT(date, '19-8-1968', 105)),
(5285824,	'Diana',	CONVERT(date, '25-12-1988', 105)),
(5285824,	'Diana',	CONVERT(date, '25-12-1988', 105));

CREATE TABLE Bekeken(
	Abonneenummer int,
	Profielnaam nvarchar(50),
	Gezien int,
	Percentage int,
);
INSERT INTO Bekeken VALUES
(1215426,	'Frank',	1001,	100),
(1215426,	'Frank',	1002,	100),
(1215426,	'Frank',	1003,	78),
(1215426,	'Madelief',	1001,	100),
(1215426,	'Madelief',	1002,	60),
(1215426,	'Madelief',	3001,	91),
(1215426,	'Madelief',	2001,	100),
(1215426,	'Madelief',	2002,	100),
(1215426,	'Madelief',	2003,	100),
(1215426,	'Madelief',	2004,	22),
(5602533,	'Petrus',	3001,	100),
(5602533,	'Petrus',	3002,	100),
(5602533,	'Petrus',	3010,	60),
(5602533,	'Petrus',	8001,	100),
(5602533,	'Petrus',	8002,	99),
(5602533,	'Paulus',	3001,	100),
(5602533,	'Paulus',	3002,	74),
(5602533,	'Paulus',	3010,	60),
(5602533,	'Paulus',	8001,	100),
(5602533,	'Paulus',	2019,	10),
(5285824,	'Fritz',	1001,	100),
(5285824,	'Fritz',	1002,	100),
(5285824,	'Fritz',	1010,	5),
(5285824,	'Diana',	8002,	100),
(5285824,	'Diana',	1001,	45);

-- Checken of alle waarden goed geinsert zijn.
SELECT *
FROM Film;

SELECT *
FROM Serie;

SELECT *
FROM Aflevering;

SELECT *
FROM Account;

SELECT *
FROM Profiel;

SELECT *
FROM Bekeken;
