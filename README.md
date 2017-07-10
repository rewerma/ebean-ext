# ebean-ext
Extend for ebean orm

1.查询扩展
(1).直接忽略null值查询

    Product product = new Product();
    io.ebean.ext.Finder<Long, Product> finder = new io.ebean.ext.Finder<>(Product.class);
    finder.query().where().ignEq("name", product.getName());
    
如果prduct.getName()为空，则直接忽略eq拼接条件。

2.