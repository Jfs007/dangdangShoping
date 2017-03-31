SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dangdang` DEFAULT CHARACTER SET utf8 ;
USE `dangdang` ;

-- -----------------------------------------------------
-- Table `dangdang`.`d_user` 用户信息表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_user` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(50) NOT NULL ,
  `nickname` VARCHAR(50) NULL DEFAULT NULL ,
  `password` VARCHAR(50) NOT NULL ,
  `user_integral` INT(12) NOT NULL DEFAULT '0' ,
  `is_email_verify` CHAR(3) NULL DEFAULT NULL ,
  `email_verify_code` VARCHAR(50) NULL DEFAULT NULL ,
  `last_login_time` BIGINT(20) NULL DEFAULT NULL ,
  `last_login_ip` VARCHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email` (`email` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

/*Data for the table `d_user` */

insert  into `d_user`(`id`,`email`,`nickname`,`password`,`user_integral`,`is_email_verify`,`email_verify_code`,`last_login_time`,`last_login_ip`) values 
(1,'caofeng2012@126.com','当当小锋','X7J17fvELYRAVJhXfGNRag==',10,'T','07b61776-7f04-4fcc-b4da-22542b6578c0',1367651563576,'0:0:0:0:0:0:0:1');


-- -----------------------------------------------------
-- Table `dangdang`.`d_book` 图书信息表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_book` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `author` VARCHAR(200) NOT NULL ,
  `publishing` VARCHAR(200) NOT NULL ,
  `publish_time` BIGINT(20) NOT NULL ,
  `word_number` VARCHAR(15) NULL DEFAULT NULL ,
  `which_edtion` VARCHAR(15) NULL DEFAULT NULL ,
  `total_page` VARCHAR(15) NULL DEFAULT NULL ,
  `print_time` BIGINT(20) NULL DEFAULT NULL ,
  `print_number` VARCHAR(15) NULL DEFAULT NULL ,
  `isbn` VARCHAR(25) NULL DEFAULT NULL ,
  `author_summary` TEXT NOT NULL ,
  `catalogue` TEXT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


/*Data for the table `d_book` */

