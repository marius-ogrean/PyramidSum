package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually... 
 */
public class NaivePyramidSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
    }

    private long getTotalAbove(int row, int column, Pyramid pyramid) {
        if (row == -1) return 0; //changed the comparison from 0 to -1 because with 0 it was omitting the first row

        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalAbove(row - 1, column, pyramid);
        long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);
        return Math.max(left, right);

        //because it is using recursion like this, for large datasets it will have to keep in memory all
        // the intermediate steps for calculating the sum for a specific path in the tree (since it is a tree)
        // so it will either take a lot of time or it will run out of stack memory
        //the best solution is traversing the tree depth first and retaining the maximum sum

        //later edit...
        //even if making the algorithm non recursive, it still takes a lot of time
        //the best solution is trying to preprocess the data so that we eventually get the maximum
    }
}