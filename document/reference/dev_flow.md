# mall

## Technology selection

### Back-end technology

technology | 名称 
----|----
Spring Boot | Container + MVC framework
Spring Security | Authentication and authorization framework
MyBatis | ORM framework  
MyBatisGenerator | Data layer code generation  
PageHelper | MyBatis physical paging plugin  
Swagger-UI | Document production tools
Hibernator-Validator | 验证框架
Elasticsearch | search engine
RabbitMq | message queue
Redis | Distributed cache
MongoDb | NoSql database
Docker | Application container engine
Druid | Database connection pool

### Front-end technology

technology | 名称 
----|----
Vue | Front-end framework
Vue-router | Routing framework
Vuex | Global State Management Framework
Element | Front-end UI framework
Axios | Front-end HTTP framework
Js-cookie | cookiemanagementtool

### 框架搭建

功能 | 完成 
----|----
集成MyBatis | ✔
集成MyBatisGenerator | ✔
集成SpringSecurity | ✔
集成Swagger-UI | ✔
集成Hibernator-Validator | ✔
集成日志功能 | ✔
集成监控功能 | ✔
crud操作demo | ✔
合理规划包结构 | ✔
SpringAOP通用日志处理 | ✔
SpringAOP通用验证失败结果返回 | ✔
CommonResult对通用Return result进行封装 | ✔
SpringSecurity登录改为Restful形式 | ✔
JWT登录、注册、获取token | ✔
JTA事务处理 | ✔
集成单元测试 | ✔
OSS上传功能 | ✔
Elasticsearch搜索功能 | ✔
HTTPSSupport | ✔
Redis数字型ID生成 | ✔
SpringTask定时任务Support | ✔
docker容器化部署 | ✔
配置Area分生产和测试环境 | ✔
ELKLog collection功能 | ✔
RabbitMq异步通信 | ✔
RestTemplate服务间调用 | ✔
SpringSecurity权限management功能 | ✔
集成SpringCloud |

### 使用tool

tool | download地址 
----|----
开发toolidea | https://www.jetbrains.com/idea/download
redis客户端连接tool | https://redisdesktop.com/download
mongo客户端连接tool | https://robomongo.org/download
本地hostmanagement | https://oldj.github.io/SwitchHosts/
Linux远程连接tool | http://www.netsarang.com/download/software.html
数据库连接tool | http://www.formysql.com/xiazai.html
数据库设计tool | http://powerdesigner.de/
原型设计tool | https://www.axure.com/
思维导图设计tool | http://www.edrawsoft.cn/mindmaster
gif录制tool | https://www.screentogif.com/

### 后台功能

#### 后台Login function ✔

- 后台User registration功能
- 后台User登录后获取token
- Refresh token功能

#### Product management ✔

> **Categories management**

- 按父分类编号分页查看分类列表
- 添加、编辑、删除分类
- 转移分类商品

> **Commodity brand management**

- 按brand name搜索分页查看Brand list
- 添加、编辑、Remove brand
- 查看当前品牌的所有产品

> **Product attribute classification management**

- Add product attribute classification（名称）
- 分页查询全部商品Attributes分类
- Delete a single product attribute category
- 修改单个Attributes分类名称
- 查询单个Attributes分类信息

> **Product attribute management**

- Query property list or parameter list based on classification（分页，Support类型）
- Add product attributes
- Query a single product attribute
- 编辑商品Attributes
- Delete product attributes in bulk
- 分页查询全部商品Attributes

> **添加商品**

- 选择Product Categories：according toCategory ID查找分类
- 选择品牌：查询全部品牌
- 选择运费模版：查询全部运费模版
- 设置member price：Check all membership levels，传入List<PmsMemberPrice>
- 添加Ladder price: parameter传入List<PmsProductLadder>
- 设置Full discount: parameter传入List<PmsProductFullReduction>
- 选择商品Attributes类别:获取所有商品Attributes分类，according to商品Attributes分类的id获取specification和parameter(type=0->specification；type=1->parameter)
- 选择specification并生成库存信息：前端实现
- Add SKU inventory information：parameter传入List<PmsSkuStock>
- 设置Attributes图片：设置到pic和album_pics字段中去
- 添加商品parameter：parameter传入List<PmsProductAttributeValue>
- 添加自定义商品specification：parameter传入List<PmsProductAttributeValue>
- Related topics:parameter传入List<CmsSubjectProductRelation>关系
- Related preference:parameter传入List<CmsPrefrenceAreaProductRelation>关系

