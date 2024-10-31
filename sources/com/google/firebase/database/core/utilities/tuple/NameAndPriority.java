package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class NameAndPriority implements Comparable<NameAndPriority> {

    /* renamed from: a, reason: collision with root package name */
    private ChildKey f17094a;

    /* renamed from: b, reason: collision with root package name */
    private Node f17095b;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(NameAndPriority nameAndPriority) {
        return NodeUtilities.a(this.f17094a, this.f17095b, nameAndPriority.f17094a, nameAndPriority.f17095b);
    }
}