insert  into `d_book`(`id`,`author`,`publishing`,`publish_time`,`word_number`,`which_edtion`,`total_page`,`print_time`,`print_number`,`isbn`,`author_summary`,`catalogue`) values 
(1,'莫言','上海文艺出版社',1338480000000,'542000','1','621',1338480000000,'1','9787532142750','莫言，山东高密人，1955年生。著有《红高粱家族》、《酒国》、《丰乳肥臀》、《檀香刑》、《生死疲劳》、《蛙》等长篇小说十一部','新版自序 第一卷 第二卷 第三卷 第四卷 第五卷 第六卷 第七卷 卷外卷 拾遗补阙'),
(2,'路遥','北京十月文艺出版社',1330531200000,'1100000','2','480',1330531200000,'1','9787530212004','路遥（1949-1992）原名王卫国，1949年12月3日生于陕西榆林市清涧县一个贫困的农民家庭，7岁时因为家里困难被过继给延川县农村的伯父','第一部 第二部 第三部'),
(3,'陈忠实','北京十月文艺出版社',1314806400000,'526000','1','322',1314806400000,'1','9787530210116','陈忠实是我国当代著名作家，任中国作家协会副主席，《白鹿原》是其成名著作','第一部 第二部 第三部'),
(4,'季良','珠海出版社',1262275200000,'350000','1','331',1262275200000,'1','9787545303261','季良，男，土家族，大学文化，1959年2月出生于湖南慈利的知识分子家庭','01、孤男寡女 02、心猿意马 03、女人的魅力 04、弥天大谎'),
(5,'南派三叔','北京联合出版公司',1343750400000,'277000','1','262',1343750400000,'1','9787550209459','南派三叔，本名徐磊，男，浙江人，现居杭州。被称为中国最会讲故事的小说家，激荡想象力剧情的推崇者','第一章  起源  第二章  第一件怪事（上）第三章  第一件怪事（下）'),
(6,'姜戎','长江文艺出版社',1080748800000,'511000','1','408',1080748800000,'1','9787535427304','姜戎，58岁。北京人。北京某大学研究人员。主业：政治经济学，偏重政治学方面','编者荐言 我们是龙的传人还是狼的传人？正文 理性探掘——关于狼图腾的讲座与对话'),
(7,'张小娴','北京十月文艺出版社',1349020800000,'130000','1','256',1349020800000,'1','9787530212547','张小娴，华语文坛最耀眼的名字。迄今已出版超过四十本小说和散文集，独创了一种既温柔又犀利的爱情文学','自序  第一章 那些少年的岁月  第二章 恋人的感觉'),
(8,'莫言','上海文艺出版社',1349020800000,'274000','1','331',1349020800000,'1','9787532146314','莫言，先后毕业于解放军艺术学院文学系（1984－1986）和北京师范大学?鲁迅文学院研究生班（1989－1991），获文艺学硕士学位','第一章 第二章 第三章'),
(9,'二月河','长江文艺出版社',1251734400000,'337000','1','223',1251734400000,'1','9787535440556','二月河：本名凌解放。当代著名历史小说作家。现为中国作家协会会员，河南省作家协会副主席','第一回 皇阿哥怜贫护盐贩　桐城令断案打奸商第二回 理河工贝勒榨藩台 探世情阿哥淋澡汤　第三回 十三郎仗义救风尘　八阿哥串连说人情'),
(10,'路遥','北京十月文艺出版社',1330531200000,'144000','2','248',1330531200000,'1','9787530211564','路遥（1949—1992）原名王卫国，1949年12月3日生于陕西榆林市清涧县一个贫困的农民家庭，7岁时因为家里困难被过继给延川县农村的伯父','第一章 第二章 第三章'),
(11,'余华','作家出版社',1343750400000,'136000','3','191',1343750400000,'28','9787506365437','余华，1960年4月3日生于浙江杭州，曾经从事过5年的牙医工作，1983年开始写作，已经完成长篇小说4部，中短篇小说集6部，随笔集3部，其作品被翻译成二十多种文字，在近三十个国家出版','中文版自序 韩文版自序 外文版评论摘要'),
(12,'钱钟书','人民文学出版社',665337600000,'254000','2','362',1338480000000,'1','9787020090006','钱钟书，原名仰先，字默存，号槐聚，曾用笔名中书君，中国现代著名作家、文学研究家。曾为《毛泽东选集》英文版翻译小组成员','序 围城 附录 记钱钟书与《围城》——杨绛'),
(13,'蔡东藩','上海科学技术文献出版社',1122825600000,'6240000','1','1100',1122825600000,'1','9211342','蔡东藩（1877-1945），浙江萧山人。1890年（光绪十六年）考中秀才。1910年赴北京朝考得中，分发福建，以知县候补，因不满官场恶习，于1911年称病归里','第一回 移花接木计献美姬 用李代桃欢承淫后  第二回 诛假父纳言迎母 称皇帝立法愚民 '),
(14,'沈从文','北京十月文艺出版社',1214841600000,'411000','1','464',1214841600000,'1','9787530209455','沈从文（1902－1988），原名沈岳焕，字崇文。湖南凤凰县人.沈从文是现代著名作家、历史文物研究家、京派小说代表人物','渔 三三 虎雏 黔小景'),
(15,'曲波','人民文学出版社',1104508800000,'400000','3','526',1104508800000,'1','9787020049110','曲波（1923-2002），山东龙口人。1938年参加八路军，曾任连、营指挥员。解入军战争时期曾率领解入军小分队在东北牧丹江一带进行剿匪战斗','一 血债  二 许大马棒和蝴蝶迷 三 受命'),
(16,'许开祯','凤凰出版社',1333209600000,'280000','1','283',1333209600000,'1','9787550611597','许开祯，甘肃省文学院签约作家，曾任政府秘书、乡企厂长、大型企业集团副总经理，身在官场数十年。2002年开始走上专业创作之路，代表作有《省委班子》《拿下》《打黑》《政法书记》《黑手》等作品','第一章　绕不过去的12·1 第二章　南湖再起血斗 第三章　沙尘暴来了'),
(17,'都梁','北京联合出版公司',1338480000000,'420000','1','412',1335801600000,'1','9787550206885','都梁，上世纪50年代生人，因出版《亮剑》《血色浪漫》《狼烟北平》和《荣宝斋》而蛮声文坛。四部小说均被改编成同名电视剧，其中《亮剑》和《血色浪漫》红遍大江南北，《狼烟北平》和《荣宝斋》在北京地区极受欢迎。','第一章 第二章 第三章'),
(18,'鲁迅','译林出版社',1330531200000,'190000','1','287',1330531200000,'1','9787544724241','鲁迅(1881-1936)，文学家、思想家和革命家。原名周树人，字豫才，浙江绍兴人。著有小说集《呐喊》、《彷徨》、《故事新编》，散文集《朝花夕拾》，散文诗集《野草》，杂文集《坟》、《热风》、《华盖集》、《南腔北凋集》、《且介亭杂文》等。','自序 狂人日记 孔乙己'),
(19,'林语堂','陕西师范大学出版社',1120147200000,'13000','1','611',1120147200000,'1','9787561334386','林语堂（1895年10月3日—1976年3月26日）福建龙溪人。原名和乐，后改玉堂，又改语堂。1912年入上海圣约翰大学，毕业后在清华大学任教。1919年秋赴美哈佛大学文学系。1922年获文学硕士学位。同年转赴德国入莱比锡大学，专攻语言学','第一章 后花园富翁埋珠宝 北京城百姓避兵灾  第二章 遇乱兵骨肉失散 贴告白沿路寻人 '),
(20,'苏青','中国妇女出版社',1251734400000,'200000','1','260',1251734400000,'1','9787802037663','苏青（1914年～1982年） 中国作家，小说家、散文家、剧作家。是与张爱玲齐名的海派女作家的代表人物。浙江宁波人。1933年考入国立中央大学（1949年更名为南京大学）外文系，后肄业移居上海。','第一章　新旧合璧的婚礼 第二章　洞房花烛夜 第三章　风流寡妇'),
(21,'沈从文','天津人民出版社',1262275200000,'200000','1','200',1262275200000,'1','9787201062914','沈从文(1902-1988)，原名沈岳焕，字崇文，湖南凤凰县人。现代著名作家、历史文物研究家、京派小说代表人物，二十世纪最优秀的中国文学家之一。他一生笔耕不辍，著作颇丰，作品结集约有八十多部，是现代作家中成书最多的一位','边城  长河'),
(22,'歧途佳人','中国三峡出版社',1262275200000,'120000','1','100',1262275200000,'1','9787802235915','苏青最好的时候能够做到一种“天涯若比邻”的广大亲切，唤起了古往今来无所不在的妻性母性的回忆……','一、邂逅 二、姊姊在青岛 三、其言也善？ '),
(23,'都梁','人民文学出版社',1183219200000,'601000','1','544',1183219200000,'1','9787020061211','都梁，50年代出生，做过教师、公务员、公司经理，本名张煐、石油勘探技术研究所所长，现为自由撰稿人。2000年1月出版长篇小说《亮剑》。同名电视连续剧由海润影视传播忪司拍摄。2001年12月发表26集电视连续剧剧本《血色浪漫》，由润亚影视传播有限公司拍摄。','第一章 第二章 第三章'),
(24,'张爱玲','北京十月文艺出版社',1254326400000,'252000','1','351',1254326400000,'1','9787530210055','张爱玲，中国现代作家。张爱玲的家世显赫，祖父张佩纶是清末名臣，祖母李菊耦是朝廷重臣李鸿章的长女。张爱玲一生创作大量文学作品，她的书信也被人们作为著作的一部分加以研究','第一回 赵朴斋咸瓜街访舅 洪善卿聚秀堂做媒 第二回 小伙子装烟空一笑 清倌人吃酒枉相讥');


