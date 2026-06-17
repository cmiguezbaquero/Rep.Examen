package contenido;

import excepciones.ContenidoNoDisponibleException;
import excepciones.DuracionInvalidaException;
import interfaces.Reproducible;

public class Cancion extends Contenido
        implements Reproducible {

    /*
     * ATRIBUTOS PROPIOS DE LA CLASE
     *
     * Todo lo que NO tiene contenido.Contenido
     * se declara aquí.
     */
    private String artista;
    private boolean reproduciendo;

    /*
     * CONSTRUCTOR
     *
     * Como hereda de contenido.Contenido:
     *
     * SIEMPRE super(...)
     * antes de cualquier otra cosa.
     */
    public Cancion(
            String titulo,
            int duracion,
            String artista)
            throws DuracionInvalidaException {

        super(titulo, duracion);

        this.artista = artista;

        /*
         * Estado inicial
         */
        this.reproduciendo = false;
    }

    /*
     * MÉTODO ABSTRACTO DE CONTENIDO
     *
     * Estamos obligados a implementarlo.
     */
    @Override
    public void reproducir()
            throws ContenidoNoDisponibleException {

        /*
         * Comprobación típica de examen
         */
        if (!isDisponible()) {

            throw new ContenidoNoDisponibleException(
                    "Canción no disponible");
        }

        /*
         * Ejecutar acción
         */
        play();

        /*
         * Actualizar estadísticas
         */
        aumentarReproducciones();
    }

    /*
     * MÉTODOS DE LA INTERFAZ
     */

    @Override
    public void play() {

        reproduciendo = true;

        System.out.println(
                "Reproduciendo canción");
    }

    @Override
    public void pause() {

        if (reproduciendo) {

            System.out.println(
                    "Canción pausada");
        }
    }

    @Override
    public void stop() {

        reproduciendo = false;

        System.out.println(
                "Canción detenida");
    }

    /*
     * GETTER
     */

    public String getArtista() {

        return artista;
    }
}
