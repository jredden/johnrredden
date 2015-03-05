package com.zenred.cosmos.domain;

public interface DistanceDetailsIF {

	public abstract Integer getNumberStarsToGenerate();

	public abstract void setNumberStarsToGenerate(Integer numberStarsToGenerate);

	public abstract Double getMediumDistance();

	public abstract void setMediumDistance(Double mediumDistance);

	public abstract Double getVariance();

	public abstract void setVariance(Double variance);

	public abstract Double getDistanceBetweenStars();

	public abstract void setDistanceBetweenStars(Double distanceBetweenStars);

}