-- -----------------------------------------------------
-- Table `dangdang`.`d_category` 产品类别信息表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_category` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `turn` INT(10) NOT NULL ,
  `en_name` VARCHAR(200) NOT NULL ,
  `name` VARCHAR(200) NOT NULL ,
  `description` VARCHAR(200) NULL DEFAULT NULL ,
  `parent_id` INT(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 44
DEFAULT CHARACTER SET = utf8;

/*Data for the table `d_category` */

INSERT INTO d_category VALUES (1,1,'Book','图书',NULL,0);
INSERT INTO d_category VALUES (2,1,'Novel','小说',NULL,1);
INSERT INTO d_category VALUES (3,2,'Youth','青春',NULL,1);
INSERT INTO d_category VALUES (4,3,'Humanity And Social Science','人文社科',NULL,1);
INSERT INTO d_category VALUES (5,4,'Management','管理',NULL,1);
INSERT INTO d_category VALUES (6,5,'Children','少儿',NULL,1);
INSERT INTO d_category VALUES (7,6,'Foreign Language','外语',NULL,1);
INSERT INTO d_category VALUES (8,7,'Computer','计算机',NULL,1);
INSERT INTO d_category VALUES (9,1,'Chinese Contemporary Novel','当代小说',NULL,2);
INSERT INTO d_category VALUES (10,2,'Chinese Modern Novel','近现代小说',NULL,2);
INSERT INTO d_category VALUES (11,3,'Chinese Classical  Novel','古典小说',NULL,2);
INSERT INTO d_category VALUES (12,4,'Four Classic Novels','四大名著',NULL,2);
INSERT INTO d_category VALUES (13,5,'Translated Works','世界名著',NULL,2);
INSERT INTO d_category VALUES (14,1,'School','校园',NULL,3);
INSERT INTO d_category VALUES (15,2,'Love','爱情/情感',NULL,3);
INSERT INTO d_category VALUES (16,3,'Grow Up','叛逆/成长',NULL,3);
INSERT INTO d_category VALUES (17,4,'Fantasy','玄幻',NULL,3);
INSERT INTO d_category VALUES (18,5,'Original','原创',NULL,3);
INSERT INTO d_category VALUES (19,1,'Political','政治',NULL,4);
INSERT INTO d_category VALUES (20,2,'Economic','经济',NULL,4);
INSERT INTO d_category VALUES (21,3,'Law','法律',NULL,4);
INSERT INTO d_category VALUES (22,4,'Philosophy','哲学',NULL,4);
INSERT INTO d_category VALUES (23,5,'History','历史',NULL,4);
INSERT INTO d_category VALUES (24,1,'Commen Management','管理学',NULL,5);
INSERT INTO d_category VALUES (25,2,'Strategic Management','战略管理',NULL,5);
INSERT INTO d_category VALUES (26,3,'Marketing','市场营销',NULL,5);
INSERT INTO d_category VALUES (27,4,'Business History','商业史传',NULL,5);
INSERT INTO d_category VALUES (28,5,'E-Business','电子商务',NULL,5);
INSERT INTO d_category VALUES (29,1,'0-2','0-2岁',NULL,6);
INSERT INTO d_category VALUES (30,2,'3-6','3-6岁',NULL,6);
INSERT INTO d_category VALUES (31,3,'7-10','7-10岁',NULL,6);
INSERT INTO d_category VALUES (32,4,'11-14','11-14岁',NULL,6);
INSERT INTO d_category VALUES (33,5,'Child Literature','儿童文学',NULL,6);
INSERT INTO d_category VALUES (34,1,'English','英语',NULL,7);
INSERT INTO d_category VALUES (35,2,'Japanese','日语',NULL,7);
INSERT INTO d_category VALUES (36,3,'Korean','韩语',NULL,7);
INSERT INTO d_category VALUES (37,4,'Russian','俄语',NULL,7);
INSERT INTO d_category VALUES (38,5,'German','德语',NULL,7);
INSERT INTO d_category VALUES (39,1,'Computer Theory','计算机理论',NULL,8);
INSERT INTO d_category VALUES (40,2,'Database','数据库',NULL,8);
INSERT INTO d_category VALUES (41,3,'Programming','程序设计',NULL,8);
INSERT INTO d_category VALUES (42,4,'Artificial Intelligence','人工智能',NULL,8);
INSERT INTO d_category VALUES (43,5,'Computer Examination','计算机考试',NULL,8);

-- -----------------------------------------------------
-- Table `dangdang`.`d_product` 产品基本信息表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_product` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `product_name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(100) NULL DEFAULT NULL ,
  `add_time` BIGINT(20) NULL DEFAULT NULL ,
  `fixed_price` DOUBLE NOT NULL ,
  `dang_price` DOUBLE NOT NULL ,
  `keywords` VARCHAR(200) NULL DEFAULT NULL ,
  `has_deleted` INT(1) NOT NULL DEFAULT '0' ,
  `product_pic` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_d_product_d_book1`
    FOREIGN KEY (`id` )
    REFERENCES `dangdang`.`d_book` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;

