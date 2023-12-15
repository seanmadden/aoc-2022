package year2023.day15

val testInput = """
    rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
""".trimIndent()

val puzzleInput = """
    ffkfx-,nkg=2,hhjz=4,cx-,ssj-,bcl-,dkr-,lfdgqz=5,bszg=2,chcdl=1,mk=1,jhzm=4,mhxpj-,lrk=6,zvvpl-,rvlns=1,pls=4,vtr=9,hcm=8,cgs=5,zb-,qdhck-,zg-,fjr=1,sd-,nc=8,mtzc-,sv-,rrgmt=8,nb=3,rhq-,dj=8,xq-,nm-,jfpqck=4,szk-,lrfz-,scg=1,jbnmxx=1,xqf-,rvt-,xzr=9,tcbv-,xkq-,qmh-,gxsb=5,rz=9,lx-,xb=6,kznc-,tcbv-,fnsj-,kb-,mtzc=2,xts=4,bk=9,mdj-,gr-,zq=3,jpb-,xkq=3,bmm=3,ctxtc=6,gb-,jdhhv=6,zt-,jl=8,hzd-,hhvz-,flg-,kp=7,lfm-,hzd-,xf-,qlr=8,gm-,plt=1,pf=2,mc-,ckj=7,ghttl-,rs=6,vqsp=4,pdb=1,tkltl=4,pt=1,lfdgqz=8,mqn=1,bl=2,vjh-,jdhhv=7,sfbn-,lmc=1,bl-,jbbd=6,lsb-,vjh-,lfm-,bsxk=4,tt-,fjr-,sc=5,qhk=8,zb-,tttb=1,lm=8,jvlff=3,crhhxv-,tcrq-,mk-,sbc=1,fs-,mrd=6,tht-,tgps-,dxcx=8,bdjh=7,llj=5,msm-,dsgfp=2,zqkfg-,mlvmzx-,fg-,svl=7,rxvh=9,gld=3,sjdzq=2,tc-,dsj-,hlz=1,vm-,hpdd=4,rxj=9,vq=5,klgghs=3,fnzn=4,gdn-,qlr=1,ldmzqs=9,qmx=2,cr=5,bl-,rxj=6,trn=1,hnm=3,xr-,mdlh-,rg-,mv=9,qqv=7,sv=8,dt=7,sgb=4,msm=7,jttd-,msm=3,zjxq-,fg=6,hv=1,gz=6,tbd-,qbj=9,zrlbq=6,tmv=6,qdh=2,mdlh=7,hg-,mfl=9,tctq-,jbnmxx-,gdfj=7,rxj-,sbq-,dnl-,ckj=7,lpdqj=8,qmgtbt-,dkr=8,qjtjv=4,fnzn-,tc=2,bl-,rs-,sbc-,vhzz=3,krc-,lhmf-,szxt=7,sfbn=8,hhjz-,kjz-,rrgmt=8,sdx-,bps-,qzgqp=9,jbnmxx-,gv=1,zp=8,rxvh=8,lg-,tc=5,zl=8,kfpl=6,gdfj-,svl=7,mk=9,tnvp-,cp=9,xpnsl-,mqq=1,mqsqd=6,krqgj-,bq-,gbq-,rkq-,dkr=5,hbbr=7,tttb=6,lk-,rxvh=8,bv-,cdpp-,gzf-,jnmz=3,tclg=3,fs-,jhzm-,tcrq=5,sj-,rkq=2,bs=7,jft=1,hqb=7,dbtm=2,xdfc-,hlz=1,xl=5,lxm-,fr=4,xp-,jpb=2,nfknj=6,rlh-,dsj=8,rd=5,bmm-,rx=5,gzf=7,hbbr-,bx=5,plt-,mxg=3,xb-,ll=3,mrd-,hhlst-,vqsp-,tvqj-,qmgtbt=9,ttds=9,dt-,vfr-,rvt=3,zbknj=2,dpbnj-,ts=2,qqv-,rf-,mlg=7,jqm=1,mv=3,kfx=3,gf=5,ph=3,ll-,zp=4,vgsj-,snpn=1,kqsk=3,tcbv=2,rk=6,jhzm-,bmqf-,vfr-,kd-,bdjh=2,mqq-,qtp-,lk=5,bkn-,hxbb=6,zbh=9,gd-,sqpkcc=4,llj=4,dqph-,fdjb-,rt-,prdnlm-,xc=9,xqf=6,lpj-,xvqk-,bmt=4,jqm=9,nbb-,sbr-,btrhxr-,rm-,lvg-,kbx=3,gxsb-,xpnsl=6,qdqm-,nxgm=3,dsshxj-,ppx=2,nm-,psd-,xvs=1,qmgtbt-,tnvp-,hqb=2,fqz=8,xkl=2,tvqj-,vm-,rqsr-,ph=9,ph=5,ndtp=8,fzzl=3,kgl-,lxm=7,xb=5,zrs-,vjh-,msm=8,sqpkcc=5,vj=3,xl=1,zvvpl-,ffd=3,dq-,rlh=1,bmqf-,tn-,ph-,vg=2,xhk-,sbc-,rd=6,vqsp-,gcn-,dklgzm-,llj=3,cjs-,ql=1,xts-,ldmzqs-,nfknj-,rq-,lpj-,ffd=7,scg-,mkb=1,mlj=1,crhhxv=2,zqkfg-,vqsp=2,gld=8,cls-,dbtm-,lfdgqz-,scl-,qhk=8,kmh-,sc=3,zcv=4,gxsb-,qlr=3,ddsh=5,qmh-,jg-,bcl=6,bsxk=4,jrx=1,qdh=7,ffkfx=7,tht-,rs-,bmqf=3,bhz-,zh-,mlc=6,rq=9,rvt-,ck=4,qccdj=9,md=7,mlj=5,lt=6,fdzxn=5,vfr=4,tgps=9,mp-,nxp-,chh=8,svl-,dkr-,xjvq-,tlrqv=1,kbx=3,vgsj=7,gcmq=2,mc-,qp-,kthb-,vqsp=5,tnhbsg=6,hsf-,zrlbq=7,bs=2,chm=5,vsmsfn-,xnz=9,rbk-,qjtjv-,qhm=5,ctxtc-,fdd=6,rxj-,hhvz=3,kgl-,tfz=9,nkg=7,gz=6,nlc-,psd-,tn=5,chcdl=7,hdk-,fhf-,bhz=8,nqxvn=5,hlz-,xvs=4,szpztt=3,ffd-,ld=5,lpdqj-,tbd=5,vlv-,cjs=7,vjv=5,sqk-,hsf-,df=2,crhhxv-,zl-,hdk-,mg-,jbnmxx=5,zvvpl-,bnl-,zbd=4,sd=6,rk=9,pt=8,djpg-,mlc-,qv-,hv=7,zcf=1,vlv-,jdq=8,jc=8,jg=2,lxl-,qtp-,xts-,bv-,br=9,tkltl=7,qg=7,qhm-,dt-,lx-,ccbkfr-,qv=1,xkl=1,tctq-,jhzm=9,ntgk-,hf=4,sm-,kb-,hc-,zlnxqh-,tcrq=5,sbc-,mkb=4,kfx-,hlz=8,bx-,ns-,kgl-,jfpqck=3,ks-,vjv=6,zz-,df=5,jk=3,km=8,mdj=9,gv-,dqph=7,sgb=4,gdfj-,fjr=2,tn=4,sbs=5,rf=4,kb=4,gr=5,fnsj-,nkg-,tq=4,gktn-,tfh=4,mdrjjr-,rjp=2,fmv-,zfh-,hg-,mr-,sfm-,bqj=5,lm=8,kthb-,vp-,lsb-,vk-,sbq-,ghttl=7,xhrq-,xp=9,jrx-,sgb-,kfpl-,rfrb-,tgn=7,xts-,zvvpl=9,mtzc-,scg-,tnhbsg=5,lfm=4,gn-,mdlh=1,mk-,jcq=3,sndz-,cjs-,gncqzh-,dxhj-,qtp-,md=7,bctt-,fdh=8,gv=4,dfq=3,dbtm-,pctr=1,cvtn-,ts=3,ncx=5,kfpl=6,zrf-,vn-,tvqj=3,hplsf-,jdq-,chh-,rd=7,mlc=9,ffkfx=1,hn=8,rn=5,rmc=5,ghxnj=2,sfbn-,pdb=2,hnm=1,tnz-,tmv-,sqk=3,mlg=5,jnmz-,psd=7,kh-,tc-,dkr=6,klqr=3,kd=3,sdx-,qdh-,lt=1,zq=1,zq=2,szxt-,spj=4,ngz=5,bk=9,gdn-,vqsp-,ngz=7,xb=5,bcl=3,dbtm=4,llj=9,km-,zbd-,tc=7,mk=8,qbj-,tnvp-,jg=4,tkltl-,qjtjv-,zrf=1,zh-,ddsh=1,stk=2,fzzl-,mc=5,klgghs-,zrs=2,krqgj-,rrgmt=9,hn-,nqg-,sj=5,knb=4,kqsk-,cdf=3,llj=7,qgrsj-,zb-,gdn-,lsb=3,dkr-,kqsk-,xpnsl=1,kcn-,hllj-,tkltl=9,dsshxj=2,tp=6,dkr=6,tfh-,xq=8,dv-,zb=5,czm=3,hqb-,mhxpj=1,chcdl-,jttd=2,vcfg=9,ddsh=3,gf-,dv-,sndz=6,fs-,hf=2,snpn-,vp=6,htzlb-,mlg-,dq-,bptq-,lrk-,gpnx=4,mc=2,pls-,rq=5,gvzj=9,ttv=2,rvlns=8,sbs-,pmj=1,tbd=4,ck=6,bq=3,jqm=2,tnvp-,hc-,sfbn=4,rl-,lpj-,cjs=3,xl=8,vjh-,vs-,hqb=5,ts-,trn-,xdfc-,nn=5,vcfg-,lrfz-,qlr-,lsb=3,nc-,scg=3,tz=8,zbh-,tgn-,tnhbsg-,bsxk-,cls=2,jbl=8,zdxd-,pf=9,zl-,xvs-,vt=4,clh-,scl-,gq-,dt=8,ssj=2,cls=2,qccdj-,vfr=4,hcm-,cgs-,dj-,lp-,qmx-,ll=6,zcf-,tc=4,sqpkcc=6,dq-,nhgfr=1,mlj=1,czfnq=7,glg-,krc-,vfr=3,kxm-,dsshxj=8,stch=8,kznc-,gssl=8,mkb-,ttds=9,kxl=7,bdjh-,zrlbq=4,ntgk-,tmv-,jpb-,dq=4,rvt-,sl-,bk-,bl-,ngz-,gnf-,ccbkfr-,fqkpv-,cdpp=5,bmqf-,jf-,qdj-,nl=6,vsmsfn-,fcqr=9,tz-,jcq=6,btrhxr-,hdk=7,btrhxr=1,xrp-,gm=1,bcl-,xrp=5,bptq=2,scl=5,czfnq-,xvqk=3,xnz=4,sxx-,zt=7,xdfc-,dxhj=3,qdh-,hnm=3,gd-,vqsp=7,vfr-,lvg=2,gm-,dj=4,vtqh=9,gnf=5,rxj=8,ns-,dklgzm=6,bps=5,szpztt=5,nn=5,fcqr=7,bdjh-,bc=3,hgk=2,bps-,kxl=9,btjs=3,bps-,pjt-,km-,hn-,gbq=6,rlh-,mm=6,dkr=1,ggv=3,jvlff=3,vn=9,hhlst-,mlvmzx=8,dqph=2,tvqj-,xjvq-,zrlbq=8,dsj=2,qhm-,msm=4,lsb=9,vfr=6,bjt=7,lpdqj-,mm=9,tvqj-,sm-,lrk=2,xvs-,rvt-,gbq=1,dklgzm-,zrs=3,mfm-,mdlh-,jg=5,gld-,tn=1,dgsf-,gnhxr=2,mdrjjr=8,dsshxj=7,crhhxv=8,fqkpv=2,ttv-,kbx-,zbh=5,rvjp=1,sjvb=6,pzj-,qdj-,xzlk-,htzlb-,qmx=4,gnf-,mm-,fj-,lxm=4,kb-,qp=4,fqz=4,dsj=4,krqgj-,qbj-,ggv-,lmc=1,dnl-,gdfj=2,vgsj=8,mxqh-,tc=8,mdrjjr=6,mc=2,kh=3,fnsj-,zvg=1,jbnmxx-,km-,nxgm-,hn=2,gn-,slgr-,bfrcb-,gzf-,nxgm=5,gn=3,tkltl=2,vtqh-,bkn-,rvt-,xkl=3,zg=3,ghttl=3,gvzj=5,vj-,zcv=8,hlm=4,jvlff-,vt=2,vt-,glg=1,knbdx=5,hlz-,gr=1,pzj=8,gq-,jdq-,rxvh-,flg-,trmg=4,nl=5,kxm-,hgk-,bmm-,rvjp-,vt-,bdjh=2,dzk-,xl=4,sndz=8,ssj=5,sfbn=6,vcfg=2,lxm-,mc-,jnmz=5,mdlh-,mtzc-,dn=9,xhrq=2,cls-,gf=4,dgr=3,kmh-,zfh-,bc-,gd-,bhz=8,vjv-,dtsx=4,gdfj-,qhm=6,plt=2,zqkfg=5,jbbd-,ktp-,mrd-,mc=7,kgv=2,zrlbq-,rr-,br-,ggqcfn=7,rvlns-,zbd=1,lx-,dxcx-,vs=1,cx=3,crhhxv=8,fdd=2,zm=6,tq=7,xkl-,vjv-,szpztt-,kjz-,pmj-,drhc=8,xhk=4,qhm=1,dn=1,fdzxn=2,vs-,pmj-,vhzz-,gb-,tfz=7,bqj-,rlh-,mn=1,dh-,vjv=8,vs-,nqg=8,sc-,gzj=1,jdq=6,tnc=9,xvqk-,nlc=5,bbs-,ph=5,nb=6,fj-,mq-,jvlff=1,vjh=5,dgsf=3,rq=8,hv-,sqpkcc-,cgq=2,bck-,ql=8,lqd-,lmc=7,mm=2,lm-,tht=8,nbb-,xkl=2,qlr-,ggv=6,fdh-,mdlh=2,qdh=5,krc-,ntgk-,mq=1,sdx-,qmjk-,rlh-,hf-,zb=4,fdzxn-,cdpp-,xp=4,kb=3,qhm=8,dj=8,bmm=8,dt=1,klgghs-,trmg-,jhzm-,msm-,ld=3,lxm=5,tvqj-,sxx-,sbq=9,dgr-,xpnsl=8,zrlbq=9,pjt=4,bq=9,gktn-,cp=1,kbx-,qdj=4,sgr-,sc-,kznc=9,dq-,mq=6,bs=9,bmm-,zm=8,ncx=2,dbtm-,lxl=4,tb=4,dj=8,hnm=7,llj=2,mqn-,kp=4,gdj=2,sj=2,tgn=2,ncx-,ngz-,bjctf=9,hzd-,zbd-,sbc-,zfh-,kxl-,jzr-,ll-,rrg=3,scl=1,xzlk-,kd-,xkq-,rvlns-,gpnx=6,mq=4,jc=5,kj-,vhzz-,dxcx=2,bkn=9,ntgk=4,bctt=4,kj=9,jhzm-,btrhxr-,cdpp=3,xzlk=8,bb=1,gncqzh-,sbs=2,gld=1,gzj-,xh=2,mqq=6,kfpl=4,sl-,bjctf-,dj=9,rg-,hlm-,gq-,lsb-,mdj=1,gxq-,lxl-,ts-,ck=5,fj-,ttds=8,jnmz-,llj=7,jdhhv-,zlnxqh-,lxl=2,mdlh-,klgghs-,bszg-,vhzz=6,qdh-,kmh-,svjl-,kgl-,rvlns-,kfx-,pls=6,lsb-,jdhhv-,trn-,rr-,nqxvn-,mv=2,tt-,zcg=1,vj=8,klgghs=2,kd=9,trmg-,hrql-,chcdl=9,cr-,rxj=4,tgn-,ddsh-,tht=9,fdd=4,hllj=9,tclg-,xf-,ckj-,stgrl-,gb=3,czfnq-,nxgm=4,mlvmzx=1,chm-,jbl-,snpn=2,gzf=8,nxgm-,gzf-,chh=5,lg-,sbs=5,jdhhv=9,rrgmt=6,dn-,kqzsf-,btjs=8,bjctf=5,mlj-,jk-,sbr-,tmkz=2,jrx-,rs=8,hc-,qt=6,ggv-,xhk=9,gb-,gdj=8,sv=4,gcmq-,gssl-,nhlr=7,czm-,bctt-,qmx-,dbtm=5,dzk=5,jj=5,vq=8,bqj-,tl-,bb-,nfknj-,tnhbsg-,lk-,dq-,mlm=4,fdzxn=1,cp-,xf-,gn-,jttd-,stgrl-,fr=2,jcq=9,hgk-,stgrl=2,plt=2,ghttl=7,mdrjjr-,zrf-,ppx-,vfr-,jfpqck=5,km-,fnzn=6,rl-,sxx-,mdj=6,vt-,hxbb=6,rmc-,hrql-,xrp-,mlvmzx-,msm=8,tkltl=3,psd=8,cx-,tfh=8,zbl=4,zv-,fls=7,dxcx-,bl=2,dj-,mqsqd-,kdf=6,hgk=8,np=8,fdd=8,spj-,hlm-,mr-,cdpp-,rd-,tclg-,nf=1,qt-,lvg-,jf-,tq-,dgsf=4,dpbnj=8,lpdqj=6,zbh-,lfdgqz=1,kjz=8,dzk=9,rrgmt-,jg-,rz=8,tq=9,hdk=9,mxqh=5,sj=9,jrspg-,ckj-,knb-,ccbkfr=3,stgrl-,lx-,kgl=1,dnmrp=7,xts=1,gncqzh=7,llj=9,mxqh=9,zfh=4,sc-,lm-,qt-,zcg=5,dsshxj=5,kqsvsl=7,chh=9,gm-,rlh-,rvlns=1,mlvmzx-,dsshxj-,kp-,xq-,ll=2,vs-,gd=7,vnnn=7,jf-,cj-,jfpqck=4,fls-,sbq-,nl-,rqsr=4,xpnsl-,zbd-,xpnsl=1,gf-,dkr-,sbs-,mh-,jpb=4,kxl-,jvlff=7,chcdl-,nvv=7,hvr=3,gdfj-,ldmzqs=9,dpbnj=9,tlrqv-,zqkfg=4,xkq=9,ph-,jcq-,nhgfr=7,zb=4,zp=1,zjxq-,ddsh=4,fls-,fmv=3,tclg-,gr-,hhlst-,sdx=9,ctxtc=7,mhxpj=5,qmjk=1,kdf-,gnf-,kj-,dv-,ljqg=1,tt=9,lsb-,tfz=6,jk-,fdjb-,vcfg=1,rxvh-,hsf=1,lh-,bc=4,sfbn-,qjtjv-,mlg=1,knbdx-,stgrl=4,jbnmxx=7,gzj-,ql=1,xvqk-,klqr=9,qdj=3,krqgj-,hdk-,lfdgqz-,mh=4,hrql-,gssl=6,mrd-,dtsx-,tt-,gpnx-,vjh-,tl-,zzkbj=4,svjl-,fdh-,rxc=4,kdf-,rt-,knb=1,hbbr-,dh-,mxg-,hplsf=6,mtzc=6,mh-,mhxpj-,xq-,nfknj-,nlc-,bq=7,sbr=6,crhhxv=8,stgrl-,pjt-,lcxlk-,jft=4,hb=4,pmj=5,sdx=7,gdj=8,nvv=2,mc=6,xh-,mrd=9,rkq-,sgb-,gz-,flq-,knb-,lpj=7,qv=9,fls=9,mlc-,gq-,sfm=6,mq-,xp-,nxp-,gpnx-,tvqj-,vk-,trn-,hgk-,xp-,krqgj=4,fnsj-,kcn=7,bnl=7,scl=9,jdhhv-,mlj-,dqcn-,zp-,xc-,kgl-,zv-,kxl-,tmv=3,ljqg-,tz=4,mxg-,nvv=8,ssr-,rs=3,snpn-,tfh-,ct=5,bmt-,gq-,kqsvsl-,jttd-,bck=6,vpx=6,bsxk-,sqk=5,lrfz-,dh=3,zfh-,dj-,dfq=9,xnz-,ct=4,gpnx-,mqsqd-,qgrsj=1,vfr=3,sfm-,zq-,hpdd=2,tq-,xjvq=3,krqgj=2,cls=7,gd=2,tclg-,zdxd-,ghttl-,sgb-,bnl=4,lrk=4,ctxtc-,clh=1,rvjp=4,mqq=9,xvs-,gnf-,rqsr=7,ldmzqs-,qt=6,sndz=4,mfm-,dqph-,hgk=3,dgr=3,mlj-,tvqj=6,kzf=6,zdxd-,xzr=7,xzr-,kmh=6,zbfqfn-,mxqh-,slgr=7,kfx=7,trmg=2,qjtjv=2,mqsqd=4,pls-,sjdzq-,mv=9,zz-,bkn-,dxhj=3,rvt-,zbl-,jpb-,sjvb-,lpdqj=4,vtr-,nm=6,tz=4,rf=5,nkg-,rjp=3,hplsf=7,rxvh-,kbx=1,zbl=7,gdn-,jqm=5,kfpl=8,cp-,qqv=5,lpdqj-,glg=1,hb=7,xh=2,zq=3,rl=4,bk-,djpg=8,ccbkfr-,vs-,ddsh-,ccbkfr=6,vpx=8,nhlr-,btrhxr=8,qmjk=9,mc-,bb-,sd-,vhzz-,flq-,pzj-,qg=6,kxm-,bmm=4,nxp-,qbj=9,tnc-,bptq-,xpnsl-,nf=5,ttv-,tnz=8,dbtm-,cp-,kcn-,gxsb=5,fk-,sqpkcc=7,fs-,vhzz-,mqsqd=9,chcdl=6,vtqh=6,zbfqfn-,gdj=5,gdfj=3,zcf-,nm-,vp-,bmt=2,lxl-,gz=6,qhm=6,ncx-,ctxtc=5,nqg-,dh=9,ljrcd-,czfnq=3,bjctf-,zjxq-,mp-,lh=8,dv-,fcqr-,rjp=5,fdjb=7,kfx-,mq=8,hplsf=1,dqph-,gdj=5,fdzxn=6,sj=7,hhjz=8,rxvh=2,md-,qmh=6,dsshxj=6,rrg=5,lqd=7,gdfj-,lqd=9,mqq=1,mqn=8,ngz=7,xb-,vpx=4,lk=1,mr=9,hc-,dtsx-,ct=9,xp-,md-,hzd-,vbqff-,mn=1,ql-,jfpqck=3,nbb-,br-,lcrh-,ffd=5,rd=3,lmc-,lg=9,btrhxr=1,jhzm-,qp-,mqq-,mxqh=7,xzlk-,rl-,rvjp=9,jrx-,mfm=6,bszg-,xzlk-,kqsk-,flq=8,jbl=9,xf-,zp-,rm-,qv=2,fs=9,lqd-,ld-,klqr=6,dt-,dsgfp-,rrgmt-,scg=1,ht-,mlvmzx-,bk-,gnhxr-,jdq=8,rbk-,ql-,rd-,mp-,gcmq-,gnhxr-,bcl-,rxc=2,bzr=7,vtr=9,hrql=7,nfknj=1,dh=3,df-,mdj=6,stch=6,zv=7,ck-,ffd-,qtp-,xhrq-,chcdl-,qtp-,nqxvn=1,vj-,chcdl-,klgghs-,lrfz-,prdnlm-,lcrh-,nhgfr=2,zv-,hlm=5,mtzc=3,zdxd-,kgv-,bq=1,xqf-,sbs-,kbx-,ph-,gdfj=4,qmgtbt=5,gld=1,qdj=8,hdk=3,vqsp-,mhxpj=7,xl=1,xpnsl=2,slg=5,rvlns-,fgs-,br-,tnz=2,sbr=5,lm=2,mlvmzx-,jpb-,lrfz-,lrfz=3,ccbkfr-,hzd-,zvg-,ggqcfn-,kzf-,vjv-,gpnx-,lvg-,lh-,jnmz-,bptq=8,nkg=2,lcrh=3,dnmrp=7,jhb=9,sbs-,zvvpl-,kqsk=2,hcm=5,zjxq=9,lh-,gnhxr=4,ssj-,hhlst-,chm=6,fjr=7,sj-,dxhj=2,rt-,mr=6,tnhbsg=9,np=8,dgr-,vsmsfn=4,lxl-,jrx=2,fp=1,rkq=1,xh=7,tq-,qdqm-,kxm-,fqz-,zbfqfn-,jcq-,mlg-,lcxlk-,qdj-,lvg-,bmm=7,tfh=7,kfpl=1,ql-,bl=2,jdhhv=2,dv=3,scg=7,lpj-,xf-,xjvq-,pmj=6,vfr=9,bfrcb=1,slg=7,pjt-,tctq=6,kfx=1,djpg=8,jl=8,dsj=7,rmc=8,zfh=6,kbx=1,kjz-,zrlbq=5,lk=1,qmh-,xts-,ghttl=9,bkn-,sbr-,klqr-,kj=5,hlz-,ljrcd=8,vq-,zqkfg=9,bdjh-,szk=9,klqr-,gf-,fcqr-,tbd=9,xpnsl-,rrgmt-,hbbr=3,kp=5,ljrcd-,bb-,nc-,rlh-,tz-,ct=2,qt=7,bx-,jvlff=8,nvv=3,ngz=7,gs=1,bjt=9,qg=9,scg=8,xl-,sbr=4,ncx=2,fr-,ks-,bnl-,bck-,lxl-,mkb-,rk-,lh=3,zcg=4,gpnx-,gncqzh-,kbx=3,gdfj-,bnl=5,qg=3,dpbnj=6,zbd-,sbc=8,np=6,rbk-,ghxnj=4,br-,bjt-,fdjb-,jzr-,nbb-,jft=1,dbtm-,rxj=3,nxp-,vsmsfn-,dv=3,sbq=2,hrql-,fj=2,rg-,hvr-,mn=9,vcfg-,vt=2,xkq=3,gvzj-,gld=6,qccdj-,lcrh-,qdhck=7,bptq=8,vtqh-,kznc=9,jhzm=5,ssr=6,lcxlk=6,tc-,bps-,lrfz=9,hb-,gn=1,sd-,rvt-,xp-,jqm-,dgsf=8,zdxd=9,hgk=2,kj=9,tq=8,qmh=4,sv=6,jk-,klqr=3,dt=1,lk-,gr=5,kbx=9,kqzsf-,kd-,lrk-,zbd=8,br=5,jfzn-,bszg=6,rrgmt-,qp-,bzr-,jnmz-,ctxtc=7,qbj-,jrspg=6,nf=8,zcg-,gktn=7,dsgfp=2,sl-,qccdj=4,tl=9,ffd-,jbl-,mdj-,kb=1,mqq=6,xkl=8,jfpqck-,hbbr=5,ffd-,tmv=4,rz-,lfm=8,nvv=3,hn-,dj=9,scg-,gbq-,lh-,qzgqp-,mr=5,xrp=3,lvg=4,pzj=2,zvvpl=6,kfpl=1,kqzsf=2,sj-,tfh-,cr=4,qgrsj-,vp-,tlrqv=8,vq-,kmh=9,svl-,hnm=2,sl=3,qdqm-,dtsx-,vgsj-,ljqg=4,ppx=8,tnvp-,tvqj=2,np-,sgb=1,zg=9,zbknj-,hn-,bdjh-,vnnn=1,kfpl=1,flg-,mtzc=1,snpn-,fp-,gncqzh=3,tq-,lt-,lg=5,lxm=9,tctq-,mfm-,rm-,tht=9,ph-,fk=9,rfrb=2,dsj-,rfrb-,jqm-,br=9,xzlk-,chm=1,xvs-,zlnxqh=9,nb-,tbd-,xzr-,kj-,ph=7,vnnn-,nl=7,lt=9,zrs-,xhk-,ppx-,nc-,dqcn=7,jhzm-,jttd-,fk-,sqk=9,rx-,sxx-,klgghs=3,stk-,ffkfx=8,mdlh=6,mlc=1,szk=1,tfh-,nqg-,kp=8,nm-,stgrl-,fhf-,xnz=2,jj-,gvzj-,sbq=2,lp-,jrspg=1,jc=5,fmv-,zvg=1,hnm=9,nhgfr=3,gzf=7,tz-,ssr=1,tcrq-,xr=6,lcxlk-,gb=3,krc-,sgb-,lrk=2,mlg=7,gf=6,htzlb=1,vtqh=2,sbq=8,qjtjv-,dnmrp-,ctxtc-,rf-,dt-,qzgqp-,hcm=9,dsgfp-,zzkbj=2,lsb-,ttv-,xpnsl-,jf-,tnc-,scl=2,sdx-,snpn=7,kbx-,vq=3,msm-,tt-,ngz=9,xnz=2,hcm=6,ct-,stgrl-,fdh-,fs=4,nxp=5,ddsh=9,ll-,vbqff-,jrspg=1,kxm-,rjp-,zzkbj-,dn=5,rrgmt-,gnf-,zv-,zfh=1,xqf-,sxx-,xhk=7,tq=9,sgb=2,kbx-,mhxpj-,md-,rl=1,zl=9,tnvp=8,qbj=2,nxgm=1,jg=2,scg=5,ctxtc=6,vtqh=8,jbnmxx-,crhhxv=5,cjs-,bfrcb=2,nqg-,kcn=6,kjz-,gbq-,qp-,ddsh-,nbb=3,kdf-,dnl-,ppx=6,ts-,lvg-,fgs-,hn=4,snpn-,dkr=8,qdqm=4,tvqj-,zrs=7,xkl-,mkb-,svjl=2,gb=2,rd-,tttb=1,kqsk-,bfrcb-,fs=6,glg-,mq=2,bbs-,zt=8,lxm-,qmh-,jbl=6,svjl-,fcqr-,mlvmzx=8,fgs=6,rr=4,vqsp=9,nc-,scl=9,djpg=5,cgs=1,gdj-,xjvq-,tnvp-,bq-,fqz-,mkb=6,qccdj-,kdf=3,jft-,jbnmxx=4,kj-,sc-,dv-,vgsj-,pctr-,dsshxj-,mkb-,hbbr-,vj=3,rvt=8,nxp=1,mqq-,rrg=9,tgps=7,nc=8,bjt=5,qhm=9,nn=9,rrgmt=7,zrf-,flg-,rvjp=2,kj=6,sxx=8,vtqh=8,bps=9,vhzz-,tcbv=8,kfx-,lvg-,gbq-,rd-,ttds-,ggqcfn=3,nb=3,pjt-,mlg=1,tk-,tcbv-,dxcx-,dnl-,xc=3,fnzn=5,zvg=5,snpn-,bptq=7,bctt=3,bs-,bc-,vsmsfn-,xqf=3,jhzm=5,vhzz=8,dgr-,nqxvn-,bkn-,fj-,gnf=4,mlj-,nlc=5,dn=7,qdhck=2,lh-,zvg=3,ks=6,ljrcd=8,kp-,stch-,jzr=1,rjp=3,jvlff=2,rxvh=2,rz-,nqxvn=2,nkg=4,kd-,xq-,lfm-,ccbkfr-,xf-,fls=9,sm=5,bkn=6,bps=1,knbdx=8,kh-,fnsj-,fnsj-,tk-,gnf-,fgs=9,nkg=4,hdk=4,gktn=5,cvtn-,tmkz=6,sc=4,cx-,xdfc=4,rmc-,krc-,zp-,hb=6,nc=9,mlg-,jc=8,kfx=4,qdqm-,lk-,szpztt-,sbc=8,scg-,kjz=4,dsshxj=5,rxvh=5,cgs-,tk=9,nbb=7,gd-,pjt=2,sgr-,scl=9,nqg=7,tkltl=6,zzkbj-,ll-,pdb=8,lg-,qdqm=4,xh=8,sgb=4,fr=3,cls=8,df=8,bfrcb-,rg=9,tq-,fnsj-,gr=3,spj=4,qqv-,zbknj-,hg-,lm-,pls=9,spj-,xzr-,hhvz-,dzk=2,kfpl=6,jk=1,mp=5,jft=2,vjv=9,gvzj-,vtr-,km=3,jbnmxx-,qccdj-,sd=7,dkr=7,rfrb=6,jk=6,cr-,rd-,mxg-,ljqg-,zcf=3,bjt-,jbnmxx=2,zt-,rvt-,hcm-,ql-,mfl=7,stch-,mlg-,mdlh=4,chcdl=9,kjz-,tclg=4,vjh-,bk=6,hbbr-,nhlr=5,btrhxr=6,hc=8,rr=2,mtzc-,drhc-,tcbv-,bx-,mlg-,nlc-,ph=7,br-,ns=5,tt-,xq-,kgv=8,rrg-,bqj=4,hhjz-,sxx-,sfbn-,gf-,crhhxv-,mqsqd=3,spj-,fk=8,pzj=7,fp-,jdhhv=8,dq-,mrd-,fdzxn=2,dt=6,xr-,gssl-,xjvq=9,glg=3,gcmq-,vpx-,mrd=1,jbl-,ljrcd-,gcn-,zlnxqh=6,jcq=2,np-,ks=3,gnf=4,jrx=2,hhlst=2,tnz-,tnvp-,ks=3,jrx-,jf=8,rfrb-,ntgk=4,bx=5,rxvh-,mr-,gld=9,zrs=4,btjs=1,ql-,gssl-,kdf-,lcrh-,fgs-,mr-,nl-,tclg=9,zfh=8,sjvb-,szk-,xzr-,scg-,hllj=1,tq=7,jf-,mk=5,gzj=4,dxhj=8,sbc-,vfr=5,gbq-,zrlbq=8,gq=7,xvs-,jbnmxx=6,bszg=9,hbbr-,kqsk-,mh=5,zlnxqh-,spj-,bx=1,ttv=1,fdjb-,kbx-,jttd=6,gq-,fjr=5,fk-,dfq=4,mp=4,dfq=7,tfkbpp-,fnsj=3,mxqh=5,ssr=2,dqcn=6,kcn=7,rvt=5,cdf-,qg-,dgr=3,rl-,km=6,qtp=8,ldmzqs-,gxq-,dnmrp-,rvlns=9,gcn=3,zbh=1,tnc=8,btrhxr-,gz=7,tcbv=2,lpj-,sjvb-,szpztt=4,bptq=7,rhq=1,fzzl=3,czfnq-,pjt=5,nfknj-,lfdgqz=6,kgv=7,fjr-,qmjk-,br-,kfx=1,hhvz-,bps-,mxg=2,plt=5,fmv-,mhxpj=6,dsj-,mcdg=7,kj-,gld=9,dpbnj=2,rvt=8,pjt-,xh=9,dqcn-,hxbb-,lsb=4,drhc-,mhxpj-,cdpp=2,clh-,xjvq-,vn-,lfm-,rxc-,sbq-,fls=8,jttd-,nl=5,gncqzh-,hlm-,jfzn=7,ssj=7,hdk=5,fj-,rxvh-,tht=5,tp=4,tmv-,ndtp-,sxx=7,xvqk=8,rrg-,fdjb=6,hsf=4,pmj=1,rm=1,lhmf-,sfbn-,kznc-,tclg-,fk=5,qdj=2,pls=3,hlm=9,ffd-,fgs=5,slg-,bdjh=3,qhm-,nb-,vjv=7,hf-,tfh=9,rk=8,zrlbq=4,gz=4,vgsj=8,mdlh-,sj-,hcm=6,vq-,nxgm-,lmc-,gf-,kqsvsl-,ncx-,dxhj-,tmv-,mqq-,kdf-,hbbr-,gcn=5,xzr-,szk=9,pzj-,ggqcfn=8,lfdgqz-,zrf=7,dzk=6,zg-,tbd-,sbc=4,tnvp=6,cjs-,nhlr-,lm-,sgb=6,ncx=2,jdq=5,qgrsj=8,chcdl-,sbs=6,vt-,dbtm=3,lxl=8,rkq-,xh-,ssj-,br=1,ktp-,zm-,gzf-,zcf=5,dxhj=4,vvsj-,ns=1,rg=9,vhzz=9,dxqlgn-,hllj-,hllj-,cj=7,btrhxr-,rfrb-,ht-,cr-,df=6,xhk=7,slgr-,fr=1,jbbd-,jbl=6,plt=4,klqr=4,qmjk=9,fdh-,kfx=3,gnhxr=7,bkn-,hqb=1,nqxvn-,vs=1,sfbn=3,bc-,mlg-,svjl-,xc=5,sfbn-,qt=7,lmc-,gf-,lp-,ljrcd-,cjs-,hc-,dsgfp-,hn=5,dv-,gv=6,jg-,sjdzq=1,rz-,lm=2,fj-,jfpqck-,gdn=6,fjr=9,xqf=5,tfh=4,vp-,zzkbj=4,bc-,fg=4,bjt-,llj=5,tlrqv=1,xhk=3,xzr=8,mdrjjr=9,nhlr-,kgv-,xqf=1,kgl-,gs=5,ks=3,kmh-,klqr-,lhmf-,vq-,cjs-,tttb-,zrlbq-,rrg=2,qdhck=6,pls=2,hxbb=4,mqn-,vsmsfn=9,jg=3,flq-,dj-,drhc-,chcdl=4,lrfz=5,jrspg=3,lfdgqz-,lqd=9,spj-,gcn=9,dzk=7,vsmsfn=7,hrql=6,lpdqj=2,ljqg-,vhzz-,ccbkfr-,cdf=6,fdjb=4,mxqh-,krc-,vn=3,kmh-,fg=9,zcg=7,bv-,fr-,dsgfp=9,knb=3,kd=1,hgk-,lfm-,qp-,bzr-,dj-,xp=4,zcf-,zbl=7,bptq-,xvs=5,qhk=2,jrspg-,dzk-,nlc-,fqz=5,czfnq-,gv=5,rxc=9,np=3,knb-,zvvpl-,qhm=8,mtzc=8,lxm-,sfbn=1,trn-,kzf-,mrd=5,dj=4,jg-,dfq-,sgb=2,zjxq=9,rvjp=6,bck-,jhzm=2,xc-,bsxk-,ghttl-,zrs=8,gxsb-,scg=5,msm-,bmqf-,ncx=6,bb=3,gvzj=9,rr-,pjt-,cdpp=4,tctq-,qmjk=1,tp=3,ht=6,jk-,cdpp=8,lh-,rz-,lpdqj-,rl-,qbj=2,jdhhv=5,hhlst-,tl=7,jft-,qzgqp=3,rf=6,tcrq-,pf-,kh=1,trmg-,sfm-,jl-,rbk-,bctt-,xzlk-,mlvmzx-,hb-,rd=6,xh=8,lxm-,szk=4,qdj-,dxqlgn-,chcdl=5,ctxtc=8,ccbkfr=5,rt=3,nc-,hplsf=3,qdh=9,szpztt-,bcl-,sfbn=2,xdfc-,lx=4,hb-,rxj=9,fk-,zbh=5,sxx-,ckj=1,hrql-,dnmrp-,jj-,xpnsl-,vqsp-,dbtm=6,qg-,kzf-,spj-,vnnn-,hb=7,jdhhv=9,rqsr-,gpnx-,lp-,nl=6,lpdqj=1,chm-,tc-,cjs=1,sbc-,tmkz=1,jf-,dnmrp=1,bptq-,tbd=6,mqsqd=7,tq=7,dq=8,tgps=9,mq-,dkr-,sl-,kqsvsl=7,xp=7,ggv-,cgq-,mtzc=9,cx=1,cdpp-,mlc-,xts-,kdf-,hhjz-,jdq-,fzzl=7,qccdj-,tk=3,rbk-,df=9,hhjz-,jpb=1,fcqr-,zvvpl=4,vm=8,vs=7,kcn=8,szk-,mhxpj-,lfdgqz-,hb-,nm=5,lcxlk-,dtsx=7,sqpkcc=9,fjr=1,ssj-,cj=4,hsf-,tq-,ljqg=2,mq-,knbdx-,ndtp=9,mtzc=3,sj-,mlc=5,hplsf=6,ns-,dq-,zh-,lxl=8,ghttl=7,ddsh=3,fhf=6,xdfc-,tcrq=2,nn-,sdx=1,xnz-,rkq-,tnhbsg-,cls=5,cr-,fdh-,pjt=8,ngz-,jcq=8,fk=4,mfm=1,qdj-,dqcn-,lcrh=7,jj-,vlv-,spj-,vcfg=7,prdnlm=8,krqgj=8,djpg=5,vcfg-,vnnn-,cjs=2,mlvmzx=9,tttb-,psd-,zfh=8,dbtm=9,gcn=8,ntgk-,mdlh-,hllj=5,xr-,vk=7,kxl=9,gb=9,gzf-,trmg=9,bck-,cls-,nbb-,bps-,jnmz-,dgr-,bnl=2,rr=6,xvs-,hcm=3,pt=3,stch=5,dq-,ht=4,zzkbj=6,sndz=1,fdjb-,zqkfg-,fjr=7,rvlns=8,plt=5,sgb-,cp-,sv-,kd-,nbb=8,tclg=2,jfzn-,jrspg=5,hb=3,knb-,hxbb-,stgrl=3,xh-,cr=4,dsshxj=6,ffkfx-,mkb-,mv=4,hhjz-,jcq-,rxvh=7,lp-,zt=2,rs-,ggv-,ttv-,flq-,qg-,gdn=1,qgrsj=4,lfdgqz-,zrs=2,xq=5,zbknj-,vvsj-,kxm=3,hn-,gktn=7,rhq-,zjxq-,ll-,llj-,nn=5,ttds-,zb-,vg-,slgr-,nlc=1,bs=8,zzkbj-,sndz=9,ttv-,zfh-,ccbkfr=6,ddsh=5,hplsf=7,kfpl-,psd-,nkg-,fls=7,lmc=5,rd-,vq=2,jl=1,sxx-,vgsj=2,hhlst-,jrspg=6,gd=6,snpn-,tq-,svl=3,rrgmt=4,qmx-,jf-,mqn=8,dsgfp-,gncqzh-,rr=2,zl=7,rr-,tttb-,hnm=9,cp=3,tt=6,sm=8,fdjb=8,rs-,gv=8,cvtn=8,zcv=5,gf=1,knbdx=4,clh=1,rf-,mqq=2,gxsb=4,lmc=1,snpn=3,tnc-,xzlk=7,jfzn-,dt-,mg=6,svjl=7,lfdgqz=1,bq-,dh=1,gnf=1,kb=9,br-,jrx-,jrspg-,rg=7,tfh-,hf=8,kqzsf=3,fs=1,cjs=6,gz-,jl-,ghttl=3,jf=7,hxbb=9,mg=1,rq=3,ljqg=8,zcv=1,ljqg-,szxt=2,nkg-,kh-,dpbnj=7,zb=3,hc=1,knb-,fhf-,gf-,tmv=4,dsj=8,tn-,zrs=4,vvsj=1,bk-,qmh=8,zjxq=4,lx-,kfx=4,scg=1,hc=6,gpnx-,slg=1,tc-,tht-,rxvh-,pdb-,zbfqfn=3,vtqh=8,jfzn-,plt-,hxbb-,gr-,qgrsj=8,dxcx-,lp=7,hllj=6,pls=9,mfm-,svl=5,gktn=8,fls-,rm-,gcn=8,jbl=3,qmgtbt-,cdf=9,crhhxv=7,gn-,tq=9,jhb-,mrd-,dgr=3,sfbn-,tttb-,tl-,gdn-,rvlns-,mdlh=3,szk-,bcl-,hlz=1,fls-,mg-,xjvq=4,nfknj=5,lmc-,gnhxr=3,cdpp=2,fdzxn-,mhxpj=6,tfz-,sgr-,kj-,chm-,kgv-,sc-,sbs=4,knbdx=6,mqsqd=1,qt-,ffd-,flg-,fp=4,kqsk-,vtr=8,qp-,mh=6,bs=2,vp=1,hdk-,lcrh-,ql-,rvjp-,mtzc-,ldmzqs-,ctxtc=9,vjh-,dv=2,nhlr=1,jvlff-,bk=1,vqsp-,xkl=5,rfrb-,zp-,dklgzm-,fr-,bc=7,kfpl-,lrfz-,hhjz-,hhjz=2,spj=9,fqkpv=7,gxsb=9,ld-,hrql-,xr-,fjr=8,fnsj=1,ct=8,gd=1,bzr-,jzr-,zzkbj-,psd=7,sdx=3,lfm=6,kj=3,bsxk-,dn-,vt-,hg=1,tp-,df-,pf=3,xl=4,mm-,vvsj=3,glg-,hhlst-,nhlr=3,fdh=2,sv-,qhm-,lxl=3,cjs-,qccdj-,sbr=2,hsf-,mdj=6,tkltl=7,jfzn-,qdhck=7,xp-,ccbkfr=5,tcrq=9,gld-,ljrcd=5,fzzl=1,vs-,scg=3,xts-,rr-,bmm=3,rr=1,bc=1,xb-,lh-,ffd-,vn=4,ct-,bk-,sgb-,tcrq-,rt=7,sjdzq=6,fnsj-,fgs=3,gf=3,zbknj=8,fdd=3,vj-,sqpkcc-,rgghm-,fqz-,bkn-,cdf=4,stch=6,vtr=2,bptq-,slg=1,kgl-,bfrcb-,fmv-,ctxtc-,ktp=8,jj=4,ldmzqs-,gn-,qt-,fqkpv-,ghttl=7,lh=4,sdx-,gs=7,bkn=3,jc-,ckj-,bmqf-,qmgtbt-,mtzc-,klgghs=4,lcrh-,tb-,dxhj=3,jbl-,zrlbq-,rd-,gncqzh=8,tkltl-,kb-,lx-,mfl-,tttb=1,dbtm=7,jvlff-,hsf-,psd=1,jc-,mp-,gcn=8,jdhhv=4,hlz=5,md-,lcrh-,mdrjjr=6,flg-,czfnq-,rrg-,ns=2,zm-,sqpkcc=9,rfrb-,mqsqd=1,snpn=6,glg-,gncqzh=9,jj-,dqph=7,lrfz-,tbd=2,rq-,hrql=2,zbknj-,nxp-,rjp=1,zqkfg=6,vn-,dxqlgn=1,kcn=1,zbfqfn-,lpj=8,bptq-,xdfc=9,mxg-,slg-,mlvmzx-,nvv=9,msm=3,gdn-,btrhxr=8,kbx=8,bx-,vtqh-,crhhxv=3,spj-,ljrcd-,jg=3,hsf=7,jrx-,zp-,mk=7,tvqj=6,gpnx-,nkg-,xhk-,bq=6,bdjh-,tbd=7,hxbb-,xhrq-,dpbnj-,dqcn=8,ssj-,gm=8,xnz-,sgb=5,fg=9,tmv=1,hg-,vk-,gld=8,fs-,lfm-,sqpkcc=6,jft=7,vfr=2,kp-,ggqcfn-,tp-,lhmf=3,lvg=5,krc=1,rk=7,fcqr-,xb-,br=4,bmqf=9,mfl-,mq-,gnf=8,cls-,krc-,cdpp=3,vjh-,df-,jg=1,zq=1,pdb-,mlvmzx=6,nqxvn=1,zrlbq=3,vfr-,xkl-,cls-,rxj=2,tnvp=7,szxt-,nlc=8,gssl-,spj-,kh=2,cx=3,hhlst=2,rr=9,kh=4,zq=8,cdf-,tp=9,tfkbpp=3,qdj=4,pdb-,xjvq=3,rr-,dqph-,hg-,sdx=8,rxc-,dj=7,dbtm=8,gs=3,hllj-,fqz-,zbl=6,jbbd-,zzkbj=9,qmgtbt-,hbbr=6,sfbn-,xrp=5,jrspg-,jrx-,hvr-,kfx=8,lcxlk=8,bmqf=7,bc=5,zbknj-,ll=5,xkq=5,rr=6,jhzm=7,slgr=9,dnl=8,fzzl-,jbbd-,tl-,sfbn=5,lpdqj=3,krc=6,rvt-,sgb-,vp=4,bzr-,qgrsj-,tlrqv-,sd=8,sfbn-,qhm=5,tht=1,bqj-,gktn=6,tl-,ql=6,kp=8,zrlbq-,dlt-,rx=4,ljrcd-,mqsqd-,xvs-,rd=9,rlh=9,msm-,bqj=3,sbs=3,gxq=6,qgrsj=2,xl=1,bmt=4,mlc=5,jrspg=4,mqn-,mkb-,ldmzqs-,mxqh=1,nvv=6,zm-,fdd-,gpnx-,spj=3,ph-,zbl=9,mqsqd=8,lhmf-,kp-,mq-,jdq-,kd=6,tmv=5,hhjz=1,hb=1,pjt-,dpbnj-,bfrcb-,rxc=2,ktp-,hhjz-,ntgk=5,jqm-,ggqcfn=1,jk=6,bjt=7,fj-,zbknj=4,tctq-,qhm-,xhrq=4,xb-,lpj=2,rvjp-,mlm=7,kh-,rk=1,dxcx-,pmj=8,fzzl-,qzgqp=4,zb-,clh=6,tgps-,fdjb-,ts-,nhgfr-,sdx-,gnhxr-,jpb=5,slg=9,bjt=2,kznc-,ntgk=1,hg=1,qmh=9,nc-,xq=8,lpdqj-,sbr=1,ggqcfn=6,spj-,flg-,klgghs-,dqcn-,ssj=8,kb-,qv=3,gb=4,mq-,xnz=8,zrlbq-,zrf=1,jcq=9,jc=4,bszg=5,sm-,mxg-,jzr-,gf-,qmh-,sgr=2,tlrqv-,jbnmxx=4,gcmq-,dzk-,gd-,htzlb=5,gncqzh=9,gd-,scl-,xh=9,hdk-,kqsk=1,sl-,slg=1,bptq=6,dqcn=6,ttv-,nqg=6,cvtn-,tmv=7,sgb-,qhm=6,ghttl=6,xb-,qtp-,tcrq=4,gssl-,gvzj=7,zq=8,hsf-,jj-,bjt=6,zfh=3,zzkbj-,rd-,vq-,gb=2,kd-,vjh=9,cvtn=8,rvjp-,hf-,xvs-,knbdx-,sfm-,stk-,mhxpj-,sbq=7,hhjz=7,qmx-,mr-,dsshxj-,jf-,gnf-,ffkfx=2,qp=8,lh=7,lpdqj-,zh-,nvv-,tvqj-,mp=9,tfz=5,mlj=7,nqg=1,zlnxqh=9,fj-,sfbn=3,mhxpj-,ttv-,zjxq-,lx-,cp=1,fp=9,tfh=9,rxj-,gm-,ddsh=2,dsj=5,qhk=2,xdfc-,mv-,vhzz-,fdjb=2,mr=2,ph-,zbfqfn=7,ddsh-,mtzc-,knb-,lh-,tclg=5,tn-,dbtm-,jpb=7,bl=9,gssl=8,sd-,fj-,cp-,fqz-,tk=8,jj=2,jrx-,nbb-,rmc-,tz-,vtqh-,xr-,ffkfx-,zbh-,sm-,dkr-,gld-,qdh=8,lx-,tq-,hc-,dxcx=7,rvt-,fqkpv-,dtsx=6,nqxvn=1,rvt-,tnhbsg=7,scl-,msm-,kj=1,kqsvsl-,fqkpv=4,mdlh-,hg=1,vk=9,bqj-,np-,rr=4,zcv-,ks=1,jvlff=5,gr=8,kfx-,gn=5,lh=1,xvs=9,sjvb-,tcrq-,gbq-,czfnq-,fr-,dqcn=2,tttb-,hlz-,zbfqfn-,hn-,knbdx-,szpztt=4,chcdl=2,cgq-,nqxvn=4,hhlst=4,zbl=1,jpb-,xhk-,qhm=9,jc=7,lxm=4,vvsj-,mlj=2,km=3,dqph-,mkb-,fhf=7,mkb=9,sm-,trn-,qdh-,jhzm=6,jhzm=2,vg=5,chcdl=5,tgn=1,ct-,zv=1,klgghs-,dlt-,hzd-,lt=5,lh-,vcfg-,ks-,kmh=8,bb-,vs-,kdf=3,dn-,rm=3,vqsp-,cgq-,fdh=8,mxqh-,lcrh-,szpztt-,tmv-,dnmrp-,sd=1,kqsk-,vtqh=2,dlt=4,kxl=9,mxg-,fdh=9,rk=9,mrd-,lqd=3,jnmz=1,gr-,ggv=9,gdn=4,bps-,bptq=1,trmg=5,rz=7,lg=1,qmh=2,gq=8,sfbn=9,jcq-,knbdx-,bs-,gs=7,xvs-,zbh=5,zcv=4,bctt-,vn-,xl-,jk=8,sbc=6,tk=3,gld-,rs=8,jdhhv=3,bx-,sd-,hxbb=1,ffkfx=6,knbdx=7,rfrb-,drhc=3,bqj=2,gxq-,tnvp-,ph=8,pjt-,bb-,msm-,gdj-,vj-,fdzxn-,lcxlk-,qv=1,lcxlk-,pls-,tnhbsg-,nbb-,tgn-,qdh=7,gssl-,lvg=1,dfq=5,rfrb-,klgghs-,fqkpv=7,zbknj-,fr=1,mdrjjr=7,vq=3,kmh=2,nlc=7,xc-,jfpqck=4,xzr-,kd=1,ssr=4,mdrjjr=9,fg-,sqk-,szxt-,mlg=1,pdb=6,vtr=4,kmh=9,fdh-,zbl=3,fg=1,scg-,svjl-,xc=7,tt-,qtp-,dq=8,gvzj=8,fls-,sndz=7,rxj=8,bsxk=1,tb-,kmh-,cx-,kthb-,mdrjjr-,xq-
""".trimIndent()

