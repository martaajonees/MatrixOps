package uca.mps.controller;

import uca.mps.model.MatricesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uca.mps.service.MatrixOperations;

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
    public int[][] dividirMatrices(@RequestBody MatricesRequest request) {
        return matrixOperations.division(request.getMatrizA(), request.getMatrizB());
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
