package filamentorganizer.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import filamentorganizer.general.Constants;
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
			connectionSource = new JdbcConnectionSource(Constants.DATABASE_URL);
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

	public static void addPrintToDatabaseAndUpdateFilament(Print pPrint, FilamentSpool pFilament) {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<FilamentSpool, String> lFilamentDAO;
		Dao<Print, String> lPrintDAO;
		try {
			lFilamentDAO = getDAOFilament(lConnect);
			lFilamentDAO.update(pFilament);

//			lPrintDAO = getDAOPrint(lConnect);
//			lPrintDAO.create(pPrint);

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

	private static Dao<FilamentSpool, String> getDAOFilament(ConnectionSource lConnect) throws SQLException {
		Dao<FilamentSpool, String> lFilamentDAO;
		lFilamentDAO = DaoManager.createDao(lConnect, FilamentSpool.class);
		if (!lFilamentDAO.isTableExists()) {
			TableUtils.createTableIfNotExists(lConnect, FilamentSpool.class);
		}
		return lFilamentDAO;
	}

	private static Dao<Print, String> getDAOPrint(ConnectionSource lConnect) throws SQLException {
		Dao<Print, String> lPrintDAO;
		lPrintDAO = DaoManager.createDao(lConnect, Print.class);
		if (!lPrintDAO.isTableExists()) {
			TableUtils.createTableIfNotExists(lConnect, Print.class);
		}
		return lPrintDAO;
	}

	public static List<Project> getProjectListFromDatabase() {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<Project, String> lProjectDAO;
		List<Project> lListOFAllFilament = new ArrayList<Project>();
		try {
			lProjectDAO = getDAOProject(lConnect);
			lListOFAllFilament = lProjectDAO.queryForAll();
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lListOFAllFilament;
	}

	private static Dao<Project, String> getDAOProject(ConnectionSource lConnect) throws SQLException {
		Dao<Project, String> lProjectDAO;
		lProjectDAO = DaoManager.createDao(lConnect, Project.class);
		if (!lProjectDAO.isTableExists()) {
			TableUtils.createTableIfNotExists(lConnect, Project.class);
		}
		return lProjectDAO;
	}
}