package mapsql.sql.condition;

import java.util.Map;

import mapsql.sql.core.Field;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.TableDescription;
import mapsql.sql.field.CHARACTER;

public class Like extends AbstractCondition {
	private String column;
	private String value;
	
	public Like(String column, String value) {
		this.column = column;
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	/* Method completed by student (Noreen A. Lenihan) */
	public boolean evaluate(TableDescription description, Map<String, String> data) throws SQLException {
		Field field = description.findField(column);
		boolean result = false;
		
		// Case when wildcard operator is at start of string
		if ((value.charAt(0) == ('%')) && !(value.charAt(value.length() - 1) == '%')){
			result = ((String) field.toValue(data.get(column))).toLowerCase().endsWith(((String)field.toValue(value)).substring(1).toLowerCase());
			//System.out.println(result);
		}
		
		// Case when wildcard operator is at end of string
		if (value.charAt(value.length() - 1) == '%' && !((value.charAt(0) == ('%')))){
			result = ((String) field.toValue(data.get(column))).toLowerCase().startsWith(((String)field.toValue(value)).substring(0, value.length()-1).toLowerCase());
			//System.out.println(result);
		}
		
		// Case when wildcard operator is at start and end of string
		if ((value.charAt(0) == ('%')) && (value.charAt(value.length() -1) == '%')) {
			result = ((String) field.toValue(data.get(column))).toLowerCase().contains(((String)field.toValue(value)).substring(1,value.length() -1).toLowerCase());
			//System.out.println(result);
		}
		
		return result;
	}
}