> **修改商品**

- according to商品id查询Product information
- Search for Products基本信息：Product category name、brand name、运费模版名称
- Search for Products促销信息：商品的member price、Ladder price、Full discount
- Search for ProductsAttributes信息：商品Attributes类别名称、sku库存信息、Attributes分类对应specification和parameter值
- Search for ProductsRelated信息：商品Related topics和Related preference
- 修改Product information：商品Attributes分类及specification不可修改，只Support单个sku的修改、删除、新增；商品Attributes分类及specification可以修改：修改后同时Show原sku库存及Attributes分类

> **商品分页查询**

- 商品的status：全部商品、已上架、未上架、待审核、未通过 (publishStatus verifyStatus)
- product name(%name%)
- Product Code(productSn)
- Category ID(productCategoryId)
- Product brandid(brandId)
- 批量操作：上下架、推荐、新品、转移分类、放入回收站、审核
- 查看记录：审核记录，操作日志
- sku:according to产品及sku编号获取sku信息，批量修改sku信息

> **商品回收management**

- 分页展示回收商品列表
- 回收商品还原功能

#### 促销management

> **秒杀活动management**

- 活动列表展示
- 活动上下线
- 设置活动商品
- 添加、编辑、删除活动

> **Coupon management**

- 优惠券列表展示
- 添加、编辑、Delete coupon
- 查看优惠券领取记录

> **活动management**

- 活动列表展示
- 添加、编辑、删除活动
- 活动上下线
- 发布到广告

> **首页推荐**

- 品牌推荐：列表展示、YesNo推荐、Sort、删除、Multiple choice加入品牌
- 新鲜好物：商品列表展示、YesNo推荐、Sort、删除、Multiple choice加入商品
- 人气推荐：商品列表展示、YesNo推荐、Sort、删除、Multiple choice加入商品
- 专题精选：专题列表展示、YesNo推荐、Sort、删除、Multiple choice加入专题
- 广告management：广告列表展示、YesNo上线、Sort、删除、添加编辑广告

#### 内容management

> **专题management**

- 专题列表：查看、删除、推荐专题
- 添加、编辑专题：选择专题分类、添加、Delete association商品
- 专题分类management：控制Show、Sort、编辑删除分类

> **优选主题**

- 优选列表：控制Show、Sort、删除
- 添加、编辑优选：Related和删除商品

> **话题management**

- 专题列表：查看、删除、热门话题
- 话题分类management：控制Show、Sort、编辑删除分类

> **帮助management**

- 帮助列表：查看、删除、控制Show
- 添加、编辑帮助：选择帮助分类
- 帮助分类management：控制Show、Sort、编辑删除分类

#### Usermanagement

> **Usermanagement**

- User列表：帐号Enable、删除、群发短信
- 批量操作：群发短信、站内信、推送、设置标签、赠送优惠券
- 查看、编辑User信息：User详情（统计信息、Shipping address、订单记录）、编辑资料、登录日志
- 购买力筛选：最近消费、消费次数、消费金额、订单均价、Product Categories、Member等级、User标签
- User标签management：标签列表、添加、编辑、删除
- Member等级设置：列表、添加、编辑、设置默认Member等级

> **成才值及积分**

- 成长值及积分查询：列表展示、积分明细、成长值明细、修改数值
- 任务奖励设置：新手任务、日常任务
- 更多规则设置：成长值规则、积分规则、积分消费设置

#### 订单management

> **订单列表**

- 订单搜索：Order Number、Name/number of consignee、Order Status、订单分类、Order source、Submit time
- 订单操作：查看订单、关闭订单、订单发货、订单跟踪、删除订单
- 批量操作：Bulk shipment、关闭订单、删除订单

> **查看订单**

- Order Status：提交订单、支付订单、平台发货、确认收货、完成评价
- 订单详情操作：修改发票信息、Modify consignee information、修改Product information、Modifying fee information、发送站内信、关闭订单、Memo order、取消订单、订单跟踪、删除订单
- 订单基本信息：order information、优惠信息、User信息
- 发票信息：类型、抬头、内容、收票人信息
- Receiver信息：Receiver、手机号、邮政编码、Shipping address
- Product information：包含商品基本信息
- 费用信息：合计及优惠信息
- 操作信息：Order Status改变记录

