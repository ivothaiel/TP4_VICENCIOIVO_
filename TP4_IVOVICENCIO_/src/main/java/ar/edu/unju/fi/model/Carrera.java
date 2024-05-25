package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
private int id;
private String nombre;
public Carrera() {
	super();
	// TODO Auto-generated constructor stub
}
public Carrera(int id, String nombre) {
	super();
	this.id = id;
	this.nombre = nombre;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


}
