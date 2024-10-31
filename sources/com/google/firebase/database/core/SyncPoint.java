package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.core.view.ViewCache;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class SyncPoint {

    /* renamed from: a, reason: collision with root package name */
    private final Map<QueryParams, View> f16932a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final PersistenceManager f16933b;

    public SyncPoint(PersistenceManager persistenceManager) {
        this.f16933b = persistenceManager;
    }

    private List<DataEvent> a(View view, Operation operation, WriteTreeRef writeTreeRef, Node node) {
        View.OperationResult a2 = view.a(operation, writeTreeRef, node);
        if (!view.b().e()) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Change change : a2.f17133b) {
                Event.EventType b2 = change.b();
                if (b2 == Event.EventType.CHILD_ADDED) {
                    hashSet2.add(change.a());
                } else if (b2 == Event.EventType.CHILD_REMOVED) {
                    hashSet.add(change.a());
                }
            }
            if (!hashSet2.isEmpty() || !hashSet.isEmpty()) {
                this.f16933b.a(view.b(), hashSet2, hashSet);
            }
        }
        return a2.f17132a;
    }

    public List<View> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<QueryParams, View>> it = this.f16932a.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            if (!value.b().e()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public boolean c() {
        return a() != null;
    }

    public boolean d() {
        return this.f16932a.isEmpty();
    }

    public View b(QuerySpec querySpec) {
        if (querySpec.e()) {
            return a();
        }
        return this.f16932a.get(querySpec.b());
    }

    public List<DataEvent> a(Operation operation, WriteTreeRef writeTreeRef, Node node) {
        QueryParams a2 = operation.b().a();
        if (a2 != null) {
            return a(this.f16932a.get(a2), operation, writeTreeRef, node);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<QueryParams, View>> it = this.f16932a.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(a(it.next().getValue(), operation, writeTreeRef, node));
        }
        return arrayList;
    }

    public List<DataEvent> a(@NotNull EventRegistration eventRegistration, WriteTreeRef writeTreeRef, CacheNode cacheNode) {
        boolean z;
        QuerySpec a2 = eventRegistration.a();
        View view = this.f16932a.get(a2.b());
        if (view == null) {
            Node a3 = writeTreeRef.a(cacheNode.d() ? cacheNode.b() : null);
            if (a3 != null) {
                z = true;
            } else {
                a3 = writeTreeRef.b(cacheNode.b());
                z = false;
            }
            view = new View(a2, new ViewCache(new CacheNode(IndexedNode.a(a3, a2.a()), z, false), cacheNode));
            if (!a2.e()) {
                HashSet hashSet = new HashSet();
                Iterator<NamedNode> it = view.a().iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().c());
                }
                this.f16933b.a(a2, hashSet);
            }
            this.f16932a.put(a2.b(), view);
        }
        view.a(eventRegistration);
        return view.b(eventRegistration);
    }

    public Pair<List<QuerySpec>, List<Event>> a(@NotNull QuerySpec querySpec, @Nullable EventRegistration eventRegistration, @Nullable DatabaseError databaseError) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean c2 = c();
        if (querySpec.d()) {
            Iterator<Map.Entry<QueryParams, View>> it = this.f16932a.entrySet().iterator();
            while (it.hasNext()) {
                View value = it.next().getValue();
                arrayList2.addAll(value.a(eventRegistration, databaseError));
                if (value.d()) {
                    it.remove();
                    if (!value.b().e()) {
                        arrayList.add(value.b());
                    }
                }
            }
        } else {
            View view = this.f16932a.get(querySpec.b());
            if (view != null) {
                arrayList2.addAll(view.a(eventRegistration, databaseError));
                if (view.d()) {
                    this.f16932a.remove(querySpec.b());
                    if (!view.b().e()) {
                        arrayList.add(view.b());
                    }
                }
            }
        }
        if (c2 && !c()) {
            arrayList.add(QuerySpec.a(querySpec.c()));
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public Node a(Path path) {
        for (View view : this.f16932a.values()) {
            if (view.a(path) != null) {
                return view.a(path);
            }
        }
        return null;
    }

    public boolean a(QuerySpec querySpec) {
        return b(querySpec) != null;
    }

    public View a() {
        Iterator<Map.Entry<QueryParams, View>> it = this.f16932a.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            if (value.b().e()) {
                return value;
            }
        }
        return null;
    }
}
