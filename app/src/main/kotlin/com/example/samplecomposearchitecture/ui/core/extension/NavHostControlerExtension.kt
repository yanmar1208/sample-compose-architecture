package com.example.samplecomposearchitecture.ui.core.extension

import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigator
import androidx.navigation.navOptions

fun NavHostController.navigateSafely(
    to: String,
    args: Bundle? = null,
    optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null,
    navigatorExtras: Navigator.Extras? = null,
) {
    // 同一画面への遷移 or NavHostが生成されていないとき(null)には遷移処理させない
    if (currentDestination?.route == to || currentDestination == null) return
    navigateWithArgs(
        to = to,
        args = args,
        optionsBuilder = optionsBuilder,
        navigatorExtras = navigatorExtras,
    )
}

/**
 * 引数にbundleを使えるようにした遷移関数
 *
 * デフォルトではbundleを引数として画面遷移することができないため、これを用意している
 */
private fun NavHostController.navigateWithArgs(
    to: String,
    args: Bundle? = null,
    optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null,
    navigatorExtras: Navigator.Extras? = null,
) {
    val routeLink = NavDeepLinkRequest.Builder.fromUri(
        NavDestination.createRoute(to).toUri()
    ).build()
    val deepLinkMatch = graph.matchDeepLink(routeLink)
    if (deepLinkMatch != null) {
        val destination = deepLinkMatch.destination
        val id = destination.id
        navigate(
            resId = id,
            args = args,
            navOptions = optionsBuilder?.let { navOptions(it) },
            navigatorExtras = navigatorExtras,
        )
    } else {
        navigate(
            route = to,
            navOptions = optionsBuilder?.let { navOptions(it) },
            navigatorExtras = navigatorExtras,
        )
    }
}