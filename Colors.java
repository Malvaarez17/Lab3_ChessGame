
public enum Colors {
	BLACK("Black"), WHITE("White");
	
	private final String color;
	
	private Colors(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	@Override
	public String toString() {
		return BLACK.getColor() + " or " + WHITE.getColor();
	}
}

