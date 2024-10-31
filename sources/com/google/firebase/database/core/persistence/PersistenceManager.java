package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface PersistenceManager {
    CacheNode a(QuerySpec querySpec);

    <T> T a(Callable<T> callable);

    List<UserWriteRecord> a();

    void a(long j);

    void a(Path path, CompoundWrite compoundWrite);

    void a(Path path, CompoundWrite compoundWrite, long j);

    void a(Path path, Node node);

    void a(Path path, Node node, long j);

    void a(QuerySpec querySpec, Node node);

    void a(QuerySpec querySpec, Set<ChildKey> set);

    void a(QuerySpec querySpec, Set<ChildKey> set, Set<ChildKey> set2);

    void b(Path path, CompoundWrite compoundWrite);

    void b(QuerySpec querySpec);

    void c(QuerySpec querySpec);

    void d(QuerySpec querySpec);
}
