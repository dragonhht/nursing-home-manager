package com.github.dragonhht.manager.service.base;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * 基本service.
 * User: huang
 * Date: 18-9-20
 */
public interface BaseService<T, R> {

    int DEFAULT_PAGE_SIZE = 20;

    T save(T model) throws Exception;

    void delete(R id) throws Exception;

    void update(T model) throws Exception;

    Optional<T> findById(R id) throws Exception;

    List<T> findAll() throws Exception;

    Page<T> findAllByPage(int pageNum, int limit) throws Exception;

}
