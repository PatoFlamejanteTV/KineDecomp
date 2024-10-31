package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* compiled from: NexEditorDeviceProfile.java */
/* renamed from: com.nextreaming.nexeditorui.ka */
/* loaded from: classes.dex */
public class C2317ka extends NexEditorDeviceProfile.b {

    /* renamed from: c */
    final /* synthetic */ String f24307c;

    /* renamed from: d */
    final /* synthetic */ NexEditorDeviceProfile f24308d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2317ka(NexEditorDeviceProfile nexEditorDeviceProfile, String str, String str2) {
        super(str);
        this.f24308d = nexEditorDeviceProfile;
        this.f24307c = str2;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        boolean a2;
        boolean a3;
        if (i >= aVar.f24091f && i <= aVar.f24092g) {
            a2 = this.f24308d.a(aVar.f24088c);
            if (a2) {
                a3 = this.f24308d.a(aVar.f24087b);
                if (a3 && aVar.f24089d.equalsIgnoreCase(Build.MANUFACTURER) && aVar.f24090e.equalsIgnoreCase(this.f24307c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
