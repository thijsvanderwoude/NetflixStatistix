SELECT Aflevering.Id, Aflevering.Titel, AVG(Bekeken.Percentage) AS 'Gemiddeld bekeken % van tijdsduur'
FROM Aflevering
JOIN Bekeken
ON Aflevering.Id = Bekeken.Gezien
/*WHERE Aflevering.Serie = door de gebruiker geselecteerde serie*/
GROUP BY Aflevering.Id, Aflevering.Titel

SELECT Aflevering.Id, Aflevering.Titel, AVG(Bekeken.Percentage) AS 'Gemiddeld bekeken % van tijdsduur'
FROM Aflevering
JOIN Bekeken
ON Aflevering.Id = Bekeken.Gezien
JOIN Account
ON Bekeken.Abonneenummer = Account.Abonneenummer
/* WHERE Aflevering.Serie = door de gebruiker geselecteerde serie AND Account.Naam = door de gebruiker geselecteerde account */ 
GROUP BY Aflevering.Id, Aflevering.Titel

SELECT COUNT(Abonneenummer) AS 'Aantal kijkers film in zijn geheel gezien'
FROM Bekeken
JOIN Film
ON Bekeken.Gezien = Film.Id
WHERE Bekeken.Percentage = 100 /* AND Film.Titel = door de gebruiker geselecteerde film */ 




