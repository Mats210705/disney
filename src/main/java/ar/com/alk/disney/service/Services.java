package ar.com.alk.disney.service;

import java.util.List;

public interface Services<T, E> {
    /**
     * @param dto//recibe
     * @return //retorna
     */
    T createNew(T dto); //cuando se implemente el servicio se ejecuta

    /**
     * @return
     */
    List<T> getAll(); //retorna la lista de la entidad

    /**
     * @param id
     * @return
     */
    T getById(Long id); //buscar por Id

    /**
     * @param dto
     * @param id
     * @return
     */
    T update(T dto, Long id); //actualizar

    /**
     * @param id
     */
    void remove(Long id); //eliminar

    /**
     * @param entity
     * @param dto
     */
    void mergeData(E entity, T dto);

}
