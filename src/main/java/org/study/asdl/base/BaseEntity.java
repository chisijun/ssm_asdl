package org.study.asdl.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.study.asdl.model.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: chisj chisj@foxmal.com
 * @Date: 2019-05-15 19:37
 * @Description:
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 2393269568666085258L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 版本号
     */
    private Integer version;
    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 最近操作人
     */
    @Column(name = "last_operator")
    private String lastOperator;

    /**
     * 最后操作人ID
     */
    @Column(name = "last_operator_id")
    private Long lastOperatorId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Transient
    private Integer pageNum;

    @Transient
    private Integer pageSize;

    @Transient
    private String orderBy;

    /**
     * Is new boolean.
     *
     * @return the boolean
     */
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }

    /**
     * Sets update info.
     *
     * @param user the user
     */
    @Transient
    @JsonIgnore
    public void setUpdateInfo(User user) {

        if (isNew()) {
            this.creatorId = (this.lastOperatorId = user.getId());
            this.creator = user.getUserName();
            this.createdTime = (this.updateTime = new Date());
        }
        this.lastOperatorId = user.getId();
        this.lastOperator = user.getUserName() == null ? user.getLoginName() : user.getUserName();
        this.updateTime = new Date();
    }
}

