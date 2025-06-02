package com.example;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class FolhaDePagamento {

    public double calcularTotalPago(List<Funcionario> funcionarios, YearMonth mesAno, Map<String, Double> vendas) {
        double totalPago = 0;
        for (Funcionario f : funcionarios) {
            if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                double valorVendas = vendas.getOrDefault(v.getNome(), 0.0);
                totalPago += v.calcularSalarioTotal(mesAno, valorVendas);
            } else {
                totalPago += f.calcularSalarioTotal(mesAno);
            }
        }
        return totalPago;
    }

    public double calcularTotalSalarios(List<Funcionario> funcionarios, YearMonth mesAno) {
        double totalSalarios = 0;
        for (Funcionario f : funcionarios) {
            totalSalarios += f.calcularSalario(mesAno);
        }
        return totalSalarios;
    }

    public double calcularTotalBeneficios(List<Funcionario> funcionarios, YearMonth mesAno, Map<String, Double> vendas) {
        double totalBeneficios = 0;
        for (Funcionario f : funcionarios) {
            if (f.getCargo() == Cargo.SECRETARIO) {
                totalBeneficios += f.calcularBeneficio(mesAno);
            } else if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                double valorVendas = vendas.getOrDefault(v.getNome(), 0.0);
                totalBeneficios += valorVendas * 0.30;
            }
        }
        return totalBeneficios;
    }

    public Funcionario funcionarioComMaiorPagamento(List<Funcionario> funcionarios, YearMonth mesAno, Map<String, Double> vendas) {
        Funcionario maiorPagamento = null;
        double maxValor = Double.NEGATIVE_INFINITY;

        for (Funcionario f : funcionarios) {
            double pagamentoAtual;
            if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                double valorVendas = vendas.getOrDefault(v.getNome(), 0.0);
                pagamentoAtual = v.calcularSalarioTotal(mesAno, valorVendas);
            } else {
                pagamentoAtual = f.calcularSalarioTotal(mesAno);
            }

            if (pagamentoAtual > maxValor) {
                maxValor = pagamentoAtual;
                maiorPagamento = f;
            }
        }
        return maiorPagamento;
    }

    public String nomeFuncionarioComMaiorBeneficio(List<Funcionario> funcionarios, YearMonth mesAno, Map<String, Double> vendas) {
        Funcionario maiorBeneficioFunc = null;
        double maxBeneficio = Double.NEGATIVE_INFINITY;

        for (Funcionario f : funcionarios) {
            double beneficioAtual = 0;
            if (f.getCargo() == Cargo.SECRETARIO) {
                beneficioAtual = f.calcularBeneficio(mesAno);
            } else if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                double valorVendas = vendas.getOrDefault(v.getNome(), 0.0);
                beneficioAtual = valorVendas * 0.30;
            }

            if (beneficioAtual > maxBeneficio) {
                maxBeneficio = beneficioAtual;
                maiorBeneficioFunc = f;
            }
        }
        return maiorBeneficioFunc != null ? maiorBeneficioFunc.getNome() : "N/A";
    }

    public Vendedor vendedorComMaiorVenda(List<Vendedor> vendedores, YearMonth mesAno, Map<String, Double> vendas) {
        Vendedor maiorVendedor = null;
        double maxVendas = Double.NEGATIVE_INFINITY;

        for (Vendedor v : vendedores) {
            double valorVendas = vendas.getOrDefault(v.getNome(), 0.0);
            if (valorVendas > maxVendas) {
                maxVendas = valorVendas;
                maiorVendedor = v;
            }
        }
        return maiorVendedor;
    }
}
