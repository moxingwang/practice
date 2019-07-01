package top.moxingwang.demo.other.pecs;

/**
 * Plate
 */
public class Plate<T> {
    private T item;

    public Plate() {
    }

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Plate item(T item) {
        this.item = item;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " item='" + getItem() + "'" + "}";
    }

}