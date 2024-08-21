public class RobotBoundedInCircle {
    /**
     After following directions if robot is not facing north, it is bound to return to original
     G- moving in given direction
     robot starts at x=0, y=0 facing north
     Clockwise
     // dirs N E S W
     //{0,1}, {1,0}, {0,-1},{-1,0}
     take var i set to 0.


     given the above list,
     north - index 0, left -index 1, south index2, west index 3.
     if i =0 and moving right it would be east and i+1. from east right turn = i+1.
     So Right turn = i+1;
     if standing in south as per above array it will run out of bounds. so to limit the range 0-3, we do %4.
     R = (i+1)%4
     L = from north to west. which is index 3 in above array
     L = (i+3) %4
     Iterate over string.
     i is for directions. from given coordinates using i iterate over directions.
     above is array for directions.
     Everytimr we have G take  i's coordinates and add  to it.
     for left and right use formulas
     TIme - o(n)
     space = o(1)

     // Anti clockwise
     // NWSE
     logic change
     L = i+1) % 4
     R = i+3 ) % 4

     */
    public boolean isRobotBounded(String instructions) {

        if (instructions == null || instructions.length() == 0) {
            return true;
        }
        int [][] directions = {{0,1},{1,0},{0,-1}, {-1,0}}; // N, E, S. W
        // x, y coordinates
        int x = 0;
        int y = 0;
        int i=0;
        // robot is facing north so i=0 as north isin 0 index

        for(int j=0; j< instructions.length(); j++){
            char c = instructions.charAt(j);
            if(c == 'G'){
                x= x+ directions[i][0];
                y= y+ directions[i][1];
            }else if(c == 'L'){
                i = (i+3) %4;
            }else if (c== 'R'){
                i = (i+1) %4;
            }
        }
        return (x==0 && y ==0) || (i!=0);
    }

    // Anti clockwise

    public boolean isRobotBounded2(String instructions) {

        if (instructions == null || instructions.length() == 0) {
            return true;
        }
        int [][] directions = {{0,1},{-1,0},{0,-1}, {1,0}}; // N, E, S. W
        // x, y coordinates
        int x = 0;
        int y = 0;
        int i=0;
        // robot is facing north so i=0 as north isin 0 index

        for(int j=0; j< instructions.length(); j++){
            char c = instructions.charAt(j);
            if(c == 'G'){
                x= x+ directions[i][0];
                y= y+ directions[i][1];
            }else if(c == 'L'){
                i = (i+1) %4;
            }else if (c== 'R'){
                i = (i+3) %4;
            }
        }
        return (x==0 && y ==0) || (i!=0);
    }
}
