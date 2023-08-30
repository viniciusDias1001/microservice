package io.github.Vinicius1001.CambioService.controller;

import io.github.Vinicius1001.CambioService.model.Cambio;
import io.github.Vinicius1001.CambioService.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
@Tag(name = "Cambio service api")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository cambioRepository;

    public CambioController(Environment environment, CambioRepository cambioRepository) {
        this.environment = environment;
        this.cambioRepository = cambioRepository;
    }

    @GetMapping(value = "/{amount}/{from}/{to}")
    @Operation(description = "get cambio from currency")
    public Cambio getCambio(@PathVariable("amount")BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to){
        var port = environment.getProperty("local.server.port");
        var cambio = cambioRepository.findByFromAndTo(from,to);
        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        if (cambio == null) throw new RuntimeException(("Currency Unsupported"));

        cambio.setEnvironment(port);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        return cambio;
    }



}

