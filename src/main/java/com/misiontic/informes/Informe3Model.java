package com.misiontic.informes;

public class Informe3Model {
    int id;
    String constructora, banco;

    public Informe3Model(int id, String constructora, String ciudad){
        this.id             =   id;
        this.constructora   =   constructora;
        this.banco          =   ciudad;

    }
    public int getId (){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
    public String getConstructora (){
        return constructora;
    }
    public void setConstructora (String constructora){
        this.constructora = constructora;
    }
    public String getBanco (){ return banco; }
    public void setBanco (String banco){
        this.banco = banco;
    }

}
