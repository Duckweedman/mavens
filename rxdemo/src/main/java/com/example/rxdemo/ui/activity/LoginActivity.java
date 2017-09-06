package com.example.rxdemo.ui.activity;

import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;

import com.example.rxdemo.R;
import com.example.rxdemo.base.BaseActivity;
import com.example.rxdemo.http.BaseEntity;
import com.example.rxdemo.http.BaseObserver;
import com.example.rxdemo.http.RetrofitFactory;
import com.example.rxdemo.model.User;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_phone)
    TextInputEditText etPhone;
    @BindView(R.id.et_pwd)
    TextInputEditText etPwd;


    @Override
    public int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                startLogin();
                break;
        }
    }

    private void startLogin() {
        String phone = etPhone.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        Log.i("Login", "startLogin: " + phone + "---" + pwd);
        login(phone, pwd);
    }

    /**
     * compose()操作符拥有更高层次的抽象概念：它操作于整个数据流中，不仅仅是某一个被发送的事件。
     * <p>
     * 1、compose()是唯一一个能够从数据流中得到原始Observable<T>的操作符，所以，那些需要对整个数据流产生作用的操作（比如，subscribeOn()和observeOn()）
     * 需要使用compose()来实现。相较而言，如果在flatMap()中使用subscribeOn()或者observeOn()，那么它仅仅对在flatMap()中创建的Observable起作用，
     * 而不会对剩下的流产生影响
     * <p>
     * 2、当创建Observable流的时候，compose()会立即执行，犹如已经提前写好了一个操作符一样，
     * 而flatMap()则是在onNext()被调用后执行，onNext()的每一次调用都会触发flatMap()，也就是说，flatMap()转换每一个事件，而compose()转换的是整个数据流。
     * <p>
     * 3、因为每一次调用onNext()后，都不得不新建一个Observable，所以flatMap()的效率较低。事实上，compose()操作符只在主干数据流上执行操作。
     * <p>
     * 4、如果想重用一些操作符，还是使用compose()吧，虽然flatMap()的用处很多，但作为重用代码这一点来讲，并不适用。
     *
     * @param user
     * @param pwd
     */
    private void login(String user, String pwd) {
        Observable<BaseEntity<User>> observable = RetrofitFactory.getInstance().login(user, pwd);
        observable.compose(compose(this.<BaseEntity<User>>bindToLifecycle()))
                .subscribe(new BaseObserver<User>(LoginActivity.this) {
                    @Override
                    protected void onHandleSuccess(User user) {
                        Log.i("Login", "onHandleSuccess: " + user.getNickname());
                        toast(user.getNickname());
                    }
                });
    }


}
