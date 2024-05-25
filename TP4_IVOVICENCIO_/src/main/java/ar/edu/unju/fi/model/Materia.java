package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

	@Component
	public class Materia {
		  private String codigo;
		    private String nombre;
		    @Autowired
		    private int curso;
		    private int cantidadDeHoras;
		    private String modalidad; // Virtual o Presencial
		    private Docente docente;
		    private Carrera carrera;
			public Materia() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Materia(String codigo, String nombre, int curso, int cantidadDeHoras, String modalidad, Docente docente,
					Carrera carrera) {
				super();
				this.codigo = codigo;
				this.nombre = nombre;
				this.curso = curso;
				this.cantidadDeHoras = cantidadDeHoras;
				this.modalidad = modalidad;
				this.docente = docente;
				this.carrera = carrera;
			}
			public String getCodigo() {
				return codigo;
			}
			public void setCodigo(String codigo) {
				this.codigo = codigo;
			}
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public int getCurso() {
				return curso;
			}
			public void setCurso(int curso) {
				this.curso = curso;
			}
			public int getCantidadDeHoras() {
				return cantidadDeHoras;
			}
			public void setCantidadDeHoras(int cantidadDeHoras) {
				this.cantidadDeHoras = cantidadDeHoras;
			}
			public String getModalidad() {
				return modalidad;
			}
			public void setModalidad(String modalidad) {
				this.modalidad = modalidad;
			}
			public Docente getDocente() {
				return docente;
			}
			public void setDocente(Docente docente) {
				this.docente = docente;
			}
			public Carrera getCarrera() {
				return carrera;
			}
			public void setCarrera(Carrera carrera) {
				this.carrera = carrera;
			}
		    
		
		
	}





