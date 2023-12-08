package year2023.day8

import java.util.LinkedList

val testInput = """
    RL

    AAA = (BBB, CCC)
    BBB = (DDD, EEE)
    CCC = (ZZZ, GGG)
    DDD = (DDD, DDD)
    EEE = (EEE, EEE)
    GGG = (GGG, GGG)
    ZZZ = (ZZZ, ZZZ)
""".trimIndent()

val puzzleInput = """
    LRLRRLLRRLRLRRLLRRLRRLLRRLRRRLRRLRRLRRRLRRLRLRLRLLLRRRLRLLRRLRLRRRLRRLLRRLRRRLRRLRLRLRRRLRLRRRLLRLLRRLRRRLLRRLRLLLRRLRLRLLRRLRLRRRLLRLLRRRLRLLRRRLRRLRRLRRRLRRRLLRLLRRRLRRRLRRLRRRLLRRRLRLRRLLRRLRLRLRRLRRLRLLRRRLRRRLLLRLRLRRRLLRRLRRRLRLRRLLRRLRRLLRLRLRRRLRLRLRLRRRLRLLRRRLRRRLRRLLLRRRR

    LCP = (FQJ, JGH)
    FFQ = (PJQ, GPP)
    NQP = (LFH, SCS)
    BMS = (RMX, JCT)
    VHP = (GJC, SRK)
    TBP = (RQG, RLP)
    VMF = (KJL, QSR)
    QLQ = (DVJ, RQK)
    GNA = (VSL, QGP)
    KFP = (RRM, CLR)
    MRV = (DNB, QLR)
    CCX = (PLC, RQD)
    MHS = (HHB, MFG)
    FFX = (HQG, VFQ)
    NTM = (TDB, GRX)
    FMT = (SVR, PKN)
    HCT = (DLB, RQF)
    SJR = (NXV, TXT)
    XNS = (KNC, SJN)
    HPL = (XBG, XBG)
    HTG = (XVG, QLN)
    TCL = (BSB, FHJ)
    JMK = (XRK, DVL)
    GSL = (JBM, PPG)
    QLK = (GQP, TTM)
    HVR = (VHP, VKC)
    BPG = (GNX, GJJ)
    GLM = (PXJ, MKB)
    GRS = (NDC, KSG)
    KPF = (QCN, MRV)
    JTP = (GQD, XHK)
    RJG = (HCC, XMN)
    KKG = (RBC, PDJ)
    FPD = (NPJ, LLK)
    VSM = (RLB, BMS)
    JSB = (SGV, FMP)
    GJL = (DVF, BPR)
    VLH = (XXV, GSM)
    JLQ = (GKB, GVM)
    HHH = (PHG, XMR)
    KQS = (FTH, BBG)
    FCA = (QHT, STM)
    LKK = (XRL, CRP)
    MPP = (VLT, TCT)
    RQK = (JNK, KMB)
    TDG = (CHP, QHR)
    LXH = (TQG, FKX)
    LPG = (FGX, LSG)
    RLS = (LDF, DSD)
    DJH = (SGV, FMP)
    BXS = (PDG, RVN)
    FDC = (RDF, FNR)
    DTX = (MTT, HHH)
    FDD = (FDC, VBJ)
    BVN = (BGN, SBD)
    JCJ = (VDH, KXG)
    SJS = (JLQ, PDL)
    KXB = (TDB, GRX)
    MQJ = (XPN, VRR)
    BPR = (MHV, TVL)
    SQB = (DSF, GSG)
    QPC = (JTR, VSF)
    DQC = (GCQ, BFG)
    BHB = (DJV, CCN)
    PKR = (BSJ, GLH)
    RVC = (PHK, MDT)
    DHQ = (LVH, NRL)
    CQC = (XVC, DKS)
    JSX = (PXJ, MKB)
    CTL = (CQG, RLS)
    PHF = (RCC, SFR)
    CGC = (MNN, RBF)
    NDV = (LRN, GSJ)
    CFV = (PVL, JCJ)
    MKT = (SGJ, KPM)
    RBH = (FXT, VCM)
    TLL = (VLV, XGC)
    XDZ = (STM, QHT)
    JBR = (RCB, JLB)
    XHS = (LDL, KHL)
    CCC = (FVR, XQR)
    JVZ = (DJH, JSB)
    CCN = (HSB, KTT)
    MDT = (MPP, TKK)
    PCQ = (RBC, PDJ)
    PCD = (CFV, SKD)
    SQQ = (PLC, RQD)
    GSJ = (CQC, HLL)
    QLG = (BGG, FJF)
    MCG = (VSM, BBB)
    TCH = (PCQ, KKG)
    LML = (FDX, DDZ)
    KLD = (GGP, NNQ)
    RCL = (KPN, BFR)
    XLJ = (PKN, SVR)
    MTT = (XMR, PHG)
    HFL = (QGS, HJN)
    FRS = (VDK, CGC)
    KTT = (HXR, NRM)
    RTQ = (BKN, GPS)
    SBD = (GDP, CKK)
    FGG = (CGV, GJV)
    NGN = (FRS, NHT)
    HSK = (JTP, QNN)
    RVK = (TMV, TMV)
    VDD = (KSG, NDC)
    RQF = (VJS, HHK)
    TJK = (LBJ, XHC)
    RDQ = (SGB, VQJ)
    LRN = (CQC, HLL)
    HSS = (BKG, XKG)
    CGV = (XBR, JRN)
    RJV = (TQH, TGT)
    NLB = (SJS, QMR)
    TGD = (SXT, GFS)
    LLK = (FHS, CPB)
    BFM = (GMC, TKL)
    BDH = (BCS, SDD)
    AAA = (SGB, VQJ)
    CNN = (FPC, GBN)
    NBQ = (KTV, FTV)
    HXH = (MHL, FSV)
    SBX = (VPP, TCL)
    GPS = (RTC, THZ)
    MHV = (MPK, CML)
    JQV = (KGJ, PBF)
    TTL = (DLQ, RJV)
    QLC = (BVG, RBH)
    CTS = (DKN, NQP)
    FNP = (BSG, BDS)
    CXJ = (SKD, CFV)
    CSH = (HQB, VVJ)
    VLV = (JSX, GLM)
    TQT = (FTK, DCS)
    BNV = (XJR, CNM)
    SXK = (GJH, BQG)
    KLT = (RCL, RKP)
    RFX = (CTL, JNH)
    LDL = (CTS, KGK)
    SVR = (CVX, FFQ)
    PRK = (DXK, JFR)
    FST = (SXM, LPX)
    LNJ = (CCK, VMR)
    DJL = (KLT, SQP)
    QSR = (DVQ, QQF)
    DVF = (TVL, MHV)
    HFB = (STN, BQF)
    JJL = (FDC, VBJ)
    KBF = (MTM, NHK)
    KMB = (BNV, LMF)
    NSD = (XCN, VBL)
    BNG = (VTB, FTQ)
    VNF = (JFT, STT)
    GRX = (HJR, RSQ)
    LRB = (KXB, NTM)
    VMR = (VJP, LSR)
    KNC = (MSP, HSK)
    XKG = (MCG, PCX)
    VFQ = (BLL, JQF)
    BVG = (VCM, FXT)
    TJH = (TTX, BXT)
    LSG = (RKT, GHC)
    FCX = (HQQ, VJH)
    DQG = (CSH, QQX)
    STN = (FCX, CBR)
    RVN = (BXB, VJV)
    CVX = (GPP, PJQ)
    GFS = (HDV, JMF)
    KBH = (FST, FKL)
    SKD = (JCJ, PVL)
    QPM = (SRQ, CXD)
    RKT = (HVR, DCG)
    SBK = (TLL, FQR)
    VVS = (GHB, LHG)
    CXD = (RVC, RKN)
    CCK = (LSR, VJP)
    GHH = (FDR, SDR)
    GJV = (XBR, JRN)
    PDG = (BXB, VJV)
    CLB = (TSS, SFP)
    TFK = (QLN, XVG)
    SXM = (MDR, BFM)
    GLH = (BCN, RFX)
    BNJ = (DSV, BNG)
    SGJ = (CVR, DQC)
    KLS = (PHF, MRT)
    QQP = (BDM, XDZ)
    MHL = (TPK, BRB)
    BSJ = (BCN, RFX)
    XHR = (PXV, QLK)
    BDS = (KDH, CLB)
    NVP = (XNC, VTN)
    BKK = (XMJ, SRL)
    FXF = (QLC, CRG)
    DSV = (VTB, FTQ)
    LPS = (GTQ, TQT)
    JRN = (QSN, MRX)
    RKN = (PHK, MDT)
    DNM = (VFQ, HQG)
    TXF = (SQP, KLT)
    FCD = (JTR, VSF)
    FGF = (KQR, XHS)
    CKN = (CDL, JNV)
    FNR = (SQL, SXK)
    FTK = (LCD, NLB)
    KXC = (HMB, BSL)
    JNH = (RLS, CQG)
    RLB = (JCT, RMX)
    TBB = (TNQ, TDG)
    MNB = (DHQ, TCN)
    HLR = (RQK, DVJ)
    NPJ = (CPB, FHS)
    LXF = (NGN, RRF)
    SMV = (LXF, BLS)
    RFH = (FQJ, JGH)
    QNG = (BGG, FJF)
    CNM = (DJL, TXF)
    FQR = (VLV, XGC)
    XBG = (JCX, JCX)
    BQG = (DTX, LJC)
    QLN = (PRK, CBH)
    RRF = (NHT, FRS)
    NLX = (KBF, RLM)
    PLC = (HNR, BLC)
    HQQ = (GBF, LTL)
    RNS = (LXF, BLS)
    QMR = (PDL, JLQ)
    SJN = (MSP, HSK)
    GVV = (CCD, PLK)
    GGJ = (QQG, LNH)
    SRX = (RXP, QBB)
    LMF = (XJR, CNM)
    HVB = (RPM, QNH)
    TNQ = (QHR, CHP)
    BFR = (GRS, VDD)
    FTH = (SJB, MHG)
    QLR = (SGT, DXD)
    TKL = (VLH, NDQ)
    TPB = (SCV, NBX)
    BSL = (PKC, CTJ)
    HMF = (DRJ, CBJ)
    CCD = (LGN, RSM)
    HJR = (CKN, NPR)
    FDR = (KLS, DBB)
    SFP = (CXJ, PCD)
    TTM = (DSM, TXL)
    DVL = (TBB, VSX)
    JNK = (LMF, BNV)
    XNC = (KHC, MQJ)
    LBR = (MLJ, VVS)
    FXL = (MKR, CGH)
    BLC = (LBK, BNJ)
    HHK = (GVV, MGS)
    GNG = (TQG, TQG)
    MNN = (XVF, QFL)
    XVF = (JMK, SPL)
    SLL = (QPK, BVN)
    MHH = (XQK, BHB)
    CDL = (VMF, SMJ)
    LGN = (MGD, LFV)
    TSS = (CXJ, PCD)
    DCG = (VHP, VKC)
    HQL = (BKN, BKN)
    TXT = (GSL, CFQ)
    GJJ = (GNG, LXH)
    FJL = (DDL, KLF)
    LBJ = (HFL, HCX)
    SFL = (RVN, PDG)
    HHB = (CKC, SRX)
    VVJ = (TQN, CDM)
    MRL = (QKN, HCT)
    XQK = (DJV, CCN)
    BPH = (BPR, DVF)
    GJB = (DFM, XPK)
    DQJ = (JBR, BTS)
    HCX = (HJN, QGS)
    HQB = (CDM, TQN)
    QVP = (XCN, VBL)
    BSG = (KDH, CLB)
    VXM = (GJB, LTR)
    LRK = (GFS, SXT)
    GQD = (VDR, NDV)
    KFH = (BRR, BRR)
    KLV = (SCV, NBX)
    TFN = (VMX, XNS)
    GQP = (DSM, TXL)
    LJC = (HHH, MTT)
    BGG = (KLV, TPB)
    KLM = (SRL, XMJ)
    VSX = (TNQ, TDG)
    MGS = (CCD, PLK)
    DKX = (CFF, CCC)
    CDM = (DTB, MHJ)
    MJN = (KTV, FTV)
    VFC = (HMB, BSL)
    STT = (TLS, DQK)
    LFV = (MKN, TCH)
    VLT = (VNF, FCS)
    TCT = (VNF, FCS)
    QSK = (GTQ, TQT)
    XLV = (HQL, HQL)
    RCG = (TJH, VBH)
    SRQ = (RVC, RKN)
    HCC = (VKG, NJR)
    MLM = (PRB, XTB)
    QCN = (DNB, QLR)
    LVG = (XXD, HFB)
    FDB = (HPN, LMS)
    QKN = (DLB, RQF)
    QNN = (GQD, XHK)
    LLL = (XLJ, FMT)
    GPP = (MMF, KFP)
    JGV = (BKG, XKG)
    JCT = (FDS, MLM)
    TKT = (PBF, KGJ)
    CRP = (FPD, MTX)
    KLF = (XKX, JVZ)
    QGS = (NSD, QVP)
    GGP = (LQT, VFG)
    PXV = (TTM, GQP)
    GBG = (TXT, NXV)
    QNH = (FKC, LNJ)
    KHL = (KGK, CTS)
    BPC = (FCD, QPC)
    TQN = (MHJ, DTB)
    BBG = (SJB, MHG)
    HJN = (NSD, QVP)
    PVF = (GNX, GJJ)
    DQK = (NBQ, MJN)
    JCX = (VLS, FNP)
    NMG = (LSG, FGX)
    GDP = (SNK, CTG)
    TPK = (VQL, DQJ)
    VKG = (DQG, PRR)
    LDF = (XRB, HXH)
    DDZ = (QGP, VSL)
    DBX = (SDD, BCS)
    RSQ = (NPR, CKN)
    THZ = (SBX, HKR)
    VFG = (XXX, TFR)
    XMJ = (TFK, HTG)
    TVL = (MPK, CML)
    KQR = (LDL, KHL)
    XPP = (SQQ, CCX)
    BRB = (VQL, DQJ)
    BKG = (MCG, PCX)
    XPK = (XLV, MLX)
    DNB = (SGT, DXD)
    XVC = (JSH, MRL)
    BKN = (RTC, RTC)
    DVQ = (LRR, HMF)
    LNG = (VRM, QQP)
    NDC = (VRC, FGF)
    SNK = (QNG, QLG)
    XRK = (VSX, TBB)
    MHQ = (MKR, CGH)
    MXA = (VLS, FNP)
    CRM = (FDX, FDX)
    JGH = (KDL, PFN)
    VDH = (TLR, TFN)
    CVR = (GCQ, GCQ)
    DSD = (HXH, XRB)
    SDD = (TVB, KPF)
    RCB = (LCP, RFH)
    BLS = (RRF, NGN)
    DKS = (JSH, MRL)
    NBX = (QVQ, MNB)
    FKX = (RDQ, ZZZ)
    FCS = (JFT, STT)
    FQJ = (PFN, KDL)
    VLM = (VFC, KXC)
    BDM = (QHT, STM)
    VBJ = (RDF, FNR)
    LPX = (BFM, MDR)
    FDS = (PRB, XTB)
    TMM = (FCD, QPC)
    FJH = (XMN, HCC)
    XQD = (VTN, XNC)
    SCS = (PTK, LFB)
    GSM = (JRD, XCS)
    VCJ = (KQS, NMX)
    RDF = (SXK, SQL)
    BCS = (KPF, TVB)
    VPP = (FHJ, BSB)
    BKC = (TML, FGR)
    CTJ = (FDB, PMH)
    SRK = (QRP, MHS)
    TLR = (XNS, VMX)
    CQG = (LDF, DSD)
    GJC = (MHS, QRP)
    FHH = (VCJ, NPD)
    BGN = (GDP, CKK)
    VJH = (LTL, GBF)
    CRR = (FFX, DNM)
    XMR = (TMM, BPC)
    TFR = (QMB, SBK)
    PRB = (KQB, TBP)
    XMN = (VKG, NJR)
    SRL = (TFK, HTG)
    CBR = (HQQ, VJH)
    DXD = (LXL, FFC)
    SMJ = (KJL, QSR)
    VLK = (GLH, BSJ)
    TQG = (RDQ, RDQ)
    DFP = (FFX, DNM)
    SHQ = (NTM, KXB)
    GDS = (MHQ, FXL)
    QBB = (FGG, XKL)
    NNQ = (VFG, LQT)
    PBF = (CBS, PLV)
    HPN = (TJK, TRG)
    RQD = (BLC, HNR)
    TXL = (JJL, FDD)
    BBQ = (TMV, FJL)
    GNX = (GNG, GNG)
    VTB = (NRD, XPS)
    FGX = (GHC, RKT)
    NHT = (VDK, CGC)
    LTR = (DFM, XPK)
    DLQ = (TGT, TQH)
    DXK = (QLQ, HLR)
    FKC = (VMR, CCK)
    GHB = (JQV, TKT)
    XRL = (MTX, FPD)
    VHK = (XTC, QPM)
    XTB = (TBP, KQB)
    BTS = (JLB, RCB)
    QHR = (MHH, LHD)
    VJV = (CPS, NXL)
    QQX = (VVJ, HQB)
    LCD = (SJS, QMR)
    NXL = (KLM, BKK)
    JQF = (VXM, RJD)
    PKN = (CVX, FFQ)
    DBS = (RCS, PHP)
    DRJ = (CRR, DFP)
    VQL = (JBR, BTS)
    XXD = (BQF, STN)
    SGT = (LXL, FFC)
    HSB = (HXR, NRM)
    SGB = (KQV, VLM)
    GTQ = (FTK, DCS)
    MMF = (CLR, RRM)
    DKN = (LFH, SCS)
    QMB = (FQR, TLL)
    GJH = (LJC, DTX)
    JRD = (KFH, PXX)
    DLB = (HHK, VJS)
    VTN = (MQJ, KHC)
    XXV = (JRD, XCS)
    VVA = (JSB, DJH)
    DSF = (LJF, HVB)
    XTC = (CXD, SRQ)
    TQH = (GHH, TND)
    PPG = (FKG, RCG)
    VBL = (LLL, DDM)
    MPK = (DKR, MKT)
    HKR = (VPP, TCL)
    SQL = (BQG, GJH)
    TKK = (VLT, TCT)
    KHC = (XPN, VRR)
    LQH = (DLQ, RJV)
    BQF = (FCX, CBR)
    MHG = (HPL, SFH)
    HMB = (PKC, CTJ)
    NRM = (DSB, LVG)
    LHG = (TKT, JQV)
    FDX = (VSL, QGP)
    LRR = (DRJ, CBJ)
    CFF = (FVR, XQR)
    JFT = (TLS, DQK)
    JFR = (QLQ, HLR)
    BFG = (CRM, LML)
    RKP = (KPN, BFR)
    FTV = (MTQ, XRS)
    XMB = (BPH, GJL)
    RXP = (FGG, XKL)
    KGJ = (PLV, CBS)
    DSB = (HFB, XXD)
    FJF = (TPB, KLV)
    NJR = (DQG, PRR)
    JMF = (VHK, JLK)
    KJL = (QQF, DVQ)
    TCN = (LVH, NRL)
    TML = (GPM, SLL)
    XJR = (DJL, TXF)
    SRZ = (FNP, VLS)
    DFM = (XLV, MLX)
    NPR = (CDL, JNV)
    LHB = (LNH, QQG)
    VSF = (TFQ, LKK)
    CHP = (LHD, MHH)
    KPM = (CVR, DQC)
    CVL = (DSF, GSG)
    TMV = (DDL, DDL)
    PRR = (QQX, CSH)
    QRP = (MFG, HHB)
    ZZZ = (VQJ, SGB)
    QSN = (RJG, FJH)
    FKL = (LPX, SXM)
    GHC = (DCG, HVR)
    TND = (FDR, SDR)
    LVH = (XQD, NVP)
    RBF = (QFL, XVF)
    TDB = (RSQ, HJR)
    JBM = (FKG, RCG)
    GVM = (FVK, HTQ)
    QPK = (BGN, SBD)
    CFQ = (JBM, PPG)
    PVL = (VDH, KXG)
    VRM = (BDM, BDM)
    HXR = (LVG, DSB)
    JLB = (LCP, RFH)
    FHJ = (LGS, DBS)
    DSM = (JJL, FDD)
    CBH = (DXK, JFR)
    GBK = (NNQ, GGP)
    SQP = (RCL, RKP)
    PLV = (MTP, HLX)
    FKG = (VBH, TJH)
    LJF = (QNH, RPM)
    PDJ = (SRN, XPP)
    VRR = (CSF, GDS)
    KDL = (CNN, TGM)
    LXL = (KLD, GBK)
    XGC = (GLM, JSX)
    MLX = (HQL, RTQ)
    FSV = (TPK, BRB)
    PHK = (MPP, TKK)
    KDH = (SFP, TSS)
    MLJ = (LHG, GHB)
    CSF = (MHQ, FXL)
    FPC = (RVK, BBQ)
    MHJ = (QKC, VVQ)
    PKC = (FDB, PMH)
    NMX = (FTH, BBG)
    QQF = (LRR, HMF)
    PHG = (TMM, BPC)
    QVQ = (TCN, DHQ)
    FXT = (DKC, LLV)
    VRC = (KQR, XHS)
    MTX = (NPJ, LLK)
    RSM = (LFV, MGD)
    PXJ = (SFL, BXS)
    GBN = (RVK, BBQ)
    SRN = (SQQ, CCX)
    MKN = (KKG, PCQ)
    LNH = (CDB, KBH)
    FHS = (TTL, LQH)
    VLS = (BSG, BDS)
    QGP = (NMG, LPG)
    LMS = (TJK, TRG)
    XHC = (HFL, HCX)
    MFG = (SRX, CKC)
    CPS = (KLM, BKK)
    VMX = (KNC, SJN)
    XKX = (JSB, DJH)
    MKB = (SFL, BXS)
    HTQ = (VLK, PKR)
    LTL = (VHC, DKX)
    LQT = (XXX, TFR)
    QKC = (XHR, NGS)
    TPS = (SJR, GBG)
    MTP = (LHB, GGJ)
    CBS = (MTP, HLX)
    SJB = (HPL, HPL)
    VHC = (CFF, CCC)
    QFL = (JMK, SPL)
    XCN = (LLL, DDM)
    DVJ = (JNK, KMB)
    FMP = (LRK, TGD)
    CPB = (LQH, TTL)
    CTG = (QNG, QLG)
    DDM = (XLJ, FMT)
    JLK = (QPM, XTC)
    KQB = (RLP, RQG)
    MTQ = (LPS, QSK)
    KQV = (VFC, KXC)
    CKC = (QBB, RXP)
    XXX = (SBK, QMB)
    DBB = (MRT, PHF)
    LSR = (JMD, MSX)
    RCC = (CVL, SQB)
    MSP = (JTP, QNN)
    RQG = (BPG, PVF)
    KGK = (NQP, DKN)
    CML = (DKR, MKT)
    GSG = (LJF, HVB)
    DKC = (SHQ, LRB)
    MGD = (TCH, MKN)
    XHK = (VDR, NDV)
    KTV = (XRS, MTQ)
    VCM = (DKC, LLV)
    BXB = (NXL, CPS)
    LBK = (DSV, BNG)
    BXT = (FHH, LGP)
    RCS = (JBG, NLX)
    XPS = (VNS, TPS)
    DCS = (LCD, NLB)
    XQR = (FXF, GPT)
    QHT = (BKC, LHC)
    FVK = (VLK, PKR)
    CHH = (BPH, GJL)
    VDR = (GSJ, LRN)
    XBR = (QSN, MRX)
    HDV = (JLK, VHK)
    HTN = (MLJ, VVS)
    MDR = (TKL, GMC)
    JSH = (HCT, QKN)
    HMG = (JCX, SRZ)
    TRG = (XHC, LBJ)
    RLP = (BPG, PVF)
    TVB = (MRV, QCN)
    LFB = (HSS, JGV)
    PXX = (BRR, LNG)
    PMH = (LMS, HPN)
    RRM = (DBX, BDH)
    JMD = (XMB, CHH)
    GPT = (CRG, QLC)
    VSL = (NMG, LPG)
    FTQ = (NRD, XPS)
    LLV = (SHQ, LRB)
    VVQ = (XHR, NGS)
    PHP = (JBG, NLX)
    HNR = (LBK, BNJ)
    LHD = (BHB, XQK)
    CKK = (CTG, SNK)
    TGT = (TND, GHH)
    MSX = (CHH, XMB)
    VNS = (SJR, GBG)
    XRB = (MHL, FSV)
    NGS = (PXV, QLK)
    TGM = (FPC, GBN)
    XRS = (QSK, LPS)
    NXV = (CFQ, GSL)
    JBG = (RLM, KBF)
    SGV = (TGD, LRK)
    XPN = (GDS, CSF)
    RLM = (NHK, MTM)
    NPD = (NMX, KQS)
    DDL = (XKX, XKX)
    NRL = (NVP, XQD)
    XCS = (KFH, PXX)
    BCN = (CTL, JNH)
    DJV = (KTT, HSB)
    CDB = (FST, FKL)
    SFR = (CVL, SQB)
    CBJ = (CRR, DFP)
    QQG = (KBH, CDB)
    VDK = (RBF, MNN)
    PJQ = (KFP, MMF)
    VJP = (JMD, MSX)
    RTC = (HKR, SBX)
    HLL = (DKS, XVC)
    MRX = (FJH, RJG)
    KSG = (VRC, FGF)
    TFQ = (XRL, CRP)
    CGH = (LBR, HTN)
    XHA = (HKR, SBX)
    PCX = (VSM, BBB)
    VJS = (MGS, GVV)
    BSB = (LGS, DBS)
    RMX = (FDS, MLM)
    FFC = (KLD, GBK)
    FGR = (SLL, GPM)
    LHC = (TML, FGR)
    BLL = (RJD, VXM)
    SCV = (QVQ, MNB)
    TLS = (MJN, NBQ)
    PLK = (RSM, LGN)
    PTK = (JGV, HSS)
    HLX = (GGJ, LHB)
    GKB = (HTQ, FVK)
    LGS = (RCS, PHP)
    KXG = (TFN, TLR)
    MTM = (SMV, RNS)
    RBC = (XPP, SRN)
    VQJ = (KQV, VLM)
    RPM = (LNJ, FKC)
    DTB = (VVQ, QKC)
    SFH = (XBG, HMG)
    HQG = (JQF, BLL)
    DKR = (SGJ, KPM)
    SDR = (KLS, DBB)
    VKC = (GJC, SRK)
    GPM = (BVN, QPK)
    SXT = (HDV, JMF)
    MKR = (HTN, LBR)
    CLR = (DBX, BDH)
    JTR = (LKK, TFQ)
    LGP = (NPD, VCJ)
    STM = (LHC, BKC)
    TTX = (LGP, FHH)
    NRD = (TPS, VNS)
    KPN = (GRS, VDD)
    CRG = (RBH, BVG)
    BBB = (RLB, BMS)
    XVG = (CBH, PRK)
    MRT = (RCC, SFR)
    PFN = (TGM, CNN)
    JNV = (SMJ, VMF)
    FVR = (GPT, FXF)
    XKL = (CGV, GJV)
    GBF = (VHC, DKX)
    GMC = (NDQ, VLH)
    LFH = (PTK, LFB)
    GCQ = (CRM, CRM)
    SPL = (DVL, XRK)
    PDL = (GKB, GVM)
    NDQ = (XXV, GSM)
    RJD = (GJB, LTR)
    BRR = (VRM, VRM)
    NHK = (RNS, SMV)
    VBH = (TTX, BXT)
""".trimIndent()

