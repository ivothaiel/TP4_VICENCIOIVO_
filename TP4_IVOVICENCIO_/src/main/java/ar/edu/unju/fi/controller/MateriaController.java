package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaCollection materiaCollection;

    @GetMapping("/listar")
    public String listarMaterias(Model model) {
        model.addAttribute("materias", MateriaCollection.listarMaterias());
        return "listarMaterias";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregarMateria(Model model) {
        model.addAttribute("materia", new Materia());
        return "formAgregarMateria";
    }

    @PostMapping("/agregar")
    public String agregarMateria(@ModelAttribute("materia") Materia materia) {
        MateriaCollection.agregarMateria(materia);
        return "redirect:/materia/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable("codigo") String codigo) {
        // Lógica para eliminar materia con el código proporcionado
        return "redirect:/materia/listar";
    }

    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEditarMateria(@PathVariable("codigo") String codigo, Model model) {
        // Lógica para mostrar el formulario de edición con los detalles de la materia con el código proporcionado
        return "formEditarMateria";
    }

    @PostMapping("/editar")
    public String editarMateria(@ModelAttribute("materia") Materia materia) {
        // Lógica para editar la materia con los datos proporcionados en el formulario
        return "redirect:/materia/listar";
    }

	public MateriaCollection getMateriaCollection() {
		return materiaCollection;
	}

	public void setMateriaCollection(MateriaCollection materiaCollection) {
		this.materiaCollection = materiaCollection;
	}
}
