package io.ebean.ext.support;

import io.ebean.typequery.TQProperty;

/**
 * 非空参数包裹类: Skip null
 */
public class SN<R> extends TQProperty<R> {
    private TQProperty<R> property;

    public SN(TQProperty<R> property) {
        super(null,null);
        this.property = property;
    }

    public TQProperty getProperty() {
        return property;
    }

    public static <R> SN<R> set(TQProperty<R> property){
        return new SN<R>(property);
    }
}
