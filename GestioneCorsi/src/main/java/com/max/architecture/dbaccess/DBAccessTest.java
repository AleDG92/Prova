package com.max.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.max.architecture.dao.DAOException;

class DBAccessTest {

	@Test
	void test() throws SQLException, FileNotFoundException, IOException {
		try {
			DBAccess.getConnection();
		}catch(DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			fail("Connessione non funzionante");
		}finally {
			try {
				DBAccess.closeConnection();
			}catch(DAOException exc) {
				exc.printStackTrace();
				fail("Impossibile chiudere la connessione");
			}
		}
		
		
		
		
		
		
		
		
	}

}
