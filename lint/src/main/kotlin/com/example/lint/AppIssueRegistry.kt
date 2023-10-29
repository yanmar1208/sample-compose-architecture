package com.example.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class AppIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(
            AppCodeDetector.ISSUE,
        )

    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = super.minApi

    override val vendor: Vendor
        get() = Vendor()
}