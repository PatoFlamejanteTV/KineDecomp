package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class LifecycleActivity {

    /* renamed from: a */
    private final Object f10773a;

    public LifecycleActivity(Activity activity) {
        Preconditions.a(activity, "Activity must not be null");
        this.f10773a = activity;
    }

    @KeepForSdk
    public Activity a() {
        return (Activity) this.f10773a;
    }

    @KeepForSdk
    public FragmentActivity b() {
        return (FragmentActivity) this.f10773a;
    }

    @KeepForSdk
    public boolean c() {
        return this.f10773a instanceof FragmentActivity;
    }

    public final boolean d() {
        return this.f10773a instanceof Activity;
    }
}
