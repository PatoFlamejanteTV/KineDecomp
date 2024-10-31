package com.nexstreaming.kinemaster.compat;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class EffectAssetCompatMap {

    /* renamed from: a */
    private static WeakReference<EffectAssetCompatMap> f20169a;

    /* renamed from: b */
    private Map<String, a> f20170b = new HashMap();

    /* loaded from: classes.dex */
    public enum CompatAction {
        Substitute,
        Delete,
        None
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final String f20171a;

        /* renamed from: b */
        public final CompatAction f20172b;

        /* synthetic */ a(CompatAction compatAction, String str, com.nexstreaming.kinemaster.compat.a aVar) {
            this(compatAction, str);
        }

        private a(CompatAction compatAction, String str) {
            this.f20171a = str;
            this.f20172b = compatAction;
        }
    }

    private EffectAssetCompatMap() {
        a("com.nexstreaming.kinemaster.basic.transition", "com.nexstreaming.kinemaster.builtin.transition.crossfade");
        a("com.nexstreaming.kinemaster.basic.middle", "com.nexstreaming.kinemaster.builtin.title.simple");
        a("com.nexstreaming.kinemaster.basic.ending", "com.nexstreaming.kinemaster.builtin.title.simple");
        a("com.nexstreaming.kinemaster.basic.opening", "com.nexstreaming.kinemaster.builtin.title.center");
        c("com.nexstreaming.kinemaster.builtin.accent.redalert");
        c("com.nexstreaming.kinemaster.builtin.accent.alien");
        c("com.nexstreaming.kinemaster.builtin.accent.bw");
        c("com.nexstreaming.kinemaster.builtin.accent.cool");
        c("com.nexstreaming.kinemaster.builtin.accent.sepia");
        c("com.nexstreaming.kinemaster.builtin.accent.sunny");
        c("com.nexstreaming.kinemaster.builtin2.accent.deepblue");
        c("com.nexstreaming.kinemaster.builtin2.accent.pink");
        c("com.nexstreaming.kinemaster.basic.accent");
    }

    public static EffectAssetCompatMap a() {
        WeakReference<EffectAssetCompatMap> weakReference = f20169a;
        EffectAssetCompatMap effectAssetCompatMap = weakReference != null ? weakReference.get() : null;
        if (effectAssetCompatMap != null) {
            return effectAssetCompatMap;
        }
        EffectAssetCompatMap effectAssetCompatMap2 = new EffectAssetCompatMap();
        f20169a = new WeakReference<>(effectAssetCompatMap2);
        return effectAssetCompatMap2;
    }

    private void c(String str) {
        this.f20170b.put(str, new a(CompatAction.Delete, null));
    }

    public String b(String str) {
        return this.f20170b.get(str).f20171a;
    }

    private void a(String str, String str2) {
        this.f20170b.put(str, new a(CompatAction.Substitute, str2));
    }

    public CompatAction a(String str) {
        a aVar = this.f20170b.get(str);
        if (aVar == null) {
            return CompatAction.None;
        }
        return aVar.f20172b;
    }
}
