package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j, double d2, double d3, double d4, double d5) {
        this.count = j;
        this.mean = d2;
        this.sumOfSquaresOfDeltas = d3;
        this.min = d4;
        this.max = d5;
    }

    public static Stats fromByteArray(byte[] bArr) {
        Preconditions.a(bArr);
        Preconditions.a(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.a(iterable);
        return statsAccumulator.a();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        Preconditions.a(byteBuffer);
        Preconditions.a(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return Objects.a(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        Preconditions.b(this.count != 0);
        return this.max;
    }

    public double mean() {
        Preconditions.b(this.count != 0);
        return this.mean;
    }

    public double min() {
        Preconditions.b(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        Preconditions.b(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        double a2 = a.a(this.sumOfSquaresOfDeltas);
        double count = count();
        Double.isNaN(count);
        return a2 / count;
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        Preconditions.b(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        double a2 = a.a(this.sumOfSquaresOfDeltas);
        double d2 = this.count - 1;
        Double.isNaN(d2);
        return a2 / d2;
    }

    public double sum() {
        double d2 = this.mean;
        double d3 = this.count;
        Double.isNaN(d3);
        return d2 * d3;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return MoreObjects.a(this).a("count", this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString();
        }
        return MoreObjects.a(this).a("count", this.count).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        Preconditions.a(byteBuffer);
        Preconditions.a(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        Preconditions.a(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j++;
            if (Doubles.a(doubleValue2) && Doubles.a(doubleValue)) {
                double d2 = j;
                Double.isNaN(d2);
                doubleValue += (doubleValue2 - doubleValue) / d2;
            } else {
                doubleValue = StatsAccumulator.a(doubleValue, doubleValue2);
            }
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.a(it);
        return statsAccumulator.a();
    }

    public static Stats of(double... dArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.a(dArr);
        return statsAccumulator.a();
    }

    public static double meanOf(double... dArr) {
        Preconditions.a(dArr.length > 0);
        double d2 = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d3 = dArr[i];
            if (Doubles.a(d3) && Doubles.a(d2)) {
                double d4 = i + 1;
                Double.isNaN(d4);
                d2 += (d3 - d2) / d4;
            } else {
                d2 = StatsAccumulator.a(d2, d3);
            }
        }
        return d2;
    }

    public static Stats of(int... iArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.a(iArr);
        return statsAccumulator.a();
    }

    public static Stats of(long... jArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.a(jArr);
        return statsAccumulator.a();
    }

    public static double meanOf(int... iArr) {
        Preconditions.a(iArr.length > 0);
        double d2 = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d3 = iArr[i];
            if (Doubles.a(d3) && Doubles.a(d2)) {
                Double.isNaN(d3);
                double d4 = i + 1;
                Double.isNaN(d4);
                d2 += (d3 - d2) / d4;
            } else {
                d2 = StatsAccumulator.a(d2, d3);
            }
        }
        return d2;
    }

    public static double meanOf(long... jArr) {
        Preconditions.a(jArr.length > 0);
        double d2 = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d3 = jArr[i];
            if (Doubles.a(d3) && Doubles.a(d2)) {
                Double.isNaN(d3);
                double d4 = i + 1;
                Double.isNaN(d4);
                d2 += (d3 - d2) / d4;
            } else {
                d2 = StatsAccumulator.a(d2, d3);
            }
        }
        return d2;
    }
}
