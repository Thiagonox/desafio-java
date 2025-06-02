package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class FolhaDePagamentoTest {

    private List<Funcionario> funcionarios;
    private Map<String, Double> vendas;
    private FolhaDePagamento folhaDePagamento;
    private YearMonth mesAnoReferencia = YearMonth.of(2022, 4); 
    private YearMonth mesAnoAtual = YearMonth.of(2025, 6); 

    @BeforeEach
    void setUp() {
        folhaDePagamento = new FolhaDePagamento();
        funcionarios = new ArrayList<>();
        vendas = new HashMap<>();

        funcionarios.add(new Secretario("Jorge Carvalho", YearMonth.of(2018, 1)));
        funcionarios.add(new Secretario("Maria Souza", YearMonth.of(2015, 12)));

        Vendedor ana = new Vendedor("Ana Silva", YearMonth.of(2021, 12));
        Vendedor joao = new Vendedor("João Mendes", YearMonth.of(2021, 12));
        funcionarios.add(ana);
        funcionarios.add(joao);

        vendas.put("Ana Silva", 5200.00); 
        vendas.put("João Mendes", 3400.00); 

        funcionarios.add(new Gerente("Juliana Paes", YearMonth.of(2017, 7)));
        funcionarios.add(new Gerente("Bento Albino", YearMonth.of(2014, 3)));
    }

    @Test
    void testCalcularTotalPagoEmAbril2022() {
        double totalEsperado = 0;
        totalEsperado += (7000 + 4 * 1000) * 1.20;
        totalEsperado += (7000 + 6 * 1000) * 1.20;
        totalEsperado += (12000 + 0 * 1800) + (5200 * 0.30);
        totalEsperado += (12000 + 0 * 1800) + (3400 * 0.30);
        totalEsperado += (20000 + 4 * 3000);
        totalEsperado += (20000 + 8 * 3000);
        assertEquals(totalEsperado, folhaDePagamento.calcularTotalPago(funcionarios, mesAnoReferencia, vendas), 0.01);
    }

    @Test
    void testCalcularTotalSalariosEmAbril2022() {
        double totalSalariosEsperado = 0;
        totalSalariosEsperado += (7000 + 4 * 1000);
        totalSalariosEsperado += (7000 + 6 * 1000);
        totalSalariosEsperado += (12000 + 0 * 1800);
        totalSalariosEsperado += (12000 + 0 * 1800);
        totalSalariosEsperado += (20000 + 4 * 3000);
        totalSalariosEsperado += (20000 + 8 * 3000);
        assertEquals(totalSalariosEsperado, folhaDePagamento.calcularTotalSalarios(funcionarios, mesAnoReferencia), 0.01);
    }

    @Test
    void testCalcularTotalBeneficiosEmAbril2022() {
        double totalBeneficiosEsperado = 0;
        totalBeneficiosEsperado += (7000 + 4 * 1000) * 0.20;
        totalBeneficiosEsperado += (7000 + 6 * 1000) * 0.20;
        totalBeneficiosEsperado += 5200 * 0.30;
        totalBeneficiosEsperado += 3400 * 0.30;
        assertEquals(totalBeneficiosEsperado, folhaDePagamento.calcularTotalBeneficios(funcionarios, mesAnoReferencia, vendas), 0.01);
    }

    @Test
    void testFuncionarioComMaiorPagamentoEmAbril2022() {
        assertEquals("Bento Albino", folhaDePagamento.funcionarioComMaiorPagamento(funcionarios, mesAnoReferencia, vendas).getNome());
    }

    @Test
    void testNomeFuncionarioComMaiorBeneficioEmAbril2022() {
        assertEquals("Maria Souza", folhaDePagamento.nomeFuncionarioComMaiorBeneficio(funcionarios, mesAnoReferencia, vendas));
    }

    @Test
    void testVendedorComMaiorVendaEmAbril2022() {
        List<Vendedor> vendedores = new ArrayList<>();
        for(Funcionario f : funcionarios) {
            if (f instanceof Vendedor) {
                vendedores.add((Vendedor) f);
            }
        }
        assertEquals("Ana Silva", folhaDePagamento.vendedorComMaiorVenda(vendedores, mesAnoReferencia, vendas).getNome());
    }

    @Test
    void testCalcularTotalPagoEmJunho2025() {
        Map<String, Double> vendasJunho2025 = new HashMap<>();
        vendasJunho2025.put("Ana Silva", 60000.00); 
        vendasJunho2025.put("João Mendes", 50000.00); 

        double totalEsperado = 0;
        totalEsperado += (7000 + 7 * 1000) * 1.20;
        totalEsperado += (7000 + 9 * 1000) * 1.20;
        totalEsperado += (12000 + 3 * 1800) + (60000 * 0.30);
        totalEsperado += (12000 + 3 * 1800) + (50000 * 0.30);
        totalEsperado += (20000 + 7 * 3000);
        totalEsperado += (20000 + 11 * 3000);
        assertEquals(totalEsperado, folhaDePagamento.calcularTotalPago(funcionarios, mesAnoAtual, vendasJunho2025), 0.01);
    }
}