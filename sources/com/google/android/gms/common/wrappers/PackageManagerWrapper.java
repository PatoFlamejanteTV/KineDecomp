package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class PackageManagerWrapper {

    /* renamed from: a */
    private final Context f11307a;

    public PackageManagerWrapper(Context context) {
        this.f11307a = context;
    }

    @KeepForSdk
    public ApplicationInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f11307a.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    public PackageInfo b(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f11307a.getPackageManager().getPackageInfo(str, i);
    }

    public final PackageInfo a(String str, int i, int i2) throws PackageManager.NameNotFoundException {
        return this.f11307a.getPackageManager().getPackageInfo(str, 64);
    }

    @KeepForSdk
    public CharSequence b(String str) throws PackageManager.NameNotFoundException {
        return this.f11307a.getPackageManager().getApplicationLabel(this.f11307a.getPackageManager().getApplicationInfo(str, 0));
    }

    public final String[] a(int i) {
        return this.f11307a.getPackageManager().getPackagesForUid(i);
    }

    @TargetApi(19)
    public final boolean a(int i, String str) {
        if (PlatformVersion.f()) {
            try {
                ((AppOpsManager) this.f11307a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f11307a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @KeepForSdk
    public int a(String str) {
        return this.f11307a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int a(String str, String str2) {
        return this.f11307a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public boolean a() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.a(this.f11307a);
        }
        if (!PlatformVersion.k() || (nameForUid = this.f11307a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f11307a.getPackageManager().isInstantApp(nameForUid);
    }
}
