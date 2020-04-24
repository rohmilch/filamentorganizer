package filamentorganizer.logik;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "prints")
public class Print implements Displayable {

	@Id
	@GeneratedValue
	private int mIndex;
	@Column
	private int mDuration;
	@Column
	private double mLength;
	@Column
	private double mWeight;
	@Column
	private String mNote;
	@ManyToOne
	@JoinColumn(name = "projects")
	private Project mProject;
	@Column
	private String mNamePrint;

	@Column
	private double mPrice;

	@Column
	private long mDate;

	@ManyToOne
	@JoinColumn(name = "filamentspools")
	private FilamentSpool mFilament;

	public Print(double pLength, double pWeight, String pNote, Project pProject, String pName,
			FilamentSpool pFilament) {
		super();
		mLength = pLength;
		mWeight = pWeight;
		mNote = pNote;
		mProject = pProject;
		mNamePrint = pName;
		mFilament = pFilament;
	}

	public Print() {
	}
	// DB

	public Date getDateFormatted() {
		return new Date(getDate());
	}

	public int getIndex() {
		return mIndex;
	}

	public void setIndex(int pIndex) {
		mIndex = pIndex;
	}

	public double getLength() {
		return mLength;
	}

	public void setLength(double pLength) {
		mLength = pLength;
	}

	public double getWeight() {
		return mWeight;
	}

	public void setWeight(double pWeight) {
		mWeight = pWeight;
	}

	public String getNote() {
		return mNote;
	}

	public void setNote(String pNote) {
		mNote = pNote;
	}

	public Project getProject() {
		return mProject;
	}

	public void setProject(Project pProject) {
		mProject = pProject;
	}

	public String getNamePrint() {
		return mNamePrint;
	}

	public void setNamePrint(String pName) {
		mNamePrint = pName;
	}

	public FilamentSpool getFilament() {
		return mFilament;
	}

	public void setFilament(FilamentSpool pFilament) {
		mFilament = pFilament;
	}

	public int getDuration() {
		return mDuration;
	}

	public void setDuration(int pDuration) {
		mDuration = pDuration;
	}

	public long getDate() {
		return mDate;
	}

	public void setDate(long pDate) {
		mDate = pDate;
	}

	public double getPrice() {
		return mPrice;
	}

	public void setPrice(double pPrice) {
		mPrice = pPrice;
	}

}
