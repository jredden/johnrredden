package com.zenred.cosmos.domain;

public class DistanceDetails implements DistanceDetailsIF {
	
	private Integer numberStarsToGenerate;
	private Double mediumDistance;
	private Double variance;
	Double distanceBetweenStars;
	
	public DistanceDetails(Integer numberStarsToGenerate,
			Double mediumDistance, Double variance) {
		super();
		this.numberStarsToGenerate = numberStarsToGenerate;
		this.mediumDistance = mediumDistance;
		this.variance = variance;
	}

	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#getNumberStarsToGenerate()
	 */
	public Integer getNumberStarsToGenerate() {
		return numberStarsToGenerate;
	}
	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#setNumberStarsToGenerate(java.lang.Integer)
	 */
	public void setNumberStarsToGenerate(Integer numberStarsToGenerate) {
		this.numberStarsToGenerate = numberStarsToGenerate;
	}
	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#getMediumDistance()
	 */
	public Double getMediumDistance() {
		return mediumDistance;
	}
	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#setMediumDistance(java.lang.Double)
	 */
	public void setMediumDistance(Double mediumDistance) {
		this.mediumDistance = mediumDistance;
	}
	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#getVariance()
	 */
	public Double getVariance() {
		return variance;
	}
	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#setVariance(java.lang.Double)
	 */
	public void setVariance(Double variance) {
		this.variance = variance;
	}
	
	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#getDistanceBetweenStars()
	 */
	public Double getDistanceBetweenStars() {
		return distanceBetweenStars;
	}

	/* (non-Javadoc)
	 * @see com.zenred.cosmos.domain.DistanceDetailsIF#setDistanceBetweenStars(java.lang.Double)
	 */
	public void setDistanceBetweenStars(Double distanceBetweenStars) {
		this.distanceBetweenStars = distanceBetweenStars;
	}

	@Override
	public String toString() {
		return "DistanceDetails [numberStarsToGenerate="
				+ numberStarsToGenerate + ", mediumDistance=" + mediumDistance
				+ ", variance=" + variance + ", distanceBetweenStars="
				+ distanceBetweenStars + "]";
	}
	
}