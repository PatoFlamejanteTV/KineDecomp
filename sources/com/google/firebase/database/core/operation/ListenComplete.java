package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ListenComplete extends Operation {
    public ListenComplete(OperationSource operationSource, Path path) {
        super(Operation.OperationType.ListenComplete, operationSource, path);
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation a(ChildKey childKey) {
        if (this.f17001c.isEmpty()) {
            return new ListenComplete(this.f17000b, Path.e());
        }
        return new ListenComplete(this.f17000b, this.f17001c.g());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", a(), b());
    }
}
