package com.misiontic.informes;

public class Informe1Model {
    int id;
    String nombre, apellido, ciudad;

    public Informe1Model(int id, String nombre, String apellido, String ciudad){
        this.id         =   id;
        this.nombre     =   nombre;
        this.apellido   =   apellido;
        this.ciudad     =   ciudad;

    }
    public int getId (){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
    public String getNombre (){
        return nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getApellido (){
        return apellido;
    }
    public void setApellido (String apellido){
        this.apellido = apellido;
    }
    public String getCiudad (){
        return ciudad;
    }
    public void setCiudad (String ciudad){
        this.ciudad = ciudad;
    }


}
