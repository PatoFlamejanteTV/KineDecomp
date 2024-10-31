package com.google.firebase.iid;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.firebase.iid.j */
/* loaded from: classes2.dex */
public final class C1613j extends AbstractC1612i<Bundle> {
    public C1613j(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // com.google.firebase.iid.AbstractC1612i
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(ShareConstants.WEB_DIALOG_PARAM_DATA);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        a((C1613j) bundle2);
    }

    @Override // com.google.firebase.iid.AbstractC1612i
    public final boolean a() {
        return false;
    }
}
