package ru.routes.bean;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import ru.routes.entity.Coordinates;
import ru.routes.entity.Location;
import ru.routes.entity.Route;
import ru.routes.service.RouteService;

import java.io.Serializable;

@Named
@ViewScoped
public class RouteEditBean implements Serializable {

    @Inject
    private RouteService routeService;

    private Route route;
    private Coordinates coordinates;
    private Location from;
    private Location to;

    @PostConstruct
    public void init() {
        route = new Route();
        coordinates = new Coordinates();
        from = new Location();
        to = new Location();
    }

    public String save() {
        try {
            route.setCoordinates(coordinates);
            route.setFrom(from);
            if (to.getY() == null) {
                route.setTo(null);
            } else {
                route.setTo(to);
            }

            if (route.getId() == null) {
                routeService.create(route);
            } else {
                routeService.update(route);
            }
            return "index?faces-redirect=true";
        } catch (IllegalArgumentException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка валидации", e.getMessage()));
            return null;
        }
    }


    public Route getRoute() { return route; }
    public Coordinates getCoordinates() { return coordinates; }
    public Location getFrom() { return from; }
    public Location getTo() { return to; }
}