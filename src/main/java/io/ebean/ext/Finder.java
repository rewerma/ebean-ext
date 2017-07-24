package io.ebean.ext;


import io.ebean.ext.querydefn.ExtOrmQuery;

public class Finder<I, T> extends io.ebean.Finder<I, T> {
    public Finder(Class<T> type) {
        super(type, Model._server(type));
    }

    public Finder(Class<T> type, String serverName) {
        super(type, serverName);
    }

    @Override
    public ExtOrmQuery<T> query() {
        return new ExtOrmQuery<T>(super.query());
    }

    @Override
    public ExtOrmQuery<T> nativeSql(String nativeSql) {
        return new ExtOrmQuery<T>(super.nativeSql(nativeSql));
    }

    @Override
    public ExtOrmQuery<T> query(String ormQuery) {
        return new ExtOrmQuery<T>(super.query(ormQuery));
    }
}
