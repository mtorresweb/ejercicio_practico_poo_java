public abstract class Empleado {
    private String nombre;
    private int edad;
    private double salario_base;
    private double salario_total;
    private double bono;

    public Empleado(String nombre, int edad, double salario_base, double bono) {
        setNombre(nombre);
        setEdad(edad);
        setBono(bono);
        setSalario_base(salario_base);
    }

    public String toString() {
        return "%s, %d años, sueldo: %s".formatted(getNombre(), getEdad(), getSalario_total());
    }

    protected abstract double calcularSueldoTotal(double salario_base);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario_base(double salario_base) {
        this.salario_base = salario_base;
        this.salario_total = calcularSueldoTotal(salario_base);
    }

    public double getSalario_total() {
        return salario_total;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public double getSalario_base() {
        return salario_base;
    }
}
