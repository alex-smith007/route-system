package ru.routes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int x;

    @NotNull
    @Column(nullable = false)
    private Integer y;

    @Column(nullable = false)
    private int z;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public Integer getY() { return y; }
    public void setY(Integer y) { this.y = y; }
    public int getZ() { return z; }
    public void setZ(int z) { this.z = z; }
}