package filamentorganizer.logik;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "projects")
public class Project implements Displayable {

	@Id
	private String mNameProject;

	@OneToMany(mappedBy = "prints")
	private ArrayList<Print> mListOfPrints;

	public String getNameProject() {
		return mNameProject;
	}

	public void setNameProject(String pName) {
		mNameProject = pName;
	}

	public ArrayList<Print> getListOfPrints() {
		if (mListOfPrints == null) {
			mListOfPrints = new ArrayList<Print>();
		}
		return mListOfPrints;
	}

	public void setListOfPrints(ArrayList<Print> pListOfPrints) {
		mListOfPrints = pListOfPrints;
	}

	@Override
	public String toString() {
		return getNameProject();
	}
}
