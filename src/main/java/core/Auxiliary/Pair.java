package core.Auxiliary;

public class Pair<First, Second> {
    public First   first;
    public Second  second;

    public Pair(First first, Second second) {
        this.first  = first;
        this.second = second;
    }

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public static <First, Second> Pair<First, Second> makePair(First first, Second second) {
        return new Pair<First, Second>(first, second);
    }
}