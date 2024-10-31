package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: NexEditorDeviceProfile.java */
/* renamed from: com.nextreaming.nexeditorui.la */
/* loaded from: classes.dex */
public class C2319la extends NexEditorDeviceProfile.b {

    /* renamed from: c */
    final /* synthetic */ NexEditorDeviceProfile f24312c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2319la(NexEditorDeviceProfile nexEditorDeviceProfile, String str) {
        super(str);
        this.f24312c = nexEditorDeviceProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        boolean a2;
        boolean a3;
        boolean a4;
        if (i >= aVar.f24091f && i <= aVar.f24092g) {
            a2 = this.f24312c.a(aVar.f24088c);
            if (a2) {
                a3 = this.f24312c.a(aVar.f24087b);
                if (a3) {
                    a4 = this.f24312c.a(aVar.f24090e);
                    if (a4 && aVar.f24089d.equalsIgnoreCase(Build.MANUFACTURER)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
