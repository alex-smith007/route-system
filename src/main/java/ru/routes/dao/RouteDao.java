package ru.routes.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.routes.entity.Route;

import java.util.List;

@Stateless
public class RouteDao {

    @PersistenceContext(unitName = "routePU")
    private EntityManager em;

    public Route findById(Long id) {
        return em.find(Route.class, id);
    }

    public List<Route> findAll() {
        return em.createQuery("SELECT r FROM Route r ORDER BY r.id", Route.class)
                .getResultList();
    }

    public Route save(Route r) {
        if (r.getId() == null) {
            em.persist(r);
            return r;
        }
        return em.merge(r);
    }

    public void delete(Long id) {
        Route r = em.find(Route.class, id);
        if (r != null) em.remove(r);
    }
}
