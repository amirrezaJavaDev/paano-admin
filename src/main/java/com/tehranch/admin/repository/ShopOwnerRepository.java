package com.tehranch.admin.repository;

import com.tehranch.admin.model.ShopOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOwnerRepository extends JpaRepository<ShopOwner,Long> {
}
