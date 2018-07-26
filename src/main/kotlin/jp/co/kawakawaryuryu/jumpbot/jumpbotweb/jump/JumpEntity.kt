package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "jumps")
class JumpEntity(
        @Id
        @Column(name = "id")
        val id: Int,
        @Column(name = "release_day")
        val releaseDay: Date,
        @Column(name = "price")
        val price: Int,
        @Column(name = "combined_issue")
        val combinedIssue: Boolean
)