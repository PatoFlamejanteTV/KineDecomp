package com.nexstreaming.app.general.iab;

import android.content.DialogInterface;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class v implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19490a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef f19491b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f19492c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(IABManager iABManager, Ref$ObjectRef ref$ObjectRef, DialogInterface.OnClickListener onClickListener) {
        this.f19490a = iABManager;
        this.f19491b = ref$ObjectRef;
        this.f19492c = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        DialogInterface.OnClickListener onClickListener = this.f19492c;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
        this.f19490a.L = null;
    }
}
