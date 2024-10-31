package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class TreeNode<T> {

    /* renamed from: a */
    public Map<ChildKey, TreeNode<T>> f17070a = new HashMap();

    /* renamed from: b */
    public T f17071b;

    public String a(String str) {
        String str2 = str + "<value>: " + this.f17071b + "\n";
        if (this.f17070a.isEmpty()) {
            return str2 + str + "<empty>";
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.f17070a.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            sb.append(entry.getKey());
            sb.append(":\n");
            sb.append(entry.getValue().a(str + "\t"));
            sb.append("\n");
            str2 = sb.toString();
        }
        return str2;
    }
}
