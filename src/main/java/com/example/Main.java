package com.example;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        YearMonth mesReferencia = YearMonth.of(2022, 4);

        List<Funcionario> funcionarios = new ArrayList<>();
        Secretario jorge = new Secretario("Kakashi Hatake", YearMonth.of(2018, 1));
        Secretario maria = new Secretario("Sakura Haruno", YearMonth.of(2015, 12));
        funcionarios.add(jorge);
        funcionarios.add(maria);

        Vendedor ana = new Vendedor("Naruto Uzumaki", YearMonth.of(2021, 12));
        Vendedor joao = new Vendedor("Sasuke Uchiha", YearMonth.of(2021, 12));
        funcionarios.add(ana);
        funcionarios.add(joao);

        Gerente juliana = new Gerente("Tsunade Senju", YearMonth.of(2017, 7));
        Gerente bento = new Gerente("Jiraiya", YearMonth.of(2014, 3));
        funcionarios.add(juliana);
        funcionarios.add(bento);

        Map<String, Double> vendas = new HashMap<>();
        vendas.put("Naruto Uzumaki", 5200.00);
        vendas.put("João Mendes", 3400.00);

        FolhaDePagamento folha = new FolhaDePagamento();

        System.out.println("--- Folha de Pagamento para " + mesReferencia + " ---");

        double totalPago = folha.calcularTotalPago(funcionarios, mesReferencia, vendas);
        System.out.printf("1. Valor total pago (salários + benefícios): R$ %.2f%n", totalPago);

        double totalSalarios = folha.calcularTotalSalarios(funcionarios, mesReferencia);
        System.out.printf("2. Total pago somente em salários: R$ %.2f%n", totalSalarios);

        double totalBeneficios = folha.calcularTotalBeneficios(funcionarios, mesReferencia, vendas);
        System.out.printf("3. Total pago somente em benefícios: R$ %.2f%n", totalBeneficios);

        Funcionario maiorPagamentoFunc = folha.funcionarioComMaiorPagamento(funcionarios, mesReferencia, vendas);
        if (maiorPagamentoFunc != null) {
            System.out.println("4. Funcionário com maior pagamento: " + maiorPagamentoFunc.getNome());
        }

        String nomeMaiorBeneficio = folha.nomeFuncionarioComMaiorBeneficio(funcionarios, mesReferencia, vendas);
        System.out.println("5. Nome do funcionário com maior benefício: " + nomeMaiorBeneficio);

        List<Vendedor> vendedores = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f instanceof Vendedor) {
                vendedores.add((Vendedor) f);
            }
        }
        Vendedor maiorVendedor = folha.vendedorComMaiorVenda(vendedores, mesReferencia, vendas);
        if (maiorVendedor != null) {
            System.out.println("6. Vendedor que mais vendeu: " + maiorVendedor.getNome());
        }

        System.out.println("\n--- Detalhamento Individual para " + mesReferencia + " ---");
        for (Funcionario f : funcionarios) {
            double salario = f.calcularSalario(mesReferencia);
            double beneficio = 0;
            double salarioTotal;

            if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                double valorVendas = vendas.getOrDefault(v.getNome(), 0.0);
                salarioTotal = v.calcularSalarioTotal(mesReferencia, valorVendas);
                beneficio = valorVendas * 0.30; 
            } else {
                beneficio = f.calcularBeneficio(mesReferencia);
                salarioTotal = f.calcularSalarioTotal(mesReferencia);
            }
            System.out.printf("Funcionário: %s, Cargo: %s, Salário Base (com bônus por tempo): R$ %.2f, Benefício/Comissão: R$ %.2f, Salário Total: R$ %.2f%n",
                    f.getNome(), f.getCargo(), salario, beneficio, salarioTotal);
        }
    }
}
