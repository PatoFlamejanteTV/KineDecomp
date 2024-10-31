package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    private static final long serialVersionUID = 0;
    transient f<T> extensionMap;

    /* loaded from: classes3.dex */
    public static abstract class a<T extends ExtendableMessage<?>> extends Message.a<T> {

        /* renamed from: a */
        f<T> f25688a;

        protected a() {
        }

        public <E> a<T> a(e<T, E> eVar, E e2) {
            f<T> fVar = this.f25688a;
            if (fVar == null) {
                this.f25688a = new f<>(eVar, e2);
            } else {
                fVar.a(eVar, e2);
            }
            return this;
        }
    }

    protected ExtendableMessage() {
    }

    protected boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        f<T> fVar = this.extensionMap;
        if (fVar == null) {
            return extendableMessage.extensionMap == null;
        }
        return fVar.equals(extendableMessage.extensionMap);
    }

    protected int extensionsHashCode() {
        f<T> fVar = this.extensionMap;
        if (fVar == null) {
            return 0;
        }
        return fVar.hashCode();
    }

    public String extensionsToString() {
        f<T> fVar = this.extensionMap;
        return fVar == null ? "{}" : fVar.toString();
    }

    public <E> E getExtension(e<T, E> eVar) {
        f<T> fVar = this.extensionMap;
        if (fVar == null) {
            return null;
        }
        return (E) fVar.a(eVar);
    }

    public List<e<T, ?>> getExtensions() {
        f<T> fVar = this.extensionMap;
        return fVar == null ? Collections.emptyList() : fVar.a();
    }

    protected void setBuilder(a<T> aVar) {
        super.setBuilder((Message.a) aVar);
        f<T> fVar = aVar.f25688a;
        if (fVar != null) {
            this.extensionMap = new f<>(fVar);
        }
    }
}
