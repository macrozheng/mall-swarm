# mall

## Technology selection

### Back-end technology

technology | Name 
----|----
Spring Boot | Container + MVC framework
Spring Security | Authentication and authorization framework
MyBatis | ORM framework  
MyBatisGenerator | Data layer code generation  
PageHelper | MyBatis physical paging plugin  
Swagger-UI | Document production tools
Hibernator-Validator | Validation framework
Elasticsearch | search engine
RabbitMq | message queue
Redis | Distributed cache
MongoDb | NoSql database
Docker | Application container engine
Druid | Database connection pool

### Front-end technology

technology | Name 
----|----
Vue | Front-end framework
Vue-router | Routing framework
Vuex | Global State Management Framework
Element | Front-end UI framework
Axios | Front-end HTTP framework
Js-cookie | cookie management tool

### Framework

Features | Completed 
----|----
Integrate MyBatis | ✔
Integrated MyBatisGenerator | ✔
Integrating SpringSecurity | ✔
Integrated Swagger-UI | ✔
Integrated Hibernator-Validator | ✔
Integrated log function | ✔
Integrated monitoring function | ✔
crud operation demo | ✔
Reasonable planning package structure | ✔
SpringAOP general log processing | ✔
SpringAOP general verification failure result returned | ✔
CommonResult encapsulates the common Return result | ✔
SpringSecurity login changed to Restful form | ✔
JWT login, registration, get token | ✔
JTA transaction processing | ✔
Integrated single dollar test | ✔
OSS upload function | ✔
Elasticsearch search function | ✔
HTTPSSupport | ✔
Redis digital ID generation | ✔
SpringTask Timed Task Support | ✔
Docker containerized deployment | ✔
Configuration distinguishes between production and test environments | ✔
ELK log collection function	 | ✔
RabbitMq asynchronous communication | ✔
RestTemplate call | ✔
SpringSecurity permission management function | ✔
Integrate SpringCloud |

### Used tools

tool | download address 
----|----
IntelliJ IDEA | https://www.jetbrains.com/idea/download
redis client connection tool | https://redisdesktop.com/download
mongo client connection tool | https://robomongo.org/download
Local host management | https://oldj.github.io/SwitchHosts/
Linux remote connection tool | http://www.netsarang.com/download/software.html
Database connection tool | http://www.formysql.com/xiazai.html
Database design tool | http://powerdesigner.de/
Prototyping tool | https://www.axure.com/
Mindmap design tool | http://www.edrawsoft.cn/mindmaster
gif recording tool | https://www.screentogif.com/

### Background functions

#### Background login function ✔

- Background user registration function
- Background user gets token after login
- Refresh token function

#### Merchandise management ✔

> **Product classification management**

- View the list of categories by parent category number
- Add, edit, delete categories
- Transfer classified products

> **Product brand management**

- Search by brand name to view brand list
- Add, edit, delete brands
- View all products of the current brand

> **Product attribute classification management**

- Add product attribute classification (name)
- Pagination query all product attribute categories
- Delete a single product attribute category
- Modify a single attribute category name
- Query single attribute classification information

> **Product attribute management**

- Query property list or parameter list according to category (pagination, support type)
- Add product attributes
- Query a single product attribute
- Edit product attributes
- Delete product attributes in bulk
- Paging through all product attributes

> **Adding Products**

- Select a product category: Find a category based on the product category id
- Select brand: query all brands
- Select shipping template: query all shipping templates
- Set Member Price: Query all member levels and pass in List
- Add ladder price: parameter passed in List
- Set full deduction price: parameter passed to List
- Select product attribute category: Get all product attribute categories, get specifications and parameters according to the id of the product attribute category (type = 0-> specification; type = 1-> parameter)
- Select specifications and generate inventory information: front-end implementation
- Add sku inventory information: parameters passed to List
- Set attribute picture: set to pic and album_pics fields
- Add product parameters: parameters passed to List
- Add custom product specifications: parameters passed to List
- Related topics: parameters passed into the List relationship
- Association Optimization: List argument to the relationship

> **Modify product**

- Query product information based on product id
- Query product basic information: product category name, brand name, shipping template name
- Query product promotion information: member price, ladder price, full discount price of the product
- Query product attribute information: product attribute category name, sku inventory information, attribute classification corresponding specifications and parameter values
- Query product related information: product related topics and related preferences
- Modify product information: The product attribute classification and specifications cannot be modified, and only support modification, deletion, and addition of a single sku; the product attribute classification and specifications can be modified: after modification, the original sku inventory and attribute classification are displayed at the same time

> **Product paging query**

- Product status: all products, listed, unlisted, pending review, failed (publishStatus verifyStatus)
- Product name (% name%)
- Product article number (productSn)
- Product category id (productCategoryId)
- Product brand id (brandId)
- Batch operations: loading and unloading, recommendation, new products, transfer classification, put in the recycle bin, review
- View records: audit records, operation logs
- sku: Get sku information based on product and sku number, modify sku information in batches


> **Product recycling management**

- Paginated list of recycled products
- Recycling merchandise restore function

#### Promotion Management

> **Flash promotion Management**

- Activity list display
- Activities online and offline
- Set event product
- Add, edit, delete events

> **Coupon management**

- Coupon list display
- Add, edit, delete coupon
- View coupon redemption history

> **Event management**

- Activity list display
- Add, edit, delete events
- Activities online and offline
- Post to ad

> **Home recommendation**

-Brand recommendation: list display, recommendation, sort, delete, multiple choice
-Fresh Products: Product List Display, Recommended, Sorted, Deleted, Multi-selected
-Popular recommendation: product list display, whether to recommend, sort, delete, multi-select to add products
-Featured Feature: Feature list display, recommendation, sorting, deletion, multiple choices to join the feature
-Advertising management: display of advertisement list, online, sort, delete, add edit advertisement


