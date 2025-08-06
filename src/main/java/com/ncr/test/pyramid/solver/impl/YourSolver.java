package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        Deque<Node> stack = new ArrayDeque<>();

        stack.push(new Node(pyramid.getRows() - 1, 0, 0));

        long max = -1;

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            int myValue = pyramid.get(current.row, current.column);
            long newSum = current.sumUpToThisPoint + myValue;

            if (current.row == 0) {
                if (newSum > max) {
                    max = newSum;
                }
            } else {
                stack.push(new Node(current.row - 1, current.column + 1, newSum));
                stack.push(new Node(current.row - 1, current.column, newSum));
            }
        }

        return max;
    }

    private class Node {
        public int row;
        public int column;
        public long sumUpToThisPoint;

        public Node(int row, int column, long sumUpToThisPoint) {
            this.row = row;
            this.column = column;
            this.sumUpToThisPoint = sumUpToThisPoint;
        }
    }
}
