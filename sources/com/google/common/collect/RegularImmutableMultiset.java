package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {

    /* renamed from: a */
    private final transient ImmutableMap<E, Integer> f2754a;
    private final transient int b;

    public RegularImmutableMultiset(ImmutableMap<E, Integer> immutableMap, int i) {
        this.f2754a = immutableMap;
        this.b = i;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f2754a.isPartialView();
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        Integer num = this.f2754a.get(obj);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // java.util.Collection
    public int size() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return this.f2754a.containsKey(obj);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        return this.f2754a.keySet();
    }

    public static <E> Multiset.Entry<E> a(Map.Entry<E, Integer> entry) {
        return Multisets.a(entry.getKey(), entry.getValue().intValue());
    }

    @Override // com.google.common.collect.ImmutableMultiset
    ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class EntrySet extends ImmutableMultiset.EntrySet {
        private EntrySet() {
            super();
        }

        /* synthetic */ EntrySet(RegularImmutableMultiset regularImmutableMultiset, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.f2754a.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return asList().iterator();
        }

        /* renamed from: com.google.common.collect.RegularImmutableMultiset$EntrySet$1 */
        /* loaded from: classes2.dex */
        class AnonymousClass1 extends ImmutableAsList<Multiset.Entry<E>> {
            final /* synthetic */ ImmutableList val$entryList;

            AnonymousClass1(ImmutableList immutableList) {
                r2 = immutableList;
            }

            @Override // java.util.List
            public Multiset.Entry<E> get(int i) {
                return RegularImmutableMultiset.a((Map.Entry) r2.get(i));
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                return EntrySet.this;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Multiset.Entry<E>> createAsList() {
            return new ImmutableAsList<Multiset.Entry<E>>() { // from class: com.google.common.collect.RegularImmutableMultiset.EntrySet.1
                final /* synthetic */ ImmutableList val$entryList;

                AnonymousClass1(ImmutableList immutableList) {
                    r2 = immutableList;
                }

                @Override // java.util.List
                public Multiset.Entry<E> get(int i) {
                    return RegularImmutableMultiset.a((Map.Entry) r2.get(i));
                }

                @Override // com.google.common.collect.ImmutableAsList
                ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection
    public int hashCode() {
        return this.f2754a.hashCode();
    }
}
