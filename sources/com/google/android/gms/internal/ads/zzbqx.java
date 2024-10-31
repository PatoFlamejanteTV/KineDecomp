package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public enum zzbqx {
    DOUBLE(0, zzbqz.SCALAR, zzbrn.DOUBLE),
    FLOAT(1, zzbqz.SCALAR, zzbrn.FLOAT),
    INT64(2, zzbqz.SCALAR, zzbrn.LONG),
    UINT64(3, zzbqz.SCALAR, zzbrn.LONG),
    INT32(4, zzbqz.SCALAR, zzbrn.INT),
    FIXED64(5, zzbqz.SCALAR, zzbrn.LONG),
    FIXED32(6, zzbqz.SCALAR, zzbrn.INT),
    BOOL(7, zzbqz.SCALAR, zzbrn.BOOLEAN),
    STRING(8, zzbqz.SCALAR, zzbrn.STRING),
    MESSAGE(9, zzbqz.SCALAR, zzbrn.MESSAGE),
    BYTES(10, zzbqz.SCALAR, zzbrn.BYTE_STRING),
    UINT32(11, zzbqz.SCALAR, zzbrn.INT),
    ENUM(12, zzbqz.SCALAR, zzbrn.ENUM),
    SFIXED32(13, zzbqz.SCALAR, zzbrn.INT),
    SFIXED64(14, zzbqz.SCALAR, zzbrn.LONG),
    SINT32(15, zzbqz.SCALAR, zzbrn.INT),
    SINT64(16, zzbqz.SCALAR, zzbrn.LONG),
    GROUP(17, zzbqz.SCALAR, zzbrn.MESSAGE),
    DOUBLE_LIST(18, zzbqz.VECTOR, zzbrn.DOUBLE),
    FLOAT_LIST(19, zzbqz.VECTOR, zzbrn.FLOAT),
    INT64_LIST(20, zzbqz.VECTOR, zzbrn.LONG),
    UINT64_LIST(21, zzbqz.VECTOR, zzbrn.LONG),
    INT32_LIST(22, zzbqz.VECTOR, zzbrn.INT),
    FIXED64_LIST(23, zzbqz.VECTOR, zzbrn.LONG),
    FIXED32_LIST(24, zzbqz.VECTOR, zzbrn.INT),
    BOOL_LIST(25, zzbqz.VECTOR, zzbrn.BOOLEAN),
    STRING_LIST(26, zzbqz.VECTOR, zzbrn.STRING),
    MESSAGE_LIST(27, zzbqz.VECTOR, zzbrn.MESSAGE),
    BYTES_LIST(28, zzbqz.VECTOR, zzbrn.BYTE_STRING),
    UINT32_LIST(29, zzbqz.VECTOR, zzbrn.INT),
    ENUM_LIST(30, zzbqz.VECTOR, zzbrn.ENUM),
    SFIXED32_LIST(31, zzbqz.VECTOR, zzbrn.INT),
    SFIXED64_LIST(32, zzbqz.VECTOR, zzbrn.LONG),
    SINT32_LIST(33, zzbqz.VECTOR, zzbrn.INT),
    SINT64_LIST(34, zzbqz.VECTOR, zzbrn.LONG),
    DOUBLE_LIST_PACKED(35, zzbqz.PACKED_VECTOR, zzbrn.DOUBLE),
    FLOAT_LIST_PACKED(36, zzbqz.PACKED_VECTOR, zzbrn.FLOAT),
    INT64_LIST_PACKED(37, zzbqz.PACKED_VECTOR, zzbrn.LONG),
    UINT64_LIST_PACKED(38, zzbqz.PACKED_VECTOR, zzbrn.LONG),
    INT32_LIST_PACKED(39, zzbqz.PACKED_VECTOR, zzbrn.INT),
    FIXED64_LIST_PACKED(40, zzbqz.PACKED_VECTOR, zzbrn.LONG),
    FIXED32_LIST_PACKED(41, zzbqz.PACKED_VECTOR, zzbrn.INT),
    BOOL_LIST_PACKED(42, zzbqz.PACKED_VECTOR, zzbrn.BOOLEAN),
    UINT32_LIST_PACKED(43, zzbqz.PACKED_VECTOR, zzbrn.INT),
    ENUM_LIST_PACKED(44, zzbqz.PACKED_VECTOR, zzbrn.ENUM),
    SFIXED32_LIST_PACKED(45, zzbqz.PACKED_VECTOR, zzbrn.INT),
    SFIXED64_LIST_PACKED(46, zzbqz.PACKED_VECTOR, zzbrn.LONG),
    SINT32_LIST_PACKED(47, zzbqz.PACKED_VECTOR, zzbrn.INT),
    SINT64_LIST_PACKED(48, zzbqz.PACKED_VECTOR, zzbrn.LONG),
    GROUP_LIST(49, zzbqz.VECTOR, zzbrn.MESSAGE),
    MAP(50, zzbqz.MAP, zzbrn.VOID);

    private static final zzbqx[] zzfpf;
    private static final Type[] zzfpg = new Type[0];
    private final int id;
    private final zzbrn zzfpb;
    private final zzbqz zzfpc;
    private final Class<?> zzfpd;
    private final boolean zzfpe;

    static {
        zzbqx[] values = values();
        zzfpf = new zzbqx[values.length];
        for (zzbqx zzbqxVar : values) {
            zzfpf[zzbqxVar.id] = zzbqxVar;
        }
    }

    zzbqx(int i, zzbqz zzbqzVar, zzbrn zzbrnVar) {
        int i2;
        this.id = i;
        this.zzfpc = zzbqzVar;
        this.zzfpb = zzbrnVar;
        int i3 = Oh.f11735a[zzbqzVar.ordinal()];
        if (i3 == 1) {
            this.zzfpd = zzbrnVar.zzanl();
        } else if (i3 != 2) {
            this.zzfpd = null;
        } else {
            this.zzfpd = zzbrnVar.zzanl();
        }
        boolean z = false;
        if (zzbqzVar == zzbqz.SCALAR && (i2 = Oh.f11736b[zzbrnVar.ordinal()]) != 1 && i2 != 2 && i2 != 3) {
            z = true;
        }
        this.zzfpe = z;
    }

    public final int id() {
        return this.id;
    }
}
