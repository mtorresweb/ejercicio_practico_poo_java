public class Aseo extends Empleado{
    static int subsidio = 160000;

    public Aseo(String nombre, int edad, double salario_base) {
        super(nombre, edad, salario_base, 0.05);
    }

    @Override
    protected double calcularSueldoTotal(double salario_base) {
        return (salario_base * getBono()) + salario_base + subsidio;
    }
}
