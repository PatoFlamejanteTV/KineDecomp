package com.facebook.marketing.internal;

import com.facebook.FacebookSdk;

/* compiled from: MarketingInitProvider.java */
/* loaded from: classes.dex */
class d implements FacebookSdk.InitializeCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MarketingInitProvider f9447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MarketingInitProvider marketingInitProvider) {
        this.f9447a = marketingInitProvider;
    }

    @Override // com.facebook.FacebookSdk.InitializeCallback
    public void onInitialized() {
        this.f9447a.setupCodeless();
    }
}
