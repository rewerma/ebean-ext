package io.ebean.ext.support;

import io.ebean.typequery.TQProperty;

/**
 * 非空参数包裹类
 */
public class SkipNull<R> extends TQProperty<R> {
    private TQProperty<R> property;

    public SkipNull(TQProperty<R> property) {
        super(null,null);
        this.property = property;
    }

    public TQProperty getProperty() {
        return property;
    }

    public static <R> SkipNull<R> set(TQProperty<R> property){
        return new SkipNull<R>(property);
    }
}
