@Override
    public boolean equals(Object obj) {
        //controllo che equals venga chiamato su se stesso
        if(obj == this) return true;
        //controllo che obj sia un'istanza della mia classe
        if(!(obj instanceof Giocattolo)) return false;
        Giocattolo og = (Giocattolo)obj;
        //controllo che nome e materiale siano uguali
        if(this.nome.equals(og.nome) && this.materiale.equals(og.materiale)) return true;
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome,this.materiale);
    }
