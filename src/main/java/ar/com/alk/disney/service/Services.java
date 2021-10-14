package ar.com.alk.disney.service;




import ar.com.alk.disney.model.dto.GeneroDTO;

import java.util.List;
//Inrterface: define contratos de metodos que deben implementarse
// en las clases donde se extiende las interfaces.
//service:permite que Spring reconozca a SampleService como servicio al escanear
// los componentes de la aplicación.
public interface Services<T, E> { //generic se indica que va a ser de algun tipo
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
     * @return
     */
    GeneroDTO remove(Long id); //eliminar

    /**
     * @param entity
     * @param dto
     */
    void mergeData(E entity, T dto);

}
