package com.adobe.creativesdk.foundation.internal.analytics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.adobe.creativesdk.foundation.adobeinternal.analytics.AdobeAnalyticsEventParams;
import com.adobe.creativesdk.foundation.auth.AdobeAuthUserProfile;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.internal.utils.w;
import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.UUID;

/* compiled from: AdobeAnalyticsETSEvent.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a */
    private static Map<String, String> f4728a = new HashMap();

    /* renamed from: b */
    private static String f4729b = "";

    /* renamed from: c */
    protected Map<String, Object> f4730c = new HashMap();

    public g(String str) {
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyType.getValue(), str);
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyStart.getValue(), w.b());
        d();
        b();
    }

    private void c() {
        if (Boolean.valueOf(com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()).booleanValue()) {
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyOffline.getValue(), "false");
        } else {
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyOffline.getValue(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
    }

    private void d() {
        String str;
        String str2;
        Context a2 = c.a.a.a.c.a.a.b().a();
        if (a2 != null) {
            PackageManager packageManager = a2.getPackageManager();
            str2 = a2.getApplicationInfo().loadLabel(packageManager).toString();
            try {
                str = packageManager.getPackageInfo(a2.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, getClass().getSimpleName(), e2.getMessage(), e2);
                str = "";
            }
        } else {
            str = "";
            str2 = str;
        }
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        if (K != null) {
            this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertyClientId.getValue(), K.h() != null ? K.h() : "");
        }
        this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertyAppName.getValue(), str2);
        this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertyAppVersion.getValue(), str);
        this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertyPlatform.getValue(), "Android");
        this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertyDeviceType.getValue(), w.d());
        Map<String, Object> map = this.f4730c;
        String value = AdobeAnalyticsEventParams.Source.AdobeEventPropertyOSVersion.getValue();
        String str3 = Build.VERSION.RELEASE;
        map.put(value, str3 != null ? str3 : "");
        if (a2 != null) {
            this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertyAppStoreId.getValue(), a2.getPackageName());
            if (a2.getPackageManager().hasSystemFeature("org.chromium.arc.device_management")) {
                this.f4730c.put(AdobeAnalyticsEventParams.Source.AdobeEventPropertySubPlatform.getValue(), "ChromeBook");
            }
        }
    }

    public void a() {
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyEnd.getValue(), w.b());
        c();
        j.a().a(this);
    }

    public void b(String str) {
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyError.getValue(), str);
    }

    private void b() {
        AdobeAuthUserProfile b2 = com.adobe.creativesdk.foundation.auth.k.a().b();
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        if (this.f4730c.get(AdobeAnalyticsEventParams.Core.AdobeEventPropertyUser.getValue()) == null) {
            String adobeID = b2 != null ? b2.getAdobeID() : null;
            if (adobeID != null) {
                this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyUser.getValue(), adobeID);
            } else {
                this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyUser.getValue(), f4729b);
            }
        }
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyGuid.getValue(), UUID.randomUUID().toString().toUpperCase());
        if (K != null) {
            this.f4730c.put(AdobeAnalyticsEventParams.Consumer.AdobeEventPropertyConsumerClientId.getValue(), K.h() != null ? K.h() : "");
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyDevice.getValue(), K.p() != null ? K.p() : "");
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyIMSFlow.getValue(), K.z() != null ? K.z() : "");
        } else {
            this.f4730c.put(AdobeAnalyticsEventParams.Consumer.AdobeEventPropertyConsumerClientId.getValue(), "");
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyDevice.getValue(), "");
        }
        try {
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyLanguage.getValue(), Resources.getSystem().getConfiguration().locale.getISO3Language());
        } catch (MissingResourceException unused) {
            this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyLanguage.getValue(), "");
        }
        this.f4730c.put(AdobeAnalyticsEventParams.Core.AdobeEventPropertyCategory.getValue(), "CSDK");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyFrameworkName.getValue(), "AdobeCreativeSDK");
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyFrameworkVersion.getValue(), c.a.a.a.a.d());
        if (f4728a.size() > 0) {
            for (Map.Entry<String, String> entry : f4728a.entrySet()) {
                this.f4730c.put(entry.getKey(), entry.getValue());
            }
        }
        if (this.f4730c.get("project") == null) {
            this.f4730c.put("project", "csdkandroid-service");
        }
    }

    public void a(String str, String str2) {
        this.f4730c.put(str, str2);
    }

    public void a(String str) {
        b(str);
        a();
    }

    public void a(String str, String str2, String str3) {
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyServiceName.getValue(), str);
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyServiceAPIVersion.getValue(), str3);
        this.f4730c.put(AdobeAnalyticsEventParams.Environment.AdobeEventPropertyServiceAPIName.getValue(), str2);
    }

    public static void b(String str, String str2) {
        f4728a.put(str, str2);
    }
}
