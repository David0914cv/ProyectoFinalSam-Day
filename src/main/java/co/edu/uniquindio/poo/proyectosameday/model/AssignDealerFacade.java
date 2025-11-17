package co.edu.uniquindio.poo.proyectosameday.model;

public class AssignDealerFacade {
    private Administrador admin;
    private Notify system;

    public AssignDealerFacade(Administrador admin, Notify system) {
        this.admin = admin;
        this.system = system;
    }

    public void assignDealer(Empresa empresa,EnvioComponent shape,Repartidor dealer,Usuario user, String message){
        this.admin.assignDealer(empresa, shape, dealer);

        this.system.addObserver(user);
        this.system.addObserver(dealer);

        this.system.importantChange(message);
    }
}
