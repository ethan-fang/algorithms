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
		
		//The map between slop and lines. Each line is defined as Set<Point>. So each slop can have several lines (as array).
        Map<Double, List<Set<Point>>> slopMap = new HashMap<Double, List<Set<Point>>>();
        
        //For vertical lines, key is no defined. So we need a separate line set for vertical lines.
        List<Set<Point>> verticalPoints = new ArrayList<Set<Point>>();
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                
                //Add duplicate points 
                if (p1.x == p2.x && p1.y == p2.y) {
                    addDuplicatePointsToAllSlops(p1, p2, slopMap, verticalPoints);
                }
                
                //Add the line into all slop map and vertical lines set.
                addNewLineIntoAllLines(p1, p2, slopMap, verticalPoints);
            }
        }
        
        //Get the max count of points in all slops and vertical lines
        return maxCount(slopMap, verticalPoints);
    }
	
	private int maxCount(Map<Double, List<Set<Point>>> slopMap, List<Set<Point>> verticalPoints) {
		int max = 0;
		
		//Excepe vertical lines
		for (Map.Entry<Double, List<Set<Point>>> entry : slopMap.entrySet()) {
    		List<Set<Point>> list = entry.getValue();
    		int maxFromList = maxCountFromSets(list);
    		if (max < maxFromList) max = maxFromList;
    	}  
		
		//Vertical lines
		int maxFromList = maxCountFromSets(verticalPoints);
		if (max < maxFromList) max = maxFromList;
		return max;
	}
	
	//Get max count of points from a slop
	private int maxCountFromSets(List<Set<Point>> pointsSets) {
		int max = 0;
		for (Set<Point> set : pointsSets) {
			if (max < set.size()) {
				max = set.size();
			}
		}
		return max;
	}
    
	//Add line into slop map and vertical lines
    private void addNewLineIntoAllLines(Point p1, Point p2, Map<Double, List<Set<Point>>> slopMap, List<Set<Point>> verticalPoints) {
        double slop = 0;
        
        //If it is vertical
        if (p1.x == p2.x) {
            addNewLineIntoSingleSlop(p1, p2, verticalPoints);
            return;
        }
        
        slop = Math.atan2((p2.y-p1.y), (p2.x-p1.x));
        List<Set<Point>> pointsSets = slopMap.get(slop);
        //No lines in the slop
        if (pointsSets == null) {
            pointsSets = new ArrayList<Set<Point>>();
            Set<Point> line = new HashSet<Point>();
            line.add(p1);
            line.add(p2);
            pointsSets.add(line);
            slopMap.put(slop, pointsSets);
        } else {
            addNewLineIntoSingleSlop(p1, p2, pointsSets);
        }
    }
    
    private void addDuplicatePointsToAllSlops(Point p1, Point samePoint, Map<Double, List<Set<Point>>> slopMap, List<Set<Point>> verticalPoints) {
        for (Map.Entry<Double, List<Set<Point>>> entry : slopMap.entrySet()) {
    		List<Set<Point>> list = entry.getValue();
    		addDuplicatePointsToSingleSlop(p1, samePoint, list);
    	}        
    	addDuplicatePointsToSingleSlop(p1, samePoint, verticalPoints);
    }
    
    private void addDuplicatePointsToSingleSlop(Point p1, Point samePoint, List<Set<Point>> pointsSets) {
        for (Set<Point> set: pointsSets) {
            if (set.contains(p1)) {
                set.add(samePoint);
                return;
            }
        }
    }

    private void addNewLineIntoSingleSlop(Point p1, Point p2, List<Set<Point>> pointsSets) {
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
        
        //If we can find two sets which contains p1, p2 respectively, we can merge them
        if (p1Set != null && p2Set != null) {
        	if (p1Set == p2Set) {
        		return;
        	}
            //Both of them has its own points, merge this two sets
            pointsSets.remove(p1Set);
            p2Set.addAll(p1Set);
            return;
        }
        
        //If one of the set contains both points, no need to do anything
        if ((p1Set != null && p1Set.contains(p2)) || (p2Set != null && p2Set.contains(p1))) {
            return;
        }
        
        //If only p1 exists in the slop
        if (p1Set != null) {
        	p1Set.add(p2);
        	return;
        }
        
        //If only p2 exists in the slop
        if (p2Set != null) {
        	p2Set.add(p1);
        	return;
        }
        
        //If both p1, p2 do not exist
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
