package com.example;

import org.junit.jupiter.api.Test;
import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.*;

class VendedorTest {

    @Test
    void testCalcularSalario() {
        Vendedor vendedor1 = new Vendedor("Ana Silva", YearMonth.of(2021, 12));
        assertEquals(12000.00 + (3 * 1800.00), vendedor1.calcularSalario(YearMonth.of(2025, 6)), 0.01);

        Vendedor vendedor2 = new Vendedor("João Mendes", YearMonth.of(2022, 1));
        assertEquals(12000.00 + (3 * 1800.00), vendedor2.calcularSalario(YearMonth.of(2025, 6)), 0.01);
    }

    @Test
    void testCalcularSalarioComComissao() {
        Vendedor vendedor = new Vendedor("Ana Silva", YearMonth.of(2021, 12));
        double salarioBaseAna = 12000.00 + (3 * 1800.00); 
        assertEquals(salarioBaseAna + (52000.00 * 0.30), vendedor.calcularSalarioComComissao(YearMonth.of(2025, 6), 52000.00), 0.01);
    }

    @Test
    void testCalcularBeneficio() {
        Vendedor vendedor = new Vendedor("Ana Silva", YearMonth.of(2021, 12));
        assertEquals(0.0, vendedor.calcularBeneficio(YearMonth.of(2025, 6)), 0.01);
    }

    @Test
    void testCalcularSalarioTotalComVendas() {
        Vendedor vendedor = new Vendedor("Ana Silva", YearMonth.of(2021, 12));
        double salarioBaseAna = 12000.00 + (3 * 1800.00); 
        assertEquals(salarioBaseAna + (52000.00 * 0.30), vendedor.calcularSalarioTotal(YearMonth.of(2025, 6), 52000.00), 0.01);
    }

    @Test
    void testCalcularSalarioTotalSemVendas() {
        Vendedor vendedor = new Vendedor("Ana Silva", YearMonth.of(2021, 12));
        double salarioBaseAna = 12000.00 + (3 * 1800.00); 
        assertEquals(salarioBaseAna, vendedor.calcularSalarioTotal(YearMonth.of(2025, 6), 0.0), 0.01);
        assertEquals(salarioBaseAna, vendedor.calcularSalarioTotal(YearMonth.of(2025, 6)), 0.01);
    }
}