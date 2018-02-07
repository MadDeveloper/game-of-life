
public class Grid {
	Cell[][] cells;
	int matrixSize;
	
	public Grid(int size) {
		this.matrixSize = size;
		this.init();
	}
	
	public void init() {
		this.cells = new Cell[this.matrixSize][this.matrixSize];
		
		for	(int i = 0; i < this.matrixSize; i++) {
			for	(int j = 0; j < this.matrixSize; j++) {
				this.cells[i][j] = new Cell();
			}
		}
	}
	
	public Cell getCell(int x, int y) {
		return this.cells[x][y];
	}
	
	public AngleType angleType(int x, int y) {
		if (x - 1 < 0 && y - 1 < 0) {
			return AngleType.TOP_LEFT;
		} else if (x - 1 < 0 && y + 1 == this.matrixSize) {
			return AngleType.TOP_RIGHT;
		} else if (x + 1 == this.matrixSize && y - 1 < 0) {
			return AngleType.BOTTOM_LEFT;
		} else if (x + 1 == this.matrixSize && y + 1 == this.matrixSize) {
			return AngleType.BOTTOM_RIGHT;
		} else {
			return AngleType.NONE;
		}
	}
	
	public LineType lineType(int x, int y) {
		if (x - 1 < 0) {
			return LineType.TOP;
		} else if (x + 1 == this.matrixSize) {
			return LineType.BOTTOM;
		} else if (y - 1 < 0) {
			return LineType.LEFT;
		} else if (y + 1 == this.matrixSize) {
			return LineType.RIGHT;
		} else {
			return LineType.NONE;
		}
	}
	
	public Cell getTopLeftCell(int x, int y) {
		return this.cells[x - 1][y - 1];
	}
	
	public Cell getTopCenterCell(int x, int y) {
		return this.cells[x - 1][y];
	}
	
	public Cell getTopRightCell(int x, int y) {
		return this.cells[x - 1][y + 1];
	}
	
	public Cell getLeftCell(int x, int y) {
		return this.cells[x][y - 1];
	}
	
	public Cell getRightCell(int x, int y) {
		return this.cells[x][y + 1];
	}
	
	public Cell getBottomLeftCell(int x, int y) {
		return this.cells[x + 1][y - 1];
	}
	
	public Cell getBottomCenterCell(int x, int y) {
		return this.cells[x + 1][y];
	}
	
	public Cell getBottomRightCell(int x, int y) {
		return this.cells[x + 1][y + 1];
	}
	
	public void display() {
		for	(int i = 0; i < this.matrixSize; i++) {
			if (0 == i) {
				System.out.println(String.format("%" + (4 * this.matrixSize) + "s", "").replace(' ', '-') + "-");
			}
			
			for	(int j = 0; j < this.matrixSize; j++) {
				if (0 == j) {
					System.out.print("|");
				}
				
				Cell cell = this.cells[i][j];
				
				System.out.print(cell.alive() ? " x " : "   ");
				System.out.print("|");
				
				if (this.matrixSize == j + 1) {
					System.out.print('\n');
				}
			}

			System.out.println(String.format("%" + (4 * this.matrixSize) + "s", "").replace(' ', '-') + "-");
		}
	}
}
