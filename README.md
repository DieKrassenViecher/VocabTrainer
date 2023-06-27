# VocabTrainer
Official VocabTrainer software made by [LUPLUV (aka Thore)](https://github.com/LUPLUV) and Tommy


## Funktionen

| Funktion                                                                    |      Verfügbar      |
|:----------------------------------------------------------------------------|:-------------------:|
| Ein sauberes Nutzer User Interface                                          | :white_check_mark:  |
| Vokabeln werden in einer Text Datei gespeichert                             | :white_check_mark:  |
| Vokabeln können im UI geübt werden                                          | :white_check_mark:  |
| Neue Vokabeln können im UI hinzugefügt werden                               | :white_check_mark:  |


Anforderungen:
=================
1) Du hast mindestens Java 17 installiert [Java 17 auf Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
2) Um den Code zu editieren musst du die BlueJ IDE installiert haben [BlueJ Download](https://www.bluej.org/index.html).
 
  
Installations Anweisungen:
=====================
1) Lade dir die neueste Version des Programms von Releases herunter

2) Führe das Programm mit java VocabTrainer.jar aus


## Bedienung

Auf der linken Seite des Fensters können Vokabeln geübt werden. Im Text Feld musst das zum Deutschen Wort gehörige Englische Wort eingetragen werden. Anschließend kann die Eingabe mit dem drücken des Knopfes darunter überprüft werden. Durch erneutes klicken des Knopfes, wird das nächste Vokabel abgefragt.


Auf der rechten Seite des Fensters können neue Vokabeln hinzugefügt werden. Im Text Feld muss das Deutsche Wort eingetragen werden. Anschließend kann die Eingabe mit dem drücken des Knopfes darunter bestätigt werden. Dann kann das zugehörige Fremdwort eingetragen werden und wieder durch den Knopf bestätigt werden. Nun ist das neue Vokabel im Cache sowie in der Datei vokabeln.txt eingetragen.

## Klassenübersicht

### GUI.java
Die Klasse GUI ist für das User-Interface zuständig und umfasst alle wichtigen Funktionen.

### Vokabeln.java
Die Klasse Vokabeln ist zur Verwaltung der Vokabeln zuständig. Dort werden Vokabeln gecacht, neue hinzugefügt und zugleich dient die Klasse als Datentyp für Vokabel Objekte.

### DataStorage.java
Die Klasse DataStorage ist zur Speicherung in der Datei vokabeln.txt da. Sie beinhaltet eine Methode um Inhalt in die Datei zu speichern sowie eine um Inhalt aus der Datei auszulesen.

Alle Klassen sind gut Kommentiert und sollten dadurch verständlich sein.