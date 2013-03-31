define(function(require, exports, module) {
	
	var $ = require('jquery'), 
		util = require('util'), 
		webRoot = util.webRoot;
	require('bootstrap');
	require('bootstrap.extension');
	require('js/order-tablelist.js');
	
	jQuery(function ($) {
		init();
		initEvent();
	});

	function init() {
		// button group init
		var ot = $("#overtime").val();
		$(".btn-group > button[value='"+ot+"']").addClass("active");
		
		// init auto print state
		$.get(webRoot+"/shop/autoprint", function(checked) {
			if(checked) {
				$("#auto_checkbox").attr("checked", true);
			}
		});
	}

	function initEvent() {

		$(".btn-group").buttonGroup().change(function(e) {
			$("#overtime").val(this.val());
			$("#queryForm").submit();
		});
		
		//出单
		$(".order-btn-out").click(function() {
			orderOut($(this).attr("value"));
			return false;
		});
		
		//是否自动出单
		$("#auto_checkbox").change(function() {
			var state = $(this).is(":checked"), 
				url = webRoot + "/shop/autoprint/" + state;
			$.ajax({
				url: url, 
				type: "put"
			})
			.fail(function(xhr) { alert(xhr.responseText); }); //自动出单更新失败
		});
	}
	
	// 出单
	function orderOut(id) {
		var ret = updateOrders(id); // 更新状态
		if(ret) { // 打印订单
		}
	}
	
	// 更新订单状态
	function updateOrders(id) {
		$.ajax({
			type: "put", 
			url: webRoot+"/shop/order/"+id+"?status=1"
		})
		.done(function(data) {
			if(data == true) {
				$("#order_item_"+id).slideUp();
				return true;
			} else {
				alert("出单失败");
				return false;
			}
		});
	}
	
});