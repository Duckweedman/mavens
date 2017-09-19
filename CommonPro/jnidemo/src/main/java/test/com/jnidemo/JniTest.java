package test.com.jnidemo;

public class JniTest {

    //加载动态库
    static {
        System.loadLibrary("jnitestlib");
    }

    public native String getStringFromC();

}
