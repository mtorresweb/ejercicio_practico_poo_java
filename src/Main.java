import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //variable para continuar la ejecución del programa
        boolean executing = true;

        //HashMap
        HashMap <String, ArrayList<Empleado>> empleados = new HashMap<>();
        empleados.put("Desarrolladores", new ArrayList<>());
        empleados.put("Administrativos", new ArrayList<>());
        empleados.put("Aseo", new ArrayList<>());

        Scanner scanner = new Scanner(System.in);

        while (executing){
            System.out.println("1. Añadir empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Aumentar sueldo a un empleado");
            System.out.println("4. Salir");

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch (option){
                    case 1:
                        add_empleado(scanner, empleados);
                        break;
                    case 2:
                        listar_empleados(empleados);
                        break;
                    case 3:
                        aumentar_sueldo(scanner, empleados);
                        break;
                    case 4:
                        executing = false;
                        break;
                    default:
                        System.out.println("Opción no válida.\n");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Debes ingresar un número.\n");
            }
        }

        scanner.close();
    }

    static void add_empleado(Scanner scanner, HashMap<String, ArrayList<Empleado>> empleados){

        System.out.println("1. Desarrollador");
        System.out.println("2. Administrativo");
        System.out.println("3. Aseo");

        try  {
            int option = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Salario: ");
            double salario = Double.parseDouble(scanner.nextLine());

            switch (option) {
                case 1:
                    Desarrollador desarrollador = new Desarrollador(nombre, edad, salario);
                    empleados.get("Desarrolladores").add(desarrollador);
                    break;
                case 2:
                    Administrativo administrativo = new Administrativo(nombre, edad, salario);
                    empleados.get("Administrativos").add(administrativo);
                    break;
                case 3:
                    Aseo aseo = new Aseo(nombre, edad, salario);
                    empleados.get("Aseo").add(aseo);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("Empleado añadido.\n");

        }catch (Exception e) {
            System.out.println("Verifica los datos ingresados, la edad y el salario son de tipo numérico.\n");
        }

    }

    static void listar_empleados(HashMap<String, ArrayList<Empleado>> empleados) {
        //Iterar las claves
        for (String clave : empleados.keySet()) {
            ArrayList<Empleado> lista = empleados.get(clave);
            // Verificar si la lista tiene empleados
            if (!lista.isEmpty()) {
                //Imprimir la clave
                System.out.println(clave);
                //Iterar la lista de empleados
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println(i + 1 + " - " + lista.get(i).toString());
                }
            }
        }
    }

    static void listar_por_tipo_de_empleado (HashMap<String, ArrayList<Empleado>> empleados, String tipo_empleado){
        ArrayList<Empleado> lista = empleados.get(tipo_empleado);
        if (!lista.isEmpty()) {
            System.out.println(tipo_empleado);
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + 1 + " - " + lista.get(i).toString());
            }
        }
    }

    static void aumentar_sueldo (Scanner scanner, HashMap<String, ArrayList<Empleado>> empleados) {
        System.out.println("Seleccione el tipo de empleado:");
        System.out.println("1. Desarrollador");
        System.out.println("2. Administrativo");
        System.out.println("3. Aseo");

        try {
            int option = Integer.parseInt(scanner.nextLine());

            listar_por_tipo_de_empleado(empleados, option == 1 ? "Desarrolladores" : option == 2 ? "Administrativos" : "Aseo");

            System.out.print("Ingrese el número del empleado: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("Ingrese el nuevo salario: ");

            switch (option) {
                case 1:
                    Desarrollador desarrollador = (Desarrollador) empleados.get("Desarrolladores").get(index);
                    desarrollador.setSalario_base(Double.parseDouble(scanner.nextLine()));
                    break;
                case 2:
                    Administrativo administrativo = (Administrativo) empleados.get("Administrativos").get(index);
                    administrativo.setSalario_base(Double.parseDouble(scanner.nextLine()));
                    break;
                case 3:
                    Aseo aseo = (Aseo) empleados.get("Aseo").get(index);
                    aseo.setSalario_base(Double.parseDouble(scanner.nextLine()));
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("Sueldo aumentado.\n");

        } catch (Exception e) {
            System.out.println("Los datos ingresados deben ser de tipo numérico.\n");
        }
    }
}