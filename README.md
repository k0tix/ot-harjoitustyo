# Unogame

Sovellus toteuttaa uno-korttipelin ja mahdollistaa sen pelaamisen konetta ja toisia pelaajia vastaan

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/k0tix/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

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

## Github release
[Linkki github releaseen](https://github.com/k0tix/ot-harjoitustyo/releases/tag/viikko6)