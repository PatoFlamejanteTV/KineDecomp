package kotlin.jvm.internal;

import kotlin.reflect.h;

/* loaded from: classes.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.h {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        j.a(this);
        return this;
    }

    @Override // kotlin.reflect.h
    public Object getDelegate() {
        return ((kotlin.reflect.h) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.a.a
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.h
    public h.a getGetter() {
        return ((kotlin.reflect.h) getReflected()).getGetter();
    }
}
