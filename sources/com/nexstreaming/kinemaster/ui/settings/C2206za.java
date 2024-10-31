package com.nexstreaming.kinemaster.ui.settings;

import android.content.SharedPreferences;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: SettingAdvanced.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.za */
/* loaded from: classes2.dex */
public class C2206za extends Ua {

    /* renamed from: h */
    private static final String f23243h = "za";

    @Override // com.nexstreaming.kinemaster.ui.settings.Ua
    protected int b() {
        return R.xml.preferences_advanced;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.Ua, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (this.f23084a == null) {
            Log.d(f23243h, "onSharedPreferenceChanged: lister is null");
        }
        if (str.equals("unlimited_layers")) {
            if (EditorGlobal.w()) {
                Crashlytics.log("unlimited layers: turn on");
                com.nexstreaming.kinemaster.usage.analytics.f.a();
                e.a aVar = new e.a(getActivity());
                aVar.e(R.string.adv_pref_warn_title);
                aVar.c(R.string.pref_unlimited_video_layer_popup_msg);
                aVar.c(R.string.adv_pref_warn_ok, new DialogInterfaceOnClickListenerC2204ya(this));
                aVar.a().show();
            } else {
                Crashlytics.log("unlimited layers: turn off");
                com.nexstreaming.kinemaster.usage.analytics.f.a();
            }
            EditorGlobal.i().b(-1, -1, -1);
            return;
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }
}
