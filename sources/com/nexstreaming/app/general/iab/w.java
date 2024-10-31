package com.nexstreaming.app.general.iab;

import android.content.DialogInterface;
import com.nexstreaming.app.general.iab.Presenter.B;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class w implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19493a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef f19494b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DialogInterface.OnClickListener f19495c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(IABManager iABManager, Ref$ObjectRef ref$ObjectRef, DialogInterface.OnClickListener onClickListener) {
        this.f19493a = iABManager;
        this.f19494b = ref$ObjectRef;
        this.f19495c = onClickListener;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        B b2;
        if (this.f19493a.n() != null) {
            if (this.f19493a.n() instanceof B) {
                IABBasePresent n = this.f19493a.n();
                if (n == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.app.general.iab.Presenter.IABWxPresent");
                }
                b2 = (B) n;
            } else {
                b2 = null;
            }
            if (b2 != null && !b2.D()) {
                b2.a(this.f19493a.h());
                return;
            }
        }
        this.f19493a.F();
        dialogInterface.dismiss();
        this.f19493a.L = null;
    }
}
