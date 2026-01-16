# Ghost Net Fishing – Fallstudie IPWA02-01

## Projektbeschreibung

Dieses Repository enthält die prototypische Umsetzung der Fallstudie **„Ghost Net Fishing“** im Rahmen des Kurses
**„Programmierung von industriellen Informationssystemen mit Java (IPWA02-01)“** an der IU Internationalen Hochschule.

Als technische Ausgangsbasis wurde ein im Kurs bereitgestelltes Java-EE-Beispielprojekt verwendet. Dieses Projekt diente als **Vorlage und Grundgerüst** und wurde im Rahmen der Fallstudie fachlich, strukturell und funktional erweitert sowie an die Anforderungen des Szenarios „Ghost Net Fishing“ angepasst.

Ziel der Anwendung ist die webbasierte Erfassung und Verwaltung von sogenannten Geisternetzen. Die Anwendung unterstützt sowohl das Melden von Geisternetzen als auch die Koordination von Bergungsmaßnahmen und bildet den jeweiligen Bearbeitungsstatus transparent ab.

## Funktionaler Umfang

Im Rahmen der Fallstudie wurden folgende Kernfunktionen prototypisch umgesetzt:

* Erfassen von Geisternetzen mit Standort (GPS-Koordinaten) und geschätzter Größe
* Anonyme oder namentliche Meldung eines Geisternetzes
* Übersicht über alle offenen (nicht geborgenen) Geisternetze
* Übernahme der Bergung eines Geisternetzes durch eine bergende Person
* Statusänderung eines Geisternetzes (geborgen oder verschollen)
* Persistente Speicherung aller Daten in einer relationalen Datenbank

## Technologiestack

Die Anwendung wurde mit dem im Kurs vorgegebenen Technologiestack umgesetzt:

* Java EE / Jakarta EE
* JavaServer Faces (JSF) mit Facelets
* Contexts and Dependency Injection (CDI)
* Java Persistence API (JPA) mit Hibernate als Persistenz-Provider
* MySQL als relationale Datenbank
* WildFly als Application Server
* Maven für Build- und Abhängigkeitsmanagement

## Projektstruktur

Der Quellcode der Anwendung ist nach dem üblichen Maven-Standard aufgebaut:

* `src/main/java` – Java-Quellcode (Controller, Services, Repositories, Domänenmodelle)
* `src/main/resources` – Konfigurationsdateien (u. a. persistence.xml)
* `src/main/webapp` – JSF-Seiten (XHTML) und Webressourcen
* `docs` – Schriftliche Ausarbeitung der Fallstudie (PDF)

## Ausführung der Anwendung

Die Anwendung wurde lokal mit einem WildFly Application Server betrieben.
Für den Betrieb wird eine MySQL-Datenbank benötigt, in der die notwendigen Tabellen automatisch durch JPA/Hibernate erzeugt werden.

## Autor

**Verfasser der Fallstudie:** Rüth, Lucas
**Studiengang:** B. Sc. Wirtschaftsinformatik
**Matrikelnummer:** IU1413095
**Kurs:** IPWA02-01
