package io.opencensus.trace;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class Span {

    /* renamed from: a */
    private static final Map<String, Object> f28040a = Collections.emptyMap();

    /* renamed from: b */
    private static final Set<Options> f28041b = Collections.unmodifiableSet(EnumSet.noneOf(Options.class));

    /* renamed from: c */
    private final i f28042c;

    /* renamed from: d */
    private final Set<Options> f28043d;

    /* loaded from: classes3.dex */
    public enum Options {
        RECORD_EVENTS
    }

    public Span(i iVar, @Nullable EnumSet<Options> enumSet) {
        Set<Options> unmodifiableSet;
        Preconditions.a(iVar, com.umeng.analytics.pro.b.Q);
        this.f28042c = iVar;
        if (enumSet == null) {
            unmodifiableSet = f28041b;
        } else {
            unmodifiableSet = Collections.unmodifiableSet(EnumSet.copyOf((EnumSet) enumSet));
        }
        this.f28043d = unmodifiableSet;
        Preconditions.a(!iVar.b().a() || this.f28043d.contains(Options.RECORD_EVENTS), "Span is sampled, but does not have RECORD_EVENTS set.");
    }

    public final i a() {
        return this.f28042c;
    }

    public abstract void a(NetworkEvent networkEvent);

    public abstract void a(g gVar);
}
