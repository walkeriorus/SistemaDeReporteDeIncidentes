package argProg;

import argProg.modelos.*;
import argProg.persistencia.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.*;


public class Main {
    public static void main(String[] args) {
        SistemaReportes sistemaReportes = new SistemaReportes();
        /*sistemaReportes.rrhh.buscarTecnicoConMayorCantidadDeResueltos();*/

        //CREO ALGUNAS FECHAS PARA LOS INCIDENTES
        LocalDate fecha_ini = LocalDate.of(2023,11,29);
        LocalDate fecha_fin = LocalDate.of(2023,12,4);


        //CREO ALGUNOS SERVICIOS
        List<Servicio> servicios_1 = new ArrayList<>();
        List<Servicio> servicios_2 = new ArrayList<>();
        Servicio windows_10 = new Servicio("Windows 10","Servicio técnico para el SO Windows 10.");
        Servicio windows_7 = new Servicio("Windows 7","Asistencia técnica para el SO Windows 7");
        Servicio linuxMint = new Servicio("Linux Mint","Asistencia técnica para el SO Linux Mint");
        Servicio tango = new Servicio("Tango","Asistencia técnica para el software TANGO");
        Servicio microsoftWord = new Servicio("Microsoft Word 2019","Asistencia técnica para el software Microsoft Word 2019");
        //Estos servicios van a ser para un cliente_1
        servicios_1.add(microsoftWord);
        servicios_1.add(windows_10);
        //Estos servicios van a ser para un cliente_2
        servicios_2.add(windows_7);
        servicios_2.add(linuxMint);


        //CREO ALGUNAS ESPECIALIDADES Y LAS AGREGO A UNA LISTA
        List<Especialidad> especialidadesList = new ArrayList<>();
        Especialidad especialidad_1 = new Especialidad("Redes Windows","Tareas de mantenimiento de redes en Windows 10");
        Especialidad especialidad_2 = new Especialidad("Windows General","Tareas de nivel general en Windows 10");
        especialidadesList.add(especialidad_1);
        especialidadesList.add(especialidad_2);

        //CREO ALGUNO USUARIOS/CLIENTES
        Cliente cliente_1 = new Cliente("Juan Gomez","202020202020","PlayTech.");
        cliente_1.setServiciosContratados(servicios_1);

        Cliente cliente_2 = new Cliente("Roberto Halcon","303030303030","Vasos SA");
        cliente_2.setServiciosContratados(servicios_2);


        //CREO ALGUNOS TIPOS DE PROBLEMAS Y LOS AGREGO A UNA LISTA
        List<TipoProblema> tiposDeProblemas = new ArrayList<>();
        TipoProblema problema_1 = new TipoProblema("RED","Problemas de conexion en Windows",4);
        TipoProblema problema_2 = new TipoProblema("HARDWARE","Problemas de incompatibilidad de drivers",4);
        tiposDeProblemas.add(problema_1);
        tiposDeProblemas.add(problema_2);

        //Guardar primero
        //CREO UN TECNICO
        Tecnico tecnico_1 = new Tecnico("Juan Tecnico",especialidadesList,8);

        //CREO UN INCIDENTE
        Incidente incidente_1 = new Incidente();
        incidente_1.setDescripcionIncidente("Problemas de red en Windows 10");
        incidente_1.setCliente(cliente_1);
        incidente_1.setEstado("resuelto");
        incidente_1.setTecnico(tecnico_1);
        incidente_1.setComplejo(false);
        incidente_1.setTiposdeproblema(tiposDeProblemas);

        //PERSISTO LOS DATOS
        //PERSISTO LOS SERVICIOS
        ServicioDAO servicioDAO = new ServicioDAO();
        servicioDAO.guardar(windows_7);
        servicioDAO.guardar(windows_10);
        servicioDAO.guardar(linuxMint);
        servicioDAO.guardar(microsoftWord);

        windows_7.setId(1);
        windows_10.setId(2);
        linuxMint.setId(3);
        microsoftWord.setId(4);

        //1)PERSISTO EL/LOS CLIENTE/S
        sistemaReportes.areaComercial.crear(cliente_1);
        sistemaReportes.areaComercial.crear(cliente_2);

        //PERSISTO LAS ESPECIALIDADES
        //Aca no hay quien se encargue todavia asi que llamo directamente a los metodos del dao EspecialidadDAO
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
        especialidadDAO.guardar(especialidad_1);
        especialidadDAO.guardar(especialidad_2);

        //2) PERSISTO LOS TIPOS DE PROBLEMAS
        TipoProblemaDAO tipoProblemaDAO = new TipoProblemaDAO();//Todavia no hay quien maneje esta parte asi que uso el DAO directamente
        tipoProblemaDAO.guardar(problema_1);
        tipoProblemaDAO.guardar(problema_2);


        //3)PERSISTO EL/LOS TECNICO/S
        especialidad_1.setId(1);
        especialidad_2.setId(2);
        sistemaReportes.rrhh.darDeAltaTecnico(tecnico_1);


        //4)PERSISTO EL INCIDENTE
        cliente_1.setId(1);
        tecnico_1.setId(1);
        problema_1.setId(1);
        problema_2.setId(2);
        incidente_1.setFechaFinalizacion(fecha_fin);
        sistemaReportes.mesaDeAyuda.crearIncidente(incidente_1);


        //BUSCO LOS CLIENTES,INCIDENTES,TECNICOS EN LA BASE DE DATOS
        System.out.println(sistemaReportes.rrhh.buscarTodosLosTecnicos());
        System.out.println(sistemaReportes.areaComercial.buscarTodosLosClientes());
        //SOLO INCIDENTES RESUELTOS-ACTUALMENTE SOLO HAY UN INCIDENTE Y SU ESTADO ES "resuelto" PERO ES PARA PROBAR
        /*System.out.println(sistemaReportes.mesaDeAyuda.buscarTodosLosIncidentesResueltos());*/
        System.out.println(sistemaReportes.mesaDeAyuda.buscarIncidentesPorFechas(fecha_ini,fecha_fin));

    }
}