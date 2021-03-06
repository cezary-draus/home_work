import java.util.*;

public class RangeSet implements Set<Integer> {


    private static Set<Range> ranges = new HashSet<>();
    private static Set<Integer> integerSet = new HashSet<>();

    public void addRange(int from, int to) {
        Range newRange = new Range(from, to);
        if (ranges.size() == 0) {
            ranges.add(newRange);
        }
        for (Range range : ranges) {

            if (range.contains(from) & !(range.contains(to))) {
                range.changeEnd(to);
            }
        }
        for (Range range : ranges) {
            if (range.getStart() == to) {
                range.changeStart(from);
            }
        }
        for (Range range : ranges) {
            if (range.getEnd() == from) {
                range.changeStart(to);
            }
        }
        for (Range range : ranges) {
            if (!(range.contains(from)) & (range.contains(to))) {
                range.changeStart(from);

            }
        }

        for (Range range : ranges) {
            int i = 0;
            if (!(range.contains(from) & range.contains(to))) {
                i++;

            }
            if (i == ranges.size()) {
                ranges.add(newRange);

            }
        }
    }

    @Override
    public int size() {
        int i = 0;
        for (Range range : ranges) {
            i++;
        }

        return i;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        ArrayList<Integer> integerList = new ArrayList<>(integerSet);
        Collections.sort(integerList);

        for (Range range : ranges) {
            if (range.getStart() <= (int) o && (int) o <= range.getEnd()) {
                return true;
            }
        }

        for (int j = 0; j < integerList.size(); j++) {
            if (integerList.get(j) == (int) o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        integerSet.add(integer);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (Range range : ranges) {
            if (range.contains((int) o)) {
                ranges.add(new Range((int) o + 1, range.getEnd()));
                range.changeEnd((int) o - 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

}
