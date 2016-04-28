package robot;

import static robot.Direction.*;

public class MapTools {
	 static Coordinates nextForwardPosition(Coordinates position, Direction direction) {
		 if (direction == NORTH)
	            return new Coordinates(position.getX(), position.getY() + 1);
	        if (direction == SOUTH)
	            return new Coordinates(position.getX(), position.getY() - 1);
	        if (direction == EAST)
	            return new Coordinates(position.getX() + 1, position.getY());
                //correction default option for direction == WEST 
	        //return new Coordinates(position.getX() + 1, position.getY());
                return new Coordinates(position.getX() - 1, position.getY());
	    }

	 static Coordinates nextBackwardPosition(Coordinates position, Direction direction) {
		 if (direction == NORTH)
	            return new Coordinates(position.getX(), position.getY() - 1);
	        if (direction == SOUTH)
	            return new Coordinates(position.getX(), position.getY() + 1);
	        if (direction == EAST)
	            return new Coordinates(position.getX() - 1, position.getY());
	        return new Coordinates(position.getX() + 1, position.getY());
	    }

	    static Direction counterclockwise(Direction direction) {
                //mission if direction = EAST return NORTH (default return)
	        if (direction == NORTH) return WEST;
	        if (direction == WEST) return SOUTH;
	        if (direction == SOUTH) return EAST;
	        //return SOUTH;
                return NORTH;
	    }

	    static Direction clockwise(Direction direction) {
	        if (direction == NORTH) return EAST;
	        if (direction == EAST) return SOUTH;
                //clockwise south -> west and not east
	        //if (direction == SOUTH) return EAST;
                if (direction == SOUTH) return WEST;
	        return NORTH;
	    }
}
