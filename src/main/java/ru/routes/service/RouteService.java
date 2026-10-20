package ru.routes.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import ru.routes.dao.RouteDao;
import ru.routes.entity.Route;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class RouteService {

    @Inject
    private RouteDao routeDao;

    @Inject
    private Validator validator;

    public Route create(Route r) {
        validate(r);
        return routeDao.save(r);
    }

    public Route update(Route r) {
        validate(r);
        return routeDao.save(r);
    }

    public void delete(Long id) {
        routeDao.delete(id);
    }

    public Route find(Long id) {
        return routeDao.findById(id);
    }

    public List<Route> findAll() {
        return routeDao.findAll();
    }

    private void validate(Route r) {
        Set<ConstraintViolation<Route>> violations = validator.validate(r);
        if (!violations.isEmpty()) {
            String msg = violations.stream()
                    .map(c -> c.getPropertyPath() + ": " + c.getMessage())
                    .collect(Collectors.joining("; "));
            throw new IllegalArgumentException(msg);
        }
    }
}