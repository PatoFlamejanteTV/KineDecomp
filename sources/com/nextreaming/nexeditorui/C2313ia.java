package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: NexEditorDeviceProfile.java */
/* renamed from: com.nextreaming.nexeditorui.ia */
/* loaded from: classes.dex */
public class C2313ia extends NexEditorDeviceProfile.b {

    /* renamed from: c */
    final /* synthetic */ NexEditorDeviceProfile f24295c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2313ia(NexEditorDeviceProfile nexEditorDeviceProfile, String str) {
        super(str);
        this.f24295c = nexEditorDeviceProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        return i >= aVar.f24091f && i <= aVar.f24092g && aVar.f24088c.equalsIgnoreCase(Build.DEVICE);
    }
}
