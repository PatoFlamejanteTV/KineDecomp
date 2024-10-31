package com.nexstreaming.kinemaster.ui.settings;

import android.view.MenuItem;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nextreaming.nexeditorui.a.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsActivity.java */
/* loaded from: classes2.dex */
public class db implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f23134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(SettingsActivity settingsActivity) {
        this.f23134a = settingsActivity;
    }

    @Override // com.nextreaming.nexeditorui.a.a.b.a
    public void a(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case R.id.maxmize_features /* 2131362977 */:
                CapabilityManager.f20040b.c(CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES);
                CapabilityManager.f20040b.b(CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES);
                if (this.f23134a.getFragmentManager() != null && (this.f23134a.getFragmentManager().findFragmentById(R.id.container) instanceof G)) {
                    ((G) this.f23134a.getFragmentManager().findFragmentById(R.id.container)).a(CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES);
                }
                CapabilityManager.f20040b.u();
                return;
            case R.id.maxmize_resolution /* 2131362978 */:
                CapabilityManager.f20040b.c(CapabilityManager.CapabilityMode.MAXIMIZE_RESOLUTION);
                CapabilityManager.f20040b.b(CapabilityManager.CapabilityMode.MAXIMIZE_RESOLUTION);
                if (this.f23134a.getFragmentManager() != null && (this.f23134a.getFragmentManager().findFragmentById(R.id.container) instanceof G)) {
                    ((G) this.f23134a.getFragmentManager().findFragmentById(R.id.container)).a(CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES);
                }
                CapabilityManager.f20040b.u();
                return;
            case R.id.run_analysis_now /* 2131363342 */:
                this.f23134a.K();
                return;
            default:
                return;
        }
    }
}
