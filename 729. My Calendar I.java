class MyCalendar {
    private List<int[]> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for (int[] booking : bookings) {
            int bookedStart = booking[0];
            int bookedEnd = booking[1];
            if (!(end <= bookedStart || start >= bookedEnd)) {
                return false;
            }
        }
        bookings.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
