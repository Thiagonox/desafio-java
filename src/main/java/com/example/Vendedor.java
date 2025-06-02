package com.example;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Vendedor extends Funcionario {
    private static final double SALARIO_BASE = 12000.00;
    private static final double BONUS_ANUAL = 1800.00;
    private static final double COMISSAO_PERCENTUAL = 0.30;

    public Vendedor(String nome, YearMonth dataContratacao) {
        super(nome, Cargo.VENDEDOR, dataContratacao);
    }

    @Override
    public double calcularSalario(YearMonth mesAno) {
        long anosDeServico = ChronoUnit.YEARS.between(getDataContratacao(), mesAno);
        return SALARIO_BASE + (anosDeServico * BONUS_ANUAL);
    }

    public double calcularSalarioComComissao(YearMonth mesAno, double valorVendas) {
        return calcularSalario(mesAno) + (valorVendas * COMISSAO_PERCENTUAL);
    }

    @Override
    public double calcularBeneficio(YearMonth mesAno) {
        return 0;
    }

    public double calcularSalarioTotal(YearMonth mesAno, double valorVendas) {
        return calcularSalarioComComissao(mesAno, valorVendas);
    }

     @Override
    public double calcularSalarioTotal(YearMonth mesAno) {
        return calcularSalario(mesAno);
    }
}
