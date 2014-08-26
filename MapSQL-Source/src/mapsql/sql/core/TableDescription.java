package mapsql.sql.core;

import java.util.Arrays;

import mapsql.sql.condition.Equals;

public class TableDescription {
	private String name;
	private Field[] fields;

	public TableDescription(String name, Field[] fields) {
		this.name = name;
		this.fields = fields;
	}

	public String name() {
		return name;
	}

	public Field findField(String name) {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].name().equals(name))
				return fields[i];
		}
		return null;
	}

	/**
	 * This method resolves an array of columns into the actual column headings
	 * to be returned (i.e. * is resolved to all the column names). If an
	 * invalid column name is given, then this method will throw an
	 * SQLException.
	 * 
	 * @param columns
	 * @return
	 * @throws SQLException
	 */
	public String[] resolveColumns(String[] columns) throws SQLException {
		String[] cols;
		if (columns.length == 1 && columns[0].equals("*")) {
			cols = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				cols[i] = fields[i].name();
			}
		} else {
			cols = new String[columns.length];
			for (int i = 0; i < columns.length; i++) {
				Field field = findField(columns[i]);
				if (field == null)
					throw new SQLException("Unknown field '" + columns[i]
							+ "' in table: '" + name + "'");
				cols[i] = columns[i];
			}
		}
		return cols;
	}

	public Field[] fields() {
		return fields;
	}

	/**
	 * Checks that no columns marked "not null" have been missed.
	 * 
	 * @param cols
	 * @throws SQLException
	 */
	public void checkForNotNulls(String[] cols) throws SQLException {
		Field[] actualFields = fields();
		boolean isNecessary = false;
		for (int i = 0; i < actualFields.length; i++) {
			System.out.println("Is "
					+ actualFields[i].name()
					+ " not null? "
					+ ((actualFields[i].isNotNull() || actualFields[i]
							.isAutoIncrement()) ? (isNecessary = true)
							: (isNecessary = false)));
		}

		boolean isMissing = false;
		// System.out.println(cols.length);
		for (int i = 0; i < actualFields.length; i++) {
			// System.out.println("actual field is " + actualFields[i].name());
			isMissing = true;
			if ((actualFields[i].isAutoIncrement())) {
				// System.out.println("I continued bc I'm AI");
				continue;
			}
			for (int j = 0; j < cols.length; j++) {
				// System.out.println("passed field is " + cols[j]);

				if ((cols[j].equalsIgnoreCase(actualFields[i].name()) && actualFields[i]
						.isNotNull())) {
					// System.out.println("Im a necessary field and im present");
					isMissing = false;
					break;
				}

				if (!(cols[j].equalsIgnoreCase(actualFields[i].name()))
						&& actualFields[i].isNotNull()) {
					// System.out.println("Col name is" + cols[j]);
					// System.out.println("Actual name is" +
					// actualFields[i].name());
					// System.out.println(isMissing);
					for (int m = 0; m < cols.length; m++) {
						if (actualFields[i].name().equals(cols[m])) {
							isMissing = false;
							// System.out.println(isMissing);
							break;
						}

					}
					if (isMissing) {

						throw new SQLException(
								"Missing VALUE for NOT NULL field "
										+ actualFields[i].name());

					}

				}

			}
		}

		if (cols.length == 0) {
			for (int l = 0; l < actualFields.length; l++) {
				if (actualFields[l].isNotNull()) {

					throw new SQLException("Missing VALUE for NOT NULL fields ");
				}
			}

		}
	}
}
