package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ServerValues {
    public static Map<String, Object> a(Clock clock) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(clock.a()));
        return hashMap;
    }

    public static Object a(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(".sv")) {
            return obj;
        }
        String str = (String) map2.get(".sv");
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static SparseSnapshotTree a(SparseSnapshotTree sparseSnapshotTree, Map<String, Object> map) {
        SparseSnapshotTree sparseSnapshotTree2 = new SparseSnapshotTree();
        sparseSnapshotTree.a(new Path(""), new A(sparseSnapshotTree2, map));
        return sparseSnapshotTree2;
    }

    public static Node a(Node node, Map<String, Object> map) {
        Object value = node.getPriority().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(".sv")) {
                value = map.get((String) map2.get(".sv"));
            }
        }
        Node a2 = PriorityUtilities.a(value);
        if (node.b()) {
            Object a3 = a(node.getValue(), map);
            return (a3.equals(node.getValue()) && a2.equals(node.getPriority())) ? node : NodeUtilities.a(a3, a2);
        }
        if (node.isEmpty()) {
            return node;
        }
        ChildrenNode childrenNode = (ChildrenNode) node;
        SnapshotHolder snapshotHolder = new SnapshotHolder(childrenNode);
        childrenNode.a(new B(map, snapshotHolder));
        if (!snapshotHolder.a().getPriority().equals(a2)) {
            return snapshotHolder.a().a(a2);
        }
        return snapshotHolder.a();
    }

    public static CompoundWrite a(CompoundWrite compoundWrite, Map<String, Object> map) {
        CompoundWrite d2 = CompoundWrite.d();
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            d2 = d2.b(next.getKey(), a(next.getValue(), map));
        }
        return d2;
    }
}
