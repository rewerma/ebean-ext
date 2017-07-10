package io.ebean.ext.spring;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class EbeanServerFactoryBean implements InitializingBean, FactoryBean<EbeanServer> {
    private ServerConfig serverConfig;
    private EbeanServer ebeanServer;

    public EbeanServerFactoryBean() {
    }

    public void afterPropertiesSet() throws Exception {
        if(this.serverConfig == null) {
            throw new Exception("No ServerConig set. You must define a ServerConfig bean");
        } else {
            this.ebeanServer = EbeanServerFactory.create(this.serverConfig);
        }
    }

    public EbeanServer getObject() throws Exception {
        return this.ebeanServer;
    }

    public Class<? extends EbeanServer> getObjectType() {
        return EbeanServer.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public ServerConfig getServerConfig() {
        return this.serverConfig;
    }

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
}