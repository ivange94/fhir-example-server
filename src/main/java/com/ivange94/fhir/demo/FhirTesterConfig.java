package com.ivange94.fhir.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.to.FhirTesterMvcConfig;
import ca.uhn.fhir.to.TesterConfig;

@Configuration
@Import(FhirTesterMvcConfig.class)
public class FhirTesterConfig {

    @Bean
    public TesterConfig testerConfig() {
        TesterConfig retVal = new TesterConfig();
        retVal
                .addServer()
                .withId("home")
                .withFhirVersion(FhirVersionEnum.DSTU3)
                .withBaseUrl("${serverBase}/baseDstu3")
                .withName("Local Tester")
                .addServer()
                .withId("hapi")
                .withFhirVersion(FhirVersionEnum.DSTU3)
                .withBaseUrl("http://fhirtest.uhn.ca/baseDstu3")
                .withName("Public HAPI Test Server");
        return retVal;
    }
}
