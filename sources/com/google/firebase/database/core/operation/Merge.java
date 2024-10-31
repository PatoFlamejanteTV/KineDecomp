package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Merge extends Operation {

    /* renamed from: d, reason: collision with root package name */
    private final CompoundWrite f16998d;

    public Merge(OperationSource operationSource, Path path, CompoundWrite compoundWrite) {
        super(Operation.OperationType.Merge, operationSource, path);
        this.f16998d = compoundWrite;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation a(ChildKey childKey) {
        if (this.f17001c.isEmpty()) {
            CompoundWrite b2 = this.f16998d.b(new Path(childKey));
            if (b2.isEmpty()) {
                return null;
            }
            if (b2.f() != null) {
                return new Overwrite(this.f17000b, Path.e(), b2.f());
            }
            return new Merge(this.f17000b, Path.e(), b2);
        }
        if (this.f17001c.f().equals(childKey)) {
            return new Merge(this.f17000b, this.f17001c.g(), this.f16998d);
        }
        return null;
    }

    public CompoundWrite d() {
        return this.f16998d;
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", a(), b(), this.f16998d);
    }
}
