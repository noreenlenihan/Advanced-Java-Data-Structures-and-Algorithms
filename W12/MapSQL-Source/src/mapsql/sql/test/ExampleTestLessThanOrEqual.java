package mapsql.sql.test;


import mapsql.sql.condition.Equals;
import mapsql.sql.condition.OrCondition;
import mapsql.sql.condition.LessThanOrEqual;
import mapsql.sql.core.Condition;
import mapsql.sql.core.Field;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.SQLManager;
import mapsql.sql.core.SQLResult;
import mapsql.sql.core.SQLStatement;
import mapsql.sql.field.CHARACTER;
import mapsql.sql.field.INTEGER;
import mapsql.sql.statement.CreateTable;
import mapsql.sql.statement.Delete;
import mapsql.sql.statement.DropTable;
import mapsql.sql.statement.Insert;
import mapsql.sql.statement.Select;
import mapsql.sql.statement.Update;
/* Test class to show working Less Than Or Equal condition */
public class ExampleTestLessThanOrEqual {
	static SQLManager manager = new SQLManager();
	
	public static void main(String[] args) {
		createTableStatement();

		showTables();
		insertData();
		selectTable();
		selectRowsWithLessThanOrEqual();

//		insertPartialData();
//		selectTable();
		
//		updateData();
//		updateOrData();
//		selectTable();

//		deleteData();
//		selectTable();
		
//		dropTable();
//		showTables();
	}

	private static void executeStatement(SQLStatement statement) {
		try {
			SQLResult result = manager.execute(statement);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTableStatement() {
		executeStatement(
				new CreateTable(
						"contact", 
						new Field[] {
								new INTEGER("id", true, false, true), 
								new CHARACTER("name", 30, false, true), 
								new CHARACTER("email", 30, false, false)
						}
				)
		);
	}
	
	public static void showTables() {
		executeStatement(new Select("mapsql.tables", new String[] { "*" }));
	}
	
	public static void selectTable() {
		executeStatement(new Select("contact", new String[] { "*" }));
	}
	
	public static void dropTable() {
		executeStatement(new DropTable("contact"));
	}
	
	public static void insertData() {
		executeStatement(
				new Insert(
						"contact", 
						new String[] {"name", "email"}, 
						new String[] {"Rem", "rem.collier@ucd.ie"}
				)
		);
		executeStatement(
				new Insert(
						"contact", 
						new String[] {"name", "email"}, 
						new String[] {"Rachel", "rachel.greene@ucd.ie"}
				)
		);
		
		executeStatement(
				new Insert(
						"contact", 
						new String[] {"name", "email"}, 
						new String[] {"Johnny", "johnny.depp@ucd.ie"}
				)
		);
	}

	public static void insertPartialData() {
		executeStatement(new Insert("contact", new String[] {"name"}, new String[] {"Henry"}));
	}

	public static void updateData() {
		executeStatement(
				new Update(
						"contact", 
						new String[] {"email"}, 
						new String[] {"henry.mcloughlin@ucd.ie"}, 
						new Equals("id", "2")
				)
		);
	}
	
	public static void updateOrData() {
		executeStatement(
				new Update(
						"contact", 
						new String[] {"email"}, 
						new String[] {"henry.mcloughlin@ucd.ie"}, 
						new OrCondition(
								new Equals("id", "1"), 
								new Equals("id", "2")
						)
				)
		);
	}
	
	public static void deleteData() {
		executeStatement(new Delete("contact", new Equals("id", "2")));
	}
	
	public static void selectTableWithColumns() {
		executeStatement(new Select("contact", new String[] { "id", "name" }));
	}
	
	/* Test method to test Less Than or Equal to condition */
	public static void selectRowsWithLessThanOrEqual(){
		executeStatement(new Select("contact", new String[] {"id", "name", "email"}, new LessThanOrEqual("id", "2")));
	}
}
