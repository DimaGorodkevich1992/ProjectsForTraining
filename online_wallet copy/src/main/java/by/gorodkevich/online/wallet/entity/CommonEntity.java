package by.gorodkevich.online.wallet.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CommonEntity {
    public abstract long getId();
    public abstract void setId(long id);

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        return isLongEquals(getId(), ( (CommonEntity) o ).getId());
    }

    public boolean isLongEquals(Long a, Long b) {
        return a == null ? b == null : a.equals(b);
    }
}
