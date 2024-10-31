package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Predicates {

    /* renamed from: a, reason: collision with root package name */
    private static final Joiner f2584a = Joiner.a(",");

    private Predicates() {
    }

    @GwtCompatible
    public static <T> Predicate<T> a() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    @GwtCompatible
    public static <T> Predicate<T> b() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> a(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> a(@Nullable T t) {
        return t == null ? b() : new IsEqualToPredicate(t);
    }

    public static <T> Predicate<T> a(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return true;
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return false;
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return obj == null;
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicate
            public boolean apply(@Nullable Object obj) {
                return obj != null;
            }
        };

        <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.a(predicate);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ (-1);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public String toString() {
            return "Not(" + this.predicate.toString() + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        private IsEqualToPredicate(T t) {
            this.target = t;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public String toString() {
            return "IsEqualTo(" + this.target + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) Preconditions.a(collection);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }

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
            return "In(" + this.target + ")";
        }
    }
}
