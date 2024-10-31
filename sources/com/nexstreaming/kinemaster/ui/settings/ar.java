package com.nexstreaming.kinemaster.ui.settings;

import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes.dex */
public class ar implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4244a;
    final /* synthetic */ SettingsActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SettingsActivity settingsActivity, Intent intent) {
        this.b = settingsActivity;
        this.f4244a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f4244a.getData().getPathSegments().get(0));
    }
}