val part2TestInput = """
    LR

    11A = (11B, XXX)
    11B = (XXX, 11Z)
    11Z = (11B, XXX)
    22A = (22B, XXX)
    22B = (22C, 22C)
    22C = (22Z, 22Z)
    22Z = (22B, 22B)
    XXX = (XXX, XXX)
""".trimIndent()

val test2Input = """
    LLR

    AAA = (BBB, BBB)
    BBB = (AAA, ZZZ)
    ZZZ = (ZZZ, ZZZ)
""".trimIndent()

fun part1(instructions: String, map: Map<String, List<String>>) {
    val list = ArrayDeque<Char>()
    list.addAll(instructions.toList())

    var currentNode = "AAA"
    var counter = 0

    do {
        val instruction = instructions[counter % instructions.length]
        counter++

        if (instruction == 'L') {
            currentNode = map[currentNode]!![0]
        } else if (instruction == 'R') {
            currentNode = map[currentNode]!![1]
        }

    } while (currentNode != "ZZZ")

    println("reached destination in $counter steps")

}

//wrong: 12169 (low),

fun part2(instructions: String, map: Map<String, List<String>>) {
    val list = ArrayDeque<Char>()
    list.addAll(instructions.toList())

    var currentNodes = map.keys.filter { it.endsWith("A") }

    val seenNodes = hashSetOf<String>()
    seenNodes.addAll(currentNodes)

    var counter = 0L

    do {
        val instruction = instructions[(counter % instructions.length).toInt()]
        counter++
        currentNodes = currentNodes.map { node ->
            when (instruction) {
                'L' -> {
                    map[node]!![0]
                }

                'R' -> {
                    map[node]!![1]
                }

                else -> {
                    error("unexpected")
                }
            }
        }

        if (currentNodes.any { seenNodes.contains(it) }) {
            println("Looping after $counter steps")
        }

        seenNodes.addAll(currentNodes)

//        if (counter % 100000000 == 0L) {
//            println("Nodes: ")
//            currentNodes.forEach {
//                println("\t$it endsInZ? ${it.endsWith('Z')}")
//            }
//        }

    } while (currentNodes.any { !it.endsWith('Z') })

    println("Nodes: ")
    currentNodes.forEach {
        println("\t$it ")
    }

    println("reached destination in $counter steps")
}

fun main(args: Array<String>) {
    val input = puzzleInput.split("\n\n")
    val instructions = input[0].trim()
    val nodes = input[1]

    val nodeMap = mutableMapOf<String, List<String>>()

    for (line in nodes.lines()) {
        val splitLine = line.split(" = ")
        val nodeDefinition = splitLine[0]
        val leftRight = splitLine[1].removePrefix("(")
            .removeSuffix(")")
            .split(",")
            .map { it.trim() }

        if (nodeMap.containsKey(nodeDefinition)) {
            error("Unexpected duplicate key")
        }

        nodeMap[nodeDefinition] = leftRight
    }
    val startTime = System.currentTimeMillis()

    part2(instructions, nodeMap)

    val endTime = System.currentTimeMillis()
    println("millis elapsed ${endTime - startTime}")
}
