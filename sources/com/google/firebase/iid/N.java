package com.google.firebase.iid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class N implements InstanceIdResult {

    /* renamed from: a */
    private final String f17338a;

    /* renamed from: b */
    private final String f17339b;

    public N(String str, String str2) {
        this.f17338a = str;
        this.f17339b = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String a() {
        return this.f17339b;
    }
}
