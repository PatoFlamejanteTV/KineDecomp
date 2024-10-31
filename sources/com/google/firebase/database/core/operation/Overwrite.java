package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Overwrite extends Operation {

    /* renamed from: d */
    private final Node f17008d;

    public Overwrite(OperationSource operationSource, Path path, Node node) {
        super(Operation.OperationType.Overwrite, operationSource, path);
        this.f17008d = node;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation a(ChildKey childKey) {
        if (this.f17001c.isEmpty()) {
            return new Overwrite(this.f17000b, Path.e(), this.f17008d.a(childKey));
        }
        return new Overwrite(this.f17000b, this.f17001c.g(), this.f17008d);
    }

    public Node d() {
        return this.f17008d;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", a(), b(), this.f17008d);
    }
}
