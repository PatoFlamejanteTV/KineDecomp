package c.d.b.d.a.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AudioOutput.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private long f3645a;

    /* renamed from: b */
    private long f3646b;

    /* renamed from: c */
    private long f3647c;

    /* renamed from: d */
    public List<C0014a> f3648d = new ArrayList();

    /* compiled from: AudioOutput.java */
    /* renamed from: c.d.b.d.a.a.b.a$a */
    /* loaded from: classes.dex */
    public static class C0014a {

        /* renamed from: a */
        public long f3657a;

        /* renamed from: b */
        public long f3658b;

        /* renamed from: c */
        public long f3659c;

        /* renamed from: d */
        public long f3660d;

        public C0014a(long j, long j2, long j3, long j4) {
            this.f3657a = j;
            this.f3658b = j2;
            this.f3659c = j3;
            this.f3660d = j4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\n-------------- audio group -------------------");
            sb.append("\n groupIndex         : " + this.f3657a);
            sb.append("\n channelIndex       : " + this.f3658b);
            sb.append("\n num of channels    : " + this.f3659c);
            sb.append("\n downMix            : " + this.f3660d);
            return sb.toString();
        }
    }

    public a(long j, long j2, long j3) {
        this.f3645a = j;
        this.f3646b = j2;
        this.f3647c = j3;
        int i = 0;
        while (i < this.f3645a) {
            i++;
            long j4 = i;
            this.f3648d.add(new C0014a(j4, j4, 1L, 0L));
        }
    }

    public long a() {
        return this.f3646b;
    }

    public long b() {
        return this.f3645a;
    }

    public long c() {
        return this.f3647c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------- audio output -------------------");
        sb.append("\n num of outputchannels  : " + this.f3645a);
        sb.append("\n depth                  : " + this.f3646b);
        sb.append("\n samplerate             : " + this.f3647c);
        Iterator<C0014a> it = this.f3648d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
