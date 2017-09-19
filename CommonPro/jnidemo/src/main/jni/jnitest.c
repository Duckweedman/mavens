//
// Created by Administrator on 2017/9/19 0019.
//

#include "test_com_jnidemo_JniTest.h"
/*
 * Class:     io_github_yanbober_ndkapplication_NdkJniUtils
 * Method:    getCLanguageString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_test_com_jnidemo_JniTest_getStringFromC
        (JNIEnv *env, jobject obj) {
    return (*env)->NewStringUTF(env, "This just a test for Android Studio NDK JNI developer!");
}