package com.tehranch.admin.repository;

import com.tehranch.admin.model.ShopOwnerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOwnerDetailRepository extends JpaRepository<ShopOwnerDetail,Long> {
}
