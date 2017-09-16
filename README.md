# mavens
git连接远程仓库，一些工具类和常用项目框架
#NetDemo库
背景和限制：近年来RxJava+retrofit网络访问框架算是比较主流的了，这里做一些总结，NetDemo库只针对single module或少module的项目环境，如果项目做组件化开发，需要对Zygote做泛化处理
思路：RxJava作为统一调用链，在整条链中，我们需要做这几件事：数据传输、数据过滤、数据缓存、请求拦截和优化
数据传输：这里新建一个BaseBean作为数据的基本结构，声明服务器公共字段，在Zygote中，添加header信息，包括token、companyId等
数据过滤：可以添加拦截器，我这里对返回值做了统一的BaseApiSubscriber,模拟一些操作
数据缓存：核心是框架支持的Observable.concat（三级缓存）,外层添加CacheManager管理类
请求拦截：在Zygote中添加拦截器即可
优化：主要是一些泛化处理和生命周期关联
