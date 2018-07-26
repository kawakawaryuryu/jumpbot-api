package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JumpRepository : JpaRepository<JumpEntity, Int>