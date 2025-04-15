package org.ualhmis.torneos;

public class TorneoConSede {
    private Torneo torneo;
    private Sede sede;

    public TorneoConSede(Torneo torneo, Sede sede) {
        if (torneo == null || sede == null)
            throw new IllegalArgumentException("El torneo y la sede no pueden ser nulos");

        this.torneo = torneo;
        this.sede = sede;
    }

    public boolean validarInstalacionesAdecuadas() {
        for (Instalacion inst : sede.getInstalaciones()) {
            if (esAdecuadaParaDeporte(inst.getTipo(), torneo.getDeporte()))
                return true;
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

    public void setTorneo(Torneo torneo) {
        if (torneo == null)
            throw new IllegalArgumentException("El torneo no puede ser nulo");
        this.torneo = torneo;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        if (sede == null)
            throw new IllegalArgumentException("La sede no puede ser nula");
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "TorneoConSede [torneo=" + torneo + ", sede=" + sede + "]";
    }
}
