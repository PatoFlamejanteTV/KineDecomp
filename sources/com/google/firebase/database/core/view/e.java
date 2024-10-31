package com.google.firebase.database.core.view;

import com.google.firebase.database.core.operation.Operation;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
/* synthetic */ class e {

    /* renamed from: a */
    static final /* synthetic */ int[] f17147a = new int[Operation.OperationType.values().length];

    static {
        try {
            f17147a[Operation.OperationType.Overwrite.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17147a[Operation.OperationType.Merge.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17147a[Operation.OperationType.AckUserWrite.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f17147a[Operation.OperationType.ListenComplete.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
