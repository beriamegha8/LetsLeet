import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> bookings; // Single bookings
    private List<int[]> overlaps; // Double bookings

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            int overlapStart = overlap[0];
            int overlapEnd = overlap[1];
            if (start < overlapEnd && end > overlapStart) {
                return false; // Triple booking detected, return false
            }
        }
        for (int[] booking : bookings) {
            int bookedStart = booking[0];
            int bookedEnd = booking[1];
            if (start < bookedEnd && end > bookedStart) {
                overlaps.add(new int[] {Math.max(start, bookedStart), Math.min(end, bookedEnd)});
            }
        }

        bookings.add(new int[] {start, end});
        return true;  // Successfully booked
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start, end);
 */
