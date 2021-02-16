package ByteByByte;

public class TwoLinesIntersect {

    public static void main(String[] args) {

        // Line can be written as y = mx + b, where m is slope and b is y intercept. Two lines are same if their slope is same and their y intercept is same.
        // example: 2x + 5 and 3x + 10 do not have same slope and their y intercept is not same. So they intersect.

    }

    class Line {
        private final double epsilon = 0.00001;
        private double slope;
        private double yIntercept;

        public Line(double slope, double yIntercept) {
            this.slope = slope;
            this.yIntercept = yIntercept;
        }

        public boolean intersect(Line line) {
            if (this.equals(line)) return true;
            if (Math.abs(slope - line.slope) > epsilon) return true;
            return false;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Line)) return false;
            Line line = (Line) o;
            return Math.abs(slope - line.slope) < epsilon &&
                    Math.abs(yIntercept - line.yIntercept) < epsilon;
        }
    }


}
