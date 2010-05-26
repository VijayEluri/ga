package com.porpoise.ga;

class GeneImpl<T> implements IGene<T> {

    private final int         index;
    private final T           data;
    private final Genotype<T> genotype;

    GeneImpl(final Genotype<T> type, final int geneIndex, final T value) {
        this.genotype = type;
        this.index = geneIndex;
        this.data = value;
    }

    // @Override
    // public IGene<T> cross(final IGene<T> gene) {
    // return null;
    // }

    @Override
    public T getValue() {
        return data;
    }

    @Override
    public IGene<T> mutate(final float random) {
        return (IGene<T>) genotype.createGene(index);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}