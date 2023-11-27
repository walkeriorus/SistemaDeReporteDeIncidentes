package argProg.modelos;

import argProg.persistencia.ClienteDAO;

public class AreaComercial {
    //Se encarga de incorporar nuevos clientes a la empresa
    //Hace altas,bajas,modificaciones de Clientes -> Accede a la tabla Cliente
    private ClienteDAO clienteDAO = new ClienteDAO();
}
