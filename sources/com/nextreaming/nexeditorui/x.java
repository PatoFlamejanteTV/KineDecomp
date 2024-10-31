package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class X implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24187a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24188b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(I i, int i2) {
        this.f24187a = i;
        this.f24188b = i2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String str;
        dialogInterface.dismiss();
        FirebaseInstanceId b2 = FirebaseInstanceId.b();
        kotlin.jvm.internal.h.a((Object) b2, "FirebaseInstanceId.getInstance()");
        String a2 = b2.a();
        Intent intent = new Intent();
        intent.putExtra("authAccount", a2);
        this.f24187a.onActivityResult(this.f24188b, -1, intent);
        str = I.f24039b;
        Log.i(str, "app instanceId = " + a2);
    }
}
