package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class V {

    /* renamed from: b */
    public View f561b;

    /* renamed from: a */
    public final Map<String, Object> f560a = new HashMap();

    /* renamed from: c */
    final ArrayList<M> f562c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof V)) {
            return false;
        }
        V v = (V) obj;
        return this.f561b == v.f561b && this.f560a.equals(v.f560a);
    }

    public int hashCode() {
        return (this.f561b.hashCode() * 31) + this.f560a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f561b + "\n") + "    values:";
        for (String str2 : this.f560a.keySet()) {
            str = str + "    " + str2 + ": " + this.f560a.get(str2) + "\n";
        }
        return str;
    }
}
