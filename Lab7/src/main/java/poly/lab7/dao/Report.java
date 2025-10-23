package poly.lab7.dao;

import java.io.Serializable;

public interface Report {
    Serializable getGroup();
    Double getSum();
    Long getCount();
}