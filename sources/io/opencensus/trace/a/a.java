package io.opencensus.trace.a;

import io.opencensus.trace.Status;
import io.opencensus.trace.a.e;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_SampledSpanStore_PerSpanNameSummary.java */
@Immutable
/* loaded from: classes3.dex */
public final class a extends e.b {

    /* renamed from: a */
    private final Map<Object, Integer> f28052a;

    /* renamed from: b */
    private final Map<Status.CanonicalCode, Integer> f28053b;

    public a(Map<Object, Integer> map, Map<Status.CanonicalCode, Integer> map2) {
        if (map != null) {
            this.f28052a = map;
            if (map2 != null) {
                this.f28053b = map2;
                return;
            }
            throw new NullPointerException("Null numbersOfErrorSampledSpans");
        }
        throw new NullPointerException("Null numbersOfLatencySampledSpans");
    }

    @Override // io.opencensus.trace.a.e.b
    public Map<Status.CanonicalCode, Integer> a() {
        return this.f28053b;
    }

    @Override // io.opencensus.trace.a.e.b
    public Map<Object, Integer> b() {
        return this.f28052a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.b)) {
            return false;
        }
        e.b bVar = (e.b) obj;
        return this.f28052a.equals(bVar.b()) && this.f28053b.equals(bVar.a());
    }

    public int hashCode() {
        return ((this.f28052a.hashCode() ^ 1000003) * 1000003) ^ this.f28053b.hashCode();
    }

    public String toString() {
        return "PerSpanNameSummary{numbersOfLatencySampledSpans=" + this.f28052a + ", numbersOfErrorSampledSpans=" + this.f28053b + "}";
    }
}
