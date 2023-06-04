package com.tehranch.admin.repository;

import com.tehranch.admin.dto.ShopPageListDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.List;

public class CustomShopDetailDaoImpl implements CustomShopDetailDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tuple> findShop(ShopPageListDto search){
        String q = "select sd.panel_type panel, sd.shop_name_eng shopEng\n" +
                ", sd.shop_name_per shopPer , sd.image_govahi imgGovahi\n" +
                " from shop_detail sd join shop_owner so on sd.shop_owner_id = so.id\n" +
                " where (sd.is_deleted is null or sd.is_deleted is false)\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(search.getPanel()!=null)
        {
            queryBuilder.append("and sd.panel_type = :v_panel \n");
        }
        queryBuilder.append("order by sd.id asc limit :v_limit offset :v_offset");
        Query query = entityManager.createNativeQuery(queryBuilder.toString(),Tuple.class);
        if(search.getPanel()!=null)
        {
            query.setParameter("v_panel" , search.getPanel());
        }
        query.setParameter("v_limit" , search.getLimit());
        query.setParameter("v_offset" , search.getPage());
        List<Tuple> meetings = query.getResultList();
        return meetings;
    }
}
