package com.qq.e.ads;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

/* loaded from: classes3.dex */
public class ADActivity extends Activity {

    /* renamed from: a */
    private ACTD f24755a;

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ACTD.DELEGATE_NAME_KEY);
            String string2 = extras.getString(ACTD.APPID_KEY);
            if (!StringUtil.isEmpty(string) && !StringUtil.isEmpty(string2)) {
                try {
                    if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                        this.f24755a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(string, this);
                        if (this.f24755a == null) {
                            str = "Init ADActivity Delegate return null,delegateName" + string;
                        }
                    } else {
                        str = "Init GDTADManager fail in AdActivity";
                    }
                    GDTLogger.e(str);
                } catch (Throwable th) {
                    GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + string, th);
                }
            }
        }
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            finish();
        }
        super.onCreate(bundle);
        ACTD actd2 = this.f24755a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        ACTD actd = this.f24755a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }
}
