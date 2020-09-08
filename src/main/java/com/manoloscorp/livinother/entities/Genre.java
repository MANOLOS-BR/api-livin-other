package com.manoloscorp.livinother.entities;

public enum Genre {

  FEMININO(0),
  MASCULINO(1),
  TRANSGÊNERO(2),
  NÃO_BINÁRIO(3),
  OUTROS(4);

  public int genre;

  Genre(int genre) {
    this.genre = genre;
  }

  public int getGenre() {
    return genre;
  }

  public static Genre valueOf(int code) {
    for (Genre value : Genre.values()) {
      if (value.getGenre() == code) {
        return value;
      }
    }
    return null;
  }

}
