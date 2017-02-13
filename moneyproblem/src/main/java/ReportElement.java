package main.java;



public class ReportElement {

	private String instrument;
	private int noOfShares; 
	private Curency priceOfShar;
	

	private ReportElement(ReportElementBuilder builder) {
		this.setInstrument(builder.instrument);
		this.noOfShares = builder.noOfShares;
		this.priceOfShar = builder.priceOfShare;
		
	}

	public Curency getPriceOfShares() {
		return priceOfShar;
	}

	public void setPriceOfShares(Curency priceOfShares) {
		this.priceOfShar = priceOfShares;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public Curency calculateTotalSharePrice() {
		return  this.priceOfShar.multiply(this.noOfShares);     
	}
		
	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public static class ReportElementBuilder {
		private String instrument;
		private int noOfShares;
		Curency priceOfShare;
		

		public ReportElementBuilder withInstrument(String instrument) {
			this.instrument = instrument;
			return this;
		}

		public ReportElementBuilder withNoOfShares(int noOfShares) {
			this.noOfShares = noOfShares;
			return this;
		}

		public ReportElementBuilder withPriceOfShares(Curency priceOfShares) {
			this.priceOfShare = priceOfShares;
			return this;
		}

		public ReportElement build() {
			return new ReportElement(this);
		}

		

	}

}
