package mapsql.sql.command;

import mapsql.shell.core.SQLVisitor;
import mapsql.shell.parser.MapSQL;
import mapsql.shell.parser.ParseException;
import mapsql.shell.parser.SimpleNode;
import mapsql.sql.core.SQLCommand;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.SQLManager;
import mapsql.sql.core.SQLOperation;
import mapsql.util.List;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sources implements SQLCommand { 
	private String filename;

	public Sources(String filename) {
		this.filename = filename;
	}

	@Override
	/* Method completed by student to use Sources command */
	/* Note: Method tested using the Shell (Shell.java) command line interface using test.sql as sample file */
	public String execute(SQLManager manager) throws SQLException, IOException {
		manager = new SQLManager();
		Scanner scanner = new Scanner(new FileInputStream(filename));
		

		while (scanner.hasNextLine()) {
			
			String sql = scanner.nextLine();
			
			try {
				SimpleNode n = new MapSQL(new ByteArrayInputStream(sql.getBytes() ) ).Start();

				List<SQLOperation> operations = (List<SQLOperation>) n.jjtAccept(new SQLVisitor(), null);
				for (SQLOperation operation : operations) {
					System.out.println(manager.execute(operation));
				}
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return "";
	
	}
}
