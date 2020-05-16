import java.util.*;
// 3 1 3 2 5 3 6
public class CoveringSegments {

    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        ArrayList<Integer> points = new ArrayList<Integer>();
        Arrays.sort(segments, (x,y) -> Integer.compare(x.end, y.end));
        int point = segments[0].end;
        points.add(segments[0].end);
        for (Segment segment: segments){
            if(! segment.condition(point)){
                point = segment.end;
                points.add(point);

            }
        }
        return points;
    }
    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        private boolean condition (int point){
            return point >= start && point <= end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
