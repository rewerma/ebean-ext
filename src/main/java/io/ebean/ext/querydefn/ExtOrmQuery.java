package io.ebean.ext.querydefn;


import io.ebean.*;
import io.ebean.bean.CallStack;
import io.ebean.bean.ObjectGraphNode;
import io.ebean.bean.PersistenceContext;
import io.ebean.event.BeanQueryRequest;
import io.ebean.event.readaudit.ReadEvent;
import io.ebean.ext.expression.ExtExpressionList;
import io.ebean.plugin.BeanType;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQProperty;
import io.ebeaninternal.api.*;
import io.ebeaninternal.server.autotune.ProfilingListener;
import io.ebeaninternal.server.deploy.BeanDescriptor;
import io.ebeaninternal.server.deploy.BeanPropertyAssocMany;
import io.ebeaninternal.server.deploy.TableJoin;
import io.ebeaninternal.server.query.CancelableQuery;
import io.ebeaninternal.server.querydefn.DefaultOrmQuery;
import io.ebeaninternal.server.querydefn.NaturalKeyBindParam;
import io.ebeaninternal.server.querydefn.OrmQueryDetail;
import io.ebeaninternal.server.querydefn.OrmUpdateProperties;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExtOrmQuery<T> implements SpiQuery<T> {
    private DefaultOrmQuery<T> defaultOrmQuery;
    private ExtExpressionList<T> textExpressions;
    private ExtExpressionList<T> whereExpressions;
    private ExtExpressionList<T> havingExpressions;

    public ExtOrmQuery(Query<T> defaultOrmQuery) {
        this.defaultOrmQuery = (DefaultOrmQuery<T>) defaultOrmQuery;
    }

    @Override
    public void checkIdEqualTo() {
        defaultOrmQuery.checkIdEqualTo();
    }

    @Override
    public boolean isAutoTunable() {
        return defaultOrmQuery.isAutoTunable();
    }

    @Override
    public boolean isNativeSql() {
        return defaultOrmQuery.isNativeSql();
    }

    @Override
    public String getNativeSql() {
        return defaultOrmQuery.getNativeSql();
    }

    @Override
    public ForUpdate getForUpdateMode() {
        return defaultOrmQuery.getForUpdateMode();
    }

    @Override
    public ExtOrmQuery<T> alias(String s) {
        defaultOrmQuery.alias(s);
        return this;
    }

    @Override
    public Class<T> getBeanType() {
        return defaultOrmQuery.getBeanType();
    }

    @Override
    public ExtOrmQuery<T> setDisableLazyLoading(boolean b) {
        defaultOrmQuery.setDisableLazyLoading(b);
        return this;
    }

    @Override
    public Set<String> validate() {
        return defaultOrmQuery.validate();
    }

    @Override
    public BeanDescriptor<T> getBeanDescriptor() {
        return defaultOrmQuery.getBeanDescriptor();
    }

    @Override
    public boolean isUseDocStore() {
        return defaultOrmQuery.isUseDocStore();
    }

    @Override
    public String getDocIndexName() {
        return defaultOrmQuery.getDocIndexName();
    }

    @Override
    public PersistenceContextScope getPersistenceContextScope() {
        return defaultOrmQuery.getPersistenceContextScope();
    }

    @Override
    public String getOriginKey() {
        return defaultOrmQuery.getOriginKey();
    }

    @Override
    public int getLazyLoadBatchSize() {
        return defaultOrmQuery.getLazyLoadBatchSize();
    }

    @Override
    public boolean selectAllForLazyLoadProperty() {
        return defaultOrmQuery.selectAllForLazyLoadProperty();
    }

    @Override
    public void setMode(Mode mode) {
        defaultOrmQuery.setMode(mode);
    }

    @Override
    public Mode getMode() {
        return defaultOrmQuery.getMode();
    }

    @Override
    public TemporalMode getTemporalMode() {
        return defaultOrmQuery.getTemporalMode();
    }

    @Override
    public boolean isVersionsBetween() {
        return defaultOrmQuery.isVersionsBetween();
    }

    @Override
    public Timestamp getVersionStart() {
        return defaultOrmQuery.getVersionStart();
    }

    @Override
    public Timestamp getVersionEnd() {
        return defaultOrmQuery.getVersionEnd();
    }

    @Override
    public boolean isAsOfQuery() {
        return defaultOrmQuery.isAsOfQuery();
    }

    @Override
    public boolean isAsDraft() {
        return defaultOrmQuery.isAsDraft();
    }

    @Override
    public boolean isIncludeSoftDeletes() {
        return defaultOrmQuery.isIncludeSoftDeletes();
    }

    @Override
    public Timestamp getAsOf() {
        return defaultOrmQuery.getAsOf();
    }

    @Override
    public boolean isAsOfBaseTable() {
        return defaultOrmQuery.isAsOfBaseTable();
    }

    @Override
    public void setAsOfBaseTable() {
        defaultOrmQuery.setAsOfBaseTable();
    }

    @Override
    public void incrementAsOfTableCount() {
        defaultOrmQuery.incrementAsOfTableCount();
    }

    @Override
    public int getAsOfTableCount() {
        return defaultOrmQuery.getAsOfTableCount();
    }

    @Override
    public void addSoftDeletePredicate(String s) {
        defaultOrmQuery.addSoftDeletePredicate(s);
    }

    @Override
    public List<String> getSoftDeletePredicates() {
        return defaultOrmQuery.getSoftDeletePredicates();
    }

    @Override
    public RawSql getRawSql() {
        return defaultOrmQuery.getRawSql();
    }

    @Override
    public ExtOrmQuery<T> setRawSql(RawSql rawSql) {
        defaultOrmQuery.setRawSql(rawSql);
        return this;
    }

    @Override
    public ExtOrmQuery<T> asOf(Timestamp timestamp) {
        defaultOrmQuery.asOf(timestamp);
        return this;
    }

    @Override
    public ExtOrmQuery<T> asDraft() {
        defaultOrmQuery.asDraft();
        return this;
    }

    @Override
    public void cancel() {
        defaultOrmQuery.cancel();
    }

    @Override
    public ExtOrmQuery<T> copy() {
        return new ExtOrmQuery<T>(defaultOrmQuery.copy());
    }

    @Override
    public ExtOrmQuery<T> setPersistenceContextScope(PersistenceContextScope persistenceContextScope) {
        defaultOrmQuery.setPersistenceContextScope(persistenceContextScope);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setDocIndexName(String s) {
        defaultOrmQuery.setDocIndexName(s);
        return this;
    }

    @Override
    public ExpressionFactory getExpressionFactory() {
        return defaultOrmQuery.getExpressionFactory();
    }

    @Override
    public boolean isAutoTuned() {
        return defaultOrmQuery.isAutoTuned();
    }

    @Override
    public ExtOrmQuery<T> setAutoTune(boolean b) {
        defaultOrmQuery.setAutoTune(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setLazyLoadBatchSize(int i) {
        defaultOrmQuery.setLazyLoadBatchSize(i);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setIncludeSoftDeletes() {
        defaultOrmQuery.setIncludeSoftDeletes();
        return this;
    }

    @Override
    public ExtOrmQuery<T> setDisableReadAuditing() {
        defaultOrmQuery.setDisableReadAuditing();
        return this;
    }

    @Override
    public ExtOrmQuery<T> select(String s) {
        defaultOrmQuery.select(s);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetch(String s, String s1) {
        defaultOrmQuery = defaultOrmQuery.fetch(s, s1);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetchQuery(String s, String s1) {
        defaultOrmQuery = (DefaultOrmQuery<T>) defaultOrmQuery.fetchQuery(s, s1);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetchLazy(String s, String s1) {
        defaultOrmQuery = (DefaultOrmQuery<T>) defaultOrmQuery.fetchLazy(s, s1);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetch(String s, String s1, FetchConfig fetchConfig) {
        defaultOrmQuery = defaultOrmQuery.fetch(s, s1, fetchConfig);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetch(String s) {
        defaultOrmQuery = defaultOrmQuery.fetch(s);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetchQuery(String s) {
        defaultOrmQuery = (DefaultOrmQuery<T>) defaultOrmQuery.fetchQuery(s);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetchLazy(String s) {
        defaultOrmQuery = (DefaultOrmQuery<T>) defaultOrmQuery.fetchLazy(s);
        return this;
    }

    @Override
    public ExtOrmQuery<T> fetch(String s, FetchConfig fetchConfig) {
        defaultOrmQuery = defaultOrmQuery.fetch(s, fetchConfig);
        return this;
    }

    @Override
    public ExtOrmQuery<T> apply(FetchPath fetchPath) {
        defaultOrmQuery.apply(fetchPath);
        return this;
    }

    @Override
    public <A> List<A> findIds() {
        return defaultOrmQuery.findIds();
    }

    @Override
    public QueryIterator<T> findIterate() {
        return defaultOrmQuery.findIterate();
    }

    @Override
    public void findEach(Consumer<T> consumer) {
        defaultOrmQuery.findEach(consumer);
    }

    @Override
    public void findEachWhile(Predicate<T> predicate) {
        defaultOrmQuery.findEachWhile(predicate);
    }

    @Override
    public List<T> findList() {
        return defaultOrmQuery.findList();
    }

    @Override
    public Set<T> findSet() {
        return defaultOrmQuery.findSet();
    }

    @Override
    public <K> Map<K, T> findMap() {
        return defaultOrmQuery.findMap();
    }

    @Override
    public <A> List<A> findSingleAttributeList() {
        return defaultOrmQuery.findSingleAttributeList();
    }

    @Override
    @Nullable
    public T findOne() {
        return defaultOrmQuery.findOne();
    }

    @Override
    public Optional<T> findOneOrEmpty() {
        return defaultOrmQuery.findOneOrEmpty();
    }

    @Override
    @Nullable
    public T findUnique() {
        return defaultOrmQuery.findUnique();
    }

    @Override
    public List<Version<T>> findVersions() {
        return defaultOrmQuery.findVersions();
    }

    @Override
    public List<Version<T>> findVersionsBetween(Timestamp timestamp, Timestamp timestamp1) {
        return defaultOrmQuery.findVersionsBetween(timestamp, timestamp1);
    }

    @Override
    public int delete() {
        return defaultOrmQuery.delete();
    }

    @Override
    public int update() {
        return defaultOrmQuery.update();
    }

    @Override
    public int findCount() {
        return defaultOrmQuery.findCount();
    }

    @Override
    public FutureRowCount<T> findFutureCount() {
        return defaultOrmQuery.findFutureCount();
    }

    @Override
    public FutureIds<T> findFutureIds() {
        return defaultOrmQuery.findFutureIds();
    }

    @Override
    public FutureList<T> findFutureList() {
        return defaultOrmQuery.findFutureList();
    }

    @Override
    public PagedList<T> findPagedList() {
        return defaultOrmQuery.findPagedList();
    }

    @Override
    public ExtOrmQuery<T> setParameter(String s, Object o) {
        defaultOrmQuery.setParameter(s, o);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setParameter(int i, Object o) {
        defaultOrmQuery.setParameter(i, o);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setId(Object o) {
        defaultOrmQuery.setId(o);
        return this;
    }

    @Override
    public Object getId() {
        return defaultOrmQuery.getId();
    }

    @Override
    public ExtOrmQuery<T> where(Expression expression) {
        defaultOrmQuery.where(expression);
        return this;
    }

    @Override
    public ExtExpressionList<T> where() {
        if (whereExpressions == null) {
            whereExpressions = new ExtExpressionList<T>(this, defaultOrmQuery.where());
        }
        return whereExpressions;
    }

    @Override
    public ExtExpressionList<T> text() {
        if (textExpressions == null) {
            textExpressions = new ExtExpressionList<T>(this, defaultOrmQuery.text());
        }
        return textExpressions;
    }

    @Override
    public ExtExpressionList<T> filterMany(String s) {
        return new ExtExpressionList<T>(this, defaultOrmQuery.filterMany(s));
    }

    @Override
    public ExtExpressionList<T> having() {
        if (havingExpressions == null) {
            havingExpressions = new ExtExpressionList<T>(this, defaultOrmQuery.having());
        }
        return havingExpressions;
    }

    @Override
    public ExtOrmQuery<T> having(Expression expression) {
        defaultOrmQuery.having(expression);
        return this;
    }

    @Override
    public ExtOrmQuery<T> orderBy(String s) {
        defaultOrmQuery.orderBy(s);
        return this;
    }

    @Override
    public ExtOrmQuery<T> order(String s) {
        defaultOrmQuery.order(s);
        return this;
    }

    //FIXME `OrderBy` is a final class, how to operation it
    @Override
    public OrderBy<T> order() {
        return defaultOrmQuery.order();
    }

    @Override
    public OrderBy<T> orderBy() {
        return defaultOrmQuery.orderBy();
    }

    @Override
    public ExtOrmQuery<T> setOrder(OrderBy<T> orderBy) {
        defaultOrmQuery.setOrder(orderBy);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setOrderBy(OrderBy<T> orderBy) {
        defaultOrmQuery.setOrderBy(orderBy);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setDistinct(boolean b) {
        defaultOrmQuery.setDistinct(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> copy(EbeanServer ebeanServer) {
        return new ExtOrmQuery<T>(defaultOrmQuery.copy(ebeanServer));
    }

    @Override
    public Type getType() {
        return defaultOrmQuery.getType();
    }

    @Override
    public void setType(Type type) {
        defaultOrmQuery.setType(type);
    }

    @Override
    public String getLoadDescription() {
        return defaultOrmQuery.getLoadDescription();
    }

    @Override
    public String getLoadMode() {
        return defaultOrmQuery.getLoadMode();
    }

    @Override
    public void setLazyLoadForParents(BeanPropertyAssocMany<?> beanPropertyAssocMany) {
        defaultOrmQuery.setLazyLoadForParents(beanPropertyAssocMany);
    }

    @Override
    public BeanPropertyAssocMany<?> getLazyLoadMany() {
        return defaultOrmQuery.getLazyLoadMany();
    }

    @Override
    public void setLoadDescription(String s, String s1) {
        defaultOrmQuery.setLoadDescription(s, s1);
    }

    @Override
    public void checkNamedParameters() {
        defaultOrmQuery.checkNamedParameters();
    }

    @Override
    public SpiNamedParam createNamedParameter(String s) {
        return defaultOrmQuery.createNamedParameter(s);
    }

    @Override
    public ManyWhereJoins getManyWhereJoins() {
        return defaultOrmQuery.getManyWhereJoins();
    }

    @Override
    public NaturalKeyBindParam getNaturalKeyBindParam() {
        return defaultOrmQuery.getNaturalKeyBindParam();
    }

    @Override
    public void prepareDocNested() {
        defaultOrmQuery.prepareDocNested();
    }

    @Override
    public void setDelete() {
        defaultOrmQuery.setDelete();
    }

    @Override
    public void setSelectId() {
        defaultOrmQuery.setSelectId();
    }

    @Override
    public void setSingleAttribute() {
        defaultOrmQuery.setSingleAttribute();
    }

    @Override
    public boolean isSingleAttribute() {
        return defaultOrmQuery.isSingleAttribute();
    }

    @Override
    public boolean isWithId() {
        return defaultOrmQuery.isWithId();
    }

    @Override
    public void setFilterMany(String s, ExpressionList<?> expressionList) {
        defaultOrmQuery.setFilterMany(s, expressionList);
    }

    @Override
    public void setTenantId(Object o) {
        defaultOrmQuery.setTenantId(o);
    }

    @Override
    public Object getTenantId() {
        return defaultOrmQuery.getTenantId();
    }

    @Override
    public void setLazyLoadManyPath(String s) {
        defaultOrmQuery.setLazyLoadManyPath(s);
    }

    @Override
    public SpiQuerySecondary convertJoins() {
        return defaultOrmQuery.convertJoins();
    }

    @Override
    public PersistenceContext getPersistenceContext() {
        return defaultOrmQuery.getPersistenceContext();
    }

    @Override
    public void setPersistenceContext(PersistenceContext persistenceContext) {
        defaultOrmQuery.setPersistenceContext(persistenceContext);
    }

    @Override
    public boolean isDetailEmpty() {
        return defaultOrmQuery.isDetailEmpty();
    }

    @Override
    public Boolean isAutoTune() {
        return defaultOrmQuery.isAutoTune();
    }

    @Override
    public void setLogSecondaryQuery(boolean b) {
        defaultOrmQuery.setLogSecondaryQuery(b);
    }

    @Override
    public boolean isLogSecondaryQuery() {
        return defaultOrmQuery.isLogSecondaryQuery();
    }

    @Override
    public List<SpiQuery<?>> getLoggedSecondaryQueries() {
        return defaultOrmQuery.getLoggedSecondaryQueries();
    }

    @Override
    public void logSecondaryQuery(SpiQuery<?> spiQuery) {
        defaultOrmQuery.logSecondaryQuery(spiQuery);
    }

    @Override
    public ProfilingListener getProfilingListener() {
        return defaultOrmQuery.getProfilingListener();
    }

    @Override
    public void setProfilingListener(ProfilingListener profilingListener) {
        defaultOrmQuery.setProfilingListener(profilingListener);
    }

    @Override
    public ObjectGraphNode setOrigin(CallStack callStack) {
        return defaultOrmQuery.setOrigin(callStack);
    }

    @Override
    public void setParentNode(ObjectGraphNode objectGraphNode) {
        defaultOrmQuery.setParentNode(objectGraphNode);
    }

    @Override
    public void setLazyLoadProperty(String s) {
        defaultOrmQuery.setLazyLoadProperty(s);
    }

    @Override
    public String getLazyLoadProperty() {
        return defaultOrmQuery.getLazyLoadProperty();
    }

    @Override
    public ObjectGraphNode getParentNode() {
        return defaultOrmQuery.getParentNode();
    }

    @Override
    public boolean isUsageProfiling() {
        return defaultOrmQuery.isUsageProfiling();
    }

    @Override
    public void setUsageProfiling(boolean b) {
        defaultOrmQuery.setUsageProfiling(b);
    }

    @Override
    public CQueryPlanKey prepare(BeanQueryRequest<?> beanQueryRequest) {
        return defaultOrmQuery.prepare(beanQueryRequest);
    }

    @Override
    public int queryBindHash() {
        return defaultOrmQuery.queryBindHash();
    }

    @Override
    public HashQuery queryHash() {
        return defaultOrmQuery.queryHash();
    }

    @Override
    public boolean isRawSql() {
        return defaultOrmQuery.isRawSql();
    }

    @Override
    public OrderBy<T> getOrderBy() {
        return defaultOrmQuery.getOrderBy();
    }

    @Override
    public ExtExpressionList<T> getWhereExpressions() {
        return this.whereExpressions;
    }

    @Override
    public ExtExpressionList<T> getHavingExpressions() {
        return this.havingExpressions;
    }

    @Override
    public ExtExpressionList<T> getTextExpression() {
        return this.textExpressions;
    }

    @Override
    public boolean hasMaxRowsOrFirstRow() {
        return defaultOrmQuery.hasMaxRowsOrFirstRow();
    }

    @Override
    public boolean isExcludeBeanCache() {
        return defaultOrmQuery.isExcludeBeanCache();
    }

    @Override
    public boolean isUseBeanCache() {
        return defaultOrmQuery.isUseBeanCache();
    }

    @Override
    public boolean isUseQueryCache() {
        return defaultOrmQuery.isUseQueryCache();
    }

    @Override
    public boolean isLoadBeanCache() {
        return defaultOrmQuery.isLoadBeanCache();
    }

    @Override
    public Boolean isReadOnly() {
        return defaultOrmQuery.isReadOnly();
    }

    @Override
    public int getTimeout() {
        return defaultOrmQuery.getTimeout();
    }

    @Override
    public BindParams getBindParams() {
        return defaultOrmQuery.getBindParams();
    }

    @Override
    public void setDetail(OrmQueryDetail ormQueryDetail) {
        defaultOrmQuery.setDetail(ormQueryDetail);
    }

    @Override
    public boolean tuneFetchProperties(OrmQueryDetail ormQueryDetail) {
        return defaultOrmQuery.tuneFetchProperties(ormQueryDetail);
    }

    @Override
    public void setDefaultRawSqlIfRequired() {
        defaultOrmQuery.setDefaultRawSqlIfRequired();
    }

    @Override
    public void setAutoTuned(boolean b) {
        defaultOrmQuery.setAutoTuned(b);
    }

    @Override
    public OrmQueryDetail getDetail() {
        return defaultOrmQuery.getDetail();
    }

    @Override
    public TableJoin getM2mIncludeJoin() {
        return defaultOrmQuery.getM2mIncludeJoin();
    }

    @Override
    public void setM2MIncludeJoin(TableJoin tableJoin) {
        defaultOrmQuery.setM2MIncludeJoin(tableJoin);
    }

    @Override
    public String getMapKey() {
        return defaultOrmQuery.getMapKey();
    }

    @Override
    public int getMaxRows() {
        return defaultOrmQuery.getMaxRows();
    }

    @Override
    public ExtOrmQuery<T> setMaxRows(int i) {
        defaultOrmQuery.setMaxRows(i);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setMapKey(String s) {
        defaultOrmQuery.setMapKey(s);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setUseCache(boolean b) {
        defaultOrmQuery.setUseCache(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setUseQueryCache(boolean b) {
        defaultOrmQuery.setUseQueryCache(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setUseDocStore(boolean b) {
        defaultOrmQuery.setUseDocStore(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setReadOnly(boolean b) {
        defaultOrmQuery.setReadOnly(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setLoadBeanCache(boolean b) {
        defaultOrmQuery.setLoadBeanCache(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setTimeout(int i) {
        defaultOrmQuery.setTimeout(i);
        return this;
    }

    @Override
    public ExtOrmQuery<T> setBufferFetchSizeHint(int i) {
        defaultOrmQuery.setBufferFetchSizeHint(i);
        return this;
    }

    @Override
    public String getGeneratedSql() {
        return defaultOrmQuery.getGeneratedSql();
    }

    @Override
    public ExtOrmQuery<T> setForUpdate(boolean b) {
        defaultOrmQuery.setForUpdate(b);
        return this;
    }

    @Override
    public ExtOrmQuery<T> forUpdate() {
        defaultOrmQuery.forUpdate();
        return this;
    }

    @Override
    public ExtOrmQuery<T> forUpdateNoWait() {
        defaultOrmQuery.forUpdateNoWait();
        return this;
    }

    @Override
    public ExtOrmQuery<T> forUpdateSkipLocked() {
        defaultOrmQuery.forUpdateSkipLocked();
        return this;
    }

    @Override
    public boolean isForUpdate() {
        return defaultOrmQuery.isForUpdate();
    }

    @Override
    public int getFirstRow() {
        return defaultOrmQuery.getFirstRow();
    }

    @Override
    public ExtOrmQuery<T> setFirstRow(int i) {
        defaultOrmQuery.setFirstRow(i);
        return this;
    }

    @Override
    public boolean isDisableLazyLoading() {
        return defaultOrmQuery.isDisableLazyLoading();
    }

    @Override
    public void setSqlDistinct(boolean b) {
        defaultOrmQuery.setSqlDistinct(b);
    }

    @Override
    public boolean isDistinctQuery() {
        return defaultOrmQuery.isDistinctQuery();
    }

    @Override
    public boolean isSqlDistinct() {
        return defaultOrmQuery.isSqlDistinct();
    }

    @Override
    public boolean isDistinct() {
        return defaultOrmQuery.isDistinct();
    }

    @Override
    public void setDefaultSelectClause() {
        defaultOrmQuery.setDefaultSelectClause();
    }

    @Override
    public void setGeneratedSql(String s) {
        defaultOrmQuery.setGeneratedSql(s);
    }

    @Override
    public void setDefaultFetchBuffer(int i) {
        defaultOrmQuery.setDefaultFetchBuffer(i);
    }

    @Override
    public int getBufferFetchSizeHint() {
        return defaultOrmQuery.getBufferFetchSizeHint();
    }

    @Override
    public boolean isDisableReadAudit() {
        return defaultOrmQuery.isDisableReadAudit();
    }

    @Override
    public boolean isFutureFetch() {
        return defaultOrmQuery.isFutureFetch();
    }

    @Override
    public void setFutureFetch(boolean b) {
        defaultOrmQuery.setFutureFetch(b);
    }

    @Override
    public void setFutureFetchAudit(ReadEvent readEvent) {
        defaultOrmQuery.setFutureFetchAudit(readEvent);
    }

    @Override
    public ReadEvent getFutureFetchAudit() {
        return defaultOrmQuery.getFutureFetchAudit();
    }

    @Override
    public void setCancelableQuery(CancelableQuery cancelableQuery) {
        defaultOrmQuery.setCancelableQuery(cancelableQuery);
    }

    @Override
    public boolean isCancelled() {
        return defaultOrmQuery.isCancelled();
    }

    @Override
    public String getAlias() {
        return defaultOrmQuery.getAlias();
    }

    @Override
    public Set<String> validate(BeanType<T> beanType) {
        return defaultOrmQuery.validate(beanType);
    }

    @Override
    public OrmUpdateProperties getUpdateProperties() {
        return defaultOrmQuery.getUpdateProperties();
    }

    @Override
    public void simplifyExpressions() {
        defaultOrmQuery.simplifyExpressions();
    }

    private static String getBeanName(TQAssocBean path) {
        try {
            Field privateStringField = TQAssocBean.class.getDeclaredField("_name");
            privateStringField.setAccessible(true);
            return (String) privateStringField.get(path);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException();
        }
    }

    //------------------------- extend -------------------------

    public ExtOrmQuery<T> select(TQProperty... fetchProperties) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (TQProperty property : fetchProperties) {
            if (i++ != 0) {
                sb.append(",");
            }
            sb.append(property.toString());
        }
        defaultOrmQuery.select(sb.toString());
        return this;
    }

    public ExtOrmQuery<T> fetch(TQAssocBean path) {
        return this.fetch(getBeanName(path));
    }

    public ExtOrmQuery<T> fetch(TQAssocBean path, FetchConfig fetchConfig) {
        return this.fetch(getBeanName(path),fetchConfig);
    }

    public ExtOrmQuery<T> fetch(TQAssocBean path, TQProperty... fetchProperties) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (TQProperty property : fetchProperties) {
            if (i++ != 0) {
                sb.append(",");
            }
            sb.append(property.toString());
        }
        defaultOrmQuery.fetch(getBeanName(path), sb.toString());
        return this;
    }

    public ExtOrmQuery<T> fetch(TQAssocBean assocProperty, FetchConfig fetchConfig, TQProperty... fetchProperties) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (TQProperty property : fetchProperties) {
            if (i++ != 0) {
                sb.append(",");
            }
            sb.append(property.toString());
        }
        defaultOrmQuery.fetch(assocProperty.toString(), sb.toString(), fetchConfig);
        return this;
    }
}
