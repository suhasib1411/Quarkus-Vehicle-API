package com.example;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {
    public Uni<Vehicle> findByPanID(String panID) {
        return find("panID", panID).firstResult();
    }
}
