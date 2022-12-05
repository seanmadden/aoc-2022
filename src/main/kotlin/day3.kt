package day3

import java.lang.Exception

val testInput = """
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw
""".trimIndent()

val puzzleInput = """
    FqdWDFppHWhmwwzdjvjTRTznjdMv
    ZBJrDVfQcfSRMLjZnjjM
    cBffPfbrbQcgQJggfVQJBPbCwlPtWFDWHFHhpmmGlGmlqmDG
    PNbMLgmPgRDgRtMPDdmdbmdmQrTBVCZnVnpCnNHHVZBNVZHc
    ljvvqhlvshhnrcpBZqpTcr
    zGhWzFTJvsFttddWbMRdmP
    hhGdDhfdDhmdnHwtzzRtdzbzQQQg
    WTTZJLsvLRJCcWJWScWWLtzjwBzBttbBzSwVQjQBtt
    vLJcLLTRsvsTZPqHGhFHGhhPhfqD
    dJszLvzvCZZsJmszCrrdFmpppMpDMQPMgmDcDgSS
    nRjRbnnjlNhblnjtVtQlWttMFPfMfPgDMpBgSBPgBS
    GWVQTVTnTNhjblQNRsdJLLdTCdzdZLrdrJ
    RnLJBfmJfmNBHlQvvbdQ
    grhgrtqgjJhhggNHqvwWqvbNlbHw
    GVTTsFFjJjVVFVGCFTJDDjhFcZmRMZfnZcncSpMSGcRPZpLp
    bwSNRNSRzSWnPnJRldMBMQmMlsCcPPCP
    FGpDqTTVFFprpjLVQMMGtMclcmHGtBdc
    TjhhgTLpVZhpLDZqrTqZVpBSwJwzNnWNWJvzzNSggwwN
    PHTMsmwrJMwLJvJddvdHwvcWnnWfccqGnhhfGcDqsnGc
    tZVlzQZblBgcSqqRhRmzqf
    CmlgmZlQtFtZNlVZdHLMrMvvCrrvvTTC
    PrDGBBddprmzddrSqccRgSTpqbsMRR
    hvLtfFNvvZNfGGfRgbqsRNlTSSgsbM
    QQQjZHHQjvththFffCHPPzmGrmDzDWrWBw
    GrjGrpjjCsnwhsGGPwlPTPLPVttPqLVl
    HzSHHhczRlLTHqqq
    DbhvFSSzQcZbcFbcQjrJrMJmmZnGJmJnjn
    mvTDsJLwzlWNDDnZngZNdd
    BVtPqFMqtvQFqPqjFBMVtRZGNGhfNcfQdpfgnQgNcNgp
    HBHtPbHCLCzsLJvT
    nVHVFfggbQVmFFfhLpBpBTrfLBCB
    cjjRwJdqtwwwNNjcwRMwnLNTpNsGCnLsLGhBhpNn
    tJqStcRMMMjPwlnvzgQWzmHzlmQl
    nNSRcDHRmHhhDZZZdBDfWJdfrJ
    LGrGVtjCPCbbQQQQLvQpbVQZzsqsBMdBqMvZMMJZqJvdBW
    GCPLlLPPPbTpbCbpLPpVlmrmmrHhHcHnHrHHgTFFnm
    rQbnBrDTQcdpHttt
    qNsNpfjLpNLRNqLMtdVsddcmVzdzVh
    WJfLCfvpWpNLbwwwBwbZFvlZ
    ZslGPhBWBJbNjmbTmSWN
    qtDCZcfZtDjbjCQvmmSj
    ttpRzqtqRLDzpRtDdtPlhhZZGBHGPsGZPhwd
    WjtcNnMtztGFrsNjcgRHvdwHhhjRwlhwlg
    pPSpPBPVqJqBCCPvZdHlVGddwdhvgH
    qpDBpBqPTDLqGLmpTPqbDmWMNrFrrFQnFMNnMNQtMm
    dNwfsjFLQLFNBhTCTPPTBJhhTP
    VmVMgqgRVHtztmgqgzgqRzgMPWCRWTpPCCPWPThDdZPCRZJp
    VMqtMgGHmgVMvmqMMtGMSmbslnQFcsndfjNNsnfscnbddF
    qbWcqrFNCJGSChvLGv
    MnslRSpSVsGgGhDDwLvl
    RjMtfnpmmmjSWSbjrNPN
    rsCsqTVgfCnQFdCznQ
    ZRsBvMvmZMGQQmFnDmQzzQ
    MlGLlBjRGjjWWGRGMlNrLLrssTPNfLcTgrVr
    vpSBBcJnWnSmcqmcChdcgf
    NRNPFDwwDbThqTJffZQHhd
    DzPDNVNbLwPzMLRbNMDjBlvpWjrvrVJjjSsBjr
    dndGpnWdVnBPFFHTBgGH
    qCcCmjqNNJDtcJQjqJqMCQJcFTBRZRwBZBHDPRHBHZDbgBBR
    szJcCtNQqjqCNjjNhdgWfLLdhVWsSVnr
    NjJLgSLGGCLWvqNqNBvwFb
    htmVmtHnlZmDVhtmhblmDMHddBRvwwZQQqWPFvFwdvRWdR
    HnlnHfDsbSTbJzsz
    JvZfsPsPhRfZZnCdtnmjHVRLCH
    TzcczTtgqpgGSTlHHVHCGjCdHdnQQQ
    wDBDSDlWzwwzDqqMtrMrfsfbNvJNJB
    ThfQTdQzQbgdhdNbJFJSlbBLlmqqHBSHCRHsHm
    rWBWWPcvpGGwjPPpvpPGplRSnLLnCrLRsRlLsLmLmR
    cGWPPMtpZDwpMpJQBQQQDBBVNfdQ
    WcWDRLSzFrRFFccPmnssMrGtmMnnGm
    jvvgCCTvNqTtJqsnqwPBmspZMB
    gbVgbvlChJVbCdbtTgjdLWSHWcHSDcQzFzRzDF
    zTrHgrFWRrWvMpPNBVZZHVfN
    hdnlltGLtGSQPVLSNBQN
    CqGGtGwlhlGdtGmbtjtmmvDRFvVFTTRDRbRgFJRbDr
    DTFpQFrZDFBDFrTNFjSWJsWlWjsRJcslsp
    zzPqvdqNzvqzfzMfzqmCzzfJsclWjSSRWglgjclWSmcjlJ
    hfPGwhhvMGCVCdddhQQZQnNrTDQnFrtn
    DDMFjwVTgVmMWgVpdqtlJnpvHHnslw
    fFfZzLSfzBfZBZtqJJHsnSsldlld
    GLcNhRGLZBhmDWTjDTWF
    FbVcQRVRBFfNFfccVfZcWddnGrrHncWtdHsZ
    hwGwjgTSGrssZHHTdn
    LvPvCJgJLwjlSJmSPLvvgGfFBpBVfLLMBQMRRbzMVb
    rfMCJPBMMCrSCSBGZZqRlRLzqhqh
    LDvdNmbgHjHgnmnvnHjgDjqlZhZzszhqzWsRWRRNcRNZ
    dmbvHDdnjDjVmjTmHjJVrfprPCCVtLSMrSpJ
    fdfTBfNVZffMmdfdhGhcJLJrvnlJvrBJ
    FFWFWTzWSWtFgPHgRPWTzggpJcvvSCGSGJnrvhhrrJhlGlGn
    pztFjzRTqWzgHqHWtPtPFgmsNfqbDdwDNVwbmfwbdNsb
    zCHvDWwvCwgpNRCWWHttCwvNPVTqrRrVbbsnbqQPbVsbPrqG
    jBBcmZBGmBSSJdmhBVbnnQrVbVqqVPbhbP
    ZfJBmLjfJZMcdZmJffGMtHtwNCvWwwwztMzg
    rgFgllfdpFlTHfTnfnNPNtPBBVtpzmVVPmmP
    bLSSbGhGWSWmLzztcQPCQC
    jvwhhwRwbwshjGhWwsRRTFflFJFzfddFrHzTrJ
    GSwgSdwfvdfvwgGwBLdJbjjpmFjSTRpqHmRrjptrqt
    NDMVMCsWQVCsQFjFTHjVLqjFrp
    PzWDDCNNlCWfbhZZLfBGwl
    clFLFpFJcVmmWWgWWcWTdwZqCZCZqDqDDSwvwrdHCZ
    GGLfGtbfMNbbLGtzjBNnsMjjZCwDvQZHrHQvDHHHHHHrrNHq
    BthbnfPGMstmJgRPpFRTLL
    VRcdVRPTgVTLVMwmggJBwblJFlmb
    CqDDQsjCCrnnnQQtDcrnGCssJZNvZbvNQmZwmZlbNbwFNwmF
    pstjcqrprsHrfDpnrCnHCzRhSMhMMMRVPLMhddfhzT
    QNDQThccDghdcLLgVsrVLVlMGM
    BbbWpppFFpnfnFbBBPRMTJMRsGlJGlJVLf
    wpnbmvbnSwSnmzHHzwwhQqTctNCcqdNqZvhQjj
    lwCLwLjzLhLHCvwjGCZJbQSHdBQdDdbDtdSQ
    pnzcTVsszpncgFdJpbtDBDttDSJS
    zTPcRrfzgzCCvGRhLLqW
    BgDbztvdDzLZZwMbDDcFHQQJPLWWPJQJHTHF
    jfpNqSrpCqNfNSpjCqSqshNFRQJcJWRRFssgWRHWWFWHQJ
    mrnNNgNfMZwmDtZw
    ZrrFPQsQPRLcvPJvhg
    HpmTjnBmDDDwqtVcHNvJhNVRhgvh
    tTpTGfnttqwnqQJzFdzfSdzSzr
    qVVZqfVNdnBZMNzNnPzfMqbzJvFSjSllvjBwrvrvFrlsrjJs
    LhHtDTmWmWmGDhGLWHghHLCwrwRjjsPJrSjFjFrFClvrww
    mDDgtcLcmtTWTTHhpWLDHhDNMqVnqfdqbZdQpqVbzZVPVb
    WGpVMtGZplgHVWMtZpZFHJjndvFdjddJhnjLHF
    DTrRcSSccfzcCPDCTnvJvjbrrhjNvqjqJL
    zczwPDTmfZZtgLwWlp
    sTtTpvMjpBdmTlhlBTdvsvdncmVcVVVVHzFqVnFfqzHzWV
    GGwQRZNCRgDgsDDbSbSgfGFFrHfVHVVWrHWWcVFF
    RZRPgbNSJDsTsplPLsvd
    GrGNGhpnPFFBfCQCMwrVlwTC
    PPWHmmSvSvdTfJvJVVfCfJ
    RjWDmDdDbjcSHmRRLRRHjdDBsFFbBngBzhqbBhpqBPgFFg
    TfdNjJjmShGcWvQNQqcNFN
    gsRZRMqbDpsHHnZnngMZFPlzQRPWvRtPwtRWzlPv
    brgMMgZCLsDpHGGjfGJVSCqddT
    BdSRjHScGMVjGdcScwLgqQqphNqNDqBBQW
    zzQClvtttrwqrwgCwp
    PQJTzvJJTtJQlvQftmfdmdmGRcSdcMSGdS
    PjPwvwlfGlGCGwppWBsWQVVQnpCQ
    FRSHzMJdrfRnpmpWmp
    TzJTMNNrHLJfTJccvjqwwgGLZLLc
    dCpjsGvcsLvszTrRRlRrDJ
    hPNqqpbhFlrDnPrRnz
    SBbphFNtLvvSfLfc
    zTFnnZzqrjFVnZTrtwMDptbpMwMMBDzb
    JGPCjWGgJjPWGJjNchmbBRpNNDsRsNBbbRBppD
    JWCggWSCmhCmvWHTQrTQfHjdVlQZll
    WWbrmZjbmjpbWSmcWHSbLddwvDggLFDhFrRlFFDw
    qPMVzTPQVfzvVzBQTMtRswwlDdhDghhsfLwdhs
    MMMPQBPJPzCVzvzQVtBJJMzCbmSZNWbSccHHmmZpWSZGZS
    BgmMgjlBMjHPssBnwphtFwhSVVmGGwFS
    rfCqQQrfvCQNRqCnCthFVSGSGtVS
    TrzLNvWfQvrWQZNWsnHsssBBcZBMsDdZ
    CtJCddDHDDPGHCdNVLPBdLDbbGFbwZSsSSZrfFFrGbGlsb
    gvjpnvhRphjmpmSfsTSnPZZrZfrZ
    ghRRRhQgWvmPWtHHtLdMtH
    qNgQgNgNQFVbqVQDMRZMDRBHHJHRFh
    jnTTPzWZCzrWzGRHMrhmBvJBSBBM
    jtCGWnCWPTsTzlctWPtqLbwqZggNwgLbwdVq
    DJgJDgFqCGlhFDGDCWhqCwRfpbcpbsgsVscRpwbwws
    SmLZQmMVvLbsbssNQsQN
    tHZMLZZZMVtmnMHWDHjWlGhFDqCl
    PZRmjlDBWRBWBQMdQQBDPRhfzSSTTnfFnfzFpVFjfSVFgS
    wwHCHLtLwnzNHVTZZV
    rJLtZtLZcCrvJwcbrGLvrcDQDhPldhGdmmPRQhhRBlPM
    zShzVhbqlbpbRNRscBNwCc
    DfmFWnfmnMFDdngdngvJFHgQQNwNsHHCQCwNTTzRcN
    FFFZMWWZZJMmJJMFFpztlPtSllLVphttGZ
    gWhGwmwQGhVwGzBMnDFmdmDDLbCnLn
    tRRHNHHlPHPfPltllNNNRsVPFrTrTbrMMTTDMdLFCrFdPP
    HvRvvHNpNvfqSshwqwVQZWhggwhw
    jDDRDVqNsRMMVFjFbtzpBlpllCBlhSLHSStH
    JJWZZTwWcmZCzQShHhzhhm
    wTrgvTwccvdcfvJvWJrvJTNzNMfGNNGjFRsjNDbfVzDs
    cVWPPThWctcFRdQpzLTzBL
    NNCqwNSrsDqNSSgLgffDCNpBdRvvdpmHRQvBdBqvdzBB
    CgbffsDJsSsNgbgJrlcGhGtjnWcJPncjWL
    RwwTGRjGlwWNgjgfQVNmjj
    HJPdLhLzhbtbdLPLbHHJLdcfBffBgrFQVZgzvgBfvrvvmr
    cmchnhtPqLSJJbdPLntlsDGCTWWDsDRwWWWTwS
    DDDBsPGPbwhDcDcj
    rgfNgCmHMvrrttvtfmNLgrLcQQJTJhcnjTQHcZlwlQHnwj
    wgfLmgFgWdBFzSVR
    RwsbssJjnbJwwsGPPdDLfTDLLLWvWNDGDpWD
    zVtHqzHHVcBQTdpSgvQDSpTS
    HHhFCdrrHchmrhcmwsjZwRwMJlshJJJZ
    BdQgtJMLBqshLfNhbccfFhffNc
    DnVWvvpvWvzrpwRWDbTvbTjTFGlfFSfNSFHGmFGNFmnPlmFS
    wDRDZzVWVjrRVjzrQgQdbgCZLCsCQtbd
    jQSgWjQmFFvHmjHWVVpZbGlbGlfGpbfGGWpf
    zBPtTqzPBcdwrzPJwqCztTNvCGpbGfDnfhZpNGGZGZbG
    MTzPtcrcwzTttdBJwPvFVHjMLFHQMgsSLHvs
    BHtjmmTtmDtHZjMMdNzCzCWcWZsZdsZs
    JRRJVPLwQJrVMPJLVVwChpRRhcdzcNzhzChNdW
    SrFwfGwGSnnGPlBMDtjbllggBn
    rsMDTrgsBNBgMgDBhfhDghrtcRWJttcmGRWLGQQLJRrqRL
    lnVVjvPbwpndvVwlVCjVwtLcsmLLqWWtttlsmGGcmm
    SsjVSCZbgTBTfNZH
    wlddvlldlBzqSmStdqmmngwgDCgrpMpgCngrMCfn
    jVLTHGRHjjvPGcDrfNMbnpngVbpf
    RJRTTRZJLRJQZcGGHLhHvTdmBFWFtWzqdWWQlFzqBFWt
    HDgZHpZSDpBQdRpHHRsDBNNzTvfTQqcqNNTqTqPQvl
    rnMFFMFJwmNgvmfTzcfq
    CWMtjCWMCCLWrWVWJwBbpgtRZSHbddZHBDDb
    hjLWPZJpZptwJghSfgHTMTgRMR
    lCcrblcnlzqDsvbfffTRSMnffjHTgj
    sqscDcblGDDpWPwFGwjLLp
    plQtRqRlGpPPPLZtmtpttRtJjHJvddLTHrLHJJjbdHvrrN
    gcMgTBWBCTczjnvNznnbgH
    FBhSwsWFWDhQZQqTTZllsT
    WsVttWDbvbtRjDVtDbDbJjrjFpCCcBrSCwrrjwww
    nzHqGNMfHqMMwJLLsNBrNcBS
    qgnHflgzHlqlZzhnzssfzbZtmVvmTQvQdTtbbDbTvv
    RtQCBbJDFhJtQtZtCbMnVnPVfGPpJVJWWmwJPG
    NsczRsrdrNrjlcSTGGnwmGmnmVPWwmVT
    SHcljRHzNHHjSHcrgNslcczgZtDgMDBCvQQbhDBCbFBCFCCF
    dRTFRJTRTgJzSSJmzJfN
    jLbQllLvvvrQlLQBrvQmFBGzCFtPSMmSGCtPPF
    QjsvDvqlvrQQvnsLjDWghTwZWcccFdRVpc
    bWnDbMJMFbhZSfngpfpd
    HjcrlvjRjrjlLqTqpwQgpfSQgghZgvgf
    THNTjClLHDCCpWmbtC
    NpBNsnFMLBcPMZccbQGblWRgGZmbRWdW
    CqrJTHCvDfrfwwJHRBvRGvgQmvmlWtlR
    rHzJJJDDwJCqjHTwBLccMpFhshnSSsMz
    bqVqqrDMpLFbLpJJQDMjbpZndwsvwHHswvnvnnZslG
    hgfRghhBWgfzBgZvncvcGvWrnZsG
    fTSSSBtTzhPththRrrCBzVLqMMJQjVJJCLjFjjqjJq
    pQlCJQjVvVGGnjNqFbFP
    wTqtmSmTBhstmstTmWRSdLdfPdNGnhGhdPNnNnrN
    mzTZBwWTcSTsTmZRRmzTsVMMVMQMDJgVqqMgcJlVDl
    vVwCqdCDvMrlDJCqrDMrPdTFWwZNbRcbmZWQbRQZWZcQWm
    fGSfhfjHGBlhSpRmpZFZNbQWjj
    ntGlgSSGgStVqdMCDCJnqd
    TlTRCrhCpmnCRtMRRWbvMBfwBB
    DVdQcsccdczbtQBWvmQBBW
    PgHPNcmcqqTphlHTCGrT
    GVLCBmdLVtlrmqGCqrTCGnjGSfwzNfPzfNNGzSSw
    rMDcWMJsDWRvRcsZPwpJpSzjwwfFjfjJ
    hcsscQQsDcWbHbmLgTbVgTmlrbgq
    VwJndPThQQjdvbrb
    BHlzFFjlZGBBlZBDFSmllfGggLNbNvggtCgNrLQLbfvbfg
    SHSHHlZSGZSDHGzHssGmnjhjphJPPpPwnsJRwPMM
    QFFGpfGtwgtjwvpwpGGjjBHgqzNNllHRlRllNdBRJl
    SWVDWVrDhnWhnqVnWPrhcSldBJPsRMMdPHsRdJHRMMBP
    SWZZcmnnZnSCLZDZftFFCvbfTTqTCTQF
    TvZBTFZpshPggBNN
    bbctWQDjcnwtwDDDllQzLfgsPzqgrsTPLshWfP
    bwRbQRnmDwtbTjmwRJQRQVZHpCpHVdvpMHZZMHZJvd
    CfqzMCGvGqNrCFFNwcMBbnnbbtBbDStw
    sJjsTjvVjLVlLLbtHSnSSwQsDBSH
    dJlvLVgJTRVPWWjjggCzhNGzzGZdhqrdmqrq
    zGSHWGjzpRsWVfsNwZ
    BmPCLzPlJBBvQmLFQrwwrVtfqtqZtsvwfR
    hLLzlmmBPFFLJMlmgDTMgdSGbDgGHbSp
    ppngVjZwNZwwVJjjnnVVJJJpLrsgmsmrbctsLcLmscDggDsL
    vHvRzRPvQPPRqPTlffRTrssbtqmmtbcMcNrDrrtD
    CHWdWzWQzdChNVZjZZwB
    LjVFhwjbFggMdVggTVMNRWRGWqQWtRNWGlQW
    DCzCpJppzJJDScFBzvBGnRWGWrNRQNNWGtNGqB
    vFJSzDSszzzccSZHzDDJmvSJhVwLjfVTPZLfwLgjThLZwhVh
    FMSSNScRlSGzfqWbqqcpWBhpmW
    TrPrnQNnJwtQpmmpmbbL
    vwvCsJZZnnwVnVHsfNjDRgSjRzgRjZjN
    CRhsghlqlvjhPslQdrMndMTWdPnTMJ
    tcDNFDpDSDwDtHrSDwDtFmtpJzWTnzQJpzQGnGWQMWnnTGBd
    ZfFSmSfwcwcScZHtVRhRCqLqCfrVrrfg
    vHPsBzvRvhCzbwbnjHLVmVbW
    ggdlpZNdZdflWTGpVMjgVbqjVmngnVbr
    lNpfllFGpZTtclDZzSWQFCWWzChPzQhS
    ddbJQGsgJcQccCjjTC
    DDflHqNNNjCCPNbT
    LFpLzfzqHzLbLvtndJhs
    mHtbGdwzmtHZrtrHtHGwrmtcFgBFRsBFcdglRsfsdgJBNN
    WvpSVjCCTCSPVDqTVjLqJwWRcWsNlgBcBlfWBRfl
    qDwjvqjVTDDLSPpnjqVnzbhbZbrGMmHzbMHHhh
    cMrrVsdtCdVtwqdHgLjPLFLfcfZZJB
    zGSlGGvpDWWvbSSNTggZPPTTJLZPjPzJ
    bNQDWbjlGSGNnWGblbQDQCmdqhsMtrsVnCrtnwdnCt
    WZSnCCMMdMMMSJMSVZmmFqVjqjVwVjjc
    zvzTlQQQQTNGbmQTjqBjcwwwGgBHGwqB
    mthbtmlPhTrNzNhhPLzlPzWfWPJdRCWspPWSSRsWSnJp
    nmqsjNFqNLcVlPNvRdvPPv
    MrggHrMpbtTpgpDptlQRJJldVRPBsDQvvV
    grgrTzfTGSFGsGSCLc
    hjdjCfQCLdQcWMfDDQhLsLCjqvVqzzZZprBFbzVdvVnqnBbd
    NTglmJGJRnRZVrVvFr
    gPGgPJSTPJtHncnjWDhDMDhP
    ZWWqBqqmgFFDMTTWDMwwcW
    ddGPpJQPprRSCrQzJPJGjHDvssMTDZDwcHhMsHsMHS
    zNRGrCRRCjPpdGQJNglqntnbtgNBZtFqtt
    pslQSspQrqHfgMRl
    tJBTjsTLGMBGMFMg
    tDwnhZdnLdZDwczzcPvsVvVW
    nZnMSDnGtnzmzWZZcMmgMcHwFFVHhHwbHsVrwQhVhF
    dlTqNqfTjdJflCppCQQRHVwFRJrvJsFVQs
    LNTqBLPprpLLzWtSnMZBMDGm
    PBjlPvvcJlJzwqjnnjLnwm
    dMfdpVfVhGVfVpVTtWWbzwngLMLwMRCmgmLMmsww
    SWppdTrprThhrGVztcrllrQJZNlBZlrNZB
    TTrNcjGNWDdDPDpPjDPNrbmFPfQSFmfSMCmCfSmSSR
    sshhqshzBVnzHgwCMbCwcfmRFmRMbm
    gHVVnBzJcBgVhtZZtgJhpGrGNpvDpddvprNGrlTJ
""".trimIndent()

