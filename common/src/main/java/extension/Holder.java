package extension;

/**
 * @author quincy
 * @create 2023 - 05 - 05 19:04
 */
public class Holder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
