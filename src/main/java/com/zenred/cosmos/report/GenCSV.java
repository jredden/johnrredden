package com.zenred.cosmos.report;

import java.util.Map;

import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;

public class GenCSV {
	
	enum Columns{
		a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab
	}
	
	Map<Columns,String> row;
	
	public static Integer numberSystemsUatATime = ImergeFromHyperspace.uDistribution * ImergeFromHyperspace.vDistribution;
	

}