/*Data for the table `d_product` */

insert  into `d_product`(`id`,`product_name`,`description`,`add_time`,`fixed_price`,`dang_price`,`keywords`,`has_deleted`,`product_pic`) values 
(1,'丰乳肥臀','《丰乳肥臀》是莫言早期创作中的一座高峰,小说从抗日战争一直写到新中国改革开放之后，以汪洋恣肆的笔触对波澜壮阔的历史进行了描绘。',1351923203963,48,33.6,'莫言',0,'16.jpg'),
(2,'平凡的世界','茅盾文学奖皇冠上的明珠激励千万青年的不朽经典',1351923103969,79.8,59.8,'不朽经典',0,'17.jpg'),
(3,'白鹿原','茅盾文学奖获奖经典作品，权威未删节平装版',1351924103969,32,22,'白鹿原',0,'18.jpg'),
(4,'副省长夫人','常务副省长穆桑俞的舅子、云雾县的代理县长邱俊辉偷情，事后女孩控告他强奸，因为她的手指甲上沾着他的血液．铁证如山',1351924303961,29.8,14.9,'官场腐败',0,'19.jpg'),
(5,'藏海花','南派三叔2012新作《藏海花》：《盗墓笔记》前传，闷油瓶的盗墓传奇！流潋紫倾心推荐',1351928503963,32.8,20.4,'盗墓笔记',0,'20.jpg'),
(6,'狼图腾','这是世界上迄今为止惟一一部描绘、研究蒙古草原狼的“旷世奇书”。阅读此书，将是我们这个时代享用不尽的关于狼图腾的精神盛宴',1351928513967,32,24,'狼图腾',0,'21.jpg'),
(7,'面包树上的女人','张小娴都市爱情小说经典代表作，面包树三部曲之一',1351927503960,28,19.6,'都市爱情',0,'22.jpg'),
(8,'天堂蒜薹之歌','2012年度诺贝尔文学奖获得者，中国著名作家莫言十一部长篇小说完整集结，重磅亮相',1351927203967,33,23.1,'诺贝尔',0,'23.jpg'),
(9,'康熙大帝','这一卷主要描写康熙晚年选择皇储以及众阿哥为争当皇储勾心斗角的故事',1351827502960,110,77,'历史帝王',0,'24.jpg'),
(10,'人生','影响千万青年的励志名篇-- 马云、贾樟柯倾情推荐',1351827500960,25,18.7,'人生哲理',0,'2.jpg'),
(11,'活着','《活着》是一部充满血泪的小说。余华通过一位中国农民的苦难生活讲述了人如何去承受巨大的苦难；讲述了眼泪的丰富和宽广',1351827500060,20,14.4,'余华小说',0,'3.jpg'),
(12,'围城','钱锺书所著的《围城》是一幅栩栩如生的世井百态图，人生的酸甜苦辣千般滋味均在其中得到了淋漓尽致的体现',1351826503061,39,29.3,'围城',0,'4.jpg'),
(13,'中国历代通俗演义','蔡东藩先生的这套《中国历代通俗演义》从秦汉写到民国，全书共一千余回，五百多万字，写了近二千二百年的历史',1351846403051,318,206.7,'中国历史',0,'5.jpg'),
(14,'沈从文集：边城','边城是沈从文小说的代表作，是我国文学史上一部优秀的抒发乡土情怀的中篇小说',1351796403052,29.8,20.6,'纯美爱情',0,'6.jpg'),
(15,'林海雪原','书里所写的是东北民主联军一支小分队，在团参谋长少剑波的率领下，深入林海雪原执行剿匪任务的过程',1351777403052,27,19.7,'剿匪',0,'7.jpg'),
(16,'县委班子','非常有内涵！许开祯经典之作，一本书看清官场里的所有门道',1351796103152,32,22.1,'官场现形',0,'8.jpg'),
(17,'荣宝斋','都梁家国四部曲之四，根据真实故事创作而成，讲述“家族奋斗”创造商业传奇的鸿篇巨作',1351396103156,36,23,'都梁小说',0,'9.jpg'),
(18,'鲁迅－呐喊·彷徨','重读鲁迅文字，体会他对现实社会与人生的冷峻刻画，感受他对旧礼教和国民性的深刻批判',1351386113156,26.8,16.3,'鲁迅',0,'10.jpg'),
(19,'京华烟云(林语堂著)','《京华烟云》是林语堂旅居巴黎时于1938年8月至1939年8月间用英文写就的长篇小说，并题献给“英勇的中国士兵”',1351385223156,43,29.3,'林语堂',0,'11.jpg'),
(20,'结婚十年','她和张爱玲是中国孤岛时期荒芜文坛上并列的奇葩，这是一本畅销中国半个世纪的长篇小说',1351355113167,26,15.9,'爱情',0,'12.jpg'),
(21,'边城.长河','沈从文小说是中国现代小说的典范。本书收入最能代表沈从文艺术水平的中篇小说《边城》和长篇小说《长河》',1351455913167,25,18.8,'沈从文',0,'13.jpg'),
(22,'歧途佳人','这篇小说是苏青以自己的婚恋经历和理想破灭过程为背景，加以耳闻目睹了黑社会里各种尔虞我诈的事件和人性丑恶的一面，再经过提炼而写成',1351475913267,26,16.9,'张爱玲',0,'14.jpg'),
(23,'血色浪漫','没有炮火的年代，一代人的青春挥洒在武斗与呐喊声中，这是他们阳光灿烂的日子，他们的浪漫在血色昏黄中弥漫成昨日的记忆',1351479913266,40,30.3,'浪漫爱情',0,'15.jpg'),
(24,'海上花列传','这部长篇小说的主要内容是写清末中国上海十里洋场中的妓院生活，涉及当时的官场、商界及与之相链接的社会层面。',1351479913267,68,50.8,'最著名的吴语小说',0,'16.jpg');


