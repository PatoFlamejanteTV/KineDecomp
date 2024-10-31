package com.nexstreaming.kinemaster.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceManager;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: SettingDevelop.java */
/* loaded from: classes.dex */
public class w extends x {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4271a = false;

    @Override // com.nexstreaming.kinemaster.ui.settings.x, android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4271a = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("disable_iab_mcc_checker", false);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.x
    protected int a() {
        return R.xml.devprefs;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.x, android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("disable_iab_mcc_checker", false) != this.f4271a) {
            System.exit(0);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.x
    protected String b() {
        return "Developer";
    }
}
