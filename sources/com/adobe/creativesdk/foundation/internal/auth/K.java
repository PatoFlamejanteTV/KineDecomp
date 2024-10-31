package com.adobe.creativesdk.foundation.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobeCSDKAuthSharedDeviceTokenAESKeyMgr.java */
/* loaded from: classes.dex */
public class K {

    /* renamed from: a */
    private static K f4836a;

    /* renamed from: b */
    private String f4837b;

    /* renamed from: c */
    private L f4838c;

    /* renamed from: d */
    private boolean f4839d;

    K() {
        this.f4839d = false;
        this.f4839d = false;
    }

    public static K a() {
        if (f4836a == null) {
            f4836a = new K();
        }
        return f4836a;
    }

    public static void a(String str) {
    }

    private void b() {
        try {
            a("Creating the Cipher Instance of Key");
            b(this.f4837b);
            this.f4838c = new L(com.adobe.creativesdk.foundation.internal.utils.w.a(this.f4837b));
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, K.class.getSimpleName(), e2.getMessage(), e2);
            a("Cipher cretion FAILED with messages :  " + e2.getClass().getSimpleName() + "   : " + e2.getMessage());
        }
    }

    private void b(String str) {
    }

    public void a(Context context, String str) {
        c.a.a.a.c.a.a.b().a(context);
        AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
        a("Setting new key " + str);
        String b2 = K.g().b(str);
        SharedPreferences.Editor edit = context.getSharedPreferences("adb_authenticator_shared_aes_preference", 0).edit();
        edit.putString("adb_authenticator_shared_aes_devicetoken", b2);
        edit.commit();
        this.f4837b = str;
        b(this.f4837b);
        b();
    }
}
