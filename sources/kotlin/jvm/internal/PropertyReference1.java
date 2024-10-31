package kotlin.jvm.internal;

import kotlin.reflect.i;

/* loaded from: classes.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.reflect.i {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        j.a(this);
        return this;
    }

    @Override // kotlin.reflect.i
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.i) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.a.b
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.i
    public i.a getGetter() {
        return ((kotlin.reflect.i) getReflected()).getGetter();
    }
}
