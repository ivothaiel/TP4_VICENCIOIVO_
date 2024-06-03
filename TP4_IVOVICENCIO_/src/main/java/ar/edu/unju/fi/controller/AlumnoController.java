package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoCollection alumnoCollection;

    @GetMapping("/listar")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", AlumnoCollection.listarAlumnos());
        return "listarAlumnos";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregarAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "formAgregarAlumno";
    }

    @PostMapping("/agregar")
    public String agregarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        AlumnoCollection.agregarAlumno(alumno);
        return "redirect:/alumno/listar";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable("dni") String dni) {
        // Lógica para eliminar alumno con el DNI proporcionado
        return "redirect:/alumno/listar";
    }

    @GetMapping("/editar/{dni}")
    public String mostrarFormularioEditarAlumno(@PathVariable("dni") String dni, Model model) {
        // Lógica para mostrar el formulario de edición con los detalles del alumno con el DNI proporcionado
        return "formEditarAlumno";
    }

    @PostMapping("/editar")
    public String editarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        // Lógica para editar el alumno con los datos proporcionados en el formulario
        return "redirect:/alumno/listar";
    }

	public AlumnoCollection getAlumnoCollection() {
		return alumnoCollection;
	}

	public void setAlumnoCollection(AlumnoCollection alumnoCollection) {
		this.alumnoCollection = alumnoCollection;
	}
}
