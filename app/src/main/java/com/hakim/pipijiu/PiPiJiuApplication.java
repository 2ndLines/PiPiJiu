package com.hakim.pipijiu;

import android.app.Application;
import android.util.Log;

import com.hakim.pipijiu.crash.FakeCrashLibrary;

import timber.log.Timber;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/11/29 17:19 <br/>
 * Desc  :
 */
public class PiPiJiuApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupTimber();
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    private class CrashReportingTree extends Timber.Tree {

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }
            FakeCrashLibrary.log(priority, tag, message);
            if (t != null) {
                if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                } else if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                }
            }
        }
    }

}
