
public enum Pieces {
	KING("King"), QUEEN("Queen"), BISHOP("Bishop"), ROOK("Rook"), KNIGHT("Knight"), PAWN("Pawn");
	
	private final String name;
	
	Pieces(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String printPieces = "";
		for(Pieces piece : Pieces.values()) {
			
			if(piece != PAWN) {
				printPieces += piece.getName() + ", ";
			}
			else {
				printPieces += piece.getName();
			}
			
		}
		return printPieces;
	}
	
}

