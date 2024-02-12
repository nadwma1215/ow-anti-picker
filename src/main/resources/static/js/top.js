/**
 * トップ画面用のJavaScript
 */
window.addEventListener('DOMContentLoaded', () => {
	
	const heroButtons = document.getElementsByClassName("hero");

	for (i = 0; i < heroButtons.length; i++) {
		heroButtons[i].addEventListener("click", function() {
			var activeButtons = document.getElementsByClassName("active");
			for (i = 0; i < activeButtons.length; i++) {
				activeButtons[i].classList.remove("active");
			}
			this.classList.add("active");
		});
	}
});