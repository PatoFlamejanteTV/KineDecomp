package com.nextreaming.nexeditorui;

import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: NexEditorDeviceProfile.java */
/* renamed from: com.nextreaming.nexeditorui.ma */
/* loaded from: classes.dex */
public class C2321ma extends NexEditorDeviceProfile.b {

    /* renamed from: c */
    final /* synthetic */ String f24315c;

    /* renamed from: d */
    final /* synthetic */ NexEditorDeviceProfile f24316d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2321ma(NexEditorDeviceProfile nexEditorDeviceProfile, String str, String str2) {
        super(str);
        this.f24316d = nexEditorDeviceProfile;
        this.f24315c = str2;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        boolean a2;
        boolean a3;
        boolean a4;
        if (i >= aVar.f24091f && i <= aVar.f24092g) {
            a2 = this.f24316d.a(aVar.f24088c);
            if (a2) {
                a3 = this.f24316d.a(aVar.f24087b);
                if (a3) {
                    a4 = this.f24316d.a(aVar.f24089d);
                    if (a4 && aVar.f24090e.equalsIgnoreCase(this.f24315c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
