package filamentorganizer.data;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import filamentorganizer.general.Constants;
import filamentorganizer.logik.FilamentSpool;
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

	public static void createFilament(FilamentSpool pFilament) {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<FilamentSpool, String> lFilamentDAO;
		try {
			lFilamentDAO = DaoManager.createDao(lConnect, FilamentSpool.class);
			lFilamentDAO.create(pFilament);
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createProject(Project pProject) {
		ConnectionSource lConnect = DatabaseConnection.getConnect();
		Dao<Project, String> lProjectDAO;
		try {
			lProjectDAO = DaoManager.createDao(lConnect, Project.class);
			lProjectDAO.create(pProject);
			lConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}