package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
/* loaded from: classes2.dex */
public class DataLayer {

    /* renamed from: a */
    public static final Object f14163a = new Object();

    /* renamed from: b */
    private static final String[] f14164b = "gtm.lifetime".split("\\.");

    /* renamed from: c */
    private static final Pattern f14165c = Pattern.compile("(\\d+)\\s*([smhd]?)");

    /* renamed from: d */
    private final ConcurrentHashMap<b, Integer> f14166d;

    /* renamed from: e */
    private final Map<String, Object> f14167e;

    /* renamed from: f */
    private final ReentrantLock f14168f;

    /* renamed from: g */
    private final LinkedList<Map<String, Object>> f14169g;

    /* renamed from: h */
    private final c f14170h;
    private final CountDownLatch i;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        public final String f14171a;

        /* renamed from: b */
        public final Object f14172b;

        public a(String str, Object obj) {
            this.f14171a = str;
            this.f14172b = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f14171a.equals(aVar.f14171a) && this.f14172b.equals(aVar.f14172b);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f14171a.hashCode()), Integer.valueOf(this.f14172b.hashCode())});
        }

        public final String toString() {
            String str = this.f14171a;
            String obj = this.f14172b.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(obj).length());
            sb.append("Key: ");
            sb.append(str);
            sb.append(" value: ");
            sb.append(obj);
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(Map<String, Object> map);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(zzaq zzaqVar);

        void a(List<a> list, long j);
    }

    @VisibleForTesting
    DataLayer() {
        this(new C1456b());
    }

    public final void a(Map<String, Object> map) {
        Long l;
        this.f14168f.lock();
        try {
            this.f14169g.offer(map);
            int i = 0;
            if (this.f14168f.getHoldCount() == 1) {
                int i2 = 0;
                do {
                    Map<String, Object> poll = this.f14169g.poll();
                    if (poll != null) {
                        synchronized (this.f14167e) {
                            for (String str : poll.keySet()) {
                                a(a(str, poll.get(str)), this.f14167e);
                            }
                        }
                        Iterator<b> it = this.f14166d.keySet().iterator();
                        while (it.hasNext()) {
                            it.next().a(poll);
                        }
                        i2++;
                    }
                } while (i2 <= 500);
                this.f14169g.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
            }
            String[] strArr = f14164b;
            int length = strArr.length;
            Object obj = map;
            while (true) {
                l = null;
                if (i >= length) {
                    break;
                }
                String str2 = strArr[i];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i++;
                }
            }
            if (obj != null) {
                l = a(obj.toString());
            }
            if (l != null) {
                ArrayList arrayList = new ArrayList();
                a(map, "", arrayList);
                this.f14170h.a(arrayList, l.longValue());
            }
        } finally {
            this.f14168f.unlock();
        }
    }

    public String toString() {
        String sb;
        synchronized (this.f14167e) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, Object> entry : this.f14167e.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public DataLayer(c cVar) {
        this.f14170h = cVar;
        this.f14166d = new ConcurrentHashMap<>();
        this.f14167e = new HashMap();
        this.f14168f = new ReentrantLock();
        this.f14169g = new LinkedList<>();
        this.i = new CountDownLatch(1);
        this.f14170h.a(new C1457c(this));
    }

    private final void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String key = entry.getKey();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + str2.length() + String.valueOf(key).length());
            sb.append(str);
            sb.append(str2);
            sb.append(key);
            String sb2 = sb.toString();
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), sb2, collection);
            } else if (!sb2.equals("gtm.lifetime")) {
                collection.add(new a(sb2, entry.getValue()));
            }
        }
    }

    @VisibleForTesting
    private static Long a(String str) {
        long j;
        Matcher matcher = f14165c.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            zzdi.d(valueOf.length() != 0 ? "unknown _lifetime: ".concat(valueOf) : new String("unknown _lifetime: "));
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            zzdi.b(valueOf2.length() != 0 ? "illegal number in _lifetime value: ".concat(valueOf2) : new String("illegal number in _lifetime value: "));
            j = 0;
        }
        if (j <= 0) {
            String valueOf3 = String.valueOf(str);
            zzdi.d(valueOf3.length() != 0 ? "non-positive _lifetime: ".concat(valueOf3) : new String("non-positive _lifetime: "));
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        char charAt = group.charAt(0);
        if (charAt == 'd') {
            return Long.valueOf(j * 1000 * 60 * 60 * 24);
        }
        if (charAt == 'h') {
            return Long.valueOf(j * 1000 * 60 * 60);
        }
        if (charAt == 'm') {
            return Long.valueOf(j * 1000 * 60);
        }
        if (charAt != 's') {
            String valueOf4 = String.valueOf(str);
            zzdi.b(valueOf4.length() != 0 ? "unknown units in _lifetime: ".concat(valueOf4) : new String("unknown units in _lifetime: "));
            return null;
        }
        return Long.valueOf(j * 1000);
    }

    public final void a(b bVar) {
        this.f14166d.put(bVar, 0);
    }

    public static Map<String, Object> a(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    @VisibleForTesting
    private final void a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                a((List<Object>) obj, (List<Object>) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                a((Map<String, Object>) obj, (Map<String, Object>) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    @VisibleForTesting
    private final void a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                a((List<Object>) obj, (List<Object>) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                a((Map<String, Object>) obj, (Map<String, Object>) list2.get(i));
            } else if (obj != f14163a) {
                list2.set(i, obj);
            }
        }
    }
}
