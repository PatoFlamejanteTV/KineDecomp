package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: NexEditorDeviceProfile.java */
/* renamed from: com.nextreaming.nexeditorui.ja */
/* loaded from: classes.dex */
public class C2315ja extends NexEditorDeviceProfile.b {

    /* renamed from: c */
    final /* synthetic */ NexEditorDeviceProfile f24302c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2315ja(NexEditorDeviceProfile nexEditorDeviceProfile, String str) {
        super(str);
        this.f24302c = nexEditorDeviceProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        return i >= aVar.f24091f && i <= aVar.f24092g && aVar.f24087b.equalsIgnoreCase(Build.MODEL);
    }
}
