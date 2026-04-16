class DynamicArray {
    
    private int[] arr;
    private int size;
    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.size == this.arr.length) {
            this.resize();
        }
        this.arr[this.size++] = n;
    }

    public int popback() {
        int pop = this.arr[--this.size];
        return pop;
    }

    private void resize() {
        int[] newArr = new int[this.getCapacity() * 2];
        for (int i = 0; i < this.size; i++) newArr[i] = this.arr[i];
        this.arr = newArr;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.arr.length;
    }
}
