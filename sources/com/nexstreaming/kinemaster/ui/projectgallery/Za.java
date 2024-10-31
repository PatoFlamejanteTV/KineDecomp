package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Za implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f22899a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC2098bb f22900b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(ViewOnClickListenerC2098bb viewOnClickListenerC2098bb, Intent intent) {
        this.f22900b = viewOnClickListenerC2098bb;
        this.f22899a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent;
        if (!c.d.b.m.i.f(this.f22900b.f22908b.f22914a) || (intent = this.f22899a) == null) {
            return;
        }
        this.f22900b.f22908b.f22914a.startActivity(intent);
        dialogInterface.dismiss();
    }
}
