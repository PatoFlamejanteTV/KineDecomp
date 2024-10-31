package com.nexstreaming.kinemaster.mediainfo;

import android.util.SparseArray;

/* loaded from: classes.dex */
public class CodecType {
    public final String Oc;
    public final CodecGroup Pc;
    public final int Qc;

    /* renamed from: a */
    private static SparseArray<CodecType> f20654a = new SparseArray<>();

    /* renamed from: b */
    public static CodecType f20655b = new CodecType("UNKNOWN", 0);

    /* renamed from: c */
    public static CodecType f20656c = new CodecType("V_BEGINE", 268435456);

    /* renamed from: d */
    public static CodecType f20657d = new CodecType("V_H261", 268501248);

    /* renamed from: e */
    public static CodecType f20658e = new CodecType("V_H263", 268501504);

    /* renamed from: f */
    public static CodecType f20659f = new CodecType("V_H264", 268501760);

    /* renamed from: g */
    public static CodecType f20660g = new CodecType("V_HEVC", 268502016);

    /* renamed from: h */
    public static CodecType f20661h = new CodecType("V_MPEG4V", 268566784);
    public static CodecType i = new CodecType("V_MPEG1V", 268567040);
    public static CodecType j = new CodecType("V_MPEG2V", 268567296);
    public static CodecType k = new CodecType("V_MSMPEG4V1", 268632320);
    public static CodecType l = new CodecType("V_MSMPEG4V2", 268632576);
    public static CodecType m = new CodecType("V_MSMPEG4V3", 268632832);
    public static CodecType n = new CodecType("V_DIVX", 268697600);
    public static CodecType o = new CodecType("V_XVID", 268763136);
    public static CodecType p = new CodecType("V_WMV", 268828672);
    public static CodecType q = new CodecType("V_WMV1", 268828928);
    public static CodecType r = new CodecType("V_WMV2", 268829184);
    public static CodecType s = new CodecType("V_WMV3", 268829440);
    public static CodecType t = new CodecType("V_WVC1", 268829696);
    public static CodecType u = new CodecType("V_MSRLE", 268894208);
    public static CodecType v = new CodecType("V_MSVIDEO1", 268959744);
    public static CodecType w = new CodecType("V_DVVIDEO", 269025280);
    public static CodecType x = new CodecType("V_INDEO", 269090816);
    public static CodecType y = new CodecType("V_INDEO2", 269091072);
    public static CodecType z = new CodecType("V_INDEO3", 269091328);
    public static CodecType A = new CodecType("V_INDEO4", 269091584);
    public static CodecType B = new CodecType("V_INDEO5", 269091840);
    public static CodecType C = new CodecType("V_VP", 269156352);
    public static CodecType D = new CodecType("V_VP3", 269156608);
    public static CodecType E = new CodecType("V_VP5", 269156864);
    public static CodecType F = new CodecType("V_VP6", 269157121);
    public static CodecType G = new CodecType("V_VP6A", 269157122);
    public static CodecType H = new CodecType("V_VP6F", 269157123);
    public static CodecType I = new CodecType("V_VP7", 269157376);
    public static CodecType J = new CodecType("V_VP8", 269157632);
    public static CodecType K = new CodecType("V_VP9", 269157888);
    public static CodecType L = new CodecType("V_REALV", 269221888);
    public static CodecType M = new CodecType("V_REALV01", 269222144);
    public static CodecType N = new CodecType("V_REALV10", 269222400);
    public static CodecType O = new CodecType("V_REALV13", 269222656);
    public static CodecType P = new CodecType("V_REALV20", 269222912);
    public static CodecType Q = new CodecType("V_REALV30", 269223168);
    public static CodecType R = new CodecType("V_REALV40", 269223424);
    public static CodecType S = new CodecType("V_FLV", 269287424);
    public static CodecType T = new CodecType("V_FLV1", 269287680);
    public static CodecType U = new CodecType("V_FLV4", 269287936);
    public static CodecType V = new CodecType("V_FLASHSV", 269353216);
    public static CodecType W = new CodecType("V_RAWV", 269418752);
    public static CodecType X = new CodecType("V_ASV1", 269484288);
    public static CodecType Y = new CodecType("V_ASV2", 269484544);
    public static CodecType Z = new CodecType("V_QPEG", 269549824);
    public static CodecType aa = new CodecType("V_TRUEMOTION1", 269615360);
    public static CodecType ba = new CodecType("V_TRUEMOTION2", 269615616);
    public static CodecType ca = new CodecType("V_VCR1", 269680896);
    public static CodecType da = new CodecType("V_FFV1", 269746432);
    public static CodecType ea = new CodecType("V_XXAN", 269811968);
    public static CodecType fa = new CodecType("V_CINEPAK", 269877504);
    public static CodecType ga = new CodecType("V_MSZH", 269943040);
    public static CodecType ha = new CodecType("V_ZLIB", 270008576);
    public static CodecType ia = new CodecType("V_SNOW", 270074112);
    public static CodecType ja = new CodecType("V_4XM", 270139648);
    public static CodecType ka = new CodecType("V_SVQ1", 270205184);
    public static CodecType la = new CodecType("V_TSCC", 270270720);
    public static CodecType ma = new CodecType("V_ULTI", 270336256);
    public static CodecType na = new CodecType("V_LOCO", 270401792);
    public static CodecType oa = new CodecType("V_WNV1", 270467328);
    public static CodecType pa = new CodecType("V_AASC", 270532864);
    public static CodecType qa = new CodecType("V_FRAPS", 270598400);
    public static CodecType ra = new CodecType("V_THEORA", 270663936);
    public static CodecType sa = new CodecType("V_CSCD", 270729472);
    public static CodecType ta = new CodecType("V_ZMBV", 270795008);
    public static CodecType ua = new CodecType("V_KMVC", 270860544);
    public static CodecType va = new CodecType("V_CAVS", 270926080);
    public static CodecType wa = new CodecType("V_VMNC", 270991616);
    public static CodecType xa = new CodecType("V_SORENSONH263", 271057152);
    public static CodecType ya = new CodecType("V_SCRREENVIDEO", 271122688);
    public static CodecType za = new CodecType("V_SCREEMVODEPV2", 271188224);
    public static CodecType Aa = new CodecType("V_QT", 271253760);
    public static CodecType Ba = new CodecType("V_JPEG", 271319296);
    public static CodecType Ca = new CodecType("V_JPEG2000", 271319552);
    public static CodecType Da = new CodecType("V_MJPEG", 271319808);
    public static CodecType Ea = new CodecType("V_STILL_IMG", 271320064);
    public static CodecType Fa = new CodecType("V_RGB24", 271384832);
    public static CodecType Ga = new CodecType("V_END", 536870911);
    public static CodecType Ha = new CodecType("A_BEGINE", 536870912);
    public static CodecType Ia = new CodecType("A_MPEGAUDIO", 536936448);
    public static CodecType Ja = new CodecType("A_MP2", 536936704);
    public static CodecType Ka = new CodecType("A_MP3", 536936960);
    public static CodecType La = new CodecType("A_MP4A", 536937216);
    public static CodecType Ma = new CodecType("A_AAC", 537001984);
    public static CodecType Na = new CodecType("A_AACPLUS", 537002240);
    public static CodecType Oa = new CodecType("A_AACPLUSV2", 537002241);
    public static CodecType Pa = new CodecType("A_ELDAAC", 537002496);
    public static CodecType Qa = new CodecType("A_AC3", 537067520);
    public static CodecType Ra = new CodecType("A_EAC3", 537067776);
    public static CodecType Sa = new CodecType("A_DTS", 537133056);
    public static CodecType Ta = new CodecType("A_DTS_DTSC", 537133312);
    public static CodecType Ua = new CodecType("A_DTS_DTSH", 537133568);
    public static CodecType Va = new CodecType("A_DTS_DTSE", 537133824);
    public static CodecType Wa = new CodecType("A_DTS_DTSL", 537134080);
    public static CodecType Xa = new CodecType("A_PCM", 537198592);
    public static CodecType Ya = new CodecType("A_PCM_S16LE", 537198848);
    public static CodecType Za = new CodecType("A_PCM_S16BE", 537199104);
    public static CodecType _a = new CodecType("A_PCM_RAW", 537199360);
    public static CodecType ab = new CodecType("A_PCM_FL32LE", 537199616);
    public static CodecType bb = new CodecType("A_PCM_FL32BE", 537199617);
    public static CodecType cb = new CodecType("A_PCM_FL64LE", 537199872);
    public static CodecType db = new CodecType("A_PCM_FL64BE", 537199873);
    public static CodecType eb = new CodecType("A_PCM_IN24LE", 537200128);
    public static CodecType fb = new CodecType("A_PCM_IN24BE", 537200129);
    public static CodecType gb = new CodecType("A_PCM_IN32LE", 537200384);
    public static CodecType hb = new CodecType("A_PCM_IN32BE", 537200385);
    public static CodecType ib = new CodecType("A_ADPCM_MS", 537264384);
    public static CodecType jb = new CodecType("A_ADPCM_IMA_WAV", 537264641);
    public static CodecType kb = new CodecType("A_ADPCM_IMA_DK4", 537264642);
    public static CodecType lb = new CodecType("A_ADPCM_IMA_DK3", 537264643);
    public static CodecType mb = new CodecType("A_ADPCM_IMA4", 537264644);
    public static CodecType nb = new CodecType("A_ADPCM_YAMAHA", 537264896);
    public static CodecType ob = new CodecType("A_ADPCM_G726", 537265152);
    public static CodecType pb = new CodecType("A_ADPCM_CT", 537265408);
    public static CodecType qb = new CodecType("A_ADPCM_SWF", 537265664);
    public static CodecType rb = new CodecType("A_WMA", 537329664);
    public static CodecType sb = new CodecType("A_WMA1", 537329920);
    public static CodecType tb = new CodecType("A_WMA2", 537330176);
    public static CodecType ub = new CodecType("A_WMA3", 537330432);
    public static CodecType vb = new CodecType("A_WMA_LOSSLESS", 537330688);
    public static CodecType wb = new CodecType("A_WMA_SPEECH", 537330944);
    public static CodecType xb = new CodecType("A_WMASPDIF", 537331200);
    public static CodecType yb = new CodecType("A_VORBIS", 537395456);
    public static CodecType zb = new CodecType("A_SONIC", 537460992);
    public static CodecType Ab = new CodecType("A_TRUESPEECH", 537526528);
    public static CodecType Bb = new CodecType("A_FLAC", 537592064);
    public static CodecType Cb = new CodecType("A_APE", 537657600);
    public static CodecType Db = new CodecType("A_IMC", 537723136);
    public static CodecType Eb = new CodecType("A_REALA", 537788416);
    public static CodecType Fb = new CodecType("A_REAL14_4", 537788672);
    public static CodecType Gb = new CodecType("A_REAL28_8", 537788928);
    public static CodecType Hb = new CodecType("A_ATRC", 537854208);
    public static CodecType Ib = new CodecType("A_COOK", 537919744);
    public static CodecType Jb = new CodecType("A_DNET", 537985280);
    public static CodecType Kb = new CodecType("A_SIPR", 538050816);
    public static CodecType Lb = new CodecType("A_RAAC", 538116352);
    public static CodecType Mb = new CodecType("A_RACP", 538181888);
    public static CodecType Nb = new CodecType("A_ADUU", 538247424);
    public static CodecType Ob = new CodecType("A_QDMC", 538312960);
    public static CodecType Pb = new CodecType("A_QDMC2", 538313216);
    public static CodecType Qb = new CodecType("A_FLV_ID_3", 538378496);
    public static CodecType Rb = new CodecType("A_FLV_ID_4", 538378752);
    public static CodecType Sb = new CodecType("A_FLV_ID_5", 538379008);
    public static CodecType Tb = new CodecType("A_FLV_ID_6", 538379264);
    public static CodecType Ub = new CodecType("A_FLV_ID_7", 538379520);
    public static CodecType Vb = new CodecType("A_FLV_ID_8", 538379776);
    public static CodecType Wb = new CodecType("A_FLV_ID_11", 538380032);
    public static CodecType Xb = new CodecType("A_FLV_ID_14", 538380288);
    public static CodecType Yb = new CodecType("A_AMR", 538443776);
    public static CodecType Zb = new CodecType("A_AMRWB", 538444032);
    public static CodecType _b = new CodecType("A_EAMRWB", 538444288);
    public static CodecType ac = new CodecType("A_SMV", 538509568);
    public static CodecType bc = new CodecType("A_QCELP", 538574848);
    public static CodecType cc = new CodecType("A_QCELP_ALT", 538575104);
    public static CodecType dc = new CodecType("A_EVRC", 538640640);
    public static CodecType ec = new CodecType("A_G711", 538705920);
    public static CodecType fc = new CodecType("A_G711_ALAW", 538706176);
    public static CodecType gc = new CodecType("A_G711_MULAW", 538706432);
    public static CodecType hc = new CodecType("A_G723", 538771712);
    public static CodecType ic = new CodecType("A_BSAC", 538837248);
    public static CodecType jc = new CodecType("A_ALAC", 538902784);
    public static CodecType kc = new CodecType("A_GSM610", 538968320);
    public static CodecType lc = new CodecType("A_BLURAYPCM", 539033856);
    public static CodecType mc = new CodecType("A_DRA", 539099392);
    public static CodecType nc = new CodecType("A_END", 805306367);
    public static CodecType oc = new CodecType("T_BEGINE", 805306368);
    public static CodecType pc = new CodecType("T_3GPP", 805372160);
    public static CodecType qc = new CodecType("T_SKT", 805437696);
    public static CodecType rc = new CodecType("T_SMI", 805503232);
    public static CodecType sc = new CodecType("T_SRT", 805568768);
    public static CodecType tc = new CodecType("T_ID3_UNSYNC_LYRIC", 805634304);
    public static CodecType uc = new CodecType("T_ID3_SYNC_LYRIC", 805634560);
    public static CodecType vc = new CodecType("T_VOB_SUB", 805699840);
    public static CodecType wc = new CodecType("T_MICRODVD_SUB", 805765376);
    public static CodecType xc = new CodecType("T_LRC", 805830912);
    public static CodecType yc = new CodecType("T_SSA", 805896448);
    public static CodecType zc = new CodecType("T_SYLT", 805961984);
    public static CodecType Ac = new CodecType("T_TTML", 806027520);
    public static CodecType Bc = new CodecType("T_TT", 806027776);
    public static CodecType Cc = new CodecType("T_WEB_VTT", 806093056);
    public static CodecType Dc = new CodecType("T_CC_CEA", 806158592);
    public static CodecType Ec = new CodecType("T_CC_CEA_608", 806158848);
    public static CodecType Fc = new CodecType("T_CC_CEA_708", 806159104);
    public static CodecType Gc = new CodecType("T_DIVX_XSUB", 806223872);
    public static CodecType Hc = new CodecType("T_DIVX_XSUBPLUS", 806224128);
    public static CodecType Ic = new CodecType("T_UTF", 806289408);
    public static CodecType Jc = new CodecType("T_UTF8", 806289664);
    public static CodecType Kc = new CodecType("T_UTF16", 806289920);
    public static CodecType Lc = new CodecType("T_UTF32", 806290176);
    public static CodecType Mc = new CodecType("T_TIMEDMETA", 806354944);
    public static CodecType Nc = new CodecType("T_END", 1073741823);

    /* loaded from: classes.dex */
    public enum CodecGroup {
        Video,
        Audio,
        Text,
        Unknown
    }

    private CodecType(String str, int i2) {
        if (str.charAt(1) == '_') {
            if (str.charAt(0) == 'V') {
                this.Pc = CodecGroup.Video;
                this.Oc = str.substring(2);
            } else if (str.charAt(0) == 'A') {
                this.Pc = CodecGroup.Audio;
                this.Oc = str.substring(2);
            } else if (str.charAt(0) == 'T') {
                this.Pc = CodecGroup.Text;
                this.Oc = str.substring(2);
            } else {
                this.Pc = CodecGroup.Unknown;
                this.Oc = str;
            }
        } else {
            this.Pc = CodecGroup.Unknown;
            this.Oc = str;
        }
        this.Qc = i2;
        if (f20654a.get(i2) == null) {
            f20654a.put(i2, this);
            return;
        }
        throw new IllegalStateException();
    }

    public static CodecType a(int i2) {
        CodecType codecType = f20654a.get(i2);
        if (codecType != null) {
            return codecType;
        }
        CodecType codecType2 = new CodecType("UNKNOWN_CODEC_" + i2, i2);
        f20654a.put(i2, codecType2);
        return codecType2;
    }
}
