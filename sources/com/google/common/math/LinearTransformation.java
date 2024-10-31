package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class LinearTransformation {

    /* loaded from: classes2.dex */
    public static final class LinearTransformationBuilder {

        /* renamed from: a */
        private final double f15985a;

        /* renamed from: b */
        private final double f15986b;

        /* synthetic */ LinearTransformationBuilder(double d2, double d3, com.google.common.math.c cVar) {
            this(d2, d3);
        }

        public LinearTransformation a(double d2) {
            Preconditions.a(!Double.isNaN(d2));
            if (com.google.common.math.a.b(d2)) {
                return new b(d2, this.f15986b - (this.f15985a * d2));
            }
            return new c(this.f15985a);
        }

        private LinearTransformationBuilder(double d2, double d3) {
            this.f15985a = d2;
            this.f15986b = d3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a extends LinearTransformation {

        /* renamed from: a */
        static final a f15987a = new a();

        private a() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends LinearTransformation {

        /* renamed from: a */
        final double f15988a;

        /* renamed from: b */
        final double f15989b;

        /* renamed from: c */
        @LazyInit
        LinearTransformation f15990c = null;

        b(double d2, double d3) {
            this.f15988a = d2;
            this.f15989b = d3;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f15988a), Double.valueOf(this.f15989b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends LinearTransformation {

        /* renamed from: a */
        final double f15991a;

        /* renamed from: b */
        @LazyInit
        LinearTransformation f15992b = null;

        c(double d2) {
            this.f15991a = d2;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f15991a));
        }
    }

    public static LinearTransformationBuilder a(double d2, double d3) {
        Preconditions.a(com.google.common.math.a.b(d2) && com.google.common.math.a.b(d3));
        return new LinearTransformationBuilder(d2, d3);
    }

    public static LinearTransformation b(double d2) {
        Preconditions.a(com.google.common.math.a.b(d2));
        return new c(d2);
    }

    public static LinearTransformation a(double d2) {
        Preconditions.a(com.google.common.math.a.b(d2));
        return new b(0.0d, d2);
    }

    public static LinearTransformation a() {
        return a.f15987a;
    }
}