> **订单设置**

- Flash Order超时时间
- Normal order超时时间
- 订单自动完成时间
- 自动结束交易时间
- 自动好评时间

> **退货申请处理**

- 退货申请搜索：Ticket number、Name/number of consignee、处理status、application time、Operator员、Processing time
- 批量操作：删除
- 查看详情：退货商品、服务单信息、Confirm return、Reject returns、确认收货

> **退货The reason设置**

- The reason列表：类型、Sort、YesNoEnable、add time
- 添加、编辑The reason：同上
- 批量操作：删除

#### 权限management ✔

> **权限management**

- 权限management：Add permissions、删除权限、Modify permissions、以树形结构返回权限
- 角色management：Add role、删除角色、更新角色、角色列表、Get the corresponding role permissions、修改相应角色权限
- 成员management：添加、编辑、删除成员、成员列表、为成员分配角色、获取成员角色、分配+-权限、获取权限列表

角色 | 菜单 
----|----
Administrator | 所有菜单权限
运营 | 首页、User、促销、运营、内容
财务 | 首页、统计、财务
美工 | 首页、商品
客服 | 首页、商品、订单

### 前台功能

#### 商品搜索 ✔

> **综合搜索功能**

- 搜索：according to商品标题、副标题、Keywords进行搜索；
- 筛选：未选择分类时聚合搜索结果，选择出现次数最多的分类，选择分类以后可以according to选择分类的筛选字段进行筛选；
- Sort：按新品、销量、价格进行Sort
- 搜索Return result：商品ID、Product picture、名称、副标题、价格、商品销量、新品、商品的parameter、brand name、分类名称
- 接口：从数据库中查询相关数据并导入es,插入（修改）数据接口，删除数据接口
- 品牌分类筛选：according to搜索结果聚合返回品牌、分类及Attributes

> **商品推荐功能**

- 推荐某商品的相关商品、according to该商品的品牌（10）、分类（6）、名称（8）、Keywords（2）、副标题（2）
- according toUser一周浏览记录推荐商品，according toUser搜索记录推荐商品

> **商品热搜功能**

- according toUser搜索记录聚合生成热搜词

> **商品搜索联想功能** 

- according toUser搜索记录聚合生成热搜词

#### 购物流程 ✔

> **购物车** 

- 添加商品到购物车
- 购物车商品列表（Product main picture、product name、商品数量、商品specification）
- 修改购物车中商品数量
- 购物车中商品重选specification
- 购物车中商品删除功能

> **生成确认单** 

- 生成确认单信息：收货信息、Product information、价格信息、发票信息、Payment method
- 选择Shipping address：默认Shipping address
- 选择优惠券及积分抵扣：展示可用优惠券和不可以优惠券
- 计算商品价格：商品合计、运费、优惠券抵扣、积分抵扣、活动优惠
- 选择Payment method：在线支付及货到付款
- 计算应付金额：合计+运费-优惠券抵扣-积分抵扣-活动优惠

> **提交订单** 

- 将确认单信息转化为订单
- 删除购物车中相关商品
- 添加订单到数据库并锁定库存
- 在线支付选择Payment method：Alipay、WeChat、银联、ApplePay

> **支付订单**

- 支付完成后修改Order Status为已支付、扣除库存

> **取消订单（Unpaid情况下）**

- 订单超时后自动取消订单，解除商品库存锁定，返还优惠券，积分

#### Member模块（我的）✔

> **我的关注**

- 关注Brand list：Brand logo、名称、地址、关注数量
- 取消关注功能
- 关注列表展示

> **我的收藏**

- 收藏的商品：Product main picture、名称、卖点、价格、找相似
- 收藏的专题：Main map of the topic、标题、副标题、收藏数、浏览数、评论数
- 收藏的话题：话题主图、标题、副标题、收藏数、浏览数、评论数

> **我的足迹**

- 浏览过的商品：Product main picture、名称、卖点、价格、找相似
- 删除记录功能
- 浏览列表展示

> **Member登录注册**

- Login function：https登录
- Registration function：username、password、手机号、手机验证码
- 获取验证码：后台生成验证码，验证码绑定手机号
- 忘记password：手机号、短信验证码、新password
- Sign out function
