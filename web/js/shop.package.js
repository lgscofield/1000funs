define(function(require, exports, module) {
	
	var $ = require('jquery'), 
		util = require('util'), 
		webRoot = util.webRoot;
	require('bootstrap');
	require('bootstrap.extension');

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
				$(".foods-area .food-add").click(function () {
					$("#dialog-add-package").modal();
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
						// validate
						if($.validation().check()) {
							$this.html("保存").removeClass("next");
							$prev.removeClass("hide");

							switchStepView("step2");
						}
					}
					// submit
					else {
						// set itemIds value
						setItemIds();
						$("#packageForm").submit();
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
			validate: function() {
				$.validation().init();
				$("#packageForm").submit(function () {
					if(!$.validation().check()) return false;
				});
			}, 
			formBind: function() {
				$("#droped").change(function() {
					$("#_droped").val(this.checked);
				});
			}, 
			// image wrapper hover & click event
			imgUploadEvent: function() {
				$(".addfood-photo-wrapper").hover(function () {
					$(this).siblings(".img-tips").removeClass("hide");
				}, function () {
					$(this).siblings(".img-tips").addClass("hide");
				})
				.click(function() {
					$(this).siblings("input[type='file']").click();
				});
			}, 
			imagePreview: function() {
				util.imagePreview($("#file-upload"), $("#image-preview"));
			}, 
			selectFoodEvt: function() {
				
				$(".food-select").change(function() {
					var $this = $(this),
						$img = $this.prev("img"), 
						foodId = $this.attr("foodId"), 
						src = $img.attr("src"), 
						foodName = $img.attr("alt"), 
						checked = $this.is(":checked");

					// console.log("foodId: " + foodId + "; src: "+ src + "; checked: " + checked);
					if(checked) {
						addSelecedFood(foodId, src, foodName);
					} else {
						removeSelectedFood(foodId);
					}
				});
			}
		};

	})(jQuery);

	// template
	var tempSelectedFood = '<li id="selected_item_${foodId}"><img src="${src}" alt="${foodName}"></li>';

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

	function switchStepView(step) {
		if(step === "step1") {
			$("#step2").addClass("hide");
			$("#step1").removeClass("hide");
			$("#dialog-add-package").removeClass("dialog-select-food");
			$("#modal-footer-food-select").addClass("hide");
			$("#packageForm").addClass("form-dialog");
		} else if (step === "step2") {
			$("#step1").addClass("hide");
			$("#step2").removeClass("hide");
			$("#dialog-add-package").addClass("dialog-select-food");
			$("#modal-footer-food-select").removeClass("hide");
			$("#packageForm").removeClass("form-dialog");
		} else {}
	}

	function addSelecedFood(foodId, src, foodName) {
		var html = tempSelectedFood
						.replace("${foodId}", foodId)
						.replace("${src}", src)
						.replace("${foodName}", foodName);
		$("#selected-foods").append(html);
		adjustSelectedFoodSize();
	}

	function removeSelectedFood(foodId) {
		$("#selected_item_"+foodId).remove();
		adjustSelectedFoodSize();
	}

	function adjustSelectedFoodSize() {
		var $foodToAdd = $("#food-to-add"), 
			$selectedFoods = $("#selected-foods"), 
			width = $selectedFoods.children("li").length * 95 + 15, 
			overflow = width > 448;

		if(overflow) {
			$selectedFoods.width(width);
			$foodToAdd.addClass("overflow");
		}
		else {
			$selectedFoods.width(448);
			$foodToAdd.removeClass("overflow");
		}
	}

	function setItemIds() {
		var id, ids = "";
		$("#selected-foods > li").each(function() {
			id = $(this).attr("id").substring(14);
			ids += (id + ",");
		});
		$("#itemIds").val(ids);
	}


	jQuery(function ($) {
		Init.run();
	});

});