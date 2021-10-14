Realizzare un db per una piattaforma di gestione di aerei e piloti: ogni pilota può guidare un aereo da un 
aeroporto di partenza ad uno di destinazione (e viceversa). Un aereo può essere assegnato a più tratte (voli). 
Ogni utente della piattaforma può prenotare uno o più voli e possiede un id utente e un codice fiscale.
Ogni volo, oltre a partenza e destinazione, ha anche un numero di volo, l'aereo utilizzato e il pilota. 
Ogni aereo ha un id e  il numero massimo di passeggeri ammessi. 
Ogni pilota ha un id pilota, nome, cognome e codice fiscale.
Ogni aeroporto ha un id e un nome.

Realizzare le seguenti query:
- ottenere la capienza massima di un certo volo
- ottenere i dati degli ultimi 3 viaggi di un certo pilota

Scrivere, infine, il codice Java per implementare, per ogni tabella (classe), l'interfaccia PersistentDAO ed
esporre, in più, seguenti metodi:
- getCapienzaMassimaVolo(codiceVolo): ottenere la capienza massima di un certo volo
