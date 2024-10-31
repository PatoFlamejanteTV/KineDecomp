package c.d.b.m;

/* compiled from: TimeStringUtils.java */
/* loaded from: classes2.dex */
public class o {
    public static String a(int i) {
        return String.format("%02d:%02d:%02d.%02d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / 1000), Integer.valueOf((i % 1000) / 10));
    }

    public static String b(int i) {
        return String.format("%02d:%02d:%02d.%03d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / 1000), Integer.valueOf(i % 1000));
    }
}
