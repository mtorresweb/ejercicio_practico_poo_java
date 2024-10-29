public class Administrativo extends Empleado{

    public Administrativo(String nombre, int edad, double salario_base) {
        super(nombre, edad, salario_base, 0.35);
    }

    @Override
    protected double calcularSueldoTotal(double salario_base) {
        return (salario_base * getBono()) + salario_base;
    }
}
