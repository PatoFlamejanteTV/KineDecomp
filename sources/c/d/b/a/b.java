package c.d.b.a;

import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* compiled from: DeviceCapabilities.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public final int f3591a;

    /* renamed from: b */
    public final int f3592b;

    public b(int i, int i2) {
        this.f3591a = i;
        this.f3592b = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.f3591a == this.f3591a && bVar.f3592b == this.f3592b;
    }

    public int hashCode() {
        return (this.f3591a * 31) + this.f3592b;
    }

    public String toString() {
        return this.f3591a + FragmentC2201x.f23219a + this.f3592b;
    }
}
