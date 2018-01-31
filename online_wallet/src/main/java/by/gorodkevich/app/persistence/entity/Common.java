package by.gorodkevich.app.persistence.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Common {

    public abstract int getId();

    public abstract void setId(int id);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Common that = (Common) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return  (getId() ^ (getId() >>> 32));
    }

}
