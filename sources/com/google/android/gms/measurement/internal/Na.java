package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Na implements InterfaceC1416g {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13670a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzfo f13671b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(zzfo zzfoVar, String str) {
        this.f13671b = zzfoVar;
        this.f13670a = str;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC1416g
    public final void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f13671b.a(i, th, bArr, this.f13670a);
    }
}
