package org.koin.core.definition;

import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: Properties.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a */
    private final Map<String, Object> f29373a;

    public e() {
        this(null, 1, null);
    }

    public e(Map<String, Object> map) {
        h.b(map, ShareConstants.WEB_DIALOG_PARAM_DATA);
        this.f29373a = map;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof e) && h.a(this.f29373a, ((e) obj).f29373a);
        }
        return true;
    }

    public int hashCode() {
        Map<String, Object> map = this.f29373a;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Properties(data=" + this.f29373a + ")";
    }

    public /* synthetic */ e(Map map, int i, f fVar) {
        this((i & 1) != 0 ? new ConcurrentHashMap() : map);
    }
}
