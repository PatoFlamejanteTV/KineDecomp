package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorDeviceProfile.java */
/* loaded from: classes.dex */
public class bt extends NexEditorDeviceProfile.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorDeviceProfile f4556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(NexEditorDeviceProfile nexEditorDeviceProfile, String str) {
        super(str);
        this.f4556a = nexEditorDeviceProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        return i >= aVar.f && i <= aVar.g && aVar.b.equalsIgnoreCase(Build.MODEL);
    }
}