val part2TestInput = """
""".trimIndent()

val test2Input = """
""".trimIndent()

fun part1() {
    println(puzzleInput.split(',').sumOf { it.reindeerHash() })
}

fun part2(values: List<Long>) {
}

fun String.reindeerHash(): Int {
    var currentValue = 0

    for (char in this) {
        val ascii = char.code
        currentValue += ascii
        currentValue *= 17
        currentValue %= 256
    }

    return currentValue
}

fun dequeueOf() = ArrayDeque<Pair<String, Int>>()

fun main(args: Array<String>) {

//    println("HASH".reindeerHash())

    val startTime = System.currentTimeMillis()

    val map = mutableMapOf<Int, ArrayDeque<Pair<String, Int>>>()

    puzzleInput.split(',')
        .map {
            Regex("([a-z]+)([-|=])([0-9]*)")
                .findAll(it)
        }
        .forEach {
            for (match in it) {
                val label = match.groups[1]!!.value
                val operator = match.groups[2]!!.value
                val box = label.reindeerHash()

                if (operator == "=") {
                    val value = match.groups[3]!!.value.toInt()
                    // if there's already a lens in the box with the same label, replace the old
                    // lens with the new lens - remove the old, put the new in its place.
                    if (map.getOrDefault(box, dequeueOf()).any { it.first == label }) {
                        val newQ = dequeueOf()
                        map[box]!! .forEach {
                            if (it.first == label) {
                                newQ.add(Pair(label, value))
                            } else {
                                newQ.add(it)
                            }
                        }
                        map[box] = newQ
                    } else {
                        // if there is NOT already a lens with the same label, add the lens in queue
                        val list = map.getOrDefault(box, dequeueOf())
                        if (!list.any { it.first == label }) {
                            list.add(Pair(label, value))
                        }
                        map[box] = list
                    }

                } else {
                    //remove lens with given label if present in box
                    //Move any remaining lenses as far forward in the box as they can go
                        map.getOrDefault(box, dequeueOf()).removeIf { it.first == label }
                }
            }
        }

    var focalPower = 0L

    for ((key, value) in map.entries) {
        if (value.isEmpty()) continue

        focalPower += value.mapIndexed { index, pair -> (1L + key.toLong()) * (1 + index) * pair.second  }.sum()
        println("Box $key: [${value.joinToString(" ", "[", "]") }}]")
    }

    println("focal power is $focalPower")

    val endTime = System.currentTimeMillis()
    println("millis elapsed ${endTime - startTime}")
}
