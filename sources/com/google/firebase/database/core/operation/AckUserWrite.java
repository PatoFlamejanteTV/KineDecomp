package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class AckUserWrite extends Operation {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f16996d;

    /* renamed from: e, reason: collision with root package name */
    private final ImmutableTree<Boolean> f16997e;

    public AckUserWrite(Path path, ImmutableTree<Boolean> immutableTree, boolean z) {
        super(Operation.OperationType.AckUserWrite, OperationSource.f17002a, path);
        this.f16997e = immutableTree;
        this.f16996d = z;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation a(ChildKey childKey) {
        if (!this.f17001c.isEmpty()) {
            Utilities.a(this.f17001c.f().equals(childKey), "operationForChild called for unrelated child.");
            return new AckUserWrite(this.f17001c.g(), this.f16997e, this.f16996d);
        }
        if (this.f16997e.getValue() != null) {
            Utilities.a(this.f16997e.d().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        }
        return new AckUserWrite(Path.e(), this.f16997e.f(new Path(childKey)), this.f16996d);
    }

    public ImmutableTree<Boolean> d() {
        return this.f16997e;
    }

    public boolean e() {
        return this.f16996d;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", a(), Boolean.valueOf(this.f16996d), this.f16997e);
    }
}
