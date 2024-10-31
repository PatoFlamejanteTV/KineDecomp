package com.nexstreaming.app.general.iab.Presenter;

import com.android.billingclient.api.AbstractC0693g;
import com.android.billingclient.api.C0688b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.InterfaceC2550t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABGooglePresent.kt */
@kotlin.coroutines.jvm.internal.c(c = "com.nexstreaming.app.general.iab.Presenter.IABGooglePresent$handlePurchase$1", f = "IABGooglePresent.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class IABGooglePresent$handlePurchase$1 extends SuspendLambda implements kotlin.jvm.a.c<InterfaceC2550t, kotlin.coroutines.b<? super kotlin.k>, Object> {
    final /* synthetic */ com.android.billingclient.api.M $purchase;
    int label;
    private InterfaceC2550t p$;
    final /* synthetic */ C1695y this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IABGooglePresent$handlePurchase$1(C1695y c1695y, com.android.billingclient.api.M m, kotlin.coroutines.b bVar) {
        super(2, bVar);
        this.this$0 = c1695y;
        this.$purchase = m;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.b<kotlin.k> create(Object obj, kotlin.coroutines.b<?> bVar) {
        kotlin.jvm.internal.h.b(bVar, "completion");
        IABGooglePresent$handlePurchase$1 iABGooglePresent$handlePurchase$1 = new IABGooglePresent$handlePurchase$1(this.this$0, this.$purchase, bVar);
        iABGooglePresent$handlePurchase$1.p$ = (InterfaceC2550t) obj;
        return iABGooglePresent$handlePurchase$1;
    }

    @Override // kotlin.jvm.a.c
    public final Object invoke(InterfaceC2550t interfaceC2550t, kotlin.coroutines.b<? super kotlin.k> bVar) {
        return ((IABGooglePresent$handlePurchase$1) create(interfaceC2550t, bVar)).invokeSuspend(kotlin.k.f28545a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AbstractC0693g abstractC0693g;
        kotlin.coroutines.intrinsics.c.a();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.h.a(obj);
        InterfaceC2550t interfaceC2550t = this.p$;
        if (!this.$purchase.f()) {
            C0688b.a c2 = C0688b.c();
            c2.a(this.$purchase.c());
            C0688b a2 = c2.a();
            abstractC0693g = this.this$0.l;
            abstractC0693g.a(a2, new C1687p(this));
        }
        return kotlin.k.f28545a;
    }
}
