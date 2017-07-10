package io.ebean.ext.support;

import io.ebean.typequery.TQProperty;

/**
 * 非空参数包裹类
 */
public class NonNull<R> extends TQProperty<R> {
    private TQProperty<R> property;

    public NonNull(TQProperty<R> property) {
        super(null,null);
        this.property = property;
    }

    public TQProperty getProperty() {
        return property;
    }

    public static <R> NonNull<R> set(TQProperty<R> property){
        return new NonNull<R>(property);
    }
}
