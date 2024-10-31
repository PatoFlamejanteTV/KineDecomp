package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class WriteTree {

    /* renamed from: a, reason: collision with root package name */
    private static final Predicate<UserWriteRecord> f16957a = new T();

    /* renamed from: b, reason: collision with root package name */
    private CompoundWrite f16958b = CompoundWrite.d();

    /* renamed from: c, reason: collision with root package name */
    private List<UserWriteRecord> f16959c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Long f16960d = -1L;

    public WriteTreeRef a(Path path) {
        return new WriteTreeRef(path, this);
    }

    public boolean b(long j) {
        UserWriteRecord userWriteRecord;
        Iterator<UserWriteRecord> it = this.f16959c.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                userWriteRecord = null;
                break;
            }
            userWriteRecord = it.next();
            if (userWriteRecord.d() == j) {
                break;
            }
            i++;
        }
        this.f16959c.remove(userWriteRecord);
        boolean f2 = userWriteRecord.f();
        boolean z = false;
        for (int size = this.f16959c.size() - 1; f2 && size >= 0; size--) {
            UserWriteRecord userWriteRecord2 = this.f16959c.get(size);
            if (userWriteRecord2.f()) {
                if (size >= i && a(userWriteRecord2, userWriteRecord.c())) {
                    f2 = false;
                } else if (userWriteRecord.c().g(userWriteRecord2.c())) {
                    z = true;
                }
            }
        }
        if (!f2) {
            return false;
        }
        if (z) {
            a();
            return true;
        }
        if (userWriteRecord.e()) {
            this.f16958b = this.f16958b.e(userWriteRecord.c());
        } else {
            Iterator<Map.Entry<Path, Node>> it2 = userWriteRecord.a().iterator();
            while (it2.hasNext()) {
                this.f16958b = this.f16958b.e(userWriteRecord.c().e(it2.next().getKey()));
            }
        }
        return true;
    }

    public void a(Path path, Node node, Long l, boolean z) {
        this.f16959c.add(new UserWriteRecord(l.longValue(), path, node, z));
        if (z) {
            this.f16958b = this.f16958b.b(path, node);
        }
        this.f16960d = l;
    }

    public void a(Path path, CompoundWrite compoundWrite, Long l) {
        this.f16959c.add(new UserWriteRecord(l.longValue(), path, compoundWrite));
        this.f16958b = this.f16958b.a(path, compoundWrite);
        this.f16960d = l;
    }

    public UserWriteRecord a(long j) {
        for (UserWriteRecord userWriteRecord : this.f16959c) {
            if (userWriteRecord.d() == j) {
                return userWriteRecord;
            }
        }
        return null;
    }

    public Node a(Path path, Node node, List<Long> list, boolean z) {
        if (list.isEmpty() && !z) {
            Node c2 = this.f16958b.c(path);
            if (c2 != null) {
                return c2;
            }
            CompoundWrite b2 = this.f16958b.b(path);
            if (b2.isEmpty()) {
                return node;
            }
            if (node == null && !b2.d(Path.e())) {
                return null;
            }
            if (node == null) {
                node = EmptyNode.e();
            }
            return b2.b(node);
        }
        CompoundWrite b3 = this.f16958b.b(path);
        if (!z && b3.isEmpty()) {
            return node;
        }
        if (!z && node == null && !b3.d(Path.e())) {
            return null;
        }
        CompoundWrite a2 = a(this.f16959c, new S(this, z, list, path), path);
        if (node == null) {
            node = EmptyNode.e();
        }
        return a2.b(node);
    }

    public Node b(Path path) {
        return this.f16958b.c(path);
    }

    public Node a(Path path, Node node) {
        Node e2 = EmptyNode.e();
        Node c2 = this.f16958b.c(path);
        if (c2 != null) {
            if (!c2.b()) {
                for (NamedNode namedNode : c2) {
                    e2 = e2.a(namedNode.c(), namedNode.d());
                }
            }
            return e2;
        }
        CompoundWrite b2 = this.f16958b.b(path);
        for (NamedNode namedNode2 : node) {
            e2 = e2.a(namedNode2.c(), b2.b(new Path(namedNode2.c())).b(namedNode2.d()));
        }
        for (NamedNode namedNode3 : b2.e()) {
            e2 = e2.a(namedNode3.c(), namedNode3.d());
        }
        return e2;
    }

    public Node a(Path path, Path path2, Node node, Node node2) {
        Path e2 = path.e(path2);
        if (this.f16958b.d(e2)) {
            return null;
        }
        CompoundWrite b2 = this.f16958b.b(e2);
        if (b2.isEmpty()) {
            return node2.a(path2);
        }
        return b2.b(node2.a(path2));
    }

    public Node a(Path path, ChildKey childKey, CacheNode cacheNode) {
        Path d2 = path.d(childKey);
        Node c2 = this.f16958b.c(d2);
        if (c2 != null) {
            return c2;
        }
        if (cacheNode.a(childKey)) {
            return this.f16958b.b(d2).b(cacheNode.b().a(childKey));
        }
        return null;
    }

    public NamedNode a(Path path, Node node, NamedNode namedNode, boolean z, Index index) {
        CompoundWrite b2 = this.f16958b.b(path);
        Node c2 = b2.c(Path.e());
        NamedNode namedNode2 = null;
        if (c2 == null) {
            if (node != null) {
                c2 = b2.b(node);
            }
            return namedNode2;
        }
        for (NamedNode namedNode3 : c2) {
            if (index.a(namedNode3, namedNode, z) > 0 && (namedNode2 == null || index.a(namedNode3, namedNode2, z) < 0)) {
                namedNode2 = namedNode3;
            }
        }
        return namedNode2;
    }

    private boolean a(UserWriteRecord userWriteRecord, Path path) {
        if (userWriteRecord.e()) {
            return userWriteRecord.c().g(path);
        }
        Iterator<Map.Entry<Path, Node>> it = userWriteRecord.a().iterator();
        while (it.hasNext()) {
            if (userWriteRecord.c().e(it.next().getKey()).g(path)) {
                return true;
            }
        }
        return false;
    }

    private void a() {
        this.f16958b = a(this.f16959c, f16957a, Path.e());
        if (this.f16959c.size() > 0) {
            this.f16960d = Long.valueOf(this.f16959c.get(r0.size() - 1).d());
        } else {
            this.f16960d = -1L;
        }
    }

    private static CompoundWrite a(List<UserWriteRecord> list, Predicate<UserWriteRecord> predicate, Path path) {
        CompoundWrite d2 = CompoundWrite.d();
        for (UserWriteRecord userWriteRecord : list) {
            if (predicate.evaluate(userWriteRecord)) {
                Path c2 = userWriteRecord.c();
                if (userWriteRecord.e()) {
                    if (path.g(c2)) {
                        d2 = d2.b(Path.a(path, c2), userWriteRecord.b());
                    } else if (c2.g(path)) {
                        d2 = d2.b(Path.e(), userWriteRecord.b().a(Path.a(c2, path)));
                    }
                } else if (path.g(c2)) {
                    d2 = d2.a(Path.a(path, c2), userWriteRecord.a());
                } else if (c2.g(path)) {
                    Path a2 = Path.a(c2, path);
                    if (a2.isEmpty()) {
                        d2 = d2.a(Path.e(), userWriteRecord.a());
                    } else {
                        Node c3 = userWriteRecord.a().c(a2);
                        if (c3 != null) {
                            d2 = d2.b(Path.e(), c3);
                        }
                    }
                }
            }
        }
        return d2;
    }
}
