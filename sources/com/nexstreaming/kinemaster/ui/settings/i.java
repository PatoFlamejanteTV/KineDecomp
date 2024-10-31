package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
class I implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeviceCapabilityProfileImporter f23058a;

    public I(DeviceCapabilityProfileImporter deviceCapabilityProfileImporter) {
        this.f23058a = deviceCapabilityProfileImporter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f23058a.getFragmentManager().getBackStackEntryCount() > 0) {
            this.f23058a.getFragmentManager().popBackStackImmediate();
        }
        if (view.getId() == R.id.toolbar_button) {
            this.f23058a.K();
        }
    }
}
