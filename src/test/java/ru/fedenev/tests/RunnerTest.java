package ru.fedenev.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"ru/fedenev/framework/steps"},
        tags = "@regress",
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class RunnerTest {
}