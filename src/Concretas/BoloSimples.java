package Concretas;

import Interfaces.IFormato;

public class BoloSimples extends Bolo {
    private boolean semLactose = false;

    public BoloSimples(int codigo, double custo, IFormato formato) {
        super(codigo, custo, formato); 
    }

    public BoloSimples(int codigo, double custo, IFormato formato, boolean semLactose) {
        super(codigo, custo, formato);
        this.semLactose = semLactose;
    }

    @Override
    public double preco() {
        double precoBase = getCusto() * getFormato().getArea();
        
        if (semLactose) {
            precoBase += 35.00;
        }
        
        return precoBase;
    }

    @Override
    public String toString() {
        return "BoloSimples [codigo=" + getCodigo() + 
                ", custo=" + getCusto() + 
                ", formato=" + (getFormato() != null ? getFormato() : "Não especificado") +
                ", semLactose=" + semLactose +
                ", preço=" + String.format("%.2f", preco()) + "]";
    }
}
