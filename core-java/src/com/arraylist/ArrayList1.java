package com.arraylist;

public class ArrayList1 {

    int defaultCapacity = 10;
    int listSize;
    private Object elements[];

    ArrayList1() {
        elements = new Object[defaultCapacity];
        listSize = 0;

    }

    public void increaseCapacity() {
        defaultCapacity = defaultCapacity + defaultCapacity << 1;

    }

    public void alterArrayList(Object[] elements, int capacity) {

        Object[] newElements = new Object[capacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
        ;
    }

    public void addElement(Object element) {
        if (listSize == defaultCapacity) {
            increaseCapacity();
            alterArrayList(elements, defaultCapacity);
        }
        elements[listSize++] = element;


    }

    Object getElement(int index) {
        if (listSize == 0 || index >= listSize) {
            System.out.println("some thing wrong ");
        }
        return elements[index];

    }

    String printArrayList() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < listSize; i++) {
            sb.append(elements[i]);
            if (i < listSize - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList1 arrayList = new ArrayList1();
        arrayList.addElement("0");
        arrayList.addElement("1");
        arrayList.addElement("2");
        arrayList.addElement("3");
        arrayList.addElement("4");
        arrayList.addElement("5");
        arrayList.addElement("6");
        arrayList.addElement("7");
        arrayList.addElement("8");
        arrayList.addElement("9");
        arrayList.addElement("10");
        System.out.println(arrayList.listSize);
        System.out.println(arrayList.getElement(10));
        System.out.println(arrayList.printArrayList());

    }
}
