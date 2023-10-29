package com.example.lint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UThrowExpression

/**
 * コードに関するLintチェック
 */
class AppCodeDetector : Detector(), Detector.UastScanner {

    /**
     * 検査するUastTypeを列挙する
     */
    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(
            UThrowExpression::class.java,
        )
    }

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {
            override fun visitThrowExpression(node: UThrowExpression) {
                if (node.thrownExpression.asSourceString().startsWith("AppError").not()) {
                    context.report(
                        ISSUE,
                        node,
                        context.getNameLocation(node),
                        "アプリ内で例外を投げるときには、ErrorではなくAppErrorを使用すること",
                    )
                }
            }
        }
    }

    companion object {
        val ISSUE: Issue = Issue.create(
            id = AppCodeDetector::class.java.toString(),
            briefDescription = "サンプルプロジェクトのコードに関するLintチェック",
            explanation = "サンプルプロジェクトのコードに関するLintチェックを行う",
            category = Category.CUSTOM_LINT_CHECKS,
            severity = Severity.ERROR,
            implementation = Implementation(
                AppCodeDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}