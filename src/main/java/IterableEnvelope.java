import java.util.Iterator;

public abstract class IterableEnvelope<X> implements Iterable<X> {

    private final Iterable<X> wrapped;

    public IterableEnvelope(final Iterable<X> iterable) {
        this.wrapped = iterable;
    }

    @Override
    public final Iterator<X> iterator() {
        return this.wrapped.iterator();
    }

    @Override
    public final boolean equals(final Object other) {
        return this.wrapped.equals(other);
    }

    @Override
    public final int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override
    public final String toString() {
        return this.wrapped.toString();
    }
}