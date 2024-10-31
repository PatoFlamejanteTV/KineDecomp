package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
/* loaded from: classes.dex */
public class o implements l {

    /* renamed from: a */
    private static final Bitmap.Config[] f8824a;

    /* renamed from: b */
    private static final Bitmap.Config[] f8825b;

    /* renamed from: c */
    private static final Bitmap.Config[] f8826c;

    /* renamed from: d */
    private static final Bitmap.Config[] f8827d;

    /* renamed from: e */
    private static final Bitmap.Config[] f8828e;

    /* renamed from: f */
    private final b f8829f = new b();

    /* renamed from: g */
    private final h<a, Bitmap> f8830g = new h<>();

    /* renamed from: h */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f8831h = new HashMap();

    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class b extends d<a> {
        b() {
        }

        public a a(int i, Bitmap.Config config) {
            a b2 = b();
            b2.a(i, config);
            return b2;
        }

        @Override // com.bumptech.glide.load.engine.a.d
        public a a() {
            return new a(this);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f8824a = configArr;
        f8825b = f8824a;
        f8826c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f8827d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f8828e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private a b(int i, Bitmap.Config config) {
        a a2 = this.f8829f.a(i, config);
        for (Bitmap.Config config2 : a(config)) {
            Integer ceilingKey = b(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f8829f.a(a2);
                return this.f8829f.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public void a(Bitmap bitmap) {
        a a2 = this.f8829f.a(com.bumptech.glide.g.n.a(bitmap), bitmap.getConfig());
        this.f8830g.a(a2, bitmap);
        NavigableMap<Integer, Integer> b2 = b(bitmap.getConfig());
        Integer num = (Integer) b2.get(Integer.valueOf(a2.f8833b));
        b2.put(Integer.valueOf(a2.f8833b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.g.n.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap removeLast() {
        Bitmap a2 = this.f8830g.a();
        if (a2 != null) {
            a(Integer.valueOf(com.bumptech.glide.g.n.a(a2)), a2);
        }
        return a2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f8830g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f8831h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f8831h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class a implements m {

        /* renamed from: a */
        private final b f8832a;

        /* renamed from: b */
        int f8833b;

        /* renamed from: c */
        private Bitmap.Config f8834c;

        public a(b bVar) {
            this.f8832a = bVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.f8833b = i;
            this.f8834c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8833b == aVar.f8833b && com.bumptech.glide.g.n.b(this.f8834c, aVar.f8834c);
        }

        public int hashCode() {
            int i = this.f8833b * 31;
            Bitmap.Config config = this.f8834c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.a(this.f8833b, this.f8834c);
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void a() {
            this.f8832a.a(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        a b2 = b(com.bumptech.glide.g.n.a(i, i2, config), config);
        Bitmap a2 = this.f8830g.a((h<a, Bitmap>) b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f8833b), a2);
            a2.reconfigure(i, i2, config);
        }
        return a2;
    }

    private NavigableMap<Integer, Integer> b(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f8831h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f8831h.put(config, treeMap);
        return treeMap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> b2 = b(bitmap.getConfig());
        Integer num2 = (Integer) b2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                b2.remove(num);
                return;
            } else {
                b2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(Bitmap bitmap) {
        return a(com.bumptech.glide.g.n.a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(int i, int i2, Bitmap.Config config) {
        return a(com.bumptech.glide.g.n.a(i, i2, config), config);
    }

    static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f8825b;
        }
        int i = n.f8823a[config.ordinal()];
        if (i == 1) {
            return f8824a;
        }
        if (i == 2) {
            return f8826c;
        }
        if (i == 3) {
            return f8827d;
        }
        if (i != 4) {
            return new Bitmap.Config[]{config};
        }
        return f8828e;
    }
}
