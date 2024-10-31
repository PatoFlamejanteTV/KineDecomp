package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.C;
import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetOneUpRecyclerViewController.java */
/* loaded from: classes.dex */
public class m implements C.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o.a.ViewOnClickListenerC0035a f6293a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ o.a f6294b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o.a aVar, o.a.ViewOnClickListenerC0035a viewOnClickListenerC0035a) {
        this.f6294b = aVar;
        this.f6293a = viewOnClickListenerC0035a;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.C.a
    public void a() {
        o.this.o.a(AdobeMultiPageViewState.AdobeMultiPageListView);
        o.this.o.a(this.f6293a.getAdapterPosition());
    }
}
