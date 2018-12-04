package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "jumps")
class Jump(
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