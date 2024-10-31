package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
public class K implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityReport.CapabilityInfo f23062a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeviceCapabilityProfileImporter f23063b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(DeviceCapabilityProfileImporter deviceCapabilityProfileImporter, CapabilityReport.CapabilityInfo capabilityInfo) {
        this.f23063b = deviceCapabilityProfileImporter;
        this.f23062a = capabilityInfo;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CapabilityManager.f20040b.a(this.f23062a, "Test", false);
        this.f23063b.M();
    }
}
