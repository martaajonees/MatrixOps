package com.uca.mps.MatrixPro.App;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class MatrixController {
    @Autowired
    private MatrixOperations matrixOperations;

    @PostMapping("/sumar")
    public int[][] sumarMatrices(@RequestBody MatricesRequest request){
        return matrixOperations.suma(request.getMatrizA(), request.getMatrizB());
    }

    @PostMapping("/restar")
    public int[][] restarMatrices(@RequestBody MatricesRequest request) {
        return matrixOperations.resta(request.getMatrizA(), request.getMatrizB());
    }

    @PostMapping("/multiplicar")
    public int[][] multiplicarMatrices(@RequestBody MatricesRequest request) {
        return matrixOperations.producto(request.getMatrizA(), request.getMatrizB());
    }

    @PostMapping("/dividir")
    public ResponseEntity<Object> dividirMatrices(@RequestBody MatricesRequest request) {
        try {
            int[][] result = matrixOperations.division(request.getMatrizA(), request.getMatrizB());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @PostMapping("/escalar")
    public int[][] escalarMatriz(@RequestParam int escalar, @RequestBody MatricesRequest request) {
        return matrixOperations.escalar(request.getMatrizA(), escalar);
    }

    @PostMapping("/simetrica")
    public boolean esSimetrica(@RequestBody MatricesRequest request) {
        return matrixOperations.simetrica(request.getMatrizA());
    }

    @PostMapping("/transpuesta")
    public int[][] transpuesta(@RequestBody MatricesRequest request) {
        return matrixOperations.transpuesta(request.getMatrizA());
    }
}
