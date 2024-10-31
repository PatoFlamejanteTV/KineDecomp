package com.nexstreaming.app.general.iab.a;

import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import java.util.List;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class h implements IABHelper.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f3150a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, List list, int i) {
        this.c = aVar;
        this.f3150a = list;
        this.b = i;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.f
    public void a(Purchase purchase, int i) {
        ((List) this.f3150a.get((((((IABHelper.f3141a >> 0) & 15) ^ i) + this.b) - 12) & 7)).add(purchase);
    }
}
