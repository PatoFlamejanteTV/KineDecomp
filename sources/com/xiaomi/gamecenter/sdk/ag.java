package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.licensinglibrary.ILicenseService;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class ag {

    /* renamed from: b */
    private static ag f26569b = new ag();

    /* renamed from: e */
    private int f26573e;

    /* renamed from: a */
    private Object f26570a = new Object();

    /* renamed from: c */
    private String f26571c = null;

    /* renamed from: d */
    private String f26572d = null;

    /* renamed from: f */
    private ConcurrentHashMap f26574f = new ConcurrentHashMap();

    /* renamed from: g */
    private OnLoginProcessListener f26575g = new aj(this);

    private ag() {
    }

    public static ag a() {
        return f26569b;
    }

    public synchronized int a(Activity activity, ILicenseService iLicenseService) {
        int i;
        if (activity == null || iLicenseService == null) {
            i = LicenseErrCode.ERROR_BUY_LICENSE_PARAMERROR;
        } else {
            b(activity, iLicenseService);
            if (!TextUtils.isEmpty(this.f26571c)) {
                Bundle a2 = a(activity, this.f26571c, iLicenseService);
                int i2 = a2.getInt("errcode");
                String string = a2.getString("orderid");
                if (i2 != 5005) {
                    return i2;
                }
                activity.runOnUiThread(new ah(this, activity, string));
                synchronized (this.f26570a) {
                    try {
                        this.f26570a.wait(120000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                return this.f26573e;
            }
            i = LicenseErrCode.ERROR_BUY_LICENSE_LOGINERROR;
        }
        return i;
    }

    public Bundle a(Activity activity, String str, ILicenseService iLicenseService) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            str = b(activity, iLicenseService);
        }
        if (!TextUtils.isEmpty(str) && (bundle = (Bundle) this.f26574f.get(str)) != null) {
            return bundle;
        }
        int i = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        Bundle bundle2 = new Bundle();
        bundle2.putString("fuid", str);
        bundle2.putString("pkgName", activity.getPackageName());
        bundle2.putInt("versionCode", i);
        Bundle b2 = iLicenseService.b(bundle2);
        String string = b2.getString("orderid");
        int i2 = b2.getInt("errcode");
        if (!TextUtils.isEmpty(string) && i2 == 5005) {
            this.f26574f.put(str, b2);
        }
        return b2;
    }

    public String b(Activity activity, ILicenseService iLicenseService) {
        String string = iLicenseService.a().getString("mid");
        if (!TextUtils.isEmpty(string) && TextUtils.equals(string, this.f26572d)) {
            return this.f26571c;
        }
        this.f26571c = null;
        this.f26572d = null;
        MiCommplatform.getInstance().miLogin(activity, this.f26575g);
        synchronized (this.f26570a) {
            try {
                this.f26570a.wait(300000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.f26571c)) {
            this.f26572d = iLicenseService.a().getString("mid");
        }
        return this.f26571c;
    }
}
