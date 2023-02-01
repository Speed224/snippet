
public class ScaloNavale {
    /**un vettore di moli perchè i moli sono in numero finito dall'inizio */
    private final Molo[] moli;

    //AF un vettore di moli dove il molo N corrisponde all'N-esimo molo nel vettore partendo da zero,
    //se ci sono 3 moli e ScaloNavale(2) indicherà il terzo molo.
    //RI moli non può essere null, Molo in moli può essere null. Deve esserci almeno un molo.

    public ScaloNavale(int numeroMoli){
        if(numeroMoli <= 0) throw new IllegalArgumentException("Il numero di moli deve essere positivo");
        this.moli = new Molo[numeroMoli];
        for(int i = 0; i < this.moli.length; i++){
            this.moli[i] = new Molo();
        }
    }

    /**
     * inserisce una nave nel corrispettivo molo
     * @param nave la nave
     * @param numeroMolo il numero del molo
     * @throws IllegalArgumentException se non esiste un molo con il numero specificato
     * @throws NullPointerException se la nave è null
     */
    public void attraccaNave(NaveCargo nave, int numeroMolo) throws IllegalArgumentException, NullPointerException{
        if(!checkMolo(numeroMolo)) throw new IllegalArgumentException("Non esiste un molo con quel numero");
        
        //Molo.attraccaNave esegue gia il controllo se la nave è {@code null}
        this.moli[numeroMolo].attraccaNave(nave);

    }

    /**
     * rimuove una nave dal corrispettivo molo, se non ci sono il molo rimane invariato
     * @param numeroMolo il numero del molo
     * @return l'ultima nave che ha attraccato nel molo corrispondente oppure null se non è presente nessuna nave
     * @throws IllegalArgumentException se non esiste un molo con quel numero
     */
    public NaveCargo salpaNave(int numeroMolo) throws IllegalArgumentException{
        if(!checkMolo(numeroMolo)) throw new IllegalArgumentException("Non esiste un molo con quel numero");
        return this.moli[numeroMolo].salpaNave();

    }

    /**
     * Fornisce la lista delle navi nel molo in ordine di attracco
     * dalla prima (a sinistra) ad aver attraccato all'ultima (desta)
     * quella più a destra è l'ultima ad aver attraccato
     * @param numeroMolo
     * @return le navi ed il peso corrispondente nel molo numeroMolo
     * @throws IllegalArgumentException se non esiste un molo corrispondente
     */
    public String ottieniMolo(int numeroMolo) throws IllegalArgumentException{
        if(checkMolo(numeroMolo)){
            return this.moli[numeroMolo].toString();}
        else throw new IllegalArgumentException("Non esiste un molo con quel numero");
    }

    /**
     * controlla il molo N è presente in moli
     * @param numeroMolo il numero del molo
     * @return true se presente false altrimenti
     */
    private Boolean checkMolo(int numeroMolo){
        if(numeroMolo < 0 || numeroMolo >= this.moli.length) return false;
        return true;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(Molo m: this.moli){
            sb.append(String.format("%d: %s\n", i, m));
            i++;
        }
        return sb.toString();
    }
}
