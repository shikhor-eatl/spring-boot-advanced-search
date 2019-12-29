package com.example.springbootadvancedsearch.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "has_gps")
    private String hasGPS;

    private String transmission;

    @JoinColumn(name = "active_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Active active;

    public String getHasGPS() {
        return hasGPS;
    }

    public void setHasGPS(String hasGPS) {
        this.hasGPS = hasGPS;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }
}
