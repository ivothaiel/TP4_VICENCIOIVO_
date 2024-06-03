package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Docente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DocenteCollection {
    private static List<Docente> docentes = new ArrayList<>();

    public static void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public static List<Docente> listarDocentes() {
        return docentes;
    }

    public static Docente buscarDocente(String legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo().equals(legajo)) {
                return docente;
            }
        }
        return null;
    }

    public static void modificarDocente(Docente docenteModificado) {
        for (int i = 0; i < docentes.size(); i++) {
            Docente docente = docentes.get(i);
            if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
                docentes.set(i, docenteModificado);
                return;
            }
        }
    }

    public static void eliminarDocente(String legajo) {
        docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
    }
}
