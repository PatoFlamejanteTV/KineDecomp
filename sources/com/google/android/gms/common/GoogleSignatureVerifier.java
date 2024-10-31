package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@ShowFirstParty
@KeepForSdk
@CheckReturnValue
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {

    /* renamed from: a */
    private static GoogleSignatureVerifier f10665a;

    /* renamed from: b */
    private final Context f10666b;

    private GoogleSignatureVerifier(Context context) {
        this.f10666b = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier a(Context context) {
        Preconditions.a(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (f10665a == null) {
                a.a(context);
                f10665a = new GoogleSignatureVerifier(context);
            }
        }
        return f10665a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean a(int i) {
        i a2;
        String[] a3 = Wrappers.a(this.f10666b).a(i);
        if (a3 == null || a3.length == 0) {
            a2 = i.a("no pkgs");
        } else {
            a2 = null;
            for (String str : a3) {
                a2 = a(str, i);
                if (a2.f11025b) {
                    break;
                }
            }
        }
        a2.c();
        return a2.f11025b;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        c a2;
        if (packageInfo != null && packageInfo.signatures != null) {
            if (z) {
                a2 = a(packageInfo, f.f11023a);
            } else {
                a2 = a(packageInfo, f.f11023a[0]);
            }
            if (a2 != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (a(packageInfo, false)) {
            return true;
        }
        if (a(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f10666b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    private final i a(String str, int i) {
        try {
            PackageInfo a2 = Wrappers.a(this.f10666b).a(str, 64, i);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.f10666b);
            if (a2 == null) {
                return i.a("null pkg");
            }
            if (a2.signatures.length != 1) {
                return i.a("single cert required");
            }
            d dVar = new d(a2.signatures[0].toByteArray());
            String str2 = a2.packageName;
            i a3 = a.a(str2, dVar, honorsDebugCertificates, false);
            return (!a3.f11025b || a2.applicationInfo == null || (a2.applicationInfo.flags & 2) == 0 || !a.a(str2, dVar, false, true).f11025b) ? a3 : i.a("debuggable release cert app rejected");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return i.a(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    private static c a(PackageInfo packageInfo, c... cVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        d dVar = new d(signatureArr[0].toByteArray());
        for (int i = 0; i < cVarArr.length; i++) {
            if (cVarArr[i].equals(dVar)) {
                return cVarArr[i];
            }
        }
        return null;
    }
}
