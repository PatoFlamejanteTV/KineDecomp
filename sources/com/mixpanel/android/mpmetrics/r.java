package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.mpmetrics.n;

/* compiled from: MixpanelAPI.java */
/* loaded from: classes.dex */
class r extends n.d {
    final /* synthetic */ String b;
    final /* synthetic */ n.d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(n.d dVar, String str) {
        super(n.this, null);
        this.c = dVar;
        this.b = str;
    }

    @Override // com.mixpanel.android.mpmetrics.n.d
    public String d() {
        return this.b;
    }

    @Override // com.mixpanel.android.mpmetrics.n.d, com.mixpanel.android.mpmetrics.n.c
    public void a(String str) {
        throw new RuntimeException("This MixpanelPeople object has a fixed, constant distinctId");
    }
}
