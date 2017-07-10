# ebean-ext
Extend for ebean orm

1.查询扩展

(1).直接忽略null值查询

    Product product = new Product();
    io.ebean.ext.Finder<Long, Product> finder = new io.ebean.ext.Finder<>(Product.class);
    finder.query().where().ignEq("name", product.getName()).findList();
    
如果prduct.getName()为空，则直接忽略eq拼接条件。

(2).使用别名参数查询

    QProduct _product = QProduct.alias();
    finder.query().where().eq(_product.name, product.getName()).findList();

(3).使用别名参数作为select入参

    finder.query().select(_product.id, _product.name).where().eq(_product.name, product.getName()).findList();

