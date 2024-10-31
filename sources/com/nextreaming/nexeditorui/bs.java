package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorDeviceProfile.java */
/* loaded from: classes.dex */
public class bs extends NexEditorDeviceProfile.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorDeviceProfile f4555a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(NexEditorDeviceProfile nexEditorDeviceProfile, String str) {
        super(str);
        this.f4555a = nexEditorDeviceProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        return i >= aVar.f && i <= aVar.g && aVar.c.equalsIgnoreCase(Build.DEVICE);
    }
}
