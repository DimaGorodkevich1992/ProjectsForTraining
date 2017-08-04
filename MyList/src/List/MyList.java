package List;

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

    final Node<E> iter(int number) {
        Node<E> neededNode = null;
        Node<E> newNode = firstNode;
        if (number > size) {                                 //проверка на существоания такого
            System.out.println("Такого элемента нет");           //элемента в списке
        } else {
            for (int index = 0; index < number; index++) {   //Поиска нужного узла
                neededNode = newNode.next;
                newNode = neededNode;
            }
        }
        return neededNode;
    }

    @Override
    public void pushElem(E element) {
        Node<E> newNode = firstNode;                                    //добавление елемента в
        newNode.current = element;                                    //начало списка
        firstNode = new Node<>(null, newNode, null);
        newNode.previos = firstNode;
        size++;
    }

    @Override
    public void removeElem(int numberElem) {
        Node<E> neededNode = iter(numberElem);
        Node<E> prevElem = neededNode.previos;          //  переопределение и проверка
        Node<E> nextElem = neededNode.next;             //  на последний узел
        if (neededNode.next != null) {
            prevElem.next = neededNode.next;
            nextElem.previos = neededNode.previos;
        } else {
            prevElem.next = null;
        }
        size--;
    }

    @Override
    public void setElem(int numberElem, E element) {
        Node<E> neededNode = iter(numberElem);
        neededNode.current = element;                      //переопределение значения нужного узла
    }

    @Override
    public Object getElem(int numberElem) {
        Node<E> neededNode = iter(numberElem);
        return neededNode;
    }

    final class Node<E> {
        private E current;
        private Node<E> next;
        private Node<E> previos;

        public Node(E current, Node<E> next, Node<E> previos) {
            this.current = current;
            this.next = next;
            this.previos = previos;
        }
    }
}
