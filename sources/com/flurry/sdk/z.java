package com.flurry.sdk;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends bc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.f499a = wVar;
    }

    @Override // com.flurry.sdk.bc
    public void a() {
        List list;
        List list2;
        u f = this.f499a.f();
        list = this.f499a.s;
        list.clear();
        list2 = this.f499a.s;
        list2.add(f);
        this.f499a.w();
    }
}
