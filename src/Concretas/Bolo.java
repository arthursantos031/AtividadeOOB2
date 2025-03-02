package Concretas;

import Interfaces.IBolo;
import Interfaces.IFormato;

import java.util.Random;

public abstract class Bolo implements IBolo {
    private int codigo;
    private double custo;
    private IFormato formato;

    public Bolo(int codigo, double custo) {
        setCodigo(codigo);
        setCusto(custo);
    }

    public Bolo(int codigo, double custo, IFormato formato) {
        setCodigo(codigo);
        setCusto(custo);
        setFormato(formato);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        codigo = codigo == 0 ? new Random().nextInt(99999999) : codigo;
        this.codigo = codigo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public IFormato getFormato() {
        return formato;
    }

    public void setFormato(IFormato formato) {
        this.formato = formato;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bolo bolo = (Bolo) obj;
        return codigo == bolo.codigo && Double.compare(bolo.custo, custo) == 0;
    }

    @Override
    public String toString() {
        return "Bolo [codigo= " + codigo + ", custo= " + custo + ", formato= " + formato + "]";
    }
}