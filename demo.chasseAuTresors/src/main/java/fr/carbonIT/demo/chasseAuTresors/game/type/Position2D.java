package fr.carbonIT.demo.chasseAuTresors.game.type;

public class Position2D {
	
	private Integer row;
	private Integer column;
	
	public Position2D(Integer row, Integer column) {
		super();
		this.row = row;
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}
	
}
