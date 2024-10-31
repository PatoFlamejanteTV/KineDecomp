package c.d.b.d.a.a.b;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.nextreaming.nexeditorui.NexTimeline;

/* compiled from: VideoOutput.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private long f3661a;

    /* renamed from: b */
    private long f3662b;

    /* renamed from: f */
    private long f3666f;

    /* renamed from: c */
    private String f3663c = MessengerShareContentUtility.IMAGE_RATIO_SQUARE;

    /* renamed from: d */
    private String f3664d = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;

    /* renamed from: e */
    private long f3665e = 24;

    /* renamed from: g */
    private boolean f3667g = false;

    public b(long j, long j2, long j3) {
        this.f3661a = j;
        this.f3662b = j2;
        this.f3666f = j3;
    }

    public long a() {
        return this.f3665e;
    }

    public long b() {
        return this.f3666f;
    }

    public long c() {
        return this.f3662b;
    }

    public long d() {
        return this.f3661a;
    }

    public boolean e() {
        return this.f3667g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------- Video Output -------------------");
        sb.append("\n width          : " + this.f3661a);
        sb.append("\n height         : " + this.f3662b);
        sb.append("\n aspect ratio   : " + this.f3663c);
        sb.append("\n textColor depth    : " + this.f3665e);
        sb.append("\n fps            : " + this.f3666f);
        sb.append("\n ntsc           : " + this.f3667g);
        return sb.toString();
    }
}
