package clases;

public class Planeta {
    public Planeta(String nombrePlaneta, int distanciaSol, int gravedad, int diametro) {
        this.nombrePlaneta = nombrePlaneta;
        this.distanciaSol = distanciaSol;
        this.gravedad = gravedad;
        this.diametro = diametro;
    }
    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    public int getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(int distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    private String nombrePlaneta;
    private int distanciaSol;
    private int gravedad;
    private int diametro;

}
