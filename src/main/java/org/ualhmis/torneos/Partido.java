package org.ualhmis.torneos;

class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        if (equipo1 == null || equipo2 == null)
            throw new IllegalArgumentException("Los equipos no pueden ser nulos");
        if (!equipo1.getCategoria().equals(equipo2.getCategoria()) ||
                !equipo1.getModalidad().equalsIgnoreCase(equipo2.getModalidad()))
            throw new IllegalArgumentException("Los equipos deben tener la misma categoría y modalidad");

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void registrarResultado(int golesEquipo1, int golesEquipo2) {
        if (golesEquipo1 < 0 || golesEquipo2 < 0)
            throw new IllegalArgumentException("Los goles no pueden ser negativos");

        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    @Override
    public String toString() {
        return "Partido [equipo1=" + equipo1.getNombre() + " (" + golesEquipo1 + ") vs equipo2="
                + equipo2.getNombre() + " (" + golesEquipo2 + ")" + "]";
    }
}
