package com.example.filmes;

public class Filme {

    int codigo;
    String titulo;
    String diretor;
    String atores;
    String genero;
    String faixa;
    String lancamento;
    String duracao;
    String sinopse;
    String pais;
    String lingua;
    String premios;

    public Filme(){

    }

    public Filme(int _codigo, String _titulo, String _diretor, String _atores, String _genero, String _faixa, String _lancamento, String _duracao, String _sinopse, String _pais, String _lingua, String _premios){
        this.codigo = _codigo;
        this.titulo = _titulo;
        this.diretor = _diretor;
        this.atores = _atores;
        this.genero = _genero;
        this.faixa = _faixa;
        this.lancamento = _lancamento;
        this.duracao = _duracao;
        this.sinopse = _sinopse;
        this.pais = _pais;
        this.lingua = _lingua;
        this.premios = _premios;
    }

    public Filme(String _titulo, String _diretor, String _atores, String _genero, String _faixa, String _lancamento, String _duracao, String _sinopse, String _pais, String _lingua, String _premios){
        this.titulo = _titulo;
        this.diretor = _diretor;
        this.atores = _atores;
        this.genero = _genero;
        this.faixa = _faixa;
        this.lancamento = _lancamento;
        this.duracao = _duracao;
        this.sinopse = _sinopse;
        this.pais = _pais;
        this.lingua = _lingua;
        this.premios = _premios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }
}
