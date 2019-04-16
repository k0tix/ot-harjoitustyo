# Unogame

Sovellus toteuttaa uno-korttipelin ja mahdollistaa sen pelaamisen konetta ja toisia pelaajia vastaan

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

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

### Jar-tiedoston luonti ja suoritus
```
mvn package

cd target/

java -jar Unogame-1.0-SNAPSHOT.jar
```