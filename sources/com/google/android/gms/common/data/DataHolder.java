package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza l = new a(new String[0], null);

    /* renamed from: a, reason: collision with root package name */
    Bundle f985a;
    int[] b;
    int c;
    boolean d;
    private final int e;
    private final String[] f;
    private final CursorWindow[] g;
    private final int h;
    private final Bundle i;
    private Object j;
    private boolean k;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f986a;
        private final ArrayList<HashMap<String, Object>> b;
        private final String c;
        private final HashMap<Object, Integer> d;
        private boolean e;
        private String f;

        private zza(String[] strArr, String str) {
            this.f986a = (String[]) zzx.a(strArr);
            this.b = new ArrayList<>();
            this.c = str;
            this.d = new HashMap<>();
            this.e = false;
            this.f = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zza(String[] strArr, String str, a aVar) {
            this(strArr, str);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.d = false;
        this.k = true;
        this.e = i;
        this.f = strArr;
        this.g = cursorWindowArr;
        this.h = i2;
        this.i = bundle;
    }

    private DataHolder(zza zzaVar, int i, Bundle bundle) {
        this(zzaVar.f986a, a(zzaVar, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.d = false;
        this.k = true;
        this.e = 1;
        this.f = (String[]) zzx.a(strArr);
        this.g = (CursorWindow[]) zzx.a(cursorWindowArr);
        this.h = i;
        this.i = bundle;
        a();
    }

    public static DataHolder a(int i, Bundle bundle) {
        return new DataHolder(l, i, bundle);
    }

    private void a(String str, int i) {
        if (this.f985a == null || !this.f985a.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        }
        if (h()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= this.c) {
            throw new CursorIndexOutOfBoundsException(i, this.c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38, types: [java.util.List] */
    private static CursorWindow[] a(zza zzaVar, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zzaVar.f986a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList subList = (i < 0 || i >= zzaVar.b.size()) ? zzaVar.b : zzaVar.b.subList(0, i);
        int size = subList.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zzaVar.f986a.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zzaVar.f986a.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) subList.get(i3);
                boolean z3 = true;
                for (int i4 = 0; i4 < zzaVar.f986a.length && z3; i4++) {
                    String str = zzaVar.f986a[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z3 = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z3 = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z3 = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z3 = cursorWindow2.putLong(((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z3 = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z3 = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        z3 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else {
                        if (!(obj instanceof Float)) {
                            throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                        }
                        z3 = cursorWindow2.putDouble(((Float) obj).floatValue(), i3, i4);
                    }
                }
                if (z3) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else {
                    if (z2) {
                        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zzaVar.f986a.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder b(int i) {
        return a(i, (Bundle) null);
    }

    public int a(int i) {
        int i2 = 0;
        zzx.a(i >= 0 && i < this.c);
        while (true) {
            if (i2 >= this.b.length) {
                break;
            }
            if (i < this.b[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.b.length ? i2 - 1 : i2;
    }

    public long a(String str, int i, int i2) {
        a(str, i);
        return this.g[i2].getLong(i, this.f985a.getInt(str));
    }

    public void a() {
        this.f985a = new Bundle();
        for (int i = 0; i < this.f.length; i++) {
            this.f985a.putInt(this.f[i], i);
        }
        this.b = new int[this.g.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.g.length; i3++) {
            this.b[i3] = i2;
            i2 += this.g[i3].getNumRows() - (i2 - this.g[i3].getStartPosition());
        }
        this.c = i2;
    }

    public void a(Object obj) {
        this.j = obj;
    }

    public boolean a(String str) {
        return this.f985a.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.e;
    }

    public int b(String str, int i, int i2) {
        a(str, i);
        return this.g[i2].getInt(i, this.f985a.getInt(str));
    }

    public String c(String str, int i, int i2) {
        a(str, i);
        return this.g[i2].getString(i, this.f985a.getInt(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] c() {
        return this.f;
    }

    public boolean d(String str, int i, int i2) {
        a(str, i);
        return Long.valueOf(this.g[i2].getLong(i, this.f985a.getInt(str))).longValue() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CursorWindow[] d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e(String str, int i, int i2) {
        a(str, i);
        return this.g[i2].getFloat(i, this.f985a.getInt(str));
    }

    public int e() {
        return this.h;
    }

    public Bundle f() {
        return this.i;
    }

    public byte[] f(String str, int i, int i2) {
        a(str, i);
        return this.g[i2].getBlob(i, this.f985a.getInt(str));
    }

    protected void finalize() throws Throwable {
        try {
            if (this.k && this.g.length > 0 && !h()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.j == null ? "internal object: " + toString() : this.j.toString()) + ")");
                i();
            }
        } finally {
            super.finalize();
        }
    }

    public int g() {
        return this.c;
    }

    public Uri g(String str, int i, int i2) {
        String c = c(str, i, i2);
        if (c == null) {
            return null;
        }
        return Uri.parse(c);
    }

    public boolean h() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    public boolean h(String str, int i, int i2) {
        a(str, i);
        return this.g[i2].isNull(i, this.f985a.getInt(str));
    }

    public void i() {
        synchronized (this) {
            if (!this.d) {
                this.d = true;
                for (int i = 0; i < this.g.length; i++) {
                    this.g[i].close();
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
