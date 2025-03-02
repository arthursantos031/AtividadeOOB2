package Interfaces;

public interface IPrateleira {
    int buscar(IBolo objeto);
    boolean cheia();
    boolean vazia();
    boolean existe(IBolo objeto);
    boolean inserir(IBolo objeto);
    IBolo remover(IBolo objeto);
    IBolo remover(int posicao);
    IBolo consultar(int posicao);
    IBolo[] listar();
    IBolo[] listar(char tipoEspecifico);
}
