package Code.OverlappingIntervals.Project02;

import java.util.*;

public class MergeIntervals {

    private static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public static List<Interval> insertMerge(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        List<Interval> result = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval current = intervals.get(i);
            newInterval.start = Math.min(current.start, newInterval.start);
            newInterval.end = Math.max(current.end, newInterval.end);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(5, 7),
                new Interval(8, 10),
                new Interval(11, 12)
        );

        Interval newInterval = new Interval(4, 9);

        List<Interval> mergedIntervals = insertMerge(intervals, newInterval);
        for (int i = 0; i < mergedIntervals.size(); i++) {
            Interval interval = mergedIntervals.get(i);
            System.out.print(interval + " ");
        }
    }
}
