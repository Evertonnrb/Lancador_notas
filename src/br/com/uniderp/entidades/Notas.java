package br.com.uniderp.entidades;

public class Notas {

    private Double n1;
    private Double n2;
    private Double n3;
    private Double n4;
    private Double mb1;
    private Double mb2;
    private Double mf;

    public Notas() {
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getN3() {
        return n3;
    }

    public void setN3(Double n3) {
        this.n3 = n3;
    }

    public Double getN4() {
        return n4;
    }

    public void setN4(Double n4) {
        this.n4 = n4;
    }

    public Double getM1() {
        return mb1;
    }

    public void setM1(Double m1) {
        this.mb1 = m1;
    }

    public Double getM2() {
        return mb2;
    }

    public void setM2(Double m2) {
        this.mb2 = m2;
    }

    public Double getMf() {
        return mf;
    }

    public void setMf(Double mf) {
        this.mf = mf;
    }

    public Double calculaMb1(Double n1, Double n2) {
        return (getN1() * 2 + getN2() * 3) / 5;
    }

    public Double calculaMb2(Double n3, Double n4) {
        return (getN3() * 2 + getN4() * 3) / 5;
    }
    public Double calculaMediaFinal(Double mb1, Double mb2){
        return (getM1()+getM2())/2;
    }
    public String situacao(Double mf){
        if(getMf()>7){
            return "A";
        }else{
            return "R";
        }
            
    }

}
