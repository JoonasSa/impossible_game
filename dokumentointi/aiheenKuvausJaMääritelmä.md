#Aihe
Impossible game tyylinen peli, jossa pelaaja yrittää selviytyä mahdollisimman kauan vaikeustason kasvaessa.
Pelissä pelaaja ei pysty liikkumaan sivuttain, vaan kenttä ikäänkuin rullaa pelaaja päin oikealta vasemmalle.
Pelissä on high score -lista johon tallennetaan parhaimmat suoritukset, score säilyy kentästä toiseen 
ja nollaantuu vain pelaajan kuollessa. :trophy:
[Tässä linkki projektin inspiraatioon.](http://impossiblegame.org/the-impossible-game/)

---
#Ohjelman rakenne
![Luokkakaavio](kaaviot/luokkakaavio2.png)

Ohjelma käynnistyessä alustetaan GameMain ja se annetaan GameFrame-oliolle. GameMain alustaa pelin logiikan ja sen tarvitsemat oliot (ActorController, GameListener), sekä grafiikka olion joka annetaan myös GameFramelle. GameFrame paketoi ohjelman grafiikan eli ikkunan ja renderöijä-olion PaintComponent. 

Ohjelma toimii GameMainin gameStart() ja gameUpdate() -loopeissa. Yksi kokonainen gameStart() kierto vastaa pelissä yhtä päivitys kierrosta. gameStart() sisältää pelin tauottamiseen ja jatkamiseen liittyvän logiikan. gameUpdate() taas kutsuu vuorotellen jokaista GameMainissa alustettua olioa:
* ActorController hoitaa vuorollaan pelihahmojen sijainnin päivittämisen, uusien hahmojen lisäämisen ja osumatestit.
  * ActorController sisältää listan päivitettävistä Actoreista.
  * Sekä Player, että Platform ovat Actor -luokan aliluokkia.
* PaintComponent renderoi uuden peli tilanteen joka päivitys kierroksella. 
* Riippumattomana GameMainin peliloopista toimii taustalla GameListener, joka kuuntelee näpääimistön painalluksia, ja toimii mikäli tiettyjä näppäimiä painetaan.
  * Näppäinten painallusten mukaan toimitaan joka päivitys kierroksella. Riippuen mitä on painettu GameListener palauttaa boolean-arvoja, jotka kuvaavat pelaajan komentoja: hyppy, tauota peli, uudelleen käynnistä peli, taikka sammutta ohjelma.
---
#Ohjelman toiminta
![Ohjelman käynnistämisen sekvenssikaavio](kaaviot/sekvenssikaavio2.png)
![Pelihahmon hyppäämisen sekvenssikaavio](kaaviot/sekvenssikaavio1.png)
---
#Käyttöohje
![Käyttöohje](kayttoohje.md)

#Käyttäjät
* Pelaaja

#Käyttäjän toiminnot
* Käyttäjä käynnistää ohjelman
* Toiminnot pelissä
  * Pelaaja kontrolloi hahmoaan hyppimällä, ja pyrkii pysymään hengissä mahdollisimman kauan
  * Pelaaja ei pysty liikkumaan sivuittain
  * Pelaaja voi laittaa pelin tauolle, ja high score tulee näkyviin
* Käyttäjän tavoite
 * Saada uusi high score

#Kenttä
Kenttä sisältää alustoja joilla pelaaja matkaa. Kenttää luodaan satunnaisesti sitä mukaa, kun pelaaja etenee.
---
#Jatkokehitys ideoita
* Endless mode - Peli, joka jatkuu kunnes pelaaja kuolee
  * Valikkoon pitää lisätä pelimuodon valinta
* No gravity mode - Pelissä ei ole pelaajan vaikuttavaa painovoimaa
  * Pelin luonne muuttuu kun pelaaja ei kontrolloikaan hahmoaan vain hyppimällä
* Boundless mode - Peli, jossa pelaaja kykenee liikkumaan myös sivuittain
