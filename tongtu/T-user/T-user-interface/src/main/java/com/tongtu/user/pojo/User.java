package com.tongtu.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_user")
@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private Long fansNumber;
    private Long team;
    private Long bushuNumber;
    private Long money;
    private Integer sex;            //性别，男为1女为0
    private String phone;
}
