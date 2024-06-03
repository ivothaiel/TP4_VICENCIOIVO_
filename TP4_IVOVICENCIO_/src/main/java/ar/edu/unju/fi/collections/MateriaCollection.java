package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Materia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MateriaCollection {
    private static List<Materia> materias = new ArrayList<>();

    public static void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public static List<Materia> listarMaterias() {
        return materias;
    }

    public static Materia buscarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(codigo)) {
                return materia;
            }
        }
        return null;
    }

    public static void modificarMateria(Materia materiaModificada) {
        for (int i = 0; i < materias.size(); i++) {
            Materia materia = materias.get(i);
            if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
                materias.set(i, materiaModificada);
                return;
            }
        }
    }

    public static void eliminarMateria(String codigo) {
        materias.removeIf(materia -> materia.getCodigo().equals(codigo));
    }
}
