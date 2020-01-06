/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : ykb

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 06/01/2020 14:44:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单号',
  `order_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态\r\n            10：待付款\r\n            20：已付款',
  `order_amount` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单金额',
  `paid_amount` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '实际支付金额',
  `product_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品表外键ID',
  `buy_counts` int(11) NULL DEFAULT NULL COMMENT '产品购买的个数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `paid_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('190920CMSX472FW0', '190920CMSX472FW0', '10', '1200.0', NULL, '653', 1, '2019-09-20 17:45:21', NULL);
INSERT INTO `orders` VALUES ('190920CR8C000PX4', '190920CR8C000PX4', '10', '11400.0', NULL, '247', 1, '2019-09-20 17:52:48', NULL);
INSERT INTO `orders` VALUES ('190920CZB29Z8N7C', '190920CZB29Z8N7C', '10', '4800.0', NULL, '522', 1, '2019-09-20 18:11:06', NULL);
INSERT INTO `orders` VALUES ('1909238360R6S51P', '1909238360R6S51P', '10', '35.0', NULL, '59', 1, '2019-09-23 11:22:13', NULL);
INSERT INTO `orders` VALUES ('1909238FG3BPCRWH', '1909238FG3BPCRWH', '10', '142.0', NULL, '61', 1, '2019-09-23 11:56:13', NULL);
INSERT INTO `orders` VALUES ('19092396A8G49ZF8', '19092396A8G49ZF8', '10', '70.0', NULL, '63', 1, '2019-09-23 12:55:45', NULL);
INSERT INTO `orders` VALUES ('190923A9R6930R68', '190923A9R6930R68', '10', '10500.0', NULL, '697326', 1, '2019-09-23 14:30:00', NULL);
INSERT INTO `orders` VALUES ('190923AH285SDRYW', '190923AH285SDRYW', '10', '1400.0', NULL, '128907', 1, '2019-09-23 14:48:59', NULL);
INSERT INTO `orders` VALUES ('190923AHDGF6XB54', '190923AHDGF6XB54', '10', '140.0', NULL, '66', 1, '2019-09-23 14:50:12', NULL);
INSERT INTO `orders` VALUES ('191012B61D94484H', '191012B61D94484H', '10', '4400.0', NULL, '475211', 1, '2019-10-12 15:42:57', NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称',
  `price` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '产品表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '苹果11pro', '13599');
INSERT INTO `product` VALUES ('2', '华为p30pro', '4999');
INSERT INTO `product` VALUES ('3', '三星note9', '8999');
INSERT INTO `product` VALUES ('4', '酒店', '123');
INSERT INTO `product` VALUES ('64', '罗小黑战记', '35.0');
INSERT INTO `product` VALUES ('653', '优客宝酒店', '1200');
INSERT INTO `product` VALUES ('68', '罗小黑战记', '70.0');
INSERT INTO `product` VALUES ('69', '罗小黑战记', '70.0');
INSERT INTO `product` VALUES ('697326', '南昌红谷滩希尔顿欢朋酒店', '10500');
INSERT INTO `product` VALUES ('70', '罗小黑战记', '105.0');

-- ----------------------------
-- Table structure for y_category
-- ----------------------------
DROP TABLE IF EXISTS `y_category`;
CREATE TABLE `y_category`  (
  `catepory_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `catepory_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名',
  PRIMARY KEY (`catepory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电影类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_category
-- ----------------------------
INSERT INTO `y_category` VALUES (1, '记录');
INSERT INTO `y_category` VALUES (2, '战争');
INSERT INTO `y_category` VALUES (3, '历史');
INSERT INTO `y_category` VALUES (4, '传记');
INSERT INTO `y_category` VALUES (5, '体育');
INSERT INTO `y_category` VALUES (6, '科幻');
INSERT INTO `y_category` VALUES (7, '魔幻');
INSERT INTO `y_category` VALUES (8, '奇幻');
INSERT INTO `y_category` VALUES (9, '文艺');
INSERT INTO `y_category` VALUES (10, '音乐');
INSERT INTO `y_category` VALUES (11, '歌舞');
INSERT INTO `y_category` VALUES (12, '动漫');
INSERT INTO `y_category` VALUES (13, '西部');
INSERT INTO `y_category` VALUES (14, '武侠');
INSERT INTO `y_category` VALUES (15, '古装');
INSERT INTO `y_category` VALUES (16, '动作');
INSERT INTO `y_category` VALUES (17, '爱情');
INSERT INTO `y_category` VALUES (18, '剧情');
INSERT INTO `y_category` VALUES (19, '喜剧');
INSERT INTO `y_category` VALUES (20, '家庭');
INSERT INTO `y_category` VALUES (21, '伦理');
INSERT INTO `y_category` VALUES (22, '恐怖');
INSERT INTO `y_category` VALUES (23, '惊悚');
INSERT INTO `y_category` VALUES (24, '冒险');
INSERT INTO `y_category` VALUES (25, '犯罪');
INSERT INTO `y_category` VALUES (26, '悬疑');
INSERT INTO `y_category` VALUES (27, '青春');
INSERT INTO `y_category` VALUES (28, '灾难');

-- ----------------------------
-- Table structure for y_cinematicket
-- ----------------------------
DROP TABLE IF EXISTS `y_cinematicket`;
CREATE TABLE `y_cinematicket`  (
  `cinemaTicket_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '影票id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `projection_id` int(11) NULL DEFAULT NULL COMMENT '放映id',
  `seat_id` int(11) NULL DEFAULT NULL COMMENT '座位id',
  `movie_score` double NULL DEFAULT NULL COMMENT '评分',
  `money` double NULL DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`cinemaTicket_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '影票表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_cinematicket
-- ----------------------------
INSERT INTO `y_cinematicket` VALUES (1, 1, 1, 3, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (2, 1, 1, 2, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (58, 1, 1, 8, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (59, 1, 1, 4, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (60, 1, 4, 3, NULL, 36);
INSERT INTO `y_cinematicket` VALUES (61, 1, 4, 4, NULL, 36);
INSERT INTO `y_cinematicket` VALUES (62, 1, 3, 18, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (63, 1, 3, 19, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (64, 13, 3, 13, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (65, 1, 3, 18, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (66, 1, 3, 19, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (67, 1, 3, 11, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (68, 1, 3, 12, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (69, 1, 3, 11, NULL, 35);
INSERT INTO `y_cinematicket` VALUES (70, 1, 3, 11, NULL, 35);

-- ----------------------------
-- Table structure for y_comment
-- ----------------------------
DROP TABLE IF EXISTS `y_comment`;
CREATE TABLE `y_comment`  (
  `movie_comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `movie_comment_content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`movie_comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for y_hall
-- ----------------------------
DROP TABLE IF EXISTS `y_hall`;
CREATE TABLE `y_hall`  (
  `hall_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '影厅ID',
  `hall_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影厅名',
  `seat_num` int(11) NULL DEFAULT NULL COMMENT '座位数',
  PRIMARY KEY (`hall_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '影厅表\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hall
-- ----------------------------
INSERT INTO `y_hall` VALUES (1, '一号厅', 10);
INSERT INTO `y_hall` VALUES (2, '二号厅', 10);
INSERT INTO `y_hall` VALUES (3, '三号厅', 10);
INSERT INTO `y_hall` VALUES (4, '4号厅', 10);

-- ----------------------------
-- Table structure for y_hotel
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel`;
CREATE TABLE `y_hotel`  (
  `hotel_id` int(10) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hotel_intro` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotel_status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`hotel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel
-- ----------------------------
INSERT INTO `y_hotel` VALUES (1, '七天优客酒店', '历史悠久，五星级酒店', '江西省南昌市青山湖区', '五星级酒店', NULL, 1);

-- ----------------------------
-- Table structure for y_hotel_bedtype
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel_bedtype`;
CREATE TABLE `y_hotel_bedtype`  (
  `bedType_id` int(10) NOT NULL AUTO_INCREMENT,
  `bedType_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bedType_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel_bedtype
-- ----------------------------
INSERT INTO `y_hotel_bedtype` VALUES (1, '特大床');
INSERT INTO `y_hotel_bedtype` VALUES (2, '双床');

-- ----------------------------
-- Table structure for y_hotel_order
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel_order`;
CREATE TABLE `y_hotel_order`  (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `room_id` int(10) NULL DEFAULT NULL,
  `user_id` int(10) NULL DEFAULT NULL,
  `endprice` decimal(10, 2) NULL DEFAULT NULL,
  `staytime` datetime(0) NULL DEFAULT NULL,
  `checkouttime` datetime(0) NULL DEFAULT NULL,
  `order_number` int(50) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `creattime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel_order
-- ----------------------------
INSERT INTO `y_hotel_order` VALUES (1, 1, 1, 200.00, '2019-09-16 17:33:05', '2019-09-18 17:33:10', 333101, 1, '2019-09-20 10:05:01');
INSERT INTO `y_hotel_order` VALUES (2, 2, 7, 1000.00, '2019-09-19 17:33:05', '2019-09-23 17:33:10', 333102, 0, '2019-09-20 10:05:01');
INSERT INTO `y_hotel_order` VALUES (3, 3, 1, 800.00, '2019-09-16 17:33:05', '2019-09-18 17:33:10', 333103, 1, '2019-09-20 10:05:01');
INSERT INTO `y_hotel_order` VALUES (7, 1, 7, 21000.00, '2019-09-20 00:00:00', '2019-10-24 00:00:00', 448364, 0, '2019-09-20 17:41:21');
INSERT INTO `y_hotel_order` VALUES (8, 1, 7, 1200.00, '2019-09-20 00:00:00', '2019-09-21 00:00:00', 480929, 0, '2019-09-20 17:45:03');
INSERT INTO `y_hotel_order` VALUES (9, 1, 7, 11400.00, '2019-09-20 00:00:00', '2019-10-08 00:00:00', 133132, 0, '2019-09-20 17:52:45');
INSERT INTO `y_hotel_order` VALUES (10, 1, 7, 4800.00, '2019-09-20 00:00:00', '2019-09-27 00:00:00', 316448, 0, '2019-09-20 18:11:02');
INSERT INTO `y_hotel_order` VALUES (11, 18, 1, 10500.00, '2019-09-20 00:00:00', '2019-09-26 00:00:00', 697326, 0, '2019-09-23 14:29:54');
INSERT INTO `y_hotel_order` VALUES (12, 16, 1, 1400.00, '2019-09-23 00:00:00', '2019-09-24 00:00:00', 128907, 1, '2019-09-23 14:49:37');
INSERT INTO `y_hotel_order` VALUES (13, 26, 1, 4400.00, '2019-10-10 00:00:00', '2019-10-31 00:00:00', 475211, 1, '2019-10-12 15:43:39');

-- ----------------------------
-- Table structure for y_hotel_remark
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel_remark`;
CREATE TABLE `y_hotel_remark`  (
  `remark_id` int(10) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `remark_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark_stars` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`remark_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel_remark
-- ----------------------------
INSERT INTO `y_hotel_remark` VALUES (1, 1, 1, '超赞', NULL, 5);

-- ----------------------------
-- Table structure for y_hotel_room
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel_room`;
CREATE TABLE `y_hotel_room`  (
  `room_id` int(10) NOT NULL AUTO_INCREMENT,
  `room_name` int(50) NOT NULL,
  `hotel_id` int(10) NULL DEFAULT NULL,
  `roomgrade_id` int(10) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `vip_price` decimal(10, 2) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `roomType_id` int(10) NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bedType_id` int(11) NULL DEFAULT NULL,
  `room_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel_room
-- ----------------------------
INSERT INTO `y_hotel_room` VALUES (2, 1002, 1, 2, 500.00, 400.00, 1, 4, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 2, '/hotel_jpg/img_5.jpg');
INSERT INTO `y_hotel_room` VALUES (4, 1004, 1, 1, 800.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_2.jpg');
INSERT INTO `y_hotel_room` VALUES (5, 1005, 1, 1, 800.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_3.jpg');
INSERT INTO `y_hotel_room` VALUES (6, 1006, 1, 2, 800.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_2.jpg');
INSERT INTO `y_hotel_room` VALUES (7, 1007, 1, 2, 800.00, 700.00, 1, 2, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_2.jpg');
INSERT INTO `y_hotel_room` VALUES (8, 1008, 1, 1, 2000.00, 700.00, 1, 1, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/img_5.jpg');
INSERT INTO `y_hotel_room` VALUES (9, 1009, 1, 1, 800.00, 700.00, 1, 1, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_3.jpg');
INSERT INTO `y_hotel_room` VALUES (10, 1010, 1, 2, 1200.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/img_1.jpg');
INSERT INTO `y_hotel_room` VALUES (11, 1011, 1, 1, 800.00, 700.00, 1, 2, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/img_5.jpg');
INSERT INTO `y_hotel_room` VALUES (12, 1012, 1, 2, 1300.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_2.jpg');
INSERT INTO `y_hotel_room` VALUES (13, 1013, 1, 1, 800.00, 700.00, 1, 4, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_1.jpg');
INSERT INTO `y_hotel_room` VALUES (14, 1014, 1, 1, 500.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_2.jpg');
INSERT INTO `y_hotel_room` VALUES (15, 1015, 1, 2, 800.00, 700.00, 1, 1, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/property_3.jpg');
INSERT INTO `y_hotel_room` VALUES (16, 1016, 1, 1, 700.00, 700.00, 1, 3, '独卫、空调，客房内部设计现代时尚，宾客可透过宽敞明亮的窗户繁华都市风光或秀丽园林景致', 1, '/hotel_jpg/img_5.jpg');
INSERT INTO `y_hotel_room` VALUES (26, 11111, 1, NULL, 200.00, 180.00, 1, 2, '很软123', 1, '/hotel_jpg/img_5.jpg');
INSERT INTO `y_hotel_room` VALUES (27, 3333, 1, NULL, 4454.00, 5565.00, 1, 2, '5555555', 2, '/hotel_jpg/img_5.jpg');

-- ----------------------------
-- Table structure for y_hotel_roomgrade
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel_roomgrade`;
CREATE TABLE `y_hotel_roomgrade`  (
  `roomgrade_id` int(10) NOT NULL AUTO_INCREMENT,
  `roomgrade_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `privileges_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`roomgrade_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel_roomgrade
-- ----------------------------
INSERT INTO `y_hotel_roomgrade` VALUES (1, '总统套房', 1);
INSERT INTO `y_hotel_roomgrade` VALUES (2, '普通套房', 2);

-- ----------------------------
-- Table structure for y_hotel_roomtype
-- ----------------------------
DROP TABLE IF EXISTS `y_hotel_roomtype`;
CREATE TABLE `y_hotel_roomtype`  (
  `roomType_id` int(10) NOT NULL AUTO_INCREMENT,
  `roomType_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roomType_residue` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`roomType_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_hotel_roomtype
-- ----------------------------
INSERT INTO `y_hotel_roomtype` VALUES (1, '客房', 50);
INSERT INTO `y_hotel_roomtype` VALUES (2, '行政楼层', 50);
INSERT INTO `y_hotel_roomtype` VALUES (3, '套房', 50);
INSERT INTO `y_hotel_roomtype` VALUES (4, '棋牌室', 50);

-- ----------------------------
-- Table structure for y_mcategory
-- ----------------------------
DROP TABLE IF EXISTS `y_mcategory`;
CREATE TABLE `y_mcategory`  (
  `movie_id` int(11) NULL DEFAULT NULL COMMENT '电影id',
  `catepory_id` int(11) NULL DEFAULT NULL COMMENT '类别id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电影—类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_mcategory
-- ----------------------------
INSERT INTO `y_mcategory` VALUES (1, 8);
INSERT INTO `y_mcategory` VALUES (1, 12);
INSERT INTO `y_mcategory` VALUES (1, 16);
INSERT INTO `y_mcategory` VALUES (2, 8);
INSERT INTO `y_mcategory` VALUES (2, 15);
INSERT INTO `y_mcategory` VALUES (2, 17);
INSERT INTO `y_mcategory` VALUES (3, 12);
INSERT INTO `y_mcategory` VALUES (3, 16);
INSERT INTO `y_mcategory` VALUES (3, 26);
INSERT INTO `y_mcategory` VALUES (4, 18);
INSERT INTO `y_mcategory` VALUES (4, 24);
INSERT INTO `y_mcategory` VALUES (5, 18);
INSERT INTO `y_mcategory` VALUES (5, 4);
INSERT INTO `y_mcategory` VALUES (6, 19);
INSERT INTO `y_mcategory` VALUES (6, 27);
INSERT INTO `y_mcategory` VALUES (7, 23);
INSERT INTO `y_mcategory` VALUES (7, 28);
INSERT INTO `y_mcategory` VALUES (7, 18);
INSERT INTO `y_mcategory` VALUES (8, 18);
INSERT INTO `y_mcategory` VALUES (9, 23);
INSERT INTO `y_mcategory` VALUES (9, 25);
INSERT INTO `y_mcategory` VALUES (10, 12);
INSERT INTO `y_mcategory` VALUES (10, 19);
INSERT INTO `y_mcategory` VALUES (10, 18);
INSERT INTO `y_mcategory` VALUES (11, 18);
INSERT INTO `y_mcategory` VALUES (12, 19);
INSERT INTO `y_mcategory` VALUES (12, 12);
INSERT INTO `y_mcategory` VALUES (12, 20);
INSERT INTO `y_mcategory` VALUES (12, 24);

-- ----------------------------
-- Table structure for y_movie
-- ----------------------------
DROP TABLE IF EXISTS `y_movie`;
CREATE TABLE `y_movie`  (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '电影ID',
  `movie_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影名',
  `movie_outline` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电影梗概',
  `premiereDate` date NULL DEFAULT NULL COMMENT '首映日期',
  `toStar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主演',
  `language` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语言',
  `movie_score` double NULL DEFAULT NULL COMMENT '评分',
  `boxOffice` double NULL DEFAULT NULL COMMENT '票房',
  `movie_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`movie_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电影表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_movie
-- ----------------------------
INSERT INTO `y_movie` VALUES (1, '罗小黑战记', '在熙攘的人类世界里，很多妖精隐匿其中，他们与人类相安无事地生活着。猫妖罗小黑因为家园被破坏，开始了它的流浪之旅。这场旅途中惺惺相惜的妖精同类与和谐包容的人类伙伴相继出现，让小黑陷入了两难抉择，究竟何处才是真正的归属？', '2019-09-16', '山新', '中国', 9.4, 2.42, '6.jpg');
INSERT INTO `y_movie` VALUES (2, '诛仙1', '草庙村被屠，少年张小凡（肖战 饰）双亲离世，被青云门大竹峰收留。机缘巧合之下，他习得佛门天音功法，又意外获得魔教法器烧火棍，踏上强者之路的同时，也让他陷入了巨大的危机。至魔法器的现世，与陆雪琪（李沁 饰）、碧瑶（孟美岐 饰）、田灵儿（唐艺昕 饰）三个女生间命运的交错，都让他原本单纯的人生轨迹充满变数。一个勇者驳斥命运的传奇之旅就此展开......', '2019-09-17', '肖战', '中国', 7.7, 3.06, '1.jpg');
INSERT INTO `y_movie` VALUES (3, '名侦探柯南：绀青之拳', '19世纪末，世界上最大的蓝宝石，又名“绀青之拳”，与一艘海盗船一同沉入了新加坡附近的海域。这时，一个当地的亿万富翁找到了蓝宝石，在他计划将其展现在公众面前时，滨海湾金沙酒店发生了一起谋杀案。在案发现场，发现了一张沾有血迹的卡片，这是怪盗基德（山口胜平 配音）的预告函。与此同时，小兰（山崎和佳奈 配音）和园子（松井菜樱子 配音）为了观看空手道锦标赛而来到了新加坡。由于柯南（高山南 配音）没有护照，所以留在日本。然而，由于基德被卷入谋杀案中，需要柯南的帮助，于是强行把柯南带到了新加坡。为了回家，柯南别无选择，只能帮助基德。没有了眼镜、手表，他变装化身当地人，被小兰问及名字的时候，柯南灵机一动谎称自己是平井亚瑟。基德得到消息，说蓝宝石被存放在一个宅邸的地下仓库里。基德潜入宅邸，一切看起来都太过顺利，但其实此处早已设下陷阱。京极真（桧山修之 配音），这位拥有400场不败纪录的空手道高手，正在那里等待基德的到来。', '2019-09-17', '高山南', '日本', 8.8, 1.77, '2.jpg');
INSERT INTO `y_movie` VALUES (4, '攀登者', '1960年，中国登山队向珠峰发起冲刺，完成了世界首次北坡登顶这一不可能的任务。15 年后，方五洲和曲松林在气象学家徐缨的帮助下，带领李国梁、杨光等年轻队员再次挑战世界之巅。迎接他们的将是更加严酷的现实，也是生与死的挑战......', '2019-09-30', '井柏然', '中国', NULL, NULL, '4.jpg');
INSERT INTO `y_movie` VALUES (5, '中国机长', '电影《中国机长》根据2018年5月14日四川航空3U8633航班机组成功处置特情真实事件改编：机组执行航班任务时，在万米高空突遇驾驶舱风挡玻璃爆裂脱落、座舱释压的极端罕见险情，生死关头，他们临危不乱、果断应对、正确处置，确保了机上全部人员的生命安全，创造了世界民航史上的奇迹。', '2019-09-30', '张涵予', '中国', NULL, NULL, '5.jpg');
INSERT INTO `y_movie` VALUES (6, '小小的愿望', '突然患上肌肉萎缩症的高中生高远（彭昱畅 饰），被医生告知时日不多，决心在临死之前完成一个愿望，那就是成为一个真正的男人！得知这个消息的身边两位好兄弟徐浩（王大陆 饰）和张正阳（魏大勋 饰），为了兄弟最后的愿望，不惜一切奋战到底。', '2019-09-13', '王大陆', '中国', 8.6, 1.69, '28.jpg');
INSERT INTO `y_movie` VALUES (7, '巨鳄风暴', '一场猛烈的飓风正在逼近美国佛罗里达州的一座小镇。女主角海莉（卡雅·斯考达里奥 饰）在游泳训练中接到了姐姐的电话，他们的父亲（巴里·佩珀 饰）已经失联多时，她非常担心父亲的安危。海莉不顾撤离命令独自前往父亲家中，并最终在地下室里找到了身受重伤的父亲。洪水暴涨眼看就要将地下室淹没，海莉很快就意识到最可怕的并不是洪水，而是隐藏在水中的致命猛兽——鳄鱼。', '2019-09-12', '卡雅·斯考达里奥', '美国', 7.2, 0.54, '8.jpg');
INSERT INTO `y_movie` VALUES (8, '我和我的祖国', '七位导演分别取材新中国成立70周年以来，祖国经历的无数个历史性经典瞬间。讲述普通人与国家之间息息相关密不可分的动人故事。聚焦大时代大事件下，小人物和国家之间，看似遥远实则密切的关联，唤醒全球华人共同回忆。', '2019-09-30', '黄渤', '中国', NULL, NULL, '7.jpg');
INSERT INTO `y_movie` VALUES (9, '速度与激情：特别行动', '一个是美国外交安全局的忠诚特工、身材魁梧的执法者霍布斯（强森饰），一个是前英国军事特工精英、无法无天的恶棍肖（斯坦森饰）。在2015年的《速度与激情7》中首次对峙之后，两人不论言语还是肢体都冲突不断，一直试图打倒对方。\r\n　　然而，通过高科技进行了基因增强的无政府主义者布里克斯顿（伊德瑞斯·艾尔巴饰）控制了一种可能永远改变人类命运的不为人知的生化武器，并且还打败了一位大胆优秀又特立独行的军情六处特工（曾出演《王冠》的凡妮莎·科比饰）——她恰好是肖的妹妹，为了扳倒这个世界上唯一可能比他们更厉害的敌人，这两个不共戴天的宿敌不得不联手。\r\n　　《速度与激情：特别行动》一片在《速度与激情》系列的宇宙中推开了一扇全新的大门。从洛杉矶到伦敦，从切尔诺贝利的有毒废墟到美丽的南太平洋岛国萨摩亚，本次特别行动席卷全球。\r\n　　该片由大卫·雷奇执导(《死侍2》导演)，由《速度与激情》系列故事的缔造者克里斯·摩根编剧，摩根、强森、斯坦森和海拉姆·加西亚共同担纲制片。丹尼·加西亚、凯利·麦考密克、、史蒂文·查斯曼、伊森·史密斯和安斯利·戴维斯担任监制。', '2019-08-23', '杰森·斯坦森', '英国', 8.8, 13.88, '32.png');
INSERT INTO `y_movie` VALUES (10, '女王的柯基', '雷克斯作为女王的皇家首席狗狗，是一只在白金汉宫过着奢靡生活、备受宠爱的小柯基犬。一次意外让它流落伦敦街头，闯入流浪狗中心，他将如何自我救赎并重返皇宫？一场民间和皇家萌犬的冒险即将上演......', '2019-08-30', '鲁斯蒂·沙克尔福特', '法国', 8.6, 0.15, '33.png');
INSERT INTO `y_movie` VALUES (11, '送我上青云', '盛男（姚晨饰），女，独立上进有追求，渴望真爱却仍孑然一身。一次意外发现自己患上了卵巢癌，需要进行手术，但父亲出轨，母亲幼稚，家庭给不了她可能的支持，她不得不接受一份自己不喜欢的工作去筹手术费。天生骄傲的盛男，在生死关头才发现成年人想生存的体面比想象中还艰难，在一次又一次的希望与绝望中，最终用自己的方式和世界和解。', '2019-08-16', '姚晨', '中国', 8.9, 0.28, '34.png');
INSERT INTO `y_movie` VALUES (12, '愤怒的小鸟2', '十年“欢喜冤家”猪鸟依旧如往常一样“互相拆台”。然而，“不速之客”发射冰球袭击了小鸟岛和猪猪岛，令双方不得不放下芥蒂，小鸟岛昔日英雄胖红联合小鸟伙伴们与曾经的对手“捣蛋猪”雷纳德一行组建了临时联盟，他们将前往全新冰封岛屿上阻止神秘反派的灭世计划。', '2019-08-16', '彼特·丁拉基', '芬兰', 9.1, 1.39, '35.png');

-- ----------------------------
-- Table structure for y_permission
-- ----------------------------
DROP TABLE IF EXISTS `y_permission`;
CREATE TABLE `y_permission`  (
  `permission_id` int(10) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_permission
-- ----------------------------
INSERT INTO `y_permission` VALUES (1, 'user', '用户管理', 1);
INSERT INTO `y_permission` VALUES (2, 'home', '系统首页', 1);
INSERT INTO `y_permission` VALUES (3, 'movies', '电影院管理', 1);
INSERT INTO `y_permission` VALUES (4, 'hotel', '酒店管理', 2);

-- ----------------------------
-- Table structure for y_projection
-- ----------------------------
DROP TABLE IF EXISTS `y_projection`;
CREATE TABLE `y_projection`  (
  `projection_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '放映id',
  `movie_id` int(11) NULL DEFAULT NULL COMMENT '电影id',
  `projection_date` datetime(0) NULL DEFAULT NULL COMMENT '放映时间',
  `hall_id` int(11) NULL DEFAULT NULL COMMENT '影厅id',
  `ticketPrice` double NULL DEFAULT NULL COMMENT '票价',
  `surplus_seat` int(11) NULL DEFAULT NULL COMMENT '剩余座位数',
  PRIMARY KEY (`projection_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '放映表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_projection
-- ----------------------------
INSERT INTO `y_projection` VALUES (1, 1, '2019-09-19 06:30:00', 1, 35, 10);
INSERT INTO `y_projection` VALUES (2, 1, '2019-09-19 13:00:00', 1, 35, 10);
INSERT INTO `y_projection` VALUES (3, 1, '2019-09-20 17:07:00', 2, 35, 10);
INSERT INTO `y_projection` VALUES (4, 3, '2019-09-21 20:30:00', 1, 36, 10);
INSERT INTO `y_projection` VALUES (5, 3, '2019-09-19 10:30:00', 3, 36, 10);

-- ----------------------------
-- Table structure for y_role
-- ----------------------------
DROP TABLE IF EXISTS `y_role`;
CREATE TABLE `y_role`  (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_role
-- ----------------------------
INSERT INTO `y_role` VALUES (1, '管理员');
INSERT INTO `y_role` VALUES (2, '普通用户');
INSERT INTO `y_role` VALUES (3, '至尊用户');

-- ----------------------------
-- Table structure for y_seat
-- ----------------------------
DROP TABLE IF EXISTS `y_seat`;
CREATE TABLE `y_seat`  (
  `seat_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '座位ID',
  `seat_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座位名',
  `hall_id` int(11) NULL DEFAULT NULL COMMENT '影厅ID',
  `seat_state` int(11) NULL DEFAULT NULL COMMENT '座位状态',
  PRIMARY KEY (`seat_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '座位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_seat
-- ----------------------------
INSERT INTO `y_seat` VALUES (1, '1排1座', 1, 0);
INSERT INTO `y_seat` VALUES (2, '1排2座', 1, 0);
INSERT INTO `y_seat` VALUES (3, '1排3座', 1, 0);
INSERT INTO `y_seat` VALUES (4, '1排4座', 1, 0);
INSERT INTO `y_seat` VALUES (5, '1排5座', 1, 0);
INSERT INTO `y_seat` VALUES (6, '2排1座', 1, 0);
INSERT INTO `y_seat` VALUES (7, '2排2座', 1, 0);
INSERT INTO `y_seat` VALUES (8, '2排3座', 1, 0);
INSERT INTO `y_seat` VALUES (9, '2排4座', 1, 0);
INSERT INTO `y_seat` VALUES (10, '2排5座', 1, 0);
INSERT INTO `y_seat` VALUES (11, '1排1座', 2, 0);
INSERT INTO `y_seat` VALUES (12, '1排2座', 2, 0);
INSERT INTO `y_seat` VALUES (13, '1排3座', 2, 0);
INSERT INTO `y_seat` VALUES (14, '1排4座', 2, 0);
INSERT INTO `y_seat` VALUES (15, '1排5座', 2, 0);
INSERT INTO `y_seat` VALUES (16, '2排1座', 2, 0);
INSERT INTO `y_seat` VALUES (17, '2排2座', 2, 0);
INSERT INTO `y_seat` VALUES (18, '2排3座', 2, 0);
INSERT INTO `y_seat` VALUES (19, '2排4座', 2, 0);
INSERT INTO `y_seat` VALUES (20, '2排5座', 2, 0);
INSERT INTO `y_seat` VALUES (21, '1排1座', 3, 0);
INSERT INTO `y_seat` VALUES (22, '1排2座', 3, 0);
INSERT INTO `y_seat` VALUES (23, '1排3座', 3, 0);
INSERT INTO `y_seat` VALUES (24, '1排4座', 3, 0);
INSERT INTO `y_seat` VALUES (25, '1排5座', 3, 0);
INSERT INTO `y_seat` VALUES (26, '2排1座', 3, 0);
INSERT INTO `y_seat` VALUES (27, '2排2座', 3, 0);
INSERT INTO `y_seat` VALUES (28, '2排3座', 3, 0);
INSERT INTO `y_seat` VALUES (29, '2排4座', 3, 0);
INSERT INTO `y_seat` VALUES (30, '2排5座', 3, 0);
INSERT INTO `y_seat` VALUES (31, '1排1座', 4, 0);
INSERT INTO `y_seat` VALUES (32, '1排2座', 4, 0);
INSERT INTO `y_seat` VALUES (33, '1排3座', 4, 0);
INSERT INTO `y_seat` VALUES (34, '1排4座', 4, 0);
INSERT INTO `y_seat` VALUES (35, '1排5座', 4, 0);
INSERT INTO `y_seat` VALUES (36, '2排1座', 4, 0);
INSERT INTO `y_seat` VALUES (37, '2排2座', 4, 0);
INSERT INTO `y_seat` VALUES (38, '2排3座', 4, 0);
INSERT INTO `y_seat` VALUES (39, '2排4座', 4, 0);
INSERT INTO `y_seat` VALUES (40, '2排5座', 4, 0);

-- ----------------------------
-- Table structure for y_user
-- ----------------------------
DROP TABLE IF EXISTS `y_user`;
CREATE TABLE `y_user`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` int(1) NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `phoneNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` int(10) NULL DEFAULT 2,
  `salt_value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `status` int(1) NULL DEFAULT 1,
  `user_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` decimal(10, 2) NULL DEFAULT NULL,
  `new_column` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_user
-- ----------------------------
INSERT INTO `y_user` VALUES (1, 'uuu', 0, 'fbee824ee24019b98b7da8eb689898cc', '2019-01-01 00:10:00', '666', 1, '2333', '2019-10-12 15:40:59', 1, NULL, NULL, NULL);
INSERT INTO `y_user` VALUES (8, '周先民', NULL, '1692f6417dd7aa593959e6cf390d1fce', NULL, '18879697413', 1, '754107', '2019-09-21 16:48:36', 1, NULL, NULL, NULL);
INSERT INTO `y_user` VALUES (9, '123', NULL, 'f08e4bc833cb8c6883157aff2e49f59f', NULL, '18397817724', 2, '135361', '2019-09-23 11:28:56', 1, NULL, NULL, NULL);
INSERT INTO `y_user` VALUES (13, '233', NULL, '35639a675fe9e9d82c7c6eb1f3b90a11', NULL, '17770568622', 2, '867479', NULL, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for y_user_card
-- ----------------------------
DROP TABLE IF EXISTS `y_user_card`;
CREATE TABLE `y_user_card`  (
  `card_id` int(10) NOT NULL AUTO_INCREMENT,
  `card_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_user_card
-- ----------------------------
INSERT INTO `y_user_card` VALUES (1, '会员卡');
INSERT INTO `y_user_card` VALUES (2, '至尊卡');

-- ----------------------------
-- Table structure for y_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `y_user_permission`;
CREATE TABLE `y_user_permission`  (
  `role_id` int(10) NULL DEFAULT NULL,
  `permission_id` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_user_permission
-- ----------------------------
INSERT INTO `y_user_permission` VALUES (1, 1);

-- ----------------------------
-- Table structure for y_user_role
-- ----------------------------
DROP TABLE IF EXISTS `y_user_role`;
CREATE TABLE `y_user_role`  (
  `user_id` int(10) NULL DEFAULT NULL,
  `role_id` int(10) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of y_user_role
-- ----------------------------
INSERT INTO `y_user_role` VALUES (1, 1);
INSERT INTO `y_user_role` VALUES (8, 1);

SET FOREIGN_KEY_CHECKS = 1;
