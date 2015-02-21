package com.zenred.cosmos.domain;

public interface UnifiedPlanetoidI {
	
	class PlanetoidRep {
		Integer planetoidrepId;
		PlanetoidDomainFactory planetoidDomainFactory;
		Integer ownerId;
		Integer planetoidId;
		String datestamp;
		public Integer getPlanetoidrepId() {
			return planetoidrepId;
		}
		public void setPlanetoidrepId(Integer planetoidrepId) {
			this.planetoidrepId = planetoidrepId;
		}
		public PlanetoidDomainFactory getPlanetoidDomainFactory() {
			return planetoidDomainFactory;
		}
		public void setPlanetoidDomainFactory(
				PlanetoidDomainFactory planetoidDomainFactory) {
			this.planetoidDomainFactory = planetoidDomainFactory;
		}
		public Integer getOwnerId() {
			return ownerId;
		}
		public void setOwnerId(Integer ownerId) {
			this.ownerId = ownerId;
		}
		public Integer getPlanetoidId() {
			return planetoidId;
		}
		public void setPlanetoidId(Integer planetoidId) {
			this.planetoidId = planetoidId;
		}
		public String getDatestamp() {
			return datestamp;
		}
		public void setDatestamp(String datestamp) {
			this.datestamp = datestamp;
		}
		@Override
		public String toString() {
			return "PlanetoidRep [planetoidrepId=" + planetoidrepId
					+ ", planetoidDomainFactory=" + planetoidDomainFactory
					+ ", ownerId=" + ownerId + ", planetoidId=" + planetoidId
					+ ", datestamp=" + datestamp + "]";
		}
		
	}
	
	public Planetoid getPlanetoid();
	public void setPlanetoid(Planetoid planetoid);
	public PlanetoidRep getPlanetoidRep();
	public void setPlanetoidRep(PlanetoidRep planetoidRep);
	
	abstract class AbstractUnifiedPlanetoid implements UnifiedPlanetoidI{
		private Planetoid planetoid;
		private PlanetoidRep planetoidRep;
		public Planetoid getPlanetoid(){
			return planetoid;
		}
		public void setPlanetoid(Planetoid planetoid){
			this.planetoid = planetoid;
		}
		public PlanetoidRep getPlanetoidRep(){
			return planetoidRep;
		}
		public void setPlanetoidRep(PlanetoidRep planetoidRep){
			this.planetoidRep = planetoidRep;
		}
		@Override
		public String toString() {
			return "AbstractUnifiedPlanetoid [planetoid=" + planetoid
					+ ", planetoidRep=" + planetoidRep + "]";
		}
	}
	
	class UnifiedPlanetoidImpl extends AbstractUnifiedPlanetoid{
		public UnifiedPlanetoidImpl() {
			super();
		}

		@Override
		public String toString() {
			return "UnifiedPlanetoidImpl [getPlanetoid()=" + getPlanetoid()
					+ ", getPlanetoidRep()=" + getPlanetoidRep()
					+ ", toString()=" + super.toString() + ", getClass()="
					+ getClass() + ", hashCode()=" + hashCode() + "]";
		}
		
		
	}
}
