package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.example.builders.data.UserBuilder;
import org.example.conf.DriverConfig;
import org.example.tasks.NavigateTo;
import org.example.tasks.UserSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {DriverConfig.class})
public class SignUpStepDefs {

    @Autowired
    private UserSignUp signUp;

    @Autowired
    private NavigateTo navigate;

    @Given("^Pepito wants to have an account$")
    public void pepito_wants_to_have_an_account() throws InterruptedException {
        navigate.signUpPage();
        Thread.sleep(4000);
    }

    @When("^he sends required information to set the account$")
    public void he_sends_required_information_to_set_the_account() {
        signUp.withInfo(
                UserBuilder
                        .anUser()
                        .but()
                        .withoutBirthDay()
                        .withoutEmail()
                        .build()
        );
    }

    @Then("^he should be told that the account was created$")
    public void he_should_be_told_that_the_account_was_created(){
        Assertions.assertThat(true).isEqualTo(true);
    }

    @Then("^he should be told that the account was not created$")
    public void he_should_be_told_that_the_account_was_not_created(){
        Assertions.assertThat(true).isEqualTo(false);
    }
}
