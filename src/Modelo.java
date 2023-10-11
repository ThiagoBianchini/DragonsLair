public class Modelo {
    private int PV;
    private int forca;
    private int defesa;
    private int agilidade;

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public Modelo(int PV, int forca, int defesa, int agilidade) {
        this.PV = PV;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    public interface Bater{
        public int Dano();
    }

    public int Dano() {
        return 0;
    }
}