DROP TABLE IF EXISTS user;

-- user
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) NOT NULL COMMENT 'username',
  `password` varchar(255) NOT NULL COMMENT 'password',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'modified',
  PRIMARY KEY (`id`)
) COMMENT='user table';

INSERT INTO user (username,password) VALUES ('admin','123456')


INSERT INTO `user` (`id`,`username`,`name`,`password`,`salt`,`state`) VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);
INSERT INTO `permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`type`,`url`) VALUES (1,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/userList');
INSERT INTO `permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`type`,`url`) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/userAdd');
INSERT INTO `permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`type`,`url`) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/userDel');
INSERT INTO `role` (`id`,`available`,`description`,`role`) VALUES (1,0,'管理员','admin');
INSERT INTO `role` (`id`,`available`,`description`,`role`) VALUES (2,0,'VIP会员','vip');
INSERT INTO `role` (`id`,`available`,`description`,`role`) VALUES (3,1,'test','test');
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `role_permission` (`permission_id`,`role_id`) VALUES (3,2);
INSERT INTO `user_role` (`role_id`,`uid`) VALUES (1,1);