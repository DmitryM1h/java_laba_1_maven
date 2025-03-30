package org.example;

/**
 *Класс container поддерживает хранение произвольного числа элементов типа int.
 *Создан на основе массива, поддерживает изменение размера массива
 * @version 1.0
 */
class Container{
    /** Поле с массивом, в котором хранятся элементы*/
    private int[] A;

    /** Поле с количеством элементов в контейнере*/
    private int size = 0;

    /** Поле c размером массива*/
    private int capacity;

    /**
     *Конструктор по умолчанию с изначальной вместимостью 50
     */
    public Container(){
        this.capacity = 50;
        A = new int[capacity];
    }
    /**
     *Констуктор с параметром capacity
     * @param capacity изначальный размер массива
     * @throws IllegalArgumentException если введенная capacity < 1
     */
    public Container(int capacity){
        if (capacity < 1)
            throw new IllegalArgumentException("capacity must be at least 1");
        this.capacity = capacity;
        A = new int[capacity];
    }

    /**
     *Метод add добавляет элемент в конец контейнера.
     * Если массив заполнен - увеличивает его размер
     * @param element элемент
     */
    void add(int element){
        A[size] = element;
        ++size;
        if (size==capacity)
            resize();
    }
    /**
     Метод resize создает новый массив с удвоенной вместимостью
     */
    void resize(){
        this.capacity = 2 * this.capacity;
        int[] A = new int[this.capacity];
        System.arraycopy(this.A, 0, A, 0, size);
        this.A = A;
    }

    /**
     Метод get_element возвращает элемент контейнера по указанному индексу
     * @param ind индекс элемента, к которому мы хотим обратиться
     * @throws IndexOutOfBoundsException если указанный индекс за пределами контейнера
     * @return элемент контейнера с указанным индексом
     */
    int get_element(int ind){
        if (ind >= size)
            throw new IndexOutOfBoundsException("Out of array's bounds");

        return A[ind];
    }

    /**
     *Метод get_capacity возвращает размер массива
     * @return размер массива
     */
    int get_capacity() {return this.capacity;}

    /**
     *Метод get_size возвращает число элементов в контейнере
     * @return количество элементов в контейнере
     */
    int get_size() {return this.size;}

    /**
     *Метод delete удаляет элемент контейнера по указанному индексу
     * @param ind индекс удаляемого элемента
     * @throws IndexOutOfBoundsException если введенный индекс за пределами контейнера
     */
    void delete(int ind){
        if (ind < 0 || ind >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");
        for(int i=ind;i<size-1;i++)
            A[i] = A[i+1];
        --size;
    }
    /**
     *Метод toString возвращает всю информацию о контейнере
     * @return информация об объекте
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        if (size==0)
            str.append("empty");
        else
            for(int i=0;i<size;i++)
                str.append(Integer.toString(A[i])).append(" ");
        str.append("\nsize: ").append(Integer.toString(size)).append("\n");
        str.append("capacity: ").append(Integer.toString(capacity));
        return str.toString();
    }

}
