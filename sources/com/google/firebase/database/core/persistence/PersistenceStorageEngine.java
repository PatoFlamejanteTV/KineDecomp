package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface PersistenceStorageEngine {
    void C();

    void E();

    void F();

    Node a(Path path);

    List<UserWriteRecord> a();

    Set<ChildKey> a(Set<Long> set);

    void a(long j);

    void a(long j, Set<ChildKey> set);

    void a(long j, Set<ChildKey> set, Set<ChildKey> set2);

    void a(Path path, CompoundWrite compoundWrite);

    void a(Path path, CompoundWrite compoundWrite, long j);

    void a(Path path, PruneForest pruneForest);

    void a(Path path, Node node);

    void a(Path path, Node node, long j);

    void a(TrackedQuery trackedQuery);

    long b();

    void b(long j);

    void b(Path path, Node node);

    List<TrackedQuery> c();

    void c(long j);

    Set<ChildKey> d(long j);
}
