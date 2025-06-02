package com.example;

import java.time.YearMonth;

public abstract class Funcionario {
    private String nome;
    private Cargo cargo;
    private YearMonth dataContratacao;

    public Funcionario(String nome, Cargo cargo, YearMonth dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public YearMonth getDataContratacao() {
        return dataContratacao;
    }

    public abstract double calcularSalario(YearMonth mesAno);
    public abstract double calcularBeneficio(YearMonth mesAno);

    public double calcularSalarioTotal(YearMonth mesAno) {
        return calcularSalario(mesAno) + calcularBeneficio(mesAno);
    }
}
