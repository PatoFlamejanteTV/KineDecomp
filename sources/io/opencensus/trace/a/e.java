package io.opencensus.trace.a;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import io.opencensus.trace.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: SampledSpanStore.java */
@ThreadSafe
/* loaded from: classes3.dex */
public abstract class e {

    /* compiled from: SampledSpanStore.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static abstract class b {
        public static b a(Map<Object, Integer> map, Map<Status.CanonicalCode, Integer> map2) {
            Preconditions.a(map, "numbersOfLatencySampledSpans");
            Map unmodifiableMap = Collections.unmodifiableMap(new HashMap(map));
            Preconditions.a(map2, "numbersOfErrorSampledSpans");
            return new io.opencensus.trace.a.a(unmodifiableMap, Collections.unmodifiableMap(new HashMap(map2)));
        }

        public abstract Map<Status.CanonicalCode, Integer> a();

        public abstract Map<Object, Integer> b();
    }

    protected e() {
    }

    public static e a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SampledSpanStore.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static final class a extends e {

        /* renamed from: a */
        private static final b f28055a = b.a(Collections.emptyMap(), Collections.emptyMap());

        /* renamed from: b */
        private final Set<String> f28056b;

        private a() {
            this.f28056b = Sets.a();
        }

        /* synthetic */ a(d dVar) {
            this();
        }
    }
}
