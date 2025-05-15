import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            interfaz calculadora = (interfaz) registro.lookup("CalculadoraRMI");

            Scanner sc = new Scanner(System.in);
            System.out.println(calculadora.mensaje());

            while (true) {
                System.out.println("\n--- Calculadora RMI ---");
                System.out.println("Operaciones disponibles: suma, resta, multiplicacion, division, salir");
                System.out.print("Selection una operación: ");
                String operacion = sc.nextLine().trim().toLowerCase();

                if (operacion.equals("salir")) {
                    System.out.println("Cerrando cliente...");
                    break;
                }

                // Validar operación
                if (!operacion.equals("suma") && !operacion.equals("resta") &&
                        !operacion.equals("multiplicacion") && !operacion.equals("division")) {
                    System.out.println("Operación no válida. Inténtalo de nuevo.");
                    continue;
                }

                System.out.print("Introduce el primer número: ");
                double a = Double.parseDouble(sc.nextLine());

                System.out.print("Introduce el segundo número: ");
                double b = Double.parseDouble(sc.nextLine());

                double resultado = 0;
                switch (operacion) {
                    case "suma":
                        resultado = calculadora.suma(a, b);
                        break;
                    case "resta":
                        resultado = calculadora.resta(a, b);
                        break;
                    case "multiplicacion":
                        resultado = calculadora.multiplicacion(a, b);
                        break;
                    case "division":
                        resultado = calculadora.division(a, b);
                        break;
                }

                System.out.println("Resultado: " + resultado);
            }

        } catch (RemoteException | NotBoundException e) {
            System.err.println("Error RMI: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Error matemático: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Entrada inválida. Asegúrate de introducir números válidos.");
        }
    }
}


