package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class a implements Comparator<Change> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventGenerator f17143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(EventGenerator eventGenerator) {
        this.f17143a = eventGenerator;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Change change, Change change2) {
        Index index;
        NamedNode namedNode = new NamedNode(change.a(), change.c().e());
        NamedNode namedNode2 = new NamedNode(change2.a(), change2.c().e());
        index = this.f17143a.f17114b;
        return index.compare(namedNode, namedNode2);
    }
}
