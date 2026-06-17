import contenido.Contenido;
import contenido.Podcast;

import java.util.ArrayList;

public class Usuario {

    private String nombre;

    /*
     * Historial de reproducciones
     */
    private ArrayList<Contenido> historial;

    public Usuario(String nombre) {

        this.nombre = nombre;

        historial = new ArrayList<>();
    }

    /*
     * Añadir al historial
     */
    public void agregarAlHistorial(
            Contenido contenido) {

        historial.add(contenido);
    }

    /*
     * Obtener solo podcasts
     *
     * instanceof otra vez.
     */
    public ArrayList<Podcast> obtenerPodcastsEscuchados() {

        ArrayList<Podcast> resultado =
                new ArrayList<>();

        for (Contenido c : historial) {

            if (c instanceof Podcast) {

                resultado.add(
                        (Podcast) c);
            }
        }

        return resultado;
    }

    /*
     * Calcular minutos escuchados
     */
    public int getTiempoEscuchado() {

        int total = 0;

        for (Contenido c : historial) {

            total += c.getDuracion();
        }

        return total;
    }
}
