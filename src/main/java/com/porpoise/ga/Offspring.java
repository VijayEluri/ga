package com.porpoise.ga;

import java.util.List;

public class Offspring {

    private final GeneSequence offspringOne;
    private final GeneSequence offspringTwo;

    public Offspring(final GeneSequence son, final GeneSequence daughter) {
        offspringOne = son;
        offspringTwo = daughter;

    }

    /**
     * @return the offspringOne
     */
    public GeneSequence getOffspringOne() {
        return offspringOne;
    }

    /**
     * @return the offspringTwo
     */
    public GeneSequence getOffspringTwo() {
        return offspringTwo;
    }

    public GeneSequence getOne(final Probability probability) {
        return get(offspringOne, probability);
    }

    public GeneSequence getTwo(final Probability probability) {
        return get(offspringTwo, probability);
    }

    private GeneSequence get(final GeneSequence offspring, final Probability probability) {
        final boolean mutate = probability.nextMutate();
        return mutate ? offspring.mutate(probability) : offspring;
    }

    public List<IGene<?>> getOffspringOneGenes() {
        return getOffspringOne().getGenes();
    }

    public List<IGene<?>> getOffspringTwoGenes() {
        return getOffspringTwo().getGenes();
    }

    public IGene<?> getOneGene(final int index) {
        return getOffspringOne().getGene(index);
    }

    public IGene<?> getTwoGene(final int index) {
        return getOffspringTwo().getGene(index);
    }

    @Override
    public String toString() {
        return String.format("Offspring:%n%s%n%s", getOffspringOne(), getOffspringTwo());
    }

}
