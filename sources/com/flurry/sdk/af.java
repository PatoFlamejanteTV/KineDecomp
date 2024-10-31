package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f453a = new HashMap();
    private Map<String, List<a>> b = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Object obj);
    }

    public synchronized void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && !a(obj, this.f453a.get(str))) {
            if (obj == null) {
                this.f453a.remove(str);
            } else {
                this.f453a.put(str, obj);
            }
            b(str, obj);
        }
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void b(String str, Object obj) {
        if (this.b.get(str) != null) {
            Iterator<a> it = this.b.get(str).iterator();
            while (it.hasNext()) {
                it.next().a(str, obj);
            }
        }
    }

    public synchronized Object a(String str) {
        return this.f453a.get(str);
    }

    public synchronized void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            List<a> list = this.b.get(str);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(aVar);
            this.b.put(str, list);
        }
    }

    public synchronized boolean b(String str, a aVar) {
        boolean remove;
        if (TextUtils.isEmpty(str)) {
            remove = false;
        } else if (aVar == null) {
            remove = false;
        } else {
            List<a> list = this.b.get(str);
            remove = list == null ? false : list.remove(aVar);
        }
        return remove;
    }
}
