package contenido;

import excepciones.ContenidoDuplicadoException;

import java.util.ArrayList;

public class Playlist {

    private String nombre;
    private ArrayList<Contenido> contenidos;

    /*
     * Constructor
     *
     * Siempre inicializar las listas
     * para evitar NullPointerException.
     */
    public Playlist(String nombre) {

        this.nombre = nombre;

        this.contenidos = new ArrayList<>();
    }

    /*
     * Añadir contenido
     *
     * Patrón típico:
     *
     * si existe -> excepción
     * si no existe -> add()
     */
    public void agregarContenido(
            Contenido contenido)
            throws ContenidoDuplicadoException {

        if (contenidos.contains(contenido)) {

            throw new ContenidoDuplicadoException(
                    "contenido.Contenido duplicado");
        }

        contenidos.add(contenido);
    }

    /*
     * Sumar duración total
     *
     * Patrón típico:
     *
     * int total = 0;
     *
     * recorrer lista
     * sumar duración
     */
    public int getDuracionTotal() {

        int total = 0;

        for (Contenido c : contenidos) {

            total += c.getDuracion();
        }

        return total;
    }

    /*
     * Obtener solo podcasts
     *
     * Patrón MUY típico:
     *
     * instanceof
     * casting
     */
    public ArrayList<Podcast> obtenerPodcasts() {

        ArrayList<Podcast> resultado =
                new ArrayList<>();

        for (Contenido c : contenidos) {

            if (c instanceof Podcast) {

                resultado.add((Podcast) c);
            }
        }

        return resultado;
    }

    /*
     * GETTERS Y SETTERS
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(
            ArrayList<Contenido> contenidos) {

        this.contenidos = contenidos;
    }
}
