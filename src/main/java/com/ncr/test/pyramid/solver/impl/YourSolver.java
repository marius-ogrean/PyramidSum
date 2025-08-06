package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {
    private long max = -1;

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        getTotalAbove(pyramid.getRows() - 1, 0, pyramid, 0);
        return max;
    }

    private void getTotalAbove(int row, int column, Pyramid pyramid, long sumUpToThisPoint) {
        int myValue = pyramid.get(row, column);
        long newSum = sumUpToThisPoint + myValue;

        if (row == 0) {
            if (newSum > max) {
                max = newSum;
            }

            return;
        }

        getTotalAbove(row - 1, column, pyramid, newSum);
        getTotalAbove(row - 1, column + 1, pyramid, newSum);
    }
}
