CREATE DATABASE `ow_anti_picker`;

CREATE TABLE `user` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '名前',
  `password` varchar(255) NOT NULL COMMENT 'パスワード',
  `created` datetime NOT NULL COMMENT '登録日時',
  `modified` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb3 COMMENT='ユーザ';

CREATE TABLE `role` (
  `id` int(1) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '名前',
  `created` datetime NOT NULL COMMENT '登録日時',
  `modified` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb3 COMMENT='ロール';

CREATE TABLE `hero` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_id` int(1) unsigned NOT NULL COMMENT 'ロールID',
  `image_name` varchar(255) DEFAULT NULL COMMENT 'イメージ名',
  `name` varchar(50) NOT NULL COMMENT '名前',
  `created` datetime NOT NULL COMMENT '登録日時',
  `modified` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  CONSTRAINT `hero_role_key` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB CHARSET=utf8mb3 COMMENT='ヒーロー';

CREATE TABLE `common_anti_pick` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `hero_id` int(3) unsigned NOT NULL COMMENT 'ヒーローID',
  `anti_hero_id` int(3) unsigned NOT NULL COMMENT 'アンチヒーローID',
  `reason` text COMMENT '理由',
  `created` datetime NOT NULL COMMENT '登録日時',
  `modified` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hero_id_anti_hero_id_unique` (`hero_id`,`anti_hero_id`),
  CONSTRAINT `common_anti_pick_hero_key` FOREIGN KEY (`hero_id`) REFERENCES `hero` (`id`),
  CONSTRAINT `common_anti_pick_anti_hero_key` FOREIGN KEY (`anti_hero_id`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB CHARSET=utf8mb3 COMMENT='共通アンチピック';

CREATE TABLE `anti_pick` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(6) unsigned NOT NULL COMMENT 'ユーザID',
  `hero_id` int(3) unsigned NOT NULL COMMENT 'ヒーローID',
  `anti_hero_id` int(3) unsigned NOT NULL COMMENT 'アンチヒーローID',
  `reason` text COMMENT '理由',
  `created` datetime NOT NULL COMMENT '登録日時',
  `modified` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_hero_id_anti_hero_id_unique` (`user_id`,`hero_id`,`anti_hero_id`),
  CONSTRAINT `anti_pick_user_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `anti_pick_hero_key` FOREIGN KEY (`hero_id`) REFERENCES `hero` (`id`),
  CONSTRAINT `anti_pick_anti_hero_key` FOREIGN KEY (`anti_hero_id`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB CHARSET=utf8mb3 COMMENT='アンチピック';