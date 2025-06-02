package com.example;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Secretario extends Funcionario {
    private static final double SALARIO_BASE = 7000.00;
    private static final double BONUS_ANUAL = 1000.00;
    private static final double BENEFICIO_PERCENTUAL = 0.20;

    public Secretario(String nome, YearMonth dataContratacao) {
        super(nome, Cargo.SECRETARIO, dataContratacao);
    }

    @Override
    public double calcularSalario(YearMonth mesAno) {
        long anosDeServico = ChronoUnit.YEARS.between(getDataContratacao(), mesAno);
        return SALARIO_BASE + (anosDeServico * BONUS_ANUAL);
    }

    @Override
    public double calcularBeneficio(YearMonth mesAno) {
        return calcularSalario(mesAno) * BENEFICIO_PERCENTUAL;
    }
}
