package Concretas;

import Interfaces.IFormato;

public class Torta extends Bolo
{
    private boolean recheio;
    private boolean cobertura;

    public Torta(int codigo, double custo, IFormato formato) {
        super(codigo, custo, formato);
    }
    public Torta(int codigo, double custo, IFormato formato, boolean recheio, boolean cobertura) {
        super(codigo, custo,formato);
        this.recheio = recheio;
        this.cobertura = cobertura;
    }

    @Override
    public double preco() {
        return 0;
    }

    @Override
    public String toString() {
        return "Torta [codigo=" + getCodigo() + ", custo=" + getCusto() +
                ", formato=" + (getFormato() != null ? getFormato() : "Não especificado") +
                ", recheio=" + recheio +
                ", cobertura=" + cobertura + "]";
    }
}
