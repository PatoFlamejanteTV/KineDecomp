package com.nexstreaming.kinemaster.ui.settings;

import android.preference.Preference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class La implements Preference.OnPreferenceClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ua f23066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(Ua ua) {
        this.f23066a = ua;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        this.f23066a.f23084a.b(preference.getKey());
        return true;
    }
}
