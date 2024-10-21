package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@ApplicationScoped
public class InsuranceService {

    private static final String POLICY_FILE = "policies.json";

    // Read the JSON file and return a list of policies asynchronously
    public Uni<InsurancePolicy> getBestPolicy() {
        return Uni.createFrom().item(() -> {
            ObjectMapper mapper = new ObjectMapper();
            List<InsurancePolicy> policies;
            // Mocked Data stored in policies.json
            try (InputStream is = getClass().getClassLoader().getResourceAsStream(POLICY_FILE)) {
                if (is == null) {
                    throw new IOException("Policy file not found");
                }
                policies = mapper.readValue(is, new TypeReference<List<InsurancePolicy>>() {});
            } catch (IOException e) {
                throw new RuntimeException("Error reading policies", e);
            }

            // Apply rules to select the best policy (basic rule: the one with the highest rating)
            return policies.stream()
                    .max((p1, p2) -> Double.compare(p1.getRating(), p2.getRating()))
                    .orElseThrow(() -> new RuntimeException("No policies available"));
        });
    }
}