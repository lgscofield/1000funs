define(function(require, exports, module) {
	
	var $ = require('jquery'), 
		util = require('util'), 
		webRoot = util.webRoot;
	require('bootstrap');
	

	var Init = (function($) {

		return {
			// main
			run: function() {
				for(var fn in Init) {
					if(fn === "run" || fn.startsWith('_')) continue;
					Init[fn].call(window);
				}
			}, 
			modal: function () {
				$(".food-add").click(function () {
					$("#dialog-add-food").modal();
				});
			}, 
			checkboxEvt: function () {
				$(".category :checkbox").change(function () {
					showOrHideTR($(this));
				});
			}
		};

	})(jQuery);

	/**
	 * show or hide TR, according to the checkbox state.
	 */
	function showOrHideTR($checkbox) {
		var $tr = $("#tr_" + $checkbox.attr("idx"));
		if($checkbox.is(":checked")) { // show
			$tr.removeClass("hide");
		} else {
			$tr.addClass("hide");
		}
	}


	jQuery(function ($) {

		Init.run();

		/*
		$(".addfood-photo-wrapper").hover(function () {
			$(this).siblings(".img-tips").removeClass("hide");
		}, function () {
			$(this).siblings(".img-tips").addClass("hide");
		})
		.click(function() {
			$(this).siblings("input[type='file']").click();
		});
		
		$("#save_group").click(function() {
			$("#groupForm").submit();
		});
		
		imagePreview($("#group-upload"), $("#group-preview"));
		 */
	});
	
	
});