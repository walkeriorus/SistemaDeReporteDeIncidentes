package argProg;

import argProg.modelos.*;
import argProg.persistencia.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        SistemaReportes sistemaReportes = new SistemaReportes();

        //CREO ALGUNAS FECHAS PARA LOS INCIDENTES
        LocalDate fecha_ini = LocalDate.of(2023,11,29);
        LocalDate fecha_fin = LocalDate.of(2023,12,4);


        //CREO ALGUNOS SERVICIOS
        Servicio windows_10 = new Servicio("Windows 10","Servicio técnico para el SO Windows 10.");
        Servicio windows_7 = new Servicio("Windows 7","Asistencia técnica para el SO Windows 7");
        Servicio linuxMint = new Servicio("Linux Mint","Asistencia técnica para el SO Linux Mint");
        Servicio tango = new Servicio("Tango","Asistencia técnica para el software TANGO");
        Servicio microsoftWord = new Servicio("Microsoft Word 2019","Asistencia técnica para el software Microsoft Word 2019");


        //CREO ALGUNAS ESPECIALIDADES Y LAS AGREGO A UNA LISTA
        Especialidad especialidad_1 = new Especialidad("Redes Windows","Tareas de mantenimiento de redes en Windows 10");
        Especialidad especialidad_2 = new Especialidad("Windows General","Tareas de nivel general en Windows 10");

        //CREO ALGUNOS USUARIOS/CLIENTES
        Cliente cliente_1 = new Cliente("Juan Gomez","202020202020","PlayTech.");
        cliente_1.agregarServicio(microsoftWord);
        cliente_1.agregarServicio(windows_10);

        Cliente cliente_2 = new Cliente("Roberto Halcon","303030303030","Vasos SA");
        cliente_2.agregarServicio(windows_7);
        cliente_2.agregarServicio(linuxMint);


        //CREO ALGUNOS TIPOS DE PROBLEMAS Y LOS AGREGO A UNA LISTA
        List<TipoProblema> tiposDeProblemas = new ArrayList<>();
        TipoProblema problema_1 = new TipoProblema("RED","Problemas de conexion en Windows",4);
        TipoProblema problema_2 = new TipoProblema("HARDWARE","Problemas de incompatibilidad de drivers",4);
        tiposDeProblemas.add(problema_1);
        tiposDeProblemas.add(problema_2);

        //Guardar primero
        //CREO ALGUNOS TECNICOS
        Tecnico tecnico_1 = new Tecnico("Juan Tecnico",8);
        Tecnico tecnico_2 = new Tecnico("Alberto Arreglin",12);
        //Agrego una especialidad a cada uno
        tecnico_1.agregarEspecialidad(especialidad_1);
        tecnico_2.agregarEspecialidad(especialidad_2);

        //CREO ALGUNOS INCIDENTES
        Incidente incidente_1 = new Incidente();
        incidente_1.setDescripcionIncidente("Problemas de red en Windows 10");
        incidente_1.setCliente(cliente_1);
        incidente_1.setEstado("resuelto");
        incidente_1.setTecnico(tecnico_1);
        incidente_1.setComplejo(false);
        incidente_1.setTiposDeProblema(tiposDeProblemas);
        incidente_1.setServicio(windows_10);

        Incidente incidente_2 = new Incidente();
        incidente_2.setDescripcionIncidente("Problemas en Linux Mint");
        incidente_2.setCliente(cliente_2);
        incidente_2.setEstado("no resuelto");
        incidente_2.setTecnico(tecnico_1);
        incidente_2.setComplejo(false);
        incidente_2.setTiposDeProblema(tiposDeProblemas);
        incidente_1.setServicio(linuxMint);

        Incidente incidente_3 = new Incidente();
        incidente_3.setDescripcionIncidente("Problemas en Linux Mint");
        incidente_3.setCliente(cliente_2);
        incidente_3.setEstado("resuelto");
        incidente_3.setTecnico(tecnico_2);
        incidente_3.setComplejo(false);
        incidente_3.setTiposDeProblema(tiposDeProblemas);
        incidente_1.setServicio(linuxMint);

        Incidente incidente_4 = new Incidente();
        incidente_4.setDescripcionIncidente("Problemas con Microsoft Word");
        incidente_4.setCliente(cliente_1);
        incidente_4.setEstado("resuelto");
        incidente_4.setTecnico(tecnico_1);
        incidente_4.setComplejo(false);
        incidente_4.setTiposDeProblema(tiposDeProblemas);
        incidente_1.setServicio(microsoftWord);

        //
        incidente_1.setFechaFinalizacion(fecha_fin);
        incidente_2.setFechaFinalizacion(fecha_fin);
        incidente_3.setFechaFinalizacion(fecha_fin);
        incidente_4.setFechaFinalizacion(fecha_fin);

        sistemaReportes.mesaDeAyuda.crearIncidente(incidente_1);
        sistemaReportes.mesaDeAyuda.crearIncidente(incidente_2);
        sistemaReportes.mesaDeAyuda.crearIncidente(incidente_3);
        sistemaReportes.mesaDeAyuda.crearIncidente(incidente_4);


    }
}