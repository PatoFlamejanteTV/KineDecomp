package e.a.e;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: TagContext.java */
@Immutable
/* loaded from: classes3.dex */
public abstract class f {
    protected abstract Iterator<e> a();

    public boolean equals(@Nullable Object obj) {
        Multiset create;
        Object create2;
        if (!(obj instanceof f)) {
            return false;
        }
        Iterator<e> a2 = a();
        Iterator<e> a3 = ((f) obj).a();
        if (a2 == null) {
            create = ImmutableMultiset.of();
        } else {
            create = HashMultiset.create(Lists.a(a2));
        }
        if (a3 == null) {
            create2 = ImmutableMultiset.of();
        } else {
            create2 = HashMultiset.create(Lists.a(a3));
        }
        return create.equals(create2);
    }

    public final int hashCode() {
        Iterator<e> a2 = a();
        int i = 0;
        if (a2 == null) {
            return 0;
        }
        while (a2.hasNext()) {
            e next = a2.next();
            if (next != null) {
                i += next.hashCode();
            }
        }
        return i;
    }

    public String toString() {
        return "TagContext";
    }
}
