package com.epam.rd.autotasks.segments;

class Segment {
    private final double x1;
    private final double x2;
    private final double y1;
    private final double y2;

    public Segment(Point start, Point end) {
        x1 = start.getX();
        x2 = end.getX();
        y1 = start.getY();
        y2 = end.getY();
        if (start.equals(end) || (x1 == x2 && y1 == y2)) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + (Math.pow((y2 - y1), 2)));
    }

    Point middle() {
        return new Point((x1 + x2)/2, (y1 + y2)/2);
    }

    Point intersection(Segment another) {
        if (x1/another.x1 == y1/another.y1 || x1/another.x1 == y2/another.y2 || (x1 == another.x1 && y2 == another.y2 && y1 > another.y1 && x2 > another.x2)) {
            return null;
        }
        else {
            double xi, yi;
            double d = (x1 - x2)*(another.y1 - another.y2) - (y1 - y2)*(another.x1 - another.x2);
            double v = another.x1 * another.y2 - another.y1 * another.x2;
            xi = ((x1*y2 - y1*x2)*(another.x1 - another.x2) - (x1 - x2)* v)/d;
            yi = ((x1*y2 - y1*x2)*(another.y1 - another.y2)-(y1 - y2)* v)/d;
            return new Point(xi, yi);
        }
    }
}