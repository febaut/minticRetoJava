package com.misiontic.informes;

public class Informe2Model {
    int id, noHabitaciones;
    String constructora, ciudad;

    public Informe2Model(int id, String constructora, int noHabitaciones, String ciudad){
        this.id             =   id;
        this.constructora   =   constructora;
        this.noHabitaciones =   noHabitaciones;
        this.ciudad         =   ciudad;

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
    public int getNoHabitaciones (){
        return noHabitaciones;
    }
    public void setNoHabitaciones (int noHabitaciones){
        this.noHabitaciones = noHabitaciones;
    }
    public String getCiudad (){
        return ciudad;
    }
    public void setCiudad (String ciudad){
        this.ciudad = ciudad;
    }

}
