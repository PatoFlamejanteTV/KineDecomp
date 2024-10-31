package com.google.android.gms.common.api;

import android.app.Activity;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class zza {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Activity, zza> f981a = new WeakHashMap();
    private static final Object b = new Object();

    public abstract void a(int i);
}
