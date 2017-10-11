# mavens
一些工具类和常用项目框架
#NetDemo库
需要完善和优化的地方有很多，欢迎大家给出建议和改善，谢谢了
背景和限制：近年来RxJava+retrofit网络访问框架算是比较主流的了，这里做一些总结，NetDemo库只针对single module或少module的项目环境，如果项目做组件化开发，需要对Zygote做泛化处理
思路：RxJava作为统一调用链，在整条链中，我们需要做这几件事：数据传输、数据过滤、数据缓存、请求拦截和优化
数据传输：这里新建一个BaseBean作为数据的基本结构，声明服务器公共字段，在Zygote中，添加header信息，包括token、companyId等
数据过滤：可以添加拦截器，我这里对返回值做了统一的BaseApiSubscriber,模拟一些操作
数据缓存：核心是框架支持的Observable.concat（三级缓存）,外层添加CacheManager管理类
请求拦截：在Zygote中添加拦截器即可
优化：主要是一些泛化处理和生命周期关联
###使用
AppCall-Zygote—Apiservice作为调用流程，绑定View的操作，看MainActivity示例，创建一个Base类继承RxFragmentActivity或RxFragment

###jniDemo库
从事Android以来，jni使用场景少了（项目使然），温故知新，对jni调用流程熟悉一遍也挺好的
Android studio集成jni四步：
第一步：新建native的java类
第二步：使用javah -classpath xxx -jni 全类名  生成.h文件、新建jni文件夹，并把.h文件复制进去
第三步：修改module的build.gradle 添加ndk过滤
ndk{
            moduleName "jnitestlib"         //生成的so名字
            abiFilters "armeabi", "armeabi-v7a", "x86"  //输出指定三种abi体系结构下的so库。目前可有可无。
        }
第四步：在工程的gradle.properties文件中添加语句：
android.useDeprecatedNdk=true
###
