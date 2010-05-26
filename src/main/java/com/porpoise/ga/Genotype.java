package com.porpoise.ga;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.porpoise.common.RandomizingIter;

/**
 * Genotype is a factory class, responsible for producing {@link IGene}s of a certain type
 * 
 * @param <T>
 */
public class Genotype<T> {

    private final List<T>     genes;
    private final Iterator<T> geneIter;
    private int               size;

    public static <T> Genotype<T> of(final Collection<T> values) {
        final Genotype<T> pool = new Genotype<T>(values);
        return pool;
    }

    public static <T> Genotype<T> of(final T... values) {
        return of(Arrays.asList(values));
    }

    private Genotype(final T... values) {
        this(Arrays.asList(values));
    }

    private Genotype(final Collection<T> values) {
        size = values.size();
        assert size > 0;
        genes = Lists.newArrayList(values);
        geneIter = new RandomizingIter<T>(genes);
    }

    public int size() {
        return size;
    }

    public T create() {
        return geneIter.next();
    }

    public IGene<?> createGene(final int position) {
        return new GeneImpl<T>(this, position, create());
    }

}