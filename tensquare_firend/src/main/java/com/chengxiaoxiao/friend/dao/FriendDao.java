package com.chengxiaoxiao.friend.dao;

import com.chengxiaoxiao.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName: FriendDao
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-01-28
 */
public interface FriendDao extends JpaRepository<Friend, String> {

    @Query(value = "SELECT count(f) FROM tb_friend f where f.userid=? and f.friendid=?", nativeQuery = true)
    public int selectCount(String userid, String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend f set f.islike=?3 where f.userid=?1 and f.friendid=?2", nativeQuery = true)
    public void updateLike(String userid, String friendid, String islike);


}
