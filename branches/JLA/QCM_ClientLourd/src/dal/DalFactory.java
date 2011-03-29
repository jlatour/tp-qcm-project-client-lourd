package dal;


public class DalFactory {

	private static IDal _cnx;

	public static IDal getDalFactory(ConnectionProvider pCprovider) {
			switch (pCprovider) {
			case sqlserver:
				_cnx = new CnxSqlServer();
				break;
			case mysql:
				_cnx = new CnxMySQL();
			}
			return _cnx;
	}

}
