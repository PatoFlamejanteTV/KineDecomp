package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Validation {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f17073a = Pattern.compile("[\\[\\]\\.#$]");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f17074b = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static void a(String str) throws DatabaseException {
        if (d(str)) {
            return;
        }
        throw new DatabaseException("Invalid Firebase Database path: " + str + ". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
    }

    public static void b(String str) throws DatabaseException {
        if (str.startsWith(".info")) {
            a(str.substring(5));
        } else if (str.startsWith("/.info")) {
            a(str.substring(6));
        } else {
            a(str);
        }
    }

    public static void c(String str) throws DatabaseException {
        if (e(str)) {
            return;
        }
        throw new DatabaseException("Invalid key: " + str + ". Keys must not contain '/', '.', '#', '$', '[', or ']'");
    }

    private static boolean d(String str) {
        return !f17073a.matcher(str).find();
    }

    private static boolean e(String str) {
        return str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || !(str.startsWith(".") || f17074b.matcher(str).find()));
    }

    private static void a(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
        }
    }

    public static void a(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(".sv")) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                c((String) entry.getKey());
                a(entry.getValue());
            }
            return;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            a(((Double) obj).doubleValue());
        }
    }

    public static Map<Path, Node> a(Path path, Map<String, Object> map) throws DatabaseException {
        Node a2;
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Path path2 = new Path(entry.getKey());
            Object value = entry.getValue();
            ValidationPath.a(path.e(path2), value);
            String a3 = !path2.isEmpty() ? path2.d().a() : "";
            if (!a3.equals(".sv") && !a3.equals(".value")) {
                if (a3.equals(".priority")) {
                    a2 = PriorityUtilities.a(path2, value);
                } else {
                    a2 = NodeUtilities.a(value);
                }
                a(value);
                treeMap.put(path2, a2);
            } else {
                throw new DatabaseException("Path '" + path2 + "' contains disallowed child name: " + a3);
            }
        }
        Path path3 = null;
        for (Path path4 : treeMap.keySet()) {
            Utilities.a(path3 == null || path3.compareTo(path4) < 0);
            if (path3 != null && path3.g(path4)) {
                throw new DatabaseException("Path '" + path3 + "' is an ancestor of '" + path4 + "' in an update.");
            }
            path3 = path4;
        }
        return treeMap;
    }
}
