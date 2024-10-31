package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum zzfn {
    DOUBLE(0, zzfp.SCALAR, zzge.DOUBLE),
    FLOAT(1, zzfp.SCALAR, zzge.FLOAT),
    INT64(2, zzfp.SCALAR, zzge.LONG),
    UINT64(3, zzfp.SCALAR, zzge.LONG),
    INT32(4, zzfp.SCALAR, zzge.INT),
    FIXED64(5, zzfp.SCALAR, zzge.LONG),
    FIXED32(6, zzfp.SCALAR, zzge.INT),
    BOOL(7, zzfp.SCALAR, zzge.BOOLEAN),
    STRING(8, zzfp.SCALAR, zzge.STRING),
    MESSAGE(9, zzfp.SCALAR, zzge.MESSAGE),
    BYTES(10, zzfp.SCALAR, zzge.BYTE_STRING),
    UINT32(11, zzfp.SCALAR, zzge.INT),
    ENUM(12, zzfp.SCALAR, zzge.ENUM),
    SFIXED32(13, zzfp.SCALAR, zzge.INT),
    SFIXED64(14, zzfp.SCALAR, zzge.LONG),
    SINT32(15, zzfp.SCALAR, zzge.INT),
    SINT64(16, zzfp.SCALAR, zzge.LONG),
    GROUP(17, zzfp.SCALAR, zzge.MESSAGE),
    DOUBLE_LIST(18, zzfp.VECTOR, zzge.DOUBLE),
    FLOAT_LIST(19, zzfp.VECTOR, zzge.FLOAT),
    INT64_LIST(20, zzfp.VECTOR, zzge.LONG),
    UINT64_LIST(21, zzfp.VECTOR, zzge.LONG),
    INT32_LIST(22, zzfp.VECTOR, zzge.INT),
    FIXED64_LIST(23, zzfp.VECTOR, zzge.LONG),
    FIXED32_LIST(24, zzfp.VECTOR, zzge.INT),
    BOOL_LIST(25, zzfp.VECTOR, zzge.BOOLEAN),
    STRING_LIST(26, zzfp.VECTOR, zzge.STRING),
    MESSAGE_LIST(27, zzfp.VECTOR, zzge.MESSAGE),
    BYTES_LIST(28, zzfp.VECTOR, zzge.BYTE_STRING),
    UINT32_LIST(29, zzfp.VECTOR, zzge.INT),
    ENUM_LIST(30, zzfp.VECTOR, zzge.ENUM),
    SFIXED32_LIST(31, zzfp.VECTOR, zzge.INT),
    SFIXED64_LIST(32, zzfp.VECTOR, zzge.LONG),
    SINT32_LIST(33, zzfp.VECTOR, zzge.INT),
    SINT64_LIST(34, zzfp.VECTOR, zzge.LONG),
    DOUBLE_LIST_PACKED(35, zzfp.PACKED_VECTOR, zzge.DOUBLE),
    FLOAT_LIST_PACKED(36, zzfp.PACKED_VECTOR, zzge.FLOAT),
    INT64_LIST_PACKED(37, zzfp.PACKED_VECTOR, zzge.LONG),
    UINT64_LIST_PACKED(38, zzfp.PACKED_VECTOR, zzge.LONG),
    INT32_LIST_PACKED(39, zzfp.PACKED_VECTOR, zzge.INT),
    FIXED64_LIST_PACKED(40, zzfp.PACKED_VECTOR, zzge.LONG),
    FIXED32_LIST_PACKED(41, zzfp.PACKED_VECTOR, zzge.INT),
    BOOL_LIST_PACKED(42, zzfp.PACKED_VECTOR, zzge.BOOLEAN),
    UINT32_LIST_PACKED(43, zzfp.PACKED_VECTOR, zzge.INT),
    ENUM_LIST_PACKED(44, zzfp.PACKED_VECTOR, zzge.ENUM),
    SFIXED32_LIST_PACKED(45, zzfp.PACKED_VECTOR, zzge.INT),
    SFIXED64_LIST_PACKED(46, zzfp.PACKED_VECTOR, zzge.LONG),
    SINT32_LIST_PACKED(47, zzfp.PACKED_VECTOR, zzge.INT),
    SINT64_LIST_PACKED(48, zzfp.PACKED_VECTOR, zzge.LONG),
    GROUP_LIST(49, zzfp.VECTOR, zzge.MESSAGE),
    MAP(50, zzfp.MAP, zzge.VOID);

    private static final zzfn[] zzwj;
    private static final Type[] zzwk = new Type[0];
    private final int id;
    private final zzge zzwf;
    private final zzfp zzwg;
    private final Class<?> zzwh;
    private final boolean zzwi;

    static {
        zzfn[] values = values();
        zzwj = new zzfn[values.length];
        for (zzfn zzfnVar : values) {
            zzwj[zzfnVar.id] = zzfnVar;
        }
    }

    zzfn(int i, zzfp zzfpVar, zzge zzgeVar) {
        int i2;
        this.id = i;
        this.zzwg = zzfpVar;
        this.zzwf = zzgeVar;
        int i3 = B.f12952a[zzfpVar.ordinal()];
        if (i3 == 1) {
            this.zzwh = zzgeVar.zzhz();
        } else if (i3 != 2) {
            this.zzwh = null;
        } else {
            this.zzwh = zzgeVar.zzhz();
        }
        boolean z = false;
        if (zzfpVar == zzfp.SCALAR && (i2 = B.f12953b[zzgeVar.ordinal()]) != 1 && i2 != 2 && i2 != 3) {
            z = true;
        }
        this.zzwi = z;
    }

    public final int id() {
        return this.id;
    }
}
