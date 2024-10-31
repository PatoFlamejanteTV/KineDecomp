package com.umeng.commonsdk.proguard;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData.java */
/* loaded from: classes3.dex */
public class v implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends j>, Map<? extends q, v>> f26282d = new HashMap();

    /* renamed from: a */
    public final String f26283a;

    /* renamed from: b */
    public final byte f26284b;

    /* renamed from: c */
    public final w f26285c;

    public v(String str, byte b2, w wVar) {
        this.f26283a = str;
        this.f26284b = b2;
        this.f26285c = wVar;
    }

    public static void a(Class<? extends j> cls, Map<? extends q, v> map) {
        f26282d.put(cls, map);
    }

    public static Map<? extends q, v> a(Class<? extends j> cls) {
        if (!f26282d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f26282d.get(cls);
    }
}
