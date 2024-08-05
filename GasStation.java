public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;      //total gas for entire trip
        int currentTank = 0;    //current gas from the current starting point
        int startingIndex = 0;  //potential starting station index
        
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            
            if (currentTank < 0) {
                startingIndex = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? startingIndex : -1;
    }
}
