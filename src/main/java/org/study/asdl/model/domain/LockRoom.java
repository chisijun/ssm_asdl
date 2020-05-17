package org.study.asdl.model.domain;

import javax.persistence.*;

@Table(name = "t_lock_room")
public class LockRoom {
    @Id
    @Column(name = "lock_id")
    private Long lockId;

    @Id
    @Column(name = "room_id")
    private Long roomId;

    /**
     * @return lock_id
     */
    public Long getLockId() {
        return lockId;
    }

    /**
     * @param lockId
     */
    public void setLockId(Long lockId) {
        this.lockId = lockId;
    }

    /**
     * @return room_id
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}