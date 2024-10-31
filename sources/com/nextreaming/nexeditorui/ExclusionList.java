package com.nextreaming.nexeditorui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ExclusionList implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private transient File f4474a;
    private Map<String, Integer> m_refs;

    private ExclusionList(File file) {
        this.f4474a = null;
        this.m_refs = null;
        this.f4474a = file;
        this.m_refs = new HashMap();
    }

    public static ExclusionList exclusionListBackedBy(File file) {
        ExclusionList exclusionList;
        ExclusionList exclusionList2 = null;
        if (!file.exists()) {
            exclusionList = null;
        } else {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                exclusionList = (ExclusionList) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (FileNotFoundException e) {
                    exclusionList2 = exclusionList;
                    exclusionList = exclusionList2;
                } catch (OptionalDataException e2) {
                } catch (StreamCorruptedException e3) {
                    exclusionList2 = exclusionList;
                    exclusionList = exclusionList2;
                } catch (IOException e4) {
                    exclusionList2 = exclusionList;
                    exclusionList = exclusionList2;
                } catch (ClassNotFoundException e5) {
                    exclusionList2 = exclusionList;
                    exclusionList = exclusionList2;
                }
            } catch (FileNotFoundException e6) {
            } catch (OptionalDataException e7) {
                exclusionList = null;
            } catch (StreamCorruptedException e8) {
            } catch (IOException e9) {
            } catch (ClassNotFoundException e10) {
            }
        }
        if (exclusionList == null) {
            return new ExclusionList(file);
        }
        exclusionList.f4474a = file;
        return exclusionList;
    }

    public synchronized void add(String str) {
        Integer num = this.m_refs.get(str);
        if (num == null) {
            this.m_refs.put(str, 1);
        } else {
            this.m_refs.put(str, Integer.valueOf(num.intValue() + 1));
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f4474a));
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    public synchronized void remove(String str) {
        Integer num = this.m_refs.get(str);
        if (num != null) {
            if (num.intValue() == 1) {
                this.m_refs.remove(str);
            } else {
                this.m_refs.put(str, Integer.valueOf(num.intValue() - 1));
            }
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.f4474a));
                objectOutputStream.writeObject(this);
                objectOutputStream.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
    }

    public synchronized boolean isExcluded(String str) {
        boolean z;
        Integer num = this.m_refs.get(str);
        if (num != null) {
            z = num.intValue() > 0;
        }
        return z;
    }
}
