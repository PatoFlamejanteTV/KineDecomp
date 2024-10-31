package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.settings.x;

/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f4243a;
    final /* synthetic */ x.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(x.b bVar, String[] strArr) {
        this.b = bVar;
        this.f4243a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        i2 = x.b.f4273a;
        if (i != i2) {
            this.b.b = i;
            return;
        }
        x.b bVar = this.b;
        i3 = x.b.f4273a;
        bVar.b = i3;
    }
}
