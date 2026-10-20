package ru.routes.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import ru.routes.entity.Route;
import ru.routes.service.RouteService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RouteListBean implements Serializable {

    @Inject
    private RouteService routeService;

    private List<Route> routes;

    @PostConstruct
    public void init() {
        refresh();
    }

    public void refresh() {
        routes = routeService.findAll();
    }

    public void delete(Route r) {
        try {
            routeService.delete(r.getId());
            refresh();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка удаления", e.getMessage()));
        }
    }

    public List<Route> getRoutes() {
        return routes;
    }
}