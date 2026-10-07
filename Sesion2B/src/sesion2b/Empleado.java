package sesion2b;

public class Empleado {

    public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
        float salarioBase = 0.0f;

        // Salario base según el puesto
        if (tipo == TipoEmpleado.Vendedor) {
            salarioBase = 2000.0f;
        } else if (tipo == TipoEmpleado.Encargado) {
            salarioBase = 2500.0f;
        }

        // Prima según el volumen de ventas
        float prima = 0.0f;
        if (ventasMes >= 1500.0f) {
            prima = 200.0f;
        } else if (ventasMes >= 1000.0f) {
            prima = 100.0f;
        }

        // Horas extra a 30 euros cada una
        float importeHorasExtra = (horasExtra > 0) ? (horasExtra * 30.0f) : 0.0f;

        return salarioBase + prima + importeHorasExtra;
    }

    public static float calculoNominaNeta(float nominaBruta) {
        float retencion = 0.0f;

        if (nominaBruta < 2100.0f) {
            retencion = 0.0f;
        } else if (nominaBruta < 2500.0f) {
            retencion = 0.15f;
        } else {
            retencion = 0.18f;
        }

        return nominaBruta * (1.0f - retencion);
    }
}