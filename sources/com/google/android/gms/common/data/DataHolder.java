package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();

    /* renamed from: a */
    private static final Builder f11004a = new a(new String[0], null);

    /* renamed from: b */
    private final int f11005b;

    /* renamed from: c */
    private final String[] f11006c;

    /* renamed from: d */
    private Bundle f11007d;

    /* renamed from: e */
    private final CursorWindow[] f11008e;

    /* renamed from: f */
    private final int f11009f;

    /* renamed from: g */
    private final Bundle f11010g;

    /* renamed from: h */
    private int[] f11011h;
    private int i;
    private boolean j;
    private boolean k;

    /* loaded from: classes.dex */
    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.j = false;
        this.k = true;
        this.f11005b = i;
        this.f11006c = strArr;
        this.f11008e = cursorWindowArr;
        this.f11009f = i2;
        this.f11010g = bundle;
    }

    public final void O() {
        this.f11007d = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.f11006c;
            if (i2 >= strArr.length) {
                break;
            }
            this.f11007d.putInt(strArr[i2], i2);
            i2++;
        }
        this.f11011h = new int[this.f11008e.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f11008e;
            if (i < cursorWindowArr.length) {
                this.f11011h[i] = i3;
                i3 += this.f11008e[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.i = i3;
                return;
            }
        }
    }

    @KeepForSdk
    public final Bundle a() {
        return this.f11010g;
    }

    @KeepForSdk
    public final String b(String str, int i, int i2) {
        a(str, i);
        return this.f11008e[i2].getString(i, this.f11007d.getInt(str));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public final void close() {
        synchronized (this) {
            if (!this.j) {
                this.j = true;
                for (int i = 0; i < this.f11008e.length; i++) {
                    this.f11008e[i].close();
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.k && this.f11008e.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public final int getCount() {
        return this.i;
    }

    @KeepForSdk
    public final int getStatusCode() {
        return this.f11009f;
    }

    @KeepForSdk
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.j;
        }
        return z;
    }

    @KeepForSdk
    public final int j(int i) {
        int i2 = 0;
        Preconditions.b(i >= 0 && i < this.i);
        while (true) {
            int[] iArr = this.f11011h;
            if (i2 >= iArr.length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.f11011h.length ? i2 - 1 : i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11006c, false);
        SafeParcelWriter.a(parcel, 2, (Parcelable[]) this.f11008e, i, false);
        SafeParcelWriter.a(parcel, 3, getStatusCode());
        SafeParcelWriter.a(parcel, 4, a(), false);
        SafeParcelWriter.a(parcel, 1000, this.f11005b);
        SafeParcelWriter.a(parcel, a2);
        if ((i & 1) != 0) {
            close();
        }
    }

    private static CursorWindow[] a(Builder builder, int i) {
        if (builder.f11012a.length != 0) {
            List subList = (i < 0 || i >= builder.f11013b.size()) ? builder.f11013b : builder.f11013b.subList(0, i);
            int size = subList.size();
            CursorWindow cursorWindow = new CursorWindow(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cursorWindow);
            cursorWindow.setNumColumns(builder.f11012a.length);
            CursorWindow cursorWindow2 = cursorWindow;
            int i2 = 0;
            boolean z = false;
            while (i2 < size) {
                try {
                    if (!cursorWindow2.allocRow()) {
                        StringBuilder sb = new StringBuilder(72);
                        sb.append("Allocating additional cursor window for large data set (row ");
                        sb.append(i2);
                        sb.append(")");
                        Log.d("DataHolder", sb.toString());
                        cursorWindow2 = new CursorWindow(false);
                        cursorWindow2.setStartPosition(i2);
                        cursorWindow2.setNumColumns(builder.f11012a.length);
                        arrayList.add(cursorWindow2);
                        if (!cursorWindow2.allocRow()) {
                            Log.e("DataHolder", "Unable to allocate row to hold data.");
                            arrayList.remove(cursorWindow2);
                            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                        }
                    }
                    Map map = (Map) subList.get(i2);
                    boolean z2 = true;
                    for (int i3 = 0; i3 < builder.f11012a.length && z2; i3++) {
                        String str = builder.f11012a[i3];
                        Object obj = map.get(str);
                        if (obj == null) {
                            z2 = cursorWindow2.putNull(i2, i3);
                        } else if (obj instanceof String) {
                            z2 = cursorWindow2.putString((String) obj, i2, i3);
                        } else if (obj instanceof Long) {
                            z2 = cursorWindow2.putLong(((Long) obj).longValue(), i2, i3);
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow2.putLong(((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            z2 = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i2, i3);
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow2.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else if (obj instanceof Float) {
                            z2 = cursorWindow2.putDouble(((Float) obj).floatValue(), i2, i3);
                        } else {
                            String valueOf = String.valueOf(obj);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length());
                            sb2.append("Unsupported object for column ");
                            sb2.append(str);
                            sb2.append(": ");
                            sb2.append(valueOf);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                    }
                    if (z2) {
                        z = false;
                    } else if (!z) {
                        StringBuilder sb3 = new StringBuilder(74);
                        sb3.append("Couldn't populate window data for row ");
                        sb3.append(i2);
                        sb3.append(" - allocating new window.");
                        Log.d("DataHolder", sb3.toString());
                        cursorWindow2.freeLastRow();
                        cursorWindow2 = new CursorWindow(false);
                        cursorWindow2.setStartPosition(i2);
                        cursorWindow2.setNumColumns(builder.f11012a.length);
                        arrayList.add(cursorWindow2);
                        i2--;
                        z = true;
                    } else {
                        throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    i2++;
                } catch (RuntimeException e2) {
                    int size2 = arrayList.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((CursorWindow) arrayList.get(i4)).close();
                    }
                    throw e2;
                }
            }
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        }
        return new CursorWindow[0];
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private final String[] f11012a;

        /* renamed from: b */
        private final ArrayList<HashMap<String, Object>> f11013b;

        /* renamed from: c */
        private final String f11014c;

        /* renamed from: d */
        private final HashMap<Object, Integer> f11015d;

        /* renamed from: e */
        private boolean f11016e;

        /* renamed from: f */
        private String f11017f;

        private Builder(String[] strArr, String str) {
            Preconditions.a(strArr);
            this.f11012a = strArr;
            this.f11013b = new ArrayList<>();
            this.f11014c = str;
            this.f11015d = new HashMap<>();
            this.f11016e = false;
            this.f11017f = null;
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.android.gms.common.data.DataHolder.Builder a(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                com.google.android.gms.common.internal.Asserts.a(r5)
                java.lang.String r0 = r4.f11014c
                r1 = -1
                if (r0 != 0) goto La
            L8:
                r0 = -1
                goto L2f
            La:
                java.lang.Object r0 = r5.get(r0)
                if (r0 != 0) goto L11
                goto L8
            L11:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.f11015d
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 != 0) goto L2b
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.f11015d
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r4.f11013b
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
                goto L8
            L2b:
                int r0 = r2.intValue()
            L2f:
                if (r0 != r1) goto L37
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.f11013b
                r0.add(r5)
                goto L41
            L37:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.f11013b
                r1.remove(r0)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r4.f11013b
                r1.add(r0, r5)
            L41:
                r5 = 0
                r4.f11016e = r5
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.Builder.a(java.util.HashMap):com.google.android.gms.common.data.DataHolder$Builder");
        }

        public /* synthetic */ Builder(String[] strArr, String str, a aVar) {
            this(strArr, null);
        }

        @KeepForSdk
        public Builder a(ContentValues contentValues) {
            Asserts.a(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return a(hashMap);
        }

        @KeepForSdk
        public DataHolder a(int i) {
            return new DataHolder(this, i, (Bundle) null, (a) null);
        }
    }

    @KeepForSdk
    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.j = false;
        this.k = true;
        this.f11005b = 1;
        Preconditions.a(strArr);
        this.f11006c = strArr;
        Preconditions.a(cursorWindowArr);
        this.f11008e = cursorWindowArr;
        this.f11009f = i;
        this.f11010g = bundle;
        O();
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.f11012a, a(builder, -1), i, (Bundle) null);
    }

    /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, a aVar) {
        this(builder, i, null);
    }

    private final void a(String str, int i) {
        Bundle bundle = this.f11007d;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i < 0 || i >= this.i) {
                    throw new CursorIndexOutOfBoundsException(i, this.i);
                }
                return;
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
    }

    @KeepForSdk
    public final byte[] a(String str, int i, int i2) {
        a(str, i);
        return this.f11008e[i2].getBlob(i, this.f11007d.getInt(str));
    }

    @KeepForSdk
    public static Builder a(String[] strArr) {
        return new Builder(strArr, null, null);
    }
}
