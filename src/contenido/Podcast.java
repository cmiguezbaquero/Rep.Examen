package contenido;

import excepciones.ContenidoNoDisponibleException;
import excepciones.ContenidoYaDescargadoException;
import excepciones.DuracionInvalidaException;
import interfaces.Reproducible;

import java.util.ArrayList;

public class Podcast extends Contenido implements Reproducible {

    private String creador;
    private ArrayList<String> invitados;
    private boolean descargado;

    /*
     * CONSTRUCTOR
     *
     * Siempre que una clase hereda de otra:
     * - primero super(...)
     * - luego atributos propios
     */
    public Podcast(String titulo,
                   int duracion,
                   String creador)
            throws DuracionInvalidaException {

        // Constructor de la clase padre
        super(titulo, duracion);

        // Atributos propios
        this.creador = creador;

        // Inicializar listas vacías
        this.invitados = new ArrayList<>();

        // Estado inicial
        this.descargado = false;
    }

    /*
     * Evitar duplicados
     *
     * Patrón típico de examen:
     *
     * if(!lista.contains(x)){
     *     lista.add(x);
     * }
     */
    public void agregarInvitado(String nombre) {

        if (!invitados.contains(nombre)) {

            invitados.add(nombre);
        }
    }

    /*
     * Método abstracto heredado de contenido.Contenido
     *
     * Patrón típico:
     *
     * 1. comprobar disponibilidad
     * 2. lanzar excepción si falla
     * 3. ejecutar acción
     * 4. actualizar contador
     */
    @Override
    public void reproducir()
            throws ContenidoNoDisponibleException {

        if (!disponible) {

            throw new ContenidoNoDisponibleException(
                    "contenido.Podcast no disponible");
        }

        play();

        aumentarReproducciones();
    }

    /*
     * Descarga del podcast
     *
     * Patrón típico:
     *
     * if(yaExiste)
     *      throw Exception
     *
     * marcar estado
     * return true
     */
    public boolean descargar()
            throws ContenidoYaDescargadoException {

        if (descargado) {

            throw new ContenidoYaDescargadoException(
                    "contenido.Podcast ya descargado");
        }

        descargado = true;

        return true;
    }

    /*
     * Implementación de interfaz
     */

    @Override
    public void play() {

        System.out.println(
                "Reproduciendo podcast: " + titulo);
    }

    @Override
    public void pause() {

        System.out.println(
                "contenido.Podcast pausado");
    }

    @Override
    public void stop() {

        System.out.println(
                "contenido.Podcast detenido");
    }

    @Override
    public int getDuracion() {

        return duracion;
    }

    /*
     * Getters y setters
     */

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public ArrayList<String> getInvitados() {
        return invitados;
    }

    public boolean isDescargado() {
        return descargado;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }
}