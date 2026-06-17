package contenido;

import excepciones.ContenidoNoDisponibleException;
import excepciones.DuracionInvalidaException;

public abstract class Contenido {

    protected String titulo;
    protected int duracion;
    protected boolean disponible;
    protected int reproducciones;

    /*
     * CONSTRUCTOR
     *
     * Patrón típico:
     * - validar datos
     * - inicializar atributos
     */
    public Contenido(String titulo,
                     int duracion)
            throws DuracionInvalidaException {

        // Validación
        if (duracion <= 0) {

            throw new DuracionInvalidaException
                    ("La duración debe ser mayor que 0");
        }

        // Inicialización
        this.titulo = titulo;
        this.duracion = duracion;

        // Valores por defecto
        this.disponible = true;
        this.reproducciones = 0;
    }

    /*
     * Incrementar reproducciones
     *
     * Patrón:
     * contador++
     */
    public void aumentarReproducciones() {

        reproducciones++;
    }

    /*
     * Método abstracto
     *
     * Las clases hijas (contenido.Podcast, contenido.Cancion...)
     * están obligadas a implementarlo.
     */
    public abstract void reproducir()
            throws ContenidoNoDisponibleException;

    /*
     * GETTERS Y SETTERS
     */

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }
}
