package com.p5.adoptions.service.exceptions;


public class ShelterAddressException extends RuntimeException
{

    private Violation violation;

    public ShelterAddressException(String message)
    {
        super(message);

    }

    public ShelterAddressException(Violation violation) {
        this.violation = violation;
    }

    public Violation getViolation() {
        return violation;
    }

    public ShelterAddressException setViolation(Violation violation) {
        this.violation = violation;
        return this;
    }
}
