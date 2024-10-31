package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public abstract class Index implements Comparator<NamedNode> {
    public abstract NamedNode a(ChildKey childKey, Node node);

    public abstract String a();

    public abstract boolean a(Node node);

    public boolean a(Node node, Node node2) {
        return compare(new NamedNode(ChildKey.e(), node), new NamedNode(ChildKey.e(), node2)) != 0;
    }

    public abstract NamedNode b();

    public NamedNode c() {
        return NamedNode.b();
    }

    public static Index a(String str) {
        if (str.equals(".value")) {
            return ValueIndex.d();
        }
        if (str.equals(".key")) {
            return KeyIndex.d();
        }
        if (!str.equals(".priority")) {
            return new PathIndex(new Path(str));
        }
        throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
    }

    public int a(NamedNode namedNode, NamedNode namedNode2, boolean z) {
        if (z) {
            return compare(namedNode2, namedNode);
        }
        return compare(namedNode, namedNode2);
    }
}
