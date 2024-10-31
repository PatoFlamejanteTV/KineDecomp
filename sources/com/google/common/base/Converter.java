package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Converter<A, B> implements Function<A, B> {

    /* renamed from: a */
    @LazyInit
    private transient Converter<B, A> f15082a;
    private final boolean handleNullAutomatically;

    /* loaded from: classes2.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        @Nullable
        A correctedDoBackward(@Nullable C c2) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c2));
        }

        @Override // com.google.common.base.Converter
        @Nullable
        C correctedDoForward(@Nullable A a2) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a2));
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(C c2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected C doForward(A a2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        /* synthetic */ FunctionBasedConverter(Function function, Function function2, c cVar) {
            this(function, function2);
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B b2) {
            return this.backwardFunction.apply(b2);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A a2) {
            return this.forwardFunction.apply(a2);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }

        private FunctionBasedConverter(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            Preconditions.a(function);
            this.forwardFunction = function;
            Preconditions.a(function2);
            this.backwardFunction = function2;
        }
    }

    /* loaded from: classes2.dex */
    private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = new IdentityConverter();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            Preconditions.a(converter, "otherConverter");
            return converter;
        }

        @Override // com.google.common.base.Converter
        protected T doBackward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        protected T doForward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* loaded from: classes2.dex */
    private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        @Nullable
        B correctedDoBackward(@Nullable A a2) {
            return this.original.correctedDoForward(a2);
        }

        @Override // com.google.common.base.Converter
        @Nullable
        A correctedDoForward(@Nullable B b2) {
            return this.original.correctedDoBackward(b2);
        }

        @Override // com.google.common.base.Converter
        protected B doBackward(A a2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        protected A doForward(B b2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return this.original.hashCode() ^ (-1);
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new FunctionBasedConverter(function, function2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.Function
    @CanIgnoreReturnValue
    @Nullable
    @Deprecated
    public final B apply(@Nullable A a2) {
        return convert(a2);
    }

    @CanIgnoreReturnValue
    @Nullable
    public final B convert(@Nullable A a2) {
        return correctedDoForward(a2);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        Preconditions.a(iterable, "fromIterable");
        return new c(this, iterable);
    }

    @Nullable
    A correctedDoBackward(@Nullable B b2) {
        if (!this.handleNullAutomatically) {
            return doBackward(b2);
        }
        if (b2 == null) {
            return null;
        }
        A doBackward = doBackward(b2);
        Preconditions.a(doBackward);
        return doBackward;
    }

    @Nullable
    B correctedDoForward(@Nullable A a2) {
        if (!this.handleNullAutomatically) {
            return doForward(a2);
        }
        if (a2 == null) {
            return null;
        }
        B doForward = doForward(a2);
        Preconditions.a(doForward);
        return doForward;
    }

    <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        Preconditions.a(converter);
        return new ConverterComposition(this, converter);
    }

    protected abstract A doBackward(B b2);

    protected abstract B doForward(A a2);

    @Override // com.google.common.base.Function
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.f15082a;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.f15082a = reverseConverter;
        return reverseConverter;
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }
}
