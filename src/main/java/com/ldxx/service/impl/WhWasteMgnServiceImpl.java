package com.ldxx.service.impl;

import com.ldxx.bean.ProductDispatch;
import com.ldxx.bean.User;
import com.ldxx.bean.WhWasteMgn;
import com.ldxx.dao.LaiLiaoWenDuYuJingDao;
import com.ldxx.dao.ProductDispatchDao;
import com.ldxx.dao.WhWasteMgnDao;
import com.ldxx.service.WhWasteMgnService;
import com.ldxx.util.GetThisTimeUtils;
import com.ldxx.util.LDXXUtils;
import com.ldxx.vo.ProductDispatchVo;
import com.ldxx.vo.WhWasteMgnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class WhWasteMgnServiceImpl implements WhWasteMgnService {

    @Autowired
    private WhWasteMgnDao dao;
    @Autowired
    private LaiLiaoWenDuYuJingDao laidao;
    @Autowired
    private ProductDispatchDao pddao;

    @Override
    public List<WhWasteMgnVo> getAllWhWasteMgn() {
        return dao.getAllWhWasteMgn();
    }

    @Override
    public int updwarningState(String id, int warningState,HttpSession session) {
        int i = dao.updwarningState(id,warningState);
        WhWasteMgn whWasteMgn = dao.getWhWasteMgnById(id);
        if(warningState==1 && i>0){
            //完全废弃
        }else if(warningState==2 && i>0){
            //调度,新增成品砼调度
            ProductDispatchVo pd=new ProductDispatchVo();
            pd.setId(LDXXUtils.getUUID12());
            pd.setBatchId(whWasteMgn.getBatchId());
            pd.setPlanId(whWasteMgn.getPlanId());
            pd.setDispatchTime(GetThisTimeUtils.getDateTime());
            pd.setEditDatetime(GetThisTimeUtils.getDateTime());
            User user = (User) session.getAttribute("user");
            if(null!=user) {
                pd.setEditUserId(user.getUserId());
                pd.setuName(user.getuName());
            }
            i=pddao.insertProductDispatch(pd);
        }else if(warningState==3 && i>0){
            //取消，修改来料温度预警状态为取消(0:未操作；1:已取消;2:以废料
            i=laidao.updWarningstateBybatchId(whWasteMgn.getBatchId(),1);
        }

        return i;
    }

    @Override
    public int insertWhWasteMgn(WhWasteMgn WhWasteMgn) {
        return dao.insertWhWasteMgn(WhWasteMgn);
    }
}
