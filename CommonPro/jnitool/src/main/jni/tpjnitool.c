#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_tp_jnitool_AppSecretTool_getAppSecretStr(JNIEnv *env, jclass type)
{
// TODO
return (*env)->NewStringUTF(env,"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
}