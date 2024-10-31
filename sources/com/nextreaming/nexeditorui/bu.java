package com.nextreaming.nexeditorui;

import android.os.Build;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditorDeviceProfile.java */
/* loaded from: classes.dex */
public class bu extends NexEditorDeviceProfile.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4557a;
    final /* synthetic */ NexEditorDeviceProfile b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(NexEditorDeviceProfile nexEditorDeviceProfile, String str, String str2) {
        super(str);
        this.b = nexEditorDeviceProfile;
        this.f4557a = str2;
    }

    @Override // com.nextreaming.nexeditorui.NexEditorDeviceProfile.b
    public boolean a(NexEditorDeviceProfile.a aVar, int i) {
        boolean e;
        boolean e2;
        if (i >= aVar.f && i <= aVar.g) {
            e = this.b.e(aVar.c);
            if (e) {
                e2 = this.b.e(aVar.b);
                if (e2 && aVar.d.equalsIgnoreCase(Build.MANUFACTURER) && aVar.e.equalsIgnoreCase(this.f4557a)) {
                    return true;
                }
            }
        }
        return false;
    }
}
