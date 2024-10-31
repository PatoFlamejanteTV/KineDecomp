package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.licensinglibrary.ILicenseService;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class ag {
    private static ag b = new ag();
    private int e;

    /* renamed from: a, reason: collision with root package name */
    private Object f4883a = new Object();
    private String c = null;
    private String d = null;
    private ConcurrentHashMap f = new ConcurrentHashMap();
    private OnLoginProcessListener g = new aj(this);

    private ag() {
    }

    public static ag a() {
        return b;
    }

    public synchronized int a(Activity activity, ILicenseService iLicenseService) {
        int i;
        if (activity == null || iLicenseService == null) {
            i = LicenseErrCode.ERROR_BUY_LICENSE_PARAMERROR;
        } else {
            b(activity, iLicenseService);
            if (TextUtils.isEmpty(this.c)) {
                i = LicenseErrCode.ERROR_BUY_LICENSE_LOGINERROR;
            } else {
                Bundle a2 = a(activity, this.c, iLicenseService);
                i = a2.getInt("errcode");
                String string = a2.getString("orderid");
                if (i == 5005) {
                    activity.runOnUiThread(new ah(this, activity, string));
                    synchronized (this.f4883a) {
                        try {
                            this.f4883a.wait(120000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i = this.e;
                }
            }
        }
        return i;
    }

    public Bundle a(Activity activity, String str, ILicenseService iLicenseService) {
        Bundle b2;
        if (TextUtils.isEmpty(str)) {
            str = b(activity, iLicenseService);
        }
        if (TextUtils.isEmpty(str) || (b2 = (Bundle) this.f.get(str)) == null) {
            int i = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
            Bundle bundle = new Bundle();
            bundle.putString("fuid", str);
            bundle.putString("pkgName", activity.getPackageName());
            bundle.putInt("versionCode", i);
            b2 = iLicenseService.b(bundle);
            String string = b2.getString("orderid");
            int i2 = b2.getInt("errcode");
            if (!TextUtils.isEmpty(string) && i2 == 5005) {
                this.f.put(str, b2);
            }
        }
        return b2;
    }

    public String b(Activity activity, ILicenseService iLicenseService) {
        String string = iLicenseService.a().getString("mid");
        if (!TextUtils.isEmpty(string) && TextUtils.equals(string, this.d)) {
            return this.c;
        }
        this.c = null;
        this.d = null;
        MiCommplatform.getInstance().miLogin(activity, this.g);
        synchronized (this.f4883a) {
            try {
                this.f4883a.wait(300000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            this.d = iLicenseService.a().getString("mid");
        }
        return this.c;
    }
}
