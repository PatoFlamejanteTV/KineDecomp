package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.cl;

/* compiled from: NexPrefsFrag.java */
/* loaded from: classes.dex */
class cv implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f4584a;
    final /* synthetic */ cl.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cl.a aVar, String[] strArr) {
        this.b = aVar;
        this.f4584a = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        int i3;
        i2 = cl.a.f4576a;
        if (i != i2) {
            this.b.b = i;
            return;
        }
        cl.a aVar = this.b;
        i3 = cl.a.f4576a;
        aVar.b = i3;
    }
}
