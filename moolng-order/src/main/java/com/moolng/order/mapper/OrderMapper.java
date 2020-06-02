package com.moolng.order.mapper;

import com.moolng.order.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    void saveOrder();

    void initDB(@Param("userList") List<UserDTO> userDTOList);
}
