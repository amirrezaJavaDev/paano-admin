package com.tehranch.admin.repository;

import com.tehranch.admin.model.ShopDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopDetailRepository extends JpaRepository<ShopDetail,Long> ,CustomShopDetailDao{

    Optional<ShopDetail> findByShopNameEnglish(String name);
}
