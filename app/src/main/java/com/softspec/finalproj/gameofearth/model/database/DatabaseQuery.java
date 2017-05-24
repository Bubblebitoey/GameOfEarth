package com.softspec.finalproj.gameofearth.model.database;

import com.softspec.finalproj.gameofearth.api.constants.DatabaseColumns;
import com.softspec.finalproj.gameofearth.api.constants.TableName;

/**
 * @author kamontat
 * @version 1.0
 * @since Thu 25/May/2017 - 1:08 AM
 */
public class DatabaseQuery {
	private static final String Q_TABLE_NAME = TableName.QUESTION.getName();
	private static final String A_TABLE_NAME = TableName.ACCEPTANCE.getName();
	private static final String D_TABLE_NAME = TableName.DECLINATION.getName();
	
	private static final String ID = DatabaseColumns.ID.getDatabaseKey();
	
	private static final String Q_NAME = DatabaseColumns.Q_TITLE.getDatabaseKey();
	private static final String Q_DESCRIPTION = DatabaseColumns.Q_DESCRIPTION.getDatabaseKey();
	
	private static String C = DatabaseColumns.CO2.getDatabaseKey();
	private static String P = DatabaseColumns.POPULATION.getDatabaseKey();
	
	
	public static final String CREATE_QUESTION_TABLE = String.format("CREATE TABLE %s (" +
			                                                                 "%s INTEGER PRIMARY KEY, " +
			                                                                 "%s TEXT NOT NULL, " +
			                                                                 "%s TEXT NOT NULL)",
			Q_TABLE_NAME, ID, Q_NAME, Q_DESCRIPTION);
	
	public static final String CREATE_ACCEPTANCE_TABLE = String.format("CREATE TABLE %s (" +
			                                                                   "%s INTEGER NOT NULL, " +
			                                                                   "%s INTEGER NOT NULL DEFAULT 0, " +
			                                                                   "%s INTEGER NOT NULL DEFAULT 0, " +
			                                                                   "FOREIGN KEY(%s) REFERENCES %s(%s))",
			A_TABLE_NAME, ID, C, P, ID, Q_TABLE_NAME, ID);
	
	public static final String CREATE_DECLINATION_TABLE = String.format("CREATE TABLE %s (" +
			                                                                    "%s INTEGER NOT NULL, " +
			                                                                    "%s INTEGER NOT NULL DEFAULT 0, " +
			                                                                    "%s INTEGER NOT NULL DEFAULT 0, " +
			                                                                    "FOREIGN KEY(%s) REFERENCES %s(%s))",
			D_TABLE_NAME, ID, C, P, ID, Q_TABLE_NAME, ID);
	
	
}
