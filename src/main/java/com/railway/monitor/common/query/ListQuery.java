package com.railway.monitor.common.query;

public interface ListQuery<T extends ListQuery<T>> extends Query<T> {

    T like(String key);

    Integer getLimit();

    Integer getOffset();
}
