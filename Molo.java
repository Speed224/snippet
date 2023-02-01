import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Classe concreta che rappresenta un molo,
 * il suo stato è dato da una collezione di {@link NaveCargo} nel molo
 */
public class Molo {
    
    //la lista che rappresenta le navi all'interno del molo
    private List<NaveCargo> coda;

    //AF coda rappresenta una LIFO, l'ultima nave inserita nel molo è la prima che può salpare
    //se inserisco nave1, nave2, nave3 la prima a poter uscire sarà nave3 poi nave2 e per finire nave1
    //il molo può essere vuoto
    //RI coda non deve essere null

    /**
     * Costruise un molo vuoto
     */
    public Molo(){
        this.coda = new ArrayList<>();
    }


    /**
     * aggiunge una nave al molo,
     * se la nave è {@code null} lancia un eccezione e il molo rimane invariato
     * @param nave la nave
     * @throws NullPointerException se la nave è {@code null}
     */
    public void attraccaNave(NaveCargo nave) throws NullPointerException{
        this.coda.add(Objects.requireNonNull(nave, "la nave non può essere null"));
    }

    /**
     * rimuove l'ultima nave ad aver attraccato nel molo,
     * se nessuna nave è presente il molo rimane invariato
     * @return l'ultima nave che ha attraccato oppure {@code null} se il molo è vuoto
     */
    public NaveCargo salpaNave(){
        if(this.coda.isEmpty()) return null;
        return this.coda.remove(this.coda.size()-1);
        
    }

    /**
     * forinisce il peso della nave che può salpare,
     * se non ci sono navi fornisce 0
     * @return il peso della nave oppure 0 se non sono presenti navi nel molo
     */
    public int pesoNave(){
        if(this.coda.isEmpty()) return 0;
        return this.coda.get(this.coda.size()-1).peso;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("< ");
        for(int i = 0; i<this.coda.size(); i++){
            sb.append(String.format("%s, ", this.coda.get(i)));
        }
        String s = sb.toString().substring(0, sb.toString().length()-2);
        return s+="#";
    }

}
