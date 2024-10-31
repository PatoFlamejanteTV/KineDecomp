package com.nexstreaming.kinemaster.ui.settings;

import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.ui.settings.DeviceCapabilityProfileImporter;
import java.io.File;

/* compiled from: DeviceCapabilityProfileImporter.java */
/* loaded from: classes2.dex */
public class O extends DeviceCapabilityProfileImporter.b.a<DeviceCapabilityProfileImporter.a> {

    /* renamed from: c */
    final /* synthetic */ DeviceCapabilityProfileImporter.b f23071c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(DeviceCapabilityProfileImporter.b bVar, DeviceCapabilityProfileImporter.a aVar) {
        super(aVar);
        this.f23071c = bVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.DeviceCapabilityProfileImporter.b.a
    public void a(View view, DeviceCapabilityProfileImporter.a aVar) {
        DeviceCapabilityProfileImporter.this.a(Uri.fromFile(new File(aVar.f23031b)));
    }
}