class Rucksack(contents: String) {

    private lateinit var compartment1: String
    private lateinit var compartment2: String

    init {
        val splitInput = contents.length / 2
        compartment1 = contents.substring(0, splitInput)
        compartment2 = contents.substring(splitInput)

//        println("Input: $contents | C1: $compartment1 | C2: $compartment2")
    }

    fun findIntersection(): HashSet<Char> {
        val set = HashSet<Char>()
        val overlap = HashSet<Char>()

        for (char in compartment1) {
            set.add(char)
        }

        for (char in compartment2) {
            if (set.contains(char)) {
                overlap.add(char)
            }
        }

        return overlap
    }
}

class ItemPrioritizer() {

    private val itemList = mutableListOf<Char>()

    init {
        for (c in 'a'.rangeTo('z')) {
            itemList.add(c)
        }
        for (c in 'A'.rangeTo('Z')) {
            itemList.add(c)
        }
    }

    fun getPriority(char: Char): Int {
        return (itemList.indexOf(char) + 1)
    }

}

fun part1() {
    val itemPrioritizer = ItemPrioritizer()
    var sum = 0

    for (line in puzzleInput.lines()) {
        val sack = Rucksack(line)
        sum += sack.findIntersection().sumOf {
            itemPrioritizer.getPriority(it)
        }
    }

    println(sum)
}

fun appearsInAllThree(str1: String, str2: String, str3: String): Char {
    val set = HashSet<Char>()
    val set2 = HashSet<Char>()

    for (c in str1) {
        set.add(c)
    }

    for (c in str2) {
        if (set.contains(c)) {
            set2.add(c)
        }
    }

    for (c in str3) {
        if (set2.contains(c)) {
            return c
        }
    }

    throw Exception()
}

fun part2() {
    val itemPrioritizer = ItemPrioritizer()
    var sum = 0

    for (lineList in puzzleInput.lines().windowed(3, 3)) {
        sum += itemPrioritizer.getPriority(appearsInAllThree(lineList[0], lineList[1], lineList[2]))
    }

    println(sum)
}

fun main(args: Array<String>) {
    part2()
}
