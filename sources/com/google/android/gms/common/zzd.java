package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.a;

/* loaded from: classes.dex */
public class zzd {

    /* renamed from: a */
    private static final zzd f1048a = new zzd();

    private zzd() {
    }

    public static zzd a() {
        return f1048a;
    }

    private boolean a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        a.ab abVar = new a.ab(packageInfo.signatures[0].toByteArray());
        if ((z ? a.a() : a.b()).contains(abVar)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(abVar.a(), 0));
        }
        return false;
    }

    public a.AbstractC0031a a(PackageInfo packageInfo, a.AbstractC0031a... abstractC0031aArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        a.ab abVar = new a.ab(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < abstractC0031aArr.length; i++) {
            if (abstractC0031aArr[i].equals(abVar)) {
                return abstractC0031aArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(abVar.a(), 0));
        }
        return null;
    }

    public boolean a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (GooglePlayServicesUtil.b(packageManager)) {
            return a(packageInfo, true);
        }
        boolean a2 = a(packageInfo, false);
        if (a2 || !a(packageInfo, true)) {
            return a2;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a2;
    }

    public boolean a(PackageManager packageManager, String str) {
        try {
            return a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
                Log.d("GoogleSignatureVerifier", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }
}
