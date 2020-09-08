package com.manoloscorp.livinother.entities;

public enum UserType {

  DOADOR(0), RECEPTOR(1);

  public int type;

  UserType(int type) {
    this.type = type;
  }

  public int getTypeUser() {
    return type;
  }
}
