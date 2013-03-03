

INSERT INTO `1000funs`.`shop` (`id`, `code`, `shop_name`, `region_id`, `manager_id`, `detail_address`, `deleted`) VALUES ('1', '440304001', '景田店', '1', '1', '深圳市福田区景田路110号', false);


INSERT INTO `1000funs`.`users` (`user_name`, `phone`, `email`, `password`,  `default_region_id`, `user_type`, `default_address`) VALUES ('SuperAdmin', '110', 'SuperAdmin@1000funs.com', 'hello', '1', '3', '深圳市福田区景田路110号');
INSERT INTO `1000funs`.`users` (`user_name`, `phone`, `email`, `password`,  `default_region_id`, `user_type`, `default_address`) VALUES ('张三', '13512312312', 'zhangshan@1000funs.com', 'hello','1', '1', '深圳市福田区景田路110号');
INSERT INTO `1000funs`.`users` (`user_name`, `phone`, `email`, `password`,  `default_region_id`, `user_type`, `default_address`) VALUES ('路人甲', '13669877898', 'jia@163.com', 'hello','1','0', '深圳市福田区景田路110号');


INSERT INTO `1000funs`.`package_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('1', '25元区', '/web/img/taochan2.jpg', '25元区;高级货', false);
INSERT INTO `1000funs`.`package_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('2', '20元区', '/img/taochan1.jpg', '20元区;', false);
INSERT INTO `1000funs`.`package_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('3', '18元区', '/web/img/taochan3.jpg', '18元区;', false);


INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('1', '10元区', '/web/img/taochan2.jpg', '10元区', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('2', '9元区', '/img/taochan1.jpg', '9元区;', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('3', '8元区', '/web/img/taochan3.jpg', '8元区;', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('4', '7元区', '/web/img/taochan3.jpg', '7元区;', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('5', '6元区', '/web/img/taochan3.jpg', '6元区;', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('6', '例汤区', '/web/img/taochan3.jpg', '例汤区;', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('7', '小吃', '/web/img/taochan3.jpg', '小吃;', false);
INSERT INTO `1000funs`.`food_group` (`id`, `group_name`, `image`, `detail`, `deleted`) VALUES ('8', '饮品', '/web/img/taochan3.jpg', '饮品;', false);


INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('1', '圆椒排骨', '圆椒排骨', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('2', '苦瓜炒蛋', '苦瓜炒蛋', '/web/img/chaixin.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('3', '蒜蓉菜心', '蒜蓉菜心', '/web/img/kuguachaodang.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('4', '蠔油菇絲蟹柳扒節瓜甫', '蠔油菇絲蟹柳扒節瓜甫', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('5', '煎羊扒配羅勒青醬汁', '煎羊扒配羅勒青醬汁', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('6', '青瓜炒猪肝', '青瓜炒猪肝', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('7', '蠔油鮑魚西生菜', '蠔油鮑魚西生菜', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('8', '萝卜牛腩', '萝卜牛腩', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('9', '铁板茄子', '铁板茄子', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('10', '西兰花炒鲜鱿', '西兰花炒鲜鱿', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('11', '蕃茄蛋', '蕃茄蛋', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('12', '菠菜蕃茄千層粉', '菠菜蕃茄千層粉', '/web/img/paigu.jpg', false);
INSERT INTO `1000funs`.`food` (`id`, `food_name`, `detail`, `image`, `deleted`) VALUES ('13', '蠔油鮑魚西生菜', '蠔油鮑魚西生菜', '/web/img/paigu.jpg', false);


INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '1', '1', '10', '10', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '2', '1', '10', '10', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '3', '1', '10', '10', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '4', '1', '10', '10', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '5', '1', '10', '10', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '6', '2', '9', '9', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '7', '2', '9', '9', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '8', '2', '9', '9', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '9', '2', '9', '9', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '10', '3', '8', '8', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '11', '3', '8', '8', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '12', '4', '7', '7', '10', false, false);
INSERT INTO `1000funs`.`food_re_shop` (`shop_id`, `food_id`, `group_id`, `origin_price`, `current_price`, `stock`, `droped`, `deleted`) VALUES ('1', '13', '5', '6', '6', '10', false, false);


INSERT INTO `1000funs`.`orders` (`id`, `shop_id`, `create_time`, `except_time`, `user_id`, `address`, `contact`, `phone`, `order_status`, `total_price`, `deleted`) VALUES ('1', '1', '2013-02-27 09:30:00', '2013-02-27 11:30:00', '3', '深圳市福田区莲花路2075号香丽大厦二楼', '路人甲', '13669877898', '0', '15', false);
INSERT INTO `1000funs`.`orders` (`id`, `shop_id`, `create_time`, `except_time`, `user_id`, `address`, `contact`, `phone`, `order_status`, `total_price`, `deleted`) VALUES ('2', '1', '2013-02-26 10:30:00', '2013-02-26 11:00:00', '3', '深圳市福田区莲花路2075号香丽大厦二楼', '路人甲', '13669877898', '0', '18', false);
INSERT INTO `1000funs`.`orders` (`id`, `shop_id`, `create_time`, `except_time`, `user_id`, `address`, `contact`, `phone`, `order_status`, `total_price`, `deleted`) VALUES ('3', '1', '2013-02-25 09:00:00', '2013-02-25 11:00:00', '3', '深圳市福田区莲花路2075号香丽大厦二楼', '路人甲', '13669877898', '0', '10', false);
INSERT INTO `1000funs`.`orders` (`id`, `shop_id`, `create_time`, `except_time`, `user_id`, `address`, `contact`, `phone`, `order_status`, `total_price`, `deleted`) VALUES ('4', '1', '2013-02-24 09:50:00', '2013-02-24 11:50:00', '3', '深圳市福田区莲花路2075号香丽大厦二楼', '路人甲', '13669877898', '0', '15', false);
INSERT INTO `1000funs`.`orders` (`id`, `shop_id`, `create_time`, `except_time`, `user_id`, `address`, `contact`, `phone`, `order_status`, `total_price`, `deleted`) VALUES ('5', '1', '2013-02-23 12:30:00', '2013-02-23 12:50:00', '3', '深圳市福田区莲花路2075号香丽大厦二楼', '路人甲', '13669877898', '0', '16', false);
INSERT INTO `1000funs`.`orders` (`id`, `shop_id`, `create_time`, `except_time`, `user_id`, `address`, `contact`, `phone`, `order_status`, `total_price`, `deleted`) VALUES ('6', '1', '2013-02-23 11:30:00', '2013-02-22 11:50:00', '3', '深圳市福田区莲花路2075号香丽大厦二楼', '路人甲', '13669877898', '0', '13', false);


INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '1', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '2', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '3', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '4', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '5', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '6', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('1', '0', '7', '1', false);

INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '9', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '8', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '2', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '4', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '5', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '6', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('2', '0', '7', '1', false);

INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '10', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '11', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '12', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '9', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '5', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '6', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('3', '0', '2', '1', false);

INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '10', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '11', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '12', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '9', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '5', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '6', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('4', '0', '2', '1', false);

INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '1', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '11', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '12', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '10', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '5', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '6', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('5', '0', '1', '1', false);

INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '10', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '11', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '12', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '4', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '5', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '3', '1', false);
INSERT INTO `1000funs`.`order_item` (`order_id`, `item_type`, `item_id`, `amount`, `deleted`) VALUES ('6', '0', '2', '1', false);


INSERT INTO `region` (`id`,`code`,`region_name`,`parent_id`,`image`,`has_children`,`full_path`,`deleted`) VALUES (1,'1','香丽大厦',-1,'img/region.jpg',NULL,NULL,0);
INSERT INTO `region` (`id`,`code`,`region_name`,`parent_id`,`image`,`has_children`,`full_path`,`deleted`) VALUES (2,'2','妇儿大厦',-1,'img/region.jpg',NULL,NULL,0);
INSERT INTO `region` (`id`,`code`,`region_name`,`parent_id`,`image`,`has_children`,`full_path`,`deleted`) VALUES (3,'3','妇女大厦',-1,'img/region.jpg',NULL,NULL,0);
INSERT INTO `region` (`id`,`code`,`region_name`,`parent_id`,`image`,`has_children`,`full_path`,`deleted`) VALUES (4,'4','少女大厦',-1,'img/region.jpg',NULL,NULL,0);
INSERT INTO `region` (`id`,`code`,`region_name`,`parent_id`,`image`,`has_children`,`full_path`,`deleted`) VALUES (5,'5','悍妇大厦',-1,'img/region.jpg',NULL,NULL,0);
