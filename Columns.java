public enum Columns {
	A('A', 1), B('B', 2), C('C', 3), 
	D('D', 4), E('E', 5), F('F', 6),
	G('G', 7), H('H', 8);
	
	private final char column;
	private final int index;
	
	private Columns(char column, int index) {
		this.column = column;
		this.index = index;
	}
	
	public char getColumn() {
		return this.column;
	}
	public int getIndex() {
		return this.index;
	}
	
	public boolean inColumns(char column) {
		column = Character.toUpperCase(column);
		for(Columns columns : Columns.values()) {
			if(columns == Columns.valueOf(String.valueOf(column).toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public static Columns fromChar(char column) {
		column = Character.toUpperCase(column);
		for (Columns c : Columns.values()) {
			if (c.getColumn() == column) {
				return c;
			}
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		String columns = "";
		for(Columns column : Columns.values()) {
			if(column != H) {
				columns += column.getColumn() + ", ";
			}
			else {
				columns += column.getColumn();
			}
		}
		return columns;
	}
}
