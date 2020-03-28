package filamentorganizer.logik;

public enum Material{
	
	PLA ("PLA", 1.24),
	PETG ("PETG", 1.23),
	ABS ("ABS", 1.04),
	NYLON("Nylon", 1.28),
	WOOD ("Wood", 1.28);
	
	private static final Material[] mValues = Material.values();
			
	private String mText;
	private double mDensity;
	//g/cm^3

	
	Material(String pText, double pDensity) {
		mText = pText;
		mDensity = pDensity;
	}


	public String getText() {
		return mText;
	}


	public void setText(String pText) {
		mText = pText;
	}


	public double getDensity() {
		return mDensity;
	}


	public void setDensity(double pDensity) {
		mDensity = pDensity;
	}


	public static Material[] getValues() {
		return mValues;
	}

	
		
	
}
