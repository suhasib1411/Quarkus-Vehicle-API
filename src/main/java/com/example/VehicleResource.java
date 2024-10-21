package com.example;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;


public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    InsuranceService insuranceService;



    @Incoming("pan-in")  // Listen for PANID from Kafka
    public void consumePanID(String panID) {
        vehicleRepository.findByPanID(panID)
                .onItem().transformToUni(vehicle -> {
                    String bestInsurance = getBestInsurance(vehicle);
                    insuranceEmitter.send(bestInsurance);  // Send best insurance via Kafka
                    return Uni.createFrom().voidItem();
                }).subscribe().with(result -> {});
    }


    @Inject
    @Channel("insurance-out")  // Kafka topic to send best insurance
    Emitter<String> insuranceEmitter;
    private String getBestInsurance(Vehicle vehicle) {

        Uni<InsurancePolicy> policy = insuranceService.getBestPolicy();
        return policy.toString();
    }
}
