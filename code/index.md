###详细Java代码如下：



一. entity

- 	[Order.java](entity/Order.java)

	订单实体

- 	[OrderCar.java](entity/OrderCar.java)

	购物车实体

- 	[OrderItem.java](entity/OrderItem.java)

	订单项实体

- 	[Product.java](entity/Product.java)

	商品实体

- 	[User.java](entity/User.java)

	用户实体

- 	[Order.hbm.xml](entity/Order.hbm.xml)

	hibernate用户配置文件

- 	[OrderItem.hbm.xml](entity/OrderItem.hbm.xml)

	hibernate订单项配置文件

- 	[Product.hbm.xml](entity/Product.hbm.xml)

	hibernate商品配置文件

- 	[User.hbm.xml](entity/User.hbm.xml)

	hibernate用户配置文件
    
二. dao

- 	[OrderDaoImpl.java](dao/OrderDaoImpl.java)

	订单dao

- 	[ProductDaoImpl.java](dao/ProductDaoImpl.java)

	商品dao

- 	[UserDaoImpl.java](dao/UserDaoImpl.java)

	用户dao
    
三. service
- 	[ShoppingCartService.java](service/ShoppingCartService.java)

	业务接口

- 	[UserService.java](service/UserService.java)

	用户业务接口
    
四. serviceimpl

- 	[ShoppingCartServiceImpl.java](impl/ShoppingCartServiceImpl.java)

	业务实现

- 	[UserServiceImpl.java](impl/UserServiceImpl.java)

	业务实现
    
五. util

- 	[BaseDao.java](util/BaseDao.java)

	泛型写的dao接口

- 	[BaseDaoImpl.java](util/BaseDaoImpl.java)

	dao实现
    
六. web

- 	[ShopCartAction.java](web/ShopCartAction.java)

	购物车action
    
- 	[ShopJsonAction.java](web/ShopJsonAction.java)

	用Jason实现的action

- 	[TempAction.java](web/TempAction.java)

	用户置空action


