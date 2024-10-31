package com.google.firebase.database.snapshot;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class PriorityUtilities {
    public static Node a() {
        return EmptyNode.e();
    }

    public static boolean a(Node node) {
        return node.getPriority().isEmpty() && (node.isEmpty() || (node instanceof DoubleNode) || (node instanceof StringNode) || (node instanceof DeferredValueNode));
    }

    public static Node a(Object obj) {
        return a(null, obj);
    }

    public static Node a(Path path, Object obj) {
        String str;
        Node a2 = NodeUtilities.a(obj);
        if (a2 instanceof LongNode) {
            a2 = new DoubleNode(Double.valueOf(((Long) a2.getValue()).longValue()), a());
        }
        if (a(a2)) {
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        if (path != null) {
            str = "Path '" + path + "'";
        } else {
            str = "Node";
        }
        sb.append(str);
        sb.append(" contains invalid priority: Must be a string, double, ServerValue, or null");
        throw new DatabaseException(sb.toString());
    }
}
