package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: a */
    @KeepForSdk
    protected final LifecycleFragment f10774a;

    @KeepForSdk
    public LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.f10774a = lifecycleFragment;
    }

    @KeepForSdk
    public static LifecycleFragment a(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.c()) {
            return zzc.a(lifecycleActivity.b());
        }
        if (lifecycleActivity.d()) {
            return zza.a(lifecycleActivity.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @KeepForSdk
    public void a(int i, int i2, Intent intent) {
    }

    @KeepForSdk
    public void a(Bundle bundle) {
    }

    @KeepForSdk
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @KeepForSdk
    public void b() {
    }

    @KeepForSdk
    public void b(Bundle bundle) {
    }

    @KeepForSdk
    public void c() {
    }

    @KeepForSdk
    public void d() {
    }

    @KeepForSdk
    public void e() {
    }

    @KeepForSdk
    public static LifecycleFragment a(Activity activity) {
        return a(new LifecycleActivity(activity));
    }

    @KeepForSdk
    public Activity a() {
        return this.f10774a.d();
    }
}
