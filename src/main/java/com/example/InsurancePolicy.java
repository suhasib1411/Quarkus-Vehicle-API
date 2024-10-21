package com.example;

public class InsurancePolicy {
    private String policyId;
    private String provider;
    private double premium;
    private double coverageAmount;
    private double rating;

    // Getters and Setters
    public String getPolicyId() { return policyId; }
    public void setPolicyId(String policyId) { this.policyId = policyId; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public double getPremium() { return premium; }
    public void setPremium(double premium) { this.premium = premium; }

    public double getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(double coverageAmount) { this.coverageAmount = coverageAmount; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "InsurancePolicy {" +
                "Policy ID='" + policyId + '\'' +
                ", Provider='" + provider + '\'' +
                ", Premium=" + premium +
                ", Coverage Amount=" + coverageAmount +
                ", Rating=" + rating +
                '}';
    }

}