
;(function ($) {
	
	/**
	 * Button Group
	 */
	var ButtonGroup = function (element) {
		this.$el = $(element);
		this._value0 = this.val(); //old value
	}

	ButtonGroup.prototype.val = function() {
		return $("button.active", this.$el).val();
	};

	ButtonGroup.prototype.click = function(callback) {
		var self = this;
		this.$el.click(function (e) { 
			setTimeout(function () {
				callback.call(self, e);
				self._value0 = self.val();
			}, 0);
		});
	};

	ButtonGroup.prototype.change = function(callback) {
		var self = this;
		this.click(function (e) {
			if(this.val() != this._value0) { //changed
				e.type="change";
				callback.call(self, e);
			}
		});
	};

	$.fn.buttonGroup = function () {
		return new ButtonGroup($(this));
	}



})(jQuery);