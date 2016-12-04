package br.com.uniderp.model;

public class Aluno {

    private Integer id;
    private Integer ra;
    private String nome;
    private String disciplina;
    private String curso;
    private Double n1;
    private Double n2;
    private Double n3;
    private Double n4;
    private Double mb1;
    private Double mb2;
    private Double mf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getMb1() {
        return mb1;
    }

    public void setMb1(Double mb1) {
        this.mb1 = mb1;
    }

    public Double getMb2() {
        return mb2;
    }

    public void setMb2(Double mb2) {
        this.mb2 = mb2;
    }

    public Double getMf() {
        return mf;
    }

    public void setMf(Double mf) {
        this.mf = mf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Aluno() {
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double calculaM1(Double n1, Double n2) {
        return (n1 + n2) / 2;
    }

    public Double calculaM2(Double n1, Double n2) {
        return (n3 + n4) / 2;
    }

    public Double calcualMediaFinal() {
        return (calculaM1(n1, n2) + calculaM2(n1, n2));
    }

    public String situacao(Double media) {
        String sit = null;
        if (calcualMediaFinal() >= 7) {
            sit = "Aprovado";
        } else {
            sit = "Reprovado";
        }
        return sit;
    }

}
