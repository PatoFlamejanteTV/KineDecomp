package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public /* synthetic */ class e {

    /* renamed from: a */
    static final /* synthetic */ int[] f17227a = new int[Node.HashVersion.values().length];

    static {
        try {
            f17227a[Node.HashVersion.V1.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17227a[Node.HashVersion.V2.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
