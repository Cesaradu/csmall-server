insert into pms_category
(name, parent_id, depth, keywords, sort, icon, enable, is_parent, is_display)
values ('家用电器', 0, 1, '家电', 99, 'http://www.tedu.cn/logo.png', 1, 1, 1),
       ('手机', 0, 1, '手机', 98, 'http://www.tedu.cn/logo.png', 1, 1, 1),
       ('家居', 0, 1, '居家生活', 91, 'http://www.tedu.cn/logo.png', 1, 1, 1),
       ('食品', 0, 1, '吃的喝的', 97, 'http://www.tedu.cn/logo.png', 1, 1, 1),
       ('电视', 1, 2, '电视', 93, 'http://www.tedu.cn/logo.png', 1, 1, 1),
       ('空调', 1, 2, '空调', 98, 'http://www.tedu.cn/logo.png', 1, 0, 1),
       ('洗衣机', 1, 2, '洗衣机', 92, 'http://www.tedu.cn/logo.png', 1, 0, 1),
       ('教育电视', 5, 3, '教育电视,教育,电视', 98, 'http://www.tedu.cn/logo.png', 1, 0, 1),
       ('游戏手机', 2, 2, '游戏手机', 95, 'http://www.tedu.cn/logo.png', 1, 0, 1),
       ('拍照手机', 2, 2, '拍照手机', 91, 'http://www.tedu.cn/logo.png', 1, 0, 1)
;