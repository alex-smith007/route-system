package ru.routes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "coordinates")
public class Coordinates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Min(-267)
    private Long x;

    @NotNull
    @Column(nullable = false)
    private Float y;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getX() { return x; }
    public void setX(Long x) { this.x = x; }
    public Float getY() { return y; }
    public void setY(Float y) { this.y = y; }
}