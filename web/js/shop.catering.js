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
			},
			addFoodDlgBtnEvt: function() {
				// 添加套餐,保存&下一步
				$("#btn_done").click(function() {
					var $this = $(this), 
						$prev = $("#btn_prev");
					if($this.hasClass("next")) { // next
						$this.html("保存").removeClass("next");
						$prev.removeClass("hide");

						switchStepView("step2");
						initEditImage();
					}
				});

				// 上一步
				$("#btn_prev").click(function() {
					var $next = $("#btn_done");
					$next.html("下一步").addClass("next");
					$(this).addClass("hide");

					switchStepView("step1");
				});
			}, 
			addFoodDlgChooseFoodEvt: function () {
				$(".food-grid .item-list img").click(function() {
					var $this = $(this), 
						$foodList = $("#food-list"), 
						oldId = $foodList.data("selected_id");
					if(oldId) {
						$("#"+oldId).removeClass("selected");
					}
					$this.addClass("selected");
					$foodList.data("selected_id", $this.attr("id"));
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

	/**
	 * switch to show which view.
	 */
	function switchStepView(step) {
		if(step === "step1") {
			$("#step2").addClass("hide");
			$("#step1").removeClass("hide");
			$("#dialog-add-package").removeClass("dialog-select-food");
		} else if (step === "step2") {
			$("#step1").addClass("hide");
			$("#step2").removeClass("hide");
			$("#dialog-add-package").addClass("dialog-select-food");
		} else {}
	}

	function initEditImage() {
		var selectedId = $("#food-list").data("selected_id");
		if(selectedId) {
			var $img = $("#"+selectedId);
			var url = $img.attr("src"), 
				name = $img.attr("alt");
			//$("#addfood-photo").attr("src", url).attr("alt", name);

		}
	}


	jQuery(function ($) {

		Init.run();

	});
	
	
});