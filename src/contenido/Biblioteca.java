package contenido;

import excepciones.ContenidoDuplicadoException;

import java.util.ArrayList;

public class Biblioteca {

    /*
     * La biblioteca guarda contenidos.
     */
    private ArrayList<Contenido> catalogo;

    /*
     * Constructor
     *
     * MUY IMPORTANTE:
     * inicializar siempre ArrayList.
     */
    public Biblioteca() {

        catalogo = new ArrayList<>();
    }

    /*
     * AÑADIR CONTENIDO
     *
     * Patrón:
     * contains + excepción
     */
    public void agregarContenido(
            Contenido contenido)
            throws ContenidoDuplicadoException {

        if (catalogo.contains(contenido)) {

            throw new ContenidoDuplicadoException(
                    "contenido.Contenido repetido");
        }

        catalogo.add(contenido);
    }

    /*
     * BUSCAR POR TÍTULO
     *
     * Patrón:
     * recorrer lista
     */
    public Contenido buscarContenido(
            String titulo)
            throws Exception {

        for (Contenido c : catalogo) {

            if (c.getTitulo().equals(titulo)) {

                return c;
            }
        }

        throw new Exception(
                "contenido.Contenido no encontrado");
    }

    /*
     * OBTENER SOLO CANCIONES
     *
     * Patrón:
     * instanceof + casting
     */
    public ArrayList<Cancion> obtenerCanciones() {

        ArrayList<Cancion> resultado =
                new ArrayList<>();

        for (Contenido c : catalogo) {

            if (c instanceof Cancion) {

                resultado.add(
                        (Cancion) c);
            }
        }

        return resultado;
    }

    /*
     * SUMAR REPRODUCCIONES
     *
     * Patrón:
     * acumulador
     */
    public int getTotalReproducciones() {

        int total = 0;

        for (Contenido c : catalogo) {

            total += c.getReproducciones();
        }

        return total;
    }

    /*
     * SUMAR DURACIONES
     */
    public int getDuracionTotal() {

        int total = 0;

        for (Contenido c : catalogo) {

            total += c.getDuracion();
        }

        return total;
    }
}
