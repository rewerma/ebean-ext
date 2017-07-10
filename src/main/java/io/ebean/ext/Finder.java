package io.ebean.ext;


public class Finder<I, T> extends io.ebean.Finder<I, T> {
    public Finder(Class<T> type) {
        super(type);
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

    public static void main(String[] args) {
        new Finder<Long, Object>(Object.class).query().where().and().ignEq("pro", 1).endAnd();
    }
}
