package com.webhostapp.mantis_bugtracker.mantisbt.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Usuarios.feature",
        glue = {"classpath:com.webhostapp.mantis_bugtracker.mantisbt.stepdefinitions",
                "classpath:com.webhostapp.mantis_bugtracker.mantisbt.hooks"})
public class UsuariosTest {
}
