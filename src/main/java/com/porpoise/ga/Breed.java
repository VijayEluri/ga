package com.porpoise.ga;import java.util.Random;public class Breed {    private final IChlorine chlorine;    public Breed(final IChlorine transform) {        this(transform, 0.0015F, 0.7F);    }    public Breed(final IChlorine transform, final float mutation, final float cross) {        if (cross < 0 || cross > 1.0) {            throw new NullPointerException("cross probability must be between 0 and 1.0");        }        chlorine = transform;    }    public Result solve(final IGenePool original) {        //        // our pool of available variations is available via the genePool        //        int generation = 0;        IGenePool pool = original;        new Random();        while (!pool.hasSolution()) {            generation++;            pool = chlorine.evolve(pool);        }        return new Result(generation, pool);    }}