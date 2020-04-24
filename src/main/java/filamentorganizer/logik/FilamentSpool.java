package filamentorganizer.logik;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "filamentspools")
public class FilamentSpool {

	@Id
	@GeneratedValue
	private int mIndex;

	@Column
	private double mCurrentLength;
	@Column
	private double mCurrentWeight;
	@Column
	private double mOriginalLength;
	@Column
	private double mOriginalWeight;
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
	private int mIdealBedTemp;
	@OneToMany(mappedBy = "prints")
	private ArrayList<Print> mListOfPrints;

	public FilamentSpool() {
		// Datenbank braucht das
	}

	public FilamentSpool(double pLength, double pWeight, String pColour, String pName, String pManufacturer,
			Material pMaterial, double pDiameter, double pPrice, int pIdealNoozleTemp, int pIdealBedTemp) {
		mCurrentLength = pLength;
		mCurrentWeight = pWeight;
		mColour = pColour;
		mName = pName;
		mManufacturer = pManufacturer;
		mMaterial = pMaterial;
		mDiameter = pDiameter;
		mPrice = pPrice;
		mIdealNoozleTemp = pIdealNoozleTemp;
		mIdealBedTemp = pIdealBedTemp;
	}

	public static FilamentSpool createASpool(double pLength, double pTotalWeigth, String pColour, String pName,
			String pManufacturer, String pMaterial, double pDiameter, double pPrice, int pIdealNoozleTemp,
			int pIdealBedTemp) {
		Material lMaterialEnum = Material.getEnum(pMaterial);
		FilamentSpool lFilamentSpool = new FilamentSpool(pLength, pTotalWeigth, pColour, pName, pManufacturer,
				lMaterialEnum, pDiameter, pPrice, pIdealNoozleTemp, pIdealBedTemp);
		return lFilamentSpool;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " " + getColour();
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

	public ArrayList<Print> getListOfPrints() {
		return mListOfPrints;
	}

	public void setListOfPrints(ArrayList<Print> pListOfPrints) {
		mListOfPrints = pListOfPrints;
	}

	public double getCurrentLength() {
		return mCurrentLength;
	}

	public void setCurrentLength(double pCurrentLength) {
		mCurrentLength = pCurrentLength;
	}

	public double getCurrentWeight() {
		return mCurrentWeight;
	}

	public void setCurrentWeight(double pCurrentWeight) {
		mCurrentWeight = pCurrentWeight;
	}

	public double getOriginalLength() {
		return mOriginalLength;
	}

	public void setOriginalLength(double pOriginalLength) {
		mOriginalLength = pOriginalLength;
	}

	public double getOriginalWeight() {
		return mOriginalWeight;
	}

	public void setOriginalWeight(double pOriginalWeight) {
		mOriginalWeight = pOriginalWeight;
	}

}
