package com.porpoise.ga;

import org.junit.Ignore;

import com.porpoise.ga.Scores.ComparableScore;

@Ignore
enum TestEvaluations
{
    ;

    /**
     * @param result
     * @return an evaluation instance which *always* returns the given rating
     */
    public static IGeneEvaluation<Float> constant(final float result)
    {
        return new IGeneEvaluation<Float>() {
            @Override
            public IScore<Float> score(final GeneSequence sequence)
            {
                return Scores.valueOf(result);
            }
        };
    }

    public static IGeneEvaluation<Integer> constant(final int result)
    {
        return new IGeneEvaluation<Integer>() {
            @Override
            public IScore<Integer> score(final GeneSequence sequence)
            {
                return Scores.valueOf(result);
            }
        };
    }

    public static IGeneEvaluation<Integer> increasing()
    {
        return new IGeneEvaluation<Integer>() {
            private int next = 0;

            @Override
            public IScore<Integer> score(final GeneSequence sequence)
            {
                final ComparableScore<Integer> score = Scores.valueOf(this.next++);
                return score;
            }
        };
    }

}
