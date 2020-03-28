package filamentorganizer.logik;

public class FilamentSpool {
	
	private int mLength;
	private int mTotalWeigth;
	private String mColour; 
	private String mName;
	private String mManufacturer;
	private Material mMaterial; //Enum
	private int mDiameter; //egal?
	private int mPrice;
	private int mIdealNoozleTemp;
	private int mIdealBedTemp;
	
	
	
	public FilamentSpool(int pLength, int pTotalWeigth, String pColour, String pName, String pManufacturer, Material pMaterial,
			int pDiameter, int pPrice, int pIdealNoozleTemp, int pIdealBedTemp) {
		mLength = pLength;
		mTotalWeigth = pTotalWeigth;
		mColour = pColour;
		mName = pName;
		mManufacturer = pManufacturer;
		mMaterial = pMaterial;
		mDiameter = pDiameter;
		mPrice = pPrice;
		mIdealNoozleTemp = pIdealNoozleTemp;
		mIdealBedTemp = pIdealBedTemp;
	}

	public static FilamentSpool createASpool (int pLength, int pTotalWeigth, String pColour, String pName, String pManufacturer, Material pMaterial,
	int pDiameter, int pPrice, int pIdealNoozleTemp, int pIdealBedTemp) {
	return	new FilamentSpool(pLength, pTotalWeigth, pColour, pName, pManufacturer, pMaterial, pDiameter, pPrice, pIdealNoozleTemp, pIdealBedTemp);
	}
	
	public int getLength() {
		return mLength;
	}
	public void setLength(int pLength) {
		mLength = pLength;
	}
	public int getTotalWeigth() {
		return mTotalWeigth;
	}
	public void setTotalWeigth(int pTotalWeigth) {
		mTotalWeigth = pTotalWeigth;
	}
	public String getColour() {
		return mColour;
	}
	public void setColour(String pColour) {
		mColour = pColour;
	}
	public String getName() {
		return mName;
	}
	public void setName(String pName) {
		mName = pName;
	}
	public String getManufacturer() {
		return mManufacturer;
	}
	public void setManufacturer(String pManufacturer) {
		mManufacturer = pManufacturer;
	}
	public Material getMaterial() {
		return mMaterial;
	}
	public void setMaterial(Material pMaterial) {
		mMaterial = pMaterial;
	}
	public int getDiameter() {
		return mDiameter;
	}
	public void setDiameter(int pDiameter) {
		mDiameter = pDiameter;
	}
	public int getPrice() {
		return mPrice;
	}
	public void setPrice(int pPrice) {
		mPrice = pPrice;
	}
	public int getIdealNoozleTemp() {
		return mIdealNoozleTemp;
	}
	public void setIdealNoozleTemp(int pIdealNoozleTemp) {
		mIdealNoozleTemp = pIdealNoozleTemp;
	}
	public int getIdealBedTemp() {
		return mIdealBedTemp;
	}
	public void setIdealBedTemp(int pIdealBedTemp) {
		mIdealBedTemp = pIdealBedTemp;
	}
	
	
	
	
}
