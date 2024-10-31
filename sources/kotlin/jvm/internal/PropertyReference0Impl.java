package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    private final String name;
    private final kotlin.reflect.e owner;
    private final String signature;

    public PropertyReference0Impl(kotlin.reflect.e eVar, String str, String str2) {
        this.owner = eVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // kotlin.reflect.h
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getName() {
        return this.name;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.e getOwner() {
        return this.owner;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return this.signature;
    }
}
