package com.example;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Gerente extends Funcionario {
    private static final double SALARIO_BASE = 20000.00;
    private static final double BONUS_ANUAL = 3000.00;

    public Gerente(String nome, YearMonth dataContratacao) {
        super(nome, Cargo.GERENTE, dataContratacao);
    }

    @Override
    public double calcularSalario(YearMonth mesAno) {
        long anosDeServico = ChronoUnit.YEARS.between(getDataContratacao(), mesAno);
        return SALARIO_BASE + (anosDeServico * BONUS_ANUAL);
    }

    @Override
    public double calcularBeneficio(YearMonth mesAno) {
        return 0;
    }
}
