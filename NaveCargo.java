import java.util.Objects;

/**
 * Classe immutabile che rappresenta una NaveCargo
 * lo stato è dato dal (mai {@code null} ne vuoto)
 * e dal peso (sempre >= 0)
 */
public class NaveCargo {

    //publici e non privati poiché sono final e fare i getter è ridondante.
    public final String nome;
    public final int peso;

    //AF una nave cargo è costituita dal nome e dal peso
    // per esempio NaveCargo(pippo, 10) è una nave di nome pippo e di peso 10
    //RI il nome non può essere null o vuoto, il peso deve essere positivo

    /**
     * Costruisce una NaveCargo dato un nome e un peso
     * @param nome il nome della nave (non null, ne vuoto)
     * @param peso il peso (positivo)
     * @throws IllegalArgumentException se il nome è vuoto o il peso è <= 0
     * @throws NullPointerException se il nome è {@code null}
     */
    public NaveCargo(String nome, int peso) throws IllegalArgumentException, NullPointerException{
        if(Objects.requireNonNull(nome).isEmpty()) throw new IllegalArgumentException("Il nome non può essere vuoto");
        this.nome=nome;
        if(peso <= 0) throw new IllegalArgumentException("Il peso deve essere positivo");
        this.peso = peso;
    }




    public String toString(){
        return String.format("%s[%d]",this.nome, this.peso);
    }
}
