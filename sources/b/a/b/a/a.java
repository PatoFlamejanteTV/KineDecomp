package b.a.b.a;

/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a */
    private final String f3237a;

    /* renamed from: b */
    private final Object[] f3238b;

    public a(String str, Object[] objArr) {
        this.f3237a = str;
        this.f3238b = objArr;
    }

    @Override // b.a.b.a.e
    public String a() {
        return this.f3237a;
    }

    @Override // b.a.b.a.e
    public void a(d dVar) {
        a(dVar, this.f3238b);
    }

    public static void a(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            a(dVar, i, obj);
        }
    }

    public a(String str) {
        this(str, null);
    }

    private static void a(d dVar, int i, Object obj) {
        if (obj == null) {
            dVar.f(i);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.a(i, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            dVar.a(i, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            dVar.a(i, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            dVar.b(i, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            dVar.b(i, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            dVar.b(i, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            dVar.b(i, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            dVar.a(i, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            dVar.b(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}
