package com.nexstreaming.kinemaster.mediainfo;

import android.util.SparseArray;

/* loaded from: classes.dex */
public class CodecType {

    /* renamed from: a, reason: collision with root package name */
    public final String f3481a;
    public final CodecGroup b;
    public final int c;
    private static SparseArray<CodecType> cS = new SparseArray<>();
    public static CodecType d = new CodecType("UNKNOWN", 0);
    public static CodecType e = new CodecType("V_BEGINE", 268435456);
    public static CodecType f = new CodecType("V_H261", 268501248);
    public static CodecType g = new CodecType("V_H263", 268501504);
    public static CodecType h = new CodecType("V_H264", 268501760);
    public static CodecType i = new CodecType("V_HEVC", 268502016);
    public static CodecType j = new CodecType("V_MPEG4V", 268566784);
    public static CodecType k = new CodecType("V_MPEG1V", 268567040);
    public static CodecType l = new CodecType("V_MPEG2V", 268567296);
    public static CodecType m = new CodecType("V_MSMPEG4V1", 268632320);
    public static CodecType n = new CodecType("V_MSMPEG4V2", 268632576);
    public static CodecType o = new CodecType("V_MSMPEG4V3", 268632832);
    public static CodecType p = new CodecType("V_DIVX", 268697600);
    public static CodecType q = new CodecType("V_XVID", 268763136);
    public static CodecType r = new CodecType("V_WMV", 268828672);
    public static CodecType s = new CodecType("V_WMV1", 268828928);
    public static CodecType t = new CodecType("V_WMV2", 268829184);
    public static CodecType u = new CodecType("V_WMV3", 268829440);
    public static CodecType v = new CodecType("V_WVC1", 268829696);
    public static CodecType w = new CodecType("V_MSRLE", 268894208);
    public static CodecType x = new CodecType("V_MSVIDEO1", 268959744);
    public static CodecType y = new CodecType("V_DVVIDEO", 269025280);
    public static CodecType z = new CodecType("V_INDEO", 269090816);
    public static CodecType A = new CodecType("V_INDEO2", 269091072);
    public static CodecType B = new CodecType("V_INDEO3", 269091328);
    public static CodecType C = new CodecType("V_INDEO4", 269091584);
    public static CodecType D = new CodecType("V_INDEO5", 269091840);
    public static CodecType E = new CodecType("V_VP", 269156352);
    public static CodecType F = new CodecType("V_VP3", 269156608);
    public static CodecType G = new CodecType("V_VP5", 269156864);
    public static CodecType H = new CodecType("V_VP6", 269157121);
    public static CodecType I = new CodecType("V_VP6A", 269157122);
    public static CodecType J = new CodecType("V_VP6F", 269157123);
    public static CodecType K = new CodecType("V_VP7", 269157376);
    public static CodecType L = new CodecType("V_VP8", 269157632);
    public static CodecType M = new CodecType("V_VP9", 269157888);
    public static CodecType N = new CodecType("V_REALV", 269221888);
    public static CodecType O = new CodecType("V_REALV01", 269222144);
    public static CodecType P = new CodecType("V_REALV10", 269222400);
    public static CodecType Q = new CodecType("V_REALV13", 269222656);
    public static CodecType R = new CodecType("V_REALV20", 269222912);
    public static CodecType S = new CodecType("V_REALV30", 269223168);
    public static CodecType T = new CodecType("V_REALV40", 269223424);
    public static CodecType U = new CodecType("V_FLV", 269287424);
    public static CodecType V = new CodecType("V_FLV1", 269287680);
    public static CodecType W = new CodecType("V_FLV4", 269287936);
    public static CodecType X = new CodecType("V_FLASHSV", 269353216);
    public static CodecType Y = new CodecType("V_RAWV", 269418752);
    public static CodecType Z = new CodecType("V_ASV1", 269484288);
    public static CodecType aa = new CodecType("V_ASV2", 269484544);
    public static CodecType ab = new CodecType("V_QPEG", 269549824);
    public static CodecType ac = new CodecType("V_TRUEMOTION1", 269615360);
    public static CodecType ad = new CodecType("V_TRUEMOTION2", 269615616);
    public static CodecType ae = new CodecType("V_VCR1", 269680896);
    public static CodecType af = new CodecType("V_FFV1", 269746432);
    public static CodecType ag = new CodecType("V_XXAN", 269811968);
    public static CodecType ah = new CodecType("V_CINEPAK", 269877504);
    public static CodecType ai = new CodecType("V_MSZH", 269943040);
    public static CodecType aj = new CodecType("V_ZLIB", 270008576);
    public static CodecType ak = new CodecType("V_SNOW", 270074112);
    public static CodecType al = new CodecType("V_4XM", 270139648);
    public static CodecType am = new CodecType("V_SVQ1", 270205184);
    public static CodecType an = new CodecType("V_TSCC", 270270720);
    public static CodecType ao = new CodecType("V_ULTI", 270336256);
    public static CodecType ap = new CodecType("V_LOCO", 270401792);
    public static CodecType aq = new CodecType("V_WNV1", 270467328);
    public static CodecType ar = new CodecType("V_AASC", 270532864);
    public static CodecType as = new CodecType("V_FRAPS", 270598400);
    public static CodecType at = new CodecType("V_THEORA", 270663936);
    public static CodecType au = new CodecType("V_CSCD", 270729472);
    public static CodecType av = new CodecType("V_ZMBV", 270795008);
    public static CodecType aw = new CodecType("V_KMVC", 270860544);
    public static CodecType ax = new CodecType("V_CAVS", 270926080);
    public static CodecType ay = new CodecType("V_VMNC", 270991616);
    public static CodecType az = new CodecType("V_SORENSONH263", 271057152);
    public static CodecType aA = new CodecType("V_SCRREENVIDEO", 271122688);
    public static CodecType aB = new CodecType("V_SCREEMVODEPV2", 271188224);
    public static CodecType aC = new CodecType("V_QT", 271253760);
    public static CodecType aD = new CodecType("V_JPEG", 271319296);
    public static CodecType aE = new CodecType("V_JPEG2000", 271319552);
    public static CodecType aF = new CodecType("V_MJPEG", 271319808);
    public static CodecType aG = new CodecType("V_STILL_IMG", 271320064);
    public static CodecType aH = new CodecType("V_RGB24", 271384832);
    public static CodecType aI = new CodecType("V_END", 536870911);
    public static CodecType aJ = new CodecType("A_BEGINE", 536870912);
    public static CodecType aK = new CodecType("A_MPEGAUDIO", 536936448);
    public static CodecType aL = new CodecType("A_MP2", 536936704);
    public static CodecType aM = new CodecType("A_MP3", 536936960);
    public static CodecType aN = new CodecType("A_MP4A", 536937216);
    public static CodecType aO = new CodecType("A_AAC", 537001984);
    public static CodecType aP = new CodecType("A_AACPLUS", 537002240);
    public static CodecType aQ = new CodecType("A_AACPLUSV2", 537002241);
    public static CodecType aR = new CodecType("A_ELDAAC", 537002496);
    public static CodecType aS = new CodecType("A_AC3", 537067520);
    public static CodecType aT = new CodecType("A_EAC3", 537067776);
    public static CodecType aU = new CodecType("A_DTS", 537133056);
    public static CodecType aV = new CodecType("A_DTS_DTSC", 537133312);
    public static CodecType aW = new CodecType("A_DTS_DTSH", 537133568);
    public static CodecType aX = new CodecType("A_DTS_DTSE", 537133824);
    public static CodecType aY = new CodecType("A_DTS_DTSL", 537134080);
    public static CodecType aZ = new CodecType("A_PCM", 537198592);
    public static CodecType ba = new CodecType("A_PCM_S16LE", 537198848);
    public static CodecType bb = new CodecType("A_PCM_S16BE", 537199104);
    public static CodecType bc = new CodecType("A_PCM_RAW", 537199360);
    public static CodecType bd = new CodecType("A_PCM_FL32LE", 537199616);
    public static CodecType be = new CodecType("A_PCM_FL32BE", 537199617);
    public static CodecType bf = new CodecType("A_PCM_FL64LE", 537199872);
    public static CodecType bg = new CodecType("A_PCM_FL64BE", 537199873);
    public static CodecType bh = new CodecType("A_PCM_IN24LE", 537200128);
    public static CodecType bi = new CodecType("A_PCM_IN24BE", 537200129);
    public static CodecType bj = new CodecType("A_PCM_IN32LE", 537200384);
    public static CodecType bk = new CodecType("A_PCM_IN32BE", 537200385);
    public static CodecType bl = new CodecType("A_ADPCM_MS", 537264384);
    public static CodecType bm = new CodecType("A_ADPCM_IMA_WAV", 537264641);
    public static CodecType bn = new CodecType("A_ADPCM_IMA_DK4", 537264642);
    public static CodecType bo = new CodecType("A_ADPCM_IMA_DK3", 537264643);
    public static CodecType bp = new CodecType("A_ADPCM_IMA4", 537264644);
    public static CodecType bq = new CodecType("A_ADPCM_YAMAHA", 537264896);
    public static CodecType br = new CodecType("A_ADPCM_G726", 537265152);
    public static CodecType bs = new CodecType("A_ADPCM_CT", 537265408);
    public static CodecType bt = new CodecType("A_ADPCM_SWF", 537265664);
    public static CodecType bu = new CodecType("A_WMA", 537329664);
    public static CodecType bv = new CodecType("A_WMA1", 537329920);
    public static CodecType bw = new CodecType("A_WMA2", 537330176);
    public static CodecType bx = new CodecType("A_WMA3", 537330432);
    public static CodecType by = new CodecType("A_WMA_LOSSLESS", 537330688);
    public static CodecType bz = new CodecType("A_WMA_SPEECH", 537330944);
    public static CodecType bA = new CodecType("A_WMASPDIF", 537331200);
    public static CodecType bB = new CodecType("A_VORBIS", 537395456);
    public static CodecType bC = new CodecType("A_SONIC", 537460992);
    public static CodecType bD = new CodecType("A_TRUESPEECH", 537526528);
    public static CodecType bE = new CodecType("A_FLAC", 537592064);
    public static CodecType bF = new CodecType("A_APE", 537657600);
    public static CodecType bG = new CodecType("A_IMC", 537723136);
    public static CodecType bH = new CodecType("A_REALA", 537788416);
    public static CodecType bI = new CodecType("A_REAL14_4", 537788672);
    public static CodecType bJ = new CodecType("A_REAL28_8", 537788928);
    public static CodecType bK = new CodecType("A_ATRC", 537854208);
    public static CodecType bL = new CodecType("A_COOK", 537919744);
    public static CodecType bM = new CodecType("A_DNET", 537985280);
    public static CodecType bN = new CodecType("A_SIPR", 538050816);
    public static CodecType bO = new CodecType("A_RAAC", 538116352);
    public static CodecType bP = new CodecType("A_RACP", 538181888);
    public static CodecType bQ = new CodecType("A_ADUU", 538247424);
    public static CodecType bR = new CodecType("A_QDMC", 538312960);
    public static CodecType bS = new CodecType("A_QDMC2", 538313216);
    public static CodecType bT = new CodecType("A_FLV_ID_3", 538378496);
    public static CodecType bU = new CodecType("A_FLV_ID_4", 538378752);
    public static CodecType bV = new CodecType("A_FLV_ID_5", 538379008);
    public static CodecType bW = new CodecType("A_FLV_ID_6", 538379264);
    public static CodecType bX = new CodecType("A_FLV_ID_7", 538379520);
    public static CodecType bY = new CodecType("A_FLV_ID_8", 538379776);
    public static CodecType bZ = new CodecType("A_FLV_ID_11", 538380032);
    public static CodecType ca = new CodecType("A_FLV_ID_14", 538380288);
    public static CodecType cb = new CodecType("A_AMR", 538443776);
    public static CodecType cc = new CodecType("A_AMRWB", 538444032);
    public static CodecType cd = new CodecType("A_EAMRWB", 538444288);
    public static CodecType ce = new CodecType("A_SMV", 538509568);
    public static CodecType cf = new CodecType("A_QCELP", 538574848);
    public static CodecType cg = new CodecType("A_QCELP_ALT", 538575104);
    public static CodecType ch = new CodecType("A_EVRC", 538640640);
    public static CodecType ci = new CodecType("A_G711", 538705920);
    public static CodecType cj = new CodecType("A_G711_ALAW", 538706176);
    public static CodecType ck = new CodecType("A_G711_MULAW", 538706432);
    public static CodecType cl = new CodecType("A_G723", 538771712);
    public static CodecType cm = new CodecType("A_BSAC", 538837248);
    public static CodecType cn = new CodecType("A_ALAC", 538902784);
    public static CodecType co = new CodecType("A_GSM610", 538968320);
    public static CodecType cp = new CodecType("A_BLURAYPCM", 539033856);
    public static CodecType cq = new CodecType("A_DRA", 539099392);
    public static CodecType cr = new CodecType("A_END", 805306367);
    public static CodecType cs = new CodecType("T_BEGINE", 805306368);
    public static CodecType ct = new CodecType("T_3GPP", 805372160);
    public static CodecType cu = new CodecType("T_SKT", 805437696);
    public static CodecType cv = new CodecType("T_SMI", 805503232);
    public static CodecType cw = new CodecType("T_SRT", 805568768);
    public static CodecType cx = new CodecType("T_ID3_UNSYNC_LYRIC", 805634304);
    public static CodecType cy = new CodecType("T_ID3_SYNC_LYRIC", 805634560);
    public static CodecType cz = new CodecType("T_VOB_SUB", 805699840);
    public static CodecType cA = new CodecType("T_MICRODVD_SUB", 805765376);
    public static CodecType cB = new CodecType("T_LRC", 805830912);
    public static CodecType cC = new CodecType("T_SSA", 805896448);
    public static CodecType cD = new CodecType("T_SYLT", 805961984);
    public static CodecType cE = new CodecType("T_TTML", 806027520);
    public static CodecType cF = new CodecType("T_TT", 806027776);
    public static CodecType cG = new CodecType("T_WEB_VTT", 806093056);
    public static CodecType cH = new CodecType("T_CC_CEA", 806158592);
    public static CodecType cI = new CodecType("T_CC_CEA_608", 806158848);
    public static CodecType cJ = new CodecType("T_CC_CEA_708", 806159104);
    public static CodecType cK = new CodecType("T_DIVX_XSUB", 806223872);
    public static CodecType cL = new CodecType("T_DIVX_XSUBPLUS", 806224128);
    public static CodecType cM = new CodecType("T_UTF", 806289408);
    public static CodecType cN = new CodecType("T_UTF8", 806289664);
    public static CodecType cO = new CodecType("T_UTF16", 806289920);
    public static CodecType cP = new CodecType("T_UTF32", 806290176);
    public static CodecType cQ = new CodecType("T_TIMEDMETA", 806354944);
    public static CodecType cR = new CodecType("T_END", 1073741823);

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
                this.b = CodecGroup.Video;
                this.f3481a = str.substring(2);
            } else if (str.charAt(0) == 'A') {
                this.b = CodecGroup.Audio;
                this.f3481a = str.substring(2);
            } else if (str.charAt(0) == 'T') {
                this.b = CodecGroup.Text;
                this.f3481a = str.substring(2);
            } else {
                this.b = CodecGroup.Unknown;
                this.f3481a = str;
            }
        } else {
            this.b = CodecGroup.Unknown;
            this.f3481a = str;
        }
        this.c = i2;
        if (cS.get(i2) != null) {
            throw new IllegalStateException();
        }
        cS.put(i2, this);
    }

    public static CodecType a(int i2) {
        CodecType codecType = cS.get(i2);
        if (codecType == null) {
            CodecType codecType2 = new CodecType("UNKNOWN_CODEC_" + i2, i2);
            cS.put(i2, codecType2);
            return codecType2;
        }
        return codecType;
    }
}
