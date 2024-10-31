package com.nexstreaming.kinemaster.ui.settings;

import android.app.FragmentManager;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
class H implements FragmentManager.OnBackStackChangedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeviceCapabilityProfileImporter f23055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(DeviceCapabilityProfileImporter deviceCapabilityProfileImporter) {
        this.f23055a = deviceCapabilityProfileImporter;
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        if (this.f23055a.getFragmentManager().getBackStackEntryCount() == 0) {
            this.f23055a.H().C.setTitleMode(Toolbar.TitleMode.Title);
            this.f23055a.H().C.setTitle("Device Capability Profile Importer");
        }
    }
}
