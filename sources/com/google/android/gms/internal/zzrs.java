package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrt;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class zzrs {

    /* loaded from: classes.dex */
    public static class zza {
        public final List<Asset> zzbhA;
        public final zzrt zzbhz;

        public zza(zzrt zzrtVar, List<Asset> list) {
            this.zzbhz = zzrtVar;
            this.zzbhA = list;
        }
    }

    private static int zza(String str, zzrt.zza.C0038zza[] c0038zzaArr) {
        int i = 14;
        for (zzrt.zza.C0038zza c0038zza : c0038zzaArr) {
            if (i != 14) {
                if (c0038zza.type != i) {
                    throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c0038zza.type);
                }
            } else if (c0038zza.type == 9 || c0038zza.type == 2 || c0038zza.type == 6) {
                i = c0038zza.type;
            } else if (c0038zza.type != 14) {
                throw new IllegalArgumentException("Unexpected TypedValue type: " + c0038zza.type + " for key " + str);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrt zzrtVar = new zzrt();
        ArrayList arrayList = new ArrayList();
        zzrtVar.zzbhB = zza(dataMap, arrayList);
        return new zza(zzrtVar, arrayList);
    }

    private static zzrt.zza.C0038zza zza(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        zzrt.zza.C0038zza c0038zza = new zzrt.zza.C0038zza();
        if (obj == null) {
            c0038zza.type = 14;
            return c0038zza;
        }
        c0038zza.zzbhF = new zzrt.zza.C0038zza.C0039zza();
        if (obj instanceof String) {
            c0038zza.type = 2;
            c0038zza.zzbhF.zzbhH = (String) obj;
        } else if (obj instanceof Integer) {
            c0038zza.type = 6;
            c0038zza.zzbhF.zzbhL = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c0038zza.type = 5;
            c0038zza.zzbhF.zzbhK = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c0038zza.type = 3;
            c0038zza.zzbhF.zzbhI = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c0038zza.type = 4;
            c0038zza.zzbhF.zzbhJ = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c0038zza.type = 8;
            c0038zza.zzbhF.zzbhN = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c0038zza.type = 7;
            c0038zza.zzbhF.zzbhM = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c0038zza.type = 1;
            c0038zza.zzbhF.zzbhG = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c0038zza.type = 11;
            c0038zza.zzbhF.zzbhQ = (String[]) obj;
        } else if (obj instanceof long[]) {
            c0038zza.type = 12;
            c0038zza.zzbhF.zzbhR = (long[]) obj;
        } else if (obj instanceof float[]) {
            c0038zza.type = 15;
            c0038zza.zzbhF.zzbhS = (float[]) obj;
        } else if (obj instanceof Asset) {
            c0038zza.type = 13;
            c0038zza.zzbhF.zzbhT = zza(list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c0038zza.type = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.b());
            zzrt.zza[] zzaVarArr = new zzrt.zza[treeSet.size()];
            Iterator it = treeSet.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                zzaVarArr[i3] = new zzrt.zza();
                zzaVarArr[i3].name = str;
                zzaVarArr[i3].zzbhD = zza(list, dataMap.a(str));
                i2 = i3 + 1;
            }
            c0038zza.zzbhF.zzbhO = zzaVarArr;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
            }
            c0038zza.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            zzrt.zza.C0038zza[] c0038zzaArr = new zzrt.zza.C0038zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 14;
            while (i4 < size) {
                Object obj3 = arrayList.get(i4);
                zzrt.zza.C0038zza zza2 = zza(list, obj3);
                if (zza2.type != 14 && zza2.type != 2 && zza2.type != 6 && zza2.type != 9) {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
                if (i5 == 14 && zza2.type != 14) {
                    i = zza2.type;
                } else {
                    if (zza2.type != i5) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    }
                    obj3 = obj2;
                    i = i5;
                }
                c0038zzaArr[i4] = zza2;
                i4++;
                i5 = i;
                obj2 = obj3;
            }
            c0038zza.zzbhF.zzbhP = c0038zzaArr;
        }
        return c0038zza;
    }

    public static DataMap zza(zza zzaVar) {
        DataMap dataMap = new DataMap();
        for (zzrt.zza zzaVar2 : zzaVar.zzbhz.zzbhB) {
            zza(zzaVar.zzbhA, dataMap, zzaVar2.name, zzaVar2.zzbhD);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzrt.zza.C0038zza.C0039zza c0039zza, int i) {
        ArrayList arrayList = new ArrayList(c0039zza.zzbhP.length);
        for (zzrt.zza.C0038zza c0038zza : c0039zza.zzbhP) {
            if (c0038zza.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                zzrt.zza[] zzaVarArr = c0038zza.zzbhF.zzbhO;
                for (zzrt.zza zzaVar : zzaVarArr) {
                    zza(list, dataMap, zzaVar.name, zzaVar.zzbhD);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c0038zza.zzbhF.zzbhH);
            } else {
                if (i != 6) {
                    throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
                }
                arrayList.add(Integer.valueOf(c0038zza.zzbhF.zzbhL));
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzrt.zza.C0038zza c0038zza) {
        int i = c0038zza.type;
        if (i == 14) {
            dataMap.a(str, (String) null);
            return;
        }
        zzrt.zza.C0038zza.C0039zza c0039zza = c0038zza.zzbhF;
        if (i == 1) {
            dataMap.a(str, c0039zza.zzbhG);
            return;
        }
        if (i == 11) {
            dataMap.a(str, c0039zza.zzbhQ);
            return;
        }
        if (i == 12) {
            dataMap.a(str, c0039zza.zzbhR);
            return;
        }
        if (i == 15) {
            dataMap.a(str, c0039zza.zzbhS);
            return;
        }
        if (i == 2) {
            dataMap.a(str, c0039zza.zzbhH);
            return;
        }
        if (i == 3) {
            dataMap.a(str, c0039zza.zzbhI);
            return;
        }
        if (i == 4) {
            dataMap.a(str, c0039zza.zzbhJ);
            return;
        }
        if (i == 5) {
            dataMap.a(str, c0039zza.zzbhK);
            return;
        }
        if (i == 6) {
            dataMap.a(str, c0039zza.zzbhL);
            return;
        }
        if (i == 7) {
            dataMap.a(str, (byte) c0039zza.zzbhM);
            return;
        }
        if (i == 8) {
            dataMap.a(str, c0039zza.zzbhN);
            return;
        }
        if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.a(str, list.get((int) c0039zza.zzbhT));
            return;
        }
        if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzrt.zza zzaVar : c0039zza.zzbhO) {
                zza(list, dataMap2, zzaVar.name, zzaVar.zzbhD);
            }
            dataMap.a(str, dataMap2);
            return;
        }
        if (i != 10) {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
        int zza2 = zza(str, c0039zza.zzbhP);
        ArrayList<Integer> zza3 = zza(list, c0039zza, zza2);
        if (zza2 == 14) {
            dataMap.c(str, zza3);
            return;
        }
        if (zza2 == 9) {
            dataMap.a(str, (ArrayList<DataMap>) zza3);
        } else if (zza2 == 2) {
            dataMap.c(str, zza3);
        } else {
            if (zza2 != 6) {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + zza2);
            }
            dataMap.b(str, zza3);
        }
    }

    private static zzrt.zza[] zza(DataMap dataMap, List<Asset> list) {
        TreeSet treeSet = new TreeSet(dataMap.b());
        zzrt.zza[] zzaVarArr = new zzrt.zza[treeSet.size()];
        int i = 0;
        Iterator it = treeSet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return zzaVarArr;
            }
            String str = (String) it.next();
            Object a2 = dataMap.a(str);
            zzaVarArr[i2] = new zzrt.zza();
            zzaVarArr[i2].name = str;
            zzaVarArr[i2].zzbhD = zza(list, a2);
            i = i2 + 1;
        }
    }
}
