package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class InternalHelpers {
    public static DatabaseReference a(Repo repo, Path path) {
        return new DatabaseReference(repo, path);
    }

    public static DataSnapshot a(DatabaseReference databaseReference, IndexedNode indexedNode) {
        return new DataSnapshot(databaseReference, indexedNode);
    }

    public static MutableData a(Node node) {
        return new MutableData(node);
    }
}
