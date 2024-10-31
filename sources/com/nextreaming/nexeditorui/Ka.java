package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.La;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class Ka implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f24051a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ La.a f24052b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(La.a aVar, String[] strArr) {
        this.f24052b = aVar;
        this.f24051a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        i2 = La.a.f24064a;
        if (i != i2) {
            this.f24052b.f24065b = i;
            return;
        }
        La.a aVar = this.f24052b;
        i3 = La.a.f24064a;
        aVar.f24065b = i3;
    }
}
