package com.hakim.pipijiu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hakim.pipijiu.data.api.UserApiImpl;

import rx.Subscriber;
import rx.functions.Action1;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        final UserApiImpl userApi = new UserApiImpl();

        Button button = (Button) findViewById(R.id.request);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.tag(TAG).d("Test LeanCloud");
                /*userApi.createUser("retrofit3", "123456").subscribe(new Action1<UserEntity>() {
                    @Override
                    public void call(UserEntity userEntity) {
                        Timber.tag(TAG).i(userEntity.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Timber.tag(TAG).e(throwable);
                    }
                });*/

                userApi.requestSmsCode("18167158550","Test").subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        Timber.tag(TAG).i("Success to request sms code");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Timber.tag(TAG).e(throwable);
                    }
                });

            }
        });

        final EditText et = (EditText) findViewById(R.id.input);

        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsCode = et.getText().toString();
                if (!TextUtils.isEmpty(smsCode)){
                    userApi.verifySmsCode("18167158550",smsCode).subscribe(new Subscriber<Boolean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Timber.tag(TAG).e(e);
                        }

                        @Override
                        public void onNext(Boolean aBoolean) {
                            Timber.tag(TAG).i("Success to verify");
                        }
                    });
                }
            }
        });
    }


}
