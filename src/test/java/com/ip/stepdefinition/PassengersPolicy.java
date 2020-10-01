package com.ip.stepdefinition;

import com.ip.airport.BusinessFlight;
import com.ip.airport.EconomyFlight;
import com.ip.airport.Flight;
import com.ip.airport.Passenger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PassengersPolicy {

    private Flight economyFlight;
    private Flight businessFlight;
    private Passenger Anubhav;
    private Passenger Pratap;

    @Given("there is an economy flight")
    public void thereIsAnEconomyFlight() {
        economyFlight = new EconomyFlight("1");
    }

    @When("we have a usual passenger")
    public void weHaveAUsualPassenger() {
        Anubhav  = new Passenger("Anubhav", false);
    }

    @Then("you can add and remove him from an economy flight")
    public void youCanAddAndRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(Anubhav)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("Anubhav", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(true, economyFlight.removePassenger(Anubhav)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
    }

    @When("we have a VIP passenger")
    public void weHaveAVIPPassenger() {
        Pratap = new Passenger("Pratap", true);
    }

    @Then("you can add him but cannot remove him from an economy flight")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a VIP passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(Pratap)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("Pratap", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(false, economyFlight.removePassenger(Pratap)),
                () -> assertEquals(1, economyFlight.getPassengersList().size())
        );
    }

    @Given("there is an business flight")
    public void thereIsAnBusinessFlight() {
        businessFlight = new BusinessFlight("2");
    }

    @Then("you cannot add or remove him from a business flight")
    public void youCannotAddOrRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> assertEquals(false, businessFlight.addPassenger(Anubhav)),
                () -> assertEquals(0, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(Anubhav)),
                () -> assertEquals(0, businessFlight.getPassengersList().size())
        );
    }

    @Then("you can add him but cannot remove him from a business flight")
    public void youCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a VIP passenger and a business flight",
                () -> assertEquals(true, businessFlight.addPassenger(Pratap)),
                () -> assertEquals(1, businessFlight.getPassengersList().size()),
                () -> assertEquals(false, businessFlight.removePassenger(Pratap)),
                () -> assertEquals(1, businessFlight.getPassengersList().size())
        );
    }
}
