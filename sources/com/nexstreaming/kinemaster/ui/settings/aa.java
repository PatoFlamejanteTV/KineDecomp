package com.nexstreaming.kinemaster.ui.settings;

import android.os.Bundle;
import android.preference.PreferenceManager;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: SettingDevelop.java */
/* loaded from: classes2.dex */
public class Aa extends Ua {

    /* renamed from: h, reason: collision with root package name */
    private boolean f23020h = false;

    @Override // com.nexstreaming.kinemaster.ui.settings.Ua
    protected int b() {
        return R.xml.devprefs;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.Ua, android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23020h = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("disable_iab_mcc_checker", false);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.Ua, android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("disable_iab_mcc_checker", false) != this.f23020h) {
            System.exit(0);
        }
    }
}
