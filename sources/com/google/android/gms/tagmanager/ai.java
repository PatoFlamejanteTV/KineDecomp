package com.google.android.gms.tagmanager;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
final class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences.Editor f2215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SharedPreferences.Editor editor) {
        this.f2215a = editor;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2215a.commit();
    }
}
