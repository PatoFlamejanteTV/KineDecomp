package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.h */
/* loaded from: classes2.dex */
final class RunnableC1418h implements Runnable {

    /* renamed from: a */
    private final InterfaceC1416g f13765a;

    /* renamed from: b */
    private final int f13766b;

    /* renamed from: c */
    private final Throwable f13767c;

    /* renamed from: d */
    private final byte[] f13768d;

    /* renamed from: e */
    private final String f13769e;

    /* renamed from: f */
    private final Map<String, List<String>> f13770f;

    /* JADX INFO: Access modifiers changed from: private */
    public RunnableC1418h(String str, InterfaceC1416g interfaceC1416g, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.a(interfaceC1416g);
        this.f13765a = interfaceC1416g;
        this.f13766b = i;
        this.f13767c = th;
        this.f13768d = bArr;
        this.f13769e = str;
        this.f13770f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13765a.a(this.f13769e, this.f13766b, this.f13767c, this.f13768d, this.f13770f);
    }

    public /* synthetic */ RunnableC1418h(String str, InterfaceC1416g interfaceC1416g, int i, Throwable th, byte[] bArr, Map map, C1414f c1414f) {
        this(str, interfaceC1416g, i, th, bArr, map);
    }
}
