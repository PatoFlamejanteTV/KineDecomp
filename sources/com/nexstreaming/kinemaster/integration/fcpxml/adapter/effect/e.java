package com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionMapping.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    public Map<String, String> f20473a;

    public e() {
        a();
    }

    private void a() {
        this.f20473a = new HashMap();
        this.f20473a.put("com.nexstreaming.kinemaster.builtin.transition.crossfade", new String[]{"Cross Dissolve"}[0]);
    }

    public String b(String str) {
        String str2 = this.f20473a.get(str);
        return str2 != null ? str2 : "Cross Dissolve";
    }

    public EffectId a(String str) {
        return EffectId.get(b(str));
    }
}
