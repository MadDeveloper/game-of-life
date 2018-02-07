
public class Game {
	Grid grid;
	int iterations;
	int gridSize;
	
	public Game(int size) {
		this.gridSize = size;
		this.grid = new Grid(this.gridSize);
	}
	
	public void numberOfIterations(int iterations) {
		this.iterations = iterations;
	}
	
	public void start() {
		System.out.println("Generation 0");
		this.grid.display();
		
		for (int i = 0; i < this.iterations; i++) {
			System.out.println("Generation " + (i + 1));
			this.iterate();
			this.grid.display();
		}
	}
	
	public void applyNextGeneration() {
		for	(int x = 0; x < this.gridSize; x++) {
			for	(int y = 0; y < this.gridSize; y++) {
				Cell cell = this.grid.getCell(x, y);
				cell.applyNextGeneration();
			}
		}
	}
	
	public void iterate() {
		for	(int x = 0; x < this.gridSize; x++) {
			for	(int y = 0; y < this.gridSize; y++) {
				Cell cell = this.grid.getCell(x, y);
				int neighbours = this.numberOfNeighbours(x, y);
				
				this.deathOrLife(cell, neighbours);
			}
		}
		
		this.applyNextGeneration();
	}
	
	public void deathOrLife(Cell cell, int neighbours) {
		if (cell.alive()) {
			if (neighbours < 2 || neighbours > 3) {
				cell.isAliveAtNextGeneration(false);
			} else if (neighbours >= 2 && neighbours <= 3) {
				cell.isAliveAtNextGeneration(true);
			}
		} else if (neighbours == 3) {
			cell.isAliveAtNextGeneration(true);
		}
	}
	
	public int numberOfNeighbours(int x, int y) {
		int neighbours = 0;
		
		AngleType angleType = this.grid.angleType(x, y);
		LineType lineType = this.grid.lineType(x, y);
		
		if (lineType != LineType.NONE) {
			if (angleType != AngleType.NONE) {
				neighbours = this.neightboursByAngle(angleType);
			} else {
				neighbours = this.neightboursByLine(lineType, x, y);
			}
		} else {
			neighbours = this.neightbours(x, y);
		}

		return neighbours;
	}
	
	public int neightboursByAngle(AngleType angleType) {
		int counter = 0;
		
		switch (angleType) {
		case TOP_LEFT:
			counter = this.grid.getRightCell(0, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomCenterCell(0, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomRightCell(0, 0).alive() ? counter + 1 : counter;
			break;

		case TOP_RIGHT:
			counter = this.grid.getLeftCell(0, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomLeftCell(0, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomCenterCell(0, this.gridSize - 1).alive() ? counter + 1 : counter;
			break;
			
		case BOTTOM_LEFT:
			counter = this.grid.getRightCell(this.gridSize - 1, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getTopRightCell(this.gridSize - 1, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getTopCenterCell(this.gridSize - 1, 0).alive() ? counter + 1 : counter;
			break;
			
		case BOTTOM_RIGHT:
			counter = this.grid.getTopCenterCell(this.gridSize - 1, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getTopLeftCell(this.gridSize - 1, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getLeftCell(this.gridSize - 1, this.gridSize - 1).alive() ? counter + 1 : counter;
			break;
			
		default:
			counter = 0;
			break;
		}
		
		return counter;
	}
	
	public int neightboursByLine(LineType lineType, int x, int y) {
		int counter = 0;
		
		switch (lineType) {
		case LEFT:
			counter = this.grid.getTopCenterCell(x, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getTopRightCell(x, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getRightCell(x, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomRightCell(x, 0).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomCenterCell(x, 0).alive() ? counter + 1 : counter;
			break;

		case RIGHT:
			counter = this.grid.getTopCenterCell(x, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getTopLeftCell(x, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getLeftCell(x, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomLeftCell(x, this.gridSize - 1).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomCenterCell(x, this.gridSize - 1).alive() ? counter + 1 : counter;
			break;
			
		case TOP:
			counter = this.grid.getLeftCell(0, y).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomLeftCell(0, y).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomCenterCell(0, y).alive() ? counter + 1 : counter;
			counter = this.grid.getBottomRightCell(0, y).alive() ? counter + 1 : counter;
			counter = this.grid.getRightCell(0, y).alive() ? counter + 1 : counter;
			break;
			
		case BOTTOM:
			counter = this.grid.getLeftCell(this.gridSize - 1, y).alive() ? counter + 1 : counter;
			counter = this.grid.getTopLeftCell(this.gridSize - 1, y).alive() ? counter + 1 : counter;
			counter = this.grid.getTopCenterCell(this.gridSize - 1, y).alive() ? counter + 1 : counter;
			counter = this.grid.getTopRightCell(this.gridSize - 1, y).alive() ? counter + 1 : counter;
			counter = this.grid.getRightCell(this.gridSize - 1, y).alive() ? counter + 1 : counter;
			break;
			
		default:
			counter = 0;
			break;
		}
		
		return counter;
	}
	
	public int neightbours(int x, int y) {
		int counter = 0;
		
		counter = this.grid.getTopLeftCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getTopCenterCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getTopRightCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getRightCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getBottomRightCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getBottomCenterCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getBottomLeftCell(x, y).alive() ? counter + 1 : counter;
		counter = this.grid.getLeftCell(x, y).alive() ? counter + 1 : counter;
		
		return counter;
	}
}
