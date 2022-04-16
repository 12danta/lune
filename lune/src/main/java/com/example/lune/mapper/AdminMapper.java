package com.example.lune.mapper;

import com.example.lune.domain.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    //添加新 Admin
    Integer insert(Admin admin);
}
