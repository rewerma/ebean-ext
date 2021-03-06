package io.ebean.ext;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.bean.EntityBean;
import io.ebean.ext.support.SN;
import io.ebean.typequery.TQProperty;
import org.apache.commons.beanutils.PropertyUtils;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class Model extends io.ebean.Model {
    protected String _server() {
        EbeanService ebeanService = this.getClass().getAnnotation(EbeanService.class);
        return ebeanService == null ? null : ebeanService.value();
    }

    public static <T> String _server(Class<T> type) {
        EbeanService ebeanService = type.getAnnotation(EbeanService.class);
        return ebeanService == null ? null : ebeanService.value();
    }

    public static <T> EbeanServer _ebeanServer(Class<T> type) {
        EbeanService ebeanService = type.getAnnotation(EbeanService.class);
        if (ebeanService == null || ebeanService.value().equals("") || ebeanService.value().equals("ebeanServer")) {
            return Ebean.getDefaultServer();
        } else {
            return Ebean.getServer(ebeanService.value());
        }
    }

    public void init() {
    }

    @Override
    public void save() {
        Object obj = this;
        if (obj instanceof EntityBean && !((EntityBean) obj)._ebean_getIntercept().isLoaded()) {
            init();
        }
        String server = _server();
        if (server == null) {
            super.save();
        } else {
            db(server).save(this);
        }
    }

    @Override
    public void insert() {
        init();
        String server = _server();
        if (server == null) {
            super.insert();
        } else {
            super.insert(server);
        }
    }

    @Override
    public void update() {
        String server = _server();
        if (server == null) {
            super.update();
        } else {
            super.update(server);
        }
    }

    @Override
    public boolean delete() {
        String server = _server();
        if (server == null) {
            return super.delete();
        } else {
            return super.delete(server);
        }
    }

    @Override
    public void update(String property) {
        this.update(new String[]{property});
    }

    public void update(String... properties) {
        try {
            EbeanServer ebeanServer;
            String server = _server();
            if (server == null) {
                ebeanServer = Ebean.getDefaultServer();
            } else {
                ebeanServer = Ebean.getServer(server);
            }
            Object id = ebeanServer.getBeanId(this);
            Object model = ebeanServer.createQuery(this.getClass()).where().idEq(id).findUnique();
            for (String property : properties) {
                if (property.startsWith("sn:")) {
                    property = property.substring(3);
                    Object val = PropertyUtils.getProperty(this, property);
                    if (val != null) {
                        PropertyUtils.setProperty(model, property, val);
                    }
                } else {
                    Object val = PropertyUtils.getProperty(this, property);
                    PropertyUtils.setProperty(model, property, val);
                }
            }
            ebeanServer.update(model);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void saveOrUpdate() {
        EbeanServer ebeanServer;
        String server = _server();
        if (server == null) {
            ebeanServer = Ebean.getDefaultServer();
        } else {
            ebeanServer = Ebean.getServer(server);
        }
        Object id = ebeanServer.getBeanId(this);
        if (id == null) {
            insert();
        } else {
            update();
        }
    }

    public void saveOrUpdate(String... properties) {
        EbeanServer ebeanServer;
        String server = _server();
        if (server == null) {
            ebeanServer = Ebean.getDefaultServer();
        } else {
            ebeanServer = Ebean.getServer(server);
        }
        Object id = ebeanServer.getBeanId(this);
        if (id == null) {
            insert();
        } else {
            update(properties);
        }
    }

    public void update(TQProperty... properties) {
        update(makeStrProperties(properties));
    }

    public void saveOrUpdate(TQProperty... properties) {
        saveOrUpdate(makeStrProperties(properties));
    }

    private static String[] makeStrProperties(TQProperty[] properties) {
        String[] proertiesStr = new String[properties.length];
        int i = 0;
        for (TQProperty property : properties) {
            if (property instanceof SN) {
                SN sn = (SN) property;
                proertiesStr[i++] = "sn:" + sn.getProperty().toString();
            } else {
                proertiesStr[i++] = property.toString();
            }
        }
        return proertiesStr;
    }
}
