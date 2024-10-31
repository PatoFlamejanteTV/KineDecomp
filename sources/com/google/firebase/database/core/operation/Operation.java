package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public abstract class Operation {

    /* renamed from: a */
    protected final OperationType f16999a;

    /* renamed from: b */
    protected final OperationSource f17000b;

    /* renamed from: c */
    protected final Path f17001c;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum OperationType {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    public Operation(OperationType operationType, OperationSource operationSource, Path path) {
        this.f16999a = operationType;
        this.f17000b = operationSource;
        this.f17001c = path;
    }

    public Path a() {
        return this.f17001c;
    }

    public abstract Operation a(ChildKey childKey);

    public OperationSource b() {
        return this.f17000b;
    }

    public OperationType c() {
        return this.f16999a;
    }
}
