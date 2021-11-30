package com.max.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {
	private static final long serialVersionUID = -8273620554038680419L;

	private final static int ORA1017 = 1017; // eccezione credenziali db
	private final static int ORA17002 = 17002;// non riesce a connettersi ad oracle
	private final static int ORA00001 = 0;// violazione di vincolo di tabella

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

	public DAOException(SQLException sql) {
		String chiave = "";
		if (sql != null) {
			switch (sql.getErrorCode()) {
			case ORA1017:
				chiave = "Username / password errati";
				log(sql);
				break;
			case ORA17002:
				chiave = "I/O exception di Oracle DB";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			default:
				chiave = "eccezione SQL non prevista";
				log(sql);
				break;
			}
		}

		message = chiave;
	}

	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("motivo: " + sql.getMessage());
		System.err.println("Stato dell'app: " + sql.getSQLState());
		System.err.println("Error code: " + sql.getErrorCode());
		System.err.println("Causa dell'eccezione: " + sql.getCause());
	}

}
