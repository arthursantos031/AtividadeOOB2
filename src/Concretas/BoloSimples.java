package Concretas;

import Interfaces.IFormato;

public class BoloSimples extends Bolo {
    private final boolean semLactose; 

    public BoloSimples(int codigo, double custo, IFormato formato) {
        super(codigo, custo, formato); 
        this.semLactose = false;
    }

    public BoloSimples(int codigo, double custo, IFormato formato, boolean semLactose) {
        super(codigo, custo, formato);
        this.semLactose = semLactose;
    }

    public BoloSimples(boolean semLactose, int codigo, double custo) {
        super(codigo, custo);
        this.semLactose = semLactose;
    }

    public BoloSimples(boolean semLactose, int codigo, double custo, IFormato formato) {
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
