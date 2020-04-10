package filamentorganizer.logik;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "projects")
public class Project {

	@Id
	private String mName;

	@OneToMany(mappedBy = "prints")
	private ArrayList<Print> mListOfPrints;

	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}

	public ArrayList<Print> getListOfPrints() {
		if (mListOfPrints == null) {
			return new ArrayList<Print>();
		}
		return mListOfPrints;
	}

	public void setListOfPrints(ArrayList<Print> pListOfPrints) {
		mListOfPrints = pListOfPrints;
	}

}
