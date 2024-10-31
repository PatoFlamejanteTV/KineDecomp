package com.nextreaming.nexeditorui.fontbrowser;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.kinemaster.kmpackage.Font;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class v implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4646a;
    final /* synthetic */ Font b;
    final /* synthetic */ View c;
    final /* synthetic */ u d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, com.nexstreaming.kinemaster.ui.a.a aVar, Font font, View view) {
        this.d = uVar;
        this.f4646a = aVar;
        this.b = font;
        this.c = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4646a.a(-2, false);
        this.f4646a.a(-1, false);
        this.b.l().onComplete(new w(this));
    }
}
