import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Cycled<X> extends IterableEnvelope<X>{
    public Cycled(Iterable<X> iterable) {
        super(
                new Iterable<X>() {

                    @Override
                    public Iterator<X> iterator() {
                        return new Iterator<X>() {
                            final List<X> copy = new LinkedList<X>();
                            final Iterator<X> origin = iterable.iterator();
                            Iterator<X> current = null;

                            @Override
                            public boolean hasNext() {
                                return this.origin.hasNext() || this.copy.size() > 0;
                            }

                            @Override
                            public X next() {
                                if (this.origin.hasNext()) {
                                    X next = this.origin.next();
                                    this.copy.add(next);
                                    return next;
                                }
                                if (this.current == null || !this.current.hasNext()) {
                                    this.current = this.copy.iterator();
                                }
                                return this.current.next();
                            }
                        };
                    }
                }
        );
    }
}