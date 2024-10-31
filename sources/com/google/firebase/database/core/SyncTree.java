package com.google.firebase.database.core;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class SyncTree {

    /* renamed from: f, reason: collision with root package name */
    private final ListenProvider f16939f;

    /* renamed from: g, reason: collision with root package name */
    private final PersistenceManager f16940g;

    /* renamed from: h, reason: collision with root package name */
    private final LogWrapper f16941h;
    private long i = 1;

    /* renamed from: a, reason: collision with root package name */
    private ImmutableTree<SyncPoint> f16934a = ImmutableTree.a();

    /* renamed from: b, reason: collision with root package name */
    private final WriteTree f16935b = new WriteTree();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Tag, QuerySpec> f16936c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<QuerySpec, Tag> f16937d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Set<QuerySpec> f16938e = new HashSet();

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface CompletionListener {
        List<? extends Event> a(DatabaseError databaseError);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface ListenProvider {
        void a(QuerySpec querySpec, Tag tag);

        void a(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, CompletionListener completionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public class a implements ListenHashProvider, CompletionListener {

        /* renamed from: a, reason: collision with root package name */
        private final View f16942a;

        /* renamed from: b, reason: collision with root package name */
        private final Tag f16943b;

        public a(View view) {
            this.f16942a = view;
            this.f16943b = SyncTree.this.b(view.b());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public CompoundHash b() {
            com.google.firebase.database.snapshot.CompoundHash a2 = com.google.firebase.database.snapshot.CompoundHash.a(this.f16942a.c());
            List<Path> b2 = a2.b();
            ArrayList arrayList = new ArrayList(b2.size());
            Iterator<Path> it = b2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
            return new CompoundHash(arrayList, a2.a());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public boolean c() {
            return NodeSizeEstimator.a(this.f16942a.c()) > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public String a() {
            return this.f16942a.c().getHash();
        }

        @Override // com.google.firebase.database.core.SyncTree.CompletionListener
        public List<? extends Event> a(DatabaseError databaseError) {
            if (databaseError != null) {
                SyncTree.this.f16941h.b("Listen at " + this.f16942a.b().c() + " failed: " + databaseError.toString());
                return SyncTree.this.a(this.f16942a.b(), databaseError);
            }
            QuerySpec b2 = this.f16942a.b();
            Tag tag = this.f16943b;
            if (tag != null) {
                return SyncTree.this.a(tag);
            }
            return SyncTree.this.a(b2.c());
        }
    }

    public SyncTree(Context context, PersistenceManager persistenceManager, ListenProvider listenProvider) {
        this.f16939f = listenProvider;
        this.f16940g = persistenceManager;
        this.f16941h = context.a("SyncTree");
    }

    public List<Event> b(@NotNull EventRegistration eventRegistration) {
        return a(eventRegistration.a(), eventRegistration, (DatabaseError) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuerySpec b(Tag tag) {
        return this.f16936c.get(tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Tag b(QuerySpec querySpec) {
        return this.f16937d.get(querySpec);
    }

    public Node b(Path path, List<Long> list) {
        ImmutableTree<SyncPoint> immutableTree = this.f16934a;
        immutableTree.getValue();
        Path e2 = Path.e();
        Node node = null;
        ImmutableTree<SyncPoint> immutableTree2 = immutableTree;
        Path path2 = path;
        do {
            ChildKey f2 = path2.f();
            path2 = path2.g();
            e2 = e2.d(f2);
            Path a2 = Path.a(e2, path);
            immutableTree2 = f2 != null ? immutableTree2.d(f2) : ImmutableTree.a();
            SyncPoint value = immutableTree2.getValue();
            if (value != null) {
                node = value.a(a2);
            }
            if (path2.isEmpty()) {
                break;
            }
        } while (node == null);
        return this.f16935b.a(path, node, list, true);
    }

    public List<? extends Event> a(Path path, Node node, Node node2, long j, boolean z, boolean z2) {
        Utilities.a(z || !z2, "We shouldn't be persisting non-visible writes.");
        return (List) this.f16940g.a(new I(this, z2, path, node, j, node2, z));
    }

    public List<? extends Event> a(Path path, CompoundWrite compoundWrite, CompoundWrite compoundWrite2, long j, boolean z) {
        return (List) this.f16940g.a(new J(this, z, path, compoundWrite, j, compoundWrite2));
    }

    public List<? extends Event> a(long j, boolean z, boolean z2, Clock clock) {
        return (List) this.f16940g.a(new K(this, z2, j, z, clock));
    }

    public List<? extends Event> a(Path path, Node node) {
        return (List) this.f16940g.a(new L(this, path, node));
    }

    public List<? extends Event> a(Path path, Map<Path, Node> map) {
        return (List) this.f16940g.a(new M(this, map, path));
    }

    public List<? extends Event> a(Path path, List<RangeMerge> list) {
        SyncPoint c2 = this.f16934a.c(path);
        if (c2 == null) {
            return Collections.emptyList();
        }
        View a2 = c2.a();
        if (a2 != null) {
            Node c3 = a2.c();
            Iterator<RangeMerge> it = list.iterator();
            while (it.hasNext()) {
                c3 = it.next().a(c3);
            }
            return a(path, c3);
        }
        return Collections.emptyList();
    }

    private List<Event> b(Operation operation, ImmutableTree<SyncPoint> immutableTree, Node node, WriteTreeRef writeTreeRef) {
        if (operation.a().isEmpty()) {
            return a(operation, immutableTree, node, writeTreeRef);
        }
        SyncPoint value = immutableTree.getValue();
        if (node == null && value != null) {
            node = value.a(Path.e());
        }
        ArrayList arrayList = new ArrayList();
        ChildKey f2 = operation.a().f();
        Operation a2 = operation.a(f2);
        ImmutableTree<SyncPoint> b2 = immutableTree.d().b(f2);
        if (b2 != null && a2 != null) {
            arrayList.addAll(b(a2, b2, node != null ? node.a(f2) : null, writeTreeRef.a(f2)));
        }
        if (value != null) {
            arrayList.addAll(value.a(operation, writeTreeRef, node));
        }
        return arrayList;
    }

    public List<? extends Event> a(Path path, List<RangeMerge> list, Tag tag) {
        QuerySpec b2 = b(tag);
        if (b2 != null) {
            Node c2 = this.f16934a.c(b2.c()).b(b2).c();
            Iterator<RangeMerge> it = list.iterator();
            while (it.hasNext()) {
                c2 = it.next().a(c2);
            }
            return a(path, c2, tag);
        }
        return Collections.emptyList();
    }

    public List<? extends Event> a(Path path) {
        return (List) this.f16940g.a(new N(this, path));
    }

    public List<? extends Event> a(Tag tag) {
        return (List) this.f16940g.a(new O(this, tag));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<? extends Event> a(QuerySpec querySpec, Operation operation) {
        Path c2 = querySpec.c();
        return this.f16934a.c(c2).a(operation, this.f16935b.a(c2), (Node) null);
    }

    public List<? extends Event> a(Path path, Node node, Tag tag) {
        return (List) this.f16940g.a(new P(this, tag, path, node));
    }

    public List<? extends Event> a(Path path, Map<Path, Node> map, Tag tag) {
        return (List) this.f16940g.a(new D(this, tag, path, map));
    }

    public List<? extends Event> a(@NotNull EventRegistration eventRegistration) {
        return (List) this.f16940g.a(new E(this, eventRegistration));
    }

    public List<Event> a(@NotNull QuerySpec querySpec, @NotNull DatabaseError databaseError) {
        return a(querySpec, (EventRegistration) null, databaseError);
    }

    private List<Event> a(@NotNull QuerySpec querySpec, @Nullable EventRegistration eventRegistration, @Nullable DatabaseError databaseError) {
        return (List) this.f16940g.a(new F(this, querySpec, eventRegistration, databaseError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<View> a(ImmutableTree<SyncPoint> immutableTree) {
        ArrayList arrayList = new ArrayList();
        a(immutableTree, arrayList);
        return arrayList;
    }

    private void a(ImmutableTree<SyncPoint> immutableTree, List<View> list) {
        SyncPoint value = immutableTree.getValue();
        if (value != null && value.c()) {
            list.add(value.a());
            return;
        }
        if (value != null) {
            list.addAll(value.b());
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<SyncPoint>>> it = immutableTree.d().iterator();
        while (it.hasNext()) {
            a(it.next().getValue(), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<QuerySpec> list) {
        for (QuerySpec querySpec : list) {
            if (!querySpec.e()) {
                Tag b2 = b(querySpec);
                this.f16937d.remove(querySpec);
                this.f16936c.remove(b2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QuerySpec a(QuerySpec querySpec) {
        return (!querySpec.e() || querySpec.d()) ? querySpec : QuerySpec.a(querySpec.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(QuerySpec querySpec, View view) {
        Path c2 = querySpec.c();
        Tag b2 = b(querySpec);
        a aVar = new a(view);
        this.f16939f.a(a(querySpec), b2, aVar, aVar);
        ImmutableTree<SyncPoint> f2 = this.f16934a.f(c2);
        if (b2 != null) {
            return;
        }
        f2.a(new G(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Tag a() {
        long j = this.i;
        this.i = 1 + j;
        return new Tag(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Event> a(Operation operation) {
        return b(operation, this.f16934a, null, this.f16935b.a(Path.e()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Event> a(Operation operation, ImmutableTree<SyncPoint> immutableTree, Node node, WriteTreeRef writeTreeRef) {
        SyncPoint value = immutableTree.getValue();
        if (node == null && value != null) {
            node = value.a(Path.e());
        }
        ArrayList arrayList = new ArrayList();
        immutableTree.d().a(new H(this, node, writeTreeRef, operation, arrayList));
        if (value != null) {
            arrayList.addAll(value.a(operation, writeTreeRef, node));
        }
        return arrayList;
    }
}
