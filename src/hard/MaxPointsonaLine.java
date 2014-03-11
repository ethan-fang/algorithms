package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxPointsonaLine {

	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
        Map<Double, List<Set<Point>>> slopMap = new HashMap<Double, List<Set<Point>>>();
        
        List<Set<Point>> verticalPoints = new ArrayList<Set<Point>>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    addSamePositionPointsIfNeeded(p1, p2, slopMap, verticalPoints);
                    addSamePositionPointsIfNeeded(p2, p1, slopMap, verticalPoints);
                }
                checkPoints(p1, p2, slopMap, verticalPoints);
            }
        }
        return maxCount(slopMap, verticalPoints);
    }
	
	private int maxCount(Map<Double, List<Set<Point>>> slopMap, List<Set<Point>> verticalPoints) {
		int max = 0;
		for (Map.Entry<Double, List<Set<Point>>> entry : slopMap.entrySet()) {
    		List<Set<Point>> list = entry.getValue();
    		int maxFromList = maxCountFromSets(list);
    		if (max < maxFromList) max = maxFromList;
    	}  
		int maxFromList = maxCountFromSets(verticalPoints);
		if (max < maxFromList) max = maxFromList;
		return max;
	}
	
	private int maxCountFromSets(List<Set<Point>> pointsSets) {
		int max = 0;
		for (Set<Point> set : pointsSets) {
			if (max < set.size()) {
				max = set.size();
			}
		}
		return max;
	}
    
    private void checkPoints(Point p1, Point p2, Map<Double, List<Set<Point>>> slopMap, List<Set<Point>> verticalPoints) {
        double slop = 0;
        if (p1.x == p2.x) {
            mergePoints(p1, p2, verticalPoints);
            return;
        }
        slop = Math.atan2((p2.y-p1.y), (p2.x-p1.x));
        List<Set<Point>> pointsSets = slopMap.get(slop);
        if (pointsSets == null) {
            pointsSets = new ArrayList<Set<Point>>();
            Set<Point> line = new HashSet<Point>();
            line.add(p1);
            line.add(p2);
            pointsSets.add(line);
            slopMap.put(slop, pointsSets);
        } else {
            mergePoints(p1, p2, pointsSets);
        }
    }
    
    private void addSamePositionPointsIfNeeded(Point p1, Point samePoint, Map<Double, List<Set<Point>>> slopMap, List<Set<Point>> verticalPoints) {
        for (Map.Entry<Double, List<Set<Point>>> entry : slopMap.entrySet()) {
    		List<Set<Point>> list = entry.getValue();
    		addSamePositionPointsIfNeeded(p1, samePoint, list);
    	}        
    	addSamePositionPointsIfNeeded(p1, samePoint, verticalPoints);
    }
    
    private void addSamePositionPointsIfNeeded(Point p1, Point samePoint, List<Set<Point>> pointsSets) {
        for (Set<Point> set: pointsSets) {
            if (set.contains(p1)) {
                set.add(samePoint);
                return;
            }
        }
    }
    
    private void mergePoints(Point p1, Point p2, List<Set<Point>> pointsSets) {
        Set<Point> p1Set = null;
        Set<Point> p2Set = null;
        for (Set<Point> set: pointsSets) {
            if (set.contains(p1)) {
                p1Set = set;
            }
            if (set.contains(p2)) {
                p2Set = set;
            }
        }
        if (p1Set != null && p2Set != null) {
        	if (p1Set == p2Set) {
        		return;
        	}
            //Both of them has its own points, merge this two sets
            pointsSets.remove(p1Set);
            p2Set.addAll(p1Set);
            return;
        }
        if ((p1Set != null && p1Set.contains(p2)) || (p2Set != null && p2Set.contains(p1))) {
            return;
        }
        if (p1Set != null) {
        	p1Set.add(p2);
        	return;
        }
        if (p2Set != null) {
        	p2Set.add(p1);
        	return;
        }
        if (p1Set == null && p2Set == null) {
            Set<Point> newSet = new HashSet<Point>();
            newSet.add(p1);
            newSet.add(p2);
            pointsSets.add(newSet);
        }
    }
    
    public static class Point {
    	 int x;
    	  int y;
    	  Point() { x = 0; y = 0; }
    	 Point(int a, int b) { x = a; y = b; }
    	 }
    
    public static void main(String[] args) {
		MaxPointsonaLine solution = new MaxPointsonaLine();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(1, 1);
//		System.out.println("max count " + solution.maxPoints(new Point[]{p1, p2, p3}));
	}
}
