/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : dragon

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-06-30 17:52:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员信息表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('145454545', 'admin3', '123456');
INSERT INTO `admin` VALUES ('145463456', 'admin2', '123456');
INSERT INTO `admin` VALUES ('456421313', 'admin1', '123456');

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `order_number` int(50) NOT NULL,
  `amount` double(50,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='营业管理表';

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('12313', '85858', '1000.00');

-- ----------------------------
-- Table structure for labels
-- ----------------------------
DROP TABLE IF EXISTS `labels`;
CREATE TABLE `labels` (
  `id` varchar(100) NOT NULL,
  `phone_label` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `label` (`phone_label`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机标签表';

-- ----------------------------
-- Records of labels
-- ----------------------------
INSERT INTO `labels` VALUES ('1745454545579123233', 'OPPO');
INSERT INTO `labels` VALUES ('1586350151595843493', 'vivo');
INSERT INTO `labels` VALUES ('1245757498726123277', '三星');
INSERT INTO `labels` VALUES ('1465785154554789767', '华为');
INSERT INTO `labels` VALUES ('1586350980272536385', '坚果');
INSERT INTO `labels` VALUES ('1784848545444174557', '小米');
INSERT INTO `labels` VALUES ('1345646544544453433', '苹果');
INSERT INTO `labels` VALUES ('1586350127696225042', '魅族');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` varchar(50) NOT NULL,
  `phone_type` varchar(255) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `price` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机维修价格管理表';

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1234545477897123133', 'S10', '屏幕问题(更换总成 旧屏回收)', '2899.00');
INSERT INTO `manager` VALUES ('1345646689897778999', '小米10', '内屏显示异常', '1199.00');
INSERT INTO `manager` VALUES ('1454547745654646899', 'S10', '电池更换', '499.00');
INSERT INTO `manager` VALUES ('1456464645654664544', '10plus', '未知错误', '11.56');
INSERT INTO `manager` VALUES ('1585720465802755237', 'S10', '主板维修', '2100.00');
INSERT INTO `manager` VALUES ('1585720465996912555', 'S10', '重装/软件故障', '200.00');
INSERT INTO `manager` VALUES ('1585790735729303271', '小米10', '外屏碎', '999.00');
INSERT INTO `manager` VALUES ('1585790777399768233', 'iPhone11Pro', '内屏显示异常', '2599.00');
INSERT INTO `manager` VALUES ('1585790812949484078', '三星 S10', '内屏显示异常', '1799.00');
INSERT INTO `manager` VALUES ('1585790830830245470', '荣耀10', '内屏显示异常', '399.00');
INSERT INTO `manager` VALUES ('1585817105292333541', '荣耀10', '外屏碎', '299.00');
INSERT INTO `manager` VALUES ('1585817137217162541', '荣耀10', '电池', '99.00');
INSERT INTO `manager` VALUES ('1585817159435971470', '荣耀10', '摄像头', '119.00');
INSERT INTO `manager` VALUES ('1585875840509416453', '三星 S9', '内屏显示异常', '1699.00');
INSERT INTO `manager` VALUES ('1586328755172337335', '6Plus', '内屏显示异常', '2199.00');
INSERT INTO `manager` VALUES ('1586328780480547189', '6Plus', 'Wifi天线', '1399.00');
INSERT INTO `manager` VALUES ('1586331953317307181', 'R11S', '重装调试', '110.00');
INSERT INTO `manager` VALUES ('1586350361132747745', 'X9', '主板维修', '300.00');
INSERT INTO `manager` VALUES ('1586351018728604050', '坚果Pro3', '音响损坏', '520.00');
INSERT INTO `manager` VALUES ('1586404719002925464', '魅族16Pro', '内屏显示异常', '700.00');
INSERT INTO `manager` VALUES ('1586657090292893195', '三星 S10', '外屏碎', '1399.00');
INSERT INTO `manager` VALUES ('1586657412603595462', '小米10', '电池', '169.00');
INSERT INTO `manager` VALUES ('1586657519272868586', '三星 S10', '电池', '177.00');
INSERT INTO `manager` VALUES ('1586673739811890735', '三星 S10', '摄像头', '297.00');
INSERT INTO `manager` VALUES ('1586760640060478547', 'K3', '内屏显示异常', '699.00');
INSERT INTO `manager` VALUES ('1586760646567390652', 'K3', '主板', '399.00');
INSERT INTO `manager` VALUES ('1586760646577697923', 'K3', '摄像头', '169.00');
INSERT INTO `manager` VALUES ('1586760646584203093', 'K3', '听筒', '89.00');
INSERT INTO `manager` VALUES ('1586760646585539855', 'K3', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586760649714602662', 'K3', '电池', '109.00');
INSERT INTO `manager` VALUES ('1586760651016119942', 'K3', '外屏碎', '499.00');
INSERT INTO `manager` VALUES ('1586761373354320682', '三星 S10', '按键', '169.00');
INSERT INTO `manager` VALUES ('1586761408194386323', '三星 S10', '声音', '159.00');
INSERT INTO `manager` VALUES ('1586761436237524502', '三星 S10', '主板', '499.00');
INSERT INTO `manager` VALUES ('1586761453761213041', '三星 S10', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586761681226428188', '三星 S9', '外屏碎', '1299.00');
INSERT INTO `manager` VALUES ('1586761699485969763', '三星 S9', '电池', '179.00');
INSERT INTO `manager` VALUES ('1586761712005921875', '三星 S9', '摄像头', '269.00');
INSERT INTO `manager` VALUES ('1586761724846345223', '三星 S9', '按键', '149.00');
INSERT INTO `manager` VALUES ('1586761736966521017', '三星 S9', '声音', '139.00');
INSERT INTO `manager` VALUES ('1586761747414999222', '三星 S9', '主板', '459.00');
INSERT INTO `manager` VALUES ('1586761755857290014', '三星 S9', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586761970666800937', 'A90', '内屏显示异常', '1299.00');
INSERT INTO `manager` VALUES ('1586761984125995300', 'A90', '外屏碎', '1099.00');
INSERT INTO `manager` VALUES ('1586761994586670747', 'A90', '电池', '159.00');
INSERT INTO `manager` VALUES ('1586762001386664972', 'A90', '摄像头', '189.00');
INSERT INTO `manager` VALUES ('1586762013245152601', 'A90', '按键', '129.00');
INSERT INTO `manager` VALUES ('1586762022826786961', 'A90', '声音', '119.00');
INSERT INTO `manager` VALUES ('1586762037374155813', 'A90', '主板', '399.00');
INSERT INTO `manager` VALUES ('1586762043806172557', 'A90', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586762183252752784', '小米10', '摄像头', '179.00');
INSERT INTO `manager` VALUES ('1586762192092164038', '小米10', '按键', '139.00');
INSERT INTO `manager` VALUES ('1586762200192237995', '小米10', '声音', '189.00');
INSERT INTO `manager` VALUES ('1586762209169713420', '小米10', '主板', '489.00');
INSERT INTO `manager` VALUES ('1586762216600702366', '小米10', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586762484879268572', '小米9', '内屏显示异常', '1099.00');
INSERT INTO `manager` VALUES ('1586762488778382040', '小米9', '外屏碎', '899.00');
INSERT INTO `manager` VALUES ('1586762492949531027', '小米9', '电池', '159.00');
INSERT INTO `manager` VALUES ('1586762497618210675', '小米9', '摄像头', '169.00');
INSERT INTO `manager` VALUES ('1586762507050915913', '小米9', '按键', '179.00');
INSERT INTO `manager` VALUES ('1586762509969235739', '小米9', '声音', '129.00');
INSERT INTO `manager` VALUES ('1586762515458173312', '小米9', '主板', '469.00');
INSERT INTO `manager` VALUES ('1586762516997547517', '小米9', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586762702081469244', '红米k30', '内屏显示异常', '699.00');
INSERT INTO `manager` VALUES ('1586762702492836830', '红米k30', '外屏碎', '599.00');
INSERT INTO `manager` VALUES ('1586762702892936907', '红米k30', '电池', '129.00');
INSERT INTO `manager` VALUES ('1586762703252372119', '红米k30', '摄像头', '119.00');
INSERT INTO `manager` VALUES ('1586762703581287086', '红米k30', '按键', '99.00');
INSERT INTO `manager` VALUES ('1586762704472910134', '红米k30', '声音', '99.00');
INSERT INTO `manager` VALUES ('1586762704753131879', '红米k30', '主板', '299.00');
INSERT INTO `manager` VALUES ('1586762705332402683', '红米k30', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586762807832820347', '荣耀10', '按键', '99.00');
INSERT INTO `manager` VALUES ('1586762812992770371', '荣耀10', '声音', '129.00');
INSERT INTO `manager` VALUES ('1586762822072261011', '荣耀10', '主板', '219.00');
INSERT INTO `manager` VALUES ('1586762828461401178', '荣耀10', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586763070098528576', '华为Mate10', '外屏碎', '1499.00');
INSERT INTO `manager` VALUES ('1586763070455591788', '华为Mate10', '内屏显示异常', '1699.00');
INSERT INTO `manager` VALUES ('1586763076089181451', '华为Mate10', '电池', '219.00');
INSERT INTO `manager` VALUES ('1586763079236149481', '华为Mate10', '摄像头', '239.00');
INSERT INTO `manager` VALUES ('1586763084109696142', '华为Mate10', '按键', '199.00');
INSERT INTO `manager` VALUES ('1586763086537482665', '华为Mate10', '声音', '189.00');
INSERT INTO `manager` VALUES ('1586763089228867438', '华为Mate10', '主板', '599.00');
INSERT INTO `manager` VALUES ('1586763091093684130', '华为Mate10', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586763214763705265', '华为P20', '内屏显示异常', '1299.00');
INSERT INTO `manager` VALUES ('1586763214955771111', '华为P20', '外屏碎', '899.00');
INSERT INTO `manager` VALUES ('1586763217795356035', '华为P20', '电池', '169.00');
INSERT INTO `manager` VALUES ('1586763223403311518', '华为P20', '摄像头', '199.00');
INSERT INTO `manager` VALUES ('1586763226035465739', '华为P20', '按键', '139.00');
INSERT INTO `manager` VALUES ('1586763228175813440', '华为P20', '声音', '149.00');
INSERT INTO `manager` VALUES ('1586763232503417753', '华为P20', '主板', '399.00');
INSERT INTO `manager` VALUES ('1586763234623583535', '华为P20', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586763341759418150', 'iPhone11Pro', '外屏碎', '1699.00');
INSERT INTO `manager` VALUES ('1586763375180271768', 'iPhone11Pro', '摄像头', '599.00');
INSERT INTO `manager` VALUES ('1586763376020989606', 'iPhone11Pro', '电池', '299.00');
INSERT INTO `manager` VALUES ('1586763379451885961', 'iPhone11Pro', '按键', '299.00');
INSERT INTO `manager` VALUES ('1586763382680930780', 'iPhone11Pro', '声音', '399.00');
INSERT INTO `manager` VALUES ('1586763389360610693', 'iPhone11Pro', '主板', '799.00');
INSERT INTO `manager` VALUES ('1586763390971978099', 'iPhone11Pro', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586763910181204874', '6Plus', '电池', '299.00');
INSERT INTO `manager` VALUES ('1586763910413437272', '6Plus', '摄像头', '359.00');
INSERT INTO `manager` VALUES ('1586763910692317100', '6Plus', '按键', '169.00');
INSERT INTO `manager` VALUES ('1586763911132301124', '6Plus', '声音', '249.00');
INSERT INTO `manager` VALUES ('1586763911452855586', '6Plus', '主板', '699.00');
INSERT INTO `manager` VALUES ('1586763912393838506', '6Plus', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1586764050969598961', 'iPhoneXR', '内屏显示异常', '1899.00');
INSERT INTO `manager` VALUES ('1586764051646287916', 'iPhoneXR', '外屏碎', '1299.00');
INSERT INTO `manager` VALUES ('1586764054898117183', 'iPhoneXR', '电池', '239.00');
INSERT INTO `manager` VALUES ('1586764058338371979', 'iPhoneXR', '摄像头', '369.00');
INSERT INTO `manager` VALUES ('1586764060798728995', 'iPhoneXR', '按键', '189.00');
INSERT INTO `manager` VALUES ('1586764065846894426', 'iPhoneXR', '声音', '179.00');
INSERT INTO `manager` VALUES ('1586764070058964412', 'iPhoneXR', '主板', '599.00');
INSERT INTO `manager` VALUES ('1586764072726816238', 'iPhoneXR', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587546089969562575', 'R17', '内屏显示异常', '1099.00');
INSERT INTO `manager` VALUES ('1587546106126227908', 'R17', '外屏碎', '999.00');
INSERT INTO `manager` VALUES ('1587546145631100155', 'R17', '电池', '299.00');
INSERT INTO `manager` VALUES ('1587546145639447569', 'R17', '摄像头', '269.00');
INSERT INTO `manager` VALUES ('1587546145640980470', 'R17', '按键', '169.00');
INSERT INTO `manager` VALUES ('1587546146329264359', 'R17', '声音', '189.00');
INSERT INTO `manager` VALUES ('1587546147074532142', 'R17', '主板', '699.00');
INSERT INTO `manager` VALUES ('1587546147417400978', 'R17', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587546517638972945', 'OPPO R17', '声音', '139.00');
INSERT INTO `manager` VALUES ('1587546517640352720', 'OPPO R17', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587546517641484955', 'OPPO R17', '主板', '599.00');
INSERT INTO `manager` VALUES ('1587546517642586767', 'OPPO R17', '按键', '169.00');
INSERT INTO `manager` VALUES ('1587546517747297199', 'OPPO R17', '摄像头', '399.00');
INSERT INTO `manager` VALUES ('1587546518142295010', 'OPPO R17', '电池', '269.00');
INSERT INTO `manager` VALUES ('1587546519172596801', 'OPPO R17', '外屏碎', '999.00');
INSERT INTO `manager` VALUES ('1587546519788537029', 'OPPO R17', '内屏显示异常', '1099.00');
INSERT INTO `manager` VALUES ('1587546758407483060', 'Find X', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587546761633773931', 'Find X', '外屏碎', '899.00');
INSERT INTO `manager` VALUES ('1587546761635269736', 'Find X', '按键', '179.00');
INSERT INTO `manager` VALUES ('1587546761635656113', 'Find X', '主板', '569.00');
INSERT INTO `manager` VALUES ('1587546761636447320', 'Find X', '声音', '139.00');
INSERT INTO `manager` VALUES ('1587546761637435610', 'Find X', '电池', '239.00');
INSERT INTO `manager` VALUES ('1587546761638246185', 'Find X', '摄像头', '379.00');
INSERT INTO `manager` VALUES ('1587546761900166591', 'Find X', '内屏显示异常', '999.00');
INSERT INTO `manager` VALUES ('1587547408620600160', 'Reno Z', '内屏显示异常', '999.00');
INSERT INTO `manager` VALUES ('1587547408624157849', 'Reno Z', '电池', '239.00');
INSERT INTO `manager` VALUES ('1587547408626428458', 'Reno Z', '外屏碎', '899.00');
INSERT INTO `manager` VALUES ('1587547408696368510', 'Reno Z', '摄像头', '389.00');
INSERT INTO `manager` VALUES ('1587547409093924241', 'Reno Z', '按键', '159.00');
INSERT INTO `manager` VALUES ('1587547409596809632', 'Reno Z', '声音', '129.00');
INSERT INTO `manager` VALUES ('1587547410003504962', 'Reno Z', '主板', '569.00');
INSERT INTO `manager` VALUES ('1587547410469327161', 'Reno Z', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587547673000652572', 'X27', '内屏显示异常', '899.00');
INSERT INTO `manager` VALUES ('1587547681626290745', 'X27', '主板', '539.00');
INSERT INTO `manager` VALUES ('1587547681637658635', 'X27', '按键', '169.00');
INSERT INTO `manager` VALUES ('1587547681638155206', 'X27', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587547688488322850', 'X27', '声音', '149.00');
INSERT INTO `manager` VALUES ('1587547689022665541', 'X27', '摄像头', '389.00');
INSERT INTO `manager` VALUES ('1587547689395615263', 'X27', '电池', '189.00');
INSERT INTO `manager` VALUES ('1587547689797112571', 'X27', '外屏碎', '799.00');
INSERT INTO `manager` VALUES ('1587548093639264664', 'Z5', '内屏显示异常', '699.00');
INSERT INTO `manager` VALUES ('1587548093649154821', 'Z5', '外屏碎', '599.00');
INSERT INTO `manager` VALUES ('1587548093663165581', 'Z5', '电池', '169.00');
INSERT INTO `manager` VALUES ('1587548093665156892', 'Z5', '摄像头', '299.00');
INSERT INTO `manager` VALUES ('1587548093704107166', 'Z5', '按键', '159.00');
INSERT INTO `manager` VALUES ('1587548094444930635', 'Z5', '声音', '149.00');
INSERT INTO `manager` VALUES ('1587548094740731678', 'Z5', '主板', '369.00');
INSERT INTO `manager` VALUES ('1587548095077997922', 'Z5', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587548325121498315', 'iQOO', '内屏显示异常', '899.00');
INSERT INTO `manager` VALUES ('1587548325122740870', 'iQOO', '外屏碎', '799.00');
INSERT INTO `manager` VALUES ('1587548325959659609', 'iQOO', '电池', '219.00');
INSERT INTO `manager` VALUES ('1587548326614371438', 'iQOO', '摄像头', '389.00');
INSERT INTO `manager` VALUES ('1587548327216211652', 'iQOO', '按键', '139.00');
INSERT INTO `manager` VALUES ('1587548344373408569', 'iQOO', '声音', '169.00');
INSERT INTO `manager` VALUES ('1587548344385683749', 'iQOO', '主板', '479.00');
INSERT INTO `manager` VALUES ('1587548344386612189', 'iQOO', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587548984103289350', '魅族16', '内屏显示异常', '899.00');
INSERT INTO `manager` VALUES ('1587548984111431714', '魅族16', '外屏碎', '799.00');
INSERT INTO `manager` VALUES ('1587548984631335310', '魅族16', '电池', '189.00');
INSERT INTO `manager` VALUES ('1587548985328989200', '魅族16', '摄像头', '319.00');
INSERT INTO `manager` VALUES ('1587548985998416648', '魅族16', '按键', '169.00');
INSERT INTO `manager` VALUES ('1587548986575670603', '魅族16', '声音', '159.00');
INSERT INTO `manager` VALUES ('1587548986911698415', '魅族16', '主板', '569.00');
INSERT INTO `manager` VALUES ('1587548992541716138', '魅族16', '重装调试', '0.00');
INSERT INTO `manager` VALUES ('1587549001126621502', '魅族16', '重装调试', '0.00');
INSERT INTO `manager` VALUES ('1587549614609797735', 'iPhoneXS', '按键', '239.00');
INSERT INTO `manager` VALUES ('1587549614610150190', 'iPhoneXS', '摄像头', '689.00');
INSERT INTO `manager` VALUES ('1587549614626822225', 'iPhoneXS', '电池', '329.00');
INSERT INTO `manager` VALUES ('1587549614627572153', 'iPhoneXS', '外屏碎', '1399.00');
INSERT INTO `manager` VALUES ('1587549614933132874', 'iPhoneXS', '声音', '199.00');
INSERT INTO `manager` VALUES ('1587549615237906246', 'iPhoneXS', '主板', '729.00');
INSERT INTO `manager` VALUES ('1587549616470764132', 'iPhoneXS', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587549617108674173', 'iPhoneXS', '内屏显示异常', '1699.00');
INSERT INTO `manager` VALUES ('1587549864882923255', 'iPhoneX', '摄像头', '469.00');
INSERT INTO `manager` VALUES ('1587549864887504836', 'iPhoneX', '按键', '169.00');
INSERT INTO `manager` VALUES ('1587549864888338795', 'iPhoneX', '主板', '699.00');
INSERT INTO `manager` VALUES ('1587549864888782866', 'iPhoneX', '外屏碎', '1099.00');
INSERT INTO `manager` VALUES ('1587549864889275734', 'iPhoneX', '内屏显示异常', '1399.00');
INSERT INTO `manager` VALUES ('1587549864890403519', 'iPhoneX', '电池', '269.00');
INSERT INTO `manager` VALUES ('1587549864950193868', 'iPhoneX', '声音', '199.00');
INSERT INTO `manager` VALUES ('1587549864953261097', 'iPhoneX', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587550304613893370', 'iPhone8', '内屏显示异常', '799.00');
INSERT INTO `manager` VALUES ('1587550304954884448', 'iPhone8', '外屏碎', '699.00');
INSERT INTO `manager` VALUES ('1587550305363967854', 'iPhone8', '电池', '219.00');
INSERT INTO `manager` VALUES ('1587550305689244045', 'iPhone8', '摄像头', '239.00');
INSERT INTO `manager` VALUES ('1587550305992243065', 'iPhone8', '按键', '169.00');
INSERT INTO `manager` VALUES ('1587550309086199458', 'iPhone8', '主板', '569.00');
INSERT INTO `manager` VALUES ('1587550309093585850', 'iPhone8', '声音', '149.00');
INSERT INTO `manager` VALUES ('1587550309094596111', 'iPhone8', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587550467151691796', 'iPhone7', '内屏显示异常', '899.00');
INSERT INTO `manager` VALUES ('1587550467650691971', 'iPhone7', '外屏碎', '799.00');
INSERT INTO `manager` VALUES ('1587550468049770783', 'iPhone7', '电池', '219.00');
INSERT INTO `manager` VALUES ('1587550468465222121', 'iPhone7', '摄像头', '319.00');
INSERT INTO `manager` VALUES ('1587550468866266396', 'iPhone7', '按键', '159.00');
INSERT INTO `manager` VALUES ('1587550469350204988', 'iPhone7', '声音', '149.00');
INSERT INTO `manager` VALUES ('1587550472588837480', 'iPhone7', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587550472589569328', 'iPhone7', '主板', '519.00');
INSERT INTO `manager` VALUES ('1587552251646853406', 'iPhone6s', '内屏显示异常', '599.00');
INSERT INTO `manager` VALUES ('1587552252311398416', 'iPhone6s', '外屏碎', '499.00');
INSERT INTO `manager` VALUES ('1587552252896897808', 'iPhone6s', '电池', '159.00');
INSERT INTO `manager` VALUES ('1587552253160336793', 'iPhone6s', '摄像头', '219.00');
INSERT INTO `manager` VALUES ('1587552254087647719', 'iPhone6s', '按键', '129.00');
INSERT INTO `manager` VALUES ('1587552254330888981', 'iPhone6s', '声音', '139.00');
INSERT INTO `manager` VALUES ('1587552254913450594', 'iPhone6s', '主板', '419.00');
INSERT INTO `manager` VALUES ('1587552255146988013', 'iPhone6s', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587552363630597809', 'iPhone6', '内屏显示异常', '599.00');
INSERT INTO `manager` VALUES ('1587552363935351492', 'iPhone6', '外屏碎', '499.00');
INSERT INTO `manager` VALUES ('1587552364574783733', 'iPhone6', '电池', '159.00');
INSERT INTO `manager` VALUES ('1587552364871882705', 'iPhone6', '摄像头', '199.00');
INSERT INTO `manager` VALUES ('1587552365191828092', 'iPhone6', '按键', '119.00');
INSERT INTO `manager` VALUES ('1587552365630664462', 'iPhone6', '声音', '139.00');
INSERT INTO `manager` VALUES ('1587552366119990191', 'iPhone6', '主板', '389.00');
INSERT INTO `manager` VALUES ('1587552366841178968', 'iPhone6', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587552463510658176', 'iPhoneSE', '外屏碎', '399.00');
INSERT INTO `manager` VALUES ('1587552464003763332', 'iPhoneSE', '电池', '139.00');
INSERT INTO `manager` VALUES ('1587552464409539318', 'iPhoneSE', '摄像头', '189.00');
INSERT INTO `manager` VALUES ('1587552464772495360', 'iPhoneSE', '按键', '119.00');
INSERT INTO `manager` VALUES ('1587552465314149535', 'iPhoneSE', '声音', '129.00');
INSERT INTO `manager` VALUES ('1587552465794631834', 'iPhoneSE', '主板', '399.00');
INSERT INTO `manager` VALUES ('1587552466889494527', 'iPhoneSE', '重装调试', '99.00');
INSERT INTO `manager` VALUES ('1587552468049434381', 'iPhoneSE', '内屏显示异常', '499.00');
INSERT INTO `manager` VALUES ('1593438045655793568', '小米测试', '小米测试', '250.00');

-- ----------------------------
-- Table structure for myimages
-- ----------------------------
DROP TABLE IF EXISTS `myimages`;
CREATE TABLE `myimages` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `myimages` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='图片上传测试表（这个表可以删除）';

-- ----------------------------
-- Records of myimages
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` varchar(255) NOT NULL,
  `notice` varchar(255) DEFAULT NULL,
  `notice_image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告栏表';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1234654544524242524', '上门维修更轻松', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/notice2.png');
INSERT INTO `notice` VALUES ('1585733841505131649', '无接触维修、安全放心', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/notice3.jpg');
INSERT INTO `notice` VALUES ('1585805442336766280', '苹果后盖，抢修大作战', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/notice4.jpg');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` varchar(200) NOT NULL DEFAULT '',
  `user_id` varchar(200) NOT NULL COMMENT '用户id',
  `order_username` varchar(255) NOT NULL,
  `order_phone` varchar(255) NOT NULL,
  `order_amount` double(255,2) NOT NULL,
  `order_detail` text,
  `order_status` varchar(10) NOT NULL DEFAULT '0' COMMENT '0未完成 \n1上门维修 \n2已完成 \n3申请退款 4已退款5已取消',
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单时间',
  `order_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `idx_user_id` (`user_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1586417035303352046', '1586072501207700571', 'Kaikaia', '18898286061', '328.00', '{\"list\":[{\"id\":\"1586328755172337335\",\"phoneType\":\"6Plus\",\"message\":\"Home键损坏\",\"price\":128},{\"id\":\"1586328780480547189\",\"phoneType\":\"6Plus\",\"message\":\"Wifi天线\",\"price\":200}],\"phone\":\"6Plus\",\"address\":\"海南省海口市龙华区国贸大厦2812\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\",\"comment\":\"\"},\"comment\":{\"rate\":5,\"content\":\"阔以的。曾师傅牛批！服务态度也很好.\"}}', '2', '2020-04-09 15:23:55', '测试字符');
INSERT INTO `orders` VALUES ('1586417148209116940', '1586072501207700571', 'Kaikaia', '18898286061', '449.00', '{\"list\":[{\"id\":\"1345646689897778999\",\"phoneType\":\"小米10\",\"message\":\"相机损坏\",\"price\":129},{\"id\":\"1585790735729303271\",\"phoneType\":\"小米10\",\"message\":\"后盖损坏\",\"price\":320}],\"phone\":\"小米10\",\"address\":\"海南省海口市龙华区国贸大厦2812\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"},\"comment\":{\"rate\":1,\"content\":\"差评，服务也太不好了，之前还是看了评论好才下的单。怎么回事？\"}}', '2', '2020-04-09 15:25:48', '测试字符');
INSERT INTO `orders` VALUES ('1586614384302776061', '1586072501207700571', 'Kaikaia', '18898286061', '169.00', '{\"list\":[{\"id\":\"1585817137217162541\",\"phoneType\":\"荣耀10\",\"message\":\"后摄像头镜片\",\"price\":169}],\"phone\":\"荣耀10\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":1,\"content\":\"我的荣耀修的。。。 T-T我都哭了\"}}', '4', '2020-04-11 22:13:04', '测试字符');
INSERT INTO `orders` VALUES ('1586614464937633405', '1586072501207700571', 'Kaikaia', '18898286061', '300.00', '{\"list\":[{\"id\":\"1586350361132747745\",\"phoneType\":\"X9\",\"message\":\"主板维修\",\"price\":300}],\"phone\":\"X9\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":4,\"content\":\"白师傅认真负责的把我手机问题修好了，点赞\"}}', '2', '2020-04-11 22:14:24', '测试字符');
INSERT INTO `orders` VALUES ('1586657972937572735', '1586072501207700571', 'Kaikaia', '18898286061', '520.00', '{\"list\":[{\"id\":\"1586351018728604050\",\"phoneType\":\"坚果Pro3\",\"message\":\"音响损坏\",\"price\":520}],\"phone\":\"坚果Pro3\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":5,\"content\":\"非常感谢师傅把我的坚果给修好了。！\"}}', '2', '2020-04-12 10:19:32', '测试字符');
INSERT INTO `orders` VALUES ('1586659686780935874', '1586072501207700571', 'Kaikaia', '18898286061', '300.00', '{\"list\":[{\"id\":\"1586350361132747745\",\"phoneType\":\"X9\",\"message\":\"主板维修\",\"price\":300}],\"phone\":\"X9\",\"address\":\"海南省海口市龙华区国贸大厦281\"}', '5', '2020-04-12 10:48:06', '');
INSERT INTO `orders` VALUES ('1586666377651954272', '1586072501207700571', 'Kaikaia', '18898286061', '1200.00', '{\"list\":[{\"id\":\"1585790777399768233\",\"phoneType\":\"iPhone11Pro\",\"message\":\"屏幕碎裂\",\"price\":1200}],\"phone\":\"iPhone11Pro\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":4,\"content\":\"4星，还行。\"}}', '2', '2020-04-12 12:39:37', '测试字符');
INSERT INTO `orders` VALUES ('1586666535087250424', '1586072501207700571', 'Kaikaia', '18898286061', '3450.00', '{\"list\":[{\"id\":\"1585790830830245470\",\"phoneType\":\"荣耀10\",\"message\":\"音响失灵\",\"price\":700},{\"id\":\"1585817105292333541\",\"phoneType\":\"荣耀10\",\"message\":\"内屏显示异常\",\"price\":2750}],\"phone\":\"荣耀10\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1324545441442104254\",\"workerName\":\"王师傅\",\"workerPhone\":\"1896666644\",\"workerCard\":\"460003199754541244\"},\"comment\":{\"rate\":4,\"content\":\"王师傅认真负责的把我手机问题修好了，点赞\"}}', '2', '2020-04-12 12:42:15', '测试字符');
INSERT INTO `orders` VALUES ('1586673381921808191', '1586072501207700571', 'Kaikaia', '18898286061', '3450.00', '{\"list\":[{\"id\":\"1585790830830245470\",\"phoneType\":\"荣耀10\",\"message\":\"音响失灵\",\"price\":700},{\"id\":\"1585817105292333541\",\"phoneType\":\"荣耀10\",\"message\":\"内屏显示异常\",\"price\":2750}],\"phone\":\"荣耀10\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":5,\"content\":\"五星好评～\"}}', '4', '2020-04-12 14:36:21', '测试字符');
INSERT INTO `orders` VALUES ('1586757887869401216', '1586757623831862805', 'khl3314', '13002084032', '110.00', '{\"list\":[{\"id\":\"1586331953317307181\",\"phoneType\":\"R11S\",\"message\":\"重装调试\",\"price\":110}],\"phone\":\"R11S\",\"address\":\"广州市白云区春兰花园\"}', '5', '2020-04-13 14:04:47', '');
INSERT INTO `orders` VALUES ('1586758526950643231', '1586757623831862805', 'khl3314', '13002084032', '110.00', '{\"list\":[{\"id\":\"1586331953317307181\",\"phoneType\":\"R11S\",\"message\":\"重装调试\",\"price\":110}],\"phone\":\"R11S\",\"address\":\"广州市白云区春兰花园\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"},\"comment\":{\"rate\":5,\"content\":\"曾师傅技术非常好，很快就解决了我的手机问题，点赞\"}}', '4', '2020-04-13 14:15:26', '测试字符');
INSERT INTO `orders` VALUES ('1586765284381645044', '1586757623831862805', 'khl3314', '13002084032', '2599.00', '{\"list\":[{\"id\":\"1585790777399768233\",\"phoneType\":\"iPhone11Pro\",\"message\":\"内屏显示异常\",\"price\":2599}],\"phone\":\"iPhone11Pro\",\"address\":\"广州市白云区春兰花园\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":5,\"content\":\"白师傅非常棒，没多久就修好了我的手机，舒服\"}}', '2', '2020-04-13 16:08:04', '测试字符');
INSERT INTO `orders` VALUES ('1587346176648742042', '1587346074140791474', 'khl33141', '15626136061', '1199.00', '{\"list\":[{\"id\":\"1345646689897778999\",\"phoneType\":\"小米10\",\"message\":\"内屏显示异常\",\"price\":1199}],\"phone\":\"小米10\",\"address\":\"东莞市寮步镇文昌路1号\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"},\"comment\":{\"rate\":5,\"content\":\"好！非常好！手机修好后马上可以使用了\"}}', '2', '2020-04-20 09:29:36', '测试字符');
INSERT INTO `orders` VALUES ('1587346474088476957', '1587346074140791474', 'khl33141', '15626136061', '4298.00', '{\"list\":[{\"id\":\"1585790777399768233\",\"phoneType\":\"iPhone11Pro\",\"message\":\"内屏显示异常\",\"price\":2599},{\"id\":\"1586763341759418150\",\"phoneType\":\"iPhone11Pro\",\"message\":\"外屏碎\",\"price\":1699}],\"phone\":\"iPhone11Pro\",\"address\":\"东莞市寮步镇文昌路1号\",\"repairInfo\":{\"workerId\":\"1324545441442104254\",\"workerName\":\"王师傅\",\"workerPhone\":\"1896666644\",\"workerCard\":\"460003199754541244\"},\"comment\":{\"rate\":5,\"content\":\"王师傅服务好，效率高，点赞\"}}', '2', '2020-04-20 09:34:34', '测试字符');
INSERT INTO `orders` VALUES ('1587346615708997392', '1587346074140791474', 'khl33141', '15626136061', '3198.00', '{\"list\":[{\"id\":\"1586763070098528576\",\"phoneType\":\"华为Mate10\",\"message\":\"外屏碎\",\"price\":1499},{\"id\":\"1586763070455591788\",\"phoneType\":\"华为Mate10\",\"message\":\"内屏显示异常\",\"price\":1699}],\"phone\":\"华为Mate10\",\"address\":\"东莞市寮步镇文昌路1号\",\"repairInfo\":{\"workerId\":\"1586337896885330669\",\"workerName\":\"白展堂\",\"workerPhone\":\"18898286062\",\"workerCard\":\"460003199702249211\"},\"comment\":{\"rate\":4,\"content\":\"白师傅修的还不错\"}}', '2', '2020-04-20 09:36:55', '测试字符');
INSERT INTO `orders` VALUES ('1587347335997746535', '1587347274057762729', 'sh123', '13005142026', '2138.00', '{\"list\":[{\"id\":\"1586764050969598961\",\"phoneType\":\"iPhoneXR\",\"message\":\"内屏显示异常\",\"price\":1899},{\"id\":\"1586764054898117183\",\"phoneType\":\"iPhoneXR\",\"message\":\"电池\",\"price\":239}],\"phone\":\"iPhoneXR\",\"address\":\"上海市浦东新区港建路1号\",\"repairInfo\":{\"workerId\":\"1586767187519818920\",\"workerName\":\"林师傅\",\"workerPhone\":\"15624239423\",\"workerCard\":\"411684646345498444\"},\"comment\":{\"rate\":5,\"content\":\"技术好，服务到位\"}}', '2', '2020-04-20 09:48:56', '测试字符');
INSERT INTO `orders` VALUES ('1587347523282218640', '1587347274057762729', 'sh123', '13005142026', '1918.00', '{\"list\":[{\"id\":\"1586763070455591788\",\"phoneType\":\"华为Mate10\",\"message\":\"内屏显示异常\",\"price\":1699},{\"id\":\"1586763076089181451\",\"phoneType\":\"华为Mate10\",\"message\":\"电池\",\"price\":219}],\"phone\":\"华为Mate10\",\"address\":\"上海市浦东新区港建路1号\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"},\"comment\":{\"rate\":4,\"content\":\"修的还不错\"}}', '2', '2020-04-20 09:52:03', '测试字符');
INSERT INTO `orders` VALUES ('1587551049087949605', '1456465464544564561', 'dragon1', '18976106570', '2599.00', '{\"list\":[{\"id\":\"1585790777399768233\",\"phoneType\":\"iPhone11Pro\",\"message\":\"内屏显示异常\",\"price\":2599}],\"phone\":\"iPhone11Pro\",\"address\":\"海南省儋州市那大镇\",\"repairInfo\":{\"workerId\":\"1587545071571643856\",\"workerName\":\"孙悟空\",\"workerPhone\":\"15682314566\",\"workerCard\":\"460003021979492112\"},\"comment\":{\"rate\":5,\"content\":\"孙老师维修技术高超，没有半个小时就把内屏故障修理好了\"}}', '2', '2020-04-22 18:24:09', '测试字符');
INSERT INTO `orders` VALUES ('1587553814439964001', '1587347274057762729', 'sh123', '13005142020', '1899.00', '{\"list\":[{\"id\":\"1586764050969598961\",\"phoneType\":\"iPhoneXR\",\"message\":\"内屏显示异常\",\"price\":1899}],\"phone\":\"iPhoneXR\",\"address\":\"上海市浦东新区港建路1号\",\"repairInfo\":{\"workerId\":\"1587545071571643856\",\"workerName\":\"孙悟空\",\"workerPhone\":\"15682314566\",\"workerCard\":\"460003021979492112\"},\"comment\":{\"rate\":4,\"content\":\"孙师傅技术高超，服务态度好，点赞！\"}}', '2', '2020-04-22 19:10:14', '测试字符');
INSERT INTO `orders` VALUES ('1587555113491212558', '1587347274057762729', 'sh123', '13005142020', '1699.00', '{\"list\":[{\"id\":\"1586763341759418150\",\"phoneType\":\"iPhone11Pro\",\"message\":\"外屏碎\",\"price\":1699}],\"phone\":\"iPhone11Pro\",\"address\":\"上海市浦东新区港建路1号\"}', '5', '2020-04-22 19:31:53', '');
INSERT INTO `orders` VALUES ('1587641897142805104', '1587540075080506351', 'khl123', '13002084032', '1799.00', '{\"list\":[{\"id\":\"1585790812949484078\",\"phoneType\":\"三星 S10\",\"message\":\"内屏显示异常\",\"price\":1799}],\"phone\":\"三星 S10\",\"address\":\"广州市白云区京溪南方医院\",\"repairInfo\":{\"workerId\":\"1586767187519818920\",\"workerName\":\"林师傅\",\"workerPhone\":\"15624239423\",\"workerCard\":\"411684646345498444\"},\"comment\":{\"rate\":4,\"content\":\"林师傅时间上有点着急，不过大体上还是弄好了\"}}', '2', '2020-04-23 19:38:17', '测试字符');
INSERT INTO `orders` VALUES ('1587699195723736911', '1587347274057762729', 'sh123', '13005142020', '1799.00', '{\"list\":[{\"id\":\"1585790812949484078\",\"phoneType\":\"三星 S10\",\"message\":\"内屏显示异常\",\"price\":1799}],\"phone\":\"三星 S10\",\"address\":\"上海市浦东新区港建路1号\",\"repairInfo\":{\"workerId\":\"1586767187519818920\",\"workerName\":\"林师傅\",\"workerPhone\":\"15624239423\",\"workerCard\":\"411684646345498444\"},\"comment\":{\"rate\":5,\"content\":\"林师傅修的非常好\"}}', '2', '2020-04-24 11:33:18', '测试字符');
INSERT INTO `orders` VALUES ('1587716096633422305', '1587540075080506351', 'khl123', '13002084032', '1699.00', '{\"list\":[{\"id\":\"1586763341759418150\",\"phoneType\":\"iPhone11Pro\",\"message\":\"外屏碎\",\"price\":1699}],\"phone\":\"iPhone11Pro\",\"address\":\"广州市白云区京溪南方医院\",\"repairInfo\":{\"workerId\":\"1587545071571643856\",\"workerName\":\"孙悟空\",\"workerPhone\":\"15682314566\",\"workerCard\":\"460003021979492112\"},\"comment\":{\"rate\":4,\"content\":\"孙师傅一看就是老江湖了，服务的十分到位，OK的\"}}', '2', '2020-04-24 16:14:56', '测试字符');
INSERT INTO `orders` VALUES ('1587737333698243854', '1587737305732603714', '胶几人', '15678784567', '0.00', '{\"list\":[],\"phone\":\"R17\",\"address\":\"康虹路\",\"repairInfo\":{\"workerId\":\"1324545441442104254\",\"workerName\":\"王师傅\",\"workerPhone\":\"18966666441\",\"workerCard\":\"460003199754541244\"}}', '1', '2020-04-24 22:08:53', '测试字符');
INSERT INTO `orders` VALUES ('1587738169958364191', '1587738118635189309', '啊啊啊啊', '15625782913', '199.00', '{\"list\":[{\"id\":\"1586657519272868586\",\"phoneType\":\"三星 S10\",\"message\":\"电池\",\"price\":199}],\"phone\":\"三星 S10\",\"address\":\"广东省东莞市\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"}}', '4', '2020-04-24 22:22:49', '测试字符');
INSERT INTO `orders` VALUES ('1587738896414998856', '1587540075080506351', 'khl123', '13002084032', '2599.00', '{\"list\":[{\"id\":\"1585790777399768233\",\"phoneType\":\"iPhone11Pro\",\"message\":\"内屏显示异常\",\"price\":2599}],\"phone\":\"iPhone11Pro\",\"address\":\"广州市白云区京溪南方医院\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"},\"comment\":{\"rate\":5,\"content\":\"曾师傅修理过程流畅，速度快，服务好 \"}}', '2', '2020-04-24 22:34:56', '测试字符');
INSERT INTO `orders` VALUES ('1587775068720131360', '1587346074140791474', 'khl3314', '13002084032', '1099.00', '{\"list\":[{\"id\":\"1586762484879268572\",\"phoneType\":\"小米9\",\"message\":\"内屏显示异常\",\"price\":1099}],\"phone\":\"小米9\",\"address\":\"广州市白云区春兰花园\",\"repairInfo\":{\"workerId\":\"1586767187519818920\",\"workerName\":\"林师傅\",\"workerPhone\":\"15624239423\",\"workerCard\":\"411684646345498444\"},\"comment\":{\"rate\":5,\"content\":\"林师傅棒棒哒，支持一下\"}}', '2', '2020-04-25 08:37:48', '测试字符');
INSERT INTO `orders` VALUES ('1587787918365482343', '1587346074140791474', 'khl3314', '13002084032', '899.00', '{\"list\":[{\"id\":\"1587547673000652572\",\"phoneType\":\"X27\",\"message\":\"内屏显示异常\",\"price\":899}],\"phone\":\"X27\",\"address\":\"广州市白云区春兰花园\"}', '5', '2020-04-25 12:11:58', '');
INSERT INTO `orders` VALUES ('1589018566099442556', '1456465464544564561', 'dragon1', '18976106570', '250.00', '{\"list\":[{\"id\":\"1585790777399768233\",\"phoneType\":\"iPhone11Pro\",\"message\":\"内屏显示异常\",\"price\":2599}],\"phone\":\"iPhone11Pro\",\"address\":\"海南省儋州市那大镇\",\"repairInfo\":{\"workerId\":\"1587545071571643856\",\"workerName\":\"孙悟空\",\"workerPhone\":\"15682314566\",\"workerCard\":\"460003021979492112\"},\"comment\":{\"rate\":5,\"content\":\"孙老师维修技术高超，没有半个小时就把内屏故障修理好了\"}}', '5', '2020-05-09 18:02:46', '测试字符');
INSERT INTO `orders` VALUES ('1590336368120474000', '1586072501207700571', 'Kaikaia', '18898286061', '2198.00', '{\"list\":[{\"id\":\"1345646689897778999\",\"phoneType\":\"小米10\",\"message\":\"内屏显示异常\",\"price\":1199},{\"id\":\"1585790735729303271\",\"phoneType\":\"小米10\",\"message\":\"外屏碎\",\"price\":999}],\"phone\":\"小米10\",\"address\":\"海南省海口市龙华区国贸大厦281\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"}}', '1', '2020-05-25 00:06:08', '测试字符');
INSERT INTO `orders` VALUES ('1590336462081666752', '1456465464544564561', 'dragon1', '18976106570', '520.00', '{\"list\":[{\"id\":\"1586351018728604050\",\"phoneType\":\"坚果Pro3\",\"message\":\"音响损坏\",\"price\":520}],\"phone\":\"坚果Pro3\",\"address\":\"海南省儋州市那大镇\",\"repairInfo\":{\"workerId\":\"1237841247824245466\",\"workerName\":\"曾师傅\",\"workerPhone\":\"18976106577\",\"workerCard\":\"460003199601072815\"}}', '1', '2020-05-25 00:07:42', '测试字符');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '唯一标识',
  `product_name` varchar(64) NOT NULL,
  `product_type` varchar(255) NOT NULL,
  `product_image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机产品信息表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1231231234544454669', '三星', '三星 S10', 'http://localhost:8080/images/1593506464083914894.jpg', '2019-12-05 18:40:34', '2020-04-08 22:15:33');
INSERT INTO `product` VALUES ('1234567894564656667', '小米', '小米10', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/MI10.png', '2019-12-05 14:49:17', '2020-04-08 22:15:31');
INSERT INTO `product` VALUES ('1234568884564624577', '华为', '荣耀10', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/荣耀10.png', '2019-12-05 15:23:46', '2020-04-08 22:15:29');
INSERT INTO `product` VALUES ('1456465464646545677', '三星', '三星 S9', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/S9.png', '2020-04-02 22:17:44', '2020-04-08 22:15:29');
INSERT INTO `product` VALUES ('1585664385066711489', '苹果', 'iPhone11Pro', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/iPhone11Pro.png', '2020-03-31 22:19:45', '2020-03-31 22:19:45');
INSERT INTO `product` VALUES ('1586351019611715245', '坚果', '坚果Pro3', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/坚果Pro3.jpg', '2020-04-08 21:03:39', '2020-04-08 21:03:39');
INSERT INTO `product` VALUES ('1586762046198893099', '三星', 'A90', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/c9bc95fccfd5face1e1483ccdcc2bf8d.png', '2020-04-13 15:14:06', '2020-04-13 15:14:06');
INSERT INTO `product` VALUES ('1586762518529176636', '小米', '小米9', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/026655176448cd21bd1e32793d224a6e.png', '2020-04-13 15:21:58', '2020-04-13 15:21:58');
INSERT INTO `product` VALUES ('1586762706272524083', '小米', '红米k30', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/aeac55e102c325f0223fc333f2bb7042.png', '2020-04-13 15:25:06', '2020-04-13 15:25:06');
INSERT INTO `product` VALUES ('1586763092186825403', '华为', '华为Mate10', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/a0ce0d3881a7005a1abf6a5c77990ca9.png', '2020-04-13 15:31:32', '2020-04-13 15:31:32');
INSERT INTO `product` VALUES ('1586763235723741398', '华为', '华为P20', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/e026caa4e6e88de747d8bb869c104219.png', '2020-04-13 15:33:55', '2020-04-13 15:33:55');
INSERT INTO `product` VALUES ('1586764073798403699', '苹果', 'iPhoneXR', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/69e32745e558f3dd1a3eaa4573dfb750.png', '2020-04-13 15:47:53', '2020-04-13 15:47:53');
INSERT INTO `product` VALUES ('1587546151202145456', 'OPPO', 'R17', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/be690a38c3cd0d558311f5c8f74ef3df.png', '2020-04-22 17:02:31', '2020-04-22 17:02:31');
INSERT INTO `product` VALUES ('1587546767129746726', 'OPPO', 'Find X', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/c93971c911d2c5595f11e3696933c1c8.png', '2020-04-22 17:12:47', '2020-04-22 17:12:47');
INSERT INTO `product` VALUES ('1587547416934142172', 'OPPO', 'Reno Z', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/920525de4e669edf67c7854c92d4390c.png', '2020-04-22 17:23:36', '2020-04-22 17:23:36');
INSERT INTO `product` VALUES ('1587547752181333053', 'Vivo', 'X27', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/b757b8f18fef18312ab2e8fd1340a568.png', '2020-04-22 17:29:12', '2020-04-22 17:29:12');
INSERT INTO `product` VALUES ('1587548135827891684', 'Vivo', 'Z5', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/824508c27b7ccbfd11074dab4cb38f02.png', '2020-04-22 17:35:35', '2020-04-22 17:35:35');
INSERT INTO `product` VALUES ('1587548349726644099', 'Vivo', 'iQOO', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/760757750f7db217aff0f8302c877d01.png', '2020-04-22 17:39:09', '2020-04-22 17:39:09');
INSERT INTO `product` VALUES ('1587549001124418431', '魅族', '魅族16', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/333d76d33d9971b7d57f6d224c332798.png', '2020-04-22 17:50:01', '2020-04-22 17:50:01');
INSERT INTO `product` VALUES ('1587549620598289454', '苹果', 'iPhoneXS', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/cda63d9533cbb66995f60040bd792011.png', '2020-04-22 18:00:20', '2020-04-22 18:00:20');
INSERT INTO `product` VALUES ('1587549870448101760', '苹果', 'iPhoneX', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/ae44a1e4dbfae6f81befcac55e040d92.png', '2020-04-22 18:04:30', '2020-04-22 18:04:30');
INSERT INTO `product` VALUES ('1587550315047109101', '苹果', 'iPhone8', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/e44af733f03a29f5a7068f1097e8d0e8.png', '2020-04-22 18:11:55', '2020-04-22 18:11:55');
INSERT INTO `product` VALUES ('1587550475187825568', '苹果', 'iPhone7', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/85c4d0d8ec1d01b67ebfde778d6518c2.png', '2020-04-22 18:14:35', '2020-04-22 18:14:35');
INSERT INTO `product` VALUES ('1587552256266654610', '苹果', 'iPhone6s', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/79d06826ca7280d5e6e1cf0eac1824a5.png', '2020-04-22 18:44:16', '2020-04-22 18:44:16');
INSERT INTO `product` VALUES ('1587552367825970082', '苹果', 'iPhone6', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/a3049cbac8f115790ee318432e73a424.png', '2020-04-22 18:46:07', '2020-04-22 18:46:07');
INSERT INTO `product` VALUES ('1587552474575433976', '苹果', 'iPhoneSE', 'http://kaikai-bloga.oss-cn-beijing.aliyuncs.com/repair/90893ef19165822a336c892eff5a7c70.png', '2020-04-22 18:47:54', '2020-04-22 18:47:54');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `username` char(12) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `money` double(10,2) NOT NULL DEFAULT '0.00',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1456465464544564561', 'dragon1', '1234567890', '海南省儋州市那大镇', '18976106570', '7459.00', '2020-04-02 12:10:41', '2020-04-08 11:02:58');
INSERT INTO `users` VALUES ('1586072501207700571', 'Kaikaia', '666666', '海南省海口市龙华区国贸大厦281', '18898286061', '5530.00', '2020-04-05 15:41:41', '2020-04-05 15:41:41');
INSERT INTO `users` VALUES ('1586673125455313411', '测试', '666666', '测试地址咯', '18898286061', '0.00', '2020-04-12 14:32:05', '2020-04-12 14:32:05');
INSERT INTO `users` VALUES ('1586757623831862805', 'khl3314', '123456', '广州市白云区春兰花园', '13002084032', '9603.00', '2020-04-13 14:00:23', '2020-04-13 14:00:23');
INSERT INTO `users` VALUES ('1587346074140791474', 'khl33141', '123456', '东莞市寮步镇文昌路1号', '15626136061', '1305.00', '2020-04-20 09:27:54', '2020-04-20 09:27:54');
INSERT INTO `users` VALUES ('1587347274057762729', 'sh123', '123456', '上海市浦东新区港建路1号', '13005142020', '246.00', '2020-04-20 09:47:54', '2020-04-20 09:47:54');
INSERT INTO `users` VALUES ('1587540075080506351', 'khl123', '123456', '广州市白云区京溪南方医院', '13002084032', '3903.00', '2020-04-22 15:21:15', '2020-04-22 15:21:15');
INSERT INTO `users` VALUES ('1587737305732603714', '胶几人', '123456', '康虹路', '15678784567', '0.00', '2020-04-24 22:08:25', '2020-04-24 22:08:25');
INSERT INTO `users` VALUES ('1587737675325492648', '按时', '123456', '和见客户见客户房', '123456', '0.00', '2020-04-24 22:14:35', '2020-04-24 22:14:35');
INSERT INTO `users` VALUES ('1587738118635189309', '啊啊啊', '4444', '广东省东莞市', '15625782913', '0.00', '2020-04-24 22:21:58', '2020-04-24 22:21:58');

-- ----------------------------
-- Table structure for workers
-- ----------------------------
DROP TABLE IF EXISTS `workers`;
CREATE TABLE `workers` (
  `worker_id` varchar(255) NOT NULL,
  `worker_name` varchar(50) NOT NULL,
  `worker_phone` varchar(50) NOT NULL,
  `worker_card` varchar(255) NOT NULL,
  `comment` text,
  PRIMARY KEY (`worker_id`),
  UNIQUE KEY `worker_name` (`worker_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修师傅表';

-- ----------------------------
-- Records of workers
-- ----------------------------
INSERT INTO `workers` VALUES ('1237841247824245466', '曾师傅', '18976106577', '460003199601072815', '{\"rate\":4.44,\"list\":[{\"rate\":5.0,\"content\":\"阔以的。曾师傅牛批！服务态度也很好.\"},{\"rate\":1.0,\"content\":\"差评，服务也太不好了，之前还是看了评论好才下的单。怎么回事？\"},{\"rate\":5.0,\"content\":\"曾师傅技术非常好，很快就解决了我的手机问题，点赞\"},{\"rate\":5.0,\"content\":\"好！非常好！手机修好后马上可以使用了\"},{\"rate\":4.0,\"content\":\"修的还不错\"},{\"rate\":5.0,\"content\":\"曾师傅修理过程流畅，速度快，服务好\"},{\"rate\":5.0,\"content\":\"曾师傅修理过程流畅，速度快，服务好\"},{\"rate\":5.0,\"content\":\"曾师傅修理过程流畅，速度快，服务好\"},{\"rate\":5.0,\"content\":\"曾师傅修理过程流畅，速度快，服务好\"}]}');
INSERT INTO `workers` VALUES ('1324545441442104254', '王师傅', '18966666441', '460003199754541244', '{\"rate\":4.5,\"list\":[{\"rate\":4.0,\"content\":\"修的不好\"},{\"rate\":5.0,\"content\":\"王师傅服务好，效率高，点赞\"},{\"rate\":4.0,\"content\":\"王师傅认真负责的把我手机问题修好了，点赞\"},{\"rate\":5.0,\"content\":\"Rrr\"}]}');
INSERT INTO `workers` VALUES ('1586337896885330669', '白展堂', '18898286062', '460003199702249211', '{\"rate\":4.08,\"list\":[{\"rate\":5.0,\"content\":\"还行吧，算是可以的\"},{\"rate\":4.0,\"content\":\"还不错\"},{\"rate\":5.0,\"content\":\"真棒，服务态度真好\"},{\"rate\":3.0,\"content\":\"一般般，修的什么鬼\"},{\"rate\":4.0,\"content\":\"4星，还行。\"},{\"rate\":4.0,\"content\":\"4星，还行。\"},{\"rate\":5.0,\"content\":\"非常感谢师傅把我的坚果给修好了。！\"},{\"rate\":1.0,\"content\":\"我的荣耀修的。。。 T-T我都哭了\"},{\"rate\":5.0,\"content\":\"五星好评～\"},{\"rate\":5.0,\"content\":\"白师傅非常棒，没多久就修好了我的手机，舒服\"},{\"rate\":4.0,\"content\":\"白师傅修的还不错\"},{\"rate\":4.0,\"content\":\"白师傅修的还不错\"},{\"rate\":4.0,\"content\":\"白师傅认真负责的把我手机问题修好了，点赞\"}]}');
INSERT INTO `workers` VALUES ('1586767187519818920', '林师傅', '15624239423', '411684646345498444', '{\"rate\":4.75,\"list\":[{\"rate\":5.0,\"content\":\"技术好，服务到位\"},{\"rate\":4.0,\"content\":\"林师傅时间上有点着急，不过大体上还是弄好了\"},{\"rate\":5.0,\"content\":\"林师傅修的非常好\"},{\"rate\":5.0,\"content\":\"林师傅棒棒哒，支持一下\"}]}');
INSERT INTO `workers` VALUES ('1587545071571643856', '孙悟空', '15682314566', '460003021979492112', '{\"rate\":4.33,\"list\":[{\"rate\":5.0,\"content\":\"孙老师维修技术高超，没有半个小时就把内屏故障修理好了\"},{\"rate\":4.0,\"content\":\"孙师傅技术高超，服务态度好，点赞！\"},{\"rate\":4.0,\"content\":\"孙师傅一看就是老江湖了，服务的十分到位，OK的\"}]}');
INSERT INTO `workers` VALUES ('1593506008223503092', '8585', '5858', '5585', null);
