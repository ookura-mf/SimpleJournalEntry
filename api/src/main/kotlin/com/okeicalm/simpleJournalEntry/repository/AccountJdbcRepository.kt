package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Account
import com.okeicalm.simpleJournalEntry.tables.Accounts
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AccountJdbcRepository @Autowired constructor(private val dslContext: DSLContext) : AccountRepository {
    override fun findAll(): List<Account> {
        val result = dslContext.select()
            .from(Accounts.ACCOUNTS)
            .fetch()
            .into(com.okeicalm.simpleJournalEntry.tables.pojos.Accounts::class.java)

        return result.map { r -> Account(r) }
    }
}