package argProg.modelos;

import argProg.persistencia.ClienteDAO;
import argProg.persistencia.IncidenteDAO;

import java.util.ArrayList;
import java.util.List;

public class MesaDeAyuda {
    /*
    la mesa de ayuda es responsable de atender las llamadas e ingresar al sistema los
    incidentes reportados -> Necesita acceso a la tabla Cliente y a la tabla Incidentes.
    */
    private ClienteDAO clienteDAO = new ClienteDAO();
    private IncidenteDAO incidenteDAO = new IncidenteDAO();

    public Cliente buscarDatosCliente(String razonSocial,String cuit) {
        /*Cuando un cliente llama, la mesa de ayuda le solicita los datos para identificarlo (razón social,
CUIT) y los ingresa en el sistema para que el mismo le muestre los servicios que el cliente
tiene contratados.*/
        Cliente cliente = clienteDAO.buscarPorCuit(cuit);
        return cliente;
    }
    public void reportarIncidente(Incidente incidente){
        /*El operador (de la mesa de ayuda) solicita que le informen por cuál de esos servicios desea
reportar un incidente, junto con una descripción del problema y el tipo del problema.
    }
    public void ingresarIncidente(Incidente incidente){
        /*Al ingresar el incidente, el sistema devuelve un listado de técnicos disponibles para resolver el
        problema.*/
        List<Tecnico> tecnicos_disponibles = this.consultarTecnicosDisponibles();
        incidenteDAO.guardar(incidente);
    }
    public List<Tecnico> consultarTecnicosDisponibles(){
        List<Tecnico> tecnicos_disponibles = null;
        return tecnicos_disponibles;
    }
    public void informarCliente(){
        /* Luego, informa al cliente que el incidente ha sido ingresado y
la fecha posible de resolución.*/
    }
}
