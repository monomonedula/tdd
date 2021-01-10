import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public final class Cycled<X> extends IterableEnvelope<X>{
    public Cycled(Iterable<X> iterable) {
        super(
                () -> new CycledIterator<>(iterable.iterator())
        );
    }
}

class CycledIterator<X> implements Iterator<X> {
    final List<X> copy = new LinkedList<X>();
    final Iterator<X> origin;
    Iterator<X> current = null;

    public CycledIterator(Iterator<X> origin) {
        this.origin = origin;
    }

    @Override
    public boolean hasNext() {
        return this.origin.hasNext() || this.copy.size() > 0;
    }

    @Override
    public X next() {
        try {
            X next = this.origin.next();
            this.copy.add(next);
            return next;
        } catch (NoSuchElementException e) {
            if (this.current == null || !this.current.hasNext())
                this.current = this.copy.iterator();
            return this.current.next();
        }
    }
}