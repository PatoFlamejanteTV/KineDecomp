package com.google.firebase.database.snapshot;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class NodeUtilities {
    public static Node a(Object obj) throws DatabaseException {
        return a(obj, PriorityUtilities.a());
    }

    public static Node a(Object obj, Node node) throws DatabaseException {
        HashMap hashMap;
        try {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(".priority")) {
                    node = PriorityUtilities.a(map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj = map.get(".value");
                }
            }
            if (obj == null) {
                return EmptyNode.e();
            }
            if (obj instanceof String) {
                return new StringNode((String) obj, node);
            }
            if (obj instanceof Long) {
                return new LongNode((Long) obj, node);
            }
            if (obj instanceof Integer) {
                return new LongNode(Long.valueOf(((Integer) obj).intValue()), node);
            }
            if (obj instanceof Double) {
                return new DoubleNode((Double) obj, node);
            }
            if (obj instanceof Boolean) {
                return new BooleanNode((Boolean) obj, node);
            }
            if (!(obj instanceof Map) && !(obj instanceof List)) {
                throw new DatabaseException("Failed to parse node with class " + obj.getClass().toString());
            }
            if (obj instanceof Map) {
                Map map2 = (Map) obj;
                if (map2.containsKey(".sv")) {
                    return new DeferredValueNode(map2, node);
                }
                hashMap = new HashMap(map2.size());
                for (String str : map2.keySet()) {
                    if (!str.startsWith(".")) {
                        Node a2 = a(map2.get(str));
                        if (!a2.isEmpty()) {
                            hashMap.put(ChildKey.a(str), a2);
                        }
                    }
                }
            } else {
                List list = (List) obj;
                hashMap = new HashMap(list.size());
                for (int i = 0; i < list.size(); i++) {
                    String str2 = "" + i;
                    Node a3 = a(list.get(i));
                    if (!a3.isEmpty()) {
                        hashMap.put(ChildKey.a(str2), a3);
                    }
                }
            }
            if (hashMap.isEmpty()) {
                return EmptyNode.e();
            }
            return new ChildrenNode(ImmutableSortedMap.Builder.a(hashMap, ChildrenNode.f17184a), node);
        } catch (ClassCastException e2) {
            throw new DatabaseException("Failed to parse node", e2);
        }
    }

    public static int a(ChildKey childKey, Node node, ChildKey childKey2, Node node2) {
        int compareTo = node.compareTo(node2);
        return compareTo != 0 ? compareTo : childKey.compareTo(childKey2);
    }
}
