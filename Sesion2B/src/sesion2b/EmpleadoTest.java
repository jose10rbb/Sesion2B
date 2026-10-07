package sesion2b;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

    // ==========================================
    // PRUEBAS DE VALORES LÍMITE: calculoNominaBruta
    // ==========================================

    @Test
    void testNominaBrutaVendedorLimiteInferiorPrima100() {
        // Ventas en 999 (justo debajo de 1000): prima = 0. Total = 2000
        assertEquals(2000.0f, Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 999.0f, 0.0f));
    }

    @Test
    void testNominaBrutaVendedorLimiteExactoPrima100() {
        // Ventas en 1000 (frontera): prima = 100. Total = 2100
        assertEquals(2100.0f, Empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1000.0f, 0.0f));
    }

    @Test
    void testNominaBrutaEncargadoLimiteInferiorPrima200() {
        // Ventas en 1499 (justo debajo de 1500): prima = 100. Total = 2500 + 100 = 2600
        assertEquals(2600.0f, Empleado.calculoNominaBruta(TipoEmpleado.Encargado, 1499.0f, 0.0f));
    }

    @Test
    void testNominaBrutaEncargadoLimiteExactoPrima200ConHoras() {
        // Ventas en 1500: prima = 200. Horas extra = 2 (60 €). Total = 2500 + 200 + 60 = 2760
        assertEquals(2760.0f, Empleado.calculoNominaBruta(TipoEmpleado.Encargado, 1500.0f, 2.0f));
    }

    // ==========================================
    // PRUEBAS DE VALORES LÍMITE: calculoNominaNeta
    // ==========================================

    @Test
    void testNominaNetaLimiteInferiorRetencion15() {
        // Nómina 2099 (< 2100): retención 0%
        float bruta = 2099.0f;
        float esperada = 2099.0f * (1.0f - 0.0f);
        assertEquals(esperada, Empleado.calculoNominaNeta(bruta), 0.01f);
    }

    @Test
    void testNominaNetaLimiteExactoRetencion15() {
        // Nómina 2100 (frontera >= 2100): retención 15%
        float bruta = 2100.0f;
        float esperada = 2100.0f * (1.0f - 0.15f);
        assertEquals(esperada, Empleado.calculoNominaNeta(bruta), 0.01f);
    }

    @Test
    void testNominaNetaLimiteInferiorRetencion18() {
        // Nómina 2499 (< 2500): retención 15%
        float bruta = 2499.0f;
        float esperada = 2499.0f * (1.0f - 0.15f);
        assertEquals(esperada, Empleado.calculoNominaNeta(bruta), 0.01f);
    }

    @Test
    void testNominaNetaLimiteExactoRetencion18() {
        // Nómina 2500 (frontera >= 2500): retención 18%
        float bruta = 2500.0f;
        float esperada = 2500.0f * (1.0f - 0.18f);
        assertEquals(esperada, Empleado.calculoNominaNeta(bruta), 0.01f);
    }
}