-- -----------------------------------------------------
-- Table `dangdang`.`d_category_product` 产品类别和产品对应关系表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_category_product` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `product_id` INT(10) NOT NULL ,
  `cat_id` INT(10) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_d_category_product_d_category1_idx` (`cat_id` ASC) ,
  INDEX `fk_d_category_product_d_product1_idx` (`product_id` ASC) ,
  CONSTRAINT `fk_d_category_product_d_category1`
    FOREIGN KEY (`cat_id` )
    REFERENCES `dangdang`.`d_category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_d_category_product_d_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `dangdang`.`d_product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 73
DEFAULT CHARACTER SET = utf8;

/*Data for the table `d_category_product` */

insert  into `d_category_product`(`id`,`product_id`,`cat_id`) values 
(1,1,9),(2,2,9),(3,3,9),(4,4,9),(5,5,9),(6,6,9),(7,7,9),(8,8,9),(9,9,9),(10,10,9),(11,11,10),(12,12,10),
(13,13,10),(14,14,10),(15,15,10),(16,16,10),(17,17,10),(18,18,10),(19,19,10),(20,20,10),(21,21,10),(22,22,10),
(23,23,10),(24,24,10),(25,1,2),(26,2,2),(27,3,2),(28,4,2),(29,5,2),(30,6,2),(31,7,2),(32,8,2),(33,9,2),
(34,10,2),(35,11,2),(36,12,2),(37,13,2),(38,14,2),(39,15,2),(40,16,2),(41,17,2),(42,18,2),(43,19,2),(44,20,2),
(45,21,2),(46,22,2),(47,23,2),(48,24,2),(49,1,1),(50,2,1),(51,3,1),(52,4,1),(53,5,1),(54,6,1),(55,7,1),(56,8,1),
(57,9,1),(58,10,1),(59,11,1),(60,12,1),(61,13,1),(62,14,1),(63,15,1),(64,16,1),(65,17,1),(66,18,1),(67,19,1),(68,20,1),
(69,21,1),(70,22,1),(71,23,1),(72,24,1);




