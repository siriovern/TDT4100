package objectstructures;

public class SudokuCell {
	private int y;
	private int x;
	private char value;
	private boolean isPredefined;
	private boolean isConflict;

	// konstruktør for sudokuCell-klassen
	public SudokuCell(int x, int y, char value, boolean isPredefined) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.isPredefined = isPredefined;
	}

	// returnerer true hvis cellen inneholder '.'
	public boolean isCellEmpty() {
		return (value == '.');
	}

	// returnerer true hvis tallet er en del av det opprinnelige brettet
	public boolean isPredefined() {
		return isPredefined;
	}

	// returnerer true hvis cellen er i konflikt
	public boolean isConflict() {
		return isConflict;
	}

	public void setConflict(boolean isConflict) {
		this.isConflict = isConflict;
	}

	public String toString(){
		if (isPredefined && !isCellEmpty()){
			return "(" +value+ ")";
		}else if (isConflict() && !isCellEmpty()){
			return " "+value+"*";
		}else {
			return " "+value+" ";
		}
	}
	public int getX(){
		return x;
	}
	public int getY() {
		return y;
	}
	public char getValue(){
		return value;
	}
}
