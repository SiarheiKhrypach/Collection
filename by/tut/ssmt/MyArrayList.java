package by.tut.ssmt;

public class MyArrayList {
    private Object[] arr;
     int filledSize;
    private int defaultSize = 10;

    public MyArrayList() {
        arr = new Object[defaultSize];
    }

    public void add(Object ob) {
        if (filledSize == defaultSize) {
            expand();
        }
        arr[filledSize++] = ob;
    }

    public void remove(int index) {
        indexCheck(index);
        Object[] newArr = new Object[filledSize];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, 0, (filledSize--) - index - 1);
        arr = newArr;
    }

    public void remove(Object ob) {
        for (int i = 0; i < filledSize; i++){
                if (arr[i].equals(ob)) {
                    remove(i);
                    i--;
            }
        }
    }

    public Object get(int index) {
        indexCheck(index);
        return arr[index];
    }

    public int size() {
        return filledSize;
    }

    public void trimToSize() {
        Object[] newArr = new Object[filledSize];
        System.arraycopy(arr, 0, newArr, 0, filledSize);
        arr = newArr;
        defaultSize = filledSize;
    }

    private void expand() {
        Object[] newArr = new Object[arr.length + 10];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        defaultSize+=10;
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= filledSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
             sb.append("[").append(arr[i].toString()).append("]");
        }
        return sb.toString();
    }
}
