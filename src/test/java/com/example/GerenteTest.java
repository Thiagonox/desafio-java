package com.example;

import org.junit.jupiter.api.Test;
import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.*;

class GerenteTest {

    @Test
    void testCalcularSalario() {
        Gerente gerente1 = new Gerente("Juliana Paes", YearMonth.of(2017, 3));
        assertEquals(20000.00 + (8 * 3000.00), gerente1.calcularSalario(YearMonth.of(2025, 6)), 0.01);

        Gerente gerente2 = new Gerente("Bento Albino", YearMonth.of(2024, 3));
        assertEquals(20000.00 + (1 * 3000.00), gerente2.calcularSalario(YearMonth.of(2025, 6)), 0.01);
    }

    @Test
    void testCalcularBeneficio() {
        Gerente gerente = new Gerente("Juliana Paes", YearMonth.of(2017, 3));
        assertEquals(0.0, gerente.calcularBeneficio(YearMonth.of(2025, 6)), 0.01);
    }

    @Test
    void testCalcularSalarioTotal() {
        Gerente gerente = new Gerente("Juliana Paes", YearMonth.of(2017, 3));
        assertEquals(44000.00, gerente.calcularSalarioTotal(YearMonth.of(2025, 6)), 0.01);
    }
}