import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacionInterface extends UnicastRemoteObject implements interfaz {
    protected ImplementacionInterface() throws RemoteException {
        super();
    }

    public String mensaje() {
        return "Bienvenido a la Calculadora RMI";
    }

    public double suma(double a, double b) {
        return a + b;
    }

    public double resta(double a, double b) {
        return a - b;
    }

    public double multiplicacion(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }
}
