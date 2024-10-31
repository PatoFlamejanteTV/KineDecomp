package com.google.firebase.iid;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.firebase.iid.h */
/* loaded from: classes2.dex */
public final class C1611h extends AbstractC1612i<Void> {
    public C1611h(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // com.google.firebase.iid.AbstractC1612i
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            a((C1611h) null);
        } else {
            a(new zzal(4, "Invalid response to one way request"));
        }
    }

    @Override // com.google.firebase.iid.AbstractC1612i
    public final boolean a() {
        return true;
    }
}
