package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    private final String name;
    private final kotlin.reflect.e owner;
    private final String signature;

    public PropertyReference1Impl(kotlin.reflect.e eVar, String str, String str2) {
        this.owner = eVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // kotlin.reflect.i
    public Object get(Object obj) {
        return getGetter().call(obj);
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
