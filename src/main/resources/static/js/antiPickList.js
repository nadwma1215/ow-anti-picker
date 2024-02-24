window.addEventListener('DOMContentLoaded', () => {

	const droparias = document.getElementsByClassName("droparia");
	const removearia = document.getElementById("removearia");
	const antiPickHeroIcons = document.getElementsByClassName("anti-pick-hero-icon-for-update");

	// ドラッグ中のイベント用function
	const onDragStartEvent = function(event) {
		// ドラッグ中のイベントのidをdataTransferにset
		event.dataTransfer.setData("Text", event.currentTarget.name);
	}

	// 各アンチピックアイコンにイベントを追加
	for (i = 0; i < antiPickHeroIcons.length; i++) {
		antiPickHeroIcons[i].ondragstart = onDragStartEvent;
	}

	// 各ドラッグエリアにイベントを追加
	for (i = 0; i < droparias.length; i++) {
		// ドロップを待機
		droparias[i].ondragover = (event) => {
			event.preventDefault();
			event.currentTarget.classList.add("opacity-50");
		}

		droparias[i].ondragleave = (event) => {
			event.preventDefault();
			event.currentTarget.classList.remove("opacity-50");
		}

		// ドロップ時のイベント
		droparias[i].ondrop = (event) => {
			event.preventDefault();
			event.currentTarget.classList.remove("opacity-50");

			// ドラッグしたイベントのname属性
			// ※後から追加されたイベントのname属性にはAbout~があるので、削除する
			var selectedHeroElmNameTmp = event.dataTransfer.getData("Text");
			var selectedHeroElmName = selectedHeroElmNameTmp.indexOf("About") != -1 ? selectedHeroElmNameTmp.substring(0, selectedHeroElmNameTmp.indexOf("About")) : selectedHeroElmNameTmp;

			// ドラッグしたイベントのid属性からhero_idを切り出す
			// ※後から追加されたイベントのname属性にはAbout~があるので、削除する
			var selectedHeroIdTmp = selectedHeroElmName.substring(selectedHeroElmName.lastIndexOf("-") + 1, selectedHeroElmName.length);
			var selectedHeroId = selectedHeroIdTmp.indexOf("About") != -1 ? selectedHeroIdTmp.substring(0, selectedHeroIdTmp.indexOf("About")) : selectedHeroIdTmp;

			// ドロップされたイベントのhero_id
			var dropHeroId = event.currentTarget.id.substring(event.currentTarget.id.lastIndexOf("-") + 1, event.currentTarget.id.length);
			// ドロップされたイベントのhero_idのinput要素を取得
			var formElements = document.querySelectorAll("input[name^='heroIdMap[" + dropHeroId + "]']");
			// formに今回のヒーローとアンチピックの組み合わせがまだ登録されていないかのチェック
			var added = false;

			// ドラッグしているヒーローとドロップしたエリアのヒーローが異なる場合にヒーローの追加処理
			if (selectedHeroId != dropHeroId) {
				// formに今回のヒーローとアンチピックの組み合わせがまだ登録されていないかのチェック
				for (i = 0; i < formElements.length; i++) {
					// 重複がある場合はフラグをtrueに変更
					if (formElements[i].value == selectedHeroId) {
						added = true;
					}
				}

				// 重複がなかった場合、ヒーローの追加処理
				if (!added) {
					// ドラッグしたイベントのname属性の文字列にAboutが含まれている場合、
					// アイコンを移動するために元のイベントを削除
					if (selectedHeroElmNameTmp.indexOf("About") != -1) {
						document.getElementsByName(selectedHeroElmNameTmp).forEach(element => {
							element.parentNode.remove();
						});
					}

					// ドラッグ中のヒーローアイコンを取得し、クローンする
					var antiPickHeroIcon = document.getElementById(selectedHeroElmName);
					var elm = antiPickHeroIcon.cloneNode(false);

					// 各属性を編集
					elm.removeAttribute("id");
					elm.setAttribute("name", elm.getAttribute("name") + "About" + dropHeroId);
					elm.ondragstart = onDragStartEvent;

					// formにhiddenの要素を追加するためにelementを作成する
					var tag = document.createElement("input");
					tag.setAttribute("type", "hidden");
					tag.setAttribute("name", "heroIdMap[" + dropHeroId + "][]");
					tag.setAttribute("value", selectedHeroId);
					
					// 上記のelementをまとめるdivタグを作成し、dropariaに追加
					var div = document.createElement("div");
					div.setAttribute("name","add-anti-pick");
					div.appendChild(tag);
					div.appendChild(elm);

					event.currentTarget.appendChild(div);
				} else {
					alert("既に存在する組み合わせです。");
				}
			} else {
				alert("登録するヒーローと登録されるヒーローが重複しています。");
			}
		}
	}

	removearia.ondragover = (event) => {
		event.preventDefault();
		event.currentTarget.classList.add("opacity-50");
	}

	removearia.ondragleave = (event) => {
		event.preventDefault();
		event.currentTarget.classList.remove("opacity-50");
	}

	removearia.ondrop = (event) => {
		event.preventDefault();
		event.currentTarget.classList.remove("opacity-50");
		var selectedHeroElmName = event.dataTransfer.getData("Text");

		if (selectedHeroElmName.indexOf("About") != -1) {
			document.getElementsByName(selectedHeroElmName).forEach(element => {
				element.parentNode.remove();
			});
		}
	}

});