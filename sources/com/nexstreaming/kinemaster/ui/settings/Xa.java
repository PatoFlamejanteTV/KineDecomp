package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.settings.Ua;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
class Xa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f23099a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ua.b f23100b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(Ua.b bVar, String[] strArr) {
        this.f23100b = bVar;
        this.f23099a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        i2 = Ua.b.f23091a;
        if (i != i2) {
            this.f23100b.f23092b = i;
            return;
        }
        Ua.b bVar = this.f23100b;
        i3 = Ua.b.f23091a;
        bVar.f23092b = i3;
    }
}
