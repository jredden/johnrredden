package com.zenred.cosmos.service_rules_and_infrastructure;

import java.util.ArrayList;
import java.util.List;

import com.zenred.cosmos.domain.ClusterRep;
import com.zenred.cosmos.domain.ClusterRepDao;
import com.zenred.cosmos.domain.Star;
import com.zenred.cosmos.domain.StarDao;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.vizualization.ClusterResponse;

public class ExamineSystems {
	
	protected static List<String> startWithCluster(String systemName){
		SystemDao systemDao = new SystemDao();
		ClusterRepDao clusterRepDao = new ClusterRepDao();
		com.zenred.cosmos.domain.System system = systemDao.readSystemByName(systemName);
		Boolean anyStars = clusterRepDao.areThereStarsInSystem(system);
		if(!anyStars){
			return new ArrayList();
		}
		StarDao starDao = new StarDao();
		ClusterRep clusterRep = new ClusterRep();
		clusterRep.setSystemId(system.getSystemId());
		clusterRep = clusterRepDao.updateClusterRepBySystemId(clusterRep);
		List<Star> stars = starDao.readStarsInCluster(clusterRep);
		List<String> keyValuePairs = new ArrayList<String>();
		for(Star star : stars){
			StringBuilder keyValuePair = new StringBuilder();
			String subClusterdescription = starDao.readStarsSubClusterDescription(star);
			keyValuePair.append(StarDao.SUB_CLUSTER_DESCRIPTION).append("=").append(subClusterdescription);
			keyValuePair.append(StarDao.ANGLE_IN_RADIANS_S).append("=").append(star.getAngle_in_radians_s());
			keyValuePair.append(StarDao.DISTANCE_CLUST_VIRT_CENTRE).append("=").append(star.getDistance_clust_virt_centre());
			keyValuePair.append(StarDao.LUMINOSITY).append("=").append(star.getLuminosity());
			keyValuePair.append(StarDao.NAME).append("=").append(star.getName());
			keyValuePair.append(StarDao.STAR_COLOR).append("=").append(star.getStar_color());
			keyValuePair.append(StarDao.STAR_SIZE).append("=").append(star.getStar_size());
			keyValuePair.append(StarDao.STAR_TYPE).append("=").append(star.getStar_type());
			keyValuePairs.add(keyValuePair.toString());
		}
		return keyValuePairs;
	}
	/**
	 * builds message with all the stars in the system
	 * 
	 * @param systemName
	 * @return
	 */
	public static ClusterResponse starsInCluster(String systemName){
		List<String> keyValuePairs = startWithCluster(systemName);
		String [] keyValueArray = new String[keyValuePairs.size()];
		int idex = 0;
		for (String keyValue : keyValuePairs){
			keyValueArray[idex++] = keyValue;
		}
		ClusterResponse clusterResponse = new ClusterResponse();
		clusterResponse.setStars(keyValueArray);
		return clusterResponse;
	}

}
