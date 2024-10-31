package com.mixpanel.android.mpmetrics;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Tweaks.java */
/* loaded from: classes.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, b> f3019a = new HashMap();
    private final List<a> b = new ArrayList();

    /* compiled from: Tweaks.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("listener cannot be null");
        }
        this.b.add(aVar);
    }

    public synchronized void a(String str, Object obj) {
        if (!this.f3019a.containsKey(str)) {
            Log.w("MixpanelAPI.Tweaks", "Attempt to set a tweak \"" + str + "\" which has never been defined.");
        } else {
            this.f3019a.put(str, this.f3019a.get(str).a(obj));
        }
    }

    public synchronized Map<String, b> a() {
        return new HashMap(this.f3019a);
    }

    /* compiled from: Tweaks.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3020a;
        private final Object b;
        private final Object c;
        private final Number d;
        private final Number e;

        /* synthetic */ b(int i, Object obj, Number number, Number number2, Object obj2, ag agVar) {
            this(i, obj, number, number2, obj2);
        }

        private b(int i, Object obj, Number number, Number number2, Object obj2) {
            this.f3020a = i;
            this.c = obj;
            this.d = number;
            this.e = number2;
            this.b = obj2;
        }

        public b a(Object obj) {
            return new b(this.f3020a, this.c, this.d, this.e, obj);
        }

        public String a() {
            String str = null;
            try {
                str = (String) this.c;
            } catch (ClassCastException e) {
            }
            try {
                return (String) this.b;
            } catch (ClassCastException e2) {
                return str;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Number] */
        public Number b() {
            int i = 0;
            if (this.c != null) {
                try {
                    i = (Number) this.c;
                } catch (ClassCastException e) {
                }
            }
            if (this.b != null) {
                try {
                    return (Number) this.b;
                } catch (ClassCastException e2) {
                    return i;
                }
            }
            return i;
        }

        public Boolean c() {
            Boolean bool = false;
            if (this.c != null) {
                try {
                    bool = (Boolean) this.c;
                } catch (ClassCastException e) {
                }
            }
            if (this.b != null) {
                try {
                    return (Boolean) this.b;
                } catch (ClassCastException e2) {
                    return bool;
                }
            }
            return bool;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae<Integer> a(String str, int i) {
        a(str, Integer.valueOf(i), 3);
        return new ah(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae<Boolean> a(String str, boolean z) {
        a(str, Boolean.valueOf(z), 1);
        return new ai(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized b a(String str) {
        return this.f3019a.get(str);
    }

    private void a(String str, Object obj, int i) {
        Number number = null;
        byte b2 = 0;
        byte b3 = 0;
        if (this.f3019a.containsKey(str)) {
            Log.w("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + str + "\" twice with the same name");
            return;
        }
        this.f3019a.put(str, new b(i, obj, number, b3 == true ? 1 : 0, obj, b2 == true ? 1 : 0));
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b.get(i2).a();
        }
    }
}
