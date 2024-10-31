package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.view.ViewProcessor;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class View {

    /* renamed from: a, reason: collision with root package name */
    private final QuerySpec f17127a;

    /* renamed from: b, reason: collision with root package name */
    private final ViewProcessor f17128b;

    /* renamed from: c, reason: collision with root package name */
    private ViewCache f17129c;

    /* renamed from: d, reason: collision with root package name */
    private final List<EventRegistration> f17130d;

    /* renamed from: e, reason: collision with root package name */
    private final EventGenerator f17131e;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class OperationResult {

        /* renamed from: a, reason: collision with root package name */
        public final List<DataEvent> f17132a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Change> f17133b;

        public OperationResult(List<DataEvent> list, List<Change> list2) {
            this.f17132a = list;
            this.f17133b = list2;
        }
    }

    public View(QuerySpec querySpec, ViewCache viewCache) {
        this.f17127a = querySpec;
        IndexedFilter indexedFilter = new IndexedFilter(querySpec.a());
        NodeFilter g2 = querySpec.b().g();
        this.f17128b = new ViewProcessor(g2);
        CacheNode d2 = viewCache.d();
        CacheNode c2 = viewCache.c();
        IndexedNode a2 = IndexedNode.a(EmptyNode.e(), querySpec.a());
        IndexedNode a3 = indexedFilter.a(a2, d2.a(), null);
        IndexedNode a4 = g2.a(a2, c2.a(), null);
        this.f17129c = new ViewCache(new CacheNode(a4, c2.d(), g2.b()), new CacheNode(a3, d2.d(), indexedFilter.b()));
        this.f17130d = new ArrayList();
        this.f17131e = new EventGenerator(querySpec);
    }

    public Node a() {
        return this.f17129c.c().b();
    }

    public QuerySpec b() {
        return this.f17127a;
    }

    public Node c() {
        return this.f17129c.d().b();
    }

    public boolean d() {
        return this.f17130d.isEmpty();
    }

    public Node a(Path path) {
        Node b2 = this.f17129c.b();
        if (b2 == null) {
            return null;
        }
        if (this.f17127a.e() || !(path.isEmpty() || b2.a(path.f()).isEmpty())) {
            return b2.a(path);
        }
        return null;
    }

    public List<DataEvent> b(EventRegistration eventRegistration) {
        CacheNode c2 = this.f17129c.c();
        ArrayList arrayList = new ArrayList();
        for (NamedNode namedNode : c2.b()) {
            arrayList.add(Change.a(namedNode.c(), namedNode.d()));
        }
        if (c2.d()) {
            arrayList.add(Change.a(c2.a()));
        }
        return a(arrayList, c2.a(), eventRegistration);
    }

    public void a(@NotNull EventRegistration eventRegistration) {
        this.f17130d.add(eventRegistration);
    }

    public List<Event> a(@Nullable EventRegistration eventRegistration, DatabaseError databaseError) {
        List<Event> emptyList;
        if (databaseError != null) {
            emptyList = new ArrayList<>();
            Path c2 = this.f17127a.c();
            Iterator<EventRegistration> it = this.f17130d.iterator();
            while (it.hasNext()) {
                emptyList.add(new CancelEvent(it.next(), databaseError, c2));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        if (eventRegistration != null) {
            int i = 0;
            int i2 = -1;
            while (true) {
                if (i >= this.f17130d.size()) {
                    i = i2;
                    break;
                }
                EventRegistration eventRegistration2 = this.f17130d.get(i);
                if (eventRegistration2.a(eventRegistration)) {
                    if (eventRegistration2.b()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            if (i != -1) {
                EventRegistration eventRegistration3 = this.f17130d.get(i);
                this.f17130d.remove(i);
                eventRegistration3.c();
            }
        } else {
            Iterator<EventRegistration> it2 = this.f17130d.iterator();
            while (it2.hasNext()) {
                it2.next().c();
            }
            this.f17130d.clear();
        }
        return emptyList;
    }

    public OperationResult a(Operation operation, WriteTreeRef writeTreeRef, Node node) {
        if (operation.c() == Operation.OperationType.Merge) {
            operation.b().a();
        }
        ViewProcessor.ProcessorResult a2 = this.f17128b.a(this.f17129c, operation, writeTreeRef, node);
        ViewCache viewCache = a2.f17138a;
        this.f17129c = viewCache;
        return new OperationResult(a(a2.f17139b, viewCache.c().a(), (EventRegistration) null), a2.f17139b);
    }

    private List<DataEvent> a(List<Change> list, IndexedNode indexedNode, EventRegistration eventRegistration) {
        List<EventRegistration> asList;
        if (eventRegistration == null) {
            asList = this.f17130d;
        } else {
            asList = Arrays.asList(eventRegistration);
        }
        return this.f17131e.a(list, indexedNode, asList);
    }
}
