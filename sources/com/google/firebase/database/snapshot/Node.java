package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public interface Node extends Comparable<Node>, Iterable<NamedNode> {

    /* renamed from: c */
    public static final ChildrenNode f17215c = new f();

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum HashVersion {
        V1,
        V2
    }

    Node a(Path path);

    Node a(Path path, Node node);

    Node a(ChildKey childKey);

    Node a(ChildKey childKey, Node node);

    Node a(Node node);

    Object a(boolean z);

    String a(HashVersion hashVersion);

    boolean b();

    boolean b(ChildKey childKey);

    ChildKey c(ChildKey childKey);

    Iterator<NamedNode> c();

    int getChildCount();

    String getHash();

    Node getPriority();

    Object getValue();

    boolean isEmpty();
}
