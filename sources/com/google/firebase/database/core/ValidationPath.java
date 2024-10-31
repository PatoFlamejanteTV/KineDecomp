package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ValidationPath {

    /* renamed from: a */
    private final List<String> f16952a = new ArrayList();

    /* renamed from: b */
    private int f16953b;

    private ValidationPath(Path path) throws DatabaseException {
        this.f16953b = 0;
        Iterator<ChildKey> it = path.iterator();
        while (it.hasNext()) {
            this.f16952a.add(it.next().a());
        }
        this.f16953b = Math.max(1, this.f16952a.size());
        for (int i = 0; i < this.f16952a.size(); i++) {
            this.f16953b += a((CharSequence) this.f16952a.get(i));
        }
        a();
    }

    public static void a(Path path, Object obj) throws DatabaseException {
        new ValidationPath(path).a(obj);
    }

    private String b() {
        String remove = this.f16952a.remove(r0.size() - 1);
        this.f16953b -= a((CharSequence) remove);
        if (this.f16952a.size() > 0) {
            this.f16953b--;
        }
        return remove;
    }

    private String c() {
        if (this.f16952a.size() == 0) {
            return "";
        }
        return "in path '" + a("/", this.f16952a) + "'";
    }

    private void a(Object obj) throws DatabaseException {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    a(str);
                    a(map.get(str));
                    b();
                }
            }
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                a(Integer.toString(i));
                a(list.get(i));
                b();
            }
        }
    }

    private void a(String str) throws DatabaseException {
        if (this.f16952a.size() > 0) {
            this.f16953b++;
        }
        this.f16952a.add(str);
        this.f16953b += a((CharSequence) str);
        a();
    }

    private void a() throws DatabaseException {
        if (this.f16953b <= 768) {
            if (this.f16952a.size() <= 32) {
                return;
            }
            throw new DatabaseException("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle " + c());
        }
        throw new DatabaseException("Data has a key path longer than 768 bytes (" + this.f16953b + ").");
    }

    private static String a(String str, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }
}
