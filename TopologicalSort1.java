package leetcode;

import java.util.*;

public class lc207 {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Map<Integer,List> adj = new HashMap<Integer,List>();
        for( int i = 0 ; i < numCourses ; i++ ){
        	map.put(i, 0);
        }
        for( int i = 0 ; i < prerequisites.length ; i++ ){
        	//map.put(prerequisites[i][0], 0);
        	List<Integer> l = adj.get(prerequisites[i][0]) == null? new LinkedList<Integer>():adj.get(prerequisites[i][0]);
    
        	l.add(prerequisites[i][1]);
        	adj.put(prerequisites[i][0], l);
        }
        for( int i = 0 ; i < prerequisites.length ; i++ ){
        	map.put(prerequisites[i][1], map.get(prerequisites[i][1])+1);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = numCourses;
        for( int i = 0 ; i < map.size() ; i++ ){
        	if( map.get(i) == 0 ){
        		queue.add(i);
        	}
        	else if( map.get(i) == -1 ) count--;
        }
        int num = 0;
        while( !queue.isEmpty() ){
        	int zeroDegree = queue.poll();
        	num++;
        	List<Integer> adjList = adj.get(zeroDegree);
        	if( adjList != null ){
	        	for( int i : adjList){
	        		map.put(i,map.get(i)-1);
	        		if( map.get(i) == 0 ){
	        			queue.add(i);
	        		}
	        	}
        	}
        }
        if( num == count ) return true;
        return false;
    }
	
	public void test(){
		int numCourses = 5;
		int[][] prerequisites = {
				{2,0},
				{1,0},
				{3,1},
				{3,2},
				{0,3}
		};
		/*
		int numCourses = 3;
		int[][] prerequisites = {
				{0,2},
				{1,2},
				{2,0}
		};
		*/
		boolean res = canFinish(numCourses,prerequisites);
		System.out.println("res: "+res);
	}
}
