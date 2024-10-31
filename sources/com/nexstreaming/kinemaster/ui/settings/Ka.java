package com.nexstreaming.kinemaster.ui.settings;

import android.os.Handler;
import android.preference.PreferenceManager;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class Ka implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Ua f23064a;

    public Ka(Ua ua) {
        this.f23064a = ua;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        boolean z;
        handler = this.f23064a.f23088e;
        runnable = this.f23064a.f23090g;
        handler.removeCallbacks(runnable);
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this.f23064a.getActivity()).getBoolean("asset_dev_mode", false);
        z = this.f23064a.f23086c;
        if (z == z2) {
            return;
        }
        this.f23064a.f23086c = z2;
        e.a aVar = new e.a(this.f23064a.getActivity());
        aVar.a("Restart KineMaster to apply Asset Developer Mode change?");
        aVar.c(R.string.button_ok, new Ja(this));
        aVar.a(R.string.button_cancel, new Ia(this));
        aVar.a().show();
    }
}
