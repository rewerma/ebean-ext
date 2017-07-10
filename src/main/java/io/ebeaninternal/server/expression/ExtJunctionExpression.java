package io.ebeaninternal.server.expression;

import io.ebean.*;
import io.ebean.event.BeanQueryRequest;
import io.ebean.ext.expression.ExtExpressionList;
import io.ebean.ext.ExtOrderBy;
import io.ebean.search.*;
import io.ebeaninternal.api.*;
import io.ebeaninternal.server.deploy.BeanDescriptor;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExtJunctionExpression<T> implements SpiJunction<T>, SpiExpression, ExpressionList<T> {
    private JunctionExpression<T> junctionExpression;

    public ExtJunctionExpression(Junction<T> junctionExpression) {
        this.junctionExpression = (JunctionExpression<T>) junctionExpression;
    }

    @Override
    public void writeDocQueryJunction(DocQueryContext context) throws IOException {
        junctionExpression.writeDocQueryJunction(context);
    }

    @Override
    public Query<T> query() {
        return junctionExpression.query();
    }

    @Override
    public Query<T> order(String orderByClause) {
        return junctionExpression.order(orderByClause);
    }

    @Override
    public OrderBy<T> order() {
        return junctionExpression.order();
    }

    @Override
    public OrderBy<T> orderBy() {
        return junctionExpression.orderBy();
    }

    @Override
    public Query<T> orderBy(String orderBy) {
        return junctionExpression.orderBy(orderBy);
    }

    @Override
    public Query<T> setOrderBy(String orderBy) {
        return junctionExpression.setOrderBy(orderBy);
    }

    @Override
    public Query<T> apply(FetchPath fetchPath) {
        return junctionExpression.apply(fetchPath);
    }

    @Override
    public Query<T> asOf(Timestamp asOf) {
        return junctionExpression.asOf(asOf);
    }

    @Override
    public Query<T> asDraft() {
        return junctionExpression.asDraft();
    }

    @Override
    public Query<T> forUpdate() {
        return junctionExpression.forUpdate();
    }

    @Override
    public Query<T> forUpdateNoWait() {
        return junctionExpression.forUpdateNoWait();
    }

    @Override
    public Query<T> forUpdateSkipLocked() {
        return junctionExpression.forUpdateSkipLocked();
    }

    @Override
    public Query<T> setIncludeSoftDeletes() {
        return junctionExpression.setIncludeSoftDeletes();
    }

    @Override
    public int delete() {
        return junctionExpression.delete();
    }

    @Override
    public int update() {
        return junctionExpression.update();
    }

    @Override
    public QueryIterator<T> findIterate() {
        return junctionExpression.findIterate();
    }

    @Override
    public void findEach(Consumer<T> consumer) {
        junctionExpression.findEach(consumer);
    }

    @Override
    public void findEachWhile(Predicate<T> consumer) {
        junctionExpression.findEachWhile(consumer);
    }

    @Override
    public List<T> findList() {
        return junctionExpression.findList();
    }

    @Override
    public <A> List<A> findIds() {
        return junctionExpression.findIds();
    }

    @Override
    public int findCount() {
        return junctionExpression.findCount();
    }

    @Override
    public Set<T> findSet() {
        return junctionExpression.findSet();
    }

    @Override
    public <K> Map<K, T> findMap() {
        return junctionExpression.findMap();
    }

    @Override
    public <A> List<A> findSingleAttributeList() {
        return junctionExpression.findSingleAttributeList();
    }

    @Nullable
    @Override
    public T findOne() {
        return junctionExpression.findOne();
    }

    @Override
    public Optional<T> findOneOrEmpty() {
        return junctionExpression.findOneOrEmpty();
    }

    @Nullable
    @Override
    public T findUnique() {
        return junctionExpression.findUnique();
    }

    @Override
    public FutureRowCount<T> findFutureCount() {
        return null;
    }

    @Override
    public FutureIds<T> findFutureIds() {
        return junctionExpression.findFutureIds();
    }

    @Override
    public FutureList<T> findFutureList() {
        return junctionExpression.findFutureList();
    }

    @Override
    public PagedList<T> findPagedList() {
        return junctionExpression.findPagedList();
    }

    @Override
    public List<Version<T>> findVersions() {
        return junctionExpression.findVersions();
    }

    @Override
    public List<Version<T>> findVersionsBetween(Timestamp start, Timestamp end) {
        return junctionExpression.findVersionsBetween(start, end);
    }

    @Override
    public ExtJunctionExpression<T> filterMany(String prop) {
        junctionExpression.filterMany(prop);
        return this;
    }

    @Override
    public Query<T> select(String properties) {
        return junctionExpression.select(properties);
    }

    @Override
    public Query<T> setDistinct(boolean distinct) {
        return junctionExpression.setDistinct(distinct);
    }

    @Override
    public Query<T> setDocIndexName(String indexName) {
        return junctionExpression.setDocIndexName(indexName);
    }

    @Override
    public Query<T> setFirstRow(int firstRow) {
        return junctionExpression.setFirstRow(firstRow);
    }

    @Override
    public Query<T> setMaxRows(int maxRows) {
        return null;
    }

    @Override
    public Query<T> setMapKey(String mapKey) {
        return null;
    }

    @Override
    public Query<T> setUseCache(boolean useCache) {
        return null;
    }

    @Override
    public Query<T> setUseQueryCache(boolean useCache) {
        return null;
    }

    @Override
    public Query<T> setUseDocStore(boolean useDocsStore) {
        return null;
    }

    @Override
    public Query<T> setDisableLazyLoading(boolean disableLazyLoading) {
        return null;
    }

    @Override
    public Query<T> setDisableReadAuditing() {
        return null;
    }

    @Override
    public ExtJunctionExpression<T> having() {
        junctionExpression.having();
        return this;
    }

    @Override
    public ExtJunctionExpression<T> where() {
        junctionExpression.where();
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonExists(String propertyName, String path) {
        junctionExpression.jsonExists(propertyName, path);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonNotExists(String propertyName, String path) {
        junctionExpression.jsonNotExists(propertyName, path);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonEqualTo(String propertyName, String path, Object value) {
        junctionExpression.jsonEqualTo(propertyName, path, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonNotEqualTo(String propertyName, String path, Object value) {
        junctionExpression.jsonNotEqualTo(propertyName, path, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonGreaterThan(String propertyName, String path, Object value) {
        junctionExpression.jsonGreaterThan(propertyName, path, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonGreaterOrEqual(String propertyName, String path, Object value) {
        junctionExpression.jsonGreaterOrEqual(propertyName, path, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonLessThan(String propertyName, String path, Object value) {
        junctionExpression.jsonLessThan(propertyName, path, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonLessOrEqualTo(String propertyName, String path, Object value) {
        junctionExpression.jsonLessOrEqualTo(propertyName, path, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> jsonBetween(String propertyName, String path, Object lowerValue, Object upperValue) {
        junctionExpression.jsonBetween(propertyName, path, lowerValue, upperValue);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> add(Expression expr) {
        junctionExpression.add(expr);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> addAll(ExpressionList<T> exprList) {
        junctionExpression.addAll(exprList);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> eq(String propertyName, Object value) {
        junctionExpression.eq(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> ne(String propertyName, Object value) {
        junctionExpression.ne(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> ieq(String propertyName, String value) {
        junctionExpression.ieq(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> between(String propertyName, Object value1, Object value2) {
        junctionExpression.between(propertyName, value1, value2);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> betweenProperties(String lowProperty, String highProperty, Object value) {
        junctionExpression.betweenProperties(lowProperty, highProperty, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> gt(String propertyName, Object value) {
        junctionExpression.gt(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> ge(String propertyName, Object value) {
        junctionExpression.ge(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> lt(String propertyName, Object value) {
        junctionExpression.lt(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> le(String propertyName, Object value) {
        junctionExpression.le(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> isNull(String propertyName) {
        junctionExpression.isNull(propertyName);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> isNotNull(String propertyName) {
        junctionExpression.isNotNull(propertyName);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> exampleLike(Object example) {
        junctionExpression.exampleLike(example);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> iexampleLike(Object example) {
        junctionExpression.iexampleLike(example);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> like(String propertyName, String value) {
        junctionExpression.like(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> ilike(String propertyName, String value) {
        junctionExpression.ilike(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> startsWith(String propertyName, String value) {
        junctionExpression.startsWith(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> istartsWith(String propertyName, String value) {
        junctionExpression.istartsWith(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> endsWith(String propertyName, String value) {
        junctionExpression.endsWith(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> iendsWith(String propertyName, String value) {
        junctionExpression.iendsWith(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> contains(String propertyName, String value) {
        junctionExpression.contains(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> icontains(String propertyName, String value) {
        junctionExpression.icontains(propertyName, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> in(String propertyName, Query<?> subQuery) {
        junctionExpression.in(propertyName, subQuery);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> in(String propertyName, Object... values) {
        junctionExpression.in(propertyName, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> in(String propertyName, Collection<?> values) {
        junctionExpression.in(propertyName, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> notIn(String propertyName, Object... values) {
        junctionExpression.notIn(propertyName, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> notIn(String propertyName, Collection<?> values) {
        junctionExpression.notIn(propertyName, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> notIn(String propertyName, Query<?> subQuery) {
        junctionExpression.notIn(propertyName, subQuery);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> isEmpty(String propertyName) {
        junctionExpression.isEmpty(propertyName);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> isNotEmpty(String propertyName) {
        junctionExpression.isNotEmpty(propertyName);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> exists(Query<?> subQuery) {
        junctionExpression.exists(subQuery);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> notExists(Query<?> subQuery) {
        junctionExpression.notExists(subQuery);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> idIn(Object... idValues) {
        junctionExpression.idIn(idValues);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> idIn(List<?> idValues) {
        junctionExpression.idIn(idValues);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> idEq(Object value) {
        junctionExpression.idEq(value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> allEq(Map<String, Object> propertyMap) {
        junctionExpression.allEq(propertyMap);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> arrayContains(String propertyName, Object... values) {
        junctionExpression.arrayContains(propertyName, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> arrayNotContains(String propertyName, Object... values) {
        junctionExpression.arrayNotContains(propertyName, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> arrayIsEmpty(String propertyName) {
        junctionExpression.arrayIsEmpty(propertyName);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> arrayIsNotEmpty(String propertyName) {
        junctionExpression.arrayIsNotEmpty(propertyName);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> raw(String raw, Object value) {
        junctionExpression.raw(raw, value);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> raw(String raw, Object... values) {
        junctionExpression.raw(raw, values);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> raw(String raw) {
        junctionExpression.raw(raw);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> match(String propertyName, String search) {
        junctionExpression.match(propertyName, search);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> match(String propertyName, String search, Match options) {
        junctionExpression.match(propertyName, search, options);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> multiMatch(String search, String... properties) {
        junctionExpression.multiMatch(search, properties);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> multiMatch(String search, MultiMatch options) {
        junctionExpression.multiMatch(search, options);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> textSimple(String search, TextSimple options) {
        junctionExpression.textSimple(search, options);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> textQueryString(String search, TextQueryString options) {
        junctionExpression.textQueryString(search, options);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> textCommonTerms(String search, TextCommonTerms options) {
        junctionExpression.textCommonTerms(search, options);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> and(Expression expOne, Expression expTwo) {
        junctionExpression.and(expOne, expTwo);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> or(Expression expOne, Expression expTwo) {
        junctionExpression.or(expOne, expTwo);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> not(Expression exp) {
        junctionExpression.not(exp);
        return this;
    }

    @Override
    public ExtJunctionExpression<T> and() {
        return new ExtJunctionExpression<T>(junctionExpression.and());
    }

    @Override
    public ExtJunctionExpression<T> or() {
        return new ExtJunctionExpression<T>(junctionExpression.or());
    }

    @Override
    public ExtJunctionExpression<T> not() {
        return new ExtJunctionExpression<T>(junctionExpression.not());
    }

    @Override
    public ExtJunctionExpression<T> conjunction() {
        return new ExtJunctionExpression<T>(junctionExpression.conjunction());
    }

    @Override
    public ExtJunctionExpression<T> disjunction() {
        return new ExtJunctionExpression<T>(junctionExpression.disjunction());
    }

    @Override
    public ExtJunctionExpression<T> must() {
        return new ExtJunctionExpression<T>(junctionExpression.must());
    }

    @Override
    public ExtJunctionExpression<T> should() {
        return new ExtJunctionExpression<T>(junctionExpression.should());
    }

    @Override
    public ExtJunctionExpression<T> mustNot() {
        return new ExtJunctionExpression<T>(junctionExpression.mustNot());
    }

    @Override
    public ExtExpressionList<T> endJunction() {
        return new ExtExpressionList<T>(this.query(),junctionExpression.endJunction());
    }

    @Override
    public ExtExpressionList<T> endAnd() {
        return new ExtExpressionList<T>(this.query(),junctionExpression.endAnd());
    }

    @Override
    public ExtExpressionList<T> endOr() {
        return new ExtExpressionList<T>(this.query(),junctionExpression.endOr());
    }

    @Override
    public ExtExpressionList<T> endNot() {
        return new ExtExpressionList<T>(this.query(),junctionExpression.endNot());
    }

    @Override
    public void simplify() {
        junctionExpression.simplify();
    }

    @Override
    public void writeDocQuery(DocQueryContext context) throws IOException {
        junctionExpression.writeDocQuery(context);
    }

    @Override
    public String nestedPath(BeanDescriptor<?> desc) {
        return junctionExpression.nestedPath(desc);
    }

    @Override
    public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins whereManyJoins) {
        junctionExpression.containsMany(desc, whereManyJoins);
    }

    @Override
    public void prepareExpression(BeanQueryRequest<?> request) {
        junctionExpression.prepareExpression(request);
    }

    @Override
    public void queryPlanHash(HashQueryPlanBuilder builder) {
        junctionExpression.queryPlanHash(builder);
    }

    @Override
    public int queryBindHash() {
        return junctionExpression.queryBindHash();
    }

    @Override
    public boolean isSameByPlan(SpiExpression other) {
        return junctionExpression.isSameByPlan(other);
    }

    @Override
    public boolean isSameByBind(SpiExpression other) {
        return junctionExpression.isSameByBind(other);
    }

    @Override
    public void addSql(SpiExpressionRequest request) {
        junctionExpression.addSql(request);
    }

    @Override
    public void addBindValues(SpiExpressionRequest request) {
        junctionExpression.addBindValues(request);
    }

    @Override
    public void validate(SpiExpressionValidation validation) {
        junctionExpression.validate(validation);
    }

    @Override
    public SpiExpression copyForPlanKey() {
        return junctionExpression.copyForPlanKey();
    }

    @Override
    public Object getIdEqualTo(String idName) {
        return junctionExpression.getIdEqualTo(idName);
    }

    //------------------------- extend -------------------------

    public ExtOrderBy<T> extOrder() {
        return new ExtOrderBy<T>(junctionExpression.order());
    }

    public ExtOrderBy<T> extOrderBy() {
        return new ExtOrderBy<T>(junctionExpression.orderBy());
    }

    public ExtJunctionExpression<T> ignEq(String propertyName, Object value) {
        if (value != null) {
            junctionExpression.eq(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignNe(String propertyName, Object value) {
        if (value != null) {
            junctionExpression.ne(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignIeq(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.ieq(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignGt(String propertyName, Object value) {
        if (value != null) {
            junctionExpression.gt(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignGe(String propertyName, Object value) {
        if (value != null) {
            junctionExpression.ge(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignLt(String propertyName, Object value) {
        if (value != null) {
            junctionExpression.lt(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignLe(String propertyName, Object value) {
        if (value != null) {
            junctionExpression.le(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignLike(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.like(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignIlike(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.ilike(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignStartsWith(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.startsWith(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignIstartsWith(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.istartsWith(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignEndsWith(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.endsWith(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignIendsWith(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.iendsWith(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignContains(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.contains(propertyName, value);
        }
        return this;
    }

    public ExtJunctionExpression<T> ignIcontains(String propertyName, String value) {
        if (value != null && !value.isEmpty()) {
            junctionExpression.icontains(propertyName, value);
        }
        return this;
    }
}
