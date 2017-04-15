package id.demo.crude.service;

import id.demo.crude.common.Result;

import java.util.List;

public interface BaseService<T> {

    Result save(final T entity);

    Result delete(final T entity);

    T findById(final int id);

    /**
     * Get all data with and without any parameter
     */
    List<T> find(T param, int offset, int limit);


    /**
     * Count all data with and without any parameter
     * <p>You can include the parameter using ${@link T} class
     *
     * @return
     */
    int count(T param);

}
