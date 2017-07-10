package io.ebean.ext.expression;

import io.ebean.*;
import io.ebean.event.BeanQueryRequest;
import io.ebean.ext.ExtOrderBy;
import io.ebean.ext.querydefn.ExtOrmQuery;
import io.ebean.search.*;
import io.ebean.typequery.*;
import io.ebeaninternal.api.*;
import io.ebeaninternal.server.deploy.BeanDescriptor;
import io.ebeaninternal.server.expression.DefaultExpressionList;
import io.ebeaninternal.server.expression.DocQueryContext;
import io.ebeaninternal.server.expression.ExtJunctionExpression;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExtExpressionList<T> implements SpiExpressionList<T> {
    private DefaultExpressionList<T> defaultExpressionList;
    private ExtOrmQuery<T> query;

    public ExtExpressionList(Query<T> query, ExpressionList<T> defaultExpressionList) {
        if (query instanceof ExtOrmQuery) {
            this.query = (ExtOrmQuery<T>) query;
        } else {
            this.query = new ExtOrmQuery<T>(query);
        }
        this.defaultExpressionList = (DefaultExpressionList<T>) defaultExpressionList;
    }

    @Override
    public ExtOrmQuery<T> query() {
        return query;
    }

    @Override
    public ExtOrmQuery<T> order(String s) {
        return this.query.order(s);
    }

    @Override
    public OrderBy<T> order() {
        return this.query.orderBy();
    }

    @Override
    public OrderBy<T> orderBy() {
        return this.query.orderBy();
    }

    @Override
    public ExtOrmQuery<T> orderBy(String s) {
        return this.query.orderBy(s);
    }

    @Override
    public ExtOrmQuery<T> setOrderBy(String s) {
        return this.query.order(s);
    }

    @Override
    public ExtOrmQuery<T> apply(FetchPath fetchPath) {
        return this.query.apply(fetchPath);
    }

    @Override
    public ExtOrmQuery<T> asOf(Timestamp timestamp) {
        return this.query.asOf(timestamp);
    }

    @Override
    public ExtOrmQuery<T> asDraft() {
        return this.query.asDraft();
    }

    @Override
    public ExtOrmQuery<T> forUpdate() {
        return this.query.forUpdate();
    }

    @Override
    public ExtOrmQuery<T> forUpdateNoWait() {
        return this.query.forUpdateNoWait();
    }

    @Override
    public ExtOrmQuery<T> forUpdateSkipLocked() {
        return this.query.forUpdateSkipLocked();
    }

    @Override
    public ExtOrmQuery<T> setIncludeSoftDeletes() {
        return this.query.setIncludeSoftDeletes();
    }

    @Override
    public int delete() {
        return this.query.delete();
    }

    @Override
    public int update() {
        return this.query.update();
    }

    @Override
    public QueryIterator<T> findIterate() {
        return this.query.findIterate();
    }

    @Override
    public void findEach(Consumer<T> consumer) {
        this.query.findEach(consumer);
    }

    @Override
    public void findEachWhile(Predicate<T> predicate) {
        this.query.findEachWhile(predicate);
    }

    @Override
    public List<T> findList() {
        return this.query.findList();
    }

    @Override
    public <A> List<A> findIds() {
        return this.query.findIds();
    }

    @Override
    public int findCount() {
        return this.query.findCount();
    }

    @Override
    public Set<T> findSet() {
        return this.query.findSet();
    }

    @Override
    public <K> Map<K, T> findMap() {
        return this.query.findMap();
    }

    @Override
    public <A> List<A> findSingleAttributeList() {
        return this.query.findSingleAttributeList();
    }

    @Nullable
    @Override
    public T findOne() {
        return this.query.findOne();
    }

    @Override
    public Optional<T> findOneOrEmpty() {
        return this.query.findOneOrEmpty();
    }

    @Nullable
    @Override
    public T findUnique() {
        return this.query.findUnique();
    }

    @Override
    public FutureRowCount<T> findFutureCount() {
        return this.query.findFutureCount();
    }

    @Override
    public FutureIds<T> findFutureIds() {
        return this.query.findFutureIds();
    }

    @Override
    public FutureList<T> findFutureList() {
        return this.query.findFutureList();
    }

    @Override
    public PagedList<T> findPagedList() {
        return this.query.findPagedList();
    }

    @Override
    public List<Version<T>> findVersions() {
        return this.query.findVersions();
    }

    @Override
    public List<Version<T>> findVersionsBetween(Timestamp timestamp, Timestamp timestamp1) {
        return this.query.findVersionsBetween(timestamp, timestamp1);
    }

    @Override
    public ExtExpressionList<T> filterMany(String s) {
        return this.query.filterMany(s);
    }

    @Override
    public ExtOrmQuery<T> select(String s) {
        return this.query.select(s);
    }

    @Override
    public ExtOrmQuery<T> setDistinct(boolean b) {
        return this.query.setDistinct(b);
    }

    @Override
    public ExtOrmQuery<T> setDocIndexName(String s) {
        return this.query.setDocIndexName(s);
    }

    @Override
    public ExtOrmQuery<T> setFirstRow(int i) {
        return this.query.setFirstRow(i);
    }

    @Override
    public ExtOrmQuery<T> setMaxRows(int i) {
        return this.query.setMaxRows(i);
    }

    @Override
    public ExtOrmQuery<T> setMapKey(String s) {
        return this.query.setMapKey(s);
    }

    @Override
    public ExtOrmQuery<T> setUseCache(boolean b) {
        return this.query.setUseCache(b);
    }

    @Override
    public ExtOrmQuery<T> setUseQueryCache(boolean b) {
        return this.query.setUseQueryCache(b);
    }

    @Override
    public ExtOrmQuery<T> setUseDocStore(boolean b) {
        return this.query.setUseDocStore(b);
    }

    @Override
    public ExtOrmQuery<T> setDisableLazyLoading(boolean b) {
        return this.query.setDisableLazyLoading(b);
    }

    @Override
    public ExtOrmQuery<T> setDisableReadAuditing() {
        return this.query.setDisableReadAuditing();
    }

    @Override
    public ExtExpressionList<T> having() {
        return this.query.having();
    }

    @Override
    public ExtExpressionList<T> where() {
        return this.query.where();
    }

    @Override
    public ExtExpressionList<T> jsonExists(String s, String s1) {
        defaultExpressionList = (DefaultExpressionList<T>) this.defaultExpressionList.jsonExists(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonNotExists(String s, String s1) {
        defaultExpressionList.jsonNotExists(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonEqualTo(String s, String s1, Object o) {
        defaultExpressionList.jsonEqualTo(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonNotEqualTo(String s, String s1, Object o) {
        defaultExpressionList.jsonNotEqualTo(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonGreaterThan(String s, String s1, Object o) {
        defaultExpressionList.jsonGreaterThan(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonGreaterOrEqual(String s, String s1, Object o) {
        defaultExpressionList.jsonGreaterOrEqual(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonLessThan(String s, String s1, Object o) {
        defaultExpressionList.jsonLessThan(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonLessOrEqualTo(String s, String s1, Object o) {
        defaultExpressionList.jsonLessOrEqualTo(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> jsonBetween(String s, String s1, Object o, Object o1) {
        defaultExpressionList.jsonBetween(s, s1, o, o1);
        return this;
    }

    @Override
    public ExtExpressionList<T> add(Expression expression) {
        defaultExpressionList.add(expression);
        return this;
    }

    @Override
    public ExtExpressionList<T> addAll(ExpressionList<T> expressionList) {
        defaultExpressionList.addAll(expressionList);
        return this;
    }

    @Override
    public ExtExpressionList<T> eq(String s, Object o) {
        defaultExpressionList.eq(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> ne(String s, Object o) {
        defaultExpressionList.ne(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> ieq(String s, String s1) {
        defaultExpressionList.ieq(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> between(String s, Object o, Object o1) {
        defaultExpressionList.between(s, o, o1);
        return this;
    }

    @Override
    public ExtExpressionList<T> betweenProperties(String s, String s1, Object o) {
        defaultExpressionList.betweenProperties(s, s1, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> gt(String s, Object o) {
        defaultExpressionList.gt(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> ge(String s, Object o) {
        defaultExpressionList.ne(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> lt(String s, Object o) {
        defaultExpressionList.lt(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> le(String s, Object o) {
        defaultExpressionList.le(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> isNull(String s) {
        defaultExpressionList.isNull(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> isNotNull(String s) {
        defaultExpressionList.isNotNull(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> exampleLike(Object o) {
        defaultExpressionList.exampleLike(o);
        return this;
    }

    @Override
    public ExtExpressionList<T> iexampleLike(Object o) {
        defaultExpressionList.iexampleLike(o);
        return this;
    }

    @Override
    public ExtExpressionList<T> like(String s, String s1) {
        defaultExpressionList.like(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> ilike(String s, String s1) {
        defaultExpressionList.ilike(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> startsWith(String s, String s1) {
        defaultExpressionList.startsWith(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> istartsWith(String s, String s1) {
        defaultExpressionList.istartsWith(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> endsWith(String s, String s1) {
        defaultExpressionList.endsWith(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> iendsWith(String s, String s1) {
        defaultExpressionList.iendsWith(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> contains(String s, String s1) {
        defaultExpressionList.contains(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> icontains(String s, String s1) {
        defaultExpressionList.icontains(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> in(String s, Query<?> query) {
        defaultExpressionList.in(s, query);
        return this;
    }

    @Override
    public ExtExpressionList<T> in(String s, Object... objects) {
        defaultExpressionList.in(s, objects);
        return this;
    }

    @Override
    public ExtExpressionList<T> in(String s, Collection<?> collection) {
        defaultExpressionList.in(s, collection);
        return this;
    }

    @Override
    public ExtExpressionList<T> notIn(String s, Object... objects) {
        defaultExpressionList.notIn(s, objects);
        return this;
    }

    @Override
    public ExtExpressionList<T> notIn(String s, Collection<?> collection) {
        defaultExpressionList.notIn(s, collection);
        return this;
    }

    @Override
    public ExtExpressionList<T> notIn(String s, Query<?> query) {
        defaultExpressionList.notIn(s, query);
        return this;
    }

    @Override
    public ExtExpressionList<T> isEmpty(String s) {
        defaultExpressionList.isEmpty(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> isNotEmpty(String s) {
        defaultExpressionList.isNotEmpty(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> exists(Query<?> query) {
        defaultExpressionList.exists(query);
        return this;
    }

    @Override
    public ExtExpressionList<T> notExists(Query<?> query) {
        defaultExpressionList.notExists(query);
        return this;
    }

    @Override
    public ExtExpressionList<T> idIn(Object... objects) {
        defaultExpressionList.idIn(objects);
        return this;
    }

    @Override
    public ExtExpressionList<T> idIn(List<?> list) {
        defaultExpressionList.idIn(list);
        return this;
    }

    @Override
    public ExtExpressionList<T> idEq(Object o) {
        defaultExpressionList.idEq(o);
        return this;
    }

    @Override
    public ExtExpressionList<T> allEq(Map<String, Object> map) {
        defaultExpressionList.allEq(map);
        return this;
    }

    @Override
    public ExtExpressionList<T> arrayContains(String s, Object... objects) {
        defaultExpressionList.arrayContains(s, objects);
        return this;
    }

    @Override
    public ExtExpressionList<T> arrayNotContains(String s, Object... objects) {
        defaultExpressionList.arrayNotContains(s, objects);
        return this;
    }

    @Override
    public ExtExpressionList<T> arrayIsEmpty(String s) {
        defaultExpressionList.arrayIsEmpty(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> arrayIsNotEmpty(String s) {
        defaultExpressionList.arrayIsNotEmpty(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> raw(String s, Object o) {
        defaultExpressionList.raw(s, o);
        return this;
    }

    @Override
    public ExtExpressionList<T> raw(String s, Object... objects) {
        defaultExpressionList.raw(s, objects);
        return this;
    }

    @Override
    public ExtExpressionList<T> raw(String s) {
        defaultExpressionList.raw(s);
        return this;
    }

    @Override
    public ExtExpressionList<T> match(String s, String s1) {
        defaultExpressionList.match(s, s1);
        return this;
    }

    @Override
    public ExtExpressionList<T> match(String s, String s1, Match match) {
        defaultExpressionList.match(s, s1, match);
        return this;
    }

    @Override
    public ExtExpressionList<T> multiMatch(String s, String... strings) {
        defaultExpressionList.multiMatch(s, strings);
        return this;
    }

    @Override
    public ExtExpressionList<T> multiMatch(String s, MultiMatch multiMatch) {
        defaultExpressionList.multiMatch(s, multiMatch);
        return this;
    }

    @Override
    public ExtExpressionList<T> textSimple(String s, TextSimple textSimple) {
        defaultExpressionList.textSimple(s, textSimple);
        return this;
    }

    @Override
    public ExtExpressionList<T> textQueryString(String s, TextQueryString textQueryString) {
        defaultExpressionList.textQueryString(s, textQueryString);
        return this;
    }

    @Override
    public ExtExpressionList<T> textCommonTerms(String s, TextCommonTerms textCommonTerms) {
        defaultExpressionList.textCommonTerms(s, textCommonTerms);
        return this;
    }

    @Override
    public ExtExpressionList<T> and(Expression expression, Expression expression1) {
        defaultExpressionList.and(expression, expression1);
        return this;
    }

    @Override
    public ExtExpressionList<T> or(Expression expression, Expression expression1) {
        defaultExpressionList.or(expression, expression1);
        return this;
    }

    @Override
    public ExtExpressionList<T> not(Expression expression) {
        defaultExpressionList.not(expression);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> and() {
        return new ExtJunctionExpression<T>(defaultExpressionList.and());
    }

    @Override
    public ExtJunctionExpression<T> or() {
        return new ExtJunctionExpression<T>(defaultExpressionList.or());
    }

    @Override
    public ExtJunctionExpression<T> not() {
        return new ExtJunctionExpression<T>(defaultExpressionList.not());
    }

    @Override
    public ExtJunctionExpression<T> conjunction() {
        return new ExtJunctionExpression<T>(defaultExpressionList.conjunction());
    }

    @Override
    public ExtJunctionExpression<T> disjunction() {
        return new ExtJunctionExpression<T>(defaultExpressionList.disjunction());
    }

    @Override
    public ExtJunctionExpression<T> must() {
        return new ExtJunctionExpression<T>(defaultExpressionList.must());
    }

    @Override
    public ExtJunctionExpression<T> should() {
        return new ExtJunctionExpression<T>(defaultExpressionList.should());
    }

    @Override
    public ExtJunctionExpression<T> mustNot() {
        return new ExtJunctionExpression<T>(defaultExpressionList.mustNot());
    }

    @Override
    public ExtExpressionList<T> endJunction() {
        return new ExtExpressionList<T>(this.query, defaultExpressionList.endJunction());
    }

    @Override
    public ExtExpressionList<T> endAnd() {
        return new ExtExpressionList<T>(this.query, defaultExpressionList.endAnd());
    }

    @Override
    public ExtExpressionList<T> endOr() {
        return new ExtExpressionList<T>(this.query, defaultExpressionList.endOr());
    }

    @Override
    public ExtExpressionList<T> endNot() {
        return new ExtExpressionList<T>(this.query, defaultExpressionList.endNot());
    }

    @Override
    public ExtJunctionExpression<T> toJunction() {
        return new ExtJunctionExpression<T>(defaultExpressionList.toJunction());
    }

    @Override
    public List<SpiExpression> getUnderlyingList() {
        return defaultExpressionList.getUnderlyingList();
    }

    @Override
    public SpiExpressionList<?> trimPath(int i) {
        return defaultExpressionList.trimPath(i);
    }

    @Override
    public boolean isEmpty() {
        return defaultExpressionList.isEmpty();
    }

    @Override
    public void writeDocQuery(DocQueryContext docQueryContext, SpiExpression spiExpression) throws IOException {
        defaultExpressionList.writeDocQuery(docQueryContext, spiExpression);
    }

    @Override
    public void simplify() {
        defaultExpressionList.simplify();
    }

    @Override
    public void writeDocQuery(DocQueryContext docQueryContext) throws IOException {
        defaultExpressionList.writeDocQuery(docQueryContext);
    }

    @Override
    public String nestedPath(BeanDescriptor<?> beanDescriptor) {
        return defaultExpressionList.nestedPath(beanDescriptor);
    }

    @Override
    public void containsMany(BeanDescriptor<?> beanDescriptor, ManyWhereJoins manyWhereJoins) {
        defaultExpressionList.containsMany(beanDescriptor, manyWhereJoins);
    }

    @Override
    public void prepareExpression(BeanQueryRequest<?> beanQueryRequest) {
        defaultExpressionList.prepareExpression(beanQueryRequest);
    }

    @Override
    public void queryPlanHash(HashQueryPlanBuilder hashQueryPlanBuilder) {
        defaultExpressionList.queryPlanHash(hashQueryPlanBuilder);
    }

    @Override
    public int queryBindHash() {
        return defaultExpressionList.queryBindHash();
    }

    @Override
    public boolean isSameByPlan(SpiExpression spiExpression) {
        return defaultExpressionList.isSameByPlan(spiExpression);
    }

    @Override
    public boolean isSameByBind(SpiExpression spiExpression) {
        return defaultExpressionList.isSameByBind(spiExpression);
    }

    @Override
    public void addSql(SpiExpressionRequest spiExpressionRequest) {
        defaultExpressionList.addSql(spiExpressionRequest);
    }

    @Override
    public void addBindValues(SpiExpressionRequest spiExpressionRequest) {
        defaultExpressionList.addBindValues(spiExpressionRequest);
    }

    @Override
    public void validate(SpiExpressionValidation spiExpressionValidation) {
        defaultExpressionList.validate(spiExpressionValidation);
    }

    @Override
    public SpiExpression copyForPlanKey() {
        return defaultExpressionList.copyForPlanKey();
    }

    @Override
    public Object getIdEqualTo(String s) {
        return defaultExpressionList.getIdEqualTo(s);
    }


    //------------------------- extend -------------------------

    public ExtOrderBy<T> extOrder() {
        return extOrderBy();
    }

    public ExtOrderBy<T> extOrderBy() {
        return new ExtOrderBy<T>(this.query);
    }

    public ExtExpressionList<T> ignEq(String s, Object o) {
        if (o != null) {
            defaultExpressionList.eq(s, o);
        }
        return this;
    }

    public ExtExpressionList<T> ignNe(String s, Object o) {
        if (o != null) {
            defaultExpressionList.ne(s, o);
        }
        return this;
    }

    public ExtExpressionList<T> ignIeq(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.ieq(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignGt(String s, Object o) {
        if (o != null) {
            defaultExpressionList.gt(s, o);
        }
        return this;
    }

    public ExtExpressionList<T> ignGe(String s, Object o) {
        if (o != null) {
            defaultExpressionList.ne(s, o);
        }
        return this;
    }

    public ExtExpressionList<T> ignLt(String s, Object o) {
        if (o != null) {
            defaultExpressionList.lt(s, o);
        }
        return this;
    }

    public ExtExpressionList<T> ignLe(String s, Object o) {
        if (o != null) {
            defaultExpressionList.le(s, o);
        }
        return this;
    }

    public ExtExpressionList<T> ignLike(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.like(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignIlike(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.ilike(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignStartsWith(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.startsWith(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignIstartsWith(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.istartsWith(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignEndsWith(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.endsWith(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignIendsWith(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.iendsWith(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignContains(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.contains(s, s1);
        }
        return this;
    }

    public ExtExpressionList<T> ignIcontains(String s, String s1) {
        if (s1 != null && !s1.isEmpty()) {
            defaultExpressionList.icontains(s, s1);
        }
        return this;
    }

    //QueryBean property
    public <X> ExtExpressionList<T> eq(PBaseNumber<?, X> propertyName, X value) {
        return this.eq(propertyName.toString(), value);
    }

    public ExtExpressionList<T> eq(PString propertyName, String value) {
        return this.eq(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> eq(PBaseValueEqual<?, X> propertyName, X value) {
        return this.eq(propertyName.toString(), value);
    }

    public ExtExpressionList<T> eq(PBoolean propertyName, Boolean value) {
        return this.eq(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> eq(PBaseDate<?, D> propertyName, D value) {
        return this.eq(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ne(PBaseNumber<?, X> propertyName, X value) {
        return this.ne(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ne(PString propertyName, String value) {
        return this.ne(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ne(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ne(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ne(PBoolean propertyName, Boolean value) {
        return this.ne(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ne(PBaseDate<?, D> propertyName, D value) {
        return this.ne(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ieq(PString propertyName, String value) {
        return this.ieq(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> between(PBaseNumber<?, X> propertyName, X value1, X value2) {
        return this.between(propertyName.toString(), value1, value2);
    }

    public ExtExpressionList<T> between(PString propertyName, String value1, String value2) {
        return this.between(propertyName.toString(), value1, value2);
    }

    public <X> ExtExpressionList<T> between(PBaseValueEqual<?, X> propertyName, X value1, X value2) {
        return this.between(propertyName.toString(), value1, value2);
    }

    public <D> ExtExpressionList<T> between(PBaseDate<?, D> propertyName, D value1, D value2) {
        return this.between(propertyName.toString(), value1, value2);
    }

    public <X> ExtExpressionList<T> betweenProperties(PBaseNumber<?, X> lowProperty, PBaseNumber<?, X> highProperty, X value) {
        return this.betweenProperties(lowProperty.toString(), highProperty.toString(), value);
    }

    public <X> ExtExpressionList<T> betweenProperties(PBaseValueEqual<?, X> lowProperty, PBaseValueEqual<?, X> highProperty, X value) {
        return this.betweenProperties(lowProperty.toString(), highProperty.toString(), value);
    }

    public <D> ExtExpressionList<T> betweenProperties(PBaseDate<?, D> lowProperty, PBaseDate<?, D> highProperty, D value) {
        return this.betweenProperties(lowProperty.toString(), highProperty.toString(), value);
    }

    public ExtExpressionList<T> betweenProperties(PString lowProperty, PString highProperty, String value) {
        return this.betweenProperties(lowProperty.toString(), highProperty.toString(), value);
    }

    public <X> ExtExpressionList<T> gt(PBaseNumber<?, X> propertyName, X value) {
        return this.gt(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> gt(PBaseValueEqual<?, X> propertyName, X value) {
        return this.gt(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> gt(PBaseDate<?, D> propertyName, D value) {
        return this.gt(propertyName.toString(), value);
    }

    public ExtExpressionList<T> gt(PString propertyName, String value) {
        return this.gt(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ge(PBaseNumber<?, X> propertyName, X value) {
        return this.ge(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ge(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ge(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ge(PBaseDate<?, D> propertyName, D value) {
        return this.ge(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ge(PString propertyName, String value) {
        return this.ge(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> lt(PBaseNumber<?, X> propertyName, X value) {
        return this.lt(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> lt(PBaseValueEqual<?, X> propertyName, X value) {
        return this.lt(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> lt(PBaseDate<?, D> propertyName, D value) {
        return this.lt(propertyName.toString(), value);
    }

    public ExtExpressionList<T> lt(PString propertyName, String value) {
        return this.lt(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> le(PBaseNumber<?, X> propertyName, X value) {
        return this.le(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> le(PBaseValueEqual<?, X> propertyName, X value) {
        return this.le(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> le(PBaseDate<?, D> propertyName, D value) {
        return this.le(propertyName.toString(), value);
    }

    public ExtExpressionList<T> le(PString propertyName, String value) {
        return this.le(propertyName.toString(), value);
    }

    public ExtExpressionList<T> isNull(TQProperty propertyName) {
        return this.isNull(propertyName.toString());
    }

    public ExtExpressionList<T> isNotNull(TQProperty propertyName) {
        return this.isNotNull(propertyName.toString());
    }


    public ExtExpressionList<T> like(PString propertyName, String value) {
        return this.like(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ilike(PString propertyName, String value) {
        return this.ilike(propertyName.toString(), value);
    }

    public ExtExpressionList<T> startsWith(PString propertyName, String value) {
        return this.startsWith(propertyName.toString(), value);
    }

    public ExtExpressionList<T> istartsWith(PString propertyName, String value) {
        return this.istartsWith(propertyName.toString(), value);
    }

    public ExtExpressionList<T> endsWith(PString propertyName, String value) {
        return this.endsWith(propertyName.toString(), value);
    }

    public ExtExpressionList<T> iendsWith(PString propertyName, String value) {
        return this.iendsWith(propertyName.toString(), value);
    }

    public ExtExpressionList<T> contains(PString propertyName, String value) {
        return this.contains(propertyName.toString(), value);
    }

    public ExtExpressionList<T> icontains(PString propertyName, String value) {
        return this.icontains(propertyName.toString(), value);
    }

    public ExtExpressionList<T> in(TQProperty propertyName, Query<?> subQuery) {
        return this.in(propertyName.toString(), subQuery);
    }

    public ExtExpressionList<T> in(TQProperty propertyName, Object... values) {
        return this.in(propertyName.toString(), values);
    }

    public ExtExpressionList<T> in(TQProperty propertyName, Collection<?> values) {
        return this.in(propertyName.toString(), values);
    }

    public ExtExpressionList<T> notIn(TQProperty propertyName, Object... values) {
        return this.notIn(propertyName.toString(), values);
    }

    public ExtExpressionList<T> notIn(TQProperty propertyName, Collection<?> values) {
        return this.notIn(propertyName.toString(), values);
    }

    public ExtExpressionList<T> notIn(TQProperty propertyName, Query<?> subQuery) {
        return this.notIn(propertyName.toString(), subQuery);
    }

    public ExtExpressionList<T> isEmpty(TQProperty propertyName) {
        return this.isEmpty(propertyName.toString());
    }

    public ExtExpressionList<T> isNotEmpty(TQProperty propertyName) {
        return this.isEmpty(propertyName.toString());
    }

    public ExtExpressionList<T> arrayContains(TQProperty propertyName, Object... values) {
        return this.arrayContains(propertyName.toString(), values);
    }

    public ExtExpressionList<T> arrayNotContains(TQProperty propertyName, Object... values) {
        return this.arrayNotContains(propertyName.toString(), values);
    }

    public ExtExpressionList<T> arrayIsEmpty(TQProperty propertyName) {
        return this.arrayIsEmpty(propertyName.toString());
    }

    public ExtExpressionList<T> arrayIsNotEmpty(TQProperty propertyName) {
        return this.arrayIsNotEmpty(propertyName.toString());
    }

    public ExtExpressionList<T> match(PString propertyName, String search) {
        return this.match(propertyName.toString(), search);
    }

    public ExtExpressionList<T> match(PString propertyName, String search, Match options) {
        return this.match(propertyName.toString(), search, options);
    }

    public ExtExpressionList<T> multiMatch(String search, PString... properties) {
        String[] propertiesStr = new String[properties.length];
        int i = 0;
        for (TQProperty property : properties) {
            propertiesStr[i++] = property.toString();
        }
        return this.multiMatch(search, propertiesStr);
    }

    public <X> ExtExpressionList<T> ignEq(PBaseNumber<?, X> propertyName, X value) {
        return this.ignEq(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignEq(PString propertyName, String value) {
        return this.ignEq(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignEq(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ignEq(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignEq(PBoolean propertyName, Boolean value) {
        return this.ignEq(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ignEq(PBaseDate<?, D> propertyName, D value) {
        return this.ignEq(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignIeq(PString propertyName, String value) {
        return this.ignIeq(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignNe(PBaseNumber<?, X> propertyName, X value) {
        return this.ignNe(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignNe(PString propertyName, String value) {
        return this.ignNe(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignNe(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ignNe(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignNe(PBoolean propertyName, Boolean value) {
        return this.ignNe(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ignNe(PBaseDate<?, D> propertyName, D value) {
        return this.ignNe(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignContains(PString propertyName, String value) {
        return this.ignContains(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignEndsWith(PString propertyName, String value) {
        return this.ignEndsWith(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignGe(PBaseNumber<?, X> propertyName, X value) {
        return this.ignGe(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignGe(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ignGe(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ignGe(PBaseDate<?, D> propertyName, D value) {
        return this.ignGe(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignGe(PString propertyName, String value) {
        return this.ignGe(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignGt(PBaseNumber<?, X> propertyName, X value) {
        return this.ignGt(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignGt(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ignGt(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ignGt(PBaseDate<?, D> propertyName, D value) {
        return this.ignGt(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignGt(PString propertyName, String value) {
        return this.ignGt(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignIcontains(PString propertyName, String value) {
        return this.ignIcontains(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignIendsWith(PString propertyName, String value) {
        return this.ignIendsWith(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignIlike(PString propertyName, String value) {
        return this.ignIlike(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignIstartsWith(PString propertyName, String value) {
        return this.ignIstartsWith(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignLe(PBaseNumber<?, X> propertyName, X value) {
        return this.ignLe(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignLe(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ignLe(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ignLe(PBaseDate<?, D> propertyName, D value) {
        return this.ignLe(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignLe(PString propertyName, String value) {
        return this.ignLe(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignLike(PString propertyName, String value) {
        return this.ignLike(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignLt(PBaseNumber<?, X> propertyName, X value) {
        return this.ignLt(propertyName.toString(), value);
    }

    public <X> ExtExpressionList<T> ignLt(PBaseValueEqual<?, X> propertyName, X value) {
        return this.ignLt(propertyName.toString(), value);
    }

    public <D> ExtExpressionList<T> ignLt(PBaseDate<?, D> propertyName, D value) {
        return this.ignLt(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignLt(PString propertyName, String value) {
        return this.ignLt(propertyName.toString(), value);
    }

    public ExtExpressionList<T> ignStartsWith(PString propertyName, String value) {
        return this.ignStartsWith(propertyName.toString(), value);
    }
}
