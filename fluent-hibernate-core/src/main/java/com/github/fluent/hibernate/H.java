package com.github.fluent.hibernate;

import com.github.fluent.hibernate.request.HibernateDoInTransaction;
import com.github.fluent.hibernate.request.HibernateHqlRequest;
import com.github.fluent.hibernate.request.HibernateObjectQuery;
import com.github.fluent.hibernate.request.HibernateRequest;
import com.github.fluent.hibernate.request.HibernateSqlRequest;
import com.github.fluent.hibernate.request.HibernateUpdate;

/**
 * Hibernate fluent API entry point.
 *
 * @author DoubleF1re
 * @author V.Ladynev
 */
public final class H {

    private H() {

    }

    public static <T> HibernateRequest<T> request(Class<?> clazz) {
        return HibernateRequest.<T> create(clazz);
    }

    public static <T> HibernateHqlRequest<T> request(String query) {
        return HibernateHqlRequest.<T> create(query);
    }

    public static <T> HibernateSqlRequest<T> sqlRequest(String query) {
        return HibernateSqlRequest.<T> create(query);
    }

    public static HibernateUpdate update(String updateQuery) {
        return HibernateUpdate.create(updateQuery);
    }

    public static <T> T getById(Class<T> clazz, Object id) {
        return H.<T> request(clazz).idEq(id).first();
    }

    public static <T> T save(T entity) {
        return HibernateObjectQuery.save(entity);
    }

    public static <T> T saveOrUpdate(T entity) {
        return HibernateObjectQuery.saveOrUpdate(entity);
    }

    public static <T> Iterable<T> saveOrUpdateAll(Iterable<T> entities) {
        return HibernateObjectQuery.saveOrUpdateAll(entities);
    }

    public static <T> Iterable<T> saveAll(Iterable<T> entities) {
        return HibernateObjectQuery.saveAll(entities);
    }

    public static <T> void delete(T entity) {
        HibernateObjectQuery.delete(entity);
    }

    public static <T> void deleteById(Class<T> clazz, Object id) {
        HibernateObjectQuery.delete(getById(clazz, id));
    }

    public static <T> void deleteAll(Iterable<T> entities) {
        HibernateObjectQuery.deleteAll(entities);
    }

    public static <T> T request(IRequest<T> request) {
        return HibernateDoInTransaction.execute(request);
    }

}
