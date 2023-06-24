package com.music.restful.musicList.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.restful.musicList.entity.MusicInfo;

@Repository
public interface MusicInfoRepository extends JpaRepository<MusicInfo, UUID> {


}
