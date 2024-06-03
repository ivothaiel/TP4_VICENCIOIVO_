package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraCollection carreraCollection;

    @GetMapping("/listar")
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", CarreraCollection.listarCarreras());
        return "listarCarreras";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregarCarrera(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "formAgregarCarrera";
    }

    @PostMapping("/agregar")
    public String agregarCarrera(@ModelAttribute("carrera") Carrera carrera) {
        CarreraCollection.agregarCarrera(carrera);
        return "redirect:/carrera/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCarrera(@PathVariable("id") int id) {
        // Lógica para eliminar carrera con el ID proporcionado
        return "redirect:/carrera/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCarrera(@PathVariable("id") int id, Model model) {
        // Lógica para mostrar el formulario de edición con los detalles de la carrera con el ID proporcionado
        return "formEditarCarrera";
    }

    @PostMapping("/editar")
    public String editarCarrera(@ModelAttribute("carrera") Carrera carrera) {
        // Lógica para editar la carrera con los datos proporcionados en el formulario
        return "redirect:/carrera/listar";
    }

	public CarreraCollection getCarreraCollection() {
		return carreraCollection;
	}

	public void setCarreraCollection(CarreraCollection carreraCollection) {
		this.carreraCollection = carreraCollection;
	}

}