#### Content management

> **Management topics**

- the list of themes: View, Delete, recommended topics
- Add, edit topic: Select the topic classification, add, delete Related Products
- topic category management: control the display, sort, edit, delete categories

> **Preferred topic**

-Preferred list: control display, sort, delete
-Add and edit preferences: associate and delete items

> **Topic management**
- Feature list: view, delete, hot topics
- Topic category management: control display, sort, edit delete category

> **Help management**

-Help list: view, delete, control display
-Add and edit help: select help category
-Help classification management: control display, sort, edit and delete classification

#### User Management

> **User Management**

-User list: account activation, deletion, group messaging
-Batch operation: group text messaging, internal message, push, set tags, give coupons
-View and edit user information: user details (statistical information, shipping address, order record), edit information, log in
-Purchasing power screening: recent consumption, number of purchases, amount of purchases, average order price, product category, membership level, user labels
-User tag management: tag list, add, edit, delete
-Member level setting: list, add, edit, set default member level

> **Talent value proposition and points**

-Growth value and points query: list display, point details, growth value details, modified values
-Mission reward settings: novice missions, daily missions
-More rules settings: growth value rules, points rules, points consumption settings

#### Order management

> **Order List**

-Order search: order number, consignee name / number, order status, order classification, order source, submission time
-Order operations: view orders, close orders, ship orders, track orders, delete orders
-Bulk operations: bulk shipping, closing orders, deleting orders

> **Check order**

-Order status: submit order, pay order, platform delivery, confirm receipt, complete evaluation
-Order details operation: modify invoice information, modify consignee information, modify product information, modify cost information, send station letter, close order, note order, cancel order, order tracking, delete order
-Basic order information: order information, discount information, user information
-Invoice information: type, header, content, payee information
-Consignee information: consignee, mobile phone number, postal code, consignee address
-Product information: contains basic product information
-Cost information: Total and discount information
-Operational information: order status change records

> **Order settings**

-Flash promotion order timeout
-Normal order timeout
-Order completion time
-Automatically end trading hours
-Automatic praise time

> **Return application processing**

-Return application search: service order number, consignee name / number, processing status, application time, operator, processing time
-Batch operation: delete
-View details: return goods, service order information, confirm return, reject return, confirm receipt

> **Return reason setting**

-Reason list: type, sort, enable or disable, add time
-Reason for adding and editing: same as above
-Batch operation: delete

#### Authority management ✔

> **Authority management**

-Permission management: add permissions, delete permissions, modify permissions, return permissions in a tree structure
-Role management: add roles, delete roles, update roles, role list, obtain corresponding role permissions, modify corresponding role permissions
-Member management: add, edit, delete members, member list, assign roles to members, get member roles, assign +-permissions, get permission list

Role | Menu
---- | ----
Administrator | All menu permissions
Operations | Home, Users, Promotions, Operations, Content
Finance | Home, Statistics, Finance
Art | Home, Products
Customer Service | Home, Products, Orders

### Foreground function

#### Product Search ✔

> **Comprehensive search function**

-Search: search by product title, subtitle, keywords;
-Filter: aggregate search results when no category is selected, select the category with the most occurrences, and select a category to filter based on the filter field of the selected category;
-Sort: Sort by new product, sales volume, price
-Search return results: product ID, product picture, name, subtitle, price, product sales, new product, product parameters, brand name, category name
-Interface: query related data from database and import es, insert (modify) data interface, delete data interface
-Brand classification filtering: aggregate the returned brand, classification and attributes based on the search results

> **Product recommendation function**

-Recommend related products of a product, according to the brand (10), category (6), name (8), keywords (2), subtitle (2) of the product
-Recommend products based on user's weekly browsing history, recommend products based on user's search history

> **Product hot search function**

- Aggregation of Keywords based on user search records

> **Product search association function** 

- Aggregation of Keywords based on user search records

#### Shopping process ✔

> **Shopping cart** 

- Add items to cart
- Shopping cart product list (product main picture, product name, product quantity, product specifications)
- Modify the number of items in the shopping cart
- Product reselection specifications
- Remove items from shopping cart

> **Generate confirmation** 

-Generate confirmation information: receipt information, product information, price information, invoice information, payment method
-Select shipping address: default shipping address
-Select coupons and points for deductions: Show available coupons and no coupons
-Calculate product price: total product, shipping cost, coupon deduction, points deduction, event discount
-Select payment method: online payment and cash on delivery
-Calculate the amount payable: total + shipping-coupon deduction-points deduction-event discount

> **Submit orders** 

-Turn confirmation information into orders
-Remove related products from Shopping cart
-Add orders to the database and Locking the inventory
-Payment method for online payment: Alipay, WeChat, UnionPay, ApplePay

> **Pay order**

- After the payment is completed, modify the order status to paid and deducted inventory

> **Cancel order (without payment)**

- Automatically cancel orders after order timeout, unlock product inventory lock, return coupons, points

#### Member module (profile)✔

> **My focus**

-List of follow brands: brand logo, name, address, number of followers
-Unfollow
-Watchlist display

> **My collection**

-Favorite products: product main picture, name, selling point, price, find similar
-Favorite topics: main themes, titles, subtitles, favorites, views, comments
-Favorite topics: topic main picture, title, subtitle, favorites, views, comments

> **My footprint**

-Products viewed: product main picture, name, selling point, price, find similar
-Delete record function
-Browse list display

> **Member Login Registration**

- Login function: https login
- Registration function: username, password, mobile phone number, mobile phone verification code
- Get verification code: Generate verification code in the background, and bind the verification code to your mobile
- Forgot password: mobile phone number, SMS verification code, new password
- Logout function
