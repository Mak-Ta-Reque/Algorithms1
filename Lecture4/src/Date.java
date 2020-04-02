// Build a immutable data type
public final class Date implements Comparable<Date> {
    private final int day;
    private final int year;
    private final int month;
    
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;       
    }
    
    public boolean equals(Object y) {
        if(this == y) return true;
        if(y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Date that = (Date) y;
        if(this.year != that.year) return false;
        if (this.month != that.month) return false;
        if (this.day != that.day) return false;
        return true;
                
        
    }

    @Override
    public int compareTo(Date y) {
        if(y == null) throw new IllegalArgumentException();
        if (y.getClass() != this.getClass()) throw new IllegalArgumentException() ;
        if(this == y) return 0;
        Date that = y;
        if(this.year > that.year) return +1;
        if (this.month > that.month) return +1;
        if (this.day > that.day) return +1;
        if (this.year < that.year) return -1;
        if (this.month < that.month) return -1;
        if (this.day < that.day) return -1;
        return 0;
    }


}
