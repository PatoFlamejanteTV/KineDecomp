package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.util.Collections;
import java.util.List;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* loaded from: classes.dex */
class r implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f6775a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f6776b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f6777c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0525s f6778d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C0525s c0525s, int[] iArr, List list, List list2) {
        this.f6778d = c0525s;
        this.f6775a = iArr;
        this.f6776b = list;
        this.f6777c = list2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        int[] iArr = this.f6775a;
        iArr[0] = iArr[0] + 1;
        boolean z = adobeCSDKException instanceof AdobeNetworkException;
        if (z && ((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorFileDoesNotExist) {
            C0525s c0525s = this.f6778d;
            c0525s.f6784f.put(c0525s.f6780b, new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure));
        }
        if (this.f6775a[0] >= this.f6776b.size()) {
            if (this.f6777c.size() > 0) {
                Collections.sort(this.f6777c, this.f6778d.f6781c);
                ((C0532z) this.f6778d.f6779a.get()).f6578f.addAll(this.f6777c);
            } else {
                if (z && ((AdobeNetworkException) adobeCSDKException).getErrorCode() == AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest) {
                    C0532z.f(this.f6778d.f6786h.f6804e);
                }
                C0532z.d(this.f6778d.f6786h.f6804e);
            }
            this.f6778d.f6782d.lock();
            C0532z.b(this.f6778d.f6786h.f6804e);
            this.f6778d.f6783e.signal();
            this.f6778d.f6782d.unlock();
        }
    }
}
