package org.study.asdl.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_role_user")
public class RoleUser {
    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "user_id")
    private Long userId;

}