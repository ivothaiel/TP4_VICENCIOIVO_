package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteCollection docenteCollection;

    @GetMapping("/listar")
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", DocenteCollection.listarDocentes());
        return "listarDocentes";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregarDocente(Model model) {
        model.addAttribute("docente", new Docente());
        return "formAgregarDocente";
    }

    @PostMapping("/agregar")
    public String agregarDocente(@ModelAttribute("docente") Docente docente) {
        DocenteCollection.agregarDocente(docente);
        return "redirect:/docente/listar";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable("legajo") String legajo) {
        // Lógica para eliminar docente con el legajo proporcionado
        return "redirect:/docente/listar";
    }

    @GetMapping("/editar/{legajo}")
    public String mostrarFormularioEditarDocente(@PathVariable("legajo") String legajo, Model model) {
        // Lógica para mostrar el formulario de edición con los detalles del docente con el legajo proporcionado
        return "formEditarDocente";
    }

    @PostMapping("/editar")
    public String editarDocente(@ModelAttribute("docente") Docente docente) {
        // Lógica para editar el docente con los datos proporcionados en el formulario
        return "redirect:/docente/listar";
    }

	public DocenteCollection getDocenteCollection() {
		return docenteCollection;
	}

	public void setDocenteCollection(DocenteCollection docenteCollection) {
		this.docenteCollection = docenteCollection;
	}
}
