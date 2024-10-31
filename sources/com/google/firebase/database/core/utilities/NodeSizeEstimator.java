package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.LongNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.StringNode;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class NodeSizeEstimator {
    private static long a(LeafNode<?> leafNode) {
        long j = 8;
        if (!(leafNode instanceof DoubleNode) && !(leafNode instanceof LongNode)) {
            if (leafNode instanceof BooleanNode) {
                j = 4;
            } else if (leafNode instanceof StringNode) {
                j = 2 + ((String) leafNode.getValue()).length();
            } else {
                throw new IllegalArgumentException("Unknown leaf node type: " + leafNode.getClass());
            }
        }
        return leafNode.getPriority().isEmpty() ? j : j + 24 + a((LeafNode<?>) leafNode.getPriority());
    }

    public static int b(Node node) {
        int i = 0;
        if (node.isEmpty()) {
            return 0;
        }
        if (node.b()) {
            return 1;
        }
        Iterator<NamedNode> it = node.iterator();
        while (it.hasNext()) {
            i += b(it.next().d());
        }
        return i;
    }

    public static long a(Node node) {
        if (node.isEmpty()) {
            return 4L;
        }
        if (node.b()) {
            return a((LeafNode<?>) node);
        }
        long j = 1;
        Iterator<NamedNode> it = node.iterator();
        while (it.hasNext()) {
            j = j + r5.c().a().length() + 4 + a(it.next().d());
        }
        return !node.getPriority().isEmpty() ? j + 12 + a((LeafNode<?>) node.getPriority()) : j;
    }
}
