package com.porpoise.ga;public class GeneticAlgorythm {    private final IChlorine chlorine;    public GeneticAlgorythm(final IGeneEvaluation criteria, final float crossRate, final float mutationRate) {        this(new ChlorineImpl(criteria, new Probability(crossRate, mutationRate)));    }    public GeneticAlgorythm(final IGeneEvaluation criteria) {        this(new ChlorineImpl(criteria));    }    public GeneticAlgorythm(final IChlorine transform) {        chlorine = transform;    }    public Result solve(final IGenePool original) {        //        // our pool of available variations is available via the genePool        //        int generation = 0;        IGenePool pool = original;        System.out.println(Probability.getInstance());        while (!pool.hasSolution()) {            generation++;            System.out.println("before:");            System.out.println(pool);            pool = chlorine.evolve(pool);            System.err.println("after:");            System.err.println(pool);        }        return new Result(generation, pool);    }}