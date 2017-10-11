#针对Retrofit+RxJava框架进行请求链的拦截和处理@参考链接：http://www.jianshu.com/p/56b5bce47d8c
1：请求
处理方式看链接文章，这里说一下我们正常开发时候的处理
如果项目刚启动时，后台还未采用加密的方式进行请求，此时，为了方便上述请求加密的拦截统一处理，Retrofit框架的ApiService中
我们，所有的参数都使用一个Map传入
当后台统一加密后，直接修改FieldMap注解为body，同时加入自定义转换器，达到统一加密的目的
2:结果
有时候接口可能对应多个数据结构，按照我们正常链，达不到这个目的
做法是，在自定义请求转换器中，自己即系gson串