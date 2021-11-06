# Web-services
All of the assignments in the course Web services

## I uppgift 1: 
Spring, Skall ni sätta upp en miljö med Spring (Spring Tool Suite 4) för att köra java som en RESTful web-service, sen ska ni kunna minst 3 funktioner i den servicen . De olika 3 funktioner ska kunna ta emot siffror beroende på vilken av funktionerna som kallas, hantera siffrorna lika, d.v.s. en för multiplikation, en för division och en för addition.

Krav för Godkänd:
3 olika funktioner
Visa resultaten i klienten

Bonus krav
Ni skall göra så att era funktionerna ska kunna ta emot flera olika siffror samtidigt.

Lycka till!


## I uppgift 2: 
RPS API, skapa ett api som kan spela Sten sax påse, för minst 2 spelare. Ni ska använda er av både POST och GET metoderna, samt hantera all logik och speldata i egna klasser.

Krav för Godkänd:
Använd POST och GET metoderna
Separata klasser där ni hanterar data och logik
Skicka tillbaka resultaten med JSON

Bonus krav
Ni skall skapa ett sätt att köra flera rundor emot en datorspelare också.


## I uppgift 3: 
Data testning,ska ni skapa dokumentation for ert RPS API med hjälp av Postman (https://www.postman.com/ ), dokumentationen skall täcka alla funktionerna ni har i ert API.

Krav för Godkänd:
Testa Environments ihop med Runner, så kan ni se olika värden utöver status koderna (https://learning.postman.com/docs/postman/variables-and-environments/variables/)

Krav för Väl Godkänt:
NA

Bonus krav
Lägg till metoder för att hantera PUT och DELETE (Bara för att
testa)
Testa alla 4 metoder (GET,POST, PUT, DELETE)



## I slutprojekt: 
MyCVS, så ska ni skapa ett API för för att hantera ett specifik CSV dokument, och skapa metoder för att få ut data av det dokumentet.

Ni kommer får en baskod att som hanterar och läser ut dokumentet, och det är ert uppdrag att bygga ett API som producerar olika resultat för de metoder som krävs

Dessa metoder förväntar jag mig att ni skall producera:
- En metod som konverterar all data från CSV till JSON, i ett format med bra struktur för att läsas av senare.
- En metod som skickar tillbaka all data från den kolumn man frågar efter. Ex: Frågar man efter “Rep1” så ska svaret vara all data från den kolumnen.
- En metod som letar efter fel i "Units", "Unit Cost", "Total" kolumnerna, och returnerar de som är fel. Ex: Om "Units" är 10, "Unit Cost" är 5 men "Total" är 60, då är den av raderna som ska vara med.

Betygsgrader: IG, G och VG

Krav för Godkänd:
- Ni ska utnyttja HTTP Request metoderna korrekt
- Data och logik för ert API ska göras i sina egna särskilda klasser.
- Skapa dokumentation med Postman, beskriver hur era funktioner i ert API funkar på ett vis så att en annan utvecklare hade kunnat skapa en klient till ert API

Krav för Väl Godkänt:
- Ni ska optimera er så så att den är så effektiv som möjligt och inte är instanser av samma kod i onödan. Tänk på vad som händer som man skulle göra många request och om hur det kan optimeras.
- Ni ska också lägga till en metod som kan skickar tillbaka all data från den kolumn man frågar efter, och sorterar den alfanumerisk. Så JSON svaret är bara en kolumn man frågat efter fast i annan ordning.

SUPER BONUS:
- Skapa en metod som kan sortera alla kolumners data baserat på en av dem. EX om man väljer att sortera Total kolumnen så ska alla andra rader följa denna ordning. JSON är bara en kolumn man frågat efter fast i annan ordning.

Redovisning
- En obligatorisk muntlig rapportering skev enskilt till mig på på 2021-04-01, med start kl.09.00, med 15 minuter per elev. Det ska ni göra oavsett hur långt ni har kommit i projektet.

Deadline
- Deadline är 2021-04-02, kl.23.59.
- Ni ska lämna in samtliga filer för ert projekt via Github, här på Classroom
- Samt en länk till dokumentation på Postman.

Lycka till!



