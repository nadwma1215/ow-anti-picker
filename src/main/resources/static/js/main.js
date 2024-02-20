/**
 * 共通Javascript
 */
window.addEventListener('DOMContentLoaded', () => {
	const flashMessages = document.getElementsByClassName("flash-message");

	for (i = 0; i < flashMessages.length; i++) {
		flashMessages[i].addEventListener("click", function(event) {
			event.currentTarget.remove();
		});
	}

});