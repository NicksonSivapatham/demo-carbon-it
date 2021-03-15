package fr.carbonIT.demo.chasseAuTresors.game.type;

public enum Orientation {
	NORD("N", 0),
	EST("E", 1),
	SUD("S", 2),
	OUEST("O", 3);
	
	String  direction;
	Integer order;
	
	
	public String getDirection() {
		return direction;
	}

	public Integer getOrder() {
		return order;
	}

	private Orientation(String direction, Integer order) {
		this.direction = direction;
		this.order = order;
	}
	
	public static Orientation fromString(String direction) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.direction.equalsIgnoreCase(direction)) {
                return orientation;
            }
        }
        return null;
    }
	
	public static Orientation fromOrder(Integer order) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.order.equals(order)) {
                return orientation;
            }
        }
        return null;
    }
}
