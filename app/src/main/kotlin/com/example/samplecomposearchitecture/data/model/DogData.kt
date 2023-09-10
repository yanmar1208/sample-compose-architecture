package com.example.samplecomposearchitecture.data.model

import com.example.samplecomposearchitecture.domain.dog.model.Dog
import kotlinx.serialization.Serializable

/**
 * 犬のデータ
 *
 * @property message 画像URL
 * @property status 通信ステータス
 */
@Serializable
data class DogData(
    val message: String,
    val status: String,
)

/**
 * データモデルをドメインモデルに変換
 */
fun DogData.toDomainModel(): Dog = Dog(url = message)