-- -----------------------------------------------------
-- Table `dangdang`.`d_order` 订单信息表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_order` (
  `id` INT(10) NOT NULL AUTO_INCREMENT ,
  `user_id` INT(10) NOT NULL ,
  `status` INT(10) NOT NULL ,
  `order_time` BIGINT(20) NOT NULL ,
  `order_desc` VARCHAR(100) NULL DEFAULT NULL ,
  `total_price` DOUBLE NOT NULL ,
  `receive_name` VARCHAR(100) NULL DEFAULT NULL ,
  `full_address` VARCHAR(200) NULL DEFAULT NULL ,
  `postal_code` VARCHAR(8) NULL DEFAULT NULL ,
  `mobile` VARCHAR(20) NULL DEFAULT NULL ,
  `phone` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_d_order_d_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_d_order_d_user`
    FOREIGN KEY (`user_id` )
    REFERENCES `dangdang`.`d_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dangdang`.`d_item`订单明细表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_item` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `order_id` INT(10) NOT NULL ,
  `product_id` INT(10) NOT NULL ,
  `product_name` VARCHAR(100) NOT NULL ,
  `dang_price` DOUBLE NOT NULL ,
  `product_num` INT(10) NOT NULL ,
  `amount` DOUBLE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_d_item_d_order1_idx` (`order_id` ASC) ,
  INDEX `fk_d_item_d_product1_idx` (`product_id` ASC) ,
  CONSTRAINT `fk_d_item_d_order1`
    FOREIGN KEY (`order_id` )
    REFERENCES `dangdang`.`d_order` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_d_item_d_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `dangdang`.`d_product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dangdang`.`d_receive_address`用户地址信息表
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dangdang`.`d_receive_address` (
  `id` INT(12) NOT NULL AUTO_INCREMENT ,
  `user_id` INT(11) NOT NULL ,
  `receive_name` VARCHAR(20) NOT NULL ,
  `full_address` VARCHAR(200) NOT NULL ,
  `postal_code` VARCHAR(8) NOT NULL ,
  `mobile` VARCHAR(15) NULL DEFAULT NULL ,
  `phone` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_d_receive_address_d_user1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_d_receive_address_d_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `dangdang`.`d_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

/*Data for the table `d_receive_address` */

insert  into `d_receive_address`(`id`,`user_id`,`receive_name`,`full_address`,`postal_code`,`mobile`,`phone`) values (1,1,'曹当当','外星球','123456','12321','110110110');


USE `dangdang` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
