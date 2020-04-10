package filamentorganizer.logik;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "prints")
public class Print {

	@Id
	@GeneratedValue
	private int mIndex;

	@Column
	private int mLength;
	@Column
	private int mWeight;
	@Column
	private String mNote;
//	@Column
	private Project mProject;
	@Column
	private String mName;
	@Column
	private FilamentSpool mFilament;

	public Print(int pLength, int pWeight, String pNote, Project pProject, String pName, FilamentSpool pFilament) {
		super();
		mLength = pLength;
		mWeight = pWeight;
		mNote = pNote;
		mProject = pProject;
		mName = pName;
		mFilament = pFilament;
	}

	public int getIndex() {
		return mIndex;
	}

	public void setIndex(int pIndex) {
		mIndex = pIndex;
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

	public void setWeight(int pWeight) {
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

	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}

	public FilamentSpool getFilament() {
		return mFilament;
	}

	public void setFilament(FilamentSpool pFilament) {
		mFilament = pFilament;
	}

}
