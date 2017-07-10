package io.ebean.ext;


import io.ebean.OrderBy;
import io.ebean.ext.querydefn.ExtOrmQuery;
import io.ebean.typequery.TQProperty;

import java.io.Serializable;

public final class ExtOrderBy<T> implements Serializable {

    private static final long serialVersionUID = 4237564406351609761L;

    private OrderBy<T> orderBy;

    public ExtOrderBy(OrderBy<T> orderBy) {
        this.orderBy = orderBy;
    }

    public ExtOrmQuery<T> asc(String propertyName) {
        return new ExtOrmQuery<T>(orderBy.asc(propertyName));
    }

    public ExtOrmQuery<T> desc(String propertyName) {
        return new ExtOrmQuery<T>(orderBy.desc(propertyName));
    }

    public ExtOrmQuery<T> asc(TQProperty propertyName) {
        return this.asc(propertyName.toString());
    }

    public ExtOrmQuery<T> desc(TQProperty propertyName) {
        return this.desc(propertyName.toString());
    }

    public ExtOrderBy<T> copy() {
        return new ExtOrderBy<T>(orderBy.copy());
    }
}
