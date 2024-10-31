package com.nexstreaming.app.general.norm;

import android.util.Log;
import com.nexstreaming.app.general.norm.NormColumnInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: NormTableInfo.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a */
    private static final String f19652a = "e";

    /* renamed from: b */
    private static Map<Class<? extends c>, e> f19653b = new HashMap();

    /* renamed from: c */
    private final String[] f19654c;

    /* renamed from: d */
    private final String[] f19655d;

    /* renamed from: e */
    private final NormColumnInfo[] f19656e;

    /* renamed from: f */
    private final String f19657f;

    /* renamed from: g */
    private final String[] f19658g;

    /* renamed from: h */
    private final NormColumnInfo f19659h;

    private e(Class<? extends c> cls) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        this.f19657f = b.a(cls.getSimpleName());
        sb.append("CREATE TABLE ");
        sb.append(this.f19657f);
        sb.append(" (\n    ");
        sb2.append("DROP TABLE IF EXISTS ");
        sb2.append(this.f19657f);
        Field[] declaredFields = cls.getDeclaredFields();
        int i = 0;
        for (Field field : declaredFields) {
            if (a(field)) {
                i++;
            }
        }
        this.f19656e = new NormColumnInfo[declaredFields.length - i];
        this.f19658g = new String[declaredFields.length - i];
        NormColumnInfo normColumnInfo = null;
        String[] strArr = null;
        String[] strArr2 = null;
        int i2 = 0;
        int i3 = -1;
        for (Field field2 : declaredFields) {
            if (!a(field2)) {
                i3++;
                NormColumnInfo normColumnInfo2 = new NormColumnInfo(field2);
                Log.d(f19652a, "columnName: " + normColumnInfo2.f19641a + ", addColumnVersion: " + normColumnInfo2.i);
                this.f19656e[i3] = normColumnInfo2;
                this.f19658g[i3] = normColumnInfo2.f19641a;
                if (normColumnInfo2.f19648h) {
                    if (strArr == null) {
                        strArr = new String[declaredFields.length];
                        strArr2 = new String[declaredFields.length];
                    }
                    strArr[i2] = "CREATE INDEX idx_" + normColumnInfo2.f19641a + " ON " + this.f19657f + "( " + normColumnInfo2.f19641a + ")";
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("DROP INDEX IF EXISTS idx_");
                    sb3.append(normColumnInfo2.f19641a);
                    strArr2[i2] = sb3.toString();
                    i2++;
                }
                normColumnInfo = normColumnInfo2.f19647g ? normColumnInfo2 : normColumnInfo;
                if (i3 > 0) {
                    sb.append(",\n    ");
                }
                sb.append(normColumnInfo2.f19641a);
                sb.append(' ');
                sb.append(a(normColumnInfo2.f19643c));
                if (normColumnInfo2.f19647g) {
                    sb.append(" PRIMARY KEY");
                }
                if (normColumnInfo2.f19644d) {
                    sb.append(" UNIQUE");
                }
                if (normColumnInfo2.f19645e) {
                    sb.append(" NOT NULL");
                }
            }
        }
        this.f19659h = normColumnInfo;
        sb.append(')');
        int i4 = i2 + 1;
        this.f19654c = new String[i4];
        this.f19654c[0] = sb.toString();
        if (i2 > 0) {
            System.arraycopy(strArr, 0, this.f19654c, 1, i2);
        }
        this.f19655d = new String[i4];
        this.f19655d[i2] = sb2.toString();
        if (i2 > 0) {
            System.arraycopy(strArr2, 0, this.f19655d, 0, i2);
        }
    }

    private boolean a(Field field) {
        if (field.isSynthetic()) {
            return true;
        }
        String name = field.getName();
        return name.startsWith("$") || name.equals("serialVersionUID");
    }

    public NormColumnInfo[] b() {
        return this.f19656e;
    }

    public String[] c() {
        return this.f19654c;
    }

    public String[] d() {
        return this.f19655d;
    }

    public NormColumnInfo e() {
        return this.f19659h;
    }

    public String f() {
        return this.f19657f;
    }

    private String a(NormColumnInfo.ColumnType columnType) {
        switch (d.f19651a[columnType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "INTEGER";
            case 4:
            case 5:
                return "REAL";
            case 6:
            case 7:
            case 8:
                return "TEXT";
            case 9:
                return "BLOB";
            default:
                return "";
        }
    }

    public static e a(Class<? extends c> cls) {
        e eVar = f19653b.get(cls);
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(cls);
        f19653b.put(cls, eVar2);
        return eVar2;
    }

    public String[] a(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            NormColumnInfo[] normColumnInfoArr = this.f19656e;
            if (i3 >= normColumnInfoArr.length) {
                break;
            }
            if (normColumnInfoArr[i3].i > i) {
                arrayList.add(Integer.valueOf(i3));
            }
            i3++;
        }
        if (arrayList.size() == 0) {
            return new String[0];
        }
        String[] strArr = new String[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            NormColumnInfo normColumnInfo = this.f19656e[((Integer) it.next()).intValue()];
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append(this.f19657f);
            sb.append(" ADD COLUMN ");
            sb.append(normColumnInfo.f19641a);
            sb.append(" ");
            sb.append(a(normColumnInfo.f19643c));
            if (normColumnInfo.f19647g) {
                sb.append(" PRIMARY KEY");
            }
            if (normColumnInfo.f19644d) {
                sb.append(" UNIQUE");
            }
            if (normColumnInfo.f19645e) {
                sb.append(" NOT NULL");
            }
            if (normColumnInfo.f19641a.equalsIgnoreCase("asset_level")) {
                sb.append(" DEFAULT '1'");
            } else {
                sb.append(" DEFAULT 'null'");
            }
            strArr[i2] = sb.toString();
            sb.reverse();
            i2++;
        }
        return strArr;
    }

    public String[] a() {
        return this.f19658g;
    }
}
