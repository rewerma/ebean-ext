package io.ebean.ext;


import io.ebean.OrderBy;
import io.ebean.ext.querydefn.ExtOrmQuery;

import java.io.Serializable;

public class ExtOrderBy<T> implements Serializable {

    private static final long serialVersionUID = 4237564406351609761L;

    private ExtOrmQuery<T> query;

    private OrderBy<T> orderBy;

    public ExtOrderBy(ExtOrmQuery<T> query) {
        this.query = query;
    }

    public ExtOrderBy(OrderBy<T> orderBy) {
        this.orderBy = orderBy;
    }

    public ExtOrmQuery<T> asc(String propertyName) {
        if (query != null) {
            this.query.getOrderBy().asc(propertyName);
            return query;
        } else {
            return new ExtOrmQuery<T>(orderBy.asc(propertyName));
        }
    }

    public ExtOrmQuery<T> desc(String propertyName) {
        if (query != null) {
        this.query.getOrderBy().desc(propertyName);
        return query;} else {
            return new ExtOrmQuery<T>(orderBy.desc(propertyName));
        }
    }
}
