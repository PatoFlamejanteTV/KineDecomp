package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class FunctionReference extends CallableReference implements g, kotlin.reflect.f {
    private final int arity;

    public FunctionReference(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        j.a(this);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (getOwner() != null ? getOwner().equals(functionReference.getOwner()) : functionReference.getOwner() == null) {
                if (getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && h.a(getBoundReceiver(), functionReference.getBoundReceiver())) {
                    return true;
                }
            }
            return false;
        }
        if (obj instanceof kotlin.reflect.f) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        kotlin.reflect.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.f getReflected() {
        return (kotlin.reflect.f) super.getReflected();
    }

    public FunctionReference(int i, Object obj) {
        super(obj);
        this.arity = i;
    }
}
