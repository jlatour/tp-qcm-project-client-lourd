package dal;

import java.sql.Connection;

public class DalFactory implements IDal {

	private Connection _cnx;

	public DalFactory(ConnectionProvider pCprovider) {
		switch (pCprovider) {
		case sqlserver:
			_cnx = CnxSqlServer.OpenCnx();
			break;
		case mysql:
			_cnx = CnxMySQL.OpenCnx();
		}
	}

	@Override
	public IDal getConnexion() {
		return (IDal) _cnx;
	}

}
