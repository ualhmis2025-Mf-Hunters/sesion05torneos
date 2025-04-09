package org.ualhmis.torneos;

public class TorneoConSede {
    private Torneo torneo;
    private Sede sede;

    public TorneoConSede(Torneo torneo, Sede sede) {
        this.torneo = torneo;
        this.sede = sede;
    }

    public boolean validarInstalacionesAdecuadas() {
        for (Instalacion inst : sede.getInstalaciones()) {
            if (esAdecuadaParaDeporte(inst.getTipo(), torneo.getDeporte())) {
                return true;
            }
        }
        return false;
    }

    private boolean esAdecuadaParaDeporte(String tipo, String deporte) {
        switch (deporte.toLowerCase()) {
            case "fútbol":
                return tipo.equalsIgnoreCase("campo");
            case "baloncesto":
                return tipo.equalsIgnoreCase("pabellón");
            case "tenis":
                return tipo.equalsIgnoreCase("pista");
            default:
                return false;
        }
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public Sede getSede() {
        return sede;
    }
}
