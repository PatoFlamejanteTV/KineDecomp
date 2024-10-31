package com.nexstreaming.app.general.iab.a;

import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import java.util.List;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class i implements IABHelper.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f3151a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, List list, int i) {
        this.c = aVar;
        this.f3151a = list;
        this.b = i;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.f
    public void a(Purchase purchase, int i) {
        ((List) this.f3151a.get((((((IABHelper.f3141a >> 4) & 15) ^ i) + this.b) - 12) & 7)).add(purchase);
    }
}
