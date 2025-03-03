package Concretas;

import Exceptions.ErrorType;
import Exceptions.PersonalizedException;
import Interfaces.IBolo;
import Interfaces.IPrateleira;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class VetorPrateleira implements IPrateleira {
    private final IBolo[] prateleira;
    private int qtdBolo;

    public VetorPrateleira(int capacidade) {
        this.prateleira = new IBolo[capacidade];
        this.qtdBolo = 0;
    }

    @Override
    public boolean inserir(IBolo objeto) {

        if (cheia()) throw new PersonalizedException("A prateleira está cheia!", ErrorType.PRATELEIRA_CHEIA);

        IntStream.range(0, qtdBolo).filter(i -> prateleira[i].equals(objeto)).forEach(i -> {
            throw new PersonalizedException("Bolo já cadastrado", ErrorType.BOLO_JA_CADASTRADO);
        });

        prateleira[qtdBolo++] = objeto;

        return true;
    }

    @Override
    public IBolo remover(IBolo objeto){

        for (int i = 0; i < prateleira.length; i++)
            if (prateleira[i].equals(objeto)) {
                return remover(i);
            }

        throw new PersonalizedException("Bolo inexistente.", ErrorType.BOLO_NAO_ENCONTRADO);
    }

    @Override
    public IBolo remover(int posicao) {
        if (posicao < 0 || posicao >= qtdBolo || prateleira[posicao] == null) {
            throw new PersonalizedException("Bolo inexistente.", ErrorType.BOLO_NAO_ENCONTRADO);
        }

        IBolo boloRemovido = prateleira[posicao];
        prateleira[posicao] = null;

        return boloRemovido;
    }

    @Override
    public IBolo consultar(int posicao)
    {
        if (prateleira[posicao] == null) {
            throw new PersonalizedException("Bolo não encontrado", ErrorType.BOLO_NAO_ENCONTRADO);
        }

        return prateleira[posicao];
    }

    @Override
    public int buscar(IBolo objeto)
    {
        //LINQ -> STREAMS
        int indice =  IntStream.range(0, qtdBolo)
                .filter(i -> prateleira[i].equals(objeto))
                .findFirst()
                .orElse(-1);

        if (indice < 0){
            throw new PersonalizedException("O bolo não está na prateleira", ErrorType.BOLO_NAO_ENCONTRADO_NA_PRATELEIRA);
        }

        return indice;
    }

    @Override
    public boolean cheia()
    {
        return IntStream.range(0, prateleira.length).noneMatch(i -> prateleira[i] == null);
    }

    @Override
    public boolean vazia()
    {
        return Arrays.stream(prateleira).noneMatch(Objects::nonNull);
    }

    @Override
    public boolean existe(IBolo objeto) {
        return buscar(objeto) > -1;
    }

    @Override
    public IBolo[] listar() {
        return java.util.Arrays.copyOf(prateleira, prateleira.length);
    }

    @Override
    public IBolo[] listar(char tipoDoBolo)
    {
        //LINQ -> STREAMS
        return Arrays.stream(prateleira)
                .filter(bolo -> (
                        (tipoDoBolo == 'S' && bolo instanceof BoloSimples) ||
                                (tipoDoBolo == 'T' && bolo instanceof Torta)
                ))
                .toArray(IBolo[]::new);
    }

    public IBolo[] getPrateleira() {
        return prateleira;
    }
}