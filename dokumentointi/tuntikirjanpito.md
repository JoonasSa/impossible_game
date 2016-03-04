#*to 21.1.2016 - (2h)* 
Tein ensimmäisen viikon tehtävät: Loin repon GitHubiin, loin Maven NetBeans -projektin ja asensin Pitin. Sain Githubin ja paikallisten tiedostojen yhteyden toimimaan. Loin aihemäärittelyn ja tuntikirjanpidon. 
#*ke 27.1.2016 - (6h)*
Ohjelma ei ole vielä ajettavassa muodossa, mutta osa ohjelma logiikasta on jo valmiina. Loin ohjelmiston rungon, joka koostuu peliloopista ja kutsuu kontrolleri luokkia päivittämään peliä, joka kierroksella. Grafiikka kontrolleri ja näppäimistön kuuntelija eivät ole vielä toiminnassa, joten peliä ei voi vielä pelata. Loin myös ruudulla olevien toimijoiden kontrolloijan ja näiden toimijoiden logiikkaa. Uskon että pelaaja ja alustat toimivat nyt lähes kuten pitää. Tein myös ison kasan testejä toimija (Actor) luokille ja joitain myös kontrolleri luokille.
#*pe 29.1.2016 - (1h)*
Loin pit-raportin ja viimeistelin viikkopalautukseen vaadittavat tiedostot. Siistin projektia.
#*ti 2.2.2016 - (4h)*
Aloitin grafiikoiden luomisen jo tässä vaiheessa, koska tätä projektia on aika turha testata ilman juoksevaa peliä. Käytin varmaan 30min Java grafiikka luokkien ja logiikan kertaamiseen. Pelkästään siihen että sain ikkunan ruudulle ohjelman suorituksen aikaan meni aivan liikaa kauan... Muokkasin ohjelman rakennetta varsin paljon: lisäsin luokan GameFrame, joka luo peli-ikkunan ja kutsuu lopulta GameMainia aloittamaan pelin. GameFrame alustaa grafiikan vain kerran kun ohjelma alkaa. Toinen iso muutos on GameControllerin hylkääminen. Huomasin ettei GameControllerilla ollut mitään omaa toiminnallisuutta, eikä siitä ollut mitään hyötyä ns. rajapintana GameMainin ja pelin loogiikan välillä. Loin jo peli looppia ja sen logiikkaa, tosin grafiikat eivät vielä päivity, mikä on harmi. 
#*ke 10.2.2016 - (4h)*
Grafiikka pävittyy ja näppäimistönkuuntelija toimii. Siistin koodia ja jatkoin pelilogiikan kehittämistä pelihahmon osalta. Nyt pelissä on alustava collision detection, mikä sisältää vielä bugin. 
#*pe 12.2.2016 - (2h)*
Viimeistelin viikon palautuksen. Loin ja päivitin kaikki tarvittavat dokumentaatiot.
#*ma 15.2.2016 - (1h)*
Projekti edisty sieltä täältä.
#*ke 17.2.2016 - (3h)*
Koodi ja dokumentaatio edistyi.
#*to 18.2.2016 - (2h)*
Dokumentaatio viikolta valmis. Hyppiminen toimii nyt melkein oikein, eli gravitaatio löytyy ja tuplahypyt eivät enää onnistu. Parantelin myös pelinopeutta, ja laattojen syntymistä. Kohta tätä voi jo pelata... 
#*pe 19.2.2016 - (1h)*
Sitä sun tätä. Eli koodia sieltä ja täältä parantelin.
#*ma 22.2.2016 - (3,5h)*
Score, high score ja erilaiset gamestatet (paused, restart) toimivat.
#*ke 24.2.2016 - (2h)*
Dokumentaatiota ja yleistä viilausta.
#*ma 29.2.2016 - (2h)*
Lisäsin pelille "hienon" tähtitaivas taustan, ja parantelin collision detectionia. Nyt pelaaja kuolee, jos hän hyppää laatan sisään.
#*ke 2.3.2016 - (1h)*
Viilasin dokumentaatiota, ja pohdin viimeisiä toimenpiteitä sekä kehityskohteita. 
#*pe 4.3.2016 - (4h)*
Viimeistelin ohjelman, nyt siinä on aloitus ruutu ja pause näyttää high score ja pisteet tyylikkäästi. Refaktoroin myös hiukan koodia, ja poistin kokonaan luokan Platform, koska se oli aivan turha. Parantelin testikattavuutta ja päivitin dokumentaatiota.
