package Concretas;

import Interfaces.IFormato;

public class BoloSimples extends Bolo {
    private boolean semLactose;

    public BoloSimples(int codigo, double custo, IFormato formato) {
        super(codigo, custo, formato);
    }

    public BoloSimples(int codigo, double custo, IFormato formato, boolean semLactose) {
        super(codigo, custo, formato);
        this.semLactose = semLactose;
    }

    @Override
    public double preco() {
        return 0;
    }

    @Override
    public String toString() {
        return "BoloSimples [codigo= " + getCodigo() + ", custo= " + getCusto() +
                ", formato=" + (getFormato() != null ? getFormato() : "Não especificado") +
                ", semLactose=" + semLactose + "]";
    }
}