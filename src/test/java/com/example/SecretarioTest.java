package com.example;

import org.junit.jupiter.api.Test;
import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.*;

class SecretarioTest {

    @Test
    void testCalcularSalario() {
        Secretario secretario1 = new Secretario("Jorge Carvalho", YearMonth.of(2018, 1));
        assertEquals(14000.00, secretario1.calcularSalario(YearMonth.of(2025, 6)), 0.01);

        Secretario secretario2 = new Secretario("Maria Souza", YearMonth.of(2023, 12));
        assertEquals(7000.00 + (1 * 1000.00), secretario2.calcularSalario(YearMonth.of(2025, 6)), 0.01);


        Secretario secretario3 = new Secretario("Carlos Silva", YearMonth.of(2025, 5));
        assertEquals(7000.00, secretario3.calcularSalario(YearMonth.of(2025, 6)), 0.01);
    }

    @Test
    void testCalcularBeneficio() {
        Secretario secretario1 = new Secretario("Jorge Carvalho", YearMonth.of(2018, 1));
        assertEquals(2800.00, secretario1.calcularBeneficio(YearMonth.of(2025, 6)), 0.01);

        Secretario secretario2 = new Secretario("Maria Souza", YearMonth.of(2023, 12));
        assertEquals(1600.00, secretario2.calcularBeneficio(YearMonth.of(2025, 6)), 0.01);
    }

    @Test
    void testCalcularSalarioTotal() {
        Secretario secretario1 = new Secretario("Jorge Carvalho", YearMonth.of(2018, 1));
        assertEquals(16800.00, secretario1.calcularSalarioTotal(YearMonth.of(2025, 6)), 0.01);
    }
}