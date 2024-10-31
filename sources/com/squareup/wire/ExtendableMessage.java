package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    private static final long serialVersionUID = 0;
    transient f<T> extensionMap;

    protected ExtendableMessage() {
    }

    protected void setBuilder(a<T> aVar) {
        super.setBuilder((Message.a) aVar);
        if (aVar.f4851a != null) {
            this.extensionMap = new f<>(aVar.f4851a);
        }
    }

    public List<e<T, ?>> getExtensions() {
        return this.extensionMap == null ? Collections.emptyList() : this.extensionMap.b();
    }

    public <E> E getExtension(e<T, E> eVar) {
        if (this.extensionMap == null) {
            return null;
        }
        return (E) this.extensionMap.a(eVar);
    }

    protected boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        if (this.extensionMap == null) {
            return extendableMessage.extensionMap == null;
        }
        return this.extensionMap.equals(extendableMessage.extensionMap);
    }

    protected int extensionsHashCode() {
        if (this.extensionMap == null) {
            return 0;
        }
        return this.extensionMap.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String extensionsToString() {
        return this.extensionMap == null ? "{}" : this.extensionMap.toString();
    }

    /* loaded from: classes.dex */
    public static abstract class a<T extends ExtendableMessage<?>> extends Message.a<T> {

        /* renamed from: a, reason: collision with root package name */
        f<T> f4851a;

        protected a() {
        }

        public <E> a<T> a(e<T, E> eVar, E e) {
            if (this.f4851a == null) {
                this.f4851a = new f<>(eVar, e);
            } else {
                this.f4851a.a(eVar, e);
            }
            return this;
        }
    }
}
