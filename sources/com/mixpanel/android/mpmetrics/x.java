package com.mixpanel.android.mpmetrics;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersistentIdentity.java */
/* loaded from: classes.dex */
public class x implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f3050a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f3050a = wVar;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Object obj;
        obj = w.k;
        synchronized (obj) {
            this.f3050a.i();
            boolean unused = w.j = false;
        }
    }
}
