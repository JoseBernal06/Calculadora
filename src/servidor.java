import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) throws RemoteException {
        try {
            interfaz objetoRemoto = new ImplementacionInterface();
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("CalculadoraRMI", (Remote) objetoRemoto);
            System.out.println("Servidor RMI listo.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
