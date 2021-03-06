package com.wjw.complete5.service;

import com.wjw.complete5.admin.Entertainment;
import com.wjw.complete5.dao.IPublicDao;
import com.wjw.complete5.repository.EntertainmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Author:JiawangWang
 *
 * @Description:
 * @Date: Create in 20:04 2018/1/18
 */

@Service
public class EntertainmentService extends BaseService<Entertainment,EntertainmentRepository> {

    @Autowired
    public IPublicDao<Entertainment> iPublicDao;
    @Override
    public void updateTById(String id,@RequestBody Entertainment entertainment) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = Update.update("list",entertainment.getList());
        iPublicDao.updateTById(query,update,Entertainment.class);
    }
}
