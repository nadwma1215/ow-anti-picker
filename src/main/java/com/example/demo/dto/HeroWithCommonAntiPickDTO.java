package com.example.demo.dto;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.example.demo.entity.Hero;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * キャラクター Entity
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HeroWithCommonAntiPickDTO extends Hero {

	/**
	 * 紐づく共通アンチピックを取得
	 */
	private List<CommonAntiPickWithHeroDTO> commonAntiPickWithHeroDTOList;

	/**
	 * ヒーローリストの並び替え処理
	 * 
	 * ヒーローリストを①日本語、②アルファベットの順でソートする
	 * @param heroList
	 */
	public static void sort(List<HeroWithCommonAntiPickDTO> heroListWithAntiPick) {

		Collator collator = Collator.getInstance(Locale.JAPAN);
		collator.setStrength(Collator.SECONDARY);

		Comparator<Hero> comparator = (hero1, hero2) -> {
			// 英語と日本語の判別
			boolean isHero1Japanese = isJapanese(hero1.getName());
			boolean isHero2Japanese = isJapanese(hero2.getName());

			// 日本語が優先されるように比較
			if (isHero1Japanese && !isHero2Japanese) {
				return -1; // hero1を先に
			} else if (!isHero1Japanese && isHero2Japanese) {
				return 1; // hero2を先に
			} else {
				// どちらも日本語またはどちらも英語の場合はCollatorを使用して比較
				return collator.compare(hero1.getName(), hero2.getName());
			}
		};

		Collections.sort(heroListWithAntiPick, comparator);
	}

	/**
	 * 渡されたStringが日本語かどうかを判定する
	 * @param str
	 * @return
	 */
	private static boolean isJapanese(String str) {
		for (char c : str.toCharArray()) {
			if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HIRAGANA ||
					Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA ||
					Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
				return true;
			}
		}
		return false;
	}
}
