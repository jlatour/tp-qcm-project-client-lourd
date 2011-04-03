package dal;

import java.sql.Connection;
import java.sql.SQLException;


public interface IDal {

	public Connection OpenCnx();
	public void closeCnx() throws SQLException;
}
