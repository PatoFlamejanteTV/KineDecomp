package com.google.android.gms.internal.ads;

import android.support.v4.view.ViewCompat;

/* renamed from: com.google.android.gms.internal.ads.sj */
/* loaded from: classes2.dex */
final class C1085sj implements InterfaceC1030oj {

    /* renamed from: a */
    private final /* synthetic */ zzbz f12533a;

    /* JADX INFO: Access modifiers changed from: private */
    public C1085sj(zzbz zzbzVar) {
        this.f12533a = zzbzVar;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1030oj
    public final void a(byte[] bArr, byte[] bArr2) {
        zzbz zzbzVar = this.f12533a;
        int i = zzbzVar.zzoj;
        int i2 = zzbzVar.zzmo;
        zzbzVar.zzli = (i2 ^ (-1)) & i;
        int i3 = zzbzVar.zzli;
        zzbzVar.zzph = (i3 ^ (-1)) & i;
        int i4 = zzbzVar.zznr;
        int i5 = zzbzVar.zzph;
        zzbzVar.zzjl = i4 | i5;
        int i6 = zzbzVar.zzjl;
        int i7 = zzbzVar.zznd;
        zzbzVar.zzjl = i6 & (i7 ^ (-1));
        zzbzVar.zzot ^= i3;
        int i8 = zzbzVar.zzot;
        zzbzVar.zzjl ^= i8;
        zzbzVar.zzpo = zzbzVar.zzjl ^ zzbzVar.zzpo;
        zzbzVar.zzpz = i8 ^ zzbzVar.zzpz;
        int i9 = zzbzVar.zzob;
        zzbzVar.zzpz &= i9;
        zzbzVar.zzpz = zzbzVar.zzmq ^ zzbzVar.zzpz;
        zzbzVar.zzmq = i3 ^ i4;
        zzbzVar.zzmq &= i7;
        zzbzVar.zzmq = zzbzVar.zzmb ^ zzbzVar.zzmq;
        int i10 = zzbzVar.zzmq;
        zzbzVar.zzmb = i9 & i10;
        zzbzVar.zzmb = i10 ^ zzbzVar.zzmb;
        int i11 = zzbzVar.zzll;
        zzbzVar.zzmb |= i11;
        zzbzVar.zzmb = zzbzVar.zzpz ^ zzbzVar.zzmb;
        zzbzVar.zzjw = zzbzVar.zzmb ^ zzbzVar.zzjw;
        zzbzVar.zzmb = i4 | i3;
        zzbzVar.zzmb ^= i;
        zzbzVar.zzls = zzbzVar.zzmb ^ zzbzVar.zzls;
        zzbzVar.zzls = (zzbzVar.zzls ^ (-1)) & i9;
        zzbzVar.zzls = zzbzVar.zzmm ^ zzbzVar.zzls;
        zzbzVar.zzls &= i11 ^ (-1);
        zzbzVar.zzmm = (i4 ^ (-1)) & i3;
        zzbzVar.zzmm ^= i2;
        zzbzVar.zzmm = (zzbzVar.zzmm ^ (-1)) & i7;
        zzbzVar.zzmb = i4 | i3;
        zzbzVar.zzmb = zzbzVar.zzke ^ zzbzVar.zzmb;
        zzbzVar.zzmb = (zzbzVar.zzmb ^ (-1)) & i7;
        zzbzVar.zzkb &= i ^ (-1);
        zzbzVar.zzkb = zzbzVar.zzlq ^ zzbzVar.zzkb;
        zzbzVar.zzki = zzbzVar.zzkb ^ zzbzVar.zzki;
        zzbzVar.zzof = zzbzVar.zzki ^ zzbzVar.zzof;
        int i12 = zzbzVar.zznt;
        int i13 = zzbzVar.zzof;
        zzbzVar.zzki = i12 | i13;
        int i14 = zzbzVar.zzou;
        zzbzVar.zzki ^= i14;
        zzbzVar.zzlk = zzbzVar.zzki ^ zzbzVar.zzlk;
        zzbzVar.zzof = i12 & i13;
        zzbzVar.zzof ^= i14;
        zzbzVar.zzla = zzbzVar.zzof ^ zzbzVar.zzla;
        zzbzVar.zzoj = i ^ i2;
        int i15 = zzbzVar.zzoj;
        zzbzVar.zzof = (i4 ^ (-1)) & i15;
        zzbzVar.zzof = i3 ^ zzbzVar.zzof;
        zzbzVar.zzmm = zzbzVar.zzof ^ zzbzVar.zzmm;
        zzbzVar.zzmm = (zzbzVar.zzmm ^ (-1)) & i9;
        zzbzVar.zzof = i4 | i15;
        zzbzVar.zzof ^= i15;
        zzbzVar.zzmb = zzbzVar.zzof ^ zzbzVar.zzmb;
        zzbzVar.zzmb &= i9;
        zzbzVar.zzpb ^= i15;
        zzbzVar.zzpb &= i7;
        zzbzVar.zzpb &= i9;
        zzbzVar.zzpb ^= i5;
        zzbzVar.zzpb |= i11;
        zzbzVar.zzpb = zzbzVar.zzpo ^ zzbzVar.zzpb;
        zzbzVar.zzje = zzbzVar.zzpb ^ zzbzVar.zzje;
        zzbzVar.zznr = i15 ^ i4;
        int i16 = zzbzVar.zznr;
        zzbzVar.zzjo ^= i16;
        zzbzVar.zzmm = zzbzVar.zzjo ^ zzbzVar.zzmm;
        zzbzVar.zzqb = zzbzVar.zzmm ^ zzbzVar.zzqb;
        zzbzVar.zznm = zzbzVar.zzqb ^ zzbzVar.zznm;
        zzbzVar.zznm ^= -1;
        zzbzVar.zzlm = i15 ^ zzbzVar.zzlm;
        zzbzVar.zzlm &= i7;
        zzbzVar.zzlm ^= i16;
        zzbzVar.zzmb = zzbzVar.zzlm ^ zzbzVar.zzmb;
        zzbzVar.zzls = zzbzVar.zzmb ^ zzbzVar.zzls;
        zzbzVar.zznk = zzbzVar.zzls ^ zzbzVar.zznk;
        int i17 = zzbzVar.zzmk;
        bArr2[0] = (byte) i17;
        bArr2[1] = (byte) (i17 >>> 8);
        bArr2[2] = (byte) (i17 >>> 16);
        bArr2[3] = (byte) ((i17 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i18 = zzbzVar.zzpd;
        bArr2[4] = (byte) i18;
        bArr2[5] = (byte) (i18 >>> 8);
        bArr2[6] = (byte) (i18 >>> 16);
        bArr2[7] = (byte) ((i18 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i19 = zzbzVar.zznm;
        bArr2[8] = (byte) i19;
        bArr2[9] = (byte) (i19 >>> 8);
        bArr2[10] = (byte) (i19 >>> 16);
        bArr2[11] = (byte) ((i19 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i20 = zzbzVar.zznc;
        bArr2[12] = (byte) i20;
        bArr2[13] = (byte) (i20 >>> 8);
        bArr2[14] = (byte) (i20 >>> 16);
        bArr2[15] = (byte) ((i20 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i21 = zzbzVar.zzje;
        bArr2[16] = (byte) i21;
        bArr2[17] = (byte) (i21 >>> 8);
        bArr2[18] = (byte) (i21 >>> 16);
        bArr2[19] = (byte) ((i21 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i22 = zzbzVar.zzjd;
        bArr2[20] = (byte) i22;
        bArr2[21] = (byte) (i22 >>> 8);
        bArr2[22] = (byte) (i22 >>> 16);
        bArr2[23] = (byte) ((i22 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i23 = zzbzVar.zzjg;
        bArr2[24] = (byte) i23;
        bArr2[25] = (byte) (i23 >>> 8);
        bArr2[26] = (byte) (i23 >>> 16);
        bArr2[27] = (byte) ((i23 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        bArr2[28] = (byte) i9;
        bArr2[29] = (byte) (i9 >>> 8);
        bArr2[30] = (byte) (i9 >>> 16);
        bArr2[31] = (byte) ((i9 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i24 = zzbzVar.zzji;
        bArr2[32] = (byte) i24;
        bArr2[33] = (byte) (i24 >>> 8);
        bArr2[34] = (byte) (i24 >>> 16);
        bArr2[35] = (byte) ((i24 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i25 = zzbzVar.zzpv;
        bArr2[36] = (byte) i25;
        bArr2[37] = (byte) (i25 >>> 8);
        bArr2[38] = (byte) (i25 >>> 16);
        bArr2[39] = (byte) ((i25 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i26 = zzbzVar.zzny;
        bArr2[40] = (byte) i26;
        bArr2[41] = (byte) (i26 >>> 8);
        bArr2[42] = (byte) (i26 >>> 16);
        bArr2[43] = (byte) ((i26 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i27 = zzbzVar.zzjj;
        bArr2[44] = (byte) i27;
        bArr2[45] = (byte) (i27 >>> 8);
        bArr2[46] = (byte) (i27 >>> 16);
        bArr2[47] = (byte) ((i27 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i28 = zzbzVar.zzmf;
        bArr2[48] = (byte) i28;
        bArr2[49] = (byte) (i28 >>> 8);
        bArr2[50] = (byte) (i28 >>> 16);
        bArr2[51] = (byte) ((i28 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i29 = zzbzVar.zzoc;
        bArr2[52] = (byte) i29;
        bArr2[53] = (byte) (i29 >>> 8);
        bArr2[54] = (byte) (i29 >>> 16);
        bArr2[55] = (byte) ((i29 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i30 = zzbzVar.zzmw;
        bArr2[56] = (byte) i30;
        bArr2[57] = (byte) (i30 >>> 8);
        bArr2[58] = (byte) (i30 >>> 16);
        bArr2[59] = (byte) ((i30 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i31 = zzbzVar.zzjn;
        bArr2[60] = (byte) i31;
        bArr2[61] = (byte) (i31 >>> 8);
        bArr2[62] = (byte) (i31 >>> 16);
        bArr2[63] = (byte) ((i31 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i32 = zzbzVar.zznk;
        bArr2[64] = (byte) i32;
        bArr2[65] = (byte) (i32 >>> 8);
        bArr2[66] = (byte) (i32 >>> 16);
        bArr2[67] = (byte) ((i32 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i33 = zzbzVar.zznb;
        bArr2[68] = (byte) i33;
        bArr2[69] = (byte) (i33 >>> 8);
        bArr2[70] = (byte) (i33 >>> 16);
        bArr2[71] = (byte) ((i33 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i34 = zzbzVar.zzlo;
        bArr2[72] = (byte) i34;
        bArr2[73] = (byte) (i34 >>> 8);
        bArr2[74] = (byte) (i34 >>> 16);
        bArr2[75] = (byte) ((i34 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i35 = zzbzVar.zzna;
        bArr2[76] = (byte) i35;
        bArr2[77] = (byte) (i35 >>> 8);
        bArr2[78] = (byte) (i35 >>> 16);
        bArr2[79] = (byte) ((i35 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i36 = zzbzVar.zzju;
        bArr2[80] = (byte) i36;
        bArr2[81] = (byte) (i36 >>> 8);
        bArr2[82] = (byte) (i36 >>> 16);
        bArr2[83] = (byte) ((i36 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i37 = zzbzVar.zzjt;
        bArr2[84] = (byte) i37;
        bArr2[85] = (byte) (i37 >>> 8);
        bArr2[86] = (byte) (i37 >>> 16);
        bArr2[87] = (byte) ((i37 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i38 = zzbzVar.zzjw;
        bArr2[88] = (byte) i38;
        bArr2[89] = (byte) (i38 >>> 8);
        bArr2[90] = (byte) (i38 >>> 16);
        bArr2[91] = (byte) ((i38 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i39 = zzbzVar.zzjv;
        bArr2[92] = (byte) i39;
        bArr2[93] = (byte) (i39 >>> 8);
        bArr2[94] = (byte) (i39 >>> 16);
        bArr2[95] = (byte) ((i39 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i40 = zzbzVar.zzod;
        bArr2[96] = (byte) i40;
        bArr2[97] = (byte) (i40 >>> 8);
        bArr2[98] = (byte) (i40 >>> 16);
        bArr2[99] = (byte) ((i40 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i41 = zzbzVar.zzom;
        bArr2[100] = (byte) i41;
        bArr2[101] = (byte) (i41 >>> 8);
        bArr2[102] = (byte) (i41 >>> 16);
        bArr2[103] = (byte) ((i41 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i42 = zzbzVar.zzme;
        bArr2[104] = (byte) i42;
        bArr2[105] = (byte) (i42 >>> 8);
        bArr2[106] = (byte) (i42 >>> 16);
        bArr2[107] = (byte) ((i42 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i43 = zzbzVar.zzjz;
        bArr2[108] = (byte) i43;
        bArr2[109] = (byte) (i43 >>> 8);
        bArr2[110] = (byte) (i43 >>> 16);
        bArr2[111] = (byte) ((i43 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i44 = zzbzVar.zzkc;
        bArr2[112] = (byte) i44;
        bArr2[113] = (byte) (i44 >>> 8);
        bArr2[114] = (byte) (i44 >>> 16);
        bArr2[115] = (byte) ((i44 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i45 = zzbzVar.zzkt;
        bArr2[116] = (byte) i45;
        bArr2[117] = (byte) (i45 >>> 8);
        bArr2[118] = (byte) (i45 >>> 16);
        bArr2[119] = (byte) ((i45 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i46 = zzbzVar.zzog;
        bArr2[120] = (byte) i46;
        bArr2[121] = (byte) (i46 >>> 8);
        bArr2[122] = (byte) (i46 >>> 16);
        bArr2[123] = (byte) ((i46 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i47 = zzbzVar.zzng;
        bArr2[124] = (byte) i47;
        bArr2[125] = (byte) (i47 >>> 8);
        bArr2[126] = (byte) (i47 >>> 16);
        bArr2[127] = (byte) ((i47 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i48 = zzbzVar.zznh;
        bArr2[128] = (byte) i48;
        bArr2[129] = (byte) (i48 >>> 8);
        bArr2[130] = (byte) (i48 >>> 16);
        bArr2[131] = (byte) ((i48 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i49 = zzbzVar.zzkf;
        bArr2[132] = (byte) i49;
        bArr2[133] = (byte) (i49 >>> 8);
        bArr2[134] = (byte) (i49 >>> 16);
        bArr2[135] = (byte) ((i49 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i50 = zzbzVar.zzms;
        bArr2[136] = (byte) i50;
        bArr2[137] = (byte) (i50 >>> 8);
        bArr2[138] = (byte) (i50 >>> 16);
        bArr2[139] = (byte) ((i50 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i51 = zzbzVar.zzpl;
        bArr2[140] = (byte) i51;
        bArr2[141] = (byte) (i51 >>> 8);
        bArr2[142] = (byte) (i51 >>> 16);
        bArr2[143] = (byte) ((i51 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i52 = zzbzVar.zzkk;
        bArr2[144] = (byte) i52;
        bArr2[145] = (byte) (i52 >>> 8);
        bArr2[146] = (byte) (i52 >>> 16);
        bArr2[147] = (byte) ((i52 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i53 = zzbzVar.zzpk;
        bArr2[148] = (byte) i53;
        bArr2[149] = (byte) (i53 >>> 8);
        bArr2[150] = (byte) (i53 >>> 16);
        bArr2[151] = (byte) ((i53 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i54 = zzbzVar.zzoq;
        bArr2[152] = (byte) i54;
        bArr2[153] = (byte) (i54 >>> 8);
        bArr2[154] = (byte) (i54 >>> 16);
        bArr2[155] = (byte) ((i54 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i55 = zzbzVar.zzkw;
        bArr2[156] = (byte) i55;
        bArr2[157] = (byte) (i55 >>> 8);
        bArr2[158] = (byte) (i55 >>> 16);
        bArr2[159] = (byte) ((i55 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i56 = zzbzVar.zzko;
        bArr2[160] = (byte) i56;
        bArr2[161] = (byte) (i56 >>> 8);
        bArr2[162] = (byte) (i56 >>> 16);
        bArr2[163] = (byte) ((i56 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i57 = zzbzVar.zzjh;
        bArr2[164] = (byte) i57;
        bArr2[165] = (byte) (i57 >>> 8);
        bArr2[166] = (byte) (i57 >>> 16);
        bArr2[167] = (byte) ((i57 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i58 = zzbzVar.zzld;
        bArr2[168] = (byte) i58;
        bArr2[169] = (byte) (i58 >>> 8);
        bArr2[170] = (byte) (i58 >>> 16);
        bArr2[171] = (byte) ((i58 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i59 = zzbzVar.zzkz;
        bArr2[172] = (byte) i59;
        bArr2[173] = (byte) (i59 >>> 8);
        bArr2[174] = (byte) (i59 >>> 16);
        bArr2[175] = (byte) ((i59 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i60 = zzbzVar.zzks;
        bArr2[176] = (byte) i60;
        bArr2[177] = (byte) (i60 >>> 8);
        bArr2[178] = (byte) (i60 >>> 16);
        bArr2[179] = (byte) ((i60 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        bArr2[180] = (byte) i2;
        bArr2[181] = (byte) (i2 >>> 8);
        bArr2[182] = (byte) (i2 >>> 16);
        bArr2[183] = (byte) ((i2 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i61 = zzbzVar.zzku;
        bArr2[184] = (byte) i61;
        bArr2[185] = (byte) (i61 >>> 8);
        bArr2[186] = (byte) (i61 >>> 16);
        bArr2[187] = (byte) ((i61 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i62 = zzbzVar.zzlr;
        bArr2[188] = (byte) i62;
        bArr2[189] = (byte) (i62 >>> 8);
        bArr2[190] = (byte) (i62 >>> 16);
        bArr2[191] = (byte) ((i62 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i63 = zzbzVar.zzjk;
        bArr2[192] = (byte) i63;
        bArr2[193] = (byte) (i63 >>> 8);
        bArr2[194] = (byte) (i63 >>> 16);
        bArr2[195] = (byte) ((i63 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i64 = zzbzVar.zzmi;
        bArr2[196] = (byte) i64;
        bArr2[197] = (byte) (i64 >>> 8);
        bArr2[198] = (byte) (i64 >>> 16);
        bArr2[199] = (byte) ((i64 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i65 = zzbzVar.zzky;
        bArr2[200] = (byte) i65;
        bArr2[201] = (byte) (i65 >>> 8);
        bArr2[202] = (byte) (i65 >>> 16);
        bArr2[203] = (byte) ((i65 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i66 = zzbzVar.zzmc;
        bArr2[204] = (byte) i66;
        bArr2[205] = (byte) (i66 >>> 8);
        bArr2[206] = (byte) (i66 >>> 16);
        bArr2[207] = (byte) ((i66 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i67 = zzbzVar.zzla;
        bArr2[208] = (byte) i67;
        bArr2[209] = (byte) (i67 >>> 8);
        bArr2[210] = (byte) (i67 >>> 16);
        bArr2[211] = (byte) ((i67 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        bArr2[212] = (byte) i7;
        bArr2[213] = (byte) (i7 >>> 8);
        bArr2[214] = (byte) (i7 >>> 16);
        bArr2[215] = (byte) ((i7 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i68 = zzbzVar.zzlc;
        bArr2[216] = (byte) i68;
        bArr2[217] = (byte) (i68 >>> 8);
        bArr2[218] = (byte) (i68 >>> 16);
        bArr2[219] = (byte) ((i68 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i69 = zzbzVar.zzkr;
        bArr2[220] = (byte) i69;
        bArr2[221] = (byte) (i69 >>> 8);
        bArr2[222] = (byte) (i69 >>> 16);
        bArr2[223] = (byte) ((i69 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i70 = zzbzVar.zzpe;
        bArr2[224] = (byte) i70;
        bArr2[225] = (byte) (i70 >>> 8);
        bArr2[226] = (byte) (i70 >>> 16);
        bArr2[227] = (byte) ((i70 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i71 = zzbzVar.zzoe;
        bArr2[228] = (byte) i71;
        bArr2[229] = (byte) (i71 >>> 8);
        bArr2[230] = (byte) (i71 >>> 16);
        bArr2[231] = (byte) ((i71 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i72 = zzbzVar.zznq;
        bArr2[232] = (byte) i72;
        bArr2[233] = (byte) (i72 >>> 8);
        bArr2[234] = (byte) (i72 >>> 16);
        bArr2[235] = (byte) ((i72 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i73 = zzbzVar.zzpr;
        bArr2[236] = (byte) i73;
        bArr2[237] = (byte) (i73 >>> 8);
        bArr2[238] = (byte) (i73 >>> 16);
        bArr2[239] = (byte) ((i73 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i74 = zzbzVar.zzpa;
        bArr2[240] = (byte) i74;
        bArr2[241] = (byte) (i74 >>> 8);
        bArr2[242] = (byte) (i74 >>> 16);
        bArr2[243] = (byte) ((i74 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i75 = zzbzVar.zzmd;
        bArr2[244] = (byte) i75;
        bArr2[245] = (byte) (i75 >>> 8);
        bArr2[246] = (byte) (i75 >>> 16);
        bArr2[247] = (byte) ((i75 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i76 = zzbzVar.zzlk;
        bArr2[248] = (byte) i76;
        bArr2[249] = (byte) (i76 >>> 8);
        bArr2[250] = (byte) (i76 >>> 16);
        bArr2[251] = (byte) ((i76 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
        int i77 = zzbzVar.zzmj;
        bArr2[252] = (byte) i77;
        bArr2[253] = (byte) (i77 >>> 8);
        bArr2[254] = (byte) (i77 >>> 16);
        bArr2[255] = (byte) ((i77 & ViewCompat.MEASURED_STATE_MASK) >>> 24);
    }

    public /* synthetic */ C1085sj(zzbz zzbzVar, C1016nj c1016nj) {
        this(zzbzVar);
    }
}