package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorDeviceProfile.java */
/* loaded from: classes.dex */
public class bv extends NexEditorDeviceProfile.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorDeviceProfile f4558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(NexEditorDeviceProfile nexEditorDeviceProfile, String str) {
        super(str);
        this.f4558a = nexEditorDeviceProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        boolean e;
        boolean e2;
        boolean e3;
        if (i >= aVar.f && i <= aVar.g) {
            e = this.f4558a.e(aVar.c);
            if (e) {
                e2 = this.f4558a.e(aVar.b);
                if (e2) {
                    e3 = this.f4558a.e(aVar.e);
                    if (e3 && aVar.d.equalsIgnoreCase(Build.MANUFACTURER)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
