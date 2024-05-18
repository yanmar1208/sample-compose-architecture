package com.example.samplecomposearchitecture.ui.core.extension

import androidx.compose.runtime.saveable.Saver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * [SavedStateHandle]から[MutableStateFlow]を生成する
 * [SavedStateHandle]に[MutableStateFlow]の値が保持され、プロセスキルなどの先同時にも値が保持される
 * [SavedStateHandle]のkeyには、property名が使用される
 *
 * @param T [T]
 * @param init 初期値。[SavedStateHandle]に値が存在しない場合は[init]で指定した値を使用する。
 */
@OptIn(SavedStateHandleSaveableApi::class)
fun <T : Any> SavedStateHandle.saveableFlow(
    init: T
): PropertyDelegateProvider<Any?, ReadOnlyProperty<Any?, MutableStateFlow<T>>> = saveable(
    saver = Saver(
        save = { it.value },
        restore = { MutableStateFlow(it) }
    ),
    init = { MutableStateFlow(init) }
)
