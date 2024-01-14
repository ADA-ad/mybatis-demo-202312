package com.ada.mybatisdemo202312.Mapper;

import com.ada.mybatisdemo202312.entity.Name;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM names")
    List<Name> findAll();

    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{prefix}, '%') AND name LIKE CONCAT('%', #{suffix}) AND " +
            "name LIKE CONCAT('%', #{contains}, '%')")
    List<Name> findByName(String prefix, String suffix, String contains);

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Name> findById(int id);
}
