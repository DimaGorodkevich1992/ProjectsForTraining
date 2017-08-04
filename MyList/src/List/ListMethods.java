package List;

/**
 * Created by dima on 01.08.2017.
 */
public interface ListMethods<E> {
    void pushElem(E element);

    void removeElem(int numberElem);

    void setElem(int numberElem , E element);

    Object getElem(int numberElem);
}
