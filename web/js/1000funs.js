/**
 * 
 */

/**
 * 获取url参数
 */
function getParam(url, name) {
	var re = new RegExp("(/?|&)"+ name +"=([^&]*)(&|$)", "i"), 
		m = url.match(re);
	if(m)
		return m[2];
	else 
		return null;
}

/**
 * 设置url参数
 */
function setParam(url, name, value) {
	var re = new RegExp("(/?|&)"+ name +"=([^&]*)(&|$)", "i"), 
		m = url.match(re);
	if(m) {
		return (url.replace(re, function($0, $1, $2) {
			return $0.replace($2, value);
		}));
	} else {
		if (url.indexOf('?') == -1)
			return (url + '?' + name + '=' + value);
		else
			return (url + '&' + name + '=' + value);
	}
}