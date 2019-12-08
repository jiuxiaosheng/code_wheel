# 常用命令

## 全局命令

- keys * 查询所有的键，会遍历所有的键值，复杂度O(n)
- dbsize 查询键总数，直接获取redis内置的键总数变量，复杂度O(1)
- exists key 存在返回1，不存在返回0
- del key [key...] 返回结果为成功删除键的个数
- expire key seconds 当超过过期时间，会自动删除，key在seconds秒后过期
- expireat key timestamp 键在秒级时间戳timestamp后过期
- pexpire key milliseconds 当超过过期时间，会自动删除，key在milliseconds毫秒后过期
- pexpireat key milliseconds-timestamp key在豪秒级时间戳timestamp后过期
- ttl 命令可以查看键hello的剩余过期时间，pttl是毫秒
- type key 如果键hello是字符串类型，则返回string；如果键不存在，则返回none
- rename key newkey 键重命名
- renamenx key newkey 只有newkey不存在时才会被覆盖
- randomkey 随机返回一个键
- dump key 键值序列化，格式采用的是RDB格式
- restore 序列化的值进行复原
- migrate 192.168.225.128 6379 flower 0 1000 replace 将键flower迁移至目标192.168.225.128:6379的库0中，超时时间为1000毫秒，replace表示目标库如果存在键flower，则覆盖
- keys pattern 全量遍历键
- scan 渐进式遍历

## 数据库管理

- select dbIndex 默认16个数据库：0-15，进入redis后默认是0库。不建议使用多个数据库
- flushdb 清除当前数据库
- flushall 清除所有数据库

## 针对key的操作

- set key value [ex]  [px]  [nx|xx] 
ex：为键值设置秒级过期时间
px：为键值设置毫秒级过期时间
nx：键必须不存在，才可以设置成功，用于添加
xx：与nx相反，键必须存在，才可以设置成功，用于更新
setnx、setex 与上面的nx、ex作用相同

- get key 不存在则返回nil
- mset key value [key value ......] 批量设置值O(k)
- mget key [key ......] 批量获取值O(k)，k是键的个数
- incr key /decr key /inceby key increment /decrby key increment 计数O(1)
- append key value 向字符串尾部追加值
- strlen key 每个汉字占用3个字字节
- getset key value 设置并返回原值
- setrange key offeset value 设置指定位置的字符
- getrange key start end 获取部分字符串

## Hash操作
- hset key field value 设置值
- hget key field 获取值
- hdel key field [field ......] 删除一个或多个field
- hlen key 计算field的个数
- Hmget key field [field ......] 批量获取field-value
- Hmset key field value [field value] 批量设置field-value
- hexists key field 判断field是否存在
- hkeys key 获取所有field
- hvals key 获取所有value
- hgetall key 获取所有的field、value
- hincrby key field 增加 key 指定的哈希集中指定字段的数值
- hincrbyfloat key field 为指定key的hash的field字段值执行float类型的increment加
- hstrlen key field 计算value字符串的长度

## 列表List操作
- rpush key value [value......] 从右边插入元素
- lpush key value [value......] 从左边插入元素
- linsert key before|after pivot value 向某个元素前或者后插入元素
- lrange key start end 获取指定范围内的元素列表, 0 -1 可以从左到右获取列表的所有元素
- lindex key index 获取列表指定下标的元素
- llen key 获取列表长度
- rpop key 从列表右侧弹出元素
- lpop key 从列表左侧弹出元素
- lrem key count value 删除指定元素
Count>0,从左到有，删除最多count个元素
Count<0,从右到左，删除最多count绝对值个元素
Count=0,删除所有
- lset key index newValue 修改指定索引下标的元素
- 阻塞操作
blpop key [key ...] timeout 当给定多个key参数时，按参数key的先后顺序依次检查各个列表，弹出第一个非空列表的头元素
brpop key [key ...] timeout 
列表为空:brpop list:test 3 3秒后返回; brpop list:test 0 一直处于阻塞中
列表不为空:brpop mylist 0 立刻返回

## Set操作（不可重复）
- sadd key element [element .....] 添加元素
- srem key element [element .....] 删除元素
- scard key 计算元素个数
- sismember key element 判断元素是否在集合中
- srandmember key [count] 随机从集合返回指定个数元素，不删除
- spop key [count] 从集合随机弹出元素, 删除并返回
- smembers key 获取所有元素

## 集合间的操作
- sinter key [ key ......] 求多个集合的交集
- sunion key [key ......] 求多个集合的并集
- sdiff key [key ......] 求多个集合的差集
- 将交集、并集、差集的结果保存
sinterstore destination key [ key ......]
sunionstore destination key [ key ......]
sdiffstore destination key [ key ......]

