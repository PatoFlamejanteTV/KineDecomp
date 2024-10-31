package com.google.firebase.database.core.persistence;

import android.util.Log;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class NoopPersistenceManager implements PersistenceManager {

    /* renamed from: a, reason: collision with root package name */
    private boolean f17018a = false;

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, Node node, long j) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void b(Path path, CompoundWrite compoundWrite) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void c(QuerySpec querySpec) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void d(QuerySpec querySpec) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, CompoundWrite compoundWrite, long j) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void b(QuerySpec querySpec) {
        b();
    }

    private void b() {
        Utilities.a(this.f17018a, "Transaction expected to already be in progress.");
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(long j) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, Node node) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(Path path, CompoundWrite compoundWrite) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public List<UserWriteRecord> a() {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public CacheNode a(QuerySpec querySpec) {
        return new CacheNode(IndexedNode.a(EmptyNode.e(), querySpec.a()), false, false);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(QuerySpec querySpec, Node node) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(QuerySpec querySpec, Set<ChildKey> set) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void a(QuerySpec querySpec, Set<ChildKey> set, Set<ChildKey> set2) {
        b();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public <T> T a(Callable<T> callable) {
        Utilities.a(!this.f17018a, "runInTransaction called when an existing transaction is already in progress.");
        this.f17018a = true;
        try {
            try {
                return callable.call();
            } catch (Throwable th) {
                Log.e("NoopPersistenceManager", "Caught Throwable.", th);
                throw new RuntimeException(th);
            }
        } finally {
            this.f17018a = false;
        }
    }
}
