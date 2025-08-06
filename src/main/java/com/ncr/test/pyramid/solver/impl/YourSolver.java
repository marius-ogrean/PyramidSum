package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        //we alter the data in the pyramid by always adding the maximum of the values below with which can be a valid source
        // thus, after processing all the rows we will get the maximum for each cell of the top row
        // then we get this maximum and return it

        for (int i = pyramid.getRows() - 2; i >= 0; i--) {
            for (int j = 0; j < pyramid.getRows() - i; j++) {
                if (j == 0) {
                    pyramid.getData()[i][j] += pyramid.get(i + 1, j);
                } else {
                    if (pyramid.get(i + 1, j) > pyramid.get(i + 1, j - 1)) {
                        pyramid.getData()[i][j] += pyramid.get(i + 1, j);
                    } else {
                        pyramid.getData()[i][j] += pyramid.get(i + 1, j - 1);
                    }
                }
            }
        }

        int max = -1;

        for (int i = 0; i < pyramid.getRows(); i++) {
            if (pyramid.get(0, i) > max) {
                max = pyramid.get(0, i);
            }
        }

        return max;
    }
}
