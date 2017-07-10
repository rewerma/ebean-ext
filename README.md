# ebean-ext
Extend for Ebean ORM

1.查询扩展

(1).直接忽略null值查询

    Product product = new Product();
    io.ebean.ext.Finder<Long, Product> finder = new io.ebean.ext.Finder<>(Product.class);
    finder.query().where().ignEq("name", product.getName()).findList();
    
如果product.getName()为空，则直接忽略eq拼接条件。

(2).使用别名参数查询

    QProduct _product = QProduct.alias();
    finder.query().where().eq(_product.name, product.getName()).findList();

(3).使用别名参数作为select入参

    finder.query().select(_product.id, _product.name).findList();

(4).使用别名参数作为fetch入参
    
    QUser _user = QUser.alias();
    User.find.query().fetch(_user.role).where().eq(_user.role.roleName, "admin").findList();
    
(5).使用别名参数fetch指定字段别名

    QUser _user = QUser.alias();
    QRole _role = QRole.alias();
    User.find.query().fetch(_user.role, _role.id, _role.roleName).where().eq(_user.role.roleName, "admin").findList();

(6).使用别名参数的orderBy

    User.find.query().extOrder().desc(_user.id).findList();
    User.find.query().where().eq(_user.id, 1L).extOrder().desc(_user.userName).findList();
    
(7).查询首行记录

    User user = User.find.query().order().desc("id").findFirst();
    
如果记录是个集合列表则返回首条记录，如果集合为空则返回空

2.Model操作扩展

(1).实体类继承抽象类：io.ebean.ext.Model

(2).实体类可引入注解：@EbeanService("ebeanServer2")
该注解可以用在多数据源的多ebeanServer的状态下，加了该注解之后，所有扩展的增删改查操作都不需要再次申明ebeanServer的beanId。

(3).model.save的初始化方法自动调用
在实体类中可以重写一个init()方法，之后在model.save或者insert的时候会自动调用init()内部的初始化方法

    @Override
    public void init() {
        if (creationDate == null) {
            creationDate = new Date();
        }
    }
    
(4).通过id更新一条记录的指定字段

    user.update("userName", "email");
    user.update(_user.userName, _user.email);
    
其中user的id属性必须有值

(5).加入saveOrUpdate方法

    user.saveOrUpdate();
    user.saveOrUpdate(_user.userName, _user.email);
  
如果是新增的情况依然支持init()初始化方法自动调用，如果是update的情况依然支持指定更新字段入参



Ebean ORM版本为10.x 

Ebean ORM的样例可以参考其官方Github: 
https://github.com/ebean-orm-examples