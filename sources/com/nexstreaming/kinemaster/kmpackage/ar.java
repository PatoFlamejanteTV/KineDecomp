package com.nexstreaming.kinemaster.kmpackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Theme.java */
/* loaded from: classes.dex */
public class ar implements com.nexstreaming.app.general.expression.ae {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectAutoSelectContext f3440a;
    final /* synthetic */ Theme b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(Theme theme, EffectAutoSelectContext effectAutoSelectContext) {
        this.b = theme;
        this.f3440a = effectAutoSelectContext;
    }

    @Override // com.nexstreaming.app.general.expression.ae
    public Object a(String str) {
        try {
            return this.f3440a.getClass().getField(str).get(this.f3440a);
        } catch (IllegalAccessException e) {
            return null;
        } catch (IllegalArgumentException e2) {
            return null;
        } catch (NoSuchFieldException e3) {
            return null;
        }
    }
}
