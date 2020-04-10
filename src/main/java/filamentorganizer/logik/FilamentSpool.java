package filamentorganizer.logik;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "filamentspools")
public class FilamentSpool {

	@Id
	@GeneratedValue
	private int mIndex;

	@Column
	private int mLength;
	@Column
	private int mWeight;
	@Column
	private String mColour;
	@Column
	private String mName;
	@Column
	private String mManufacturer;
	@Column
	private Material mMaterial;
	@Column
	private double mDiameter;
	@Column
	private double mPrice;
	@Column(nullable = true)
	private int mIdealNoozleTemp;
	@Column(nullable = true)
	int mIdealBedTemp;

	public FilamentSpool() {
		// Datenbank braucht das
	}

	public FilamentSpool(int pLength, int pWeight, String pColour, String pName, String pManufacturer,
			Material pMaterial, double pDiameter, double pPrice, int pIdealNoozleTemp, int pIdealBedTemp) {
		mLength = pLength;
		mWeight = pWeight;
		mColour = pColour;
		mName = pName;
		mManufacturer = pManufacturer;
		mMaterial = pMaterial;
		mDiameter = pDiameter;
		mPrice = pPrice;
		mIdealNoozleTemp = pIdealNoozleTemp;
		mIdealBedTemp = pIdealBedTemp;
	}

	public static FilamentSpool createASpool(int pLength, int pTotalWeigth, String pColour, String pName,
			String pManufacturer, String pMaterial, double pDiameter, double pPrice, int pIdealNoozleTemp,
			int pIdealBedTemp) {
		Material lMaterialEnum = Material.getEnum(pMaterial);
		FilamentSpool lFilamentSpool = new FilamentSpool(pLength, pTotalWeigth, pColour, pName, pManufacturer,
				lMaterialEnum, pDiameter, pPrice, pIdealNoozleTemp, pIdealBedTemp);
		return lFilamentSpool;
	}

	public int getLength() {
		return mLength;
	}

	public void setLength(int pLength) {
		mLength = pLength;
	}

	public int getWeight() {
		return mWeight;
	}

	public void setWeigth(int pWeigth) {
		mWeight = pWeigth;
	}

	public String getColour() {
		if (mColour == null) {
			setColour("");
		}
		return mColour;
	}

	public void setColour(String pColour) {
		mColour = pColour;
	}

	public String getName() {
		if (mName == null) {
			setName("");
		}
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}

	public String getManufacturer() {
		if (mManufacturer == null) {
			setManufacturer("");
		}
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

	public double getDiameter() {
		return mDiameter;
	}

	public void setDiameter(double pDiameter) {
		mDiameter = pDiameter;
	}

	public double getPrice() {
		return mPrice;
	}

	public void setPrice(double pPrice) {
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
