package Code.OverlappingIntervals.Project01;

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

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2){
            return intervals;
        }

        // Sort intervals based on the start time
        intervals.sort(Comparator.comparingInt(in -> in.start));

        List<Interval> result = new LinkedList<>();
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= end) {
                // Overlapping intervals, merge them
                end = Math.max(current.end, end);
            } else {
                // Non-overlapping interval, add to result
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        // If you want to make intervals by taking input from user;;

//        Scanner scanner = new Scanner(System.in);
//        List<Interval> intervals = new ArrayList<>();
//
//        System.out.println("Enter the number of intervals:");
//        int n = scanner.nextInt();
//
//        System.out.println("Enter the intervals (start and end):");
//        for (int i = 0; i < n; i++) {
//            int start = scanner.nextInt();
//            int end = scanner.nextInt();
//            intervals.add(new Interval(start, end));
//        }

        List<Interval> mergedIntervals = merge(intervals);
        for (int i = 0; i < mergedIntervals.size(); i++) {
            Interval interval = mergedIntervals.get(i);
            System.out.print(interval + " ");
        }
    }
}
