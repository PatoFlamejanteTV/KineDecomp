package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Predicates {

    /* renamed from: a */
    private static final Joiner f15107a = Joiner.a(',');

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* synthetic */ AndPredicate(List list, m mVar) {
            this(list);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!this.components.get(i).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return "Predicates.and(" + Predicates.f15107a.a((Iterable<?>) this.components) + ")";
        }

        private AndPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f */
        final Function<A, ? extends B> f15108f;
        final Predicate<B> p;

        /* synthetic */ CompositionPredicate(Predicate predicate, Function function, m mVar) {
            this(predicate, function);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable A a2) {
            return this.p.apply(this.f15108f.apply(a2));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f15108f.equals(compositionPredicate.f15108f) && this.p.equals(compositionPredicate.p);
        }

        public int hashCode() {
            return this.f15108f.hashCode() ^ this.p.hashCode();
        }

        public String toString() {
            return this.p + "(" + this.f15108f + ")";
        }

        private CompositionPredicate(Predicate<B> predicate, Function<A, ? extends B> function) {
            Preconditions.a(predicate);
            this.p = predicate;
            Preconditions.a(function);
            this.f15108f = function;
        }
    }

    /* loaded from: classes2.dex */
    public static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        /* synthetic */ InPredicate(Collection collection, m mVar) {
            this(collection);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }

        private InPredicate(Collection<?> collection) {
            Preconditions.a(collection);
            this.target = collection;
        }
    }

    @GwtIncompatible
    /* loaded from: classes2.dex */
    public static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        /* synthetic */ InstanceOfPredicate(Class cls, m mVar) {
            this(cls);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable Object obj) {
            return this.clazz.isInstance(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.clazz == ((InstanceOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }

        private InstanceOfPredicate(Class<?> cls) {
            Preconditions.a(cls);
            this.clazz = cls;
        }
    }

    /* loaded from: classes2.dex */
    public static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        /* synthetic */ IsEqualToPredicate(Object obj, m mVar) {
            this(obj);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        private IsEqualToPredicate(T t) {
            this.target = t;
        }
    }

    /* loaded from: classes2.dex */
    public static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> predicate) {
            Preconditions.a(predicate);
            this.predicate = predicate;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T t) {
            return !this.predicate.apply(t);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ (-1);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* loaded from: classes2.dex */
    public enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$1 */
        /* loaded from: classes2.dex */
        enum AnonymousClass1 extends ObjectPredicate {
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$2 */
        /* loaded from: classes2.dex */
        enum AnonymousClass2 extends ObjectPredicate {
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$3 */
        /* loaded from: classes2.dex */
        enum AnonymousClass3 extends ObjectPredicate {
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* renamed from: com.google.common.base.Predicates$ObjectPredicate$4 */
        /* loaded from: classes2.dex */
        enum AnonymousClass4 extends ObjectPredicate {
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        <T> Predicate<T> withNarrowedType() {
            return this;
        }

        /* synthetic */ ObjectPredicate(m mVar) {
            this();
        }
    }

    private Predicates() {
    }

    public static <T> Predicate<T> b() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> Predicate<T> c() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> a(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    private static <T> List<Predicate<? super T>> b(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    public static <T> Predicate<T> a(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        Preconditions.a(predicate);
        Preconditions.a(predicate2);
        return new AndPredicate(b(predicate, predicate2));
    }

    public static <T> Predicate<T> a(@Nullable T t) {
        return t == null ? c() : new IsEqualToPredicate(t);
    }

    @GwtIncompatible
    public static Predicate<Object> a(Class<?> cls) {
        return new InstanceOfPredicate(cls);
    }

    public static <T> Predicate<T> a(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <A, B> Predicate<A> a(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }
}
