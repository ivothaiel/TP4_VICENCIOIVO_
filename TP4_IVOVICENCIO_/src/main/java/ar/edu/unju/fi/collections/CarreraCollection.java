package ar.edu.unju.fi.collections;

import ar.edu.unju.fi.model.Carrera;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CarreraCollection {
    private static List<Carrera> carreras = new ArrayList<>();

    public static void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    public static List<Carrera> listarCarreras() {
        return carreras;
    }

    public static Carrera buscarCarrera(int id) {
        for (Carrera carrera : carreras) {
            if (carrera.getId() == id) {
                return carrera;
            }
        }
        return null;
    }

    public static void modificarCarrera(Carrera carreraModificada) {
        for (int i = 0; i < carreras.size(); i++) {
            Carrera carrera = carreras.get(i);
            if (carrera.getId() == carreraModificada.getId()) {
                carreras.set(i, carreraModificada);
                return;
            }
        }
    }

    public static void eliminarCarrera(int id) {
        carreras.removeIf(carrera -> carrera.getId() == id);
    }
}
