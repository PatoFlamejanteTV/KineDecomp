package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorDeviceProfile.java */
/* loaded from: classes.dex */
public class bw extends NexEditorDeviceProfile.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4559a;
    final /* synthetic */ NexEditorDeviceProfile b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(NexEditorDeviceProfile nexEditorDeviceProfile, String str, String str2) {
        super(str);
        this.b = nexEditorDeviceProfile;
        this.f4559a = str2;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        boolean e;
        boolean e2;
        boolean e3;
        if (i >= aVar.f && i <= aVar.g) {
            e = this.b.e(aVar.c);
            if (e) {
                e2 = this.b.e(aVar.b);
                if (e2) {
                    e3 = this.b.e(aVar.d);
                    if (e3 && aVar.e.equalsIgnoreCase(this.f4559a)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
