package io.grpc.internal;

import com.google.common.base.Supplier;
import java.net.ProxySelector;

/* compiled from: ProxyDetectorImpl.java */
/* renamed from: io.grpc.internal.ac */
/* loaded from: classes3.dex */
class C2414ac implements Supplier<ProxySelector> {
    @Override // com.google.common.base.Supplier
    public ProxySelector get() {
        return ProxySelector.getDefault();
    }
}
