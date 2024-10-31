package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class N implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private static final N f17806a = new N();

    private N() {
    }

    public static io.reactivex.c.e a() {
        return f17806a;
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.c(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(((FetchEligibleCampaignsResponse) obj).p().size())));
    }
}
