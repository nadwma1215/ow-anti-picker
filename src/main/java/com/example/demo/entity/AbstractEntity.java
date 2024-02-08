package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;


/**
 * 共通 Entity
 * エンティティの共通項目の設定
 * エンティティクラスを実装する際には必ず継承する
 */
@Data
abstract class AbstractEntity {
	
	/**
	 * 作成日
	 * 登録時に更新
	 */
    private LocalDateTime created;
    
    /**
     * 更新日
     * 登録時、更新時に更新
     */
    private LocalDateTime modifired;

}