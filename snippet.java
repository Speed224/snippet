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

  /**
   * Restituisce un iteratore che enumera tutti i brani della playlist che provengono dall'album
   * dato.
   *
   * @param album l'album.
   * @return l'iteartore.
   * @throws NullPointerException se l'album è {@code null}.
   */
  public Iterator<Album.Brano> brani(final Album album) {
    Objects.requireNonNull(album, "L'album non può essere null.");
    return new Iterator<Album.Brano>() {

      /** Un iteratore su tutti i brani della playlist. */
      private final Iterator<Album.Brano> it = iterator();

      /** Il prossimo brano da restituire. */
      private Album.Brano next = null;

      @Override
      public boolean hasNext() {
        if (next != null) return true;
        while (it.hasNext()) {
          next = it.next();
          if (next.appartiene(album)) return true;
        }
        next = null;
        return false;
      }

      @Override
      public Album.Brano next() {
        if (!hasNext()) throw new NoSuchElementException();
        final Album.Brano ret = next;
        next = null;
        return ret;
      }
    };
  }

  /**
   * Restituisce un iteratore che enumera (senza ripetizioni) gli album di cui esiste un brano in
   * questa playlist.
   *
   * @return l'itertore.
   */
  public Iterator<Album> album() {
    return new Iterator<Album>() {

      /** Un iteratore su tutti i brani della playlist. */
      private final Iterator<Album.Brano> it = iterator();

      /** Il prossimo album da restituire. */
      private Album next = null;

      /** L'insieme degli album restituiti da {@link #next()}. */
      private final Set<Album> restituiti = new HashSet<>();

      @Override
      public boolean hasNext() {
        if (next != null) return true;
        while (it.hasNext()) {
          next = it.next().album();
          if (!restituiti.contains(next)) {
            restituiti.add(next);
            return true;
          }
        }
        next = null;
        return false;
      }

      @Override
      public Album next() {
        if (!hasNext()) throw new NoSuchElementException();
        final Album ret = next;
        next = null;
        return ret;
      }
    };
  }

  @Override
  public Iterator<Album.Brano> iterator() {
    return Collections.unmodifiableCollection(brani).iterator();
  }
}
