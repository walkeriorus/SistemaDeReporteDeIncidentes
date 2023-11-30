package argProg;

import argProg.modelos.*;

import java.time.LocalDate;
import java.util.*;

public class SistemaReportes {
    RRHH rrhh = new RRHH();
    MesaDeAyuda mesaDeAyuda = new MesaDeAyuda();
    AreaComercial areaComercial = new AreaComercial();

    public Tecnico buscarTecnicoConMasResueltosEntreFechas(LocalDate fechIni,LocalDate fechaFin){
        List<Incidente> incidentesResueltos = mesaDeAyuda.buscarIncidentesResueltosEntreFechas(fechIni,fechaFin);

        // Contar las ocurrencias de cada id(Tecnico) y guardarlos en un HashMap
        // donde los pares clave-valor tienen : idTecnico(clave):ocurenciasIdTecnico(valor)
        Map<Integer, Integer> idCountMap = new HashMap<>();
        for (Incidente incidente : incidentesResueltos) {
            int objectId = incidente.getTecnico().getId();
            idCountMap.put(objectId, idCountMap.getOrDefault(objectId, 0) + 1);
        }
        System.out.println("idCountMap: "+idCountMap);

        // Find the ID with the maximum occurrences
        int mostFrequentId = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : idCountMap.entrySet()) {
            int currentId = entry.getKey();
            int currentCount = entry.getValue();

            if (currentCount > maxCount) {
                mostFrequentId = currentId;
                maxCount = currentCount;
            }
        }
        return rrhh.buscarTecnicoPorId(mostFrequentId);
    }
    public Tecnico buscarTecnicoConMasResueltosPorEspecialidad(LocalDate fechIni,LocalDate fechaFin,Integer idEspecialidad){
        System.out.println("EJECUTANDO buscarTecnicoConMasResueltosPorEspecialidad...");
        List<Incidente> incidentesResueltos = mesaDeAyuda.buscarIncidentesResueltosEntreFechas(fechIni,fechaFin);

        Map<Integer, Integer> idCountMap = new HashMap<>();
        for (Incidente incidente : incidentesResueltos) {
            Tecnico tecnicoActual = incidente.getTecnico();

            for( Especialidad especialidad : tecnicoActual.getEspecialidades() ){
                if( especialidad.getId() == idEspecialidad ){
                    int objectId = incidente.getTecnico().getId();
                    idCountMap.put(objectId, idCountMap.getOrDefault(objectId, 0) + 1);
                }
            }
        }
        System.out.println("idCountMap: " + idCountMap );
        int mostFrequentId = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : idCountMap.entrySet()) {
            int currentId = entry.getKey();
            int currentCount = entry.getValue();

            if (currentCount > maxCount) {
                mostFrequentId = currentId;
                maxCount = currentCount;
            }
        }
        return rrhh.buscarTecnicoPorId(mostFrequentId);
    }
    public Tecnico buscarTecnicoQueResolvioMasRapidoSusIncidentes( LocalDate fechIni,LocalDate fechaFin ){
        List<Incidente> incidentesResueltos = mesaDeAyuda.buscarIncidentesResueltosEntreFechas(fechIni,fechaFin);

        // Contar las ocurrencias de cada id(Tecnico) y guardarlos en un HashMap
        // donde los pares clave-valor tienen : idTecnico(clave):ocurenciasIdTecnico(valor)
        Map<Integer, Integer> idCountMap = new HashMap<>();
        for (Incidente incidente : incidentesResueltos) {
            int sum = 0;
            for(TipoProblema tipoProblema : incidente.getTiposdeproblema()){
                sum = sum + tipoProblema.getTiempoMaximoDeResolucion();
            }
            int objectId = incidente.getTecnico().getId();
            idCountMap.put(objectId, idCountMap.getOrDefault(objectId, 0) + sum);
        }
        int mostFrequentId = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : idCountMap.entrySet()) {
            int idTecnicoActual = entry.getKey();
            int totalDeHorasDeTecnicoActual = entry.getValue();

            if (totalDeHorasDeTecnicoActual < maxCount) {
                mostFrequentId = idTecnicoActual;
                maxCount = totalDeHorasDeTecnicoActual;
            }
        }
        Collection<Integer> horasDeTecnicos = idCountMap.values();
        Integer minimoHoras = Collections.min(horasDeTecnicos);


        return rrhh.buscarTecnicoPorId(mostFrequentId);
    }
}
