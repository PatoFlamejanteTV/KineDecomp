package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableAsList<E> extends ImmutableList<E> {
    abstract ImmutableCollection<E> delegateCollection();

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    @Override // java.util.Collection, java.util.List
    public int size() {
        return delegateCollection().size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return delegateCollection().isPartialView();
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableCollection<?> collection;

        SerializedForm(ImmutableCollection<?> immutableCollection) {
            this.collection = immutableCollection;
        }

        Object readResolve() {
            return this.collection.asList();
        }
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(delegateCollection());
    }
}