## ZADD操作（有序集合）
- zadd key score member[score member .....] 将所有指定成员添加到键为key有序集合（sorted set）里面
- zcard key 计算成员个数
- zsore key member 计算某个成员分数
- zrank key member 计算成员的排名
- zrem key member [member .......] 删除成员
- zincrby key increment member 增加成员的分数
- 返回指定排名范围的成员
zrange key start end [withscores] 从低分到高分 zrange myzset 0 1 withscores
zrevrange key start end [withscores] 从高分到低分 zrevrange myzset 0 1 withscores
- zcount key min max 返回指定分数范围的成员个数
- zremrangebyrank key start end 删除指定排名内的升序元素
- zremrangebystore key min max 删除指定分数范围的成员

## pub/sub(发布、订阅)
- publish channel message                发布消息 eg：publish channel:sports 'I want to go eatting'
- subscribe channel [channel .....]      订阅消息    eg: subscribe channel:sports
- unsubscribe channel [channel .....]    取消订阅
- psubscribe pattern [pattern ......]    按照模式订阅
- unpsubscribe pattern [pattern ......]  按照模式取消订阅
- pubsub channels                        查看活跃的频道
- pubsub numsub [channel ......]         查看频道订阅数 eg:pubsub numsub channel:sports
- ubsub numpat                           查看模式订阅数

## Transaction（事务）
- discard                 取消执行事务块内的所有命令
- exec                    执行事务块内的命令
- multi                   标记一个事务块的开始
- unwatch                 取消watch命令对所有key的监视
- watch key [key ...]     监视一个或者多个key，如果事务执行之前，这个kye被其它命令所动，则事务被打断

## Connection（连接）
- auth password           登录redis时输入密码
- echo message            打印一个特定的信息message，测试时使用
- ping                    测试与服务器的连接，如果正常则返回pong
- quit                    请求服务器关闭与当前客户端的连接
- select index            切换到指定的数据库

## Server(服务器)
- bgsave                              后台异步保存数据到硬盘
- client setname/client getname       为连接设置、获取名字
- client kill ip:port                 关闭地址为 ip:port的客户端
- client list                         以人类可读的方式，返回所有的连接客户端信息和统计数据
- config get parameter                取得运行redis服务器的配置参数
- config set parameter value          设置redis服务器的配置参数
- config resetstat                    重置info命令的某些统计数据
- dbsize                              返回当前数据库中key的数量
- flushall                            清空整个redis服务器的数据（删除所有数据库的所有key）
- flushdb                             清空当前数据库中的所有key
- info [section]                      返回redis服务器的各种信息和统计数据
- lastsave                            返回最近一次redis成功将数据保存到磁盘时的时间
- monitor                             实时打印出redis服务器接收到的指令
- save                                将当前 Redis 实例的所有数据快照(snapshot)以 RDB 文件的形式保存到硬盘
- slaveof host port                   将当前服务器转变为指定服务器的从属服务器
- slowlog subcommand [argument]       Redis用来记录查询执行时间的日志系统


# 管道（Pipelining）
主要解决每次请求和响应RTT (Round Trip Time - 往返时间)时间太长的问题




# 技术点

- 用冒号作为分割是设计key的一种不成文的原则，遵循这种格式设计出的key在某些redis客户端下可以有效的识别
user:userid:9:username admin
user:userid:9:password 123456
user:username:admin:uid 1
- BLPOP BRPOP
* 如果所有给定的key都不存在或包含空列表，那么BLPOP/BRPOP命令将阻塞连接，直到另一个客户端对给定的这些key的任意一个执行LRPUSH或者RPUSH命令为止
* 按照key的顺序从左到右依次处理
* 如果多个客户端对同一个key阻塞的时候，第一个被处理的客户端是等待时间最长的
* 一旦一个客户端解除阻塞那么它就不会保持任何优先级，当它因为下一个 BLPOP 命令而再次被阻塞的时候，会在处理完那些 被同个 key 阻塞的客户端后才处理它（即从第一个被阻塞的处理到最后一个被阻塞的）
* 在处理每个 key 的时候，只要这个 key 里有元素， Redis就会对所有等待这个key的客户端按照“先进先出”(FIFO)的顺序进行服务
* 当多个元素被push进入一个list时BLPOP的行为：Redis 2.6 或更高版本所采取的行为是先执行多个 push 命令，然后在执行了这个命令之后再去服务被阻塞的客户端，Redis2.4客户端会在push操作的上下文中被服务
* 只要在执行某个单一命令、事务或者脚本后 list 中没有出现元素，它就会被继续阻塞下去










