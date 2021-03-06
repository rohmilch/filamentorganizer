package filamentorganizer.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import filamentorganizer.general.ConstantsAndGeneralMethods;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Print;
import filamentorganizer.logik.Project;

public class DatabaseConnection {

	// Achtung, InitialKrams
//	TableUtils.createTable(lConnect, FilamentSpool.class);
//C://sqlite/db/ muss es geben

	public static ConnectionSource getConnect() {
		ConnectionSource connectionSource = null;
		try {
			connectionSource = new JdbcConnectionSource(ConstantsAndGeneralMethods.DATABASE_URL);
			TableUtils.createTableIfNotExists(connectionSource, FilamentSpool.class);
			TableUtils.createTableIfNotExists(connectionSource, Project.class);
			TableUtils.createTableIfNotExists(connectionSource, Print.class);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connectionSource;
	}

	public static void addFilamentToDatabase(FilamentSpool pFilament) {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<FilamentSpool, String> lFilamentDAO;
		try {
			lFilamentDAO = getDAOFilament(lConnect);

			lFilamentDAO.create(pFilament);
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addPrintToDatabaseAndUpdateFilamentAndProject(Print pPrint) {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<FilamentSpool, String> lFilamentDAO;
		Dao<Print, String> lPrintDAO;
		Dao<Project, String> lProjectDAO;
		try {
			lFilamentDAO = getDAOFilament(lConnect);
			lFilamentDAO.update(pPrint.getFilament());

			lPrintDAO = getDAOPrint(lConnect);
			lPrintDAO.create(pPrint);
			lProjectDAO = getDAOProject(lConnect);
			lProjectDAO.update(pPrint.getProject());

			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addProjectToDatabase(Project pProject) {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<Project, String> lProjectDAO;
		try {
			lProjectDAO = getDAOProject(lConnect);
			lProjectDAO.create(pProject);
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<FilamentSpool> getFilamentListFromDatabase() {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<FilamentSpool, String> lFilamentDAO;
		List<FilamentSpool> lListOFAllFilament = new ArrayList<FilamentSpool>();
		try {
			lFilamentDAO = getDAOFilament(lConnect);
			lListOFAllFilament = lFilamentDAO.queryForAll();
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lListOFAllFilament;
	}

	public static List<Project> getProjectListFromDatabase() {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<Project, String> lProjectDAO;
		List<Project> lListOFAllProjects = new ArrayList<Project>();
		try {
			lProjectDAO = getDAOProject(lConnect);
			lListOFAllProjects = lProjectDAO.queryForAll();
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lListOFAllProjects;
	}

	public static List<Print> getPrintListFromDatabase() {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<Print, String> lPrintDAO;
		List<Print> lListOFAllPrints = new ArrayList<Print>();
		try {
			lPrintDAO = getDAOPrint(lConnect);
			lListOFAllPrints = lPrintDAO.queryForAll();
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lListOFAllPrints;
	}

	private static Dao<FilamentSpool, String> getDAOFilament(ConnectionSource lConnect) throws SQLException {
		Dao<FilamentSpool, String> lFilamentDAO;
		lFilamentDAO = DaoManager.createDao(lConnect, FilamentSpool.class);
		return lFilamentDAO;
	}

	private static Dao<Print, String> getDAOPrint(ConnectionSource lConnect) throws SQLException {
		Dao<Print, String> lPrintDAO;
		lPrintDAO = DaoManager.createDao(lConnect, Print.class);
		return lPrintDAO;
	}

	private static Dao<Project, String> getDAOProject(ConnectionSource lConnect) throws SQLException {
		Dao<Project, String> lProjectDAO;
		lProjectDAO = DaoManager.createDao(lConnect, Project.class);
		return lProjectDAO;
	}
}