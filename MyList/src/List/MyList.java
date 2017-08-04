package List;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by dima on 01.08.2017.
 */
public class MyList<E> implements ListMethods<E> {

    private Node<E> firstNode;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public MyList() {
        firstNode = new Node<>(null, null, null);
    }


    @Override
    public void pushElem(E element) {
        Node<E> newNode = firstNode;
        newNode.setCurrent(element);
        firstNode = new Node<>(null, newNode, null);
        newNode.setPrevios(firstNode);
        size++;

    }

    @Override
    public void removeElem(int numberElem) {
        Node<E> neededNode = null;
        Node<E> newNode = firstNode;
        if (numberElem > size) {                                 //проверка на существоания такого
            System.out.println("Такого элемента нет");           //элемента в списке
        } else {
            for (int index = 0; index < numberElem; index++) {   //Поиска нужного узла
                neededNode = newNode.getNext();
                newNode = neededNode;

            }
            Node<E> prevElem = neededNode.getPrevios();          //  переопределение и проверка
            Node<E> nextElem = neededNode.getNext();             //  на последний узел
            if (neededNode.getNext() != null) {
                prevElem.setNext(neededNode.getNext());
                nextElem.setPrevios(neededNode.getPrevios());
            } else {
                prevElem.setNext(null);
            }

           /* neededNode.setCurrent(null);
            neededNode.setPrevios(null);
            neededNode.setNext(null);*/
            size--;
        }


    }

    @Override
    public void setElem(int numberElem, E element) {
        Node<E> neededNode = null;
        Node<E> newNode = firstNode;
        if (numberElem > size) {                                 //проверка на существоания такого
            System.out.println("Такого элемента нет");           //элемента в списке
        } else {
            for (int index = 0; index < numberElem; index++) {   //Поиска нужного узла
                neededNode = newNode.getNext();
                newNode = neededNode;
            }
            neededNode.setCurrent(element);                      //переопределение значения нужного узла
        }

    }

    @Override
    public void getElem(int numberElem) {
        Node<E> neededNode = null;
        Node<E> newNode = firstNode;
        if (numberElem > size) {                                 //проверка на существоания такого
            System.out.println("Такого элемента нет");           //элемента в списке
        } else {
            for (int index = 0; index < numberElem; index++) {   //Поиска нужного узла
                neededNode = newNode.getNext();
                newNode = neededNode;
            }

        }
        System.out.println("current Element " + neededNode.getCurrent());
        System.out.println("previos Element " + neededNode.getPrevios().getCurrent());
        System.out.println("next Element " +  neededNode.getNext());
    }
    public class Node<E> {
        private E current;
        private Node<E> next;
        private Node<E> previos;

        public Node(E current, Node<E> next, Node<E> previos) {
            this.current = current;
            this.next = next;
            this.previos = previos;
        }

        public E getCurrent() {
            return current;
        }

        public void setCurrent(E current) {
            this.current = current;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevios() {
            return previos;
        }

        public void setPrevios(Node<E> previos) {
            this.previos = previos;
        }
    }


}

