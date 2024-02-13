/**
 * トップ画面用のJavaScript
 */
window.addEventListener('DOMContentLoaded', () => {

	// heroクラスが付与されたボタンを取得する。
	const heroButtons = document.getElementsByClassName("hero");

	// 各ボタンにクリック時のイベントを登録
	for (i = 0; i < heroButtons.length; i++) {
		heroButtons[i].addEventListener("click", function() {
			var activeButtons = document.getElementsByClassName("active");
			var antiPickLists = document.getElementsByClassName("anti-pick-list");
			var selectedHeroAntiPickList = document.getElementById(this.id + "-anti-pick-list");

			// 現在選択中の要素を未選択状態に変更
			for (i = 0; i < activeButtons.length; i++) {
				activeButtons[i].children[1].classList.add("display-none");
				activeButtons[i].classList.remove("active");
			}
			// hero-pickerの選択要素のクラスを操作
			this.classList.add("active");
			this.children[1].classList.remove("display-none");

			// anti-pick-listの表示の初期化
			for (i = 0; i < antiPickLists.length; i++) {
				antiPickLists[i].classList.add("display-none");
			}
			// 対応するanti-pick-listを表示
			selectedHeroAntiPickList.classList.remove("display-none");

		});
	}
});