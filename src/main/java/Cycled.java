import java.util.Iterator;

public final class Cycled<X> extends IterableEnvelope<X>{
    public Cycled(Iterable<X> iterable) {
        super(
                new Iterable<X>() {
                    @Override
                    public Iterator<X> iterator() {
                        return new Iterator<X>() {
                            @Override
                            public boolean hasNext() {
                                return false;
                            }

                            @Override
                            public X next() {
                                return null;
                            }
                        };
                    }
                }
        );
    }
}