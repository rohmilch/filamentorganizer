package filamentorganizer.logik;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "projects")
public class Project {

	@Id
	private String mName;

	@Column
	private List<Print> mListOfPrints;

}
