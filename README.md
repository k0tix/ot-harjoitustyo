# Unogame

Sovellus toteuttaa uno-korttipelin ja mahdollistaa sen pelaamisen konetta ja toisia pelaajia vastaan

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

## Komennot

### Testit
```
mvn test
```

### Testiraportti
```
mvn test jacoco:report
```

### Checkstyle
```
mvn jxr:jxr checkstyle:checkstyle
```

### JavaDoc
```
mvn javadoc:javadoc
```

### Jar-tiedoston luonti ja suoritus
```
mvn package

cd target/

java -jar Unogame-1.0-SNAPSHOT.jar
```

## Github releaset
[Viikko 5](https://github.com/k0tix/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/k0tix/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/k0tix/ot-harjoitustyo/releases/tag/viikko